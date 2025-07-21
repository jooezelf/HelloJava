package chap05;

public class ExamArr {

	public static void main(String[] args) {

		// 배열에 저장 된 값들의 합, 최대값, 최소값 구하기
		// 배열 값 : 1에서 100까지의 난수(Math.random()) 10개 배열에 저장
		// 배열 값 출력
		// 배열 값의 합계, 최대값, 최소값 출력

		int[] rans = new int[10];
		for (int i = 0; i < rans.length; i++) {
			rans[i] = (int) (Math.random() * 100) + 1;
		}

		// 배열의 합
		int sum = 0;
		int max = rans[0];
		int min = 100;
		for (int i = 0; i < rans.length; i++) {
			System.out.println(rans[i]);
			sum += rans[i];
			if (max < rans[i])
				max = rans[i];
			if (min < rans[i])
				min = rans[i];
		}
		System.out.println();
		System.out.printf("합=%d\n최대값=%d\n최소값%d\n", sum, max, min);

		// 배열의 요소중 4의 배수출력
		// 4의 배수 갯수 출력

		// scores.length 행의 길이
		// scores[0].length

		// 2차원 배열

		// 배열 선언
		int[][] twoArr = { { 80, 90 }, { 70, 60, 50 } };

		// 2 차원 출력
		for (int i = 0; i < twoArr.length; i++) {
		for (int j = 0; j < twoArr[i].length; j++) {
			System.out.printf("| %d ", twoArr[i][j]);
			}
			System.out.println();
		}

		// 2차원 배열 출력

		int[][] twoArr2 = { { 1, 2, 3 }, { 1, 2 }, { 1 }, { 1, 2, 3 } };
		for (int a = 0; a < twoArr2.length; a++) {
		for (int b = 0; b < twoArr2[a].length; b++) {
			System.out.printf("| %d ", twoArr2[a][b]);
			}
			System.out.println();
		}

		// 현재 관객수 출력
		int[][] person = new int [3][10];
		int sum2 = 0;
		for(int i=0; i<3; i++) {
			for(int j=0; j<10; j++) {
				person[i][j] = (int) (Math.random()* 2);
				System.out.print(person [i][j] + " ");
				sum2 += person [i][j];
			}
				System.out.println();
		}
			System.out.println("관객수는" + sum2);
			
			
	}
	
	//학생 별 평균 계산하기
	
	

}// end main
