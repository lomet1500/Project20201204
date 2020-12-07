package streams;

import java.util.Arrays;
import java.util.OptionalInt;
import java.util.function.IntConsumer;
import java.util.function.IntPredicate;
import java.util.stream.IntStream;

public class StreamExample2 {
	public static void main(String[] args) {
		// 1 ~ 100까지의 숫자를 가져오기
		// 짝수만 결과를 출력하도록 해보세요.
		IntStream.rangeClosed(1, 100).filter(t -> t%2 == 0).forEach(s -> System.out.println(" " + s + " "));
		
		int sum = IntStream.rangeClosed(1, 100).filter(t -> t%2 == 0).sum();
			
		
		int[] intAry = {2,6,4,8,1,9};
		IntStream is = Arrays.stream(intAry);
		OptionalInt max = is.max();
		System.out.println(max);
		
		int imax = max.getAsInt(); 
		System.out.println(imax);
		

//		int max1 = is.min().getAsInt();
//		System.out.println(max);	메소드 호출

		is = Arrays.stream(intAry);
		
		System.out.println("평균: " + is.average().getAsDouble());
		
		// 조건(filter)
		Arrays.stream(intAry).filter(new IntPredicate() {

			@Override
			public boolean test(int a) {
				
				return a > 5;
			}

		}).forEach(new IntConsumer(){

			@Override
			public void accept(int a) {
				System.out.println(a);
				
			}
			
		});
		
//		Arrays.stream(intAry).filter((int a) -> a % 2 ==0).forEach((a) ->
//				System.out.println(a));
				
		
		
			}
			
	}



// Stream <Integer> - stream은 Integer 클래스를 사용 
// IntStream (int) predicate(x)
// LongStream
// DoubleStream - 3개밖에 스트림이 없다