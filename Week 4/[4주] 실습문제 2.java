import java.util.Scanner;

public class Week4 {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		
		PolarPoint pp = new PolarPoint(input.nextDouble(), input.nextDouble());		
		
		System.out.printf("(%.2f,%.2f)\n",pp.getX(), pp.getY()); // C언어 prinf() 함수와 같은 형식		
	}

}
