package com.mygdx.events;

import org.simpleframework.xml.Attribute;
import org.simpleframework.xml.ElementList;
import org.simpleframework.xml.Root;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by itachi on 05/11/16.
 */
@Root
public class Event
{
    @Attribute(name="Name")
    private String mName = "";

    @Attribute(name="Scene")
    private String mSceneName = "";

    @ElementList(name="Actions")
    private List<Action> mActions = new ArrayList<Action>();

    public String getName() { return mName; }

    public Event()
    {

    }

    public void execute()
    {
        for(Action action : mActions)
        {
            action.execute();
            /*
            try {
                Thread.sleep(4000);
            }
            catch(Exception e)
            {

            }
            */
        }
    }
}
