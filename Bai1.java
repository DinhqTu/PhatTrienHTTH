package Tuan2;
/**
 * tuan2
 */
import java.util.Scanner;

public class Bai1 {
   public static void main(String[] args) {
       Scanner sc = new Scanner(System.in);
       String message ; 
       System.out.println("Nhập chuỗi kĩ tự cần chuyển :");
       message = sc.nextLine();
       char[] charArray = message.toCharArray();
       for (int i=0 ; i<= charArray.length;i++){
          if(charArray[i]>= 97 && charArray[i]<=122){
               charArray[i]-=32 ;
          }
       }
       message=String.valueOf(charArray);
       System.out.println("Sau khi chuyển : \n" + message);
   }
}