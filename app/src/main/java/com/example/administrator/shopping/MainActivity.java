package com.example.administrator.shopping;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;
import android.widget.AdapterView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.SimpleAdapter;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import static android.support.constraint.R.id.parent;

public class MainActivity extends AppCompatActivity implements MyAdapter.OnItemClickListener, MyAdapter.OnItemLongClickListener{

    //private static final String TAG= "MainActivity";
    private RecyclerView mRecyclerView;
    private MyAdapter mMyAdapter;


    //View v1=layoutInflater.inflate(R.layout.activity_main,null);
    //View v2=layoutInflater.inflate(R.layout.shopping_list,null);
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final RelativeLayout relativeLayout=(RelativeLayout)findViewById(R.id.shop);
        relativeLayout.setVisibility(View.INVISIBLE);
        final FloatingActionButton fab=(FloatingActionButton)findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!tag) {
                    fab.setImageResource(R.drawable.mainpage);
                    tag = true;
                    mRecyclerView.setVisibility(View.INVISIBLE);
                    relativeLayout.setVisibility(View.VISIBLE);
//                    Intent intent=new Intent(MainActivity.this,Shoppinglist.class);
//                    startActivity(intent);

                } else {
                    fab.setImageResource(R.drawable.shoplist);
                    tag = false;
                    mRecyclerView.setVisibility(View.VISIBLE);
                    relativeLayout.setVisibility(View.INVISIBLE);

                }
            }
        });
        final List<Map<String, Object>> datas = new ArrayList<>();
        List<Info> Infos=initData();

        final char[] cycle =new char[Infos.size()];//十件商品
        final String[] name =new String[Infos.size()];
        for (int i = 0; i < Infos.size(); i++) {
            char x = Infos.get(i).getcycle();
            cycle[i] = x;
        }
        for(int i=0;i<Infos.size();i++){
            name[i] = Infos.get(i).getName();
        }
        for (int i = 0; i < Infos.size(); i++) {
            Map<String, Object> temp = new LinkedHashMap<>();
            temp.put("cycle", cycle[i]);
            temp.put("name", name[i]);
            datas.add(temp);
        }

        mRecyclerView = (RecyclerView) findViewById(R.id.rv_main);
        mMyAdapter = new MyAdapter(MainActivity.this, Infos,datas,cycle,name);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);//一开始没有设置布局管理器，启动后的界面是空白界面
        //设置布局管理器
        mRecyclerView.setLayoutManager(layoutManager);
        mMyAdapter.setOnItemClickListener(this);
        mMyAdapter.setOnItemLongClickListener(this);
        mRecyclerView.setItemAnimator(new DefaultItemAnimator());
        mRecyclerView.setAdapter(mMyAdapter);

    }
    public List<Info> initData(){
        List<Info> Infos = new ArrayList<Info>() {{
            add(new Info("Enchated Forest", "￥5.00", "作者", "Johanna Basford", R.drawable.enchatedforest));
            add(new Info("Arla Mile", "￥59.00", "产地", "德国", R.drawable.arla));
            add(new Info("Devondale Mile", "￥79.00", "产地", "澳大利亚", R.drawable.devondale));
            add(new Info("Kindle Oasis", "￥2399.00", "版本", "8GB", R.drawable.kindle));
            add(new Info("waitrose 早餐麦片", "￥179.00", "重量", "2Kg", R.drawable.waitrose));
            add(new Info("Mcvitie's 饼干", "￥14.90", "产地", "英国", R.drawable.mcvitie));
            add(new Info("Ferrero Rocher", "￥132.59", "重量", "300g", R.drawable.ferrero));
            add(new Info("Maltesers", "￥141.43", "重量", "118g", R.drawable.maltesers));
            add(new Info("Lindt", "￥139.43", "重量", "249g", R.drawable.lindt));
            add(new Info("Borggreve", "￥28.90", "重量", "640g", R.drawable.borggreve));
        }};
        return Infos;
    }

    public void onClick(View parent, int position) {
        Intent intent = new Intent(MainActivity.this, InfoActivity.class);
        Info temp=mMyAdapter.getInfo().get(position);
        intent.putExtra("Info",temp);
        startActivity(intent);

    }

    @Override
    public boolean onLongClick(final View parent, final int position) {

        //return true;
        Info temp=mMyAdapter.getInfo().get(position);
        AlertDialog.Builder message=new AlertDialog.Builder(MainActivity.this);
        message.setTitle("删除商品");
        message.setMessage("确定删除商品" + temp.getName());
        message.setPositiveButton("确定", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialogInterface, int i) {

                mMyAdapter.getdata().remove(position);
                mMyAdapter.getInfo().remove(position);
                mMyAdapter.notifyItemRemoved(position);
                Toast.makeText(MainActivity.this, "删除了第" + (position + 1) + "项", Toast.LENGTH_LONG).show();
            }
        });
        message.setNegativeButton("取消", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialogInterface, int i) {
            }
        });
        message.create().show();
        return true;
    }


    private boolean tag = false;
}
