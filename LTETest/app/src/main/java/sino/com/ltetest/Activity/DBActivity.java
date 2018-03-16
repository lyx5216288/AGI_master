package sino.com.ltetest.Activity;

import android.app.Activity;
import android.net.Uri;
import android.os.Bundle;
import android.widget.ListView;

import com.google.android.gms.appindexing.Action;
import com.google.android.gms.appindexing.AppIndex;
import com.google.android.gms.common.api.GoogleApiClient;

import net.sqlcipher.database.SQLiteDatabase;

import java.util.ArrayList;
import java.util.List;

import sino.com.ltetest.Dao.SysConfig.Users.UsersDBManager;
import sino.com.ltetest.Dao.SysConfig.Users.UsersDao;
import sino.com.ltetest.R;

/**
 * Created by 刘洋旭 on 2016/8/26.
 */
public class DBActivity extends Activity {
    public UsersDBManager mgr;
    public List<UsersDao> users;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.finding_directionlayout);
        SQLiteDatabase.loadLibs(this);
//        mgr=new UsersDBManager(this);
//        users=new ArrayList<>();
//        users.add(new UsersDao("111","111"));
//        users.add(new UsersDao("121","121"));
//        mgr.add(users);

    }
}
