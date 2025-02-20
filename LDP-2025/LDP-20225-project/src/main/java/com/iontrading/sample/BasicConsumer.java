package com.iontrading.sample;

import com.iontrading.isf.boot.spi.IService;

public class BasicConsumer implements IService{
    public String getName(){
        return "Basically A COOL Consumer";
    }
    public void start() throws Exception{
        System.out.println(getName() + " is starting...");
    }
    public void shutdown(){
        System.out.println(getName() + " is shutting down...");
    }
}
