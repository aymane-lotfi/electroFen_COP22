package com.mygdx.events;

import com.badlogic.gdx.Gdx;
import com.mygdx.game.ElectroFunCop22;
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
        Gdx.app.log(ElectroFunCop22.APP_TAG, "[Event - execute()] execute event : "+mName);
        for(Action action : mActions)
        {
            action.execute();
        }
    }
}
