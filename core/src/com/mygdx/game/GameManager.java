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
        final int LAVABO_PLUGED_IN = 1;
        final int BANO_PLUGED_IN = 3;

        boolean isLavaboPlugedIn = false;
        boolean isBanoPlugedIn = false;

        //Air
        final int TREE_0_PLUGEDIN = 2;
        final int TREE_1_PLUGEDIN = 4;
        final int TREE_2_PLUGEDIN = 5;

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

    @Override
    public void notify(InputData pData)
    {
        Scene _currentScene = SceneManager.Instance.getCurrentScene();

        //Air
        if( pData.earth1 == TREE_0_PLUGEDIN || pData.earth2 == TREE_1_PLUGEDIN || pData.earth3 == TREE_2_PLUGEDIN)
        {
            if(_currentScene != null) {
                if (!_currentScene.getName().equals("Terre")) {
                    //TODO add Events to scene
                    SceneManager.Instance.changeScene("Terre");
                    Scene _newScene = SceneManager.Instance.getCurrentScene();

                    if(pData.earth1 == TREE_0_PLUGEDIN)
                    {
                        if(!isTree0PlugedIn)
                        {
                            _newScene.addEvent("add_tree_0");
                            isTree0PlugedIn = true;
                        }
                    }

                    if(pData.earth2 == TREE_1_PLUGEDIN)
                    {
                        if(!isTree1PlugedIn)
                        {
                            _newScene.addEvent("add_tree_1");
                            isTree1PlugedIn = true;
                        }
                    }

                    if(pData.earth3 == TREE_2_PLUGEDIN)
                    {
                        if(!isTree2PlugedIn)
                        {
                            _newScene.addEvent("add_tree_2");
                            isTree2PlugedIn = true;
                        }
                    }
                    _newScene.justChanged();
                }
                else
                {
                    if(pData.earth1 == TREE_0_PLUGEDIN)
                    {
                        if(!isTree0PlugedIn)
                        {
                            EventManager.Instance.executeEvent("add_tree_0");
                            isTree0PlugedIn = true;
                        }
                    }

                    if(pData.earth2 == TREE_1_PLUGEDIN)
                    {
                        if(!isTree1PlugedIn)
                        {
                            EventManager.Instance.executeEvent("add_tree_1");
                            isTree1PlugedIn = true;
                        }
                    }

                    if(pData.earth3 == TREE_2_PLUGEDIN)
                    {
                        if(!isTree2PlugedIn)
                        {
                            EventManager.Instance.executeEvent("add_tree_2");
                            isTree2PlugedIn = true;
                        }
                    }

                }
            }
        }

        //eau
        switch(pData.water)
        {
            case LAVABO_PLUGED_IN:
                if(!isLavaboPlugedIn)
                {
                    if(_currentScene != null)
                    {
                        if(!_currentScene.getName().equals("Eau"))
                        {
                            //TODO add Events to scene
                            SceneManager.Instance.changeScene("Eau");
                            Scene _newScene = SceneManager.Instance.getCurrentScene();
                            if(isBanoPlugedIn)
                            {
                                _newScene.addEvent("add_lavabo_dirty");
                            }
                            else
                            {
                                _newScene.addEvent("add_lavabo_clean");
                            }

                            _newScene.justChanged();
                        }
                        else
                        {
                            if(isBanoPlugedIn)
                            {
                                EventManager.Instance.executeEvent("add_lavabo_dirty");
                            }
                            else
                            {
                                EventManager.Instance.executeEvent("add_lavabo_clean");
                            }
                        }
                        isLavaboPlugedIn = true;
                    }
                    else
                    {
                        Gdx.app.error(ElectroFunCop22.APP_TAG, "[GameManager - notify()] current scene is null");
                    }
                }
                break;

            case BANO_PLUGED_IN:
                if(!isBanoPlugedIn)
                {
                    if(_currentScene != null)
                    {
                        if(!_currentScene.getName().equals("Eau"))
                        {
                            //TODO add Events to scene
                            SceneManager.Instance.changeScene("Eau");
                            Scene _newScene = SceneManager.Instance.getCurrentScene();
                            if(isLavaboPlugedIn)
                            {
                                _newScene.addEvent("add_bano_dirty");
                            }
                            else
                            {
                                _newScene.addEvent("add_bano_clean");
                            }

                            _newScene.justChanged();
                        }
                        else
                        {
                            if(isLavaboPlugedIn)
                            {
                                EventManager.Instance.executeEvent("add_bano_dirty");
                            }
                            else
                            {
                                EventManager.Instance.executeEvent("add_bano_clean");
                            }
                        }
                        isBanoPlugedIn = true;
                    }
                    else
                    {
                        Gdx.app.error(ElectroFunCop22.APP_TAG, "[GameManager - notify()] current scene is null");
                    }
                }
                break;
        }
    }
}
