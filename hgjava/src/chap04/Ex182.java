package chap04;

public class Ex182 {

	public static void main(String[] args) {
		// p182 문제3
		// 1에서 100까지 정수 중 3의 배수 합, 3의 배수의 갯수
		int sum = 0;
		int count = 0;
		for(int i=1; 1<=100; i++) {
			if(i%3 == 0) {
				sum = (sum + i);
				count = (count + 1);
				System.out.println();
				
			}
		}

	}

}
