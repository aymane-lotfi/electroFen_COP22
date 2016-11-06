package com.mygdx.game;

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
                    if(_currentScene != null && !_currentScene.getName().equals("Eau"))
                    {
                        //TODO add Events to scene
                        SceneManager.Instance.changeScene("Eau");
                    }
                    isLavaboPlugedIn = true;
                }
                break;

            case BANO_PLUGED_IN:
                if(!isBanoPlugedIn)
                {
                    if(_currentScene != null && !_currentScene.getName().equals("Eau"))
                    {
                        //TODO add Events to scene
                        SceneManager.Instance.changeScene("Eau");
                    }
                    isBanoPlugedIn = true;
                }
                break;
        }
    }
}
