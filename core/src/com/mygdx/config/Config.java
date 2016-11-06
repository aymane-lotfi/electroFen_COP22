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
    public static String EVENTS_PATH = "data/events";

    public static String DEFAULT_SCENE = "Terre";//"Eau"; //The Scene's name

    public static List<String> SCENES_LIST = Arrays.asList(
            SCENES_PATH+"/Terre.xml",
            SCENES_PATH+"/Eau.xml"
    );

    public static List<String> EVENTS_LIST = Arrays.asList(
            //EVENTS_PATH+"/eau/cleaning_clothes.xml", //test
            //EVENTS_PATH+"/eau/cleaning_girl.xml", //test
            EVENTS_PATH+"/eau/add_bano.xml",
            EVENTS_PATH+"/eau/add_lavabo.xml"
    );

}
