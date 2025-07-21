package chap06;

public class StudentDao {
	Student[] stData(){
		Student[] students = {
				new Student("장원영" , 100, 100, 100),
				new Student("안유진" , 45, 87, 47),
				new Student("김지원" , 54, 58, 75),
				new Student("김가을" , 74, 47, 47),
				new Student("이현서" , 78, 78, 78),
				new Student("김레이" , 74, 35, 78),
				new Student("코토코" , 78, 78, 73),
				new Student("미나미" , 80, 80, 80),
				new Student("제나" , 70, 70, 70),
				new Student("츠키" , 60, 60, 60)

		};
		
		return students;
	}
}
