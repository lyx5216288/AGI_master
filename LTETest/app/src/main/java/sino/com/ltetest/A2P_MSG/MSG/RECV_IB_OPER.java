package sino.com.ltetest.A2P_MSG.MSG;

import sino.com.ltetest.type.U8;

/**
 * Created by 刘洋旭 on 2016/7/21.
 */
public class RECV_IB_OPER {

    private U8 ibSysNo;
    private U8 ibCmdType;
    private U8[] ibImsi;  //size=8;

    public static final int byteArrayLen =(2+8)*U8.byteArrayLen;



    public U8 getIbSysNo() {
        return ibSysNo;
    }

    public void setIbSysNo(int ibSysNo) {
        this.ibSysNo = new U8(ibSysNo);
    }

    public U8 getIbCmdType() {
        return ibCmdType;
    }

    public void setIbCmdType(int ibCmdType) {
        this.ibCmdType = new U8(ibCmdType);
    }

    public U8[] getIbImsi() {
        return ibImsi;
    }

    public void setIbImsi(String ibImsi) {
        this.ibImsi = new U8[8];
        for (int i=0;i<8;i++){
            U8 pos=new U8();
            if (i==0){
                pos.setBase(Integer.parseInt("0"+ibImsi.charAt(0),16));
            }else
            {
                pos.setBase(Integer.parseInt(ibImsi.substring(2*i-1,2*i),16));
            }
            this.ibImsi[i]=pos;
        }
    }
}