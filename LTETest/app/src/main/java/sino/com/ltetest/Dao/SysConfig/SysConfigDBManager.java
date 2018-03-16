package sino.com.ltetest.Dao.SysConfig;

import android.content.Context;
import net.sqlcipher.database.SQLiteDatabase;
import android.provider.Telephony;
import android.support.v4.view.animation.FastOutLinearInInterpolator;

/**
 * Created by 刘洋旭 on 2016/8/4.
 */
public class SysConfigDBManager {
    private SysConfigDBHelper helper;
    private SQLiteDatabase db;


    private SysConfigDBManager(Context context){
        helper=new SysConfigDBHelper(context);
        db=helper.getWritableDatabase("123456");
        db.execSQL("CREATE TABLE IF NOT EXISTS " + helper.TABLE_NAME  +
                "(sysNo TEXT PRIMARY KEY,mcc INTEGER,mnc INTEGER,pciNo INTEGER,tac INTEGER,cellId INTEGER," +
                "peri INTEGER,reqNumOUT INTEGER,reqNumIN INTEGER,boolMeasureOUT INTEGER,boolMeasureIN INTEGER," +
                "tauRejOUT INTEGER,tauRejIN INTEGER,attRejOUT INTEGER,attRejIN INTEGER,ratOUT INTEGER,ratIN INTEGER," +
                "carrierOUT INTEGER,carrierIN INTEGER,priorityOUT INTEGER,priorityIN INTEGER,cellIN INTEGER)");
    }

    private void add(SysConfigDao dao){
        db.beginTransaction();
        try {
            insertOrUpdate(dao);
            db.setTransactionSuccessful();
        } finally {
            db.endTransaction();
        }


    }

    public void insertOrUpdate(SysConfigDao dao) {
        if (!isExistsByName(dao.Sysno)) {
          //  insert(dao);
        } else {
          //  update(dao);
        }

    }

    public boolean isExistsByName(int name) {
       // return isExistsByField("name", name);
        return true;
    }


}
