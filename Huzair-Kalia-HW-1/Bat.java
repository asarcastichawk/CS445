
public class Bat extends Creature implements Flyer {

	public Bat(String name) {
		super(name);
	}

	@Override
	public void fly() {
		System.out.println(this+" is swooping through the dark");
	}

	@Override
	public void move() {
		fly();
	}
	
	@Override
	public void eat(Thing aThing){
		if ( (aThing.getClass().getSimpleName()).equalsIgnoreCase("Thing") ) {
			System.out.println(this+" won't eat a "+aThing.toString());
	  	}
		else
			System.out.println(this+" has just eaten a "+aThing.toString());
		
	}

}
