import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RMISecurityManager;
import java.rmi.RemoteException;

public class HelloClient {

    public static void main(final String[] args) {

        System.setSecurityManager(new RMISecurityManager());

        try {
            final Hello hello = (Hello) Naming.lookup("HelloServer");
            System.out.println(hello.SayHello());

        } catch (MalformedURLException | RemoteException | NotBoundException e) {
            System.out.println("COMMUNICATION ERROR : " + e);
        }
    }

}
