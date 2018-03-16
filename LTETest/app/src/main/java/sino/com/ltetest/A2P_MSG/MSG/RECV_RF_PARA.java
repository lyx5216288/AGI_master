package sino.com.ltetest.A2P_MSG.MSG;

import sino.com.ltetest.MsgSendHelper;
import sino.com.ltetest.type.U16;
import sino.com.ltetest.type.U8;

/**
 * Created by 刘洋旭 on 2016/7/19.
 */
public class RECV_RF_PARA {
    private U16 rfSysNo;
    private U8 rfEnable;
    private U8 fastConfigEarfcn;
    private U16 eutra_band;
    private U16 DlEarfcn;
    private U16 UlEarfcn;
    private U8 FrameStrucureType;
    private U8 SubframeAssinment;
    private U8 specialSubframePatterns;
    private U8 DlBandWidth;
    private U8 UlBandWidth;
    private U8 RFchoice;
    private U16 TX1PowerAttenuation;
    private U16 TX2PowerAttenuation;

    public static final int byteArrayLen =6*U16.byteArrayLen+8*U8.byteArrayLen;




    private void validate(byte[] bytes) {
        if (bytes.length < RECV_RF_PARA.byteArrayLen) {
            throw new IllegalArgumentException("byte array is not message RECV_RF_PARA!");
        }
    }


    public U16 getRfSysNo() {
        return rfSysNo;
    }

    public void setRfSysNo(int rfSysNo) {
        this.rfSysNo = new U16(rfSysNo);
    }

    public U8 getRfEnable() {
        return rfEnable;
    }

    public void setRfEnable(int rfEnable) {
        this.rfEnable = new U8(rfEnable);
    }

    public U8 getFastConfigEarfcn() {
        return fastConfigEarfcn;
    }

    public void setFastConfigEarfcn(int fastConfigEarfcn) {
        this.fastConfigEarfcn = new U8(fastConfigEarfcn);
    }

    public U16 getEutra_band() {
        return eutra_band;
    }

    public void setEutra_band(int eutra_band) {
        this.eutra_band = new U16(eutra_band);
    }

    public U16 getDlEarfcn() {
        return DlEarfcn;
    }

    public void setDlEarfcn(int dlEarfcn) {
        DlEarfcn = new U16(dlEarfcn);
    }

    public U16 getUlEarfcn() {
        return UlEarfcn;
    }

    public void setUlEarfcn(int ulEarfcn) {
        UlEarfcn = new U16(ulEarfcn);
    }

    public U8 getFrameStrucureType() {
        return FrameStrucureType;
    }

    public void setFrameStrucureType(int frameStrucureType) {
        FrameStrucureType = new U8(frameStrucureType);
    }

    public U8 getSubframeAssinment() {
        return SubframeAssinment;
    }

    public void setSubframeAssinment(int subframeAssinment) {
        SubframeAssinment = new U8(subframeAssinment);
    }

    public U8 getSpecialSubframePatterns() {
        return specialSubframePatterns;
    }

    public void setSpecialSubframePatterns(int specialSubframePatterns) {
        this.specialSubframePatterns = new U8(specialSubframePatterns);
    }

    public U8 getDlBandWidth() {
        return DlBandWidth;
    }

    public void setDlBandWidth(int dlBandWidth) {
        DlBandWidth = new U8(dlBandWidth);
    }

    public U8 getUlBandWidth() {
        return UlBandWidth;
    }

    public void setUlBandWidth(int ulBandWidth) {
        UlBandWidth = new U8(ulBandWidth);
    }

    public U8 getRFchoice() {
        return RFchoice;
    }

    public void setRFchoice(int RFchoice) {
        this.RFchoice = new U8(RFchoice);
    }

    public U16 getTX1PowerAttenuation() {
        return TX1PowerAttenuation;
    }

    public void setTX1PowerAttenuation(int TX1PowerAttenuation) {
        this.TX1PowerAttenuation = new U16(TX1PowerAttenuation);
    }

    public U16 getTX2PowerAttenuation() {
        return TX2PowerAttenuation;
    }

