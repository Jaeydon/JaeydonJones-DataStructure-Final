/* Jaeydon Jones
 * Data Structure Final Project 
 * 5/4/2023
 */
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import java.util.HashSet;
import java.util.Arrays;

//Class to Verify Strength of Password
class passwordsecurity {
	   
	   
    public static void printStrongNess(String input)
    {
        // Checking lower alphabet in string
        int n = input.length();
        boolean hasLower = false, hasUpper = false,
                hasDigit = false, specialChar = false;
        Set<Character> set = new HashSet<Character>(
            Arrays.asList('!', '@', '#', '$', '%', '^', '&',
                          '*', '(', ')', '-', '+'));
        for (char i : input.toCharArray())
        {
            if (Character.isLowerCase(i))
                hasLower = true;
            if (Character.isUpperCase(i))
                hasUpper = true;
            if (Character.isDigit(i))
                hasDigit = true;
            if (set.contains(i))
                specialChar = true;
        }
       
        // Strength of password
        System.out.print("Strength of password:- ");
        if (hasDigit && hasLower && hasUpper && specialChar
            && (n >= 8))
            System.out.print(" Strong\n");
        else if ((hasLower || hasUpper || specialChar)
                 && (n >= 6))
            System.out.print(" Moderate\n");
        else
            System.out.print(" Weak\n");   
}
}

//Driver Class
public class User extends passwordsecurity {

@SuppressWarnings("rawtypes")
public static void main(String[] args)
{
Map<String,String> db = new HashMap<String, String>();
String user,pass = null;
String filename = "password.txt";
@SuppressWarnings("resource")
Scanner sc = new Scanner(System.in);
while(true)
{
// Enter Username and Password
System.out.println("Please enter username:");
user = sc.next();
System.out.println("Please enter password");
pass = sc.next();
printStrongNess(pass);

db.put(user, pass);
//Makes Txt File
File f = new File(filename);
try(FileWriter fw = new FileWriter(f, true);
BufferedWriter bw = new BufferedWriter(fw);
PrintWriter out = new PrintWriter(bw)){

out.println("The User "+ user + " stored in system at "+ LocalDateTime.now());
out.println("Username: " + user);
out.println("Password: " + pass + "\n");

//Output if unable to find .txt file
} catch (IOException e) {
System.out.println("Not able to store user "+ user);
}                    // "Menu"
System.out.println("+-----------------------------------------------------------------+");
System.out.println("|1.) Q to Quit.                                                   |");
System.out.println("|2.) Enter Any key to add more Usernames and Passwords.(Continue) |");
System.out.println("|            ==(To Change Password, Reenter Username)==           |");
System.out.println("+-----------------------------------------------------------------+");
System.out.println("Decision: ");
char choice;
choice = sc.next().charAt(0);
// Exit
if(choice == 'Q' || choice == 'q')
break;
}

//Prints All Stored Usernames and Passwords of Current Session
System.out.println("-<Stored Usernames and Passwords>-");
for(Map.Entry m:db.entrySet()){
System.out.println("Username: "+m.getKey()+" || Password: "+m.getValue());
}
}
}