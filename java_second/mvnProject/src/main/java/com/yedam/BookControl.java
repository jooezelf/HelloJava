package com.yedam;

import java.util.List;
import java.util.Scanner;

import com.yedam.common.DBUtil;
import com.yedam.mapper.BookMapper;
import com.yedam.vo.Book;

// 목록.
// 단건.
// 등록.

public class BookControl {

	Scanner scn = new Scanner(System.in);
	BookMapper mapper = DBUtil.getInstance().openSession().getMapper((Class<T>) BookMapper.class);

	public void exe() {
		boolean run = true;
		while (run) {
			System.out.println("도서정보관리");
			System.out.println("1. 도서목록");
			System.out.println("2. 도서등록");
			System.out.println("3. 상세조회");
			System.out.println("0. 이전메뉴");
			int menu = Integer.parseInt(scn.nextLine());
			switch (menu) {
			case 1: // 목록.
				bookList();
				break;
			case 2: // 등록.
				addBook();
				break;
			case 0:
				return;
			default:
				System.out.println("메뉴를 선택하세요.");
			}

		}
	} // end of exe();

	private void bookList() {
		List<Book> list = mapper.selectList();
		// id / title / price
		System.out.println("그룹명	멤버	시장가치");
		System.out.println("================");
		for (Book book : list) {
			book.showBrief();
		}

	} // end of bookList().

	private void addBook() {

	} // end of addBook().

}