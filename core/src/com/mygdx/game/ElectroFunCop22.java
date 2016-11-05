package com.mygdx.game;

import java.util.Iterator;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.math.Rectangle;
//import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.math.Vector3;
import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.utils.TimeUtils;
import com.mygdx.components.Animation;
import com.mygdx.components.AnimationComponent;
import com.mygdx.components.Component;
import com.mygdx.config.Config;
import com.mygdx.editor.Editor;
import com.mygdx.events.EventManager;
import com.mygdx.scene.Actor;
import com.mygdx.scene.Scene;
import com.mygdx.scene.SceneManager;
import com.mygdx.scene.Vector2;

public class ElectroFunCop22 extends ApplicationAdapter {

   public static OrthographicCamera camera;
   public static final String APP_TAG = "ElectroFen"; //For logs

   @Override
   public void create()
   {
      // create the camera and the SpriteBatch
      camera = new OrthographicCamera();
      camera.setToOrtho(false, 800, 480);


      //New game system
      SceneManager.create();
      EventManager.create();

       if(Config.enableEditor)
       {
           Editor.create();
       }

      SceneManager.Instance.load();
      EventManager.Instance.load();

      //
   }


   @Override
   public void render() {
      // clear the screen with a dark blue color. The
      // arguments to glClearColor are the red, green
      // blue and alpha component in the range [0,1]
      // of the color to be used to clear the screen.
      Gdx.gl.glClearColor(0, 0, 0.2f, 1);
      Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

      // tell the camera to update its matrices.
      camera.update();

      // tell the SpriteBatch to render in the
      // coordinate system specified by the camera.
      SceneManager.Instance.getSpriteBatch().setProjectionMatrix(camera.combined);

      SceneManager.Instance.draw();

   }

   @Override
   public void dispose() {
      SceneManager.Instance.destroy();
   }
}
