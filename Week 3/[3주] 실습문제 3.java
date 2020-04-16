import java.util.Scanner;

public class Week3 {

	public static void main(String[] args) {
		
		Scanner input = new Scanner(System.in);
		
		Square s1 = new Square(1,2,3);
		Square s2 = new Square(4,5,6);
		
		switch(input.nextInt()) {		
		case 1: // exchange(s) 테스트
			s1.exchange(s2);
			System.out.println(s1.length + " " + s1.x + " " + s1.y);
			System.out.println(s2.length + " " + s2.x + " " + s2.y);
			break;
		case 2: // duplicate(s) 테스트
			Square s3 = s1.duplicate();
			s1.increase(3);			
			System.out.println(s1.length + " " + s1.x + " " + s1.y);
			System.out.println(s3.length + " " + s3.x + " " + s3.y);
			break;		
		}
		
		input.close();
	}

}
