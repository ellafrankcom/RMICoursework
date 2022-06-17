import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

public class Client {
    private Client(){}
    public static void main(String[] args){
        try{
            //Get the registry
            Registry registry = LocateRegistry.getRegistry(null);

            //look up registry for remote object
            //RemoteInt expo = (RemoteInt) registry.lookup("RemoteInt");
            ImpClass object = new ImpClass();
            RemoteInt expo = (RemoteInt) UnicastRemoteObject.exportObject(object, 0);

            expo.serializable();
            System.out.println("Method invoked");

        }
        catch(Exception e){
            System.err.println("Client exception: " + e.toString());
            e.printStackTrace();
        }
    }
}
