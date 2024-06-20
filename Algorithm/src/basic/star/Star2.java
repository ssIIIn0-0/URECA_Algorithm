package basic.star;

public class Star2 {

	// 반복문 + 출력 + 반전 시점
	// 반전 : 저ㅓㅇ확히 반인 곳에서 공백 기준으로 점점 증가? 점점 감소? 를 판단 (밑으로 가면서)
	// 옆으로(열) 가면서 공백 출력 나머지 조건 (전체 7 중 공백 뺀 만큼) 에 별 출력

	public static void main(String[] args) {
		// 내코드
		System.out.println("내 코드");
		for (int i = 0; i < 7; i++) {
			for (int j = 0; j < 7; j++) {
				if (i < 7 / 2) {
					if (i > j)
						System.out.print(" ");
					else
						System.out.print("*");

					if (7 - i == j + 1) {
						break;
					}
				} else {
					if (7 - i > j + 1)
						System.out.print(" ");
					else
						System.out.print("*");
					if (i == j) {
						break;
					}
				}
			}
			System.out.println();
		}

		System.out.println("\n 강사님 코드");
		// 강사님 코드
		int turnCnt = 7 / 2; // 3
		int spaceCnt = 0; // 공백 개수
		boolean spaceIncrease = true; // 공백문자 수 증가? 감소?

		for (int i = 0; i < 7; i++) {
			for (int j = 0; j < 7; j++) {
				if (j < spaceCnt) {
					System.out.print(" ");
				} else if (j < 7 - spaceCnt) {
					System.out.print("*");
				}
			}
			System.out.println();
			// 헹 별 출력이 완료 => 공백 증가 감소 판단
			if (spaceIncrease)
				spaceCnt++;
			else
				spaceCnt--;

			if (spaceCnt == turnCnt) // 다음 행부터 감소로 변경
				spaceIncrease = false;
		}

		System.out.println("\n 강사님 코드 리팩토링 씬ver.");
		// 강사님 코드 리팩토링 씬ver.
		int totalRows = 7;
		int turnCnt2 = totalRows / 2; // 3
		int spaceCnt2 = 0; // 공백 개수
		int delta = 1; // 공백문자 수 증가(+1) 또는 감소(-1)

		for (int i = 0; i < totalRows; i++) {
			// 공백 출력
			System.out.print(" ".repeat(spaceCnt2));
			// 별 출력
			System.out.print("*".repeat(totalRows - 2 * spaceCnt2));
			// 줄 바꿈
			System.out.println();

			// 공백 개수 변경
			spaceCnt2 += delta;

			// 공백 개수가 turnCnt에 도달하면 방향 변경
			if (spaceCnt2 == turnCnt2) {
				delta = -delta;
			}
		}

		System.out.println("\n 강사님 코드 리팩토링 강사님ver.");
		// 강사님 코드 리팩토링 강사님ver.
		int turnCnt3 = 7 / 2; // 3
		int spaceCnt3 = 0; // 공백 개수
		boolean spaceIncrease3 = true; // 공백문자 수 증가? 감소?

		for (int i = 0; i < 7; i++) {
//			// 1. 출력하지 않을 부분까지 j<7 로 따진다.
//			for (int j = 0; j < 7; j++) {
//				if (j < spaceCnt3) {
//					System.out.print(" ");
//				} else if (j < 7 - spaceCnt3) {
//					System.out.print("*");
//				}
//			}
//			// 2. 출력할 부분까지만 따진다.
//			for (int j = 0; j < 7-spaceCnt3; j++) {
//				if (j < spaceCnt3) {
//					System.out.print(" ");
//				} else if (j < 7 - spaceCnt3) {
//					System.out.print("*");
//				}
//			}
			
			// 3. if else문을 삭제
			// 가독성때문이 아니라, 결국 if, else문은 for문을 돌릴때마다 수행해야하는 코드이므로 그걸 줄인거임
			// for문 2개는 그냥 수행만 하면 되니까
			for (int j = 0; j < spaceCnt3; j++) {
				System.out.print(" ");
			}
			for (int j = spaceCnt3; j < 7-spaceCnt3; j++) {
				System.out.print("*");
			}
			System.out.println();
			// 헹 별 출력이 완료 => 공백 증가 감소 판단
			if (spaceIncrease3)
				spaceCnt3++;
			else
				spaceCnt3--;

			if (spaceCnt3 == turnCnt3) // 다음 행부터 감소로 변경
				spaceIncrease3 = false;

		}
	}

}