import java.io.*;
import java.rmi.*;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.rmi.server.*;
import java.io.*;
import java.rmi.*;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.rmi.server.*;
import java.rmi.registry.Registry; 
import java.rmi.registry.LocateRegistry; 
import java.rmi.RemoteException; 
import java.rmi.server.UnicastRemoteObject;
import java.io.*;
import java.util.*;
public class SampleClient 
{
	public static void main(String args[])
	{
		try
		{
			
				Scanner sc=new Scanner(System.in);
				System.out.println("I want to generate the otp to access" );
				Sample sa=(Sample)Naming.lookup("rmi://localhost//Aces");
				System.out.println(sa.generateOTP());
					
							
		}
		catch(Exception e)
		{
		}
		
	}
}
