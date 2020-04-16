
public class Animal {	
	private String name;
	private int age;
	private double weight;
	private int x,y;
	private String shape;
	
	protected Animal(String name, int age, double weight, int x, int y, String shape) {
		this.name = name; this.age = age; this.weight = weight;
		this.x = x; this.y = y;
		this.shape = shape;
	}
	
	protected void move(int delta_x, int delta_y) {
		this.x += delta_x; 
		this.y += delta_y;
	}
	
	public double distFrom(Animal a) {
		return Math.sqrt( (this.x-a.x)*(this.x-a.x) + (this.y-a.y)*(this.y-a.y));
	}
	
	public void showInfo() {
		System.out.println(name + "," + age + "살," + 
				weight + "Kg" + " @ (" + x + "," + y + ")");		
	}
	
	public int ageDiff(Animal a) {		
		return (this.age >= a.age) ? this.age - a.age : a.age - this.age;
		// 혹은 if-else 문으로 다음과 같이도 작성 가능
		//if (this.age >= a.age) return this.age - a.age;
		//else return a.age - this.age;
	}
	
	public void show() {
		for(int i=1;i<=21;i++) System.out.print("-");
		System.out.println();
		
		for(int i=-2;i<this.y;i++) System.out.println();
		
		for(int i=-10;i<this.x;i++) System.out.print(" ");
		
		System.out.println(this.shape);
		
		for(int i=this.y+1;i<=2;i++) System.out.println();
		
		for(int i=1;i<=21;i++) System.out.print("-");
		System.out.println();
	}
}