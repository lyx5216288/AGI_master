package sino.com.ltetest.Dao.SysConfig;



/**
 * Created by 刘洋旭 on 2016/8/4.
 */
public class SysConfigDao {
    public final int Sysno;
    public final int Mcc;
    public final int Mnc;
    public final int Pcino;
    public final int Tac;
    public final int CellId;
    public final int Peri;
    public final int ReqNumOUT;
    public final int ReqNumIN;
    public final int UEcapaEnquiryNumOUT;
    public final int UEcapaEnquiryNumIN;
    public final int BoolMeasureOUT;
    public final int BoolMeasureIN;
    public final int paraTAURejCauOUT;
    public final int paraTAURejCauIN;
    public final int paraATTRejCauOUT;
    public final int paraATTRejCauIN;
    public final int redirectedRATOUT;
    public final int redirectedCarrierOUT;
    public final int PriorityOUT;
    public final int redirectedRATIN;
    public final int redirectedCarrierIN;
    public final int PriorityIN;
    public final int redirectedCellIN;

    public SysConfigDao(){
        Sysno = 1;
        Mcc = 460;
        Mnc = 00;
        Pcino = 336;
        Tac = 9578;
        CellId = 75;
        Peri = 0;
        ReqNumOUT = 1;
        ReqNumIN = 1;
        UEcapaEnquiryNumOUT = 1;
        UEcapaEnquiryNumIN = 1;
        BoolMeasureOUT = 1;
        BoolMeasureIN = 1;
        this.paraTAURejCauOUT = 0;
        this.paraTAURejCauIN = 0;
        this.paraATTRejCauOUT = 0;
        this.paraATTRejCauIN = 0;
        this.redirectedRATOUT = 0;
        this.redirectedCarrierOUT = 1;
        PriorityOUT = 15;
        this.redirectedRATIN = 1;
        this.redirectedCarrierIN = 50;
        PriorityIN = 15;
        this.redirectedCellIN = 63;
    }


    public SysConfigDao(int sysno, int mcc, int mnc, int pcino, int tac, int cellId, int peri, int reqNumOUT,
                        int reqNumIN, int uEcapaEnquiryNumOUT, int uEcapaEnquiryNumIN, int boolMeasureOUT,
                        int boolMeasureIN, int paraTAURejCauOUT, int paraTAURejCauIN, int paraATTRejCauOUT,
                        int paraATTRejCauIN, int redirectedRATOUT, int redirectedCarrierOUT, int priorityOUT,
                        int redirectedRATIN, int redirectedCarrierIN, int priorityIN, int redirectedCellIN) {
        Sysno = sysno;
        Mcc = mcc;
        Mnc = mnc;
        Pcino = pcino;
        Tac = tac;
        CellId = cellId;
        Peri = peri;
        ReqNumOUT = reqNumOUT;
        ReqNumIN = reqNumIN;
        UEcapaEnquiryNumOUT = uEcapaEnquiryNumOUT;
        UEcapaEnquiryNumIN = uEcapaEnquiryNumIN;
        BoolMeasureOUT = boolMeasureOUT;
        BoolMeasureIN = boolMeasureIN;
        this.paraTAURejCauOUT = paraTAURejCauOUT;
        this.paraTAURejCauIN = paraTAURejCauIN;
        this.paraATTRejCauOUT = paraATTRejCauOUT;
        this.paraATTRejCauIN = paraATTRejCauIN;
        this.redirectedRATOUT = redirectedRATOUT;
        this.redirectedCarrierOUT = redirectedCarrierOUT;
        PriorityOUT = priorityOUT;
        this.redirectedRATIN = redirectedRATIN;
        this.redirectedCarrierIN = redirectedCarrierIN;
        PriorityIN = priorityIN;
        this.redirectedCellIN = redirectedCellIN;
    }
}
