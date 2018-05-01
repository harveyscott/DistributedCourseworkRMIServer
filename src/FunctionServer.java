import java.rmi.AlreadyBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;


public class FunctionServer {
    public static void main(String[] args) throws RemoteException, AlreadyBoundException {
        FunctionImpl function = new FunctionImpl();

        Functions functionsStub = (Functions) UnicastRemoteObject.exportObject(function, 1200);

        Registry registry = LocateRegistry.createRegistry(1099);

        registry.bind("MyFunction", functionsStub);

        System.out.println("Server Waiting");
    }
}
