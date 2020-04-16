import java.util.Scanner;

public class Week4 {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		
		Point p = new Point(input.nextDouble(), input.nextDouble());
		System.out.println("(" + p.getX() + "," + p.getY() + ")");
		
		p.setX(input.nextDouble());
		p.setY(input.nextDouble());
		System.out.println("(" + p.getX() + "," + p.getY() + ")");
		
		System.out.printf("%.1f\n",p.distFromOrigin()); // C언어 prinf() 함수와 같은 형식
		
		
	}

}
