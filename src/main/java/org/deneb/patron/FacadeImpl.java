package org.deneb.patron;

public class FacadeImpl implements IFacade {
    private final ScheduleServer server;

    public FacadeImpl(ScheduleServer server){
        this.server = server;
    }
    @Override
    public void startServer() {
        server.readSystemConfigFile();
        server.init();
        server.InitializeContext();
    }

    @Override
    public void stopServer() {
        server.destory();
        server.shutdown();
    }
}
