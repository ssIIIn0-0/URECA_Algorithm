package DP_ch08;

import java.util.Scanner;

public class 바닥공사 {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        int[] memory = new int[1001];

        memory[1] = 1;
        memory[2] = 3;
        for (int i = 3; i < n + 1; i++) {
            memory[i] = (memory[i - 1] + 2 * memory[i - 2]) % 796796;
        }
        System.out.println(memory[n]);
	}
}
