import java.util.Scanner;

public class Week4 {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		
		PolarPoint pp = new PolarPoint(input.nextDouble(), input.nextDouble());
		
		switch(input.nextInt()) {
		case 1:	System.out.printf("%.2f", pp.distFromOrigin());
				break;
		case 2: pp.setX(input.nextDouble());
				System.out.printf("(%.2f,%.2f)\n", pp.r, pp.theta);
				break;
		case 3: pp.setY(input.nextDouble());
				System.out.printf("(%.2f,%.2f)\n", pp.r, pp.theta);
				break;		
        }
        input.close();
    }
}

