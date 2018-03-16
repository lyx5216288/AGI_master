package sino.com.ltetest.Activity;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.SimpleAdapter;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.concurrent.TimeUnit;

import sino.com.ltetest.R;
import sino.com.ltetest.external.MonitorApplication;
import sino.com.ltetest.external.MonitorHelper;
import sino.com.ltetest.type.Global;

/**
 * Created by 刘洋旭 on 2016/8/15.
 */
public class MainActivity extends Activity {
    private GridView gridView;
    private ArrayList<HashMap<String,Object>> itemList;
    private SimpleAdapter simpleAdapter;
    private String texts[];
    private int images[];
    private MonitorHelper monitorHelper;
//    private myBroadcastReceiver broadcastReceiver;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.mainlayout);
        init();
    }
    public void init(){

        images = new int[]{R.drawable.configuration,
                R.drawable.find_stmsi,
                R.drawable.local_info,
                R.drawable.local_info,
                R.drawable.local_info,
                R.drawable.local_info};
        texts = new String[]{this.getString(R.string.title_main_menu_cell_monitor),
                this.getString(R.string.title_main_menu_find_STMSI),
                this.getString(R.string.title_main_menu_orientation),
                this.getString(R.string.title_main_menu_environment_detection),
                this.getString(R.string.title_main_menu_configuration),
                this.getString(R.string.title_main_menu_cellPhone_info)};
        itemList = new ArrayList<HashMap<String, Object>>();
        for(int i = 0; i < 6; i++){
            HashMap<String,Object> map = new HashMap<String,Object>();
            map.put("itemImage",images[i]);
            map.put("itemText",texts[i]);
            itemList.add(map);
        }
        simpleAdapter = new SimpleAdapter(this,
                itemList,
                R.layout.main_menu_item,
                new String[]{"itemImage","itemText"},
                new int[]{R.id.main_menu_item_image,R.id.main_menu_item_name});
        gridView = (GridView) findViewById(R.id.main_menu_gridView);
        gridView.setAdapter(simpleAdapter);
        gridView.setOnItemClickListener(new ItemClickListener());

//        try {
//            broadcastReceiver = new myBroadcastReceiver();
//            IntentFilter filter = new IntentFilter();
//            filter.addAction(MonitorApplication.BROAD_FROM_MAIN_MENU_DEVICE);
//            filter.addAction(MonitorApplication.BROAD_FROM_CONFIGURATION_ACTIVITY);
//            registerReceiver(broadcastReceiver, filter);
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
        Global.ThreadPool.scheduledThreadPool.scheduleAtFixedRate(new Runnable() {
            @Override
            public void run() {
                refreshDeviceStatusBar();
            }
        }, 1, 1, TimeUnit.SECONDS);

        monitorHelper = new MonitorHelper();
        monitorHelper.startService(this);

    }
    class ItemClickListener implements AdapterView.OnItemClickListener{

        @Override
        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
            HashMap<String,Object> item = (HashMap<String, Object>) parent.getItemAtPosition(position);
            String itemText = (String) item.get("itemText");
            Object object = item.get("itemImage");
            //Toast.makeText(MainMenuActivity.this,itemText,Toast.LENGTH_LONG).show();
            switch (images[position]){
                case R.drawable.configuration:
                    startActivity(new Intent(MainActivity.this, SysConfig.class));
                    break;
                case R.drawable.find_stmsi:
                    startActivity(new Intent(MainActivity.this, FindIMSIActivity.class));
                    break;
                case R.drawable.local_info:
                    startActivity(new Intent(MainActivity.this, LocalInfoActivity.class));
                    break;
//                case R.drawable.local_info:
//                    startActivity(new Intent(MainMenuActivity.this,InterferenceActivity.class));
//                    break;
//                case R.drawable.local_info:
//                    startActivity(new Intent(MainMenuActivity.this, ConfigurationActivity.class));
//                    break;
//                case R.drawable.local_info:
//                    startActivity(new Intent(MainMenuActivity.this, LocalInfoActivity.class));
//                    break;
            }
        }
    }

