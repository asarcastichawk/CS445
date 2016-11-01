
public class Tiger extends Creature{

	public Tiger(String name) {
		super(name);
	}

	@Override
	public void move() {
		System.out.println(this+" has just pounced");
	}

}
