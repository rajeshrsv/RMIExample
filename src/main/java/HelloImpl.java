import java.net.MalformedURLException;
import java.rmi.AlreadyBoundException;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class HelloImpl extends UnicastRemoteObject implements Hello {

    public HelloImpl() throws RemoteException {}

    @Override
    public String SayHello() throws RemoteException {
        return "Hello world!!";
    }

    public static void main(final String[] args) {
        try {
            final HelloImpl helloImpl = new HelloImpl();

            Naming.bind("HelloServer", helloImpl);

        } catch (final RemoteException | MalformedURLException | AlreadyBoundException e) {
            System.out.println("**** HELLO IMPL ERR : " + e);
        }

    }

}
