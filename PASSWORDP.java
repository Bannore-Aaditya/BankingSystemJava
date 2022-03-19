package details;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.security.SecureRandom;
import java.util.HashMap;
import java.util.Scanner;
import java.io.*;
import java.util.regex.*;
import java.util.*;

public class PASSWORDP 
{
	public static boolean isValid(String password)
    {
  
        // for checking if password length
        // is between 8 and 15
        if (!((password.length() >= 8)
              && (password.length() <= 15))) {
            return false;
        }
  
        // to check space
        if (password.contains(" ")) {
            return false;
        }
        if (true) {
            int count = 0;
  
            // check digits from 0 to 9
            for (int i = 0; i <= 9; i++) {
  
                // to convert int to string
                String str1 = Integer.toString(i);
  
                if (password.contains(str1)) {
                    count = 1;
                }
            }
            if (count == 0) {
                return false;
            }
        }
  
        // for special characters
        if (!(password.contains("@") || password.contains("#")
              || password.contains("!") || password.contains("~")
              || password.contains("$") || password.contains("%")
              || password.contains("^") || password.contains("&")
              || password.contains("*") || password.contains("(")
              || password.contains(")") || password.contains("-")
              || password.contains("+") || password.contains("/")
              || password.contains(":") || password.contains(".")
              || password.contains(", ") || password.contains("<")
              || password.contains(">") || password.contains("?")
              || password.contains("|"))) {
            return false;
        }
  
        if (true) {
            int count = 0;
  
            // checking capital letters
            for (int i = 65; i <= 90; i++) {
  
                // type casting
                char c = (char)i;
  
                String str1 = Character.toString(c);
                if (password.contains(str1)) {
                    count = 1;
                }
            }
            if (count == 0) {
                return false;
            }
        }
  
        if (true) {
            int count = 0;
  
            // checking small letters
            for (int i = 90; i <= 122; i++) {
  
                // type casting
                char c = (char)i;
                String str1 = Character.toString(c);
  
                if (password.contains(str1)) {
                    count = 1;
                }
            }
            if (count == 0) {
                return false;
            }
        }
  
        // if all conditions fails
        return true;
    }
	
	//number 
	public static boolean isValid1(String s)
    {
 
     
        Pattern p = Pattern.compile("^\\d{10}$");
 
   
        Matcher m = p.matcher(s);
 
        // Returning bollean value
        return (m.matches());
    }
	
	public static boolean isValid2(String email)
    {
        String emailRegex = "^[a-zA-Z0-9_+&*-]+(?:\\."+
                            "[a-zA-Z0-9_+&*-]+)*@" +
                            "(?:[a-zA-Z0-9-]+\\.)+[a-z" +
                            "A-Z]{2,7}$";
                              
        Pattern pat = Pattern.compile(emailRegex);
        if (email == null)
            return false;
        return pat.matcher(email).matches();
    }
	
