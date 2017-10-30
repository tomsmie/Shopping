package com.example.administrator.shopping;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import static android.R.attr.name;
import static android.R.interpolator.cycle;

/**
 * Created by Administrator on 2017/10/26.
 */

public class Shoppinglist extends AppCompatActivity {
    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.shopping_list);
//        final Shopcar shopcar=(Shopcar)getApplication();
//        List<Info>li=shopcar.getS();
//        List<Map<String, Object>> datas = new ArrayList<>();
//        for(int i=0;i<li.size();i++){
//            Map<String, Object> temp = new LinkedHashMap<>();
//            temp.put("letter",li.get(i).getcycle());
//            temp.put("name",li.get(i).getName());
//            temp.put("price",li.get(i).getPrice());
//            datas.add(temp);
//        }
//        InfoActivity in=new InfoActivity();
//        ListView list=(ListView)findViewById(R.id.myshopping);
//        SimpleAdapter simpleadapter= new SimpleAdapter(this,datas,R.layout.shopping_list,new String[]{"letter","name","price"},new int[]{R.id.token2,R.id.list2,R.id.price2});
//        list.setAdapter(simpleadapter);
    }
}