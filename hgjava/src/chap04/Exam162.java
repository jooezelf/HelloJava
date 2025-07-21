package chap04;

public class Exam162 {

	public static void main(String[] args) {
		// 오징어 게임
		// 주사위를 2개 던진다
		int dice1 = (int) (Math.random() * 6) + 1;
		int dice2 = (int) (Math.random() * 6) + 1;
		// 합이 10을 넘으면 두 수를 더하고
		int result = dice1 + dice2;
		if (result > 10) {
			System.out.printf("%d + %d = %d\n", dice1, dice2, result);
		} else {
			System.out.printf("%d + %d = %d\n", dice1, dice2, dice1 * dice2);
		}

		// 그렇지 않으면 두 수를 곱한 결과

		// 오전시간 (9~12) 일정 출력
		// 현재 시간 확인
		int time = (int) (Math.random() * 4) + 9;
		System.out.println("현재시간" + time);
		// 9시 : 출근
		// 10시 : 회의
		// 11시 : 업무
		// 12시 : 외근

		switch (time) {
		case 9:
			System.out.println("출근");
		case 10:
			System.out.println("회의");
		case 11:
			System.out.println("업무");
		case 12:
			System.out.println("외근");
		}
		System.out.println("일정 끝");

		// p169 문제3 => switch 문으로 변경
		int score = 85;
		switch (score / 10) {
		case 10:
		case 9:
			System.out.println("A");
			break;
		case 8:
			System.out.println("B");
			break;
		case 7:
			System.out.println("C");
			break;
		default:
			System.out.println("D");
		}

		// 주사위 게임
		// 주사위 2개를 던져서 합이 10이면 탈출
		// 주사위 순서쌍 출력 (5, 2)
		int sum = 0;
		sum = sum + 1;
		System.out.println("합 :" + sum);
		// 기회는 5번
		int sum1 = 5;
		for (int i=10; i<=12;) {
			sum1 = sum1 + i;
		}
		System.out.println("주사위 2개의 합:" + sum);
	}// end main

}// end class