package lambda;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.function.ToIntFunction;
import java.util.stream.Stream;

public class LambdaExample {
	public static void main(String[] args) {
		List<Student> list = Arrays.asList(new Student("Hong", "MALE", 70), new Student("Hwang", "FEMALE", 80),
				new Student("Park", "MALE", 90), new Student("Choi", "FEMALE", 85));

		// 1.여학생정보: 이름 - 점수.
		System.out.println("1.여학생 정보");
		for (Student student : list) {
			if (student.getSex().equals("FEMALE")) {
				System.out.println(student.getName() + "-" + student.getScore());
			}
		}

		// 2.전체학생: 점수 80점 초과. 이름 - 점수.
		System.out.println("2.전체학생 중 80점 초과 학생");
		for (Student student : list) {
			if (student.getScore() > 80) {
				System.out.println(student.getName() + "-" + student.getScore());
			}
		}

		// 3.남학생의 총점: 남학생총점: 160점;
		System.out.println("3.남학생 총점");
		int num = 0;
		for (Student student : list) {
			if (student.getSex().equals("MALE")) {
				num += student.getScore();

			}
		}
		System.out.println(num);

		// 4.여학생의 평균 : 여학생평균: 82.5점;
		System.out.println("4.여학생 평균");
		int sum = 0, count = 0;
		for (Student student : list) {
			if (student.getSex().equals("FEMALE")) {
				sum += student.getScore();
				count++;

			}
		}
		System.out.println((double) sum / count);

//반복문(반복자) : 스트림(반복자)
//스트림 생성 -> 소진.
		
// 1번 예시

		Stream<Student> stream = list.stream();
		stream.filter(new Predicate<Student>() {

			@Override
			public boolean test(Student t) {     
				
				return t.getSex().equals("FEMALE");
			}
			
		}).
		
		forEach(new Consumer<Student>() {

			@Override
			public void accept(Student t) {
				System.out.println(t.getName() + "-" + t.getScore());
			}
		});
		
//		stream.filter((t) -> t.getSex().equals("FEMALE"))
//		.forEach((t) -> System.out.println(t.getName() + "-" + t.getScore())); - 람다식
// 2번
		stream = list.stream();
		stream.filter(new Predicate<Student>() {

			@Override
			public boolean test(Student t) {
				
				return t.getScore() > 80;
			}
			
			}).forEach(new Consumer<Student>() {

			@Override
			public void accept(Student t) {
				System.out.println(t.getName() + t.getScore());
				
			}
	});
// 3번
		stream = list.stream();
		stream.filter((t) ->  
			 t.getScore() > 80).forEach((t) -> System.out.println(t.getName() + t.getScore())); // 람다식
				
			int sum1 = list.stream().filter(t ->t.getSex().equals("MALE"))
			 .mapToInt(new ToIntFunction<Student>() {

				@Override
				public int applyAsInt(Student value) {
					
					return value.getScore();
				}
				 
			 }).sum();
			
	
//			int sum1 = list.stream().filter(t ->t.getSex().equals("MALE"))
//					.mapToInt((value) -> value.getScore())
//					.sum();

			double avg = list.stream().filter(t -> t.getSex().equals("FEMALE"))
					.mapToInt(s -> s.getScore())
					.average()
					.getAsDouble();
			System.out.println("평균: " + avg);
}
}
