package sino.com.ltetest.P2A_MSG;

import sino.com.ltetest.MsgSendHelper;
import sino.com.ltetest.type.U16;
import sino.com.ltetest.type.U8;

/**
 * Created by 刘洋旭 on 2016/7/29.
 */
public class SendFreq {   //设备返回时先返回此结构体
    private U8 sysNo;
    private U16 earfcn;  //频点

    public U8 getSysNo() {
        return sysNo;
    }

    public void setSysNo(int sysNo) {
        this.sysNo = new U8(sysNo);
    }

    public U16 getEarfcn() {
        return earfcn;
    }

    public void setEarfcn(int earfcn) {
        this.earfcn = new U16(earfcn);
    }

    public SendFreq(byte[] bytes) {
        validate(bytes);
        int pos = 0;
        this.sysNo = new U8(MsgSendHelper.getSubByteArray(bytes, pos, U8.byteArrayLen));
        pos += U8.byteArrayLen;
        this.earfcn = new U16(MsgSendHelper.getSubByteArray(bytes, pos, U16.byteArrayLen));
        pos += U16.byteArrayLen;


    }

    private void validate(byte[] bytes) {
        if (bytes.length < SendUeInfo.byteArrayLen) {
            throw new IllegalArgumentException("byte array is not message PLMNID_STRU!");
        }
    }
}
