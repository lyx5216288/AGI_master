package sino.com.ltetest.P2A_MSG;

import android.print.PrinterCapabilitiesInfo;

import sino.com.ltetest.MsgSendHelper;
import sino.com.ltetest.type.U16;
import sino.com.ltetest.type.U8;

/**
 * Created by 刘洋旭 on 2016/7/29.
 */
public class SendPagingPwr {
    private U8 pagingSysNo;
    private U8[] pagingImsi;  //size=8
    private U8 uePwrNo;
    private U8 padding;
    private U8[] uePwr;   //size=100;
    public static final int byteArrayLen=(3+8+100)*U8.byteArrayLen;

    public U8 getPagingSysNo() {
        return pagingSysNo;
    }

    public void setPagingSysNo(int pagingSysNo) {
        this.pagingSysNo = new U8(pagingSysNo);
    }

    public U8[] getPagingImsi() {
        return pagingImsi;
    }

    public void setPagingImsi(U8[] pagingImsi) {
        this.pagingImsi = pagingImsi;
    }

    public U8 getUePwrNo() {
        return uePwrNo;
    }

    public void setUePwrNo(int uePwrNo) {
        this.uePwrNo = new U8(uePwrNo);
    }

    public U8 getPadding() {
        return padding;
    }

    public void setPadding(int padding) {
        this.padding = new U8(padding);
    }

    public U8[] getUePwr() {
        return uePwr;
    }

    public void setUePwr(U8[] uePwr) {
        this.uePwr = uePwr;
    }

    public SendPagingPwr(byte[] bytes) {
        validate(bytes);
        int pos = 0;
        this.pagingSysNo = new U8(MsgSendHelper.getSubByteArray(bytes, pos, U8.byteArrayLen));
        pos += U8.byteArrayLen;
        for(int i=0;i<8;i++){
        this.pagingImsi[i] = new U8(MsgSendHelper.getSubByteArray(bytes, pos, U8.byteArrayLen));
        pos += U8.byteArrayLen;
        }

        this.uePwrNo = new U8(MsgSendHelper.getSubByteArray(bytes, pos, U8.byteArrayLen));
        pos += U8.byteArrayLen;
        this.padding = new U8(MsgSendHelper.getSubByteArray(bytes, pos, U8.byteArrayLen));
        pos += U8.byteArrayLen;

        for (int i=0;i<100;i++){
            this.uePwr[i] = new U8(MsgSendHelper.getSubByteArray(bytes, pos, U8.byteArrayLen));
            pos += U8.byteArrayLen;
        }
    }

    private void validate(byte[] bytes) {
        if (bytes.length < SendUeInfo.byteArrayLen) {
            throw new IllegalArgumentException("byte array is not message PLMNID_STRU!");
        }
    }
}
