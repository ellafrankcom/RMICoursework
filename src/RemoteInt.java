import java.rmi.Remote;
import java.rmi.RemoteException;

public interface RemoteInt extends Remote {
    void serializable() throws RemoteException;
}