	public static void main(String[] args)throws NoSuchAlgorithmException, NoSuchProviderException 
{
	// TODO Auto-generated method stub
	int select ;
	String Id1 ;
	String password1 ;
	String Name1 ;
	String Email1 ;
	String phoneno1 ;
	long balance1 ;
	
	Scanner sc = new Scanner(System.in) ;
	
	HashMap<String,String> List1 = new HashMap<String,String>();//password
	HashMap<String,String> List2 = new HashMap<String,String>();//name
	HashMap<String,String> List3 = new HashMap<String,String>();//Email
	HashMap<String,String> List4 = new HashMap<String,String>();//Phone number
	HashMap<String,Long> List5 = new HashMap<String,Long>();//Balance
	
	//account aadityabannore = new account("1201006",1234,"aadityabannore","aadityabanno@gmailcom",99208095,15000) ;
	//aadityabannore.Deposit();
	 String salt = getSalt();
	
	for(int i =0 ;i<100 ; i++)
	{
		String C1,C2 ;
		Long x,y ;
		System.out.println("Select A Opioion :");
		System.out.println("1.Select New Entry");
		System.out.println("2.Select Deposit");
		System.out.println("3.Select Withdraw");
		System.out.println("4.View Details");
		System.out.println("5.Exit");
		select = sc.nextInt() ;
		switch(select)
		{
		case 1:
			
			System.out.println("Enter Id:");
			Id1 = sc.next() ;
			while(true)
			{
			System.out.println("Enter Password:");
			password1 = sc.next() ;
			
			 if (isValid(password1)) 
			 	{
		            break ;
			 	}
		        else 
		        {
		            System.out.println("Invalid Password!!!");
		        }
			}
			String passwordToHash = password1 ;
			String securePassword = getSecurePassword(passwordToHash, salt);
	        password1 = securePassword ; 
	        System.out.println(password1);
	        
			List1.put(Id1, password1 ) ;			 
		
			System.out.println("Enter Name:");
			Name1 = sc.next() ; 
			List2.put(Id1, Name1) ;
			
			while(true)
			{
			System.out.println("Enter GEmail:");
			Email1 = sc.next() ;
			 if (isValid2(Email1))
			 {
	                break ;
			 } 
	         else
	         {
	        	 System.out.println(i + " - Not Valid");
	         }
			
			
			}
			List3.put(Id1, Email1) ;
			
			while(true)
			{
			System.out.println("Enter Phone Number:");
			phoneno1 = sc.next() ;
			if (isValid1(phoneno1))
			{	 
				break ;
			}
			else
			{
	            // Print statement
	            System.out.println("Invalid Number");
			}
			}
			List4.put(Id1, phoneno1) ;
			
			System.out.println("Enter Balance:");
			balance1 = sc.nextLong() ;
			List5.put(Id1, balance1) ;
			break ;
		case 2:
			System.out.println("Enter Id:");
			Id1 = sc.next() ;
			System.out.println("Enter Password:");
			C2 = sc.next() ;
			
			String passwordToHash1 = C2 ;
	        String securePassword1 = getSecurePassword(passwordToHash1, salt);
	        C2 = securePassword1 ; 
	        System.out.println(C2);
			
			C1 = List1.get(Id1) ;
			if(C1.equals(C2)==true)
			{
			x = List5.get(Id1) ;
			System.out.println("Enter Amount to deposit:");
			y= sc.nextLong() ;
			x = x + y ;		
			List5.put(Id1, x) ;
			System.out.println("Balance is " + x );
			}
			else
			{
				System.out.println("You Have Entered Wrong Password");
			}
			break ;
		case 3:
			System.out.println("Enter Id:");
			Id1 = sc.next() ;
			System.out.println("Enter Password:");
			C2 = sc.next() ;
			
			String passwordToHash2 = C2 ;
	        String securePassword2 = getSecurePassword(passwordToHash2, salt);
	        C2 = securePassword2 ; 
	        System.out.println(C2);
			
			C1 = List1.get(Id1) ;
			if(C1.equals(C2)==true)
			{
			x = List5.get(Id1) ;
			System.out.println("Enter Amount to deposit:");
			y= sc.nextLong() ;
			if(x-y < 0)
			{
				System.out.println("Not Enogh Amount in Bank");
			}
			else
			{
			x = x - y ;		
			List5.put(Id1, x) ;
			System.out.println("Balance is " + x );
			}
			}
			else
			{
				System.out.println("You Have Entered Wrong Password (Suspect)");
			}
			break ;
		case 4:
			System.out.println("Enter Id:");
			Id1 = sc.next() ;
			System.out.println("Enter Password:");
			C2 = sc.next() ;
			
			String passwordToHash3 = C2 ;
	        String securePassword3 = getSecurePassword(passwordToHash3, salt);
	        C2 = securePassword3 ; 
	        System.out.println(C2);
			
			C1 = List1.get(Id1) ;
			if(C1.equals(C2)==true)
			{
				System.out.println("Name : " + List2.get(Id1));
				System.out.println("Email : " + List3.get(Id1));
				System.out.println("Phone Number is : " + List4.get(Id1));
				System.out.println("Balance : " + List5.get(Id1));
			}
			break ;
		case 5:
			System.exit(0) ;
			break ;
		
		}
	}
}
		
		    private static String getSecurePassword(String passwordToHash,String salt) 
		    {
		        String generatedPassword = null;
		        try 
		        {
		            MessageDigest md = MessageDigest.getInstance("MD5");
		            
		            md.update(salt.getBytes());
		            
		           
		            byte[] bytes = md.digest(passwordToHash.getBytes());
		            
		           StringBuilder sb = new StringBuilder();
		            
		            for (int i = 0; i < bytes.length; i++) 
		            {
		                sb.append(Integer.toString((bytes[i] & 0xff) + 0x100, 16)
		                        .substring(1));
		            }
		            
		            
		            generatedPassword = sb.toString();
		        } catch (NoSuchAlgorithmException e) 
		        {
		            e.printStackTrace();
		        }
		        return generatedPassword;
		    }

		    
		    private static String getSalt()
		            throws NoSuchAlgorithmException, NoSuchProviderException 
		    {
		        
		        SecureRandom sr = SecureRandom.getInstance("SHA1PRNG", "SUN");

		      
		        byte[] salt = new byte[16];

		        
		        sr.nextBytes(salt);

		   
		        return salt.toString();
		    }
}