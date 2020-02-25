package com.FutureBounce;

import java.util.concurrent.*;

/**
 * Create by Joyyue sheting on 2020/2/23
 */
public class DemoRunning {

    private final ConcurrentHashMap<Object, Future<String>> map = new ConcurrentHashMap();

    private String executionTask(final String taskName) {
        while (true) {
            Future<String> future = map.get(taskName);

            if(future == null) {
                Callable<String> task = new Callable<String>()  {
                    @Override
                    public String call() throws Exception {
                        System.out.println("has been call!");
                        return null;
                    }
                };
                FutureTask<String> futureTask = new FutureTask<String>(task);
                future = map.putIfAbsent(taskName, futureTask);
                if (future == null) {
                    future = futureTask;
                    futureTask.run();
                }
            }
            try {
                return future.get();
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (ExecutionException e) {
                e.printStackTrace();
            }

        }
    }

    public static void main(String[] args) {
        DemoRunning new1 = new DemoRunning();
        String name = new1.executionTask("error_wrong");
        System.out.println(name);
    }

}
