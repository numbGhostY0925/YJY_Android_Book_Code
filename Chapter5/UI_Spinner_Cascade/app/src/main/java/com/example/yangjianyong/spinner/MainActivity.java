package com.example.yangjianyong.spinner;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

public class MainActivity extends Activity {

    //步骤1：声明控件
    private Spinner city=null;
    private Spinner   area=null;
    //步骤6: 创建城市对应的数据
    private String[][]  areaData=new String[][]{
            {"天安门","朝阳","海淀"},
            {"相城","常熟","张家港","园区","木渎"},
            {"昆明","大理","昭通","楚雄","玉溪","香格里拉"}
    };
    //步骤7:适配器
    private ArrayAdapter<CharSequence> adapterArea=null;

    //步骤10:转到RES--city_data.xml 添加数据
    //步骤11:声明第2组控件
    private Spinner region=null;
    private Spinner  scenicspot=null;
    //步骤14:定义第2组spinner需要的适配器
    private ArrayAdapter<CharSequence> adapterregion=null;
    private ArrayAdapter<CharSequence> adapterscenicspot=null;
    //步骤17:建立regionSpinner和scenic Spinner的对应关系
    private int[]  scenicspotres=new int[]{R.array.km,R.array.dl,R.array.lj,R.array.xsbn};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //步骤2：加载布局文件
        setContentView(R.layout.activity_main);
        //步骤3:找到声明的控件
        city=(Spinner) findViewById(R.id.city);
        area=(Spinner) findViewById(R.id.area);
        //步骤4:编写事件-选择城市，让对应的spinner获得对应的数据
        city.setOnItemSelectedListener(new OnItemSelectedListenerImpl());

        //步骤12:找到布局文件中第2组spinner
        region=(Spinner) findViewById(R.id.region);
        scenicspot=(Spinner) findViewById(R.id.scenicspot);
        //步骤13:将xml文件的region信息加载到适配器上，转到步骤14定义适配器
        adapterregion=new ArrayAdapter<CharSequence>(this,
                android.R.layout.simple_spinner_dropdown_item,
                this.getResources().getStringArray(R.array.region));
        region.setAdapter(adapterregion); //到这一步，应该能看见第2组spinner的第1个有数据
        //步骤15:编写点击region Spinner控件的事件
        this.region.setOnItemSelectedListener(new OnRegionItemSelectedListenerImpl());
    }

    //步骤16：编写region Spinner的点击事件
    public class OnRegionItemSelectedListenerImpl implements AdapterView.OnItemSelectedListener {
        @Override
        public void onItemSelected(AdapterView<?> parent, View view , int position,
                                   long id) {
            // 获得region Spinner点击的位置之后，找到对应的数据XML里面，用一个数组来对应
            //转到步骤17创建数组
            adapterscenicspot=new ArrayAdapter<CharSequence>(MainActivity.this,
                    android.R.layout.simple_spinner_item,
                    MainActivity.this.getResources().getStringArray(scenicspotres[position]));
            MainActivity.this.scenicspot.setAdapter(MainActivity.this.adapterscenicspot);
        }
        @Override
        public void onNothingSelected(AdapterView<?> arg0) {
            // TODO Auto-generated method stub
        }
    }

    //步骤5:编写Spinner的事件代码
    public class OnItemSelectedListenerImpl implements AdapterView.OnItemSelectedListener {
        @Override
        public void onItemSelected(AdapterView<?> parent, View view, int position,
                                   long id) {
            //因为需要对应的数据，使用二位数组来解决，转到上面的步骤6来定义这个二维数组
            //步骤8:通过点击事件获得信息，将对应的数组信息加载到适配器上
            MainActivity.this.adapterArea=new ArrayAdapter<CharSequence>(MainActivity.this,
                    android.R.layout.simple_spinner_item,
                    MainActivity.this.areaData[position]);
            //步骤9: 将适配器加载到控件上
            MainActivity.this.area.setAdapter(adapterArea);
        }

        @Override
        public void onNothingSelected(AdapterView<?> arg0) {
            // TODO Auto-generated method stub
        }
    }
}
