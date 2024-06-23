package basic.recursive;

public class RecursiveCallTest {

	public static void main(String[] args) {
//		m1();
//		m1_2(0);
//		m2();
//		m3();
//		m4();
		m5(5);
	}

	static int m1_cnt = 0;

	static void m1() {
		// local 변수 값(m1에서 선언한 값)은 항상 초기화
//		int i = 0;
//		System.out.println("m1" + i);
//		m1();

		// static 변수는 공유
		System.out.println("m1 " + m1_cnt++);
		m1();
	}

	// parameter 공유
	static void m1_2(int i) {
		System.out.println("m1_2" + i);
		i++;
		m1_2(i);
	}

	static int m2_cnt = 5;

	static void m2() {
		System.out.println("앞 m2 cnt : " + m2_cnt);

		if (m2_cnt > 0) {
			m2_cnt--;
			m2();
		}
		System.out.println("뒤 m2 cnt : " + m2_cnt);
	}

	static int m3_cnt = 5;

	static void m3() {
		System.out.println("앞 m3 cnt : " + m3_cnt); // 기저조건 check 전에 항상 수행
		// 기저조건
		if (m3_cnt == 0) {
			return;
		}
		m3_cnt--;
		m3();

		System.out.println("뒤 m3 cnt : " + m3_cnt); // 기저조건 check 후에 있어서 기저조건에 의해 return 되면 쌍이 맞지 않음 (기저조건 전에 있는게 1개 더  많음)
	}

	static int m4_cnt = 5;

	static void m4() {
		// 기저조건
		if (m4_cnt == 0) {
			return;
		}

		// 앞, 뒤 출력을 쌍으로 맞추려면 기저조건이 맨 위로 이동해야 한다.
		System.out.println("앞 m4 cnt : " + m4_cnt);
		m4_cnt--;
		m4();
		m4_cnt++; // 재귀호출 전후에 동일한 static 변수의 값을 가지려면 변화량의 반대로 처리를 해줘야 한다.
		System.out.println("뒤 m4 cnt : " + m4_cnt);
	}

	// static 대신 파라미터 공유
	static void m5(int m5_cnt) {
		// 기저조건
		if (m5_cnt == 0) {
			return;
		}

		// 앞, 뒤 출력을 쌍으로 맞추려면 기저조건이 맨 위로 이동해야 한다.
		System.out.println("앞 m4 cnt : " + m5_cnt);
		
		// 1. 줄였다 원복.
//		m5_cnt--;
//		m5(m5_cnt);
//		m5_cnt++; // 재귀호출 전후에 동일한 static 변수의 값을 가지려면 변화량의 반대로 처리를 해줘야 한다.
		
		// 2, 쥴이지 않고 줄이는 연산을 통해서 전달
//		m5(m5_cnt - 1);
		
		// 3. -- 연산자
//		m5(m5_cnt--);	// stack overflow
		
		// 4. -- 연산자 앞
		m5(-- m5_cnt);
		m5_cnt++;	// 원복이 필요
		System.out.println("뒤 m5 cnt : " + m5_cnt);
	}

}
