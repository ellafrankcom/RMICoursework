import java.rmi.registry.Registry;
import java.rmi.registry.LocateRegistry;
import java.rmi.server.UnicastRemoteObject;

public class Server extends ImpClass{
    public Server(){}
    public static void main(String args[]){
        try{
            //instantiating implementation class
            ImpClass object = new ImpClass();

            //Exporting object of imp class
            RemoteInt expo = (RemoteInt) UnicastRemoteObject.exportObject(object, 0);

            //Binding remote object in registry
            Registry registry = LocateRegistry.getRegistry();
            registry.bind("RemoteInt", expo);
            System.err.println("Server ready...");

        }catch(Exception e){
            System.err.println("Server exception: " + e.toString());
            e.printStackTrace();
        }
    }
}
