import netscape.javascript.JSObject;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.Objects;

public class ServerRemote extends UnicastRemoteObject implements IServerRemote {
    JSONObject dict = new JSONObject();

    protected ServerRemote() throws RemoteException {
        dict.put("initial", "meaning");
    }


    @Override
    public void add(String word, String meaning) throws RemoteException {
        dict.put(word, meaning);
    }

    @Override
    public String search(String word) throws RemoteException {
        String meaning = (String) dict.get(word);
        System.out.println(Objects.requireNonNullElse(meaning, "This word does not exist"));
        return meaning;
    }

    @Override
    public void delete(String word) throws RemoteException {
        dict.remove(word);
    }
}
