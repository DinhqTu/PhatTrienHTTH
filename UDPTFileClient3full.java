package Tuan4;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.LineNumberReader;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class UDPTFileClient2 {
    private static final String FILE_URL1 = "D:/HK1 năm 3/Phát triển hệ thống tích hợp/Code Java/Tuan4/test2.txt";

    public static void main(String[] args) {
        try {
            //tao moi socket client
            DatagramSocket ClientSocket = new DatagramSocket();
            System.out.println("Đã tạo client. ");
            
            //-----------------------------------------------------------------------------
            //Đếm số lượng dòng trong file
            InputStream inputStream = new FileInputStream(FILE_URL1);
            InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
            LineNumberReader lnr=new LineNumberReader(inputStreamReader);

            int j=0;
            while(lnr.readLine() !=null){
                j++;
            }
            System.out.println("Tong so dong la: "+ j);
            //--------------------------------------------------------------------------
            while (true) {
                System.out.println("\nChon chuc nang: \n");
                System.out.println("0.In ra chuoi");
                System.out.println("1.Dao Chuoi \n2.In hoa chuoi \n3.In hoa chu cai dau ");
                System.out.println("4.In hoa ký tự đầu mỗi từ \n5.Đảo ngược các từ trong câu \n6.Chuyển chữ hoa thành chữ thường \n7.Viết thường chữ đầu tiên in hoa tất cả\n8.Exit");
                System.out.println("Nhap lua chon: ");

                BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
                String select = read.readLine();

                byte[] ghi = select.getBytes();
                //lay lua chon nhap tu ban phim
                DatagramPacket in = new DatagramPacket(ghi, ghi.length,InetAddress.getByName("localhost"),2910);
                ClientSocket.send(in);
                // tạo goi nhan du lieu ve
                DatagramPacket os;
                byte[] nhan = new byte[2000];
                //-------------------------------
                int a=Integer.parseInt(select);

                if(a ==8 ){
                    System.out.println("Client da dong");
                    ClientSocket.close();
                    System.exit(0);

                }

                //-------------------------------------------------------------------------------------
                for (int i = 0; i < j; i++) {
                
                    os = new DatagramPacket(nhan, nhan.length);
                    ClientSocket.receive(os);

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
