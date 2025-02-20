package com.iontrading.sample;

import com.google.inject.Inject;
import com.iontrading.isf.boot.spi.IService;
import com.iontrading.isf.dependency_manager.api.DependencyChangeEvent;
import com.iontrading.isf.dependency_manager.api.DependencyManager;
import com.iontrading.isf.dependency_manager.api.DependencyObserver;
import com.iontrading.isf.dependency_manager.api.DependencySnapshot;
import com.iontrading.isf.dependency_manager.providers.IonBusDependency;
import com.iontrading.isf.service_manager.spi.IBusServiceManager;

public class BasicConsumer implements IService{
    public String getName(){
        return "Basically A COOL Consumer";
    }
    private String currency="200$";
    private String source="Consumer";

    @Inject IBusServiceManager serviceManager;
    @Inject DependencyManager dependencyManager;

    public void start() throws Exception{
        //dependency mgmt
        dependencyManager
                .create(new MyObserver())
                .addInterest(new IonBusDependency("RefData"))
                .start();

        //service mgmt
        serviceManager.addService("MyCoolConsumer",currency,source);
        serviceManager.activateService("MyCoolConsumer");
        System.out.println(getName() + " is starting...");
    }
    public void shutdown(){
        serviceManager.deactivateService("MyCoolConsumer");
        System.out.println(getName() + " is shutting down...");
    }

    public static class MyObserver implements DependencyObserver{
        public void onChange(DependencyChangeEvent event){
            //check if dependencies are available
            for(DependencySnapshot<?> dep:event){
                if(!dep.isAvailable()){
                break;
                }
            }
        }
    }
}
