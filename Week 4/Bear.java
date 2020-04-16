
public class Bear extends Animal {

	public Bear(String name, int age, double weight, int x, int y) {
		super(name, age, weight, x, y, "ʕ •ᴥ•ʔ");		
	}	
	
	@Override
	public void move(int delta_x, int delta_y) {		
		if (delta_x > 5) delta_x = 5; else if (delta_x < -5) delta_x = -5;
		if (delta_y > 5) delta_y = 5; else if (delta_y < -5) delta_y = -5;
		
		super.move(delta_x, delta_y);
		//this.x += delta_x; 
		//this.y += delta_y;
	}
}

