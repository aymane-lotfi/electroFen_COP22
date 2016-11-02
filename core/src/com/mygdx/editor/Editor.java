package com.mygdx.editor;

import com.badlogic.gdx.Application;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.graphics.Camera;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.math.Vector3;
import com.badlogic.gdx.utils.Logger;
import com.mygdx.game.ElectroFunCop22;
import com.mygdx.scene.Actor;
import com.mygdx.scene.Scene;
import com.mygdx.scene.SceneManager;

/**
 * Created by itachi on 02/11/16.
 */
public class Editor implements InputProcessor
{
    //Singleton setup
    public static Editor Instance = null;

    public static void create()
    {
        Instance = new Editor();
    }

    private Editor()
    {
        Gdx.app.log(ElectroFunCop22.APP_TAG, "[Editor - create()]");
        Gdx.input.setInputProcessor(this);
    }
    //

    private Actor mSelectedActor = null;

    private Vector3 _mousePos = new Vector3();

    //Editor states
    private boolean mDragging = false;
    //

    //Input Handlers
    @Override
    public boolean keyDown(int keycode) {
        return false;
    }

    @Override
    public boolean keyUp(int keycode) {
        return false;
    }

    @Override
    public boolean keyTyped(char character) {
        return false;
    }

    @Override
    public boolean touchDown(int screenX, int screenY, int pointer, int button)
    {
        if(button != Input.Buttons.LEFT || pointer > 0) //Ignore right button
            return false;

        ElectroFunCop22.camera.unproject(_mousePos.set(screenX, screenY, 0));

        Gdx.app.log(ElectroFunCop22.APP_TAG, "[Editor - touchDown()] mouse position  :"+_mousePos.toString());

        Scene _currentScene = SceneManager.Instance.getCurrentScene();
        mSelectedActor = _currentScene.getActorAt(new Vector2(_mousePos.x, _mousePos.y));

        if(mSelectedActor != null)
        {
            Gdx.app.log(ElectroFunCop22.APP_TAG, "[Editor - touchDown()] found actor");

            mDragging = true;
            return true;
        }

        return false;
    }

    @Override
    public boolean touchUp(int screenX, int screenY, int pointer, int button)
    {
        if(button != Input.Buttons.LEFT || pointer > 0) //Ignore right button
            return false;

        Gdx.app.log(ElectroFunCop22.APP_TAG, "[Editor - touchUp()]");

        mSelectedActor = null;
        mDragging = false;
        return  true;
    }

    @Override
    public boolean touchDragged(int screenX, int screenY, int pointer)
    {
        if(!mDragging)
            return false;

        Gdx.app.log(ElectroFunCop22.APP_TAG, "[Editor - touchDragged()]");

        ElectroFunCop22.camera.unproject(_mousePos.set(screenX, screenY, 0));

        mSelectedActor.setPos(new Vector2(_mousePos.x, _mousePos.y));
        return true;
    }

    @Override
    public boolean mouseMoved(int screenX, int screenY) {
        return false;
    }

    @Override
    public boolean scrolled(int amount) {
        return false;
    }
    //


}
