package org.deneb.patron;

public class ScheduleServer {

    public void readSystemConfigFile(){
        System.out.println("Reading system config files...");
        try {
            Thread.sleep(50);
            System.out.println("config files Ok!");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    public void init(){
        System.out.println("Initializing");
    }
    public void InitializeContext(){
        System.out.println("Initializing context");
    }
    public void destory(){
        System.out.println("Destroying");
    }
    public void shutdown(){
        System.out.println("Shutdown down...");
    }

}
