package onGKUDP;

import java.io.BufferedReader;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.io.InputStreamReader;


public class UDPDateTimeClient {
    public static void main(String[] args) {
        try {
            DatagramSocket cs=new DatagramSocket();

            System.out.println("Client da dc tao!");

            while (true) {


                System.out.println("\n\t1.Date | 2.Time | 3. DateTime | 0.Exit\n");
                System.out.println("\nNhap lua chon cua ban: ");

                BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
                String bString = read.readLine();

                byte[] ghi = bString.getBytes();

                DatagramPacket in = new DatagramPacket(ghi, ghi.length,InetAddress.getByName("localhost"),9876);

                cs.send(in);

                byte[] nhan = new byte[1024];

                DatagramPacket os = new DatagramPacket(nhan, nhan.length);
                cs.receive(os);;

                String doi = new String(os.getData(),0,os.getLength());
                System.out.println(doi);

                if(bString.compareTo("0")==0){
                    System.out.println("Client da dong!");
                    cs.close();
                    
                    break;
                }
                
            }
            



        } catch (Exception e) {
            //TODO: handle exception
            e.printStackTrace();
        }
    }

}
