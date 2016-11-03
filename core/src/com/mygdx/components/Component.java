package com.mygdx.components;

import com.mygdx.scene.Actor;
import org.simpleframework.xml.Attribute;
import org.simpleframework.xml.Root;

/**
 * Created by itachi on 02/11/16.
 */
@Root
public class Component
{
    @Attribute(name="Name")
    protected  String mName = "";

    @Attribute(name="isDrawable")
    protected boolean mIsDrawable;

    protected Actor mActor = null;

    public void setActor(Actor pActor)
    {
        mActor = pActor;
    }

    public Component()
    {

    }

    public boolean isDrawable()
    {
        return mIsDrawable;
    }

    public void load()
    {

    }

    public void update()
    {

    }

    public void draw()
    {

    }

    public void destroy()
    {

    }
}
