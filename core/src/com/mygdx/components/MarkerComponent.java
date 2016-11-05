package com.mygdx.components;

import com.badlogic.gdx.Gdx;
import com.mygdx.game.ElectroFunCop22;
import com.mygdx.scene.Actor;
import com.mygdx.scene.Vector2;
import org.simpleframework.xml.Attribute;

/**
 * Created by itachi on 05/11/16.
 */
public class MarkerComponent extends Component
{
    @Attribute(name="Number")
    private int mNumber;

    private Actor mMarkedActor = null;

    public Actor getMarkedActor()
    {
        return mMarkedActor;
    }

    public void markActor(Actor pActor)
    {
        mMarkedActor = pActor;
    }

    public Vector2 getPos()
    {
        if(mActor != null)
        {
            return mActor.getPos();
        }

        Gdx.app.error(ElectroFunCop22.APP_TAG, "[MarkerComponent - getPos()] the parrent actor is null");
        return null;
    }


    public int getNumber()
    {
        return mNumber;
    }


    public MarkerComponent()
    {
        mName = "MarkerComponent";
        mIsDrawable = false;
    }
}
