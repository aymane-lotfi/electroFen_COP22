package com.mygdx.events;

import com.badlogic.gdx.Gdx;
import com.mygdx.components.Component;
import com.mygdx.components.MarkerComponent;
import com.mygdx.game.ElectroFunCop22;
import com.mygdx.scene.Actor;
import com.mygdx.scene.Scene;
import com.mygdx.scene.SceneManager;
import org.simpleframework.xml.Attribute;
import org.simpleframework.xml.Root;

/**
 * Created by itachi on 05/11/16.
 */
@Root
public class ActionAdd extends Action
{
    @Attribute(name="ActorPath")
    private String mActorFile = "";

    @Attribute(name="MarkerNumber")
    private int mMarkerNumber;

    public ActionAdd()
    {

    }

    public void execute()
    {
        Actor _actor = Actor.load(mActorFile);
        if(_actor != null)
        {
            _actor.load();
            Scene _currentScene = SceneManager.Instance.getCurrentScene();
            MarkerComponent _MarkerComp = _currentScene.getMarker(mMarkerNumber);
            if(_MarkerComp != null)
            {
                _MarkerComp.markActor(_actor);
                _actor.setPos(_MarkerComp.getPos());
                _currentScene.addActor(_actor);
            }
            else
            {
                Gdx.app.error(ElectroFunCop22.APP_TAG,"[ActionAdd - execute()] no Marker in this scene");
            }
        }
        else
        {
            Gdx.app.error(ElectroFunCop22.APP_TAG, "[ActionAdd - execute()] failed to load actor file "+mActorFile);
        }
    }
}
