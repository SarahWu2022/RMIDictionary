import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class Server {
    public static void main(String[] args)  {
        try {
            IServerRemote remoteDict = new ServerRemote();
            Registry registry = LocateRegistry.createRegistry(8888);
            LocateRegistry.createRegistry(1888);
            registry.bind("Dict", remoteDict);
            System.out.println("Dict server is ready ... Waiting for Connections");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
