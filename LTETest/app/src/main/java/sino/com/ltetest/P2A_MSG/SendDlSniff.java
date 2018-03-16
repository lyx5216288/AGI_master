package sino.com.ltetest.P2A_MSG;

import sino.com.ltetest.MsgSendHelper;
import sino.com.ltetest.type.U16;
import sino.com.ltetest.type.U8;

/**
 * Created by 刘洋旭 on 2016/8/1.
 */
public class SendDlSniff {
    private U8 numberCell;
    private cellInfomation[] cellInfomation;  //size=numberCell;

    public U8 getNumberCell() {
        return numberCell;
    }

    public void setNumberCell(int numberCell) {
        this.numberCell = new U8(numberCell);
    }

    public sino.com.ltetest.P2A_MSG.cellInfomation[] getCellInfomation() {
        return cellInfomation;
    }

    public void setCellInfomation(sino.com.ltetest.P2A_MSG.cellInfomation[] cellInfomation) {
        this.cellInfomation = cellInfomation;
    }


    public SendDlSniff(byte[] bytes) {
        validate(bytes);
        int pos = 0;
        this.numberCell = new U8(MsgSendHelper.getSubByteArray(bytes, pos, U8.byteArrayLen));
        pos += U8.byteArrayLen;
        for (int i=0;i<this.numberCell.getBase();i++){
            this.cellInfomation[i] = new cellInfomation(MsgSendHelper.getSubByteArray(bytes, pos, sino.com.ltetest.P2A_MSG.cellInfomation.byteArrayLen));
            pos += sino.com.ltetest.P2A_MSG.cellInfomation.byteArrayLen;
        }


    }

    private void validate(byte[] bytes) {
        if (bytes.length < SendUeInfo.byteArrayLen) {
            throw new IllegalArgumentException("byte array is not message PLMNID_STRU!");
        }
    }

}
