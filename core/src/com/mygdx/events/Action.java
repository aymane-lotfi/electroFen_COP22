package com.mygdx.events;

import org.simpleframework.xml.Attribute;
import org.simpleframework.xml.Root;

/**
 * Created by itachi on 05/11/16.
 */
@Root
public class Action
{
    @Attribute(name="Action")
    protected String mActionName = "";

    @Attribute(name="Actor", required = false)
    protected String mActorName = "";

    @Attribute(name="Animation", required = false)
    protected String mAnimationName = "";

    public Action()
    {

    }

    public void execute()
    {

    }
}
