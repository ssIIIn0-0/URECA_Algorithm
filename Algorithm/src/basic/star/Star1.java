package basic.star;

public class Star1 {

	public static void main(String[] args) {
		
		// 내 코드
		for (int i = 0; i < 5; i++) {
            for (int j = 0; j < i; j++) {
                System.out.print(" ");
            }

            for (int k = 5; k > i; k--) {
                System.out.print("*");
            }
            
            System.out.println();
        }
		
		for (int i = 0; i < 5; i++) {
            System.out.println(" ".repeat(i) + "*".repeat(5 - i));
        }
		
		// 강사님 코드
		for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
            	if (i > j)
            		System.out.print(" ");
            	else
            		System.out.print("*");
            }
            
            System.out.println();
        }

	}

}
