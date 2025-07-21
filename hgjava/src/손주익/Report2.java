package 손주익;

import java.util.Scanner;

public class Report2 {
    public static void main(String[] args) {
        // 동전 계산 프로그램
        
        Scanner sc = new Scanner(System.in);
        System.out.print("교환할 금액 : ");
        int money = Integer.parseInt(sc.nextLine());
        
        int remain; // 변수 선언
        
        int num500 = money / 500;
        remain = money % 500; // int 제거 - 대입만
        
        int num100 = remain / 100;
        remain = remain % 100;
        
        int num50 = remain / 50;
        remain = remain % 50;
        
        int num10 = remain / 10;
        remain = remain % 10;
        
        System.out.println("500원짜리 : " + num500);
        System.out.println("100원짜리 : " + num100);
        System.out.println("50원짜리 : " + num50);
        System.out.println("10원짜리 : " + num10);
        System.out.println("교환금액 : " + (money - remain));
        System.out.println("남은금액 : " + remain);
        
        sc.close();
    }
}