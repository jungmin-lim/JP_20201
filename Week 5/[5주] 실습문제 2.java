import java.util.Arrays;
import java.util.Scanner;

public class Week5 {

	public static void main(String[] args) {		
		Scanner input = new Scanner(System.in);
		int N = input.nextInt();	// class C 객체 수 입력
		for(int i=0;i<N;i++) {
			C c = new C();	// 새로운 class C 객체 생성
			int N1 = input.nextInt(); int N2 = input.nextInt();		// 객체 별 f1(), f2() 호출 수 입력			
			for(int j=0;j<N1;j++) c.f1();	// f1() 호출
			for(int j=0;j<N2;j++) c.f2();	// f2() 호출
		}		
		input.close();
	}

}
