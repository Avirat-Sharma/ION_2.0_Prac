package com.iontrading.sample;
import com.google.inject.Inject;
import com.iontrading.isf.boot.spi.IService;
import com.iontrading.isf.service_manager.spi.IBusServiceManager;

import java.math.BigDecimal;

public class BasicProducer implements IService {
    public String getName() {
        return "Basically A COOL Producer";
    }
    private String currency="200$";
    private String source="Producer";
    @Inject IBusServiceManager serviceManager;

    public void start() throws Exception{
        serviceManager.addService("MyCoolProducer",currency,source);
        serviceManager.activateService("MyCoolProducer");
        System.out.println(getName() + " is starting...");
    }
    public void shutdown(){
        serviceManager.deactivateService("MyCoolProducer");
        System.out.println(getName() + " is shutting down...");
    }
}
