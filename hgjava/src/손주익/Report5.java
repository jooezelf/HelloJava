package 손주익;

import java.util.Random;
import java.util.Scanner;

public class Report5 {
	public static void main(String[] args) {
		
		// Scanner 객체 생성 (사용자 입력을 받기 위함)
		Scanner scanner = new Scanner(System.in);

		// Random 객체 생성 (컴퓨터의 난수 생성을 위함)
		Random random = new Random();

		// 게임 선택지 배열
		String[] choices = { "가위", "바위", "보" };

		System.out.println("가위바위보 게임을 시작합니다!");
		System.out.println("1: 가위, 2: 바위, 3: 보");
		System.out.print("선택하세요 (1-3): ");

		// 사용자 입력 받기
		int userChoice = scanner.nextInt();

		// 입력값 유효성 검사
		if (userChoice < 1 || userChoice > 3) {
			System.out.println("잘못된 입력입니다. 1, 2, 3 중에서 선택해주세요.");
			scanner.close();
			return;
		}

		// 컴퓨터 선택 (0~2 범위의 난수 생성)
		int computerChoice = random.nextInt(3);

		// 선택 결과 출력
		System.out.println("당신의 선택: " + choices[userChoice - 1]);
		System.out.println("컴퓨터의 선택: " + choices[computerChoice]);

		// 게임 결과 판정
		int result = determineWinner(userChoice - 1, computerChoice);

		// 결과 출력
		if (result == 0) {
			System.out.println("결과: 무승부!");
		} else if (result == 1) {
			System.out.println("결과: 당신이 이겼습니다!");
		} else {
			System.out.println("결과: 컴퓨터가 이겼습니다!");
		}

		// Scanner 리소스 해제
		scanner.close();
	}

	// 승부 판정 메서드
	// 반환값: 0(무승부), 1(사용자 승리), -1(컴퓨터 승리)
	public static int determineWinner(int user, int computer) {
		// 같은 선택이면 무승부
		if (user == computer) {
			return 0;
		}

		// 사용자가 이기는 경우
		// 가위(0) vs 보(2), 바위(1) vs 가위(0), 보(2) vs 바위(1)
		if ((user == 0 && computer == 2) || (user == 1 && computer == 0) || (user == 2 && computer == 1)) {
			return 1;
		}

		// 나머지 경우는 컴퓨터가 승리
		return -1;
	}
}
