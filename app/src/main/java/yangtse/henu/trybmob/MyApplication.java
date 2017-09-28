package yangtse.henu.trybmob;

import android.app.Application;

import cn.bmob.v3.Bmob;

/**
 * Created by Yangtse on 2017/9/28.
 */

public class MyApplication extends Application {
    private String ApplicationID="813e670d69dde5067b2ed1b2a275ed13";
    @Override
    public void onCreate() {
        super.onCreate();
        Bmob.initialize(this,ApplicationID);
    }
}
