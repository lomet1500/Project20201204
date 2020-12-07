package streams;

import java.util.Arrays;
import java.util.List;
import java.util.function.IntBinaryOperator;

public class ReduceExample {
	public static void main(String[] args) {
		List<Student> list = Arrays.asList(//
				new Student("Hong", 80), //
				new Student("Hwang", 90), //
				new Student("Park", 87)//
		);
		// 학생점수합계.할당.
		int sum = list.stream().mapToInt(t -> t.getScore()).sum();
		System.out.println("합계: " + sum);

		// reduce
		int result = list.stream()//
				.mapToInt(t -> t.getScore())// 
				.reduce(new IntBinaryOperator() {

					@Override
					public int applyAsInt(int left, int right) {
						System.out.println("left:" + left + ", right: " + right);
						return left + right; // 두개의 결과값을 리턴시키고 그 다음 값을 계산
					}

				}).getAsInt();

		System.out.println("결과값: " + result);

		result = list.stream().mapToInt(t -> t.getScore()).reduce(100, (left, right) -> left < right ? left : right);
		System.out.println("최소값: " + result);

		result = list.stream().mapToInt(t -> t.getScore()).reduce((left, right) -> (left + right)/2 ).getAsInt(); //getAsInt
		System.out.println("평균값: " + result);

		//  mapToInt가 없으면 reduce에서 들어오는 매개값은 student
		
		}
		}

