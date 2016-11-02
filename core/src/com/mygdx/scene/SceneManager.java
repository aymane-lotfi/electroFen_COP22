package com.mygdx.scene;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.mygdx.config.Config;
import com.mygdx.game.ElectroFunCop22;
import org.simpleframework.xml.Serializer;
import org.simpleframework.xml.core.Persister;

import java.io.File;
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
        //If it's already the current scene
        if(mCurrentScene != null && mCurrentScene.getName().equals(pSceneName))
            return;

        for(Scene scene : mScenes)
        {
            if(scene.getName().equals(pSceneName))
            {
                mCurrentScene = scene;
                return;
            }
        }
    }

    public Scene loadScene(String pFilePath)
    {
        Serializer _serializer = new Persister();
        File _sceneFile = new File(pFilePath);
        Scene _scene = null;

        try
        {
            _scene = _serializer.read(Scene.class, _sceneFile);
        }
        catch(Exception e)
        {
            Gdx.app.error(ElectroFunCop22.APP_TAG, "[SceneManager - loadScene()] error : "+e.toString());
        }
        finally
        {
            return _scene;
        }
    }

    public void load()
    {
        //Load all scenes from configuration file
        for(String scenePath : Config.SCENES_LIST)
        {
            Scene _newScene = loadScene(scenePath);
            if(_newScene != null)
            {
                mScenes.add(_newScene);
            }
            else
            {
                Gdx.app.error(ElectroFunCop22.APP_TAG, "[SceneManager - load()] loaded scene is null!");
            }
        }
        //

        //load actors scenes
        for(Scene scene : mScenes)
        {
            scene.load();
            if(scene.getName().equals(Config.DEFAULT_SCENE))
            {
                mCurrentScene = scene;
            }
        }

        if(mCurrentScene == null)
        {
            Gdx.app.error(ElectroFunCop22.APP_TAG, "the current scene is null");
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
