package ongkUDP;

import java.io.File;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class Server {
    public static void main(String[] args) {
        // tạo socket phía server cổng là 9876
        DatagramSocket serverSocket = new DatagramSocket(9876); 
        while (true) {
            // tạo biến receiveData để nhận dữ liệu từ gói tin đên
            byte []  receiveData= new byte[1];
            // tạo biến sendData để nhận dữ liệu gửi đến gói tin
            byte[] sendData = new byte[10000] ; 
            // tạo biến receivePacket để nhận gói tin từ socket
            DatagramPacket receivePacket = new DatagramPacket(receiveData, receiveData.length);
            // nhận gói tin qua receive() 
            serverSocket.receive(receivePacket);
            // chuyển dữ liệu sang string 
            String sectence = new String(receivePacket.getData());
            // lấy địa chỉ IP của bên gửi 
            InetAddress IPAddress = receivePacket.getAddress();
            // lấy số hiệu cổng bên gửi 
            int port = receivePacket.getPort(); 

            int a = Integer.valueOf(sendData);

                switch (a) {
                    case 1:
                        string file1 = "" ;
                        break;
                    case 2:
                        string sentence_to_client1;
                        // tạo gói tin gửi đi client 
                        byte[] sendData1 = new byte[60];

                        //datagrampacket
                        File file2 = new File()
                    default:
                        break;
                }
        }
       }
}
