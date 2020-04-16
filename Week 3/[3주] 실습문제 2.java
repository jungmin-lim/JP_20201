import java.util.Scanner;

public class Week3 {

	public static void main(String[] args) {
		
		Scanner input = new Scanner(System.in);
		
		Square s1 = new Square();
		
		switch(input.nextInt()) {		
		case 1: // move(delta_x,delta_y) 테스트
			s1.move(input.nextInt(), input.nextInt());
			System.out.println(s1.length + " " + s1.x + " " + s1.y);
			break;
		case 2: // move(delta) 테스트
			s1.move(input.nextInt());
			System.out.println(s1.length + " " + s1.x + " " + s1.y);
			break;
		case 3: // increase(delta)와 getArea()를 테스트
			System.out.println(s1.increase(input.nextInt()));
			System.out.println(s1.length + " " + s1.x + " " + s1.y);
			System.out.println(s1.getArea());
			break;
		}
		
		input.close();
	}

}
