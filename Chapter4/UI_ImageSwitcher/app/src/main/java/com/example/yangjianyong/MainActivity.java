package com.example.yangjianyong;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageSwitcher;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ViewSwitcher;

public class MainActivity extends Activity {

    //步骤1：装载图片资源
    private int[] imageId=new int[]{R.drawable.image14,R.drawable.image15,R.drawable.image16,
            R.drawable.image17,R.drawable.image18,R.drawable.image19};

    //步骤2：声明程序中用到的控件和变量
    private ImageSwitcher imageSwitcher=null;
    private Button up=null;
    private Button down=null;

    private int index=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //步骤3:加载布局文件
        setContentView(R.layout.activity_main);

        //步骤4:获得程序中的控件
        this.imageSwitcher=(ImageSwitcher) findViewById(R.id.imageswitcher);
        this.up=(Button) findViewById(R.id.button1);
        this.down=(Button) findViewById(R.id.button2);

        //步骤5:设置ImageSwitcher的动画效果
        this.imageSwitcher.setInAnimation(AnimationUtils.loadAnimation(this, android.R.anim.fade_in));
        this.imageSwitcher.setOutAnimation(AnimationUtils.loadAnimation(this, android.R.anim.fade_out));

        //步骤6:设置ImageSwitcher控件的视图工厂
        this.imageSwitcher.setFactory(new ViewSwitcher.ViewFactory() {
            @Override
            public View makeView() {
                //设置返回的View类型，因为在setFactory方法中。所以context使用MainActivity.this，不能直接使用this
                ImageView imageView=new ImageView(MainActivity.this);
                //设置图片的显示模式,自适应居中
                imageView.setScaleType(ImageView.ScaleType.FIT_CENTER);
                //图片的尺寸
                imageView.setLayoutParams(new ImageSwitcher.LayoutParams(
                        LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT
                ));
                return imageView;
            }
        });
        //步骤7:显示ImageSwitcher的默认图片
        imageSwitcher.setImageResource(imageId[index]);

        //步骤8:两个按钮的点击事件，点击之后可以切换图片
        up.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {//每点击一次按钮，就获得当前图片的上一张图片
                if (index>0){
                    index--;
                }else{
                    index=imageId.length-1;
                }
                imageSwitcher.setImageResource(imageId[index]);
            }
        });

        down.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //在index自增之前，必须检查是否在数组下标的范围之内
                //可以加的值为0,1,2,3,4。 到5就不能加了
                if (index<imageId.length-1){
                    index++;
                }else{
                    index=0;
                }
                imageSwitcher.setImageResource(imageId[index]);
            }
        });
    }
}
