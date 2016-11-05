package com.mygdx.scene;


import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Rectangle;
import com.mygdx.components.Component;
import org.simpleframework.xml.Attribute;
import org.simpleframework.xml.Element;
import org.simpleframework.xml.ElementList;
import org.simpleframework.xml.Root;

import java.util.ArrayList;
import java.util.List;

@Root
public class Actor
{
    @Attribute(name="Name")
    private String mName = "";

    @Attribute(name="Layer")
    private int mLayer;

    @Element(name="Position")
    private Vector2 mPosition = null;

    @Element(name="Scale")
    private Vector2 mScale = new Vector2(64, 64);

    @ElementList(name="Components", required=false)
    private List<Component> mComponents = new ArrayList<Component>();

    private Scene mParent = null;

    public Actor()
    {
        super();
        mPosition = new Vector2(0,0);
    }


    public Actor(boolean pHasUVTexture, String pTexturePath, Vector2 pPos, Vector2 pScale)
    {

        //Position
        mPosition = pPos;

        //Scale
        mScale = pScale;
    }

    public Actor(String pTexturePath, boolean pHasUVTexture, Vector2 pPos, Scene pParent)
    {
        mParent = pParent;


        //Position
        mPosition = pPos;
    }

    public String getName()
    {
        return mName;
    }


    public int getLayer()
    {
        return mLayer;
    }

    public void addComponent(Component pComp)
    {
        mComponents.add(pComp);
    }

    public void setParent(Scene pScene)
    {
        mParent = pScene;
    }

    public Scene getParent()
    {
        return mParent;
    }

    public Vector2 getPos()
    {
        return mPosition;
    }

    public void setPos(Vector2 pPos)
    {
        mPosition = pPos;
    }

    public boolean selected(Vector2 pPos)
    {
        Rectangle _rect = new Rectangle(mPosition.x, mPosition.y, mScale.x, mScale.y);
        return _rect.contains(pPos.x, pPos.y);
    }

    public Vector2 getScale()
    {
        return mScale;
    }

    public void setScale(Vector2 pScale)
    {
        mScale = pScale;
    }

    public Component getComponent(String pCompName)
    {
        for(Component comp : mComponents)
        {
            if(comp.getName().equals(pCompName))
            {
                return comp;
            }
        }

        return null;
    }

    public void load()
    {
        for(Component comp : mComponents)
        {
            comp.setActor(this);
            comp.load();
        }
    }

    public void update()
    {
        for(Component comp : mComponents)
        {
            comp.update();
        }
    }

    public void draw()
    {
        for(Component comp : mComponents)
        {
            if(comp.isDrawable())
            {
                comp.draw();
            }
        }
    }

    public void destroy()
    {
        for(Component comp : mComponents)
        {
            comp.destroy();
        }
    }
}
