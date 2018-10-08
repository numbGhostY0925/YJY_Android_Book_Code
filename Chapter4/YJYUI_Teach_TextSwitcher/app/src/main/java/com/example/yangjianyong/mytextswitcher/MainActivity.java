package com.example.yangjianyong.mytextswitcher;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextSwitcher;
import android.widget.TextView;
import android.widget.ViewSwitcher;

import java.text.SimpleDateFormat;
import java.util.Date;

public class MainActivity extends Activity {

    //0.声明需要的控件
    private  TextSwitcher myTextSwitcher=null;
    private Button but=null;
    private int index=0;
    private String strshow=null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //1.	加载布局文件
        setContentView(R.layout.activity_main);
        //2.	找到布局文件中的控件
        this.myTextSwitcher=(TextSwitcher) findViewById(R.id.myTestSwitcher) ;
        this.but=(Button) findViewById(R.id.but);
        //3.	设置主要控件的属性：TextSwitcher 设置视图工厂，设置动画（in/out）
        //3-1设置动画工厂
        this.myTextSwitcher.setFactory(new ViewFactoryImpl());
        //3-2 设置InAnimation   就是淡入的方式
        this.myTextSwitcher.setInAnimation(AnimationUtils.loadAnimation(this,android.R.anim.fade_in));
        //3-3设置outAnimation
        this.myTextSwitcher.setOutAnimation(AnimationUtils.loadAnimation(this,android.R.anim.fade_out));
        //4.	设置按钮的事情，配合TextSwitcher的显示
        this.but.setOnClickListener(new OnClickListenerImpl());
    }

    //3-1设置动画工厂的具体代码
    public class ViewFactoryImpl implements ViewSwitcher.ViewFactory {
        @Override
        public View makeView() {
            // 显示文本动画的视图显示参数
            TextView txt=new TextView(MainActivity.this);
            txt.setBackgroundColor(0xFFFFFFFF);
            txt.setLayoutParams(new TextSwitcher.LayoutParams(
                    LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.MATCH_PARENT));
            txt.setTextSize(20);
            return txt;
        }
    }
    //4. 设置按钮的事情的具体代码
    public class OnClickListenerImpl implements View.OnClickListener {
        @Override
        public void onClick(View v) {
            if (index==5){
                index=0;
            }
            switch(index){
                case 0:strshow="当前的时间是："+new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS").format(new Date());break;
                case 1:strshow=(String)MainActivity.this.getResources().getString(R.string.text2) ;break;
                case 2:strshow=(String)MainActivity.this.getResources().getString(R.string.text3) ;break;
                case 3:strshow=(String)MainActivity.this.getResources().getString(R.string.text4) ;break;
                default:strshow="无话可说" ;break;
            }
            index++;
            MainActivity.this.myTextSwitcher.setText(strshow);
        }
    }
}
