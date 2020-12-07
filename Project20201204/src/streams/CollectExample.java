package streams;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;

public class CollectExample {
	public static void main(String[] args) {
		List<Student> list = Arrays.asList(//
				new Student("Hong", 80), //
				new Student("Hwang", 90), //
				new Student("Park", 87)//
				
		);
		
	
//		list.stream().filter(s-> s.getScore()/10 == 8)//
//		.forEach(s -> System.out.println(s.getName()+"," +s.getScore()));
//		
//		list.stream().filter(s-> s.getScore()/10 == 8)//
//		.forEach(System.out :: println);  //축소형태 (매개값만 받아서 쓰여질 경우)

		List<Student> student80s = list.stream()//  //List 뿐만 아니라 Set도 가능
		.filter(s-> s.getScore()/10 == 8)//
		.sorted()  //오류원인 : student class는 Comparable를 구현하지않음. Student에서 적용시켜야함
		.collect(Collectors.toList()); 
	
		for (Student student : student80s) {
			System.out.println("이름 :" + student.getName() + "/ 점수: " + student.getScore());

	{
		System.out.println("이름 :" + student.getName() + "/ 점수: " + student.getScore());
	}
		list.stream()//
				.filter(s -> s.getScore() / 10 == 8)//
				.sorted()//
				.collect(//
						Collectors.toMap(//
						new Function<Student, String>() {

							@Override //재생성
							public String apply(Student t) {
								
								return t.getName();
							}
							
						}, new Function<Student, Integer>() {

							@Override
							public Integer apply(Student t) {
								
								return t.getScore();
							}
						
						}) //toMap 메소드의 닫는 부분
						
						); // collect라는 메소드의 열고 닫는 부분
		
	
	Map<String, Integer> map = list.stream()// 람다식
			.filter(s -> s.getScore() / 10 == 8)//
			.sorted()//
			.collect(//
					Collectors.toMap(//
					 (t) -> t.getName(), //key
					 (t) -> t.getScore() //value
					 )//
					);
	
	Set<String>set = map.keySet();
		for(String key : set) {
			System.out.println("Key: " + key + ", val: " + map.get(key));
		}
					
		}
	}
}
