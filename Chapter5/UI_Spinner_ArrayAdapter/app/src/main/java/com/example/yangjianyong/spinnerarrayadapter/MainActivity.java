package com.example.yangjianyong.spinnerarrayadapter;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends Activity {

    //步骤1：声明需用的控件
    private Spinner spiCity=null;
    private Spinner  spiColor=null;
    private Spinner  spiEud=null;
    //步骤1-2:声明适配器
    //装载在资源中的字符串数组，需要用到一个适配器
    private ArrayAdapter<CharSequence> adapterColor=null;
    private   ArrayAdapter<CharSequence>   adapterEdu=null;
    //步骤1-3声明一个List集合
    private List<CharSequence> dataEdu=null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //步骤2：加载布局文件
        setContentView(R.layout.activity_main);
        //步骤3：找到声明的那些控件
        spiCity=(Spinner) findViewById(R.id.mycity);
        //步骤6：编写Spinner的点击事件
        this.spiCity.setOnItemSelectedListener(new OnItemSelectedListenerImpl());

        //步骤3：找到声明的那些控件
        spiColor=(Spinner) findViewById(R.id.mycolor);
        spiColor.setPrompt("请选择您喜欢的颜色");
        //步骤4：配置需要用的ArrayAdapter
        this.adapterColor=ArrayAdapter.createFromResource(this,
                R.array.color_label,android.R.layout.simple_spinner_item);
        this.adapterColor.setDropDownViewResource(
                android.R.layout.simple_spinner_dropdown_item);
        //步骤5：将Adapter运用到控件上
        this.spiColor.setAdapter(adapterColor);
        //步骤6：编写Spinner的点击事件
        this.spiColor.setOnItemSelectedListener(new OnItemSelectedListenerImpl());

        //使用直接创建的List集合来加载数据
        spiEud=(Spinner) findViewById(R.id.myedu);
        //步骤7.创建一个List集合
        this.dataEdu=new ArrayList<CharSequence>();
        this.dataEdu.add("初中");
        this.dataEdu.add("高中");
        this.dataEdu.add("大学");
        this.dataEdu.add("硕士");
        this.dataEdu.add("博士");
        this.adapterEdu=new ArrayAdapter<CharSequence>(this,
                android.R.layout.simple_spinner_dropdown_item, dataEdu);
        this.adapterEdu.setDropDownViewResource(
                android.R.layout.simple_spinner_dropdown_item);
        this.spiEud.setAdapter(adapterEdu);
        this.spiEud.setOnItemSelectedListener(new OnItemSelectedListenerImpl());
    }


    public class OnItemSelectedListenerImpl implements AdapterView.OnItemSelectedListener {
        @Override
        public void onItemSelected(AdapterView<?> parent , View view, int position,
                                   long id) {
            // 获得当前选择的条目信息,并 赋给字符串变量
            String valuestring=parent.getItemAtPosition(position).toString();
            Toast.makeText(MainActivity.this,
                    "您选择的是:"+valuestring,Toast.LENGTH_SHORT).show();
        }
        @Override
        public void onNothingSelected(AdapterView<?> arg0) {
            // TODO Auto-generated method stub
        }
    }
}
