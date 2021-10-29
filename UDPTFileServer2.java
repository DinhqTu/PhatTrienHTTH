
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class UDPTFileServer2 {
    public static void main (String[] args) {
        try {
            //Tạo socket phía server với số hiệu cổng 9876
            DatagramSocket serverSocket = new DatagramSocket(9876);   
            System.out.println("Server da duoc tao!");

            while (true) {
                //tạo biến receiveData để nhận dữ liệu từ gói tin đến 
                byte[] receiveData = new byte[1000];
                //tạo sendData để nhận dữ liệu gửi lên gói tin đi
                byte[] sendData  = new byte[60000];
  
                //----------------------------------------------------------------------
                //Lấy lựa chọn
                DatagramPacket receivePacket = new DatagramPacket(receiveData, receiveData.length);
                serverSocket.receive(receivePacket);
                String bString = new String(receivePacket.getData(),0,receivePacket.getLength());
                System.out.println("Client: "+bString);

                // //Lấy địa chỉ IP của bên gửi
                InetAddress IPAddress = receivePacket.getAddress();
                // //Lấy số hiệu cổng bên gửi
                int port = receivePacket.getPort(); 
                 
                DatagramPacket sendPacket;
                //---------------------------------------------------------------------
                switch (bString) {
                    case "0":
                        //đọc file
                        final String FILE_URL1 = "/test.txt";
                        InputStream inputStream = new FileInputStream(FILE_URL1);
                        InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
                        BufferedReader reader = new BufferedReader(inputStreamReader);
                        String line0="";
                        System.out.println("Chuỗi trong file:\n");
                        while((line0 = reader.readLine())  != null){
                            System.out.println(line0);
                            sendData=line0.getBytes();
                            sendPacket = 
                                new DatagramPacket(sendData, sendData.length, IPAddress, port);
                            // //Gửi gói tin đi
                            serverSocket.send(sendPacket);
                        }
                        break;

                    case "1":// đảo chuỗi 
                        inputStream = new FileInputStream("/test.txt");
                        inputStreamReader = new InputStreamReader(inputStream);
                        reader = new BufferedReader(inputStreamReader);
                        String line="";
                       
                       //---------------------------------------------------
                        while((line = reader.readLine())  != null){
                            //System.out.println(line);
                            StringBuilder str = new StringBuilder(line);
                            sendData= str.reverse().toString().getBytes();
                            sendPacket = 
                                 new DatagramPacket(sendData, sendData.length, IPAddress, port);
                            // //Gửi gói tin đi
                            serverSocket.send(sendPacket);       
  
                        }
                        break;

                    case "2":     // in hoa chuỗi           
                        inputStream = new FileInputStream("/test.txt");
                        inputStreamReader = new InputStreamReader(inputStream);
                        reader = new BufferedReader(inputStreamReader);
                        String line1="";
                    //---------------------------------------------------
                        while((line1 = reader.readLine())  != null){
                            //System.out.println(line1);
                            sendData= line1.toUpperCase().getBytes();
                            sendPacket = 
                                new DatagramPacket(sendData, sendData.length, IPAddress, port);
                            // //Gửi gói tin đi
                            serverSocket.send(sendPacket);
                        }
                        break;

                    case "3":
                        //In hoa chữ cái đầu dòng
                        inputStream = new FileInputStream("/test.txt");
                        inputStreamReader = new InputStreamReader(inputStream);
                        reader = new BufferedReader(inputStreamReader);
                        String line2="";
                    //---------------------------------------------------
                        while((line2 = reader.readLine())  != null){
                            //System.out.println(line2);
                            String fstr= line2.substring(0,1).toUpperCase();
                            String lstr = line2.substring(1, line2.length());
                            String name=fstr+lstr;
                            sendData= name.getBytes();
                            sendPacket = 
                                new DatagramPacket(sendData, sendData.length, IPAddress, port);
                            // //Gửi gói tin đi
                            serverSocket.send(sendPacket);
        
                        }       
                        break;

                    case "4":
                    //IN hoa chữ cái đầu của từ
                        inputStream = new FileInputStream("/test.txt");
                        inputStreamReader = new InputStreamReader(inputStream);
                        reader = new BufferedReader(inputStreamReader);
                        String line3="";

                        while((line3 = reader.readLine())  != null){
                            char[] arr = line3.toCharArray();
                            boolean space=true;

                            for(int i=0;i<arr.length;i++){
                                if(Character.isLetter(arr[i])){
                                    if(space){
                                        arr[i]=Character.toUpperCase(arr[i]);
                                        space=false;
                                    }
                                }else{
                                    space=true;
                                }
                            }

                            line3 = String.valueOf(arr);
                            sendData= line3.getBytes();
                            sendPacket = 
                                new DatagramPacket(sendData, sendData.length, IPAddress, port);
                            // //Gửi gói tin đi
                            serverSocket.send(sendPacket);
                        }

                        break;

                    case "5": // đảo ngược các từ trong câu 
                        inputStream = new FileInputStream("/test.txt");
                        inputStreamReader = new InputStreamReader(inputStream);
                        reader = new BufferedReader(inputStreamReader);
                        String line4="";

                        while((line4 = reader.readLine())  != null){
                            
                            String[] words = line4.split(" ");// tách chuỗi dựa trên khoảng trắng 
                            String reversedString = "";
                            for (int i = 0; i < words.length; i++)
                            {
                                String word = words[i];
                                String reverseWord = "";
                                for (int j = word.length()-1; j >= 0; j--)
                                {
                                    reverseWord = reverseWord + word.charAt(j);
                                }
                                reversedString = reversedString + reverseWord + " ";
                            }

                           
                            sendData= reversedString.getBytes();
                            sendPacket = 
                                new DatagramPacket(sendData, sendData.length, IPAddress, port);
                            // //Gửi gói tin đi
                            serverSocket.send(sendPacket);
                        }
                        break;
                    case "6":
                        System.exit(0);
                        break;

                    default:
                        break;
                }
            }            
        } catch (Exception e) {
            //TODO: handle exception
            e.printStackTrace();
        }
    }
}
