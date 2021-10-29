import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.LineNumberReader;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class OnUDPClient {
    private static final String FILE_URL1 = "E:/NgonNgu Java/PhatTrienHTTH/OnGKUDP/test.txt";

    public static void main(String[] args) {
        try {
            
            DatagramSocket clientSocket = new DatagramSocket();
            System.out.println("Da tao client: ");

            InputStream inputStream = new FileInputStream(FILE_URL1);
            InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
            LineNumberReader lnr= new LineNumberReader(inputStreamReader);

            int j = 0 ; 
            while(lnr.readLine()!= null){
                ++j; 
            }

            while (true) {
                System.out.println("\nChon chuc nang : \n");
                System.out.println("0. In ra chuoi");
                System.out.println("1.Dao chuoi");
                System.out.println("6.Exit");

                BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
                String bString = read.readLine() ; 

                byte [] ghi = bString.getBytes();

                DatagramPacket in = new DatagramPacket(ghi, ghi.length,InetAddress.getByName("localhost"),9876);
                clientSocket.send(in);

                DatagramPacket os; 
                byte [] nhan = new byte[2000];

                int a = Integer.parseInt(bString);

                if(a==6){
                    clientSocket.close();
                    System.exit(0);
                }

                for (int i = 0 ;i<j;i++){

                    os = new DatagramPacket(nhan, nhan.length);
                    clientSocket.receive(os);

                    String aString = new String(os.getData(),0,os.getLength());
                    System.out.println(aString);
                }

            }
        } catch (Exception e) {
            //TODO: handle exception
            e.printStackTrace();
        }
    }

    
}
