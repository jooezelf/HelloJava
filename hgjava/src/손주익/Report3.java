package 손주익;

import java.util.Scanner;

public class Report3 {
    public static void main(String[] args) {
        // ATM 프로그램
        boolean run = true;
        int balance = 0;
        Scanner scanner = new Scanner(System.in);
        int money;

        while(run) {
            System.out.println("-----------------------------------");
            System.out.println("1. 예금 | 2. 출금 | 3. 잔고 | 4. 종료");
            System.out.println("-----------------------------------"); // err -> out 수정
            System.out.print("선택>");
            int choose = Integer.parseInt(scanner.nextLine()); // 입력과정

            switch (choose) {
                case 1:
                    System.out.print("예금액>");
                    money = Integer.parseInt(scanner.nextLine());
                    if (money > 0) {
                        balance += money;
                        System.out.println("예금이 완료되었습니다.");
                    } else {
                        System.out.println("올바른 금액을 입력하세요.");
                    }
                    break;
                    
                case 2:
                    System.out.print("출금액>");
                    money = Integer.parseInt(scanner.nextLine());
                    if (money > 0 && money <= balance) {
                        balance -= money;
                        System.out.println("출금이 완료되었습니다.");
                    } else if (money > balance) {
                        System.out.println("잔고가 부족합니다.");
                    } else {
                        System.out.println("올바른 금액을 입력하세요.");
                    }
                    break;
                    
                case 3:
                    System.out.printf("잔고> %d원 \n", balance);
                    break;
                    
                case 4:
                    System.out.println("프로그램을 종료합니다.");
                    run = false;
                    break; // 일관성을 위해 추가
                    
                default:
                    System.out.println("1~4 중에서 선택하세요.");
                    break;
            }
        }
        
        scanner.close(); // 리소스 해제
    }
}