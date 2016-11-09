package com.mygdx.events;

import com.badlogic.gdx.Gdx;
import com.mygdx.game.ElectroFunCop22;
import com.mygdx.scene.SceneManager;
import org.simpleframework.xml.Attribute;
import org.simpleframework.xml.Root;

/**
 * Created by itachi on 08/11/16.
 */
@Root
public class ActionChangeScene extends Action
{
    @Attribute(name="Scene")
    private String mScene = "";

    @Attribute(name="Timer")
    private float mTimer = 0;

    public ActionChangeScene()
    {

    }

    public void execute()
    {
        if(SceneManager.Instance.sceneExists(mScene))
        {
            SceneManager.Instance.scheduleChangeScene(mScene, mTimer);
        }
        else
        {
            Gdx.app.error(ElectroFunCop22.APP_TAG, "[ActionChangeScene - execute()] \""+mScene+"\" does not exist");
        }
    }
}
