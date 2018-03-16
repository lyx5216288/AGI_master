package sino.com.ltetest.A2P_MSG;

import sino.com.ltetest.A2P_MSG.MSG.RECV_RF_PARA;
import sino.com.ltetest.MsgSendHelper;

/**
 * Created by 刘洋旭 on 2016/7/19.
 */
public class MSG_RF_SEND {
    private RECV_RF_PARA recv_rf_para;
    public byte[] getbytes(){
        MsgSendHelper.AppendByteArray apb=new MsgSendHelper.AppendByteArray();
        recv_rf_para=new RECV_RF_PARA();
        recv_rf_para.setRfEnable(1);
        apb.append(recv_rf_para.getRfEnable().getBytes());
        recv_rf_para.setFastConfigEarfcn(1);
        apb.append(recv_rf_para.getFastConfigEarfcn().getBytes());
        recv_rf_para.setEutra_band(40);
        apb.append(recv_rf_para.getEutra_band().getBytes());
        recv_rf_para.setDlEarfcn(40);
        apb.append(recv_rf_para.getDlEarfcn().getBytes());
        recv_rf_para.setUlEarfcn(40);
        apb.append(recv_rf_para.getUlEarfcn().getBytes());
        recv_rf_para.setSubframeAssinment(1);
        apb.append(recv_rf_para.getSubframeAssinment().getBytes());
        recv_rf_para.setSpecialSubframePatterns(7);
        apb.append(recv_rf_para.getSpecialSubframePatterns().getBytes());
        recv_rf_para.setFrameStrucureType(0);
        apb.append(recv_rf_para.getFrameStrucureType().getBytes());
        recv_rf_para.setDlBandWidth(100);
        apb.append(recv_rf_para.getDlBandWidth().getBytes());
        recv_rf_para.setUlBandWidth(100);
        apb.append(recv_rf_para.getUlBandWidth().getBytes());
        recv_rf_para.setTX1PowerAttenuation(1);
        apb.append(recv_rf_para.getTX1PowerAttenuation().getBytes());
        recv_rf_para.setTX2PowerAttenuation(1);
        apb.append(recv_rf_para.getTX2PowerAttenuation().getBytes());

        return apb.toByteArray();

    }
}
