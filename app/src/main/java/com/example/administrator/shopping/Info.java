package com.example.administrator.shopping;
import java.io.Serializable;
/**
 * Created by Administrator on 2017/10/23.
 */

public class Info implements Serializable{
    public Info(String name,String price,String Inf,String information,int background){
        this.name=name;
        this.price=price;
        this.Inf=Inf;
        this.information=information;
        this.background=background;
    }
    public int getbackgound(){
        return background;
    }
    public void setBackground(int background) {
        this.background = background;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public String getPrice() {
        return price;
    }
    public void setPrice(String price) {
        this.price = price;
    }

    public String getInf() {
        return Inf;
    }
    public void setInf(String Inf) {
        this.Inf = Inf;
    }

    public String getInformation() {
        return information;
    }
    public void setInformation(String information) {
        this.information= information;
    }

    public char getcycle() {
        char first = name.charAt(0);
        if (first >= 97 && first <= 122) {
            first -= 32;
        }
        return first;
    }
    private int background;
    private String price;
    private String information;
    private String name;
    private String Inf;
}
