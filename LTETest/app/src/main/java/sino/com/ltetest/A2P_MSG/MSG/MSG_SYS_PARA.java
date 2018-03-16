package sino.com.ltetest.A2P_MSG.MSG;

import sino.com.ltetest.MsgSendHelper;
import sino.com.ltetest.type.U16;
import sino.com.ltetest.type.U32;
import sino.com.ltetest.type.U8;

/**
 * Created by 刘洋旭 on 2016/7/13.
 */
public class MSG_SYS_PARA {
    private U8 paraSysNo;
    private U8[] paraMcc; //size=3;
    private U8[] paraMnc; //size=2;
    private U16 paraPciNo;
    private U16 paraTac;
    private U8[] padding1;  //size=2;
    private U32 paraCellId;
    private U32 paraPeri;
    private U8 paraIdReqNumOUT;
    private U8 paraIdReqNumIN;
    private U8 UEcapaEnquirYNumOUT;
    private U8 UEcapaEnquirYNumIN;
    private U8 BoolMeasureOUT;
    private U8 BoolMeasureIN;
    private U8 paraTAURejCauOUT;
    private U8 paraTAURejCauIN;
    private U8 paraATTRejCauOUT;
    private U8 paraATTRejCauIN;
    private U8 redirectedRATOUT;
    private U8 padding2;
    private U16 redirectedCarrierOUT;
    private U8 PriorityOUT;
    private U8 redirectedRATIN;
    private U16 redirectedCarrierIN;
    private U8 PriorityIN;
    private U8 redirectedCellIN;

    public static final int byteArrayLen =4*U16.byteArrayLen+2*U32.byteArrayLen+(17+3+2+2)*U8.byteArrayLen;

    public U8 getParaSysNo() {
        return paraSysNo;
    }

    public void setParaSysNo(int paraSysNo) {
        this.paraSysNo =new U8(paraSysNo);
    }

    public U8[] getParaMcc() {
        return paraMcc;
    }

    public void setParaMcc(U8[] paraMcc) {
        this.paraMcc = paraMcc;
    }

    public U8[] getParaMnc() {
        return paraMnc;
    }

    public void setParaMnc(U8[] paraMnc) {
        this.paraMnc = paraMnc;
    }

    public U16 getParaPciNo() {
        return paraPciNo;
    }

    public void setParaPciNo(int paraPciNo) {
        this.paraPciNo =new U16(paraPciNo);
    }

    public U16 getParaTac() {
        return paraTac;
    }

    public void setParaTac(int paraTac) {
        this.paraTac =new U16(paraTac) ;
    }

    public U8[] getPadding1() {
        return padding1;
    }

    public void setPadding1(U8[] padding1) {
        this.padding1 = padding1;
    }

    public U32 getParaCellId() {
        return paraCellId;
    }

    public void setParaCellId(int paraCellId) {
        this.paraCellId =new U32(paraCellId);
    }

    public U32 getParaPeri() {
        return paraPeri;
    }

    public void setParaPeri(int  paraPeri) {
        this.paraPeri =new U32(paraPeri);
    }

    public U8 getParaIdReqNumOUT() {
        return paraIdReqNumOUT;
    }

    public void setParaIdReqNumOUT(int  paraIdReqNumOUT) {
        this.paraIdReqNumOUT =new U8(paraIdReqNumOUT);
    }

    public U8 getParaIdReqNumIN() {
        return paraIdReqNumIN;
    }

    public void setParaIdReqNumIN(int paraIdReqNumIN) {
        this.paraIdReqNumIN =new U8(paraIdReqNumIN);
    }

    public U8 getUEcapaEnquirYNumOUT() {
        return UEcapaEnquirYNumOUT;
    }

    public void setUEcapaEnquirYNumOUT(int UEcapaEnquirYNumOUT) {
        this.UEcapaEnquirYNumOUT = new U8(UEcapaEnquirYNumOUT);
    }

    public U8 getUEcapaEnquirYNumIN() {
        return UEcapaEnquirYNumIN;
    }

    public void setUEcapaEnquirYNumIN(int UEcapaEnquirYNumIN) {
        this.UEcapaEnquirYNumIN = new U8(UEcapaEnquirYNumIN);
    }

    public U8 getBoolMeasureOUT() {
        return BoolMeasureOUT;
    }

    public void setBoolMeasureOUT(int boolMeasureOUT) {
        BoolMeasureOUT =new U8(boolMeasureOUT);
    }

    public U8 getBoolMeasureIN() {
        return BoolMeasureIN;
    }

    public void setBoolMeasureIN(int boolMeasureIN) {
        BoolMeasureIN = new U8(boolMeasureIN);
    }

    public U8 getParaTAURejCauOUT() {
        return paraTAURejCauOUT;
    }

    public void setParaTAURejCauOUT(int paraTAURejCauOUT) {
        this.paraTAURejCauOUT = new U8(paraTAURejCauOUT);
    }

    public U8 getParaTAURejCauIN() {
        return paraTAURejCauIN;
    }

    public void setParaTAURejCauIN(int paraTAURejCauIN) {
        this.paraTAURejCauIN = new U8(paraTAURejCauIN);
    }

