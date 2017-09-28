package yangtse.henu.trybmob;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.util.List;

import cn.bmob.v3.BmobObject;
import cn.bmob.v3.BmobQuery;
import cn.bmob.v3.exception.BmobException;
import cn.bmob.v3.listener.FindListener;
import cn.bmob.v3.listener.SaveListener;
import cn.bmob.v3.listener.UpdateListener;
import yangtse.henu.trybmob.Bean.MyTry;
///高逸博测速sdkfjfhd撒打算33高富帅东风股份

public class MainActivity extends AppCompatActivity {
    private Button btn_main_add,btn_main_fix;
    private Context context;
    private String objectId="";
    private static String TAG="MainActivity";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        context=this;
        btn_main_add=(Button)findViewById(R.id.btn_main_add);
        btn_main_fix=(Button)findViewById(R.id.btn_main_fix);
        btn_main_fix.setOnClickListener(new MyClickListener());
        btn_main_add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MyTry t=new MyTry("1");
                t.save(new SaveListener<String>() {
                    @Override
                    public void done(String s, BmobException e) {
                        if(e==null){
                            ShowMessage("success");
                        }
                    }
                });
            }
        });
    }
    class MyClickListener implements View.OnClickListener{

        @Override
        public void onClick(View v) {
            switch (v.getId()){
                case R.id.btn_main_fix:
                    BmobQuery<MyTry>query=new BmobQuery<MyTry>();
                    query.addWhereEqualTo("try1","1");
                    query.findObjects(new FindListener<MyTry>() {
                        @Override
                        public void done(List<MyTry> list, BmobException e) {
                            if(e==null){
                                for(MyTry t:list){
                                    objectId=t.getObjectId();
                                    Log.d(TAG, objectId);
                                    MyTry t2=new MyTry();
                                    t2.setValue("try2","2");
                                    t2.setValue("try3","3");
                                    t2.update(objectId, new UpdateListener() {
                                        @Override
                                        public void done(BmobException e) {
                                            if(e==null){
                                                Log.d(TAG, "更新成功");
                                            }else{
                                                Log.d(TAG, "Exception："+e.getMessage());
                                            }
                                        }
                                    });
                                }
                            }
                        }
                    });
                    break;
            }
        }
    }
    public void ShowMessage(String s){
        Toast.makeText(context,s,Toast.LENGTH_SHORT).show();
    }
}
