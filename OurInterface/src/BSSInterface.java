import java.rmi.Remote;
import java.rmi.RemoteException;

public interface BSSInterface extends Remote{

	//dummy signature method to test the whole rmi
	public int add (int num1, int num2) throws RemoteException;
	
}
