package com.mygdx.events;

import com.badlogic.gdx.Gdx;
import com.mygdx.config.Config;
import com.mygdx.game.ElectroFunCop22;
import com.mygdx.scene.Scene;
import com.sun.xml.internal.bind.v2.model.core.EnumLeafInfo;
import org.simpleframework.xml.Serializer;
import org.simpleframework.xml.core.Persister;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by itachi on 05/11/16.
 */
public class EventManager
{
    //Singleton setup
    public static EventManager Instance = null;

    public static void create()
    {
        if(Instance == null)
        {
            Instance = new EventManager();
        }
    }

    private EventManager()
    {

    }
    //

    private List<Event> mEvents = new ArrayList<Event>();

    public Event loadEvent(String pFilePath)
    {
        Serializer _serializer = new Persister();
        File _eventFile = new File(pFilePath);
        Event _event = null;

        try
        {
            _event = _serializer.read(Event.class, _eventFile);
        }
        catch(Exception e)
        {
            Gdx.app.error(ElectroFunCop22.APP_TAG, "[EventManager - loadEvent()] error : "+e.toString());
        }
        finally
        {
            return _event;
        }
    }

    public void load() {
        //Load all events from configuration file
        for (String eventPath : Config.EVENTS_LIST) {
            Event _newEvent = loadEvent(eventPath);
            if (_newEvent != null) {
                mEvents.add(_newEvent);
            } else {
                Gdx.app.error(ElectroFunCop22.APP_TAG, "[EventManager - load()] loaded Event is null!");
            }
        }
        //
    }
    public void executeEvent(String pEventName)
    {
        for(Event event : mEvents)
        {
            if(event.getName().equals(pEventName))
            {
                event.execute();
                return;
            }
        }

        Gdx.app.error(ElectroFunCop22.APP_TAG, "[EventManager - executeEvent()] event \""+pEventName+"\" doesn't exist");
    }
}
