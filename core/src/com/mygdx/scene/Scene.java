package com.mygdx.scene;

import com.badlogic.gdx.Gdx;
//import com.badlogic.gdx.math.Vector2;
import com.mygdx.config.Config;
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
