package com.iontrading.sample;

import com.iontrading.isf.commons.async.AsyncResult;
import com.iontrading.talk.api.annotation.TalkFunction;
import com.iontrading.talk.api.annotation.TalkParam;
import com.iontrading.talk.ionbus.spi.IonBusInfo;

public  interface TalkBusInterface {
    @TalkFunction(name="AddNewOrder")
    AsyncResult<String> orderAdd(
            @TalkParam(name="COOLBean") COOLJavaBean COOLBean,
            @TalkParam(name="UserTag",nullable = true) String userTag,
            IonBusInfo busInfo
            );
}
