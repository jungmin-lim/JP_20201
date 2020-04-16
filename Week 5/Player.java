
public abstract class Player 
{
	public static int total_money = 1000000;
	public static int total_num_borrow = 0;
	
	public String name;
	public int x,y;
	public int money;	
	public int score;	
		
    public Player(String name, int x, int y) 
    {	// 생성자 method
		this.name = name; this.x = x; this.y=y;		
		this.money = 0; this.score = 0;
	}
	
    public void move(int delta_x, int delta_y) 
    {
		this.x += delta_x; this.y += delta_y;
	}
	
    public void borrow(int m) 
    { // 은행에서 m원을 빌림
		if (total_money >= m) {	total_money -= m; this.money += m;	total_num_borrow++; }
	}
	
    public void repay(int m) 
    { // 은행에 m원을 돌려줌
		if (this.money >= m) { this.money -= m;	total_money += m; }
	}
	
	public abstract void sound();
	
	public abstract void show();
}

