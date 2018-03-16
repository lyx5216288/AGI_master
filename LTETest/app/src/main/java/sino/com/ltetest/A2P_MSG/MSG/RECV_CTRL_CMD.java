package sino.com.ltetest.A2P_MSG.MSG;

import sino.com.ltetest.type.U8;

/**
 * Created by 刘洋旭 on 2016/7/25.
 */
public class RECV_CTRL_CMD {
    private U8 ctrlSysNo;
    private U8 ctrlCmdType;
    private U8 ctrlCmdPara;
    private U8 ctrlPagingIDType;
    private U8[] ctrlImsi; //size=8;
    public static final int byteArrayLen =(4+8)*U8.byteArrayLen;

    public U8 getCtrlSysNo() {
        return ctrlSysNo;
    }

    public void setCtrlSysNo(int ctrlSysNo) {
        this.ctrlSysNo = new U8(ctrlSysNo);
    }

    public U8 getCtrlCmdType() {
        return ctrlCmdType;
    }

    public void setCtrlCmdType(int ctrlCmdType) {
        this.ctrlCmdType = new U8(ctrlCmdType);
    }

    public U8 getCtrlCmdPara() {
        return ctrlCmdPara;
    }

    public void setCtrlCmdPara(int ctrlCmdPara) {
        this.ctrlCmdPara = new U8(ctrlCmdPara);
    }

    public U8 getCtrlPagingIDType() {
        return ctrlPagingIDType;
    }

    public void setCtrlPagingIDType(int ctrlPagingIDType) {
        this.ctrlPagingIDType = new U8(ctrlPagingIDType);
    }

    public U8[] getCtrlImsi() {
        return ctrlImsi;
    }

    public void setCtrlImsi(String ctrlImsi) {
        this.ctrlImsi =new U8[8];
        for (int i=0;i<8;i++){
            U8 pos=new U8();
            if (i==0){
                pos.setBase(Integer.parseInt("0"+ctrlImsi.charAt(0),16));
            }else
            {
                pos.setBase(Integer.parseInt(ctrlImsi.substring(2*i-1,2*i),16));
            }
            this.ctrlImsi[i]=pos;
        }
    }
}
