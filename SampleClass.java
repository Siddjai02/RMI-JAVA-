import java.io.*;
import java.rmi.*;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.rmi.server.*;
import java.rmi.server.UnicastRemoteObject;
import java.io.*;
import java.math.*;
import javax.crypto.spec.*;
import java.security.*;
import javax.crypto.*;
  
public class SampleClass extends UnicastRemoteObject implements Sample
{
	String g="XXXX";
	byte[] encrypted =new byte[1000000];
	public SampleClass()throws RemoteException
	{
	}
	public String generateOTP()
	{
		try
		{
		int x=(int)Math.random()*(9999-1000+1);
		g=Integer.toString(x);
		
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
		return g;
	}
	public byte[] encrypt(String toEncrypt, String key) throws Exception 
	{
      // create a binary key from the argument key (seed)
      SecureRandom sr = new SecureRandom(key.getBytes());
      KeyGenerator kg = KeyGenerator.getInstance("DESede");
      kg.init(sr);
      SecretKey sk = kg.generateKey();
  
      // create an instance of cipher
      Cipher cipher = Cipher.getInstance("DESede");
  
      // initialize the cipher with the key
      cipher.init(Cipher.ENCRYPT_MODE, sk);
  
      // enctypt!
      byte[] encrypted = cipher.doFinal(toEncrypt.getBytes());
  
      return encrypted;
   }
  
	public String Encrypt(String h)
	{
		  String s="";
		  try
		  {
			  System.out.println("Encrypting...");
			  encrypted = encrypt(h, "password");
			  s=new String(encrypted);
			  System.out.println(s);
			 }
			 catch(Exception e)
			 {
				 System.out.println(e);
				}
			return s;
	}
	public static String decrypt(byte[] toDecrypt, String key) throws Exception {
      // create a binary key from the argument key (seed)
      SecureRandom sr = new SecureRandom(key.getBytes());
      KeyGenerator kg = KeyGenerator.getInstance("DESede");
      kg.init(sr);
      SecretKey sk = kg.generateKey();
  
      // do the decryption with that key
      Cipher cipher = Cipher.getInstance("DESede");
      cipher.init(Cipher.DECRYPT_MODE, sk);
      byte[] decrypted = cipher.doFinal(toDecrypt);
  
      return new String(decrypted);
   }
	public String Decrypt(String h)
	{
		String decrypted="";
		try
		{
		 decrypted= decrypt(encrypted, "password");
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
		return decrypted;
		
	}
}
