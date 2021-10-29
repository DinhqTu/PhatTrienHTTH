package Tuan2;
import java.util.Scanner;

public class ToaDo {
    float x ; 
    float y ; 
    ToaDo(float x , float y){
        this.x =x ;
        this.y= y;
    }
    void nhaptoado (){
        Scanner sc = new Scanner(System.in);
        float a ,b ;
        System.out.println("Nhap toa do a:");
        a = sc.nextFloat();
        System.out.println("Nhap toa do b :");
        b = sc.nextFloat();

        ToaDo(a,b);
    }
    void intoado () {
        System.out.println("Toa do (a,b)="+"("+x+","+y+")");
    }
    public static void main(String[] args) {
        ToaDo A =  new ToaDo();
        A.nhaptoado();
        A.intoado();

        ToaDo B = new ToaDo();
        B.nhaptoado(4,5);
        B.intoado();
    }
}
