package com.iontrading.sample;
import com.google.inject.Binder.*;
import com.google.inject.AbstractModule;
import com.iontrading.isf.boot.guice.BootModule;
import com.iontrading.isf.boot.spi.IBootService;
import com.iontrading.isf.boot.spi.IService;
import com.iontrading.isf.modules.annotation.ModuleDescriptor;

@ModuleDescriptor(requires = {BootModule.class})
public class ApplicationModule extends AbstractModule {
    @Override
    protected void configure() {
        BootModule.registerBootService(binder(), (Class<? extends IService>) BasicProducer.class, IBootService.RunPhase.RUNNING);
        BootModule.registerBootService(binder(),(Class<? extends IService>) BasicConsumer.class, IBootService.RunPhase.START);
    }
}

