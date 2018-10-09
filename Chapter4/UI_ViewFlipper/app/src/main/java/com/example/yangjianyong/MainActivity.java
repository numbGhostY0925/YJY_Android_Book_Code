package com.example.yangjianyong;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.ViewFlipper;

public class MainActivity extends Activity {

    //步骤1：声明程序中存在这样的一个控件
    private ViewFlipper viewFlipper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //步骤2：找到这个控件
        viewFlipper=(ViewFlipper) findViewById(R.id.details);
        // 步骤3：编写每个按钮的动画动作
    }
    public  void down(View source){
        //设置ViewFlipper控件的淡入淡出方式，方式的文件要自己写
        viewFlipper.setInAnimation(this,R.anim.slide_in_top);
        viewFlipper.setOutAnimation(this, R.anim.slide_out_bottom);
        viewFlipper.showNext();
        viewFlipper.stopFlipping();
    }
    public void up(View source){
        viewFlipper.setInAnimation(this,R.anim.slide_in_bottom);
        viewFlipper.setOutAnimation(this, R.anim.slide_out_top);
        viewFlipper.showNext();
        viewFlipper.stopFlipping();
    }
    public void autoupdown(View source){
        viewFlipper.setInAnimation(this,R.anim.slide_in_top);
        viewFlipper.setOutAnimation(this, R.anim.slide_out_bottom);
        viewFlipper.startFlipping();
    }
    public  void prev(View  source){
        //设置ViewFlipper控件的淡入淡出方式，方式的文件要自己写
        viewFlipper.setInAnimation(this,R.anim.slide_in_right);
        viewFlipper.setOutAnimation(this, R.anim.slide_out_left);
        viewFlipper.showNext();
        viewFlipper.stopFlipping();
    }
    public void next(View source){
        viewFlipper.setInAnimation(this,android.R.anim.slide_in_left);
        viewFlipper.setOutAnimation(this,android.R.anim.slide_out_right);
        viewFlipper.showNext();
        viewFlipper.stopFlipping();
    }
    public void auto(View source){
        viewFlipper.setInAnimation(this,android.R.anim.slide_in_left);
        viewFlipper.setOutAnimation(this,android.R.anim.slide_out_right);
        viewFlipper.startFlipping();
    }

}
