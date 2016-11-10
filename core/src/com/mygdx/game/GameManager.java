package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.mygdx.events.EventManager;
import com.mygdx.input.InputData;
import com.mygdx.input.InputListener;
import com.mygdx.scene.Scene;
import com.mygdx.scene.SceneManager;

/**
 * Created by itachi on 06/11/16.
 */
public class GameManager implements InputListener
{
    //Singleton setup

    public static GameManager Instance = null;

    public static void create()
    {
        if(Instance == null)
        {
            Instance = new GameManager();
        }
    }

    private GameManager()
    {

    }
    //

    //Game state

        //Eau
        final int WATER_FILTER_01_IN = 1;
        final int WATER_FILTER_02_IN = 2;
        final int WATER_FILTER_03_IN = 3;
        final int WATER_FILTER_04_IN = 4;
        final int WATER_FILTER_05_IN = 5;
        final int WATER_FILTER_06_IN = 6;
        final int WATER_FILTER_07_IN = 7;
        final int WATER_FILTER_08_IN = 8;
        final int WATER_FILTER_09_IN = 9;
        final int WATER_FILTER_10_IN = 10;

        boolean isWaterFilter01_in = false;
        boolean isWaterFilter02_in = false;
        boolean isWaterFilter03_in = false;
        boolean isWaterFilter04_in = false;
        boolean isWaterFilter05_in = false;
        boolean isWaterFilter06_in = false;
        boolean isWaterFilter07_in = false;
        boolean isWaterFilter08_in = false;
        boolean isWaterFilter09_in = false;
        boolean isWaterFilter10_in = false;

        //Air-1
        boolean isElementAir1Done = false;

        final int AIR_FILTER_01_IN = 1;
        final int AIR_FILTER_02_IN = 2;
        final int AIR_FILTER_03_IN = 3;
        final int AIR_FILTER_04_IN = 4;
        final int AIR_FILTER_05_IN = 5;


        boolean isAirFilter01_in = false;
        boolean isAirFilter02_in = false;
        boolean isAirFilter03_in = false;
        boolean isAirFilter04_in = false;
        boolean isAirFilter05_in = false;

        //Air-2
        final int AIR_FILTER_06_IN = 6;
        final int AIR_FILTER_07_IN = 7;
        final int AIR_FILTER_08_IN = 8;

        boolean isAirFilter06_in = false;
        boolean isAirFilter07_in = false;
        boolean isAirFilter08_in = false;

        //Terre-1
        boolean isElementTerre1Done = false;

        final int EARTH_FILTER_01_IN = 1;
        final int EARTH_FILTER_02_IN = 2;
        final int EARTH_FILTER_03_IN = 3;
        final int EARTH_FILTER_04_IN = 4;
        final int EARTH_FILTER_05_IN = 5;

        boolean isEarthFilter01_in = false;
        boolean isEarthFilter02_in = false;
        boolean isEarthFilter03_in = false;
        boolean isEarthFilter04_in = false;
        boolean isEarthFilter05_in = false;

        //Terre-2
        final int EARTH_FILTER_06_IN = 6;
        final int EARTH_FILTER_07_IN = 7;
        final int EARTH_FILTER_08_IN = 8;
        final int EARTH_FILTER_09_IN = 9;
        final int EARTH_FILTER_10_IN = 10;

        boolean isEarthFilter06_in = false;
        boolean isEarthFilter07_in = false;
        boolean isEarthFilter08_in = false;
        boolean isEarthFilter09_in = false;
        boolean isEarthFilter10_in = false;
    //

    public void load()
    {

    }

    public void update()
    {

    }

    public void checkScene(String pElement)
    {
        Scene _currentScene = SceneManager.Instance.getCurrentScene();

        if(_currentScene != null)
        {
            if (!_currentScene.getName().equals(pElement))
            {
                SceneManager.Instance.changeScene(pElement);
                Scene _newScene = SceneManager.Instance.getCurrentScene();
                _newScene.justChanged();
            }
        }
    }

