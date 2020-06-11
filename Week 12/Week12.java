import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Week12 {
	public static void main(String[] args) {
		// create a shared document
        SharedDoc sharedDoc = new SharedDoc();

		// create n threads from input
		Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        Thread thread[] = new Thread[n];		

		for(int i=0;i<n;i++) {			
			thread[i] = new Thread(new DocRunnable(sharedDoc, input.next(), input.nextInt()));
        }		

		// start all threads
        for(int i=0;i<n;i++) thread[i].start();		

		// wait until all threads finish execution
		for(int i=0;i<n;i++)
			try {
				thread[i].join();
			} catch (InterruptedException e) {				
				e.printStackTrace();
            }

		// according to input option, print either entire doc OR sorted change sequence 
		int option = input.nextInt();
		input.close();
		switch(option) {
		case 1: System.out.println(sharedDoc.text); break;
		case 2: System.out.println(findSortedChangeSequence(sharedDoc.text)); break;
		}		
	}

	static String findSortedChangeSequence(String text) {
        if (text.length() == 0) return "";

        ArrayList<Character> changeSequence = new ArrayList<Character>();

		char current = text.charAt(0);
		changeSequence.add(current);
		for(int i=1;i<text.length();i++) {		
            if (text.charAt(i) == '\n' || text.charAt(i) == '\r') continue;

			if (text.charAt(i) != current) {
				current = text.charAt(i);
				changeSequence.add(current);
			}
		}
		
		Collections.sort(changeSequence);
		
		String rtText = "";
		for(char c:changeSequence) rtText += c;
		return rtText;
	}
}
