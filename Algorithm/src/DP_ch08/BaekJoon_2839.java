package DP_ch08;

import java.util.Scanner;

//그리디
public class BaekJoon_2839 {

	static int N, answer;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		
		while(N >= 0) {
			if(N % 5 == 0) {
				answer += N / 5;
				System.out.println(answer);
				return;
			}
			else {
				N -= 3;
				answer++;
			}
		}
		
		System.out.println(-1);
	}

}

/*
// 강사님 코드
 public class BJ_설탕배달_2839_2 {
    static int N, count;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        while(true) {
            if( N < 0 ) { // 줄여나가는 과정에서 N 을 맞추지 못하고 음수가 되면
                System.out.println(-1);
                break;
            }
            
            // 0 이거나, 5 로 나누어 떨어지는 경우
            if( N % 5 == 0 ) { // -3 으로 처리하고 난 뒤 0 인 경우도 포함
                System.out.println(N / 5 + count );
                break;
            }
            
            N -= 3;
            count++;
        }
        
    }
}

 */
/*
3 - 1
4 - x
5 - 1
6 - 2
7 - x
8 - 2
9 - 3
10 - 2
11 - 3 
12 - 4
13 - 3
 */
