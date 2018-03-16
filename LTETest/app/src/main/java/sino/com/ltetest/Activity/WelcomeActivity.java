package sino.com.ltetest.Activity;

import android.app.Activity;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;

import sino.com.ltetest.R;

/**
 * Created by 刘洋旭 on 2016/8/31.
 */
public class WelcomeActivity extends Activity {
    private FragmentManager fragmentManager;
    private FragmentTransaction transaction;
    private LoginFragment loginFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.welcome_layout);

        init();
    }

    private void init(){

        transaction=getFragmentManager().beginTransaction();
        loginFragment=new LoginFragment();
        transaction.add(R.id.fragmentPager,loginFragment).commit();


    }
}