    public void setTX2PowerAttenuation(int TX2PowerAttenuation) {
        this.TX2PowerAttenuation = new U16(TX2PowerAttenuation);
    }

    public RECV_RF_PARA(){
        this.rfSysNo=new U16();
        this.rfEnable=new U8();
        this.fastConfigEarfcn=new U8();
        this.eutra_band=new U16();
        this.DlEarfcn=new U16();
        this.UlEarfcn=new U16();
        this.FrameStrucureType=new U8();
        this.SubframeAssinment=new U8();
        this.specialSubframePatterns=new U8();
        this.DlBandWidth=new U8();
        this.UlBandWidth=new U8();
        this.RFchoice=new U8();
        this.TX1PowerAttenuation=new U16();
        this.TX2PowerAttenuation=new U16();
    }
    public RECV_RF_PARA(byte[] bytes){
        validate(bytes);
        int pos = 0;
        this.rfSysNo = new U16(MsgSendHelper.getSubByteArray(bytes, pos, U16.byteArrayLen));
        pos += U16.byteArrayLen;
        this.rfEnable = new U8(MsgSendHelper.getSubByteArray(bytes, pos, U8.byteArrayLen));
        pos += U8.byteArrayLen;
        this.fastConfigEarfcn = new U8(MsgSendHelper.getSubByteArray(bytes, pos, U8.byteArrayLen));
        pos += U8.byteArrayLen;
        this.eutra_band = new U16(MsgSendHelper.getSubByteArray(bytes, pos, U16.byteArrayLen));
        pos += U16.byteArrayLen;
        this.DlEarfcn = new U16(MsgSendHelper.getSubByteArray(bytes, pos, U16.byteArrayLen));
        pos += U16.byteArrayLen;
        this.UlEarfcn = new U16(MsgSendHelper.getSubByteArray(bytes, pos, U16.byteArrayLen));
        pos += U16.byteArrayLen;
        this.FrameStrucureType = new U8(MsgSendHelper.getSubByteArray(bytes, pos, U8.byteArrayLen));
        pos += U8.byteArrayLen;
        this.SubframeAssinment = new U8(MsgSendHelper.getSubByteArray(bytes, pos, U8.byteArrayLen));
        pos += U8.byteArrayLen;
        this.specialSubframePatterns = new U8(MsgSendHelper.getSubByteArray(bytes, pos, U8.byteArrayLen));
        pos += U8.byteArrayLen;
        this.DlBandWidth = new U8(MsgSendHelper.getSubByteArray(bytes, pos, U8.byteArrayLen));
        pos += U8.byteArrayLen;
        this.UlBandWidth = new U8(MsgSendHelper.getSubByteArray(bytes, pos, U8.byteArrayLen));
        pos += U8.byteArrayLen;
        this.RFchoice = new U8(MsgSendHelper.getSubByteArray(bytes, pos, U8.byteArrayLen));
        pos += U8.byteArrayLen;
        this.TX1PowerAttenuation = new U16(MsgSendHelper.getSubByteArray(bytes, pos, U16.byteArrayLen));
        pos += U16.byteArrayLen;
        this.TX2PowerAttenuation = new U16(MsgSendHelper.getSubByteArray(bytes, pos, U16.byteArrayLen));
        pos += U16.byteArrayLen;

    }

    public byte[] getBytes(){
        MsgSendHelper.AppendByteArray ret = new MsgSendHelper.AppendByteArray();
        ret.append(rfSysNo.getBytes())
                .append(rfEnable.getBytes())
                .append(fastConfigEarfcn.getBytes())
                .append(eutra_band.getBytes())
                .append(DlEarfcn.getBytes())
                .append(UlEarfcn.getBytes())
                .append(FrameStrucureType.getBytes())
                .append(SubframeAssinment.getBytes())
                .append(specialSubframePatterns.getBytes())
                .append(DlBandWidth.getBytes())
                .append(UlBandWidth.getBytes())
                .append(RFchoice.getBytes())
                .append(TX1PowerAttenuation.getBytes())
                .append(TX2PowerAttenuation.getBytes());
        return ret.toByteArray();
    }



}
