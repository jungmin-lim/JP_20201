// #1
/*
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Scanner;

public class Week9 
{
    public static void main(String[] args) 
    {
        Scanner input = new Scanner(System.in);
        String paragraph = input.nextLine();
        input.close();

        String[] wordList = paragraph.split(" ");

        HashMap<String, Word> wordMap = new HashMap<String, Word>();
        for(String word : wordList) 
        {
            if (word.endsWith(".")) word = word.substring(0,word.length()-1);
            word = word.toLowerCase();

            Word w = wordMap.get(word);
            if (w != null) 
            { 
                w.count++; 
                wordMap.put(word, w);
            }
            else wordMap.put(word, new Word(word));
        }
        ArrayList<Word> wordArrayList= new ArrayList<Word>(wordMap.values());
        Collections.sort(wordArrayList);

        for(Word t : wordArrayList)
        {
            System.out.println(t.toString());
        }
	}
}
*/

import java.util.Scanner;

public class Week9 
{
    public static void main(String[] args)
    {
		Scanner input = new Scanner(System.in);
		Point p = new Point(input.nextInt(), input.nextInt());
		Word w = new Word(input.next());
		String s = new String(input.next());
        input.close();

		Pair<Point, Word> pwPair1 = new Pair<Point,Word>(p,w);
        Pair<Word, String> pwPair2 = new Pair<Word, String>(w,s);

		System.out.println(pwPair1.a);
		System.out.println(pwPair1.b);
		System.out.println(pwPair2.a);
		System.out.println(pwPair2.b);
	}
}
