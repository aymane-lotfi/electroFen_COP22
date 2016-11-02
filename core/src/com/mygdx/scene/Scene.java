package com.mygdx.scene;

import com.badlogic.gdx.math.Vector2;

import java.util.*;

public class Scene
{
    private String mName = null;
    private List<Actor> mActors = new ArrayList<Actor>();


    public Scene(String pName)
    {
        mName = pName;
    }

    public void addActor(Actor pActor)
    {
        pActor.setParent(this);
        mActors.add(pActor);
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
