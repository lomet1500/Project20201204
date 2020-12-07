package streams;

import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.function.ToIntFunction;
import java.util.stream.Stream;

import lambda.Student;

public class StreamExample3 {
	public static void main(String[] args) {
		
		String[] strs = "Java8-lanmbda-Hello".split(" ");
		
		List<String> strList = Arrays.asList("Jaba8 lambda", "stream mapping");
		strList.stream().flatMap(new Function<String, Stream<String>>(){

			@Override
			public Stream<String> apply(String t) {
				
				return Arrays.stream(t.split(" "));
			}
			
		}).filter(s-> s.startsWith("s")).forEach(s -> System.out.println(s));
		
//		
//		List<String> strList = Arrays.asList("Jaba8 lambda", "stream mapping");
//		strList.stream().flatMap((String t) ->Arrays.stream(t.split(" ")))
//		.forEach(s -> System.out.println(s));
		
		strList.stream()//
		.map(new Function<String, String>() {

			@Override
			public String apply(String t) {
				return t.toUpperCase();
			}
			
		}).forEach(s -> System.out.println(s));
		
		
		List<Student> students = Arrays.asList(//
				new Student("송다희","F",80),//
				new Student("윤태현","M",75),//
				new Student("이혜빈","F",85),//
				new Student("정병기","M",90));
				
				double sum = students.stream().mapToInt(new ToIntFunction<Student>() {

					@Override
					public int applyAsInt(Student s) {
						System.out.println(s.getName() + "/ " + s.getScore());
						return s.getScore();
					}
						
				}).average()//
				.getAsDouble();
				System.out.println("평균값: " + sum);
				}
	
}
