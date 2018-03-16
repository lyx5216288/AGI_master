package sino.com.ltetest.Dao.SysConfig.Users;

import android.content.Context;
import net.sqlcipher.database.SQLiteDatabase;
import net.sqlcipher.database.SQLiteOpenHelper;

/**
 * Created by 刘洋旭 on 2016/8/26.
 */
public class UsersDBHelper extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "lte.db";
    private static final int DATABASE_VERSION = 1;
    public static final String TABLE_NAME = "users";

    public static final String ADMIN = "admin";
    public static final String DEFAUL_NAME = "user";
    public static final String DEFAUL_PASSWORD = "user";
    public static final String DEFAUL_COUNT = "50";

    public UsersDBHelper(Context context) {
        super(context,DATABASE_NAME, null, DATABASE_VERSION);
        SQLiteDatabase.loadLibs(context);
    }


    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE IF NOT EXISTS " + TABLE_NAME  +
                "(name TEXT PRIMARY KEY,password TEXT,count TEXT)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
