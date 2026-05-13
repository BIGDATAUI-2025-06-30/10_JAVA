package Ch18_;

/* ----------------------------------------------------------
   8. [연습문제] 직원 데이터로 스트림 종합 활용
   ----------------------------------------------------------
   주어진 직원 리스트에서 :
     Q1. IT 부서 직원만 골라 이름순으로 정렬해 이름 리스트로 반환
     Q2. 부서별 평균 연봉 (Map<부서, 평균>)
     Q3. 연봉 상위 3 명의 이름
     Q4. 전체 연봉 합계
     Q5. 모든 직원의 나이가 20 이상인지 검사
     Q6. 부서 종류 (중복 제거된 부서 이름 리스트)
     Q7. 부서별 직원 수 (Map<부서, count>)

   학습 포인트 :
     - filter / map / sorted / distinct / limit 조합
     - Collectors.groupingBy + averagingInt / counting
     - allMatch / mapToInt + sum / collect
   ---------------------------------------------------------- */

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class C08Ex {

	// 연습용 직원 데이터 클래스 (이름 / 부서 / 나이 / 연봉)
	static class Emp {
		String name;
		String dept;
		int    age;
		int    salary;

		Emp(String name, String dept, int age, int salary) {
			this.name   = name;
			this.dept   = dept;
			this.age    = age;
			this.salary = salary;
		}
		@Override
		public String toString() {
			return name + "(" + dept + "," + age + "세," + salary + ")";
		}
	}

	public static void main(String[] args) {

		List<Emp> emps = Arrays.asList(
				new Emp("김철수", "IT",   28, 4500),
				new Emp("이영희", "HR",   35, 3800),
				new Emp("박민수", "IT",   42, 6200),
				new Emp("정수진", "Sales",31, 4100),
				new Emp("최동훈", "IT",   25, 3500),
				new Emp("강서연", "HR",   29, 3900),
				new Emp("윤지호", "Sales",38, 4800),
				new Emp("한미래", "IT",   33, 5500)
		);

		// ====================================================
		// Q1. IT 부서 직원만 골라 이름순 정렬, 이름 리스트 반환
		// ====================================================
		List<String> q1 = emps.stream()
				.filter(e -> e.dept.equals("IT"))
				.sorted((a, b) -> a.name.compareTo(b.name))
				.map(e -> e.name)
				.collect(Collectors.toList());
		System.out.println("Q1. IT 부서 이름순 : " + q1);

		// ====================================================
		// Q2. 부서별 평균 연봉
		// ====================================================
		Map<String, Double> q2 = emps.stream()
				.collect(Collectors.groupingBy(
						e -> e.dept,
						Collectors.averagingInt(e -> e.salary)));
		System.out.println("Q2. 부서별 평균 연봉 : " + q2);

		// ====================================================
		// Q3. 연봉 상위 3명의 이름
		// ====================================================
		List<String> q3 = emps.stream()
				.sorted((a, b) -> b.salary - a.salary)
				.limit(3)
				.map(e -> e.name)
				.collect(Collectors.toList());
		System.out.println("Q3. 연봉 상위 3명 : " + q3);

		// ====================================================
		// Q4. 전체 연봉 합계
		// ====================================================
		int q4 = emps.stream().mapToInt(e -> e.salary).sum();
		System.out.println("Q4. 연봉 합계 : " + q4);

		// ====================================================
		// Q5. 모든 직원이 20세 이상인가
		// ====================================================
		boolean q5 = emps.stream().allMatch(e -> e.age >= 20);
		System.out.println("Q5. 모두 20세 이상? : " + q5);

		// ====================================================
		// Q6. 부서 종류 (중복 제거)
		// ====================================================
		List<String> q6 = emps.stream()
				.map(e -> e.dept)
				.distinct()
				.collect(Collectors.toList());
		System.out.println("Q6. 부서 종류 : " + q6);

		// ====================================================
		// Q7. 부서별 직원 수
		// ====================================================
		Map<String, Long> q7 = emps.stream()
				.collect(Collectors.groupingBy(
						e -> e.dept,
						Collectors.counting()));
		System.out.println("Q7. 부서별 인원 : " + q7);
	}
}
