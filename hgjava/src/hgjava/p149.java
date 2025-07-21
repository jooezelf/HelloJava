package hgjava;

import java.util.Scanner;

public class p149 {
    public static void main(String[] args) {
        // p149 문제1
        // 이유 주석으로 표시, 오류수정
        // byte 말고 int로 수정해야함
        int b = 5;
        b = -b;
        int result = 10 / b;
        System.out.println(result);

        // 문제없음
        int x = 10;
        int y = 20;
        int z = (++x) + (y--);
        System.out.println(z);

        // !stop으로 수정
        boolean stop = true;
        while(!stop) {
            // 무한루프 방지를 위해 break 추가
            break;
        }
        System.out.println("반복 종료!");

        // 534 자루의 연필을 30명의 학생들에게 똑같은 개수로 나누어주기
        int pencils = 534;
        int students = 30;

        // 학생 한 명이 가지는 연필 개수
        int pencilsPerStudent = pencils / students;
        System.out.println("나눠준 개수 = " + pencilsPerStudent);

        // 남은 연필 개수
        int pencilsLeft = pencils % students;
        System.out.println("남은 개수 = " + pencilsLeft);

        // 5번 문제
        // 나누기를 빼기로, 곱하기를 더하기로 변경
        int var1 = 5;
        int var2 = 2;
        double var3 = var1 - var2;
        int var4 = (int) (var3 + var2);
        System.out.println(var4);

        // 6번 문제
        int value = 356;
        System.out.println((value / 100) * 100);

        // 7번 문제 - 부동소수점 비교 문제 수정
        float var5 = 10f;
        float var6 = var5 / 100;
        if(var6 == 0.1f) {
            System.out.println("10%입니다.");
        } else {
            System.out.println("10%가 아닙니다.");
        }

        // 8번 문제 - 사다리꼴 넓이 공식 수정
        int lengthTop = 5;
        int lengthBottom = 10;
        int height = 7;
        double area = (lengthTop + lengthBottom) * height / 2.0;
        System.out.println("사다리꼴 넓이: " + area);

        // 9번 문제 - 주석 해제 및 수정
        Scanner sc = new Scanner(System.in);
        System.out.print("첫 번째 수: ");
        int num1 = Integer.parseInt(sc.nextLine());
        System.out.print("두 번째 수: ");
        int num2 = Integer.parseInt(sc.nextLine());
        if(num2 != 0) {
            double result1 = (double)num1 / num2;
            System.out.println("나눈값 = " + result1);
        } else {
            System.out.println("0으로 나눌 수 없습니다.");
        }

        // 10번 문제 - 원의 넓이 계산 수정
        int radius = 10;
        double pi = 3.14;
        double circleArea = radius * radius * pi;
        System.out.println("원의 넓이: " + circleArea);

        // 윤년 계산 프로그램 - 올바른 윤년 판별 로직
        System.out.print("년도 입력: ");
        int year = Integer.parseInt(sc.nextLine());
        
        boolean isLeapYear = false;
        if(year % 4 == 0) {
            if(year % 100 == 0) {
                if(year % 400 == 0) {
                    isLeapYear = true;
                }
            } else {
                isLeapYear = true;
            }
        }
        
        if(isLeapYear) {
            System.out.println(year + "년은 윤년입니다.");
        } else {
            System.out.println(year + "년은 평년입니다.");
        }
        
        sc.close();
    }
}