    public U8 getParaATTRejCauOUT() {
        return paraATTRejCauOUT;
    }

    public void setParaATTRejCauOUT(int paraATTRejCauOUT) {
        this.paraATTRejCauOUT = new U8(paraATTRejCauOUT);
    }

    public U8 getParaATTRejCauIN() {
        return paraATTRejCauIN;
    }

    public void setParaATTRejCauIN(int paraATTRejCauIN) {
        this.paraATTRejCauIN = new U8(paraATTRejCauIN);
    }

    public U8 getRedirectedRATOUT() {
        return redirectedRATOUT;
    }

    public void setRedirectedRATOUT(int redirectedRATOUT) {
        this.redirectedRATOUT = new U8(redirectedRATOUT);
    }

    public U8 getPadding2() {
        return padding2;
    }

    public void setPadding2(int padding2) {
        this.padding2 = new U8(padding2);
    }

    public U16 getRedirectedCarrierOUT() {
        return redirectedCarrierOUT;
    }

    public void setRedirectedCarrierOUT(int redirectedCarrierOUT) {
        this.redirectedCarrierOUT = new U16(redirectedCarrierOUT);
    }

    public U8 getPriorityOUT() {
        return PriorityOUT;
    }

    public void setPriorityOUT(int priorityOUT) {
        PriorityOUT = new U8(priorityOUT);
    }

    public U8 getRedirectedRATIN() {
        return redirectedRATIN;
    }

    public void setRedirectedRATIN(int redirectedRATIN) {
        this.redirectedRATIN = new U8(redirectedRATIN);
    }

    public U16 getRedirectedCarrierIN() {
        return redirectedCarrierIN;
    }

    public void setRedirectedCarrierIN(int redirectedCarrierIN) {
        this.redirectedCarrierIN = new U16(redirectedCarrierIN);
    }

    public U8 getPriorityIN() {
        return PriorityIN;
    }

    public void setPriorityIN(int  priorityIN) {
        PriorityIN = new U8(priorityIN);
    }

    public U8 getRedirectedCellIN() {
        return redirectedCellIN;
    }

    public void setRedirectedCellIN(int redirectedCellIN) {
        this.redirectedCellIN = new U8(redirectedCellIN);
    }

    public MSG_SYS_PARA(){
        this.paraSysNo=new U8();
        this.paraMcc=new U8[3];//size=3
        this.paraMnc=new U8[2];//size=2
        this.paraPciNo=new U16();
        this.paraTac=new U16();
        this.padding1=new U8[2]; //size=2
        this.paraCellId=new U32();
        this.paraPeri=new U32();
        this.paraIdReqNumOUT=new U8();
        this.paraIdReqNumIN=new U8();
        this.UEcapaEnquirYNumOUT=new U8();
        this.UEcapaEnquirYNumIN=new U8();
        this.BoolMeasureOUT=new U8();
        this.BoolMeasureIN=new U8();
        this.paraTAURejCauOUT=new U8();
        this.paraTAURejCauIN=new U8();
        this.paraATTRejCauOUT=new U8();
        this.paraATTRejCauIN=new U8();
        this.redirectedRATOUT=new U8();
        this.padding2=new U8();
        this.redirectedCarrierOUT=new U16();
        this.PriorityOUT=new U8();
        this.redirectedRATIN=new U8();
        this.redirectedCarrierIN=new U16();
        this.PriorityIN=new U8();
        this.redirectedCellIN=new U8();
    }

