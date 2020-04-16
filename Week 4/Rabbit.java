
public class Rabbit extends Animal {
	
	public Rabbit(String name, int age, double weight, int x, int y) {
		super(name, age, weight, x, y, "(o:3");		
	}	

	@Override
	public void move(int delta_x, int delta_y) {		
		if (delta_x > 3) delta_x = 3; else if (delta_x < -3) delta_x = -3;
		if (delta_y > 3) delta_y = 3; else if (delta_y < -3) delta_y = -3;
		
		super.move(delta_x, delta_y);		
	}
}
