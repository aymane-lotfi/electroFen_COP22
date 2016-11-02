package com.mygdx.scene;


import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.math.Rectangle;
//import com.badlogic.gdx.math.Vector2;
import org.simpleframework.xml.Attribute;
import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;

@Root
public class Actor
{
    @Attribute(name="HasUVTextrue")
    private boolean mHasUVTexture = false;

    private boolean mAlreadyLoaded = false;

    @Attribute(name="SpritePath")
    private String mTexturePath = null;

    private Texture mSprite = null;

    @Element(name="Position")
    private Vector2 mPosition = null;

    @Element(name="Scale")
    private Vector2 mScale = new Vector2(64, 64);

    private Scene mParent = null;

    public Actor()
    {
        super();
    }


    public Actor(boolean pHasUVTexture, String pTexturePath, Vector2 pPos, Vector2 pScale)
    {
        mTexturePath = pTexturePath;
        mHasUVTexture = pHasUVTexture;

        //Position
        mPosition = pPos;

        //Scale
        mScale = pScale;
    }

    public Actor(String pTexturePath, boolean pHasUVTexture, Vector2 pPos, Scene pParent)
    {
        mParent = pParent;

        mTexturePath = pTexturePath;
        mHasUVTexture = pHasUVTexture;

        //Position
        mPosition = pPos;
    }

    public void setParent(Scene pScene)
    {
        mParent = pScene;
    }

    public Scene getParent()
    {
        return mParent;
    }

    public boolean alreadyLoaded()
    {
        return mAlreadyLoaded;
    }

    public Vector2 getPos()
    {
        return mPosition;
    }

    public void setPos(Vector2 pPos)
    {
        mPosition = pPos;
    }

    public boolean selected(Vector2 pPos)
    {
        Rectangle _rect = new Rectangle(mPosition.x, mPosition.y, mScale.x, mScale.y);
        return _rect.contains(pPos.x, pPos.y);
    }

    public Vector2 getScale()
    {
        return mScale;
    }

    public void setScale(Vector2 pScale)
    {
        mScale = pScale;
    }

    public void load()
    {
        if(!mHasUVTexture)
        {
            mSprite = new Texture(Gdx.files.internal(mTexturePath));
        }
        else
        {
            //TODO
        }

        mAlreadyLoaded = true;
    }

    public void update()
    {

    }

    public void draw()
    {
        if(mPosition != null)
        {
            Batch _spriteBatch = SceneManager.Instance.getSpriteBatch();
            if(_spriteBatch != null)
            {
                _spriteBatch.draw(mSprite, mPosition.x, mPosition.y, mScale.x, mScale.y);
            }
        }
    }

    public void destroy()
    {
        mSprite.dispose();
    }
}
