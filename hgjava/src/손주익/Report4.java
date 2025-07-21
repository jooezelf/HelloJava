package 손주익;

import java.util.Scanner;

public class Report4 {
	public static void main(String[] args) {
		// ATM 프로그램
		boolean run = true;
		int balance = 0;
		Scanner scanner = new Scanner(System.in);
		int money;

		while (run) {
			System.out.println("-------------------------");
			System.out.println("1. 예금 | 2. 출금 | 3. 잔액 | 4. 종료");
			System.out.println("-------------------------");
			System.out.print("선택>");
			int choose = Integer.parseInt(scanner.nextLine());

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
					System.out.println("잔액이 부족합니다.");
				} else {
					System.out.println("올바른 금액을 입력하세요.");
				}
				break;

			case 3:
				System.out.printf("잔액> %d원 \n", balance);
				break; // 이 break가 중요!

			case 4:
				System.out.println("프로그램을 종료합니다.");
				run = false;
				break;

			default:
				System.out.println("올바른 번호를 선택하세요.");
				break;
			}
		}

		scanner.close(); // 리소스 해제
	} // main 끝
}