import java.util.Arrays;
import java.util.Scanner;

public class Week5 {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int N = input.nextInt();	
		for(int i=0;i<N;i++) {
			C c = new C();
			int N1 = input.nextInt(); int N2 = input.nextInt();
			for(int j=0;j<N1;j++) c.f1();
			for(int j=0;j<N2;j++) c.f2();
		}
		input.close();
	}

}