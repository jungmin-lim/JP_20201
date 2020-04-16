import java.util.Scanner;

public class Week3 {

	public static void main(String[] args) {
		
		Scanner input = new Scanner(System.in);
		
		Square s1 = new Square(input.nextInt(), input.nextInt(), input.nextInt());		
		Square s2 = new Square();
		
		System.out.println(s1.length + " " + s1.x + " " + s1.y);
		System.out.println(s2.length + " " + s2.x + " " + s2.y);	
		
		input.close();
	}

}
