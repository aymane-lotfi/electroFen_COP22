package com.mygdx.scene;


import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;

public class Actor
{
    private boolean mHasUVTexture = false;
    private boolean mAlreadyLoaded = false;
    private String mTexturePath = null;
    private Texture mSprite = null;
    private Vector2 mPosition = null;
    private Vector2 mScale = new Vector2(64, 64);
    //private Rectangle mRect = new Rectangle();
    private Scene mParent = null;

    public Actor(String pTexturePath, boolean pHasUVTexture)
    {
        mTexturePath = pTexturePath;
        mHasUVTexture = pHasUVTexture;
    }

    public Actor(String pTexturePath, boolean pHasUVTexture, Vector2 pPos)
    {
        mTexturePath = pTexturePath;
        mHasUVTexture = pHasUVTexture;

        //Position
        mPosition = pPos;
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
