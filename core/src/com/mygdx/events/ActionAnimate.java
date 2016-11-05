package com.mygdx.events;

import com.badlogic.gdx.Gdx;
import com.mygdx.components.AnimationComponent;
import com.mygdx.game.ElectroFunCop22;
import com.mygdx.scene.Actor;
import com.mygdx.scene.Scene;
import com.mygdx.scene.SceneManager;

/**
 * Created by itachi on 05/11/16.
 */
public class ActionAnimate extends Action
{
    public ActionAnimate()
    {

    }

    public void execute()
    {
        Scene _currentScene = SceneManager.Instance.getCurrentScene();
        Actor _actor = _currentScene.getActorByName(mActorName);
        if(_actor != null)
        {
            AnimationComponent _animComp = (AnimationComponent)_actor.getComponent("AnimationComponent");
            if(_animComp != null) {
                _animComp.changeAnim(mAnimationName);
            }
            else
            {
                Gdx.app.error(ElectroFunCop22.APP_TAG, "[ActionAnimate - execute()] \""+_actor.getName()+"\" doesn't have animationComponent");
            }
        }
        else
        {
            Gdx.app.error(ElectroFunCop22.APP_TAG, "[ActionAnimate - execute()] \""+_actor.getName()+"\" is not found in the scene");
        }
    }
}
