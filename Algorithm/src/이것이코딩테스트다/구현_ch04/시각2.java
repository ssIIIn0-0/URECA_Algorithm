package 이것이코딩테스트다.구현_ch04;

import java.util.Scanner;
// 문자열로 처리하지 않고, 숫자로 처리하는 부분 OK
// 시, 분, 초를 나눠서 따로 처리하는 부분 OK
// || vs |, && vs &
// || : 한번 true가 나오면 나머지 뒤에거는 비교안함 && : 한번 false가 나오면 나머지 뒤에거는 비교안함
// | : 한번 true가 나와도 끝까지 모든걸 비교함 & : 한번 false가 나와도 끝까지 모든걸 비교함

public class 시각2 {
	static int N, cnt;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();

        long start = System.nanoTime();
        for (int h = 0; h <= N; h++) {
            if (h % 10 == 3) {
            	cnt += 3600;
            	continue;
            }
            for (int m = 0; m < 60; m++) {
            	if (m / 10 == 3 || m % 10 == 3) {
            		cnt += 60;
            		continue;
            	}
            	for (int s = 0; s < 60; s++){
                	if (s / 10 == 3 || s % 10 == 3) cnt++;
                }
            }
        }
        
        long end = System.nanoTime();
        System.out.println(cnt);
        System.out.println(end - start);
    }

}
// 5 11475