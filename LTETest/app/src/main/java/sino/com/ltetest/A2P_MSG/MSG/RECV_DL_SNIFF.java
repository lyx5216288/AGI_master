package sino.com.ltetest.A2P_MSG.MSG;

import sino.com.ltetest.type.U16;
import sino.com.ltetest.type.U32;
import sino.com.ltetest.type.U8;

/**
 * Created by 刘洋旭 on 2016/7/20.
 */
public class RECV_DL_SNIFF {
    private U8 dlSysNo;
    private U16 earfcn;
    private U32 dlFn;         //帧数

    private U8 dlRxMod;
    private U8 dlEnable;
    private U8 padding;

    public static final int byteArrayLen =4*U8.byteArrayLen+U16.byteArrayLen+U32.byteArrayLen;


    public U8 getDlSysNo() {
        return dlSysNo;
    }

    public void setDlSysNo(int dlSysNo) {
        this.dlSysNo = new U8(dlSysNo);
    }

    public U16 getEarfcn() {
        return earfcn;
    }

    public void setEarfcn(int earfcn) {
        this.earfcn = new U16(earfcn);
    }

    public U32 getDlFn() {
        return dlFn;
    }

    public void setDlFn(int dlFn) {
        this.dlFn = new U32(dlFn);
    }

    public U8 getDlRxMod() {
        return dlRxMod;
    }

    public void setDlRxMod(int dlRxMod) {
        this.dlRxMod = new U8(dlRxMod);
    }

    public U8 getDlEnable() {
        return dlEnable;
    }

    public void setDlEnable(int dlEnable) {
        this.dlEnable = new U8(dlEnable);
    }

    public U8 getPadding() {
        return padding;
    }

    public void setPadding(int padding) {
        this.padding = new U8(padding);
    }
}
