package com.mygdx.config;

import java.util.Arrays;
import java.util.List;

/**
 * Created by itachi on 02/11/16.
 */
public class Config
{
    public static boolean enableEditor = true;

    public static String SCENES_PATH = "scenes";

    public static String DEFAULT_SCENE = "Eau"; //The Scene's name

    public static List<String> SCENES_LIST = Arrays.asList(
            SCENES_PATH+"/Eau.xml",
            SCENES_PATH+"/Feu.xml"
    );

}
