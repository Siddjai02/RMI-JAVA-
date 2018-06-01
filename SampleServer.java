import java.io.*;
import java.rmi.*;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.rmi.server.*;
import java.rmi.registry.Registry; 
import java.rmi.registry.LocateRegistry; 
import java.rmi.RemoteException; 
import java.rmi.server.UnicastRemoteObject; 
public class SampleServer
{
	public static void main(String args[])throws RemoteException
	{
		try
		{
			SampleClass s=new SampleClass();
			Naming.rebind("rmi://localhost//Aces",s);
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
	}
}
