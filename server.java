package cnTuan4;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
public class server {
    private static ServerSocket serverSocket = null ;
    public static void main(String[] args) throws IOException {
        DataOutputStream os = null ; 
        DataInputStream is = null ;
        try {
            serverSocket = new ServerSocket(2000);
            System.out.println("Server đã được tạo");
            Socket clientSocket = null ; 
            clientSocket = serverSocket.accept();
            os = new DataOutputStream(clientSocket.getOutputStream());
            is = new DataInputStream(clientSocket.getInputStream());
            String inline = "" ; 
            while(true){
                inline = is.readUTF();
                char ch[] = inline.toCharArray();
                if(Character.isDigit(ch[0])){
                    int i = Integer.parseInt(inline);
                    switch(i){
                        case 0:inline="Không";break;

                        case 1:inline="Một";break;
        
                        case 2:inline="Hai";break;
        
                        case 3:inline="Ba";break;
        
                        case 4:inline="Bốn";break;
        
                        case 5:inline="Năm";break;
        
                        case 6:inline="Sáu";break;
        
                        case 7:inline="Bảy";break;
        
                        case 8:inline="Tám";break;
        
                        case 9:inline="Chín";break;
                    }
                    os.writeUTF(inline);
                }
                else 
                    os.writeUTF("Không phải số nguyên");
                }
        } catch (Exception e) {
            os.close();
            serverSocket.close();
            is.close();
            System.out.println(e.getMessage());
        }
    }   
}
