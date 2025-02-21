package com.iontrading.sample;

import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Date;

public class COOLJavaBean {
    private static Integer id=0;
    public Integer identifier;
    public String name;
    public Date birthday;
    public Date deathday;
    public ArrayList<String> favourites;

    public COOLJavaBean() {
        this.identifier=id;
        incrementor();
        this.name="COOL JAVA BEAN NO:"+String.valueOf(id);
    }
    private static void incrementor(){
        id++;
    }
}
