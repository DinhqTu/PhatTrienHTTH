package onGKUDP;
import java.net.DatagramPacket;
import java.net.DatagramSocket;

public class UDPDateTimeServer {
    public static void main(String[] args) {
        try {
            DatagramSocket ds = new DatagramSocket(9876);

            System.out.println("Server da duoc tao!");

            byte[] give = new byte[1024];
            while (true) {
                
                DatagramPacket in = new DatagramPacket(give, give.length);
                ds.receive(in);

                String bString = new String(in.getData(),0,in.getLength());
                System.out.println("Client: "+bString);

                byte[] send = new byte[1024];
                DatagramPacket os;

                switch (bString) {

                    case "1":
                        String date= "Ngay hien tai: "+ java.time.LocalDate.now();
                        send=date.getBytes();
                        os = new DatagramPacket(send, send.length, in.getAddress(), in.getPort());
                        ds.send(os);
                        break;
                    case "2": 
                        String time= "Gio hien tai: "+ java.time.LocalTime.now();
                        send=time.getBytes();

                        os = new DatagramPacket(send, send.length, in.getAddress(), in.getPort());

                        ds.send(os);
                        break;
                    case "3":
                        String datetime= "Ngay gio hien tai: "+ java.time.LocalDateTime.now();
                        send=datetime.getBytes();
                        os = new DatagramPacket(send, send.length, in.getAddress(), in.getPort());

                        ds.send(os);
                        break;
                    case "0":
                        System.exit(0);
                        break;
                
                    default:
                        System.exit(0);
                        break;
                }
            }

        } catch (Exception e) {
            //TODO: handle exception
            e.printStackTrace();
        }
    }

}
