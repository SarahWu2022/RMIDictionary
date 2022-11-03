import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class Client {
    public static void main(String[] args) {

        try {
            //Connect to the rmiregistry that is running on localhost
            Registry registry = LocateRegistry.getRegistry("localhost", 8888);

            //Retrieve the stub/proxy for the remote math object from the registry
            IServerRemote remoteDict = (IServerRemote) registry.lookup("Dict");

            //Call methods on the remote object as if it was a local object
            System.out.println("Client: calling remote methods");

            remoteDict.add("hello","hello");
            remoteDict.add("yes","no");

            String searchResult = remoteDict.search("hello");
            System.out.println(searchResult);

            remoteDict.delete("hello");
            searchResult = remoteDict.search("hello");
            System.out.println(searchResult);

        }catch(Exception e) {
            e.printStackTrace();
        }

    }
}
