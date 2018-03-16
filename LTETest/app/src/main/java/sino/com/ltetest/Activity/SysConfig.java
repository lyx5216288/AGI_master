package sino.com.ltetest.Activity;

import android.app.Activity;
import android.app.TabActivity;
import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.provider.SyncStateContract;
import android.view.MotionEvent;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.Spinner;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.security.PrivateKey;

import sino.com.ltetest.A2P_MSG.MSG.MSG_SYS_PARA;
import sino.com.ltetest.A2P_MSG.MSG.RECV_REDIRECT_R9;
import sino.com.ltetest.A2P_MSG.MSG.RECV_RF_PARA;
import sino.com.ltetest.A2P_MSG.MSG.RECV_SYS_OPTION;
import sino.com.ltetest.Constant.constant;
import sino.com.ltetest.Dao.SysConfig.SysConfigDao;
import sino.com.ltetest.R;
import sino.com.ltetest.type.U8;

/**
 * Created by 刘洋旭 on 2016/8/3.
 */
public class SysConfig extends Activity{

    //系统参数
    private EditText SysNo,Mcc,Pci,Tac,Cellid,Peri,Bsic,CarrierIN,PriorityIN,CarrierOUT,PriorityOUT,ReqNumIN
    ,ReqNumOUT,UENumOUT,UENumIN;
    private Spinner Mnc,RatIN,RatOUT,TAUIN,TAUOUT,ATTACHIN,ATTACHOUT;
    private CheckBox UEIN,UEOUT;

    //RF参数
    private EditText rf_sysno,pdh,dlpdh,ulpdh,dlpl,ulpl,udltime,speczhen,tx1pwd,tx2pwd;
    private CheckBox shepin,kspzpd;
    private Spinner zhentype,zhenjgtype,dldk,uldk;

    //SYS_OPTION参数
    private EditText so_sysno;
    private CheckBox getImei,getStmsi;


    //RECV_REDIRECT_R9参数
    private EditText msgtype,r9_cellid,lac;
    private CheckBox boolR9;



    private MSG_SYS_PARA  msg;
    private RECV_RF_PARA rfmsg;
    private RECV_SYS_OPTION sysopmsg;
    private RECV_REDIRECT_R9 R9msg;

    private SharedPreferences sharedPreferences,sharedPreferences1,sharedPreferences2,sharedPreferences3;