    //Water
    private void elementWaterReaction(int pValue)
    {
        checkScene("Eau");

        switch(pValue)
        {
            case WATER_FILTER_01_IN:
                if(!isWaterFilter01_in)
                {
                    if(SceneManager.Instance.getCurrentScene().isChanged())
                    {
                        SceneManager.Instance.getCurrentScene().addEvent("window_rain");
                    }
                    else
                    {
                        EventManager.Instance.executeEvent("window_rain");
                    }
                    isWaterFilter01_in = true;
                }
                break;
            case WATER_FILTER_02_IN:
                if(!isWaterFilter02_in)
                {
                    if(SceneManager.Instance.getCurrentScene().isChanged())
                    {
                        SceneManager.Instance.getCurrentScene().addEvent("window_tree1_appears");
                    }
                    else
                    {
                        EventManager.Instance.executeEvent("window_tree1_appears");
                    }
                    isWaterFilter02_in = true;
                }
                break;
            case WATER_FILTER_03_IN:
                if(!isWaterFilter03_in)
                {
                    if(SceneManager.Instance.getCurrentScene().isChanged())
                    {
                        SceneManager.Instance.getCurrentScene().addEvent("window_tree2_appears");
                    }
                    else
                    {
                        EventManager.Instance.executeEvent("window_tree2_appears");
                    }
                    isWaterFilter03_in = true;
                }
                break;
            case WATER_FILTER_05_IN:
                if(!isWaterFilter05_in)
                {
                    if(SceneManager.Instance.getCurrentScene().isChanged())
                    {
                        SceneManager.Instance.getCurrentScene().addEvent("flower_blossoms");
                    }
                    else
                    {
                        EventManager.Instance.executeEvent("flower_blossoms");
                    }
                    isWaterFilter05_in = true;
                }
                break;
            case WATER_FILTER_09_IN:
                if(!isWaterFilter09_in)
                {
                    if(SceneManager.Instance.getCurrentScene().isChanged())
                    {
                        if(isWaterFilter10_in)
                        {
                            SceneManager.Instance.getCurrentScene().addEvent("girl_clean_0");
                        }
                        else
                        {
                            SceneManager.Instance.getCurrentScene().addEvent("girl_clean_1");
                        }
                    }
                    else
                    {

                        if(isWaterFilter10_in)
                        {
                            EventManager.Instance.executeEvent("girl_clean_0");
                        }
                        else
                        {
                            EventManager.Instance.executeEvent("girl_clean_1");
                        }
                    }
                    isWaterFilter09_in = true;
                }
                break;
            case WATER_FILTER_10_IN:
                if(!isWaterFilter10_in)
                {
                    if(SceneManager.Instance.getCurrentScene().isChanged())
                    {
                        if(isWaterFilter09_in)
                        {
                            SceneManager.Instance.getCurrentScene().addEvent("girl_clothes_clean_0");
                        }
                        else
                        {
                            SceneManager.Instance.getCurrentScene().addEvent("girl_clothes_clean_1");
                        }
                    }
                    else
                    {
                        if(isWaterFilter09_in)
                        {
                            EventManager.Instance.executeEvent("girl_clothes_clean_0");
                        }
                        else
                        {
                            EventManager.Instance.executeEvent("girl_clothes_clean_1");
                        }

                    }
                    isWaterFilter10_in = true;
                }
                break;
            case WATER_FILTER_08_IN:
                if(!isWaterFilter08_in)
                {
                    if(SceneManager.Instance.getCurrentScene().isChanged())
                    {
                        SceneManager.Instance.getCurrentScene().addEvent("bano_coule");
                    }
                    else
                    {
                        EventManager.Instance.executeEvent("bano_coule");
                    }
                    isWaterFilter08_in = true;
                }
                break;
            case WATER_FILTER_04_IN:
                if(!isWaterFilter04_in)
                {
                    if(SceneManager.Instance.getCurrentScene().isChanged())
                    {
                        SceneManager.Instance.getCurrentScene().addEvent("lavabo_coule");
                    }
                    else
                    {
                        EventManager.Instance.executeEvent("lavabo_coule");
                    }
                    isWaterFilter04_in = true;
                }
                break;
            case WATER_FILTER_06_IN:
                if(!isWaterFilter06_in)
                {
                    if(SceneManager.Instance.getCurrentScene().isChanged())
                    {
                        if(isWaterFilter07_in)
                        {
                            SceneManager.Instance.getCurrentScene().addEvent("placard_propre_1");
                        }
                        else
                        {
                            SceneManager.Instance.getCurrentScene().addEvent("placard_propre_0");
                        }
                    }
                    else
                    {
                        if(isWaterFilter07_in)
                        {
                            EventManager.Instance.executeEvent("placard_propre_1");
                        }
                        else
                        {
                            EventManager.Instance.executeEvent("placard_propre_0");
                        }
                    }
                    isWaterFilter06_in = true;
                }
                break;
            case WATER_FILTER_07_IN:
                if(!isWaterFilter07_in)
                {
                    if(SceneManager.Instance.getCurrentScene().isChanged())
                    {
                        if(isWaterFilter06_in)
                        {
                            SceneManager.Instance.getCurrentScene().addEvent("serviettes_propres_0");
                        }
                        else
                        {
                            SceneManager.Instance.getCurrentScene().addEvent("serviettes_propres_1");
                        }
                    }
                    else
                    {
                        if(isWaterFilter06_in)
                        {
                            EventManager.Instance.executeEvent("serviettes_propres_0");
                        }
                        else
                        {
                            EventManager.Instance.executeEvent("serviettes_propres_1");
                        }
                    }
                    isWaterFilter07_in = true;
                }
                break;
        }
    }

