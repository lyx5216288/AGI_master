package sino.com.ltetest.external.msghandler;



import io.fmaster.LteMessage.Lte0xb16eMessage;
import io.fmaster.Message;
import io.fmaster.MessageHandler;
import sino.com.ltetest.external.MonitorApplication;

public class Lte0xb16eMsgHandler implements MessageHandler {

    @Override
    public void handle(Message message) {
        Lte0xb16eMessage msg = (Lte0xb16eMessage) message;

        Float txPwr = msg.getPuschTxPwr();
        if (txPwr != null) {
            MonitorApplication.data_PwrInfo.setPUSCH_TxPwr(txPwr);
        }
    }
}
