package sino.com.ltetest.Dao.SysConfig;

import android.content.Context;

import net.sqlcipher.database.SQLiteDatabase;
import net.sqlcipher.database.SQLiteOpenHelper;

/**
 * Created by 刘洋旭 on 2016/8/4.
 */
public class SysConfigDBHelper extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "lte.db";
    private static final int DATABASE_VERSION = 1;

    public static final String TABLE_NAME = "sysconfig";

    public SysConfigDBHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE IF NOT EXISTS " + TABLE_NAME  +
                "(sysNo TEXT PRIMARY KEY,mcc INTEGER,mnc INTEGER,pciNo INTEGER,tac INTEGER,cellId INTEGER," +
                "peri INTEGER,reqNumOUT INTEGER,reqNumIN INTEGER,boolMeasureOUT INTEGER,boolMeasureIN INTEGER," +
                "tauRejOUT INTEGER,tauRejIN INTEGER,attRejOUT INTEGER,attRejIN INTEGER,ratOUT INTEGER,ratIN INTEGER," +
                "carrierOUT INTEGER,carrierIN INTEGER,priorityOUT INTEGER,priorityIN INTEGER,cellIN INTEGER)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
}
