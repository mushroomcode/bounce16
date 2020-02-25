package com.FutureBounce;

import com.FutureBounce.CallablesBean.ASingletonTask;
import com.FutureBounce.CallablesBean.Event;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

/**
 * Create by Joyyue sheting on 2020/2/23
 */
public class FutureBounceStartor {

    public static void main(String[] args) {
        List<FutureTask> futureTasks = new ArrayList<>();

        Event e1 = new Event();
        Event e2 = new Event();
        Event e3 = new Event();
        e1.setContent("It ");
        e2.setContent("is ");
        e3.setContent("hardLife !");

        ASingletonTask a1 = new ASingletonTask(e1);
        ASingletonTask a2 = new ASingletonTask(e2);
        ASingletonTask a3 = new ASingletonTask(e3);

        FutureTask<Object> f1 = new FutureTask<>(a1);

//        CompletableFuture<>

        futureTasks.add(f1);
        futureTasks.add(new FutureTask(a2));
        futureTasks.add(new FutureTask(a3));
        ExecutorService service = Executors.newCachedThreadPool();
        try {

            for(int i = 0;i < futureTasks.size(); ++ i) {

                futureTasks.get(i).run();
//                new Thread(futureTasks.get(i)).start();
                System.out.println("has been running!");
//                service.submit(futureTasks.get(i));
            }
//            service.shutdown();

            for(int i = 0;i < futureTasks.size(); ++ i) {
                Event event = (Event) futureTasks.get(i).get();
                System.out.println(i);
            }
        }
        catch (CancellationException c1) {
            c1.printStackTrace();
        }
        catch (InterruptedException i1) {
            i1.printStackTrace();
        }
        catch (Exception e) {
            e.printStackTrace();
        }


    }

}
