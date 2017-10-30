package com.example.administrator.shopping;

import android.app.Application;

import java.util.List;

/**
 * Created by Administrator on 2017/10/27.
 */

public class Shopcar extends Application{
    private List<Info> s;
    public void setS(List<Info> s){
        this.s=s;
    }
    public List<Info> getS(){
        return s;
    }

}
