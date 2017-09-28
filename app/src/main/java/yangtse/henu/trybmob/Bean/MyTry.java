package yangtse.henu.trybmob.Bean;

import cn.bmob.v3.BmobObject;

/**
 * Created by Yangtse on 2017/9/28.
 */

public class MyTry extends BmobObject {
    private String try1;
    private String try2;
    private String try3;
    public void setTry1(String try1){this.try1=try1;}
    public String getTry1(){return try1;}
    public void setTry2(String try2){this.try2=try2;}
    public String getTry2(){return try2;}
    public void setTry3(String try3){this.try3=try3;}
    public String getTry3(){return try3;}
    public MyTry(String try1){
        this.try1=try1;
        this.try2="";
        this.try3="";
    }
    public MyTry(){}
}
