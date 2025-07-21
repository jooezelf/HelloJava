package chap06_1;

import java.util.Scanner;

public class BookDao {
	
	Scanner sc = new Scanner(System.in);
	
	Book[] BookData(int n){
		Book[] books = new Book[n];
				
				for(int i=0; i<n; i++) {
					System.out.printf("%1번 도서 이름>");
					System.out.printf("%d 2번 도서정보 등록>");
					
				}
		return books;
	}
	}

