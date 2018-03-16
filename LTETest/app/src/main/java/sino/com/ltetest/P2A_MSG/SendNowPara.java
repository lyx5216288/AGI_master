package sino.com.ltetest.P2A_MSG;

import sino.com.ltetest.MsgSendHelper;
import sino.com.ltetest.type.U16;
import sino.com.ltetest.type.U8;

/**
 * Created by 刘洋旭 on 2016/7/29.
 */
public class SendNowPara {
    private U8 nowSysNo;
    private U16 nowType;
    private U8[] nowPara;//size=100

    public U8 getNowSysNo() {
        return nowSysNo;
    }

    public void setNowSysNo(int nowSysNo) {
        this.nowSysNo = new U8(nowSysNo);
    }

    public U16 getNowType() {
        return nowType;
    }

    public void setNowType(int nowType) {
        this.nowType = new U16(nowType);
    }

    public U8[] getNowPara() {
        return nowPara;
    }

    public void setNowPara(U8[] nowPara) {
        this.nowPara = nowPara;
    }

    public SendNowPara(byte[] bytes) {
        validate(bytes);
        int pos = 0;
        this.nowSysNo = new U8(MsgSendHelper.getSubByteArray(bytes, pos, U8.byteArrayLen));
        pos += U8.byteArrayLen;
        this.nowType = new U16(MsgSendHelper.getSubByteArray(bytes, pos, U16.byteArrayLen));
        pos += U16.byteArrayLen;
        for (int i=0;i<100;i++){
            this.nowPara[i] = new U8(MsgSendHelper.getSubByteArray(bytes, pos, U8.byteArrayLen));
            pos += U8.byteArrayLen;
        }

    }

    private void validate(byte[] bytes) {
        if (bytes.length < SendUeInfo.byteArrayLen) {
            throw new IllegalArgumentException("byte array is not message PLMNID_STRU!");
        }
    }
}
