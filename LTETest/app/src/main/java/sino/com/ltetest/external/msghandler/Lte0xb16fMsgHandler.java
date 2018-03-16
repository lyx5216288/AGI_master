package sino.com.ltetest.external.msghandler;



import io.fmaster.LteMessage.Lte0xb16fMessage;
import io.fmaster.Message;
import io.fmaster.MessageHandler;
import sino.com.ltetest.external.MonitorApplication;

public class Lte0xb16fMsgHandler implements MessageHandler {

    @Override
    public void handle(Message message) {
        Lte0xb16fMessage msg = (Lte0xb16fMessage) message;

        Float txPwr = msg.getPucchTxPwr();
        if (txPwr != null) {
            MonitorApplication.data_PwrInfo.setPUCCH_TxPwr(txPwr);
        }
    }

}
