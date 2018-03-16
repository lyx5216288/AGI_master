package sino.com.ltetest.P2A_MSG;

import sino.com.ltetest.MsgSendHelper;
import sino.com.ltetest.type.U16;
import sino.com.ltetest.type.U8;

/**
 * Created by 刘洋旭 on 2016/8/1.
 */
public class SendDevVersion {
    private U8  type;
    private char  fpgaVersion; //size=4
    private char  BBUVersion;  //size=4
    private char  SoftWareVersion;  //sie=64

    public static final int byteArrayLen=1*U8.byteArrayLen+(4+4+64)*2;

    public U8 getType() {
        return type;
    }

    public void setType(int type) {
        this.type = new U8(type);
    }

    public char getFpgaVersion() {
        return fpgaVersion;
    }

    public void setFpgaVersion(char fpgaVersion) {
        this.fpgaVersion = fpgaVersion;
    }

    public char getBBUVersion() {
        return BBUVersion;
    }

    public void setBBUVersion(char BBUVersion) {
        this.BBUVersion = BBUVersion;
    }

    public char getSoftWareVersion() {
        return SoftWareVersion;
    }

    public void setSoftWareVersion(char softWareVersion) {
        SoftWareVersion = softWareVersion;
    }


    public SendDevVersion(byte[] bytes) {
        validate(bytes);
        int pos = 0;
        this.type = new U8(MsgSendHelper.getSubByteArray(bytes, pos, U8.byteArrayLen));
        pos += U8.byteArrayLen;
        for (int i=0;i<4;i++){
            this.fpgaVersion= (char) (this.fpgaVersion+(char) (((bytes[pos] & 0xFF) << 8) | (bytes[pos+1] & 0xFF)));
            pos+=2;
        }

        for (int i=0;i<4;i++){
            this.BBUVersion= (char) (this.BBUVersion+(char) (((bytes[pos] & 0xFF) << 8) | (bytes[pos+1] & 0xFF)));
            pos+=2;
        }

        for (int i=0;i<64;i++){
            this.SoftWareVersion= (char) (this.SoftWareVersion+(char) (((bytes[pos] & 0xFF) << 8) | (bytes[pos+1] & 0xFF)));
            pos+=2;
        }

    }

    private void validate(byte[] bytes) {
        if (bytes.length < SendUeInfo.byteArrayLen) {
            throw new IllegalArgumentException("byte array is not message PLMNID_STRU!");
        }
    }
}
