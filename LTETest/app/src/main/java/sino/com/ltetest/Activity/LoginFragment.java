package sino.com.ltetest.Activity;

import android.app.Fragment;
import android.app.FragmentTransaction;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import net.sqlcipher.database.SQLiteDatabase;

import java.util.ArrayList;
import java.util.List;

import sino.com.ltetest.Dao.SysConfig.Users.UsersDBHelper;
import sino.com.ltetest.Dao.SysConfig.Users.UsersDBManager;
import sino.com.ltetest.Dao.SysConfig.Users.UsersDao;
import sino.com.ltetest.R;

/**
 * Created by 刘洋旭 on 2016/8/31.
 */
public class LoginFragment extends Fragment {
    private final static String CONFIG_DERECTORY = "configure";
    private Button loginBtn;
    private Button manageBtn;
    private EditText usernameEdt;
    private EditText passwordEdt;
    private TextView countText;
    private CheckBox rememberCheck;
    private UsersDBManager dmgr;
    private List<UsersDao> users=new ArrayList<>();
    private FragmentTransaction fragmentTransaction;
    private UserManagerFragment userManageFragment;
    private SharedPreferences sharedPreferences;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.fragment_login,container,false);
        usernameEdt = (EditText) view.findViewById(R.id.welcome_username_edit);
        passwordEdt = (EditText) view.findViewById(R.id.welcome_password_edit);
        countText = (TextView) view.findViewById(R.id.welcome_count_edit);
        loginBtn = (Button) view.findViewById(R.id.welcome_login_button);
        manageBtn = (Button) view.findViewById(R.id.welcome_manage_button);
        rememberCheck = (CheckBox) view.findViewById(R.id.welcome_remember_checkbox);
        sharedPreferences =  getActivity().getSharedPreferences(CONFIG_DERECTORY, Context.MODE_PRIVATE);

        dmgr = new UsersDBManager(getActivity());
        users = dmgr.listDB();
        if (users.size() == 0) {
            UsersDao adminUser = new UsersDao(UsersDBHelper.ADMIN, UsersDBHelper.ADMIN, null);
            UsersDao normalUser = new UsersDao(UsersDBHelper.DEFAUL_NAME, UsersDBHelper.DEFAUL_PASSWORD, UsersDBHelper.DEFAUL_COUNT);
            users.add(adminUser);
            users.add(normalUser);
            dmgr.add(users);

            usernameEdt.setText(normalUser.username);
            passwordEdt.setText(normalUser.password);
            countText.setText(normalUser.count);
        } else {
            String username = sharedPreferences.getString("username", "");
            if (username.equals("")) {
                rememberCheck.setChecked(false);
            } else {
                rememberCheck.setChecked(true);
                for (UsersDao user : users) {
                    if (user.username.equals(username)) {
                        usernameEdt.setText(user.username);
                        passwordEdt.setText(user.password);
                        countText.setText(user.count);
                        break;
                    }
                }
            }
        }

        loginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String username = usernameEdt.getText().toString();
                String password = passwordEdt.getText().toString();
                for (UsersDao user : users) {
                    if (username.equals(user.username) && password.equals(user.password)) {
                        if (!username.equals(UsersDBHelper.ADMIN)) {
                            int count = Integer.valueOf(user.count);
                            if (count == 0) {
                                Toast.makeText(getActivity(), "剩余使用次数不足，无法登陆！", Toast.LENGTH_LONG);
                                return;
                            } else {
                                count--;
                                Toast.makeText(getActivity(), "剩余使用次数:" + count, Toast.LENGTH_LONG).show();
                                dmgr.updateCount(user.username, String.valueOf(count));
                            }
                        }
                        SharedPreferences.Editor editor = sharedPreferences.edit();
                        if (rememberCheck.isChecked()) {
                            editor.putString("username", username);
                        } else {
                            editor.putString("username", "");
                        }
                        editor.commit();
                        startActivity(new Intent(getActivity(), MainActivity.class));
                        getActivity().finish();
                    }
                }
            }
        });
        manageBtn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                String username = usernameEdt.getText().toString();
                String password = passwordEdt.getText().toString();
                for (UsersDao user : users) {
                    if(username.equals(UsersDBHelper.ADMIN) && username.equals(user.username) && password.equals(user.password)) {
                        fragmentTransaction = getFragmentManager().beginTransaction();
                        userManageFragment = new UserManagerFragment();
                        fragmentTransaction.replace(R.id.fragmentPager, userManageFragment);
                        fragmentTransaction.addToBackStack(null);
                        fragmentTransaction.commit();
                    }
                }
            }
        });
        return view;

    }
}
