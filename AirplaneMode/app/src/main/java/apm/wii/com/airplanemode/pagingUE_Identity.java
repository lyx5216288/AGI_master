package apm.wii.com.airplanemode1;

/**
 * Created by 刘洋旭 on 2017/8/3.
 */
public class pagingUE_Identity {
    public int t;
    S_TMSI sTmsi;
    class S_TMSI{
        MMEC mmec;
        S_TMSI_m_TMSI m_TMSI;
        class MMEC{
            int numbits;
            char data;
        }
        class S_TMSI_m_TMSI{
            int numbits;
            char[] data=new char[4];
        }
    }
    class IMSI{
        int n;
        char[] imsi=new char[21];
    }
}
