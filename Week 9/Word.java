public class Word implements Comparable<Word>
{
    public String word;
    public int count;

    public Word(String word) 
    {
        this.word = word;
        this.count = 1;
    }

    public String toString() 
    {
        return "(" + this.word + "," + this.count + ")";
    }

    public int compareTo(Word o)
    {
        if(this.count > o.count)
        {
            return -1;
        }
        else if(this.count == o.count)
        {
            return 0;
        }
        else return 1;
    }
}