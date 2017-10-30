package com.example.administrator.shopping;

/**
 * Created by Administrator on 2017/10/21.
 */

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;



public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder>{
    private static final String TAG = "MyAdapter";
    private List<Map<String, Object>> datas;
    private List<Info> Infos;
    private char[]cycle;
    private String[] name;
    private LayoutInflater inflater;
    private OnItemClickListener mOnItemClickListener = null;
    private OnItemLongClickListener mOnItemLongClickListener = null;
    public MyAdapter(Context context,List<Info> Infos, List<Map<String, Object>> datas,char[] cycle,String[]name ) {
        this.Infos=Infos;
        this.cycle=cycle;
        this.name=name;
        this.datas = datas;
        inflater = LayoutInflater.from(context); //加载布局
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        TextView title;
        TextView letter;
        public MyViewHolder(View itemView) {
            super(itemView);
            title = (TextView) itemView.findViewById(R.id.rv_main_item_title);
            letter= (TextView) itemView.findViewById(R.id.goods_letter);
        }
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Log.e(TAG, "create a new item");
        MyViewHolder holder = new MyViewHolder(inflater.inflate(R.layout.item_layout, null, false));//若第二个参数设置为parent，则只显示一行
        return holder;
    }

    @Override
    public void onBindViewHolder(final MyViewHolder holder, final int position) { // 将数据与界面进行绑定的操作
       String s=String.valueOf(cycle[position]); //char类型转String类型
        holder.title.setText(name[position].toString());
        holder.letter.setText(s ); //setText函数返回一个String类型的值
        // 点击事件注册及分发
        if(null != mOnItemClickListener) {
            holder.title.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    mOnItemClickListener.onClick(holder.title,holder.getAdapterPosition());
                }
            });
            holder.letter.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    mOnItemClickListener.onClick(holder.letter, holder.getAdapterPosition());
                }
            });
        }
        // 长按事件注册及分发
        if(null != mOnItemLongClickListener) {
            holder.title.setOnLongClickListener(new View.OnLongClickListener() {
                @Override
                public boolean onLongClick(View v) {
                    return mOnItemLongClickListener.onLongClick(holder.title,holder.getAdapterPosition() );
                }
            });
            holder.letter.setOnLongClickListener(new View.OnLongClickListener() {
                @Override
                public boolean onLongClick(View v) {
                    return mOnItemLongClickListener.onLongClick(holder.letter, holder.getAdapterPosition());
                }
            });
        }
    }

    @Override
    public int getItemCount() {
        return datas.size();
    }

    public List<Info> getInfo() {
        if (Infos == null) {
            Infos = new ArrayList<>();
        }
        return Infos;
    }

    public List<Map<String, Object>> getdata() {
        if (datas == null) {
            datas = new ArrayList<>();
        }
        return datas;
    }
    // 设置点击事件
    public void setOnItemClickListener(OnItemClickListener l) {
        this.mOnItemClickListener = l;
    }

    // 设置长按事件
    public void setOnItemLongClickListener(OnItemLongClickListener l) {
        this.mOnItemLongClickListener = l;
    }

    // 点击事件接口
    public interface OnItemClickListener {
        void onClick(View parent, int position);
    }

    // 长按事件接口
    public interface OnItemLongClickListener {
        boolean onLongClick(View parent, int position);
    }
}