//    private class myBroadcastReceiver extends BroadcastReceiver {
//
//        @Override
//        public void onReceive(Context context, Intent intent) {
//            // TODO Auto-generated method stub
//            if (intent.getAction().equals(MonitorApplication.BROAD_FROM_MAIN_MENU_DEVICE)) {
////                Bundle bundle = intent.getExtras();
////                final int colorOne = bundle.getInt("colorOne");
////                final int colorTwo = bundle.getInt("colorTwo");
////                final int colorThree = bundle.getInt("colorThree");
////                final int colorFour = bundle.getInt("colorFour");
////                final String statusText = bundle.getString("statusText");
////                runOnUiThread(new Runnable() {
////                    @Override
////                    public void run() {
////                        deviceColorOne.setBackgroundColor(colorOne);
////                        deviceColorTwo.setBackgroundColor(colorTwo);
////                        deviceColorThree.setBackgroundColor(colorThree);
////                        deviceColorFour.setBackgroundColor(colorFour);
////                        deviceStatusText.setText(statusText);
////                    }
////                });
//            } else if (intent.getAction().equals(MonitorApplication.BROAD_FROM_CONFIGURATION_ACTIVITY)) {
//                String flag = intent.getStringExtra("flag");
//                switch (flag) {
////                    case ConfigurationActivity.ADD_DEVICE_FLAG: {
////                        String name = intent.getStringExtra("name");
////                        String ip = intent.getStringExtra("ip");
////                        Status.BoardType type = (Status.BoardType) intent.getSerializableExtra("type");
////                        DeviceManager.getInstance().addToAll(new MonitorDevice(name, ip, type));
////                        Log.e(TAG, "AllDevices Size" + DeviceManager.getInstance().getAllDevices().size());
////                        break;
////                    }
////                    case ConfigurationActivity.DELETE_DEVICE_FLAG: {
////                        String name = intent.getStringExtra("name");
////                        MonitorDevice device = DeviceManager.getInstance().getFromAll(name);
////                        if (device != null) {
////                            device.release();
////                        }
////                        DeviceManager.getInstance().remove(name);
////                        DeviceManager.getInstance().removeFromAll(name);
////                        Log.e(TAG, "AllDevices Size" + DeviceManager.getInstance().getAllDevices().size());
////                        break;
////                    }
////                    case ConfigurationActivity.CHANGE_DEVICE_FLAG: {
////                        String name = intent.getStringExtra("name");
////                        String ip = intent.getStringExtra("ip");
////                        Status.BoardType type = (Status.BoardType) intent.getSerializableExtra("type");
////                        MonitorDevice device = DeviceManager.getInstance().getFromAll(name);
////                        if (device != null) {
////                            device.release();
////                        }
////                        DeviceManager.getInstance().remove(name);
////                        Log.e("Device", "replaceName" + name);
////                        DeviceManager.getInstance().addToAll(new MonitorDevice(name, ip, type));
////                        Log.e(TAG, "AllDevices Size" + DeviceManager.getInstance().getAllDevices().size());
////                        break;
////                    }
////                    case ConfigurationActivity.REBOOT_DEVICE_FLAG: {
////                        String name = intent.getStringExtra("name");
////                        MonitorDevice device = DeviceManager.getInstance().getDevice(name);
////                        if (device != null) {
////                            device.reboot();
////                            DeviceManager.getInstance().remove(name);
////                            Toast.makeText(MainMenuActivity.this, "设备重启中!", Toast.LENGTH_SHORT).show();
////                        }
////                        break;
////                    }
////                    default:
////                        break;
//                }
//            }
//        }
//    }

    private void refreshDeviceStatusBar() {
//        int colorOne = getResources().getColor(R.color.default_color);
//        int colorTwo = getResources().getColor(R.color.default_color);
//        int colorThree = getResources().getColor(R.color.default_color);
//        int colorFour = getResources().getColor(R.color.default_color);
//        String statusText = "未就绪";
//        int i = 0;
//        for (MonitorDevice device : DeviceManager.getInstance().getAllDevices()) {
//            i++;
//            if (device.isConnected()) {
//                if (i == 1)
//                    colorOne = Color.GREEN;
//                else if (i == 2)
//                    colorTwo = Color.GREEN;
//                else if (i == 3)
//                    colorThree = Color.GREEN;
//                else if (i == 4)
//                    colorFour = Color.GREEN;
//                statusText = "已连接";
//
//            } else {
//                if (device.getPingStatus() == Status.PingResult.SUCCEED) {
//                    if (i == 1)
//                        colorOne = Color.YELLOW;
//                    else if (i == 2)
//                        colorTwo = Color.YELLOW;
//                    else if (i == 3)
//                        colorThree = Color.YELLOW;
//                    else if (i == 4)
//                        colorFour = Color.YELLOW;
//                    if (statusText != "已连接")
//                        statusText = "已就绪";
//                } else {
//                    if (i == 1)
//                        colorOne = Color.RED;
//                    else if (i == 2)
//                        colorTwo = Color.RED;
//                    else if (i == 3)
//                        colorThree = Color.RED;
//                    else if (i == 4)
//                        colorFour = Color.RED;
//                }
//                try {
//                    //device.connect();
//                } catch (Exception e) {
//                    e.printStackTrace();
//                }
//            }
//            //Log.d("changeDevice","devicename:"+device.getName()+" hashcode:"+device.hashCode());
//        }
//        if (DeviceManager.getInstance().getAllDevices().size() == 0) {
//            statusText = "无可用设备";
//        }
        Intent intent = new Intent();
        Bundle bundle = new Bundle();
//        bundle.putInt("colorOne", colorOne);
//        bundle.putInt("colorTwo", colorTwo);
//        bundle.putInt("colorThree", colorThree);
//        bundle.putInt("colorFour", colorFour);
//        bundle.putString("statusText", statusText);
        intent.putExtras(bundle);
        intent.setAction(MonitorApplication.BROAD_FROM_MAIN_MENU_DEVICE);
        sendBroadcast(intent);
    }



}


