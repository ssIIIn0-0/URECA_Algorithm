package 구현_ch04;

import java.util.Scanner;

public class 왕실의나이트2 {
	static int y, x, result;
	// 나이트가 이동할 수 있는 8가지 방향 정의
    static int[] dy = {-1, -2, -2, -1, 1, 2, 2, 1};
    static int[] dx = {-2, -1, 1, 2, 2, 1, -1, -2};

	public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // 현재 나이트의 위치 입력받기
        String inputData = sc.nextLine();
        y = inputData.charAt(1) - '0';
        x = inputData.charAt(0) - 'a' + 1;

        // 만약 무조건 8개로 이동할 수 있으면 미리 출력
        // if문을 미리 써서 손해라고 생각할 수 있지만,
        // if문 : 비교 4번, for문까지 확인 : 8 x 4 = 32 로 오히려 if문을 사용하는게 나을 수 있다.
        if (y > 2 && y < 7 && x > 2 && x < 7) {
        	System.out.println(8);
        	return;
        }
        
        // 8가지 방향에 대하여 각 위치로 이동이 가능한지 확인
        for (int d = 0; d < 8; d++) {
            // 이동하고자 하는 위치 확인
            int ny = y + dy[d];
            int nx = x + dx[d];
            
            // 해당 위치로 이동된다면 다음꺼 확인
            if (ny < 1 || nx < 1 || ny > 8 || nx > 8) continue;
            
            result += 1;
        }

        System.out.println(result);
    }
}



//a1 2














