package sino.com.ltetest.A2P_MSG.MSG;

import android.renderscript.Int2;

import sino.com.ltetest.MsgSendHelper;
import sino.com.ltetest.type.U16;
import sino.com.ltetest.type.U8;

/**
 * Created by 刘洋旭 on 2016/7/27.
 */
public class RECV_REDIRECT_R9 {
    private U8   BoolR9;
    private U8   MsgType;
    private U16  CellID;
    private U16  LAC;
    private U8   MSCR;
    private U8   ba_ag_blks_res;
    private U8   ccch_conf;
    private U8   bs_pa_mfrms;
    private U8   T3412_value;
    private U8   pwrc;
    private U8   DTX;
    private U8   radio_link_timeout;
    private U8   MsTxPwrMaxCch;
    private U8   Neci;
    private U8   RxlevAccessMin;
    private U8   RachMax_retrans;
    private U8   RachTx_int;
    private U8   CelllReselOffset;

    public static final int byteArrayLen =16*U8.byteArrayLen+2*U16.byteArrayLen;

    public U8 getBoolR9() {
        return BoolR9;
    }

    public void setBoolR9(int boolR9) {
        BoolR9 = new U8(boolR9);
    }

    public U8 getMsgType() {
        return MsgType;
    }

    public void setMsgType(int msgType) {
        MsgType = new U8(msgType);
    }

    public U16 getCellID() {
        return CellID;
    }

    public void setCellID(int cellID) {
        CellID = new U16(cellID);
    }

    public U16 getLAC() {
        return LAC;
    }

    public void setLAC(int LAC) {
        this.LAC = new U16(LAC);
    }

    public U8 getMSCR() {
        return MSCR;
    }

    public void setMSCR(int MSCR) {
        this.MSCR = new U8(MSCR);
    }

    public U8 getBa_ag_blks_res() {
        return ba_ag_blks_res;
    }

    public void setBa_ag_blks_res(int ba_ag_blks_res) {
        this.ba_ag_blks_res = new U8(ba_ag_blks_res);
    }

    public U8 getCcch_conf() {
        return ccch_conf;
    }

    public void setCcch_conf(int ccch_conf) {
        this.ccch_conf = new U8(ccch_conf);
    }

    public U8 getBs_pa_mfrms() {
        return bs_pa_mfrms;
    }

    public void setBs_pa_mfrms(int bs_pa_mfrms) {
        this.bs_pa_mfrms = new U8(bs_pa_mfrms);
    }

    public U8 getT3412_value() {
        return T3412_value;
    }

    public void setT3412_value(int t3412_value) {
        T3412_value = new U8(t3412_value);
    }

    public U8 getPwrc() {
        return pwrc;
    }

    public void setPwrc(int pwrc) {
        this.pwrc = new U8(pwrc);
    }

    public U8 getDTX() {
        return DTX;
    }

    public void setDTX(int DTX) {
        this.DTX = new U8(DTX);
    }

    public U8 getRadio_link_timeout() {
        return radio_link_timeout;
    }

    public void setRadio_link_timeout(int radio_link_timeout) {
        this.radio_link_timeout = new U8(radio_link_timeout);
    }

    public U8 getMsTxPwrMaxCch() {
        return MsTxPwrMaxCch;
    }

    public void setMsTxPwrMaxCch(int msTxPwrMaxCch) {
        MsTxPwrMaxCch = new U8(msTxPwrMaxCch);
    }

    public U8 getNeci() {
        return Neci;
    }

    public void setNeci(int neci) {
        Neci = new U8(neci);
    }

    public U8 getRxlevAccessMin() {
        return RxlevAccessMin;
    }

    public void setRxlevAccessMin(int rxlevAccessMin) {
        RxlevAccessMin = new U8(rxlevAccessMin);
    }

    public U8 getRachMax_retrans() {
        return RachMax_retrans;
    }

    public void setRachMax_retrans(int rachMax_retrans) {
        RachMax_retrans = new U8(rachMax_retrans);
    }

    public U8 getRachTx_int() {
        return RachTx_int;
    }

    public void setRachTx_int(int rachTx_int) {
        RachTx_int = new U8(rachTx_int);
    }

    public U8 getCelllReselOffset() {
        return CelllReselOffset;
    }

    public void setCelllReselOffset(int celllReselOffset) {
        CelllReselOffset = new U8(celllReselOffset);
    }

