package sino.com.ltetest.A2P_MSG.MSG;

import sino.com.ltetest.MsgSendHelper;
import sino.com.ltetest.type.U16;
import sino.com.ltetest.type.U8;

/**
 * Created by 刘洋旭 on 2016/7/20.
 */
public class RECV_SYS_OPTION {

    private U16 opSysNo;
    private U8 opLuImei;
    private U8 opLuSTMSI;

    public static final int byteArrayLen =U16.byteArrayLen+2*U8.byteArrayLen;

    private void validate(byte[] bytes) {
        if (bytes.length < RECV_SYS_OPTION.byteArrayLen) {
            throw new IllegalArgumentException("byte array is not message RECV_SYS_OPTION!");
        }
    }

    public U16 getOpSysNo() {
        return opSysNo;
    }

    public void setOpSysNo(int opSysNo) {
        this.opSysNo = new U16(opSysNo);
    }

    public U8 getOpLuImei() {
        return opLuImei;
    }

    public void setOpLuImei(int opLuImei) {
        this.opLuImei = new U8(opLuImei);
    }

    public U8 getOpLuSTMSI() {
        return opLuSTMSI;
    }

    public void setOpLuSTMSI(int opLuSTMSI) {
        this.opLuSTMSI = new U8(opLuSTMSI);
    }

    public RECV_SYS_OPTION(){
        this.opSysNo=new U16();
        this.opLuImei=new U8();
        this.opLuSTMSI=new U8();
    }

    public RECV_SYS_OPTION(byte[] bytes ){
        validate(bytes);
        int pos = 0;
        this.opSysNo = new U16(MsgSendHelper.getSubByteArray(bytes, pos, U16.byteArrayLen));
        pos += U16.byteArrayLen;
        this.opLuImei = new U8(MsgSendHelper.getSubByteArray(bytes, pos, U8.byteArrayLen));
        pos += U8.byteArrayLen;
        this.opLuSTMSI = new U8(MsgSendHelper.getSubByteArray(bytes, pos, U8.byteArrayLen));
        pos += U8.byteArrayLen;
    }

    public byte[] getBytes(){
        MsgSendHelper.AppendByteArray ret = new MsgSendHelper.AppendByteArray();
        ret.append(opSysNo.getBytes())
                .append(opLuImei.getBytes())
                .append(opLuSTMSI.getBytes());
        return ret.toByteArray();
    }
}
