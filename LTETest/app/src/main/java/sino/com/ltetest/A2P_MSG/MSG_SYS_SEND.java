package sino.com.ltetest.A2P_MSG;

import sino.com.ltetest.A2P_MSG.MSG.MSG_SYS_PARA;
import sino.com.ltetest.MsgSendHelper;
import sino.com.ltetest.type.U8;

/**
 * Created by 刘洋旭 on 2016/7/18.
 */
public class MSG_SYS_SEND {
    private MSG_SYS_PARA msg;
    public byte[] getbytes(){
        MsgSendHelper.AppendByteArray apb=new MsgSendHelper.AppendByteArray();
        msg=new MSG_SYS_PARA();
        msg.setParaSysNo(1);
        apb.append(msg.getParaSysNo().getBytes());
        msg.setParaMcc(new U8[]{new U8(4),new U8(6),new U8(0)});
        for (U8 u:msg.getParaMcc()){
            apb.append(u.getBytes());
        }
        msg.setParaMnc(new U8[]{new U8(0),new U8(0)});
        for (U8 u1:msg.getParaMnc()){
            apb.append(u1.getBytes());
        }
        msg.setParaPciNo(336);
        apb.append(msg.getParaPciNo().getBytes());
        msg.setParaTac(9578);
        apb.append(msg.getParaTac().getBytes());
        //中间有padding，未处理；
        msg.setParaCellId(75);
        apb.append(msg.getParaCellId().getBytes());
        msg.setParaPeri(0);
        apb.append(msg.getParaPeri().getBytes());
        msg.setParaIdReqNumOUT(1);
        apb.append(msg.getParaIdReqNumOUT().getBytes());
        msg.setParaIdReqNumIN(1);
        apb.append(msg.getParaIdReqNumIN().getBytes());
        msg.setUEcapaEnquirYNumOUT(5);
        apb.append(msg.getUEcapaEnquirYNumOUT().getBytes());
        msg.setUEcapaEnquirYNumIN(5);
        apb.append(msg.getUEcapaEnquirYNumIN().getBytes());
        msg.setBoolMeasureOUT(1);
        apb.append(msg.getBoolMeasureOUT().getBytes());
        msg.setBoolMeasureIN(1);
        apb.append(msg.getBoolMeasureIN().getBytes());
        msg.setParaTAURejCauOUT(2);
        apb.append(msg.getParaTAURejCauOUT().getBytes());
        msg.setParaTAURejCauIN(13);
        apb.append(msg.getParaTAURejCauIN().getBytes());
        msg.setParaATTRejCauOUT(2);
        apb.append(msg.getParaATTRejCauOUT().getBytes());
        msg.setParaATTRejCauIN(2);
        apb.append(msg.getParaATTRejCauIN().getBytes());
        msg.setRedirectedRATOUT(0);
        apb.append(msg.getRedirectedRATOUT().getBytes());

        //padding2,未处理
        msg.setRedirectedCarrierOUT(1);
        apb.append(msg.getRedirectedCarrierOUT().getBytes());
        msg.setPriorityOUT(15);
        apb.append(msg.getPriorityOUT().getBytes());

        msg.setRedirectedRATIN(1);
        apb.append(msg.getRedirectedRATIN().getBytes());
        msg.setRedirectedCarrierIN(50);
        apb.append(msg.getRedirectedCarrierIN().getBytes());
        msg.setPriorityIN(15);
        apb.append(msg.getPriorityIN().getBytes());

        msg.setRedirectedCellIN(63);
        apb.append(msg.getRedirectedCellIN().getBytes());

        return apb.toByteArray();
    }

}
