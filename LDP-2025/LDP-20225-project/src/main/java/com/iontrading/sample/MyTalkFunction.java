package com.iontrading.sample;

import com.iontrading.isf.commons.async.AsyncResult;
import com.iontrading.isf.commons.async.AsyncResultPromise;
import com.iontrading.isf.commons.async.AsyncResults;
import com.iontrading.talk.api.exception.TalkException;
import com.iontrading.talk.ionbus.spi.IonBusInfo;

public class MyTalkFunction implements TalkBusInterface{
    @Override
    public AsyncResult<String> orderAdd(COOLJavaBean COOLBean, String userTag,IonBusInfo busInfo) {
        AsyncResultPromise<String> result= AsyncResults.create();
        if(result.isDone() && COOLBean.identifier.equals(2)){
            System.out.println("I FOUND THE BEAN :)))))");
            result.success("Bean No: "+String.valueOf(COOLBean.identifier)+" Was found");
        }
        else{
            System.out.println("NO YOU FAILED :((((");
            result.failure(new TalkException("NO, try again"));
        }
        return result;
    }
}