    //Air
    private void elementAir2Reaction(int pValue)
    {
        checkScene("Air-2");

        Scene _current = SceneManager.Instance.getCurrentScene();

        if(_current == null)
        {
            Gdx.app.error(ElectroFunCop22.APP_TAG, "[GameManager - elementAir1Reaction()] Air-1 scene not found, current scene is null");
            return;
        }

        switch (pValue) {
            case AIR_FILTER_06_IN:
                if (!isAirFilter06_in) {
                    if (_current.isChanged()) {
                        _current.addEvent("add_tree_0");
                    } else {
                        EventManager.Instance.executeEvent("add_tree_0");
                    }
                    isAirFilter06_in = true;
                }
                break;
            case AIR_FILTER_07_IN:
                if (!isAirFilter07_in) {
                    if (_current.isChanged()) {
                        _current.addEvent("add_tree_1");
                    } else {
                        EventManager.Instance.executeEvent("add_tree_1");
                    }
                    isAirFilter07_in = true;
                }
                break;
            case AIR_FILTER_08_IN:
                if (!isAirFilter08_in) {
                    if (_current.isChanged()) {
                        _current.addEvent("add_tree_2");
                    } else {
                        EventManager.Instance.executeEvent("add_tree_2");
                    }
                    isAirFilter08_in = true;
                }
                break;
        }
    }

    private void elementAir1Reaction(int pValue)
    {
        checkScene("Air-1");

        Scene _current = SceneManager.Instance.getCurrentScene();

        if(_current == null)
        {
            Gdx.app.error(ElectroFunCop22.APP_TAG, "[GameManager - elementAir1Reaction()] Air-1 scene not found, current scene is null");
            return;
        }

        switch (pValue)
        {
            case AIR_FILTER_01_IN:
                if(!isAirFilter01_in)
                {
                    if (_current.isChanged())
                    {
                        _current.addEvent("window_tree1_appears");
                    } else
                    {
                        EventManager.Instance.executeEvent("window_tree1_appears");
                    }
                    isAirFilter01_in = true;
                }
                break;
            case AIR_FILTER_02_IN:
                if(!isAirFilter02_in) {
                    if (_current.isChanged()) {
                        _current.addEvent("cloud_decrease_by_half");
                    } else {
                        EventManager.Instance.executeEvent("cloud_decrease_by_half");
                    }
                    isAirFilter02_in = true;
                }
                break;
            case AIR_FILTER_03_IN:
                if(!isAirFilter03_in) {
                    if (_current.isChanged()) {
                        _current.addEvent("window_tree2_appears");
                    } else {
                        EventManager.Instance.executeEvent("window_tree2_appears");
                    }
                    isAirFilter03_in = true;
                }
                break;
            case AIR_FILTER_04_IN:
                if(!isAirFilter04_in)
                {
                    if(_current.isChanged())
                    {
                        _current.addEvent("cloud_disappear");
                    }
                    else
                    {
                        EventManager.Instance.executeEvent("cloud_disappear");
                    }
                    isAirFilter04_in = true;
                }
                break;
            case AIR_FILTER_05_IN:
                if(!isAirFilter05_in)
                {
                    if(_current.isChanged())
                    {
                        _current.addEvent("flowers_blossom");
                    }
                    else
                    {
                        EventManager.Instance.executeEvent("flowers_blossom");
                    }
                    isAirFilter05_in = true;
                }
                break;
        }
    }

