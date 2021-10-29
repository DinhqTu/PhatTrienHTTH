import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;
public class client {
    public static void main(String[] args) throws IOException{
        Socket mySocket = null ; 
        DataOutputStream os = null ; 
        DataInputStream is = null ; 

        try {
            mySocket = new Socket("LocalHost",2000);
            os = new DataOutputStream(mySocket.getOutputStream());
            is = new DataInputStream(mySocket.getInputStream());
            Scanner input = new Scanner(System.in);
            String s = null ; 
            while(true) {
                System.out.println("Nhap so nguyen :");
                s = input.nextLine();
                os.writeUTF(str);
                String str = is.readUTF();
                System.out.println("Kết quả từ Server :"+str);
            }
        } catch (Exception e) {
            System.out.println("Ngắt kết nối");
            is.close();
            os.close();
            mySocket.close();
            e.printStackTrace();
        }
    }
}
