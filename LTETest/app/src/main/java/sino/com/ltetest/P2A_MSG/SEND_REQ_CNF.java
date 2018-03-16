package sino.com.ltetest.P2A_MSG;

import sino.com.ltetest.MsgSendHelper;
import sino.com.ltetest.type.U16;

/**
 * Created by 刘洋旭 on 2016/7/29.
 */
public class SEND_REQ_CNF {
    private U16 cnfSysNo;
    private U16 cnfType;
    private U16 cnfInd;
    private U16 padding;

    public U16 getCnfSysNo() {
        return cnfSysNo;
    }

    public void setCnfSysNo(int cnfSysNo) {
        this.cnfSysNo = new U16(cnfSysNo);
    }

    public U16 getCnfType() {
        return cnfType;
    }

    public void setCnfType(int cnfType) {
        this.cnfType = new U16(cnfType);
    }

    public U16 getCnfInd() {
        return cnfInd;
    }

    public void setCnfInd(int cnfInd) {
        this.cnfInd = new U16(cnfInd);
    }

    public U16 getPadding() {
        return padding;
    }

    public void setPadding(int padding) {
        this.padding = new U16(padding);
    }

    public SEND_REQ_CNF(byte[] bytes) {
        validate(bytes);
        int pos = 0;
        this.cnfSysNo = new U16(MsgSendHelper.getSubByteArray(bytes, pos, U16.byteArrayLen));
        pos += U16.byteArrayLen;
        this.cnfType = new U16(MsgSendHelper.getSubByteArray(bytes, pos, U16.byteArrayLen));
        pos += U16.byteArrayLen;
        this.cnfInd = new U16(MsgSendHelper.getSubByteArray(bytes, pos, U16.byteArrayLen));
        pos += U16.byteArrayLen;
        this.padding = new U16(MsgSendHelper.getSubByteArray(bytes, pos, U16.byteArrayLen));
        pos += U16.byteArrayLen;
    }

    private void validate(byte[] bytes) {
        if (bytes.length < SendUeInfo.byteArrayLen) {
            throw new IllegalArgumentException("byte array is not message PLMNID_STRU!");
        }
    }

}
