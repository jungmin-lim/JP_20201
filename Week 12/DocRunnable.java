import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class DocRunnable implements Runnable{
    SharedDoc sharedDoc;
    String text;
    int number;

    public DocRunnable(SharedDoc sharedDoc, String text, int number){
        this.sharedDoc = sharedDoc;
        this.text = text;
        this.number = number;
    }
    
    public void run(){
        sharedDoc.addText(this.text, this.number);
    }
}