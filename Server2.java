package CopyCode;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Date;


public class Servert{
private static ServerSocket serverSocket = null;

public static void main(String[] args) throws IOException {
    DataInputStream dos = null;
    DataOutputStream dis = null;
    try{
        serverSocket = new ServerSocket(8001);
        System.out.println("SERVER ready:...\n");
        Socket clientSocket = null;
        clientSocket = serverSocket.accept();
        dos = new DataInputStream(clientSocket.getInputStream());
        dis = new DataOutputStream(clientSocket.getOutputStream());
        String inline="";
        while(true)
        {
            inline = dos.readUTF();
            char ch[]=inline.toCharArray();

            if(Character.isDigit(ch[0]))
            {
                int i = Integer.parseInt(inline);

                switch(i)
                {
                    case 1:
                    {
                        Date now = new Date();
                        inline = ("Date now: " + now);
                        break;
                    }
                    case 2:
                    {
                        Date now = new Date();
                        Long time = now.getTime();
                        inline = ("Time now:" + time);
                        break;
                    }
                    case 3:
                    {
                        Date now = new Date();
                        long time = now.getTime(); 
                        inline = ("Date\time now : " + now  + "\n" + time);
                        break;
                    }
                }
                dis.writeUTF(inline);
            }

            else
                dis.writeUTF("WARNING........");
        }
    } catch(Exception e){
        dis.close();
        serverSocket.close();
        dos.close();
        System.out.println(e.getMessage());
    }
}
}