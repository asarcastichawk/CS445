
public class Ant extends Creature{
	
	public Ant(String name) {
		super(name);
	}

	@Override
	public void move() {
		System.out.println(this+" is crawling around");
	}
}
