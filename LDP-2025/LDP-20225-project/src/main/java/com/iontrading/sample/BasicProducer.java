package com.iontrading.sample;
import com.iontrading.isf.boot.spi.IService;

public class BasicProducer implements IService {
    public String getName(){
        return "Basically A COOL Producer";
    }
    public void start() throws Exception{
        System.out.println(getName() + " is starting...");
    }
    public void shutdown(){
        System.out.println(getName() + " is shutting down...");
    }
}
