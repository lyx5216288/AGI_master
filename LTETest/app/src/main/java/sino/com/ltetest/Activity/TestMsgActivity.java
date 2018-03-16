package sino.com.ltetest.Activity;

import android.app.Activity;
import android.os.Bundle;
import android.provider.SyncStateContract;
import android.widget.TextView;

import sino.com.ltetest.A2P_MSG.MSG.MSG_SYS_PARA;
import sino.com.ltetest.Constant.constant;
import sino.com.ltetest.R;
import sino.com.ltetest.type.U8;

/**
 * Created by 刘洋旭 on 2016/8/17.
 */
public class TestMsgActivity extends Activity {

    private TextView textxianshi;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.textmsglayout);
        textxianshi= (TextView) findViewById(R.id.textxianshi);
        MSG_SYS_PARA  msg=new MSG_SYS_PARA(constant.sysmsg.getBytes());
        String str="";
        for(U8 t:msg.getParaMcc()){
            str+=t.getBase();
        }str+="-mcc,";
        for(U8 t:msg.getParaMnc()){
            str+=t.getBase();
        }
        str+="-mnc,";

        str+=msg.getParaPciNo().getBase()+"-pcino,";
        str+=msg.getParaTac().getBase()+"-tac,";
        for(U8 t:msg.getPadding1()){
            str+=t.getBase();
        }str+="-padding1,";
        str+=msg.getParaCellId().getBase()+"-cellid,";
        str+=msg.getParaPeri().getBase()+"-peri,";
        str+=msg.getParaIdReqNumOUT().getBase()+"-reqout,";
        str+=msg.getParaIdReqNumIN().getBase()+"-reqin,";
        str+=msg.getUEcapaEnquirYNumOUT().getBase()+"-uecapout,";
        str+=msg.getUEcapaEnquirYNumIN().getBase()+"-uecapin,";
        str+=msg.getBoolMeasureOUT().getBase()+",-boolmeaout";
        str+=msg.getBoolMeasureIN().getBase()+"-boolmeain,";
        str+=msg.getParaTAURejCauOUT().getBase()+"-tauout,";
        str+=msg.getParaTAURejCauIN().getBase()+"-tauin,";
        str+=msg.getParaATTRejCauOUT().getBase()+"-attrout,";
        str+=msg.getParaATTRejCauIN().getBase()+"-attrin,";
        str+=msg.getRedirectedRATOUT().getBase()+"-ratout,";
        str+=msg.getPadding2().getBase()+"-padding2,";
        str+=msg.getRedirectedCarrierOUT().getBase()+"-carrierout,";
        str+=msg.getPriorityOUT().getBase()+"-prioout,";
        str+=msg.getRedirectedRATIN().getBase()+"-ratin,";
        str+=msg.getRedirectedCarrierIN().getBase()+"-carrierin,";
        str+=msg.getPriorityIN().getBase()+"periin,";
        str+=msg.getRedirectedCellIN().getBase()+"-cellin,";
        textxianshi.setText(msg.getParaSysNo().getBase()+","+str);
        textxianshi.setTextSize(30);



    }
}
