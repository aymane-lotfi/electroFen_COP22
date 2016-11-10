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

    public static String DEFAULT_SCENE = "Terre-1";//;//"Terre";//"Eau"; //The Scene's name

    public static List<String> SCENES_LIST = Arrays.asList(
            SCENES_PATH+"/Eau.xml", //Salle de bain
            SCENES_PATH+"/Air-1.xml", //salon
            SCENES_PATH+"/Air-2.xml", //jardin
            SCENES_PATH+"/Terre-1.xml", //cuisine
            SCENES_PATH+"/Terre-2.xml" //potagé
    );

    public static List<String> EVENTS_LIST = Arrays.asList(
            //Eau : Salle de bain
            EVENTS_PATH+"/eau/bano_coule.xml",
            EVENTS_PATH+"/eau/lavabo_coule.xml",
            EVENTS_PATH+"/eau/placard_propre_0.xml",
            EVENTS_PATH+"/eau/placard_propre_1.xml",
            EVENTS_PATH+"/eau/serviettes_propres_0.xml",
            EVENTS_PATH+"/eau/serviettes_propres_1.xml",
            EVENTS_PATH+"/eau/girl_clean_0.xml",
            EVENTS_PATH+"/eau/girl_clean_1.xml",
            EVENTS_PATH+"/eau/girl_clothes_clean_0.xml",
            EVENTS_PATH+"/eau/girl_clothes_clean_1.xml",
            EVENTS_PATH+"/eau/window_rain.xml",
            EVENTS_PATH+"/eau/window_tree1_appears.xml",
            EVENTS_PATH+"/eau/window_tree2_appears.xml",
            EVENTS_PATH+"/eau/flower_blossoms.xml",

            //Air-1 : Salon
            EVENTS_PATH+"/air-1/window_tree1_appears.xml",
            EVENTS_PATH+"/air-1/window_tree2_appears.xml",
            EVENTS_PATH+"/air-1/cloud_decrease_50.xml",
            EVENTS_PATH+"/air-1/cloud_decrease_100.xml",
            EVENTS_PATH+"/air-1/flowers_blossom.xml",
            EVENTS_PATH+"/air-1/girl_thanking.xml",

            //Air-2 : Jardin
            EVENTS_PATH+"/air-2/add_tree_0.xml",
            EVENTS_PATH+"/air-2/add_tree_1.xml",
            EVENTS_PATH+"/air-2/add_tree_2.xml",

            //Terre-1 : Cuisine
            EVENTS_PATH+"/terre-1/window_tree1.xml",
            EVENTS_PATH+"/terre-1/window_tree2.xml",
            EVENTS_PATH+"/terre-1/window_tree3.xml",
            EVENTS_PATH+"/terre-1/flower_blossoms.xml",
            EVENTS_PATH+"/terre-1/tasse_tizane.xml",

            //Terre-2 : Potagé
            EVENTS_PATH+"/terre-2/plant_plant1.xml",
            EVENTS_PATH+"/terre-2/plant_plant2.xml",
            EVENTS_PATH+"/terre-2/plant_plant3.xml",
            EVENTS_PATH+"/terre-2/plant_plant4.xml",
            EVENTS_PATH+"/terre-2/plant_plant5.xml"
    );

}
