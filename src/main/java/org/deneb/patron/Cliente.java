package org.deneb.patron;

public class Cliente {
	
	// https://itquetzali.com/2019/11/08/patron-de-diseno-facade-java/
	
    public static void main (String [] args){
        ScheduleServer server = new ScheduleServer();

        IFacade facade = new FacadeImpl(server);
        facade.startServer();
        System.out.println("Start server");
        facade.stopServer();
        System.out.println("Stop server");
    }
}
