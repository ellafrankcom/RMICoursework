import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class Client {
    private Client(){}
    public static void main(String[] args){
        try{
            //Get the registry
            Registry registry = LocateRegistry.getRegistry(null);

            //look up registry for remote object
            RemoteInt expo = (RemoteInt) registry.lookup("RemoteInt");

            expo.serializable();
            System.out.println("Method invoked");


        }
        catch(Exception e){
            System.err.println("Client exception: " + e.toString());
            e.printStackTrace();
        }
    }
}
