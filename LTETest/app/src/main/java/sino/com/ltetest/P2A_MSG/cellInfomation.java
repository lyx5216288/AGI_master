package sino.com.ltetest.P2A_MSG;

import sino.com.ltetest.MsgSendHelper;
import sino.com.ltetest.type.U16;
import sino.com.ltetest.type.U8;

/**
 * Created by 刘洋旭 on 2016/8/1.
 */
public class cellInfomation {

    private U8 SysNo;
    private U8 Mcc;
    private U8 Mnc;
    private U16 Tac;
    private U16 PciNo;
    private U8[] CellId;  //size=7;
    private U16 Earfcn;
    private U8 CP_Type;
    private U16 Crs_RP;
    private U16 Crs_RQ;

    public static final int byteArrayLen=11*U8.byteArrayLen+5*U16.byteArrayLen;

    public U8 getSysNo() {
        return SysNo;
    }

    public void setSysNo(int sysNo) {
        SysNo = new U8(sysNo);
    }

    public U8 getMcc() {
        return Mcc;
    }

    public void setMcc(int mcc) {
        Mcc = new U8(mcc);
    }

    public U8 getMnc() {
        return Mnc;
    }

    public void setMnc(int mnc) {
        Mnc = new U8(mnc);
    }

    public U16 getTac() {
        return Tac;
    }

    public void setTac(int tac) {
        Tac = new U16(tac);
    }

    public U16 getPciNo() {
        return PciNo;
    }

    public void setPciNo(int pciNo) {
        PciNo = new U16(pciNo);
    }

    public U8[] getCellId() {
        return CellId;
    }

    public void setCellId(U8[] cellId) {
        CellId = cellId;
    }

    public U16 getEarfcn() {
        return Earfcn;
    }

    public void setEarfcn(int earfcn) {
        Earfcn = new U16(earfcn);
    }

    public U8 getCP_Type() {
        return CP_Type;
    }

    public void setCP_Type(int CP_Type) {
        this.CP_Type = new U8(CP_Type);
    }

    public U16 getCrs_RP() {
        return Crs_RP;
    }

    public void setCrs_RP(int crs_RP) {
        Crs_RP = new U16(crs_RP);
    }

    public U16 getCrs_RQ() {
        return Crs_RQ;
    }

    public void setCrs_RQ(int crs_RQ) {
        Crs_RQ = new U16(crs_RQ);
    }


    public cellInfomation(byte[] bytes) {
        validate(bytes);
        int pos = 0;
        this.SysNo = new U8(MsgSendHelper.getSubByteArray(bytes, pos, U8.byteArrayLen));
        pos += U8.byteArrayLen;
        this.Mcc = new U8(MsgSendHelper.getSubByteArray(bytes, pos, U8.byteArrayLen));
        pos += U8.byteArrayLen;
        this.Mnc = new U8(MsgSendHelper.getSubByteArray(bytes, pos, U8.byteArrayLen));
        pos += U8.byteArrayLen;
        this.Tac = new U16(MsgSendHelper.getSubByteArray(bytes, pos, U8.byteArrayLen));
        pos += U16.byteArrayLen;
        this.PciNo = new U16(MsgSendHelper.getSubByteArray(bytes, pos, U8.byteArrayLen));
        pos += U16.byteArrayLen;
        for (int i=0;i<7;i++){
            this.CellId[i]= new U8(MsgSendHelper.getSubByteArray(bytes, pos, U8.byteArrayLen));
            pos += U8.byteArrayLen;
        }
        this.Earfcn  = new U16(MsgSendHelper.getSubByteArray(bytes, pos, U8.byteArrayLen));
        pos += U16.byteArrayLen;

        this.CP_Type = new U8(MsgSendHelper.getSubByteArray(bytes, pos, U8.byteArrayLen));
        pos += U8.byteArrayLen;
        this.Crs_RP  = new U16(MsgSendHelper.getSubByteArray(bytes, pos, U8.byteArrayLen));
        pos += U16.byteArrayLen;
        this.Crs_RQ  = new U16(MsgSendHelper.getSubByteArray(bytes, pos, U8.byteArrayLen));
        pos += U16.byteArrayLen;


    }

    private void validate(byte[] bytes) {
        if (bytes.length < SendUeInfo.byteArrayLen) {
            throw new IllegalArgumentException("byte array is not message PLMNID_STRU!");
        }
    }
}
