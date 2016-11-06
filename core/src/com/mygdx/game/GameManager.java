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
        final int BANO_PLUGED_IN = 2;

        boolean isLavaboPlugedIn = false;
        boolean isBanoPlugedIn = false;

        //Terre
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
                            _newScene.addEvent("add_lavabo");
                            _newScene.justChanged();
                        }
                        else
                        {
                            EventManager.Instance.executeEvent("add_lavabo");
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
                            _newScene.addEvent("add_bano");
                            _newScene.justChanged();
                        }
                        else
                        {
                            EventManager.Instance.executeEvent("add_bano");
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