    //Terre
    private void elementTerre1Reaction(int pValue)
    {
        checkScene("Terre-1");

        Scene _current = SceneManager.Instance.getCurrentScene();

        if(_current == null)
        {
            Gdx.app.error(ElectroFunCop22.APP_TAG, "[GameManager - elementTerre1Reaction()] Terre-1 scene not found, current scene is null");
            return;
        }

        switch (pValue)
        {
            case EARTH_FILTER_01_IN:

                if (_current.isChanged())
                {
                    _current.addEvent("terre1_window_tree1");
                } else
                {
                    EventManager.Instance.executeEvent("terre1_window_tree1");
                }
                isEarthFilter01_in = true;
                break;
            case EARTH_FILTER_02_IN:
                if (_current.isChanged()) {
                    _current.addEvent("terre1_window_tree2");
                } else {
                    EventManager.Instance.executeEvent("terre1_window_tree2");
                }
                isEarthFilter02_in = true;
                break;
            case EARTH_FILTER_03_IN:
                if (_current.isChanged()) {
                    _current.addEvent("terre1_window_tree3");
                } else {
                    EventManager.Instance.executeEvent("terre1_window_tree3");
                }
                isEarthFilter03_in = true;
                break;
            case EARTH_FILTER_04_IN:
                if(_current.isChanged())
                {
                    _current.addEvent("terre1_flower_blossoms");
                }
                else
                {
                    EventManager.Instance.executeEvent("terre1_flower_blossoms");
                }
                isEarthFilter04_in = true;
                break;
            case EARTH_FILTER_05_IN:
                if(_current.isChanged())
                {
                    _current.addEvent("tasse_tizane");
                }
                else
                {
                    EventManager.Instance.executeEvent("tasse_tizane");
                }
                isEarthFilter05_in = true;
                break;
        }
    }

    private void elementTerre2Reaction(int pValue)
    {
        checkScene("Terre-2");

        Scene _current = SceneManager.Instance.getCurrentScene();

        if(_current == null)
        {
            Gdx.app.error(ElectroFunCop22.APP_TAG, "[GameManager - elementTerre2Reaction()] Terre-2 scene not found, current scene is null");
            return;
        }

        switch (pValue)
        {
            case EARTH_FILTER_06_IN:

                if (_current.isChanged())
                {
                    _current.addEvent("plant_plant1");
                } else
                {
                    EventManager.Instance.executeEvent("plant_plant1");
                }
                isEarthFilter06_in = true;
                break;
            case EARTH_FILTER_07_IN:
                if (_current.isChanged()) {
                    _current.addEvent("plant_plant2");
                } else {
                    EventManager.Instance.executeEvent("plant_plant2");
                }
                isEarthFilter07_in = true;
                break;
            case EARTH_FILTER_08_IN:
                if (_current.isChanged()) {
                    _current.addEvent("plant_plant3");
                } else {
                    EventManager.Instance.executeEvent("plant_plant3");
                }
                isEarthFilter08_in = true;
                break;
            case EARTH_FILTER_09_IN:
                if(_current.isChanged())
                {
                    _current.addEvent("plant_plant4");
                }
                else
                {
                    EventManager.Instance.executeEvent("plant_plant4");
                }
                isEarthFilter09_in = true;
                break;
            case EARTH_FILTER_10_IN:
                if(_current.isChanged())
                {
                    _current.addEvent("plant_plant5");
                }
                else
                {
                    EventManager.Instance.executeEvent("plant_plant5");
                }
                isEarthFilter10_in = true;
                break;
        }
    }

