package sino.com.ltetest.A2P_MSG.MSG;

import sino.com.ltetest.type.U16;
import sino.com.ltetest.type.U8;

/**
 * Created by 刘洋旭 on 2016/7/25.
 */
public class RECV_NEW_TAC {
    private U8 newSysNo;
    private U16 newTimer;

    public static final int byteArrayLen =U8.byteArrayLen+U16.byteArrayLen;

    public U8 getNewSysNo() {
        return newSysNo;
    }

    public void setNewSysNo(int newSysNo) {
        this.newSysNo = new U8(newSysNo);
    }

    public U16 getNewTimer() {
        return newTimer;
    }

    public void setNewTimer(int newTimer) {
        this.newTimer = new U16(newTimer);
    }
}
