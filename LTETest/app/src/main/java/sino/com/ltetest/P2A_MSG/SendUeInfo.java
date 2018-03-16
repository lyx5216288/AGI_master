package sino.com.ltetest.P2A_MSG;

import sino.com.ltetest.MsgSendHelper;
import sino.com.ltetest.type.U16;
import sino.com.ltetest.type.U8;

/**
 * Created by 刘洋旭 on 2016/7/28.
 */
public class SendUeInfo {

    private U16 ueSysNo;
    private U16 ueSendNo;
    private U8[] CurrentMcc; //size=3
    private U8[] CurrentMnc; //size=2
    private U8 padding;
    private U16 CurrentTac;
    private char ueImsi; //size=16;
    private char ueImei; //size=16;
    private char ueSTmsi; //size=12;
    private U8[] ueMsisdn; //size=4;
    private  U8 ueType;
    private  U8 ueTaType;
    private  U8[] ueTaTime;  //size=19;
    private U8 uePwrNo;
    private U8[] uePwr; //size=100;

    public static final int byteArrayLen=3*U16.byteArrayLen+(4+3+2+4+19+100)*U8.byteArrayLen+32+32+24;


    public U16 getUeSysNo() {
        return ueSysNo;
    }

    public void setUeSysNo(int ueSysNo) {
        this.ueSysNo = new U16(ueSysNo);
    }

    public U16 getUeSendNo() {
        return ueSendNo;
    }

    public void setUeSendNo(int ueSendNo) {
        this.ueSendNo = new U16(ueSendNo);
    }

    public U8[] getCurrentMcc() {
        return CurrentMcc;
    }

    public void setCurrentMcc(U8[] currentMcc) {
        CurrentMcc =currentMcc;
    }

    public U8[] getCurrentMnc() {
        return CurrentMnc;
    }

    public void setCurrentMnc(U8[] currentMnc) {
        CurrentMnc = currentMnc;
    }

    public U8 getPadding() {
        return padding;
    }

    public void setPadding(int padding) {
        this.padding = new U8(padding);
    }

    public U16 getCurrentTac() {
        return CurrentTac;
    }

    public void setCurrentTac(int currentTac) {
        CurrentTac = new U16(currentTac);
    }

    public char getUeImsi() {
        return ueImsi;
    }

    public void setUeImsi(char ueImsi) {
        this.ueImsi = ueImsi;
    }

    public char getUeImei() {
        return ueImei;
    }

    public void setUeImei(char ueImei) {
        this.ueImei = ueImei;
    }

    public char getUeSTmsi() {
        return ueSTmsi;
    }

    public void seteSTmsi(char eSTmsi) {
        this.ueSTmsi = eSTmsi;
    }

    public U8[] getUeMsisdn() {
        return ueMsisdn;
    }

    public void setUeMsisdn(U8[] ueMsisdn) {
        this.ueMsisdn = ueMsisdn;
    }

    public U8 getUeType() {
        return ueType;
    }

    public void setUeType(int ueType) {
        this.ueType = new U8(ueType);
    }

    public U8 getUeTaType() {
        return ueTaType;
    }

    public void setUeTaType(int ueTaType) {
        this.ueTaType = new U8(ueTaType);
    }

    public U8[] getUeTaTime() {
        return ueTaTime;
    }

    public void setUeTaTime(U8[] ueTaTime) {
        this.ueTaTime = ueTaTime;
    }

    public U8 getUePwrNo() {
        return uePwrNo;
    }

    public void setUePwrNo(int uePwrNo) {
        this.uePwrNo = new U8(uePwrNo);
    }

    public U8[] getUePwr() {
        return uePwr;
    }

    public void setUePwr(U8[] uePwr) {
        this.uePwr = uePwr;
    }

