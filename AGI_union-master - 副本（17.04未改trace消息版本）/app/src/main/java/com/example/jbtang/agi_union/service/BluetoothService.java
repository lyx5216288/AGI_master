package com.example.jbtang.agi_union.service;

import android.app.Activity;
import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothSocket;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.print.PrinterCapabilitiesInfo;
import android.util.Log;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.ExecutionException;

/**
 * Created by 刘洋旭 on 2017/5/11.
 */
public class BluetoothService {
    private static final String TAG="BluetoothService";
    private static final boolean D=true;
    private Activity currentActivity;
    private static final UUID MY_UUID=UUID.fromString("00001101-0000-1000-8000-00805F9B34FB");
    private List<String> lstDevices=new ArrayList();
    private BluetoothAdapter mAdapter=null;
    private myBroadReceiver mReceiver;
    private final Handler mHandler=new Handler(new Handler.Callback() {
        @Override
        public boolean handleMessage(Message msg) {

            return false;
        }
    });

    public BluetoothService() throws IOException {
        mAdapter = BluetoothAdapter.getDefaultAdapter();
        mAdapter.listenUsingRfcommWithServiceRecord("hello",MY_UUID);
        mAdapter.startDiscovery();
        mReceiver=new myBroadReceiver();
        byte[] bytes="7EF1FF111111F17E".getBytes();
        IntentFilter filter = new IntentFilter(BluetoothDevice.ACTION_FOUND);
        currentActivity.registerReceiver(mReceiver, filter);
        filter = new IntentFilter(BluetoothAdapter.ACTION_DISCOVERY_FINISHED);
        currentActivity.registerReceiver(mReceiver, filter);
        BluetoothDevice device=mAdapter.getRemoteDevice("keyname");
        BluetoothSocket btsocket=device.createRfcommSocketToServiceRecord(MY_UUID);
        InputStream is=null;
        OutputStream os=null;
        try{
            btsocket.connect();
            is=btsocket.getInputStream();

            os=btsocket.getOutputStream();
            os.write(bytes);
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            if (is!=null){is.close();}
            if (os!=null){os.close();}
        }
    }

    class  myBroadReceiver extends BroadcastReceiver{
        @Override
        public void onReceive(Context context, Intent intent) {
            String action = intent.getAction();
            Bundle b = intent.getExtras();
            Object[] lstName = b.keySet().toArray();
            //显示所有收到的消息及其细节
            for(int i =0; i < lstName.length;i++) {
                String keyName = lstName[i].toString();
                Log.e(keyName,String.valueOf(b.get(keyName)));
            }
            //搜索设备时，取得设备的MAC地址
            if(BluetoothDevice.ACTION_FOUND.equals(action)) {
                BluetoothDevice device = intent.getParcelableExtra(BluetoothDevice.EXTRA_DEVICE);
                String str= device.getName() +"|" +device.getAddress();
                if(lstDevices.indexOf(str) == -1)//防止重复添加
                    lstDevices.add(str);// 获取设备名称和mac地址
//                adtDevices.notifyDataSetChanged();

            }

        }

    }


}
