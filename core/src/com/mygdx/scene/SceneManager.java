package com.mygdx.scene;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import java.util.ArrayList;
import java.util.List;

public class SceneManager
{
    //Singleton setup
    public static SceneManager Instance = null;

    public static void create()
    {
        if(Instance == null)
        {
            Instance = new SceneManager();
        }
    }

    private SceneManager()
    {

    }
    //

    private List<Scene> mScenes = new ArrayList<Scene>();
    private Batch mSpriteBatch = new SpriteBatch();
    private Scene mCurrentScene = null;

    public void addScene(Scene pScene)
    {
        mCurrentScene = pScene; //TODO delete it just for test
        mScenes.add(pScene);
    }

    public Scene getCurrentScene()
    {
        return mCurrentScene;
    }

    public Batch getSpriteBatch()
    {
        return mSpriteBatch;
    }

    public void changeScene(String pSceneName)
    {

    }

    public void load()
    {
        for(Scene scene : mScenes)
        {
            scene.load();
        }
    }

    public void update()
    {
        for(Scene scene : mScenes)
        {
            scene.update();
        }
    }

    public void draw()
    {
        if(mSpriteBatch != null)
        {
            mSpriteBatch.begin();

            if(mCurrentScene != null)
            {
                mCurrentScene.draw();
            }

            mSpriteBatch.end();
        }
    }

    public void destroy()
    {
        for(Scene scene : mScenes)
        {
            scene.destroy();
        }
    }
}