    //UI
    private TextView sysconfig,rfconfig,sysoptionconfig,redirctr9;
    private LinearLayout sysconfig1;
    private TextView Xiaoqu,Ib,Ob,Ibredirct,Obredirct;
    private RelativeLayout Xiaoqu1,Ib1,Ob1,Ibredirct1,Obredirct1,rfconfig1,sysoptionconfig1,redirctr91;
    private TextView send_sysconfig_button,send_RFconfig_button,send_sysopconfgi_button;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.config_layout);
        init();
        setUI();
        send_sysconfig_button= (TextView) findViewById(R.id.send_sysconfig_button);
        send_sysconfig_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sendSysConfig();
            }
        });
        send_RFconfig_button= (TextView) findViewById(R.id.send_rfconfig_button);
        send_RFconfig_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sendRFConfig();
            }
        });
        send_sysopconfgi_button= (TextView) findViewById(R.id.send_sysopconfgi_button);
        send_sysopconfgi_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {sendSysOptionConfig();
            }
        });


    }

    private void init(){

        findViewById(R.id.scroll).setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent motionEvent) {
                switch (v.getId()) {
                    case R.id.scroll:
                        InputMethodManager imm = (InputMethodManager)
                                getSystemService(Context.INPUT_METHOD_SERVICE);
                        imm.hideSoftInputFromWindow(v.getWindowToken(), 0);
                        break;
                }
                return false;
            }
        });

        //系统参数
        sharedPreferences = getSharedPreferences("sysconfig", Context.MODE_PRIVATE);
        SysConfigDao dao=new SysConfigDao();
        SysNo= (EditText) findViewById(R.id.sysno);
        SysNo.setText(sharedPreferences.getString("Sysno",""+dao.Sysno));
        Mcc= (EditText) findViewById(R.id.mcc);
        Mcc.setText(sharedPreferences.getString("Mcc",""+dao.Mcc));
        Pci= (EditText) findViewById(R.id.pci);
        Pci.setText(sharedPreferences.getString("Pcino",""+dao.Pcino));
        Tac= (EditText) findViewById(R.id.tac);
        Tac.setText(sharedPreferences.getString("Tac",""+dao.Tac));
        Cellid= (EditText) findViewById(R.id.cellid);
        Cellid.setText(sharedPreferences.getString("CellId",""+dao.CellId));
        Peri= (EditText) findViewById(R.id.peri);
        Peri.setText(sharedPreferences.getString("Peri",""+dao.Peri));
        Bsic= (EditText) findViewById(R.id.bsic);
        Bsic.setText(sharedPreferences.getString("redirectedCellIN",""+dao.redirectedCellIN));
        CarrierIN= (EditText) findViewById(R.id.carrier);
        CarrierIN.setText(sharedPreferences.getString("redirectedCarrierIN",""+dao.redirectedCarrierIN));
        CarrierOUT= (EditText) findViewById(R.id.carrier2);
        CarrierOUT.setText(sharedPreferences.getString("redirectedCarrierOUT",""+dao.redirectedCarrierOUT));
        PriorityOUT= (EditText) findViewById(R.id.priority2);
        PriorityOUT.setText(sharedPreferences.getString("PriorityOUT",""+dao.PriorityOUT));
        PriorityIN= (EditText) findViewById(R.id.priority);
        PriorityOUT.setText(sharedPreferences.getString("PriorityIN",""+dao.PriorityIN));
        ReqNumIN= (EditText) findViewById(R.id.kuneicount);
        ReqNumIN.setText(sharedPreferences.getString("ReqNumIN",""+dao.ReqNumIN));
        ReqNumOUT= (EditText) findViewById(R.id.kuwaicount);
        ReqNumOUT.setText(sharedPreferences.getString("ReqNumOUT",""+dao.ReqNumOUT));
        UENumOUT= (EditText) findViewById(R.id.kuwainengli);
        UENumOUT.setText(sharedPreferences.getString("UEcapaEnquiryNumOUT",""+dao.UEcapaEnquiryNumOUT));
        UENumIN= (EditText) findViewById(R.id.kuneinengli);
        UENumIN.setText(sharedPreferences.getString("UEcapaEnquiryNumIN",""+dao.UEcapaEnquiryNumIN));


        Mnc= (Spinner) findViewById(R.id.mnc);
        Mnc.setSelection(Integer.parseInt(sharedPreferences.getString("Mnc","0")));
        RatIN= (Spinner) findViewById(R.id.rat);
        RatIN.setSelection(Integer.parseInt(sharedPreferences.getString("RatIN","1")));
        RatOUT= (Spinner) findViewById(R.id.rat2);
        RatOUT.setSelection(Integer.parseInt(sharedPreferences.getString("RatOUT","0")));
        TAUIN= (Spinner) findViewById(R.id.inrefuseres);
        TAUIN.setSelection(Integer.parseInt(sharedPreferences.getString("TAUIN","6")));
        TAUOUT= (Spinner) findViewById(R.id.outrefuseres);
        TAUOUT.setSelection(Integer.parseInt(sharedPreferences.getString("TAUOUT","0")));
        ATTACHIN= (Spinner) findViewById(R.id.inattrefuseres);
        ATTACHIN.setSelection(Integer.parseInt(sharedPreferences.getString("ATTACHIN","0")));
        ATTACHOUT= (Spinner) findViewById(R.id.outattrefuseres);
        ATTACHOUT.setSelection(Integer.parseInt(sharedPreferences.getString("ATTACHOUT","0")));

        UEIN= (CheckBox) findViewById(R.id.inue);
        boolean bool;
        if(sharedPreferences.getString("UEIN","0").equals("0"))
        {bool=false;}else
        {bool=true;}
        UEIN.setChecked(bool);
        UEOUT= (CheckBox) findViewById(R.id.outue);
        boolean bool1;
        if(sharedPreferences.getString("UEOUT","0").equals("0"))
        {bool1=false;}else
        {bool1=true;}
        UEOUT.setChecked(bool1);



        //RF参数
        sharedPreferences1 = getSharedPreferences("rfconfig", Context.MODE_PRIVATE);
        rf_sysno= (EditText) findViewById(R.id.rf_sysno);
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

        rf_sysno.setText(sharedPreferences1.getString("sysno","1"));
        pdh.setText(sharedPreferences1.getString("pdh","40"));
        dlpdh.setText(sharedPreferences1.getString("dlpdh","38950"));
        ulpdh.setText(sharedPreferences1.getString("ulpdh","38950"));
        dlpl.setText(sharedPreferences1.getString("dlpl","2330"));
        ulpl.setText(sharedPreferences1.getString("ulpl","2330"));
        udltime.setText(sharedPreferences1.getString("udltime","1"));
        speczhen.setText(sharedPreferences1.getString("speczhen","7"));
        tx1pwd.setText(sharedPreferences1.getString("tx1pwd","1"));
        tx2pwd.setText(sharedPreferences1.getString("tx2pwd","1"));
        boolean bool11;
        if(sharedPreferences.getString("shepin","0").equals("0")){
            bool11=true;
        }else {
            bool11=false;
        }
        shepin.setChecked(bool11);

        boolean bool12;
        if(sharedPreferences.getString("kspzpd","0").equals("0")){
            bool12=true;
        }else {
            bool12=false;
        }
        kspzpd.setChecked(bool12);

        zhentype.setSelection(Integer.parseInt(sharedPreferences.getString("zhentype","1")));
        zhenjgtype.setSelection(Integer.parseInt(sharedPreferences.getString("zhenjgtype","0")));
        dldk.setSelection(Integer.parseInt(sharedPreferences.getString("dldk","5")));
        uldk.setSelection(Integer.parseInt(sharedPreferences.getString("uldk","5")));


        //SYS_OPTION参数
        sharedPreferences2 = getSharedPreferences("sysoptionconfig", Context.MODE_PRIVATE);
        so_sysno= (EditText) findViewById(R.id.so_sysno);
        getImei= (CheckBox) findViewById(R.id.getimei);
        getStmsi= (CheckBox) findViewById(R.id.getstmsi);

        so_sysno.setText(sharedPreferences2.getString("so_sysno","1"));

        boolean boolso1;
        if(sharedPreferences2.getString("getimei","1").equals("1")){
            boolso1=true;
        }else {
            boolso1=false;
        }
        getImei.setChecked(boolso1);

        boolean boolso2;
        if(sharedPreferences2.getString("getstmsi","1").equals("1")){
            boolso2=true;
        }else {
            boolso2=false;
        }
        getStmsi.setChecked(boolso2);

        //RECV_REDIRECT_R9参数
        msgtype= (EditText) findViewById(R.id.msgtype);
        r9_cellid= (EditText) findViewById(R.id.r9_cellid);
        lac= (EditText) findViewById(R.id.lac);
        boolR9= (CheckBox) findViewById(R.id.boolR9);

        sharedPreferences3  = getSharedPreferences("redirectR9config", Context.MODE_PRIVATE);

        msgtype.setText(sharedPreferences3.getString("msgtype",""));
        r9_cellid.setText(sharedPreferences3.getString("r9_cellid",""));
        lac.setText(sharedPreferences3.getString("lac",""));


        if(sharedPreferences3.getString("boolR9","0").equals("0")){
            boolR9.setChecked(false);
        }else {
            boolR9.setChecked(true);
        }




    }
    private void sendSysConfig(){
        msg=new MSG_SYS_PARA();
        msg.setParaSysNo(Integer.parseInt(SysNo.getText().toString()));
        sharedPreferences.edit().putString("Sysno",SysNo.getText().toString());
        U8[] mcc=new U8[3];
        for (int i=0;i<3;i++){
            if(i<2){
                mcc[i]=new U8(Integer.parseInt(Mcc.getText().toString().substring(i,i+1)));
            }else
            {
                mcc[i]=new U8(Integer.parseInt(Mcc.getText().toString().substring(i)));
            }
        }
        msg.setParaMcc(mcc);
        String strmcc="";
        for (U8 t:mcc){
            strmcc+=t.getBase();
        }
        sharedPreferences.edit().putString("Mcc",strmcc);

        U8[] mnc=new U8[2];
        mnc[0]=new U8(Integer.parseInt(Mnc.getSelectedItem().toString().substring(2,3)));
        mnc[1]=new U8(Integer.parseInt(Mnc.getSelectedItem().toString().substring(3)));
        msg.setParaMnc(mnc);
        String strmnc="";
        for (U8 t:mnc){
            strmnc+=t.getBase();
        }
        sharedPreferences.edit().putString("Mnc",strmnc);

        msg.setParaPciNo(Integer.parseInt(Pci.getText().toString()));
        sharedPreferences.edit().putString("Pcino",Pci.getText().toString());
        msg.setParaTac(Integer.parseInt(Tac.getText().toString()));
        sharedPreferences.edit().putString("Tac",Tac.getText().toString());
        msg.setPadding1(new U8[]{new U8(0),new U8(0)});
        msg.setPadding2(0);
        msg.setParaCellId(Integer.parseInt(Cellid.getText().toString()));
        sharedPreferences.edit().putString("CellId",Cellid.getText().toString());
        msg.setParaPeri(Integer.parseInt(Peri.getText().toString()));
        sharedPreferences.edit().putString("Peri",Peri.getText().toString());
        msg.setRedirectedCarrierOUT(Integer.parseInt(CarrierOUT.getText().toString()));
        sharedPreferences.edit().putString("redirectedCarrierOUT",CarrierOUT.getText().toString());
        msg.setRedirectedCarrierIN(Integer.parseInt(CarrierIN.getText().toString()));
        sharedPreferences.edit().putString("redirectedCarrierIN",CarrierIN.getText().toString());
        msg.setPriorityIN(Integer.parseInt(PriorityIN.getText().toString()));
        sharedPreferences.edit().putString("PriorityIN",PriorityIN.getText().toString());
        msg.setPriorityOUT(Integer.parseInt(PriorityOUT.getText().toString()));
        sharedPreferences.edit().putString("PriorityOUT",PriorityOUT.getText().toString());
        msg.setParaIdReqNumIN(Integer.parseInt(ReqNumIN.getText().toString()));
        sharedPreferences.edit().putString("ReqNumIN",ReqNumIN.getText().toString());
        msg.setParaIdReqNumOUT(Integer.parseInt(ReqNumOUT.getText().toString()));
        sharedPreferences.edit().putString("ReqNumOUT",ReqNumOUT.getText().toString());
        msg.setUEcapaEnquirYNumOUT(Integer.parseInt(UENumOUT.getText().toString()));
        sharedPreferences.edit().putString("UEcapaEnquiryNumOUT",UENumOUT.getText().toString());
        msg.setUEcapaEnquirYNumIN(Integer.parseInt(UENumIN.getText().toString()));
        sharedPreferences.edit().putString("UEcapaEnquiryNumIN",UENumIN.getText().toString());


        if(UEIN.isChecked()){
            msg.setBoolMeasureIN(1);
            sharedPreferences.edit().putString("UEIN","1");
        }else
        {
            msg.setBoolMeasureIN(0);
            sharedPreferences.edit().putString("UEIN","0");
        }

        if(UEOUT.isChecked()){
            msg.setBoolMeasureOUT(1);
            sharedPreferences.edit().putString("UEOUT","1");
        }else
        {
            msg.setBoolMeasureOUT(0);
            sharedPreferences.edit().putString("UEOUT","0");
        }




        msg.setRedirectedRATIN((int)(RatIN.getSelectedItemId()+1));
        sharedPreferences.edit().putString("RatIN",""+(RatIN.getSelectedItemId()+1));
        msg.setRedirectedRATOUT((int)(RatOUT.getSelectedItemId()+1));
        sharedPreferences.edit().putString("RatOUT",""+(RatIN.getSelectedItemId()+1));

        if((int)TAUIN.getSelectedItemId()==0){
            msg.setParaTAURejCauIN(2);
            sharedPreferences.edit().putString("TAUIN","2");
        }else if((int)TAUIN.getSelectedItemId()==1){
            msg.setParaTAURejCauIN(3);
            sharedPreferences.edit().putString("TAUIN","3");
        }else if((int)TAUIN.getSelectedItemId()==2){
            msg.setParaTAURejCauIN(5);
            sharedPreferences.edit().putString("TAUIN","5");
        }else if((int)TAUIN.getSelectedItemId()==3){
            msg.setParaTAURejCauIN(6);
            sharedPreferences.edit().putString("TAUIN","6");
        }else if((int)TAUIN.getSelectedItemId()==4){
            msg.setParaTAURejCauIN(11);
            sharedPreferences.edit().putString("TAUIN","11");
        }else if((int)TAUIN.getSelectedItemId()==5){
            msg.setParaTAURejCauIN(12);
            sharedPreferences.edit().putString("TAUIN","12");
        }else if((int)TAUIN.getSelectedItemId()==6){
            msg.setParaTAURejCauIN(13);
            sharedPreferences.edit().putString("TAUIN","13");
        }else if((int)TAUIN.getSelectedItemId()==7){
            msg.setParaTAURejCauIN(15);
            sharedPreferences.edit().putString("TAUIN","15");
        }else if((int)TAUIN.getSelectedItemId()==8){
            msg.setParaTAURejCauIN(17);
            sharedPreferences.edit().putString("TAUIN","17");
        }else if((int)TAUIN.getSelectedItemId()==9){
            msg.setParaTAURejCauIN(22);
            sharedPreferences.edit().putString("TAUIN","22");
        }

        if((int)TAUOUT.getSelectedItemId()==0){
            msg.setParaTAURejCauOUT(2);
            sharedPreferences.edit().putString("TAUOUT","2");
        }else if((int)TAUOUT.getSelectedItemId()==1){
            msg.setParaTAURejCauOUT(3);
            sharedPreferences.edit().putString("TAUOUT","3");
        }else if((int)TAUOUT.getSelectedItemId()==2){
            msg.setParaTAURejCauOUT(5);
            sharedPreferences.edit().putString("TAUOUT","5");
        }else if((int)TAUOUT.getSelectedItemId()==3){
            msg.setParaTAURejCauOUT(6);
            sharedPreferences.edit().putString("TAUOUT","6");
        }else if((int)TAUOUT.getSelectedItemId()==4){
            msg.setParaTAURejCauOUT(11);
            sharedPreferences.edit().putString("TAUOUT","11");
        }else if((int)TAUOUT.getSelectedItemId()==5){
            msg.setParaTAURejCauOUT(12);
            sharedPreferences.edit().putString("TAUOUT","12");
        }else if((int)TAUOUT.getSelectedItemId()==6){
            msg.setParaTAURejCauOUT(13);
            sharedPreferences.edit().putString("TAUOUT","13");
        }else if((int)TAUOUT.getSelectedItemId()==7){
            msg.setParaTAURejCauOUT(15);
            sharedPreferences.edit().putString("TAUOUT","15");
        }else if((int)TAUOUT.getSelectedItemId()==8){
            msg.setParaTAURejCauOUT(17);
            sharedPreferences.edit().putString("TAUOUT","17");
        }else if((int)TAUOUT.getSelectedItemId()==9){
            msg.setParaTAURejCauOUT(22);
            sharedPreferences.edit().putString("TAUOUT","22");
        }


        if((int)ATTACHIN.getSelectedItemId()==0){
            msg.setParaATTRejCauIN(2);
            sharedPreferences.edit().putString("ATTACHIN","2");
        }else if((int)ATTACHIN.getSelectedItemId()==1){
            msg.setParaATTRejCauIN(3);
            sharedPreferences.edit().putString("ATTACHIN","3");
        }else if((int)ATTACHIN.getSelectedItemId()==2){
            msg.setParaATTRejCauIN(5);
            sharedPreferences.edit().putString("ATTACHIN","5");
        }else if((int)ATTACHIN.getSelectedItemId()==3){
            msg.setParaATTRejCauIN(6);
            sharedPreferences.edit().putString("ATTACHIN","6");
        }else if((int)ATTACHIN.getSelectedItemId()==4){
            msg.setParaATTRejCauIN(11);
            sharedPreferences.edit().putString("ATTACHIN","11");
        }else if((int)ATTACHIN.getSelectedItemId()==5){
            msg.setParaATTRejCauIN(12);
            sharedPreferences.edit().putString("ATTACHIN","12");
        }else if((int)ATTACHIN.getSelectedItemId()==6){
            msg.setParaATTRejCauIN(13);
            sharedPreferences.edit().putString("ATTACHIN","13");
        }else if((int)ATTACHIN.getSelectedItemId()==7){
            msg.setParaATTRejCauIN(15);
            sharedPreferences.edit().putString("ATTACHIN","15");
        }else if((int)ATTACHIN.getSelectedItemId()==8){
            msg.setParaATTRejCauIN(17);
            sharedPreferences.edit().putString("ATTACHIN","17");
        }else if((int)ATTACHIN.getSelectedItemId()==9){
            msg.setParaATTRejCauIN(22);
            sharedPreferences.edit().putString("ATTACHIN","22");
        }


        if((int)ATTACHOUT.getSelectedItemId()==0){
            msg.setParaATTRejCauOUT(2);
            sharedPreferences.edit().putString("ATTACHOUT","2");
        }else if((int)ATTACHOUT.getSelectedItemId()==1){
            msg.setParaATTRejCauOUT(3);
            sharedPreferences.edit().putString("ATTACHOUT","3");
        }else if((int)ATTACHOUT.getSelectedItemId()==2){
            msg.setParaATTRejCauOUT(5);
            sharedPreferences.edit().putString("ATTACHOUT","5");
        }else if((int)ATTACHOUT.getSelectedItemId()==3){
            msg.setParaATTRejCauOUT(6);
            sharedPreferences.edit().putString("ATTACHOUT","6");
        }else if((int)ATTACHOUT.getSelectedItemId()==4){
            msg.setParaATTRejCauOUT(11);
            sharedPreferences.edit().putString("ATTACHOUT","11");
        }else if((int)ATTACHOUT.getSelectedItemId()==5){
            msg.setParaATTRejCauOUT(12);
            sharedPreferences.edit().putString("ATTACHOUT","12");
        }else if((int)ATTACHOUT.getSelectedItemId()==6){
            msg.setParaATTRejCauOUT(13);
            sharedPreferences.edit().putString("ATTACHOUT","13");
        }else if((int)ATTACHOUT.getSelectedItemId()==7){
            msg.setParaATTRejCauOUT(15);
            sharedPreferences.edit().putString("ATTACHOUT","15");
        }else if((int)ATTACHOUT.getSelectedItemId()==8){
            msg.setParaATTRejCauOUT(17);
            sharedPreferences.edit().putString("ATTACHOUT","17");
        }else if((int)ATTACHOUT.getSelectedItemId()==9){
            msg.setParaATTRejCauOUT(22);
            sharedPreferences.edit().putString("ATTACHOUT","22");
        }
        msg.setRedirectedCellIN(Integer.parseInt(Bsic.getText().toString()));
        sharedPreferences.edit().putString("redirectedCellIN",Bsic.getText().toString());
        sharedPreferences.edit().commit();
        //constant constant=new constant();
        constant.sysmsg=msg;
        startActivity(new Intent(SysConfig.this, TestMsgActivity.class));
    }
    private void setUI(){
        sysconfig= (TextView) findViewById(R.id.sysconfig);
        rfconfig= (TextView) findViewById(R.id.rfconfig);
        sysoptionconfig= (TextView) findViewById(R.id.sysoptionconfig);
        redirctr9= (TextView) findViewById(R.id.redirctr9);

        sysconfig1= (LinearLayout) findViewById(R.id.sysconfig1);
        rfconfig1= (RelativeLayout) findViewById(R.id.rfconfig1);
        sysoptionconfig1= (RelativeLayout) findViewById(R.id.sysoptionconfig1);
        redirctr91= (RelativeLayout) findViewById(R.id.redirctr91);

        sysconfig.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(sysconfig1.getVisibility()==View.VISIBLE){
                    sysconfig1.setVisibility(View.GONE);
                }else{
                    sysconfig1.setVisibility(View.VISIBLE);
                }
            }
        });
        rfconfig.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(rfconfig1.getVisibility()==View.VISIBLE){
                    rfconfig1.setVisibility(View.GONE);
                }else{
                    rfconfig1.setVisibility(View.VISIBLE);
                }
            }
        });
        sysoptionconfig.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(sysoptionconfig1.getVisibility()==View.VISIBLE){
                    sysoptionconfig1.setVisibility(View.GONE);
                }else{
                    sysoptionconfig1.setVisibility(View.VISIBLE);
                }
            }
        });
        redirctr9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(redirctr91.getVisibility()==View.VISIBLE){
                    redirctr91.setVisibility(View.GONE);
                }else{
                    redirctr91.setVisibility(View.VISIBLE);
                }
            }
        });


        Xiaoqu= (TextView) findViewById(R.id.xiaoquconfig);
        Ib= (TextView) findViewById(R.id.ibconfig);
        Ob= (TextView) findViewById(R.id.obconfig);
        Ibredirct= (TextView) findViewById(R.id.ibredirctconfig);
        Obredirct= (TextView) findViewById(R.id.obredirctconfig);
        Xiaoqu1= (RelativeLayout) findViewById(R.id.xiaoquconfig1);
        Ib1= (RelativeLayout) findViewById(R.id.ibconfig1);
        Ob1= (RelativeLayout) findViewById(R.id.obconfig1);
        Ibredirct1= (RelativeLayout) findViewById(R.id.ibredirctconfig1);
        Obredirct1= (RelativeLayout) findViewById(R.id.obredirctconfig1);
        Xiaoqu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(Xiaoqu1.getVisibility()==View.VISIBLE){
                    Xiaoqu1.setVisibility(View.GONE);
                }else{
                    Xiaoqu1.setVisibility(View.VISIBLE);
                }
            }
        });
        Ib.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(Ib1.getVisibility()==View.VISIBLE){
                    Ib1.setVisibility(View.GONE);
                }else{
                    Ib1.setVisibility(View.VISIBLE);
                }
            }
        });
        Ob.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(Ob1.getVisibility()==View.VISIBLE){
                    Ob1.setVisibility(View.GONE);
                }else{
                    Ob1.setVisibility(View.VISIBLE);
                }
            }
        });

        Ibredirct.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(Ibredirct1.getVisibility()==View.VISIBLE){
                    Ibredirct1.setVisibility(View.GONE);
                }else{
                    Ibredirct1.setVisibility(View.VISIBLE);
                }
            }
        });
        Obredirct.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(Obredirct1.getVisibility()==View.VISIBLE){
                    Obredirct1.setVisibility(View.GONE);
                }else{
                    Obredirct1.setVisibility(View.VISIBLE);
                }
            }
        });
    }

    private void sendSysOptionConfig(){
        sysopmsg=new RECV_SYS_OPTION();
        sysopmsg.setOpSysNo(Integer.parseInt(so_sysno.getText().toString()));
        if (getImei.isChecked()){
            sysopmsg.setOpLuImei(1);
            sharedPreferences2.edit().putString("getImei","1");
        }else{
            sysopmsg.setOpLuImei(0);
            sharedPreferences2.edit().putString("getImei","0");
        }

        if (getStmsi.isChecked()){
            sharedPreferences2.edit().putString("getStmsi","1");
            sysopmsg.setOpLuSTMSI(1);
        }else{
            sysopmsg.setOpLuSTMSI(0);
            sharedPreferences2.edit().putString("getStmsi","0");
        }
        sharedPreferences2.edit().putString("so_sysno",so_sysno.getText().toString());
        sharedPreferences2.edit().commit();
        constant.sysoptionmsg=sysopmsg;
        startActivity(new Intent(SysConfig.this, TestRFMsgActivity.class));


    }

    private void sendRedirctR9Config(){
        R9msg=new RECV_REDIRECT_R9();



    }
    private void sendRFConfig(){
        rfmsg=new RECV_RF_PARA();
        rfmsg.setRfSysNo(Integer.parseInt(rf_sysno.getText().toString()));
        sharedPreferences1.edit().putString("sysno",rf_sysno.getText().toString());
        if (shepin.isChecked()){
            rfmsg.setRfEnable(1);
            sharedPreferences1.edit().putString("shepin","1");
        }else{
            rfmsg.setRfEnable(0);
            sharedPreferences1.edit().putString("shepin","0");
        }

        if (kspzpd.isChecked()){
            rfmsg.setFastConfigEarfcn(1);
            sharedPreferences1.edit().putString("kspzpd","1");
        }else{
            rfmsg.setFastConfigEarfcn(0);
            sharedPreferences1.edit().putString("kspzpd","0");

        }
        rfmsg.setEutra_band(Integer.parseInt(pdh.getText().toString()));
        sharedPreferences1.edit().putString("pdh",pdh.getText().toString());
        rfmsg.setDlEarfcn(Integer.parseInt(dlpdh.getText().toString()));
        sharedPreferences1.edit().putString("dlpdh",dlpdh.getText().toString());
        rfmsg.setUlEarfcn(Integer.parseInt(ulpdh.getText().toString()));
        sharedPreferences1.edit().putString("ulpdh",ulpdh.getText().toString());
        rfmsg.setSubframeAssinment(Integer.parseInt(udltime.getText().toString()));
        sharedPreferences1.edit().putString("udltime",udltime.getText().toString());
        rfmsg.setSpecialSubframePatterns(Integer.parseInt(speczhen.getText().toString()));
        sharedPreferences1.edit().putString("speczhen",speczhen.getText().toString());
        rfmsg.setFrameStrucureType((int)(zhenjgtype.getSelectedItemId()));
        sharedPreferences1.edit().putString("pzhenjgtypedh",zhenjgtype.getSelectedItemId()+"");
        if((int)uldk.getSelectedItemId()==0){
            rfmsg.setUlBandWidth(6);
        }else if((int)uldk.getSelectedItemId()==1){
            rfmsg.setUlBandWidth(15);
        }else{
            rfmsg.setUlBandWidth(25*((int)uldk.getSelectedItemId()-1));

        }
        sharedPreferences1.edit().putString("uldk",uldk.getSelectedItemId()+"");
        if((int)dldk.getSelectedItemId()==0){
            rfmsg.setDlBandWidth(6);
        }else if((int)dldk.getSelectedItemId()==1){
            rfmsg.setDlBandWidth(15);
        }else{
            rfmsg.setDlBandWidth(25*((int)dldk.getSelectedItemId()-1));
        }
        sharedPreferences1.edit().putString("dldk",uldk.getSelectedItemId()+"");
        rfmsg.setTX1PowerAttenuation(Integer.parseInt(tx1pwd.getText().toString()));
        sharedPreferences1.edit().putString("tx1pwd",tx1pwd.getText().toString());
        rfmsg.setTX2PowerAttenuation(Integer.parseInt(tx2pwd.getText().toString()));
        sharedPreferences1.edit().putString("tx2pwd",tx2pwd.getText().toString());

        rfmsg.setRFchoice((int)zhentype.getSelectedItemId());
        sharedPreferences1.edit().putString("zhentype",zhentype.getSelectedItemId()+"");
        sharedPreferences1.edit().commit();

        constant.rfmsg=rfmsg;
        startActivity(new Intent(SysConfig.this, TestRFMsgActivity.class));
    }

}