    public SendUeInfo(byte[] bytes){
        validate(bytes);
        int pos = 0;
        this.ueSysNo = new U16(MsgSendHelper.getSubByteArray(bytes, pos, U16.byteArrayLen));
        pos += U16.byteArrayLen;
        this.ueSendNo = new U16(MsgSendHelper.getSubByteArray(bytes, pos, U16.byteArrayLen));
        pos += U16.byteArrayLen;
        this.CurrentMcc = new U8[3];
        this.CurrentMcc[0]=new U8(MsgSendHelper.getSubByteArray(bytes, pos, U8.byteArrayLen));
        pos += U8.byteArrayLen;
        this.CurrentMcc[1]=new U8(MsgSendHelper.getSubByteArray(bytes, pos, U8.byteArrayLen));
        pos += U8.byteArrayLen;
        this.CurrentMcc[2]=new U8(MsgSendHelper.getSubByteArray(bytes, pos, U8.byteArrayLen));
        pos += U8.byteArrayLen;
        this.CurrentMnc=new U8[2];
        this.CurrentMnc[0]=new U8(MsgSendHelper.getSubByteArray(bytes, pos, U8.byteArrayLen));
        pos += U8.byteArrayLen;
        this.CurrentMnc[1]=new U8(MsgSendHelper.getSubByteArray(bytes, pos, U8.byteArrayLen));
        pos += U8.byteArrayLen;
        this.padding=new U8(MsgSendHelper.getSubByteArray(bytes, pos, U8.byteArrayLen));
        pos += U8.byteArrayLen;
        this.CurrentTac=new U16(MsgSendHelper.getSubByteArray(bytes, pos, U16.byteArrayLen));
        pos += U16.byteArrayLen;
        for (int i=0;i<16;i++){
            this.ueImsi= (char) (this.ueImsi+(char) (((bytes[pos] & 0xFF) << 8) | (bytes[pos+1] & 0xFF)));
            pos+=2;
        }

        for (int i=0;i<16;i++){
            this.ueImei= (char) (this.ueImei+(char) (((bytes[pos] & 0xFF) << 8) | (bytes[pos+1] & 0xFF)));
            pos+=2;
        }
        for (int i=0;i<12;i++){
            this.ueSTmsi= (char) (this.ueSTmsi+(char) (((bytes[pos] & 0xFF) << 8) | (bytes[pos+1] & 0xFF)));
            pos+=2;
        }

        this.ueMsisdn = new U8[4];
        this.ueMsisdn[0]=new U8(MsgSendHelper.getSubByteArray(bytes, pos, U8.byteArrayLen));
        pos += U8.byteArrayLen;
        this.ueMsisdn[1]=new U8(MsgSendHelper.getSubByteArray(bytes, pos, U8.byteArrayLen));
        pos += U8.byteArrayLen;
        this.ueMsisdn[2]=new U8(MsgSendHelper.getSubByteArray(bytes, pos, U8.byteArrayLen));
        pos += U8.byteArrayLen;
        this.ueMsisdn[3]=new U8(MsgSendHelper.getSubByteArray(bytes, pos, U8.byteArrayLen));
        pos += U8.byteArrayLen;

        this.ueType=new U8(MsgSendHelper.getSubByteArray(bytes, pos, U8.byteArrayLen));
        pos += U8.byteArrayLen;
        this.ueTaType=new U8(MsgSendHelper.getSubByteArray(bytes, pos, U8.byteArrayLen));
        pos += U8.byteArrayLen;

        this.ueTaTime=new U8[19];
        for(int i=0;i<19;i++){
            this.ueTaTime[i]=new U8(MsgSendHelper.getSubByteArray(bytes, pos, U8.byteArrayLen));
            pos += U8.byteArrayLen;
        }

        this.uePwrNo=new U8(MsgSendHelper.getSubByteArray(bytes, pos, U8.byteArrayLen));
        pos += U8.byteArrayLen;

        this.uePwr=new U8[100];
        for(int i=0;i<100;i++){
            this.uePwr[i]=new U8(MsgSendHelper.getSubByteArray(bytes, pos, U8.byteArrayLen));
            pos += U8.byteArrayLen;
        }
    }



    private void validate(byte[] bytes) {
        if (bytes.length < SendUeInfo.byteArrayLen) {
            throw new IllegalArgumentException("byte array is not message PLMNID_STRU!");
        }
    }


}
