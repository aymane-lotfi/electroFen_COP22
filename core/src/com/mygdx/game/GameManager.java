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
        final int WATER_FILTER_01_IN = 5;
        final int WATER_FILTER_02_IN = 2;
        final int WATER_FILTER_03_IN = 3;
        final int WATER_FILTER_04_IN = 4;
        final int WATER_FILTER_05_IN = 1;
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

        //Air
        final int TREE_0_PLUGEDIN = 6;
        final int TREE_1_PLUGEDIN = 7;
        final int TREE_2_PLUGEDIN = 8;

        boolean isTree0PlugedIn = false;
        boolean isTree1PlugedIn = false;
        boolean isTree2PlugedIn = false;
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

    public void elementWaterReaction(int pValue)
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

    void elementAirReaction(int pValue)
    {
        checkScene("Terre");

        if(pValue == TREE_0_PLUGEDIN)
        {
            if(!isTree0PlugedIn)
            {
                if(SceneManager.Instance.getCurrentScene().isChanged())
                {
                    SceneManager.Instance.getCurrentScene().addEvent("add_tree_0");
                }
                else
                {
                    EventManager.Instance.executeEvent("add_tree_0");
                }
                isTree0PlugedIn = true;
            }
        }

        if(pValue == TREE_1_PLUGEDIN)
        {
            if(!isTree1PlugedIn)
            {
                if(SceneManager.Instance.getCurrentScene().isChanged())
                {
                    SceneManager.Instance.getCurrentScene().addEvent("add_tree_1");
                }
                else
                {
                    EventManager.Instance.executeEvent("add_tree_1");
                }
                isTree1PlugedIn = true;
            }
        }

        if(pValue == TREE_2_PLUGEDIN)
        {
            if(!isTree2PlugedIn)
            {
                if(SceneManager.Instance.getCurrentScene().isChanged())
                {
                    SceneManager.Instance.getCurrentScene().addEvent("add_tree_3");
                }
                else
                {
                    EventManager.Instance.executeEvent("add_tree_3");
                }

                isTree2PlugedIn = true;
            }
        }
    }

    @Override
    public void notify(InputData pData)
    {
        Scene _currentScene = SceneManager.Instance.getCurrentScene();

        //Air
        if( pData.earth1 == TREE_0_PLUGEDIN ||
            pData.earth2 == TREE_1_PLUGEDIN ||
            pData.earth3 == TREE_2_PLUGEDIN
        )
        {
            elementAirReaction(pData.earth1);
            elementAirReaction(pData.earth2);
            elementAirReaction(pData.earth3);
        }

        //eau
        if(
                pData.water == WATER_FILTER_01_IN || pData.water == WATER_FILTER_02_IN ||
                pData.water == WATER_FILTER_03_IN || pData.water == WATER_FILTER_04_IN ||
                pData.water == WATER_FILTER_05_IN || pData.water == WATER_FILTER_06_IN ||
                pData.water == WATER_FILTER_07_IN || pData.water == WATER_FILTER_08_IN ||
                pData.water == WATER_FILTER_09_IN || pData.water == WATER_FILTER_10_IN
            )
        {

            elementWaterReaction(pData.water);
        }

    }
}
