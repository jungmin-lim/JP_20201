import java.util.Scanner;
import stringprocess.StringProcessor;

public class Week6 {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		StringProcessor sp = new StringProcessor();
		
		int N = input.nextInt();
		for(int i=0;i<N;i++) {
			String str = sp.extract_from_within_brackets(input.next());
			String[] words = sp.split_based_on_comma(str);
			System.out.println(sp.count_as(words));
		}
	}
}

