package sino.com.ltetest.Dao.SysConfig.Users;

import java.net.PasswordAuthentication;

/**
 * Created by 刘洋旭 on 2016/8/26.
 */
public class UsersDao {
    public String username;
    public String password;
    public String count;
    public UsersDao(){
        username="admin";
        password="admin";
        this.count = "";
    }
    public UsersDao(String username,String password,String count){
        this.username=username;
        this.password=password;
        this.count = count;
    }
}
