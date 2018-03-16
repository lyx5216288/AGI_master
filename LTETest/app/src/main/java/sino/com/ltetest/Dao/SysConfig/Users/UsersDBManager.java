package sino.com.ltetest.Dao.SysConfig.Users;

import android.content.ContentValues;
import android.content.Context;


import net.sqlcipher.Cursor;
import net.sqlcipher.database.SQLiteDatabase;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by 刘洋旭 on 2016/8/26.
 */
public class UsersDBManager {
    public UsersDBHelper helper;
    public SQLiteDatabase db;


    public UsersDBManager(Context context) {
        helper = new UsersDBHelper(context.getApplicationContext());
        db = helper.getWritableDatabase("111111");
        db.execSQL("CREATE TABLE IF NOT EXISTS " + UsersDBHelper.TABLE_NAME +
                "(name TEXT PRIMARY KEY, password TEXT, count TEXT)");
    }

    public void add(List<UsersDao> users){
        db.beginTransaction();  //开始事务
        try {
            for (UsersDao t : users) {
                db.execSQL("INSERT INTO "+UsersDBHelper.TABLE_NAME+" VALUES(?, ?,?)", new Object[]{t.username,t.password,t.count});
            }
            db.setTransactionSuccessful();  //设置事务成功完成
        } finally {
            db.endTransaction();    //结束事务
        }
    }

    public void clear(){
        String sql = "DELETE FROM " + UsersDBHelper.TABLE_NAME;
        db.execSQL(sql);
    }

    private void updateByField(String field, String key, String value) {
        ContentValues cv = new ContentValues();
        cv.put(field, value);
        db.update(UsersDBHelper.TABLE_NAME, cv, "name = ?", new String[]{key});
    }

    public void updateName(String from, String to) {
        updateByField("name", from, to);
    }

    public void updatePwd(String name, String newPwd) {
        updateByField("password", name, newPwd);
    }

    public void updateCount(String name, String newCount){
        updateByField("count", name, newCount);
    }

    private int deleteByField(String field, String value) {
        return db.delete(UsersDBHelper.TABLE_NAME, field + "=?", new String[]{value});
    }

    public int deleteByName(String name) {
        return deleteByField("name", name);
    }

    public String getPwdByName(String name) {
        Cursor c = db.rawQuery("SELECT password FROM " + UsersDBHelper.TABLE_NAME + " where name = ? ", new String[]{name});
        String pwd = null;
        if (c.moveToNext()) {
            pwd = c.getString(c.getColumnIndex("password"));
        }
        c.close();
        return pwd;
    }

    public boolean isExistsByField(String field, String value) {
        StringBuilder sql = new StringBuilder();
        sql.append("SELECT COUNT(*) FROM ").append(UsersDBHelper.TABLE_NAME).append(" WHERE ")
                .append(field).append(" =?");

        return isExistsBySQL(sql.toString(), new String[]{field, value});
    }

    private boolean isExistsBySQL(String sql, String[] selectionArgs) {
        boolean result = false;

        final Cursor c = db.rawQuery(sql, selectionArgs);
        try {
            if (c.moveToFirst()) {
                result = (c.getInt(0) > 0);
            }
        } finally {
            c.close();
        }
        return result;
    }

    public List<UsersDao> listDB() {
//        String sql = "SELECT name, password, count FROM " + UsersDBHelper.TABLE_NAME;
        SQLiteDatabase db1=helper.getReadableDatabase("111111");
        String[] colnums={"name","password","count"};
//        Cursor c = db1.rawQuery(sql, new String[]{});
        Cursor c = db1.query(UsersDBHelper.TABLE_NAME,colnums,null,null,null,null,null);
        List<UsersDao> users = new ArrayList<>();
        while (c.moveToNext()) {
            String name = c.getString(c.getColumnIndex("name"));
            String pwd = c.getString(c.getColumnIndex("password"));
            String count = c.getString(c.getColumnIndex("count"));
            UsersDao user = new UsersDao(name, pwd, count);
            users.add(user);
        }
        c.close();
        return users;
    }

    public void closeDB() {
        db.close();
    }

    public void dropTable() {
        String sql = "DROP TABLE " + UsersDBHelper.TABLE_NAME;
        db.execSQL(sql);
    }

    public void createTable() {
        db.execSQL("CREATE TABLE IF NOT EXISTS " + UsersDBHelper.TABLE_NAME +
                "(name TEXT PRIMARY KEY, password TEXT, count TEXT)");
    }
}
