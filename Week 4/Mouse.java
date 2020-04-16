
public class Mouse extends Animal {

	public Mouse(String name, int age, double weight, int x, int y) {
		super(name, age, weight, x, y, "ᘛ⁐̤ᕐᐷ");		
	}
	
	@Override
	public void move(int delta_x, int delta_y) {		
		if (delta_x > 1) delta_x = 1; else if (delta_x < -1) delta_x = -1;
		if (delta_y > 1) delta_y = 1; else if (delta_y < -1) delta_y = -1;
		
		super.move(delta_x, delta_y);		
	}
}
