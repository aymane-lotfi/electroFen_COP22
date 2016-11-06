package com.mygdx.input;

import com.badlogic.gdx.Gdx;
import com.fazecast.jSerialComm.SerialPort;
import com.fazecast.jSerialComm.SerialPortEvent;
import com.mygdx.game.ElectroFunCop22;
import org.json.JSONObject;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by itachi on 05/11/16.
 */
public class InputManager
{
    //Singleton setup

    public static InputManager Instance = null;

    public static void create()
    {
        if(Instance == null)
        {
            Instance = new InputManager();
        }
    }

    private InputManager()
    {

    }
    //

    private List<InputListener> mListeners = new ArrayList<InputListener>();

    public void addListener(InputListener pListener)
    {
        mListeners.add(pListener);
    }

    public void notify(InputData pData)
    {
        for(InputListener listener : mListeners)
        {
            listener.notify(pData);
        }
    }

    ArduinoListener mArduinoListener = null;
    public SerialPort comPort;


    public void load()
    {
        try
        {
            comPort = SerialPort.getCommPorts()[0];
            comPort.openPort();
            comPort.addDataListener(new ArduinoListener(comPort));

        }catch(Exception e){
            Gdx.app.error(ElectroFunCop22.APP_TAG, "[InputManager - load()] error "+e.toString());
        }
    }
}
