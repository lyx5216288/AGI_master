package sino.com.ltetest.Activity;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

import sino.com.ltetest.A2P_MSG.MSG.MSG_SYS_PARA;
import sino.com.ltetest.A2P_MSG.MSG.RECV_RF_PARA;
import sino.com.ltetest.Constant.constant;
import sino.com.ltetest.R;

/**
 * Created by 刘洋旭 on 2016/8/17.
 */
public class TestRFMsgActivity extends Activity {
    private TextView textxianshi;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.textmsglayout);
        textxianshi= (TextView) findViewById(R.id.textxianshi);
        RECV_RF_PARA msg=new RECV_RF_PARA(constant.rfmsg.getBytes());
        String str="";
        str+=msg.getRfEnable().getBase()+"-rfEnable,";
        str+=msg.getFastConfigEarfcn().getBase()+"-fastConfigEarfcn;,";
        str+=msg.getEutra_band().getBase()+"-eutra_band,";
        str+=msg.getDlEarfcn().getBase()+"-DlEarfcn,";
        str+=msg.getUlEarfcn().getBase()+"-UlEarfcn,";
        str+=msg.getFrameStrucureType().getBase()+"-FrameStrucureType,";
        str+=msg.getSubframeAssinment().getBase()+"-SubframeAssinment,";
        str+=msg.getSpecialSubframePatterns().getBase()+"-specialSubframePatterns;,";
        str+=msg.getDlBandWidth().getBase()+"-DlBandWidth;,";
        str+=msg.getUlBandWidth().getBase()+"-UlBandWidth;,";
        str+=msg.getRFchoice().getBase()+"-RFchoice,";
        str+=msg.getTX1PowerAttenuation().getBase()+"-TX1PowerAttenuation,";
        str+=msg.getTX2PowerAttenuation().getBase()+"-TX2PowerAttenuation,";
        textxianshi.setText(msg.getRfSysNo().getBase()+","+str);
        textxianshi.setTextSize(30);
    }
}
