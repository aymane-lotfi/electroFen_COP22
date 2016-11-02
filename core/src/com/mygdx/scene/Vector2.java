package com.mygdx.scene;

import org.simpleframework.xml.Attribute;
import org.simpleframework.xml.Root;

/**
 * Created by itachi on 02/11/16.
 */

@Root
public class Vector2
{
    @Attribute(name="x")
    public float x;

    @Attribute(name="y")
    public float y;

    public Vector2()
    {
        x = 0;
        y = 0;
    }

    public Vector2(float pX, float pY)
    {
        x = pX;
        y = pY;
    }
}