    @Override
    public void notify(InputData pData)
    {
        //Air
        if(
            (pData.air == AIR_FILTER_01_IN && !isAirFilter01_in)
            || (pData.air == AIR_FILTER_04_IN && !isAirFilter04_in)
            || (pData.air == AIR_FILTER_02_IN && !isAirFilter02_in)
            || (pData.air == AIR_FILTER_05_IN && !isAirFilter05_in)
            || (pData.air == AIR_FILTER_03_IN && !isAirFilter03_in)
            || (pData.air == AIR_FILTER_06_IN && !isAirFilter06_in)
            || (pData.air == AIR_FILTER_07_IN && !isAirFilter07_in)
            || (pData.air == AIR_FILTER_08_IN && !isAirFilter08_in)
        )
        {
            if(!isElementAir1Done) {
                elementAir1Reaction(pData.air);
            }
            else if(isElementAir1Done)
            {
                elementAir2Reaction(pData.air);
            }

            if(!isElementAir1Done && isAirFilter01_in && isAirFilter02_in && isAirFilter03_in && isAirFilter04_in && isAirFilter05_in)
            {
                if(!SceneManager.Instance.getCurrentScene().getName().equals("Air-2")) {

                    EventManager.Instance.executeEvent("air-1_girl_thanking");

                    isElementAir1Done = true;
                    SceneManager.Instance.scheduleChangeScene("Air-2", 100);
                }
            }
        }

        //eau
        if(
                (pData.water == WATER_FILTER_01_IN && !isWaterFilter01_in)
                || (pData.water == WATER_FILTER_02_IN && !isWaterFilter02_in)
                || (pData.water == WATER_FILTER_03_IN && !isWaterFilter03_in)
                || (pData.water == WATER_FILTER_04_IN && !isWaterFilter04_in)
                || (pData.water == WATER_FILTER_05_IN && !isWaterFilter05_in)
                || (pData.water == WATER_FILTER_06_IN && !isWaterFilter06_in)
                || (pData.water == WATER_FILTER_07_IN && !isWaterFilter07_in)
                || (pData.water == WATER_FILTER_08_IN && !isWaterFilter08_in)
                || (pData.water == WATER_FILTER_09_IN && !isWaterFilter09_in)
                || (pData.water == WATER_FILTER_10_IN && !isWaterFilter10_in)
            )
        {

            elementWaterReaction(pData.water);
        }

        //Terre
        if(
                (pData.earth == EARTH_FILTER_01_IN && !isEarthFilter01_in)
                || (pData.earth == EARTH_FILTER_02_IN && !isEarthFilter02_in)
                || (pData.earth == EARTH_FILTER_03_IN && !isEarthFilter03_in)
                || (pData.earth == EARTH_FILTER_04_IN && !isEarthFilter04_in)
                || (pData.earth == EARTH_FILTER_05_IN && !isEarthFilter05_in)
                || (pData.earth == EARTH_FILTER_06_IN && !isEarthFilter06_in)
                || (pData.earth == EARTH_FILTER_07_IN && !isEarthFilter07_in)
                || (pData.earth == EARTH_FILTER_08_IN && !isEarthFilter08_in)
                || (pData.earth == EARTH_FILTER_09_IN && !isEarthFilter09_in)
                || (pData.earth == EARTH_FILTER_10_IN && !isEarthFilter10_in)
            )
        {
            if(!isElementTerre1Done) {
                elementTerre1Reaction(pData.earth);
            }
            else if(isElementTerre1Done)
            {
                elementTerre2Reaction(pData.earth);
            }

            if(!isElementTerre1Done && isEarthFilter01_in && isEarthFilter02_in && isEarthFilter03_in && isEarthFilter04_in && isEarthFilter05_in)
            {
                if(!SceneManager.Instance.getCurrentScene().getName().equals("Terre-2")) {

                    EventManager.Instance.executeEvent("Terre-1_girl_thanking");

                    isElementTerre1Done = true;
                    SceneManager.Instance.scheduleChangeScene("Terre-2", 100);
                }
            }
        }

    }
}
