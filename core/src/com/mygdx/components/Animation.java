package com.mygdx.components;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.mygdx.game.ElectroFunCop22;
import com.mygdx.scene.Actor;
import com.mygdx.scene.SceneManager;
import org.simpleframework.xml.Attribute;
import org.simpleframework.xml.Root;

/**
 * Created by itachi on 02/11/16.
 */

@Root
public class Animation
{
    @Attribute(name="Name")
    public String mName = "";

    public TextureRegion[] mAnimationFrames = null;
    public TextureRegion mCurrentFrame = null;
    public com.badlogic.gdx.graphics.g2d.Animation mAnimation = null;


    @Attribute(name="AnimationSheet")
    public String mAnimationSheetPath = "";

    @Attribute(name="FramesCount")
    public int mFramesCount = 0;

    @Attribute(name="Speed")
    public float mTime = 0;

    public Actor mActor = null;

    public void setActor(Actor pActor)
    {
        mActor = pActor;
    }

    public Animation()
    {

    }

    public Animation(String pName, String pAnimathionSheetPath, int pFramesCount, float pSpeed)
    {
        mName = pName;
        mAnimationSheetPath = pAnimathionSheetPath;
        mFramesCount = pFramesCount;
        mTime = pSpeed;
    }

    public void load()
    {
        Texture _animationSheet = new Texture(Gdx.files.internal(mAnimationSheetPath));
        if(_animationSheet == null)
        {
            Gdx.app.error(ElectroFunCop22.APP_TAG, "[Animation - load()] failed to load "+mName+" animation");
        }
        else
        {
            mAnimationFrames = new TextureRegion[mFramesCount];
            TextureRegion[][] _tmp = TextureRegion.split(_animationSheet, _animationSheet.getWidth()/mFramesCount, _animationSheet.getHeight());

            for(int i=0; i<mFramesCount;i++)
            {
                mAnimationFrames[i] = _tmp[0][i];
            }

            mAnimation = new com.badlogic.gdx.graphics.g2d.Animation(mTime, mAnimationFrames);
        }
    }

    public void play()
    {
        mTime += Gdx.graphics.getDeltaTime();
        mCurrentFrame = mAnimation.getKeyFrame(mTime, true);

        if(mActor != null)
        {
            SceneManager.Instance.getSpriteBatch().draw(mCurrentFrame, mActor.getPos().x, mActor.getPos().y);
        }
        else
        {
            Gdx.app.error(ElectroFunCop22.APP_TAG, "[Animation - play()] failed to play "+mName+" animation actor is null");
        }
    }

    public void destroy()
    {
    }
}
