package com.FutureBounce.CallablesBean;

import java.util.concurrent.Callable;

/**
 * Create by Joyyue sheting on 2020/2/23
 */
public class ASingletonTask implements Callable<Object> {

    private Event event;

    public ASingletonTask() {

    }

    public ASingletonTask(Event event) {
        this.event = event;
    }

    @Override
    public Object call() throws Exception {
        System.out.println(event.getContent());
        Thread.sleep(5000);
        return this.event;
    }
}
