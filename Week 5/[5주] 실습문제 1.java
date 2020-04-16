import java.util.Arrays;
import java.util.Scanner;

public class Week5 {

	public static void main(String[] args) {		
		Scanner input = new Scanner(System.in);
		
		int N = input.nextInt();
		Rook rArray[] = new Rook[N];
		for(int i=0;i<N;i++) {
			Rook r = new Rook("rook #" + (i+1), i+1, i+1);
			r.score = input.nextInt();
			r.money = input.nextInt();
			rArray[i] = r;
		}
				
		Arrays.sort(rArray);

		for(int i=0;i<rArray.length;i++) 
			System.out.println(rArray[i].name + "(" + rArray[i].score + ", " + rArray[i].money + ")");
	}

}
