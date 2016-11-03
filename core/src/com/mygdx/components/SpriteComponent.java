package com.mygdx.components;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.mygdx.game.ElectroFunCop22;
import com.mygdx.scene.SceneManager;
import com.mygdx.scene.Vector2;
import org.simpleframework.xml.Attribute;
import org.simpleframework.xml.Element;

/**
 * Created by itachi on 03/11/16.
 */
public class SpriteComponent extends Component
{
    @Attribute(name="SpritePath")
    private String mTexturePath = null;

    private Texture mSprite = null;

    public SpriteComponent()
    {
        mName = "SpriteComponent";
        mIsDrawable = true;
    }

    public void load()
    {
        mSprite = new Texture(Gdx.files.internal(mTexturePath));
    }

    public  void update()
    {

    }

    public  void draw()
    {
        if(mActor != null && mActor.getPos() != null)
        {
            Batch _spriteBatch = SceneManager.Instance.getSpriteBatch();
            if(_spriteBatch != null && mSprite != null)
            {
                _spriteBatch.draw(mSprite, mActor.getPos().x, mActor.getPos().y, mActor.getScale().x, mActor.getScale().y);
            }
            else
            {
                Gdx.app.error(ElectroFunCop22.APP_TAG, "[Actor - draw()] Sprite or SpriteBatch is null");
            }
        }
    }

    public void destroy()
    {
        if(mSprite != null)
        {
            mSprite.dispose();
        }
    }
}
