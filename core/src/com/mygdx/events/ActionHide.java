package com.mygdx.events;

import com.badlogic.gdx.Gdx;
import com.mygdx.components.SpriteComponent;
import com.mygdx.game.ElectroFunCop22;
import com.mygdx.scene.Actor;
import com.mygdx.scene.Scene;
import com.mygdx.scene.SceneManager;
import org.simpleframework.xml.Attribute;
import org.simpleframework.xml.Root;

/**
 * Created by itachi on 08/11/16.
 */
@Root
public class ActionHide extends Action
{
    public ActionHide()
    {

    }

    public void execute()
    {
        Scene _currentScene = SceneManager.Instance.getCurrentScene();
        if(_currentScene != null)
        {
            Actor _actor = _currentScene.getActorByName(mActorName);
            if(_actor != null)
            {
                SpriteComponent _spriteComp = (SpriteComponent)_actor.getComponent("SpriteComponent");
                if(_spriteComp != null)
                {
                    _spriteComp.activate(false);
                }
                else
                {
                    Gdx.app.error(ElectroFunCop22.APP_TAG, "The actor \""+mActorName+"\" is not a drawable");
                }
            }
            else
            {
                Gdx.app.error(ElectroFunCop22.APP_TAG, "The actor \""+mActorName+"\" does not exist in "+_currentScene.getName());
            }
        }
        else
        {
            Gdx.app.error(ElectroFunCop22.APP_TAG, "[ActionHide - execute()] current scene is null");
        }
    }
}
