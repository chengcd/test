package com.ccd.test.tomcat.fiveService;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by ccd on 2018/2/7.
 */
public final class ThreadPool {
    private final int worker_num;

    private WorkerThread[] workerThreads;
    private List<Runnable> taskQueue = new LinkedList<>();
    private static ThreadPool threadPool;
    public ThreadPool(int worker_num){
        this.worker_num = worker_num;
        workerThreads = new WorkerThread[worker_num];
        for(int i=0;i<worker_num;i++){
            workerThreads[i] = new WorkerThread();
            workerThreads[i].start();
        }
    }

    private class WorkerThread extends Thread{
        public void run(){
            Runnable r = null;
            while(true){
                synchronized (taskQueue){
                    if(!taskQueue.isEmpty()){
                        r= taskQueue.remove(0);
                        r.run();
                    }
                }

            }
        }
    }
}
