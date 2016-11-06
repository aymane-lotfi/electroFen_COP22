package com.mygdx.input;

import com.badlogic.gdx.Gdx;
import com.fazecast.jSerialComm.SerialPort;
import com.fazecast.jSerialComm.SerialPortDataListener;
import com.fazecast.jSerialComm.SerialPortEvent;
import com.mygdx.events.EventManager;
import com.mygdx.game.ElectroFunCop22;
import org.json.JSONObject;

import java.io.InputStream;

/**
 * Created by itachi on 05/11/16.
 */
public class ArduinoListener implements SerialPortDataListener
{

    private SerialPort comPort;
    JSONObject obj;

    public ArduinoListener(SerialPort pComPort)
    {
        comPort = pComPort;
    }

    @Override
    public int getListeningEvents() { return SerialPort.LISTENING_EVENT_DATA_AVAILABLE; }
    @Override
    public void serialEvent(SerialPortEvent event)
    {
        if (event.getEventType() != SerialPort.LISTENING_EVENT_DATA_AVAILABLE)
            return;
        InputManager.Instance.comPort.setComPortTimeouts(SerialPort.TIMEOUT_READ_SEMI_BLOCKING, 5000, 0);
        InputStream in = InputManager.Instance.comPort.getInputStream();
        try
        {
            String arduinoData = "";
            char nextChar;
            for (int j = 0; j < 100; ++j){
                nextChar = (char)in.read();
                if(nextChar != '\r')
                    arduinoData += nextChar;
                else
                    break;
            }

            try{
                obj = new JSONObject(arduinoData);
               System.out.println("earth action number:" + obj.getInt("water"));
                Gdx.app.log(ElectroFunCop22.APP_TAG, "Water element : "+obj.getInt("water"));
                final int _value = obj.getInt("water");
                new Thread(new Runnable(){
                    @Override
                    public void run(){
                        //Here we are telling libgdx to connect a new runnable to the gl thread
                        Gdx.app.postRunnable(new Runnable()
                        {
                            @Override
                            public void run()
                            {
                                getElementWaterElement(_value);

                            }
                        });
                    }

                }).start();
            }catch(Exception e){
                System.out.println("bad value:" + e.toString());
            }

            arduinoData = "";
            in.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    void getElementWaterElement(int pElem)
    {
        switch (pElem)
        {
            case 1:
                EventManager.Instance.executeEvent("add_bano");
                break;
            case 2:
                EventManager.Instance.executeEvent("add_lavabo");
                break;
        }
    }
}
