package com.mygdx.scene;

import com.badlogic.gdx.Gdx;
//import com.badlogic.gdx.math.Vector2;
import com.mygdx.components.Component;
import com.mygdx.components.MarkerComponent;
import com.mygdx.config.Config;
import com.mygdx.events.Event;
import com.mygdx.events.EventManager;
import com.mygdx.game.ElectroFunCop22;
import org.simpleframework.xml.*;
import org.simpleframework.xml.core.Persister;

import java.io.File;
import java.util.*;

@Root
public class Scene
{
    @Attribute(name="name")
    private String mName = null;

    @ElementList(name="Actors")
    private List<Actor> mActors = new ArrayList<Actor>();

    int mTimeWaitToExecEvent = 1000;
    boolean mJustChanged = false;
    private List<String> mEvents = new ArrayList<String>();

    public void addEvent(String pEvent)
    {
        mEvents.add(pEvent);
    }

    void justChanged()
    {
        mJustChanged = true;
    }

    public Scene(String pName)
    {
        mName = pName;
    }

    public Scene()
    {
        super();
    }

    public void addActor(Actor pActor)
    {
        pActor.setParent(this);
        mActors.add(pActor);
    }

    public String getName()
    {
        return mName;
    }


    public Actor getActorAt(Vector2 pPosition)
    {
        for(Actor actor : mActors)
        {
            if(actor.selected(pPosition))
            {
                return actor;
            }
        }

        return null;
    }

    public MarkerComponent getMarker(int pNumber)
    {
        for(Actor actor : mActors)
        {
            MarkerComponent _comp = (MarkerComponent)actor.getComponent("MarkerComponent");
            if(_comp != null && _comp.getNumber() == pNumber)
            {
                return _comp;
            }
        }

        return null;
    }

    public Actor getActorByName(String pName)
    {
        for(Actor actor : mActors)
        {
            if(actor.getName().equals(pName))
            {
                return actor;
            }
        }

        return null;
    }

    public Actor getActorAt(Vector2 pPosition, int pLayer)
    {
        for(Actor actor : mActors)
        {
            if(actor.getLayer() == pLayer && actor.selected(pPosition))
            {
                return actor;
            }
        }

        return null;
    }

    public void save()
    {
        Serializer _serializer = new Persister();
        String _sceneFilePath = Config.SCENES_PATH+"/"+mName+".xml";

        File _sceneFile = new File(_sceneFilePath);

        try {
            _serializer.write(this, _sceneFile);
        }
        catch(Exception e)
        {
            Gdx.app.error(ElectroFunCop22.APP_TAG, "[Scene - save()] error : "+e.toString());
        }
    }

    public void load()
    {
        for(Actor actor : mActors)
        {
            actor.load();
        }
    }

    public void update()
    {
        if(mJustChanged)
        {
            try {
                Thread.sleep(mTimeWaitToExecEvent);
                for(String event : mEvents)
                {
                    EventManager.Instance.executeEvent(event);
                }
                mJustChanged = false;
            }
            catch(Exception e)
            {
                Gdx.app.error(ElectroFunCop22.APP_TAG, "[Scene - Update()] error :"+e.toString());
            }
        }

        for(Actor actor : mActors)
        {
            actor.update();
        }
    }

    public void draw()
    {
        for(Actor actor : mActors)
        {
            actor.draw();
        }
    }

    public void destroy()
    {
        for(Actor actor : mActors)
        {
            actor.destroy();
        }
    }
}
