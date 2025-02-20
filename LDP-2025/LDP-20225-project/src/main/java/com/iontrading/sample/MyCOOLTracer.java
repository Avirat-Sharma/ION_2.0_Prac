package com.iontrading.sample;

import com.iontrading.isf.boot.spi.IService;
import com.iontrading.isf.trace.ITracer;
import com.iontrading.isf.trace.ITracerFactory;
import jakarta.inject.Inject;

public class MyCOOLTracer implements IService {
    private final ITracer tracer;
    @Inject
    public MyCOOLTracer(ITracerFactory tracerFactory) {
        this.tracer = tracerFactory.createTracer("MyTradeApp :)))");
    }
    @Override
    public String getName() {
        return "Coolest Tracer";
    }
    @Override
    public void start() throws Exception{
        tracer.INFO().key("OrderApplicationService").action("Processing Start").token("Date","").token("Time","").end();

    }
    @Override
    public void shutdown(){
        tracer.FATAL().key("OrderApplicationService").action("Processing Shutdown").token("Date","").token("Time","").end();
    }
}
