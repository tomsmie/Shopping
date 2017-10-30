package com.example.administrator.shopping;

import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2017/10/23.
 */

public class InfoActivity extends AppCompatActivity {

    @Override

    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info);
        //final Shopcar shopcar=(Shopcar)getApplication();
        final Info p = (Info) getIntent().getSerializableExtra("Info");

        final List<Info> myp=new ArrayList<>();
        Button button=(Button)findViewById(R.id.shopping_list);
        button.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Toast.makeText(InfoActivity.this,"商品已添加到购物车",Toast.LENGTH_SHORT).show();
                myp.add(p);
            }
        });

        ImageView image=(ImageView)findViewById(R.id.Top);
        image.setBackground(getDrawable(p.getbackgound()));

        Button back = (Button) findViewById(R.id.Back);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        TextView Inf = (TextView) findViewById(R.id.info1);
        Inf.setText(p.getInf());

        TextView information = (TextView) findViewById(R.id.info2);
        information.setText(p.getInformation());

        TextView name = (TextView) findViewById(R.id.Name);
        name.setText(p.getName());

        TextView price = (TextView) findViewById(R.id.good_price);
        price.setText(p.getPrice());

        String[] operations1 = new String[]{"更多产品信息"};
        ArrayAdapter<String> arrayAdapter1 = new ArrayAdapter<>(this, R.layout.more_inf, operations1);
        ListView listView1 = (ListView) findViewById(R.id.more);
        listView1.setAdapter(arrayAdapter1);

        String[] operations2 = new String[]{"一键下单", "分享商品", "不感兴趣", "查看更多商品促销信息"};
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<>(this, R.layout.more_inf, operations2);
        ListView listView = (ListView) findViewById(R.id.listview);
        listView.setAdapter(arrayAdapter);

        /*  星星的切换 */
        final Button star = (Button) findViewById(R.id.star);
        star.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!tag) {
                    star.setBackground(getDrawable(R.drawable.full_star));
                    tag = true;
                } else {
                    star.setBackground(getDrawable(R.drawable.empty_star));
                    tag = false;
                }
            }
        });
    }


    private boolean tag = false;
}
