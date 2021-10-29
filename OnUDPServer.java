import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class OnUDPServer {
    public static void main(String[] args) {
        try {
            DatagramSocket serverSocket = new DatagramSocket(9876);
            System.out.println("Server da duoc tao");
            while (true) {
                byte[] receiveData = new byte[1000];
                byte[] sendData = new byte [60000];

                DatagramPacket receivePacket = new DatagramPacket(receiveData, receiveData.length);
                serverSocket.receive(receivePacket);
                String bString = new String (receivePacket.getData(),0,receivePacket.getLength());
                System.out.println("Client: " +bString);

                InetAddress IPAddress = receivePacket.getAddress();
                int port = receivePacket.getPort();

                DatagramPacket sendPacket ;
                switch (bString) {
                    case "0":
                        final String FILE_URL1 = "E:/NgonNgu Java/PhatTrienHTTH/OnGKUDP/test.txt";
                        InputStream inputStream = new FileInputStream(FILE_URL1);
                        InputStreamReader inputStreamReader = new InputStreamReader (inputStream);
                        BufferedReader reader = new BufferedReader (inputStreamReader);
                        String line0 = "";
                        System.out.println("Chuoi trong file :\n");
                        while ((line0= reader.readLine())!= null) {
                            System.out.println(line0);
                            sendData = line0.getBytes();
                            sendPacket = new DatagramPacket (sendData, sendData.length, IPAddress, port );

                            serverSocket.send(sendPacket);
                            
                        }
                        break;
                    case "1":// đảo chuỗi 
                    inputStream = new FileInputStream("E:/NgonNgu Java/PhatTrienHTTH/OnGKUDP/test.txt");
                    inputStreamReader = new InputStreamReader(inputStream);
                    reader = new BufferedReader(inputStreamReader);
                    String line="";
                    
                    //---------------------------------------------------
                    while((line = reader.readLine())  != null){
                        //System.out.println(line);
                        StringBuilder str = new StringBuilder(line);
                        sendData= str.reverse().toString().getBytes();
                        sendPacket = new DatagramPacket(sendData, sendData.length, IPAddress, port);
                        // //Gửi gói tin đi
                        serverSocket.send(sendPacket);       

                    }
                        break;

                    case "6":
                        System.exit(0);
                        break ; 

                    default:
                        break;
                }
            }

        } catch (Exception e) {
            
            e.printStackTrace(); 
        }
    }
}
