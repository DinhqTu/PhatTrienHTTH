package CopyCode;

public import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;


public class Clientt {
    
    public static void main(String[] args) throws IOException 
    {
        Socket mySocket = null;
        DataInputStream dos = null;
        DataOutputStream dis = null;

        try
        {
            mySocket = new Socket("localhost", 8001);
            dis = new DataOutputStream(mySocket.getOutputStream());
            dos = new DataInputStream(mySocket.getInputStream());
            Scanner input = new Scanner(System.in);
            String s = null;

            while(true)
            {
                System.out.println("\nCHON MENU:....");
                System.out.println("\n1.HIEN THI DATE:...");
                System.out.println("\n2.HIEN THI TIME:...");
                System.out.println("\n3.HIEN THI DATE/TIME:...");
                s = input.nextLine();
                dis.writeUTF(s);

                String str = dos.readUTF();
                System.out.println("KET QUA:...." + str);
            }
        } catch(Exception e){
            System.out.println("KHONG THE KET NOI:...");
            dos.close();
            dis.close();
            mySocket.close();
            e.printStackTrace();
        }
    }
}class client {
    
}
