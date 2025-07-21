package hgjava;

import java.util.Scanner;

public class Class {

	public static void main(String[] args) {
		// p120 문제1
		String name = "감자바";
		int age = 25;
		String tel1 = "010", tel2 = "123", tel3 = "4567";
		
		System.out.println("이름 : " + name);
		System.out.print("나이 : " + age + "\n");
		System.out.printf("전화 : %s-%s-%s\n",tel1, tel2, tel3);
		
		// p121 문제2
		
		Scanner sc =  new Scanner(System.in); //스캐너 만들기
		
		System.out.print("수1 입력>"); // 출력 명령
		int num1 = Integer.parseInt(sc.nextLine()); // 입력문장 불러오기
		
		System.out.print("수2 입력>");
		int num2 = Integer.parseInt(sc.nextLine());
		
		int result = num1 + num2; // 변수 사용
		System.out.println("덧셈 결과 = " + result);
		
		sc.close();
		
		// int로 변경하는 방법 Integer.parseInt

		// 기억공간 int
		
		// 피연산자가 byte, short, char 타입이면 int 타입으로 변환

	}

}
