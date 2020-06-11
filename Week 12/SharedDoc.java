import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class SharedDoc {
    String text;

    public SharedDoc(){
        text = "";
    }

    public void addText(String text, int number){
        synchronized(this){
            int numPrinted = 0;
            for(int i=0;i<number;i++) {
                for(int j=0;j<text.length();j++) {
                    this.text = this.text + text.charAt(j);
                    numPrinted++;
                    if (numPrinted%50==0) this.text = this.text + System.lineSeparator();
				}
			}
			System.out.println();
        }
    }
}