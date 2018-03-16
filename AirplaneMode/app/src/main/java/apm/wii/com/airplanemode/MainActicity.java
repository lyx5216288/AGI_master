package apm.wii.com.airplanemode1;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.provider.Settings;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by 刘洋旭 on 2016/12/13.
 */
public class MainActicity extends Activity {
    public EditText data;
    public Button btn;
    public TextView imsi,stmsi;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_layout);
        final byte[] m=new byte[]{0x40,0x04,0x28,0x30,0x28,0x28,0x58};
        data= (EditText) findViewById(R.id.bitdata);
        btn= (Button) findViewById(R.id.jiexi);
        imsi= (TextView) findViewById(R.id.imsi);
        stmsi= (TextView) findViewById(R.id.stmsi);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
              StringBuffer str=new StringBuffer();
                for (int i=0;i<m.length;i++){
                    str.append(byteToBit(m[i]));
                }
                imsi.setText(str);
            }

        });


    }

    public static String byteToBit(byte b){
        return ""+(byte)((b>>7)&0x1)+
                (byte)((b>>6)&0x1)+
                (byte)((b>>5)&0x1)+
                (byte)((b>>4)&0x1)+
                (byte)((b>>3)&0x1)+
                (byte)((b>>2)&0x1)+
                (byte)((b>>1)&0x1)+
                (byte)((b>>0)&0x1);
    }
}
