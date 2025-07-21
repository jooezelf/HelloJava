package chap06_1;

import java.util.Scanner;

public class BookMain {

	public static void main(String[] args) {
		
		boolean run = true;
		try (Scanner scanner = new Scanner(System.in)) {
			while(run) {
				System.out.println("----------------------------------------------------------------------");
				System.out.println("1. 도서수 입력 | 2. 도서정보 등록 | 3. 도서정보 전체조회 | 4. 도서정보 분석 | 5. 종료");
				System.out.println("----------------------------------------------------------------------");
				System.out.print("선택>");
				Integer.parseInt(scanner.nextLine());
			
				}
			
		}

	}
	
}