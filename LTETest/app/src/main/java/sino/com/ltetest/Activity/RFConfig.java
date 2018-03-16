package sino.com.ltetest.Activity;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Spinner;

import sino.com.ltetest.A2P_MSG.MSG.RECV_RF_PARA;
import sino.com.ltetest.R;

/**
 * Created by 刘洋旭 on 2016/8/8.
 */
public class RFConfig extends Activity {
    private RECV_RF_PARA rf;

    private EditText sysno,pdh,dlpdh,ulpdh,dlpl,ulpl,udltime,speczhen,tx1pwd,tx2pwd;
    private CheckBox shepin,kspzpd;
    private Spinner zhentype,zhenjgtype,dldk,uldk;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.rf_config);

    }

    public void init(){
        final SharedPreferences sharedPreferences = getSharedPreferences("rfconfig", Context.MODE_PRIVATE);
        sysno= (EditText) findViewById(R.id.rf_sysno);
        pdh= (EditText) findViewById(R.id.rf_pdh);
        dlpdh= (EditText) findViewById(R.id.rf_dlpdh);
        ulpdh= (EditText) findViewById(R.id.rf_ulpdh);
        dlpl= (EditText) findViewById(R.id.rf_dlpl);
        ulpl= (EditText) findViewById(R.id.rf_ulpl);
        udltime= (EditText) findViewById(R.id.rf_udltime);
        speczhen= (EditText) findViewById(R.id.rf_tszz);
        tx1pwd= (EditText) findViewById(R.id.rf_tx1gld);
        tx2pwd= (EditText) findViewById(R.id.rf_tx2gld);
        shepin= (CheckBox) findViewById(R.id.shepin);
        kspzpd= (CheckBox) findViewById(R.id.kspzpd);
        zhentype= (Spinner) findViewById(R.id.rf_paorrru);
        zhenjgtype= (Spinner) findViewById(R.id.rf_zjglx);
        dldk= (Spinner) findViewById(R.id.rf_dldk);
        uldk= (Spinner) findViewById(R.id.rf_uldk);

        sysno.setText(sharedPreferences.getString("sysno","1"));
        pdh.setText(sharedPreferences.getString("pdh","40"));
        dlpdh.setText(sharedPreferences.getString("dlpdh","38950"));
        ulpdh.setText(sharedPreferences.getString("ulpdh","38950"));
        dlpl.setText(sharedPreferences.getString("dlpl","2330"));
        ulpl.setText(sharedPreferences.getString("ulpl","2330"));
        udltime.setText(sharedPreferences.getString("udltime","1"));
        speczhen.setText(sharedPreferences.getString("speczhen","7"));
        tx1pwd.setText(sharedPreferences.getString("tx1pwd","1"));
        tx2pwd.setText(sharedPreferences.getString("tx2pwd","1"));
        boolean bool;
        if(sharedPreferences.getString("shepin","0").equals("0")){
            bool=true;
        }else {
            bool=false;
        }
        shepin.setChecked(bool);

        boolean bool1;
        if(sharedPreferences.getString("kspzpd","0").equals("0")){
            bool1=true;
        }else {
            bool1=false;
        }
        kspzpd.setChecked(bool1);

        zhentype.setSelection(Integer.parseInt(sharedPreferences.getString("zhentype","1")));
        zhenjgtype.setSelection(Integer.parseInt(sharedPreferences.getString("zhenjgtype","0")));
        dldk.setSelection(Integer.parseInt(sharedPreferences.getString("dldk","5")));
        uldk.setSelection(Integer.parseInt(sharedPreferences.getString("uldk","5")));

    }

}
