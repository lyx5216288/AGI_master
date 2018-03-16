package sino.com.ltetest.A2P_MSG.MSG;

import sino.com.ltetest.type.U16;
import sino.com.ltetest.type.U8;

/**
 * Created by 刘洋旭 on 2016/7/25.
 */
public class RECV_NOW_PARA {
    private U8 nowSysNo;
    private U16 nowType;

    public static final int byteArrayLen =U8.byteArrayLen+U16.byteArrayLen;

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
}
