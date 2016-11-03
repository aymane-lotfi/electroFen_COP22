package com.mygdx.components;

import com.badlogic.gdx.Gdx;
import com.mygdx.game.ElectroFunCop22;
import com.mygdx.scene.Actor;
import org.simpleframework.xml.ElementList;
import org.simpleframework.xml.Root;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by itachi on 02/11/16.
 */
@Root
public class AnimationComponent extends Component
{
    @ElementList(name="Animations")
    private List<Animation> mAnimations = new ArrayList<Animation>();

    private Animation mCurrentAnimation = null;

    public AnimationComponent()
    {
        mName = "AnimationComponent";
        mIsDrawable = true;
    }

    public void addAnimation(Animation pAnim)
    {
        mAnimations.add(pAnim);
    }

    public void load()
    {
        for(Animation anim : mAnimations)
        {
            anim.setActor(mActor);
            anim.load();
        }
        mCurrentAnimation = mAnimations.get(0);
    }

    public void update()
    {

    }

    public void draw()
    {
        if(mCurrentAnimation != null)
        {
            mCurrentAnimation.play();
        }
        else
        {
            Gdx.app.error(ElectroFunCop22.APP_TAG, "[AnimationComponent - draw()] current animation is null");
        }
    }

    public void destroy()
    {
        for(Animation anim : mAnimations)
        {
            anim.destroy();
        }
    }
}