    public RECV_REDIRECT_R9(){
        this.BoolR9=new U8();
        this.MsgType=new U8();
        this.CellID=new U16();
        this.LAC=new U16();
        this.MSCR=new U8();
        this.ba_ag_blks_res=new U8();
        this.ccch_conf=new U8();
        this.bs_pa_mfrms=new U8();
        this.T3412_value=new U8();
        this.pwrc=new U8();
        this.DTX=new U8();
        this.radio_link_timeout=new U8();
        this.MsTxPwrMaxCch=new U8();
        this.Neci=new U8();
        this.RxlevAccessMin=new U8();
        this.RachMax_retrans=new U8();
        this.RachTx_int=new U8();
        this.CelllReselOffset=new U8();
    }
    public RECV_REDIRECT_R9(byte[] bytes){
        validate(bytes);
        int pos = 0;
        this.BoolR9 = new U8(MsgSendHelper.getSubByteArray(bytes, pos, U8.byteArrayLen));
        pos += U8.byteArrayLen;
        this.MsgType = new U8(MsgSendHelper.getSubByteArray(bytes, pos, U8.byteArrayLen));
        pos += U8.byteArrayLen;
        this.CellID = new U16(MsgSendHelper.getSubByteArray(bytes, pos, U16.byteArrayLen));
        pos += U16.byteArrayLen;
        this.LAC = new U16(MsgSendHelper.getSubByteArray(bytes, pos, U16.byteArrayLen));
        pos += U16.byteArrayLen;
        this.MSCR = new U8(MsgSendHelper.getSubByteArray(bytes, pos, U8.byteArrayLen));
        pos += U8.byteArrayLen;
        this.ba_ag_blks_res = new U8(MsgSendHelper.getSubByteArray(bytes, pos, U8.byteArrayLen));
        pos += U8.byteArrayLen;
        this.ccch_conf = new U8(MsgSendHelper.getSubByteArray(bytes, pos, U8.byteArrayLen));
        pos += U8.byteArrayLen;
        this.bs_pa_mfrms = new U8(MsgSendHelper.getSubByteArray(bytes, pos, U8.byteArrayLen));
        pos += U8.byteArrayLen;
        this.T3412_value = new U8(MsgSendHelper.getSubByteArray(bytes, pos, U8.byteArrayLen));
        pos += U8.byteArrayLen;
        this.pwrc = new U8(MsgSendHelper.getSubByteArray(bytes, pos, U8.byteArrayLen));
        pos += U8.byteArrayLen;
        this.DTX = new U8(MsgSendHelper.getSubByteArray(bytes, pos, U8.byteArrayLen));
        pos += U8.byteArrayLen;
        this.radio_link_timeout = new U8(MsgSendHelper.getSubByteArray(bytes, pos, U8.byteArrayLen));
        pos += U8.byteArrayLen;
        this.MsTxPwrMaxCch = new U8(MsgSendHelper.getSubByteArray(bytes, pos, U8.byteArrayLen));
        pos += U8.byteArrayLen;
        this.Neci = new U8(MsgSendHelper.getSubByteArray(bytes, pos, U8.byteArrayLen));
        pos += U8.byteArrayLen;
        this.RxlevAccessMin = new U8(MsgSendHelper.getSubByteArray(bytes, pos, U8.byteArrayLen));
        pos += U8.byteArrayLen;
        this.RachMax_retrans = new U8(MsgSendHelper.getSubByteArray(bytes, pos, U8.byteArrayLen));
        pos += U8.byteArrayLen;
        this.RachTx_int = new U8(MsgSendHelper.getSubByteArray(bytes, pos, U8.byteArrayLen));
        pos += U8.byteArrayLen;
        this.CelllReselOffset = new U8(MsgSendHelper.getSubByteArray(bytes, pos, U8.byteArrayLen));
        pos += U8.byteArrayLen;

    }

    public byte[] getBytes(){
        MsgSendHelper.AppendByteArray ret = new MsgSendHelper.AppendByteArray();
        ret.append(BoolR9.getBytes())
                .append(MsgType.getBytes())
                .append(CellID.getBytes())
                .append(LAC.getBytes())
                .append(MSCR.getBytes())
                .append(ba_ag_blks_res.getBytes())
                .append(ccch_conf.getBytes())
                .append(bs_pa_mfrms.getBytes())
                .append(T3412_value.getBytes())
                .append(pwrc.getBytes())
                .append(DTX.getBytes())
                .append(radio_link_timeout.getBytes())
                .append(MsTxPwrMaxCch.getBytes())
                .append(Neci.getBytes())
                .append(RxlevAccessMin.getBytes())
                .append(RachMax_retrans.getBytes())
                .append(RachTx_int.getBytes())
                .append(CelllReselOffset.getBytes());
        return ret.toByteArray();
    }

    private void validate(byte[] bytes) {
        if (bytes.length < RECV_REDIRECT_R9.byteArrayLen) {
            throw new IllegalArgumentException("byte array is not message RECV_REDIRECT_R9!");
        }
    }


}
