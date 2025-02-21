package com.iontrading.sample;
import com.google.common.util.concurrent.ServiceManager;
import com.google.inject.AbstractModule;
import com.google.inject.Inject;
import com.google.inject.Singleton;
import com.iontrading.isf.boot.guice.BootModule;
import com.iontrading.isf.boot.spi.IBootService;
import com.iontrading.isf.boot.spi.IService;
import com.iontrading.isf.configuration.guice.ConfigurationModule;
import com.iontrading.isf.dependency_manager.providers.guice.ServiceManagerDependencyProviderModule;
import com.iontrading.isf.modules.annotation.ModuleDescriptor;
import com.iontrading.isf.service_manager.guice.ServiceManagerModule;
import com.iontrading.talk.ionbus.guice.TalkIonBusModule;

import java.math.BigDecimal;

@ModuleDescriptor(requires = {BootModule.class, ConfigurationModule.class, ServiceManagerDependencyProviderModule.class, TalkIonBusModule.class})
public class ApplicationModule extends AbstractModule {
    @Override
    protected void configure() {
        //bind configuration
        ConfigurationModule.bindConfigurationGroup(binder(),TradeOrderConfiguration.class);
        //bootstrap
        BootModule.registerBootService(binder(), (Class<? extends IService>) BasicProducer.class, IBootService.RunPhase.RUNNING);
        BootModule.registerBootService(binder(),(Class<? extends IService>) BasicConsumer.class, IBootService.RunPhase.START);
        //activate services
        ServiceManagerModule.addService(binder(),"MyCoolProducer");
        ServiceManagerModule.addService(binder(),"MyCoolConsumer");
        //bind talk class to interface
        bind(TalkBusInterface.class).to(MyTalkFunction.class).in(Singleton.class);
        TalkIonBusModule.exportFunctions(binder(),MyTalkFunction.class);
    }

    public class OrderApplicatioProcessor{
        private String currency;
        private BigDecimal rate;
        @Inject
        private TradeOrderConfiguration orderConfig;

        public void startProcessingOrders() throws Exception{
            this.currency= orderConfig.getOrderCurrency();
            this.rate=orderConfig.getOrderRate();
        }
    }
}

