public class Rook extends Player implements Comparable<Rook>
{

    public Rook(String name, int x, int y) 
    {
		super(name, x, y);		
	}

	@Override
    public void sound() 
    {
		System.out.println("부릉부릉~");		
	}

	@Override
    public void show() 
    {
		System.out.println("rook");		
    }
    
    @Override
    public int compareTo(Rook r)
    {
        int cmp = this.score - r.score; 
        if(cmp == 0)
        {
            return this.money - r.money;
        }
        else
        {
            return cmp;
        }
    }
}
