package com.iontrading.sample;

import com.iontrading.isf.applicationserver.spi.AS;

public class Main {
    public static void main(String[] args) {
        AS.createLaunchConfiguration()
                .withArgs(args)
                .withModules(ApplicationModule.class)
                .withComponentInfo("My_COOL_APP","COOL ION 2.0 Application","0.0.1","na")
                .launch();
    }
}