    public MSG_SYS_PARA(byte[] bytes){
        validate(bytes);
        int pos = 0;
        this.paraSysNo = new U8(MsgSendHelper.getSubByteArray(bytes, pos, U8.byteArrayLen));
        pos += U8.byteArrayLen;

        paraMcc = new U8[3]; // size = 3
        for (int i = 0; i < paraMcc.length; i++) {
            paraMcc[i] = new U8(MsgSendHelper.getSubByteArray(bytes, pos, U8.byteArrayLen));
            pos += U8.byteArrayLen;
        }
        paraMnc = new U8[2]; // size = 2
        for (int i = 0; i < paraMnc.length; i++) {
            paraMnc[i] = new U8(MsgSendHelper.getSubByteArray(bytes, pos, U8.byteArrayLen));
            pos += U8.byteArrayLen;
        }
        paraPciNo = new U16(MsgSendHelper.getSubByteArray(bytes, pos, U16.byteArrayLen));
        pos += U16.byteArrayLen;
        paraTac = new U16(MsgSendHelper.getSubByteArray(bytes, pos, U16.byteArrayLen));
        pos += U16.byteArrayLen;
        padding1 = new U8[2]; // size = 2
        for (int i = 0; i < padding1.length; i++) {
            padding1[i] = new U8(MsgSendHelper.getSubByteArray(bytes, pos, U8.byteArrayLen));
            pos += U8.byteArrayLen;
        }

        paraCellId = new U32(MsgSendHelper.getSubByteArray(bytes, pos, U32.byteArrayLen));
        pos += U32.byteArrayLen;
        paraPeri = new U32(MsgSendHelper.getSubByteArray(bytes, pos, U32.byteArrayLen));
        pos += U32.byteArrayLen;

        this.paraIdReqNumOUT = new U8(MsgSendHelper.getSubByteArray(bytes, pos, U8.byteArrayLen));
        pos += U8.byteArrayLen;
        this.paraIdReqNumIN = new U8(MsgSendHelper.getSubByteArray(bytes, pos, U8.byteArrayLen));
        pos += U8.byteArrayLen;
        this.UEcapaEnquirYNumOUT = new U8(MsgSendHelper.getSubByteArray(bytes, pos, U8.byteArrayLen));
        pos += U8.byteArrayLen;
        this.UEcapaEnquirYNumIN = new U8(MsgSendHelper.getSubByteArray(bytes, pos, U8.byteArrayLen));
        pos += U8.byteArrayLen;
        this.BoolMeasureOUT = new U8(MsgSendHelper.getSubByteArray(bytes, pos, U8.byteArrayLen));
        pos += U8.byteArrayLen;
        this.BoolMeasureIN = new U8(MsgSendHelper.getSubByteArray(bytes, pos, U8.byteArrayLen));
        pos += U8.byteArrayLen;
        this.paraTAURejCauOUT = new U8(MsgSendHelper.getSubByteArray(bytes, pos, U8.byteArrayLen));
        pos += U8.byteArrayLen;
        this.paraTAURejCauIN = new U8(MsgSendHelper.getSubByteArray(bytes, pos, U8.byteArrayLen));
        pos += U8.byteArrayLen;
        this.paraATTRejCauOUT = new U8(MsgSendHelper.getSubByteArray(bytes, pos, U8.byteArrayLen));
        pos += U8.byteArrayLen;
        this.paraATTRejCauIN = new U8(MsgSendHelper.getSubByteArray(bytes, pos, U8.byteArrayLen));
        pos += U8.byteArrayLen;
        this.redirectedRATOUT = new U8(MsgSendHelper.getSubByteArray(bytes, pos, U8.byteArrayLen));
        pos += U8.byteArrayLen;
        this.padding2 = new U8(MsgSendHelper.getSubByteArray(bytes, pos, U8.byteArrayLen));
        pos += U8.byteArrayLen;

        this.redirectedCarrierOUT = new U16(MsgSendHelper.getSubByteArray(bytes, pos, U16.byteArrayLen));
        pos += U16.byteArrayLen;
        this.PriorityOUT = new U8(MsgSendHelper.getSubByteArray(bytes, pos, U8.byteArrayLen));
        pos += U8.byteArrayLen;
        this.redirectedRATIN = new U8(MsgSendHelper.getSubByteArray(bytes, pos, U8.byteArrayLen));
        pos += U8.byteArrayLen;
        this.redirectedCarrierIN = new U16(MsgSendHelper.getSubByteArray(bytes, pos, U16.byteArrayLen));
        pos += U16.byteArrayLen;
        this.PriorityIN = new U8(MsgSendHelper.getSubByteArray(bytes, pos, U8.byteArrayLen));
        pos += U8.byteArrayLen;
        this.redirectedCellIN = new U8(MsgSendHelper.getSubByteArray(bytes, pos, U8.byteArrayLen));
        pos += U8.byteArrayLen;



    }

    public byte[] getBytes(){
        MsgSendHelper.AppendByteArray ret = new MsgSendHelper.AppendByteArray();
        ret.append(paraSysNo.getBytes());
        for (U8 t : paraMcc) {
            ret.append(t.getBytes());
        }
        for (U8 t : paraMnc) {
            ret.append(t.getBytes());
        }
        ret.append(paraPciNo.getBytes())
                .append(paraTac.getBytes());
        for (U8 t : padding1) {
            ret.append(t.getBytes());
        }
        ret.append(paraCellId.getBytes())
                .append(paraPeri.getBytes())
                .append(paraIdReqNumOUT.getBytes())
                .append(paraIdReqNumIN.getBytes())
                .append(UEcapaEnquirYNumOUT.getBytes())
                .append(UEcapaEnquirYNumIN.getBytes())
                .append(BoolMeasureOUT.getBytes())
                .append(BoolMeasureIN.getBytes())
                .append(paraTAURejCauOUT.getBytes())
                .append(paraTAURejCauIN.getBytes())
                .append(paraATTRejCauOUT.getBytes())
                .append(paraATTRejCauIN.getBytes())
                .append(redirectedRATOUT.getBytes())
                .append(padding2.getBytes())
                .append(redirectedCarrierOUT.getBytes())
                .append(PriorityOUT.getBytes())
                .append(redirectedRATIN.getBytes())
                .append(redirectedCarrierIN.getBytes())
                .append(PriorityIN.getBytes())
                .append(redirectedCellIN.getBytes());

        return ret.toByteArray();
    }


    private void validate(byte[] bytes) {
        if (bytes.length < MSG_SYS_PARA.byteArrayLen) {
            throw new IllegalArgumentException("byte array is not message MSG_SYS_PARA!");
        }
    }



}
