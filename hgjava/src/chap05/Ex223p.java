package chap05;

import java.util.Scanner;

public class Ex223p {

	public static void main(String[] args) {
		// p223 문제6
		// switch문 이용
		
			//1. 학생수 받아서 => 배열의 크기 잡아줌
			//2. 배열의 크기 만큼 학생 점수 입력받음
			//3. 배열에 저장된 학생 점수 출력
			//4. 점수 중 최고점수와 평균점수 계산해서 출력
			//프로그램 종료
		boolean run = true;
		int studentNum = 0;
		int[] scores = null;
		try (Scanner scanner = new Scanner(System.in)) {
			while(run) {
				System.out.println("------------------------------------------------------------");
				System.out.println("1. 학생수 | 2. 점수입력 | 3. 점수리스트 | 4. 분석 | 5. 종료");
				System.out.println("------------------------------------------------------------");
				System.out.print("선택> ");
				
				int selectNo = Integer.parseInt(scanner.nextLine());
				
				switch (selectNo) {
				case 1 :
					System.out.print("학생수>");
					studentNum = Integer.parseInt(scanner.nextLine());
					scores = new int[studentNum];
					break;
					
				case 2 : 
					for(int i=0; i<studentNum; i++) {
						System.out.printf("scores [%d]> ", i);
						scores[i] = Integer.parseInt(scanner.nextLine());
					}
					break;
				
				case 5 :
					run = false;
					break;
					default :
					System.out.println("잘못 선택함");
					
					
				}
			
			
			}
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
