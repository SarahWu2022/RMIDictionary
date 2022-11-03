import java.rmi.Remote;
import java.rmi.RemoteException;
public interface IServerRemote extends Remote{
    void add(String word, String meaning) throws RemoteException;
    String search(String word) throws RemoteException;
    void delete(String word) throws RemoteException;
}
