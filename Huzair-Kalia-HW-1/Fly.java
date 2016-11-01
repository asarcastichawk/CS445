
public class Fly extends Creature implements Flyer {

	public Fly(String name) {
		super(name);
	}

	@Override
	public void fly() {
		System.out.println(this+" is buzzing around in Flight");
	}

	@Override
	public void move() {
		fly();
	}
	
	@Override
	public void eat(Thing aThing){
		if ( (aThing.getClass().getSimpleName()).equalsIgnoreCase("Thing") ) {
			System.out.println(this+" has just eaten a "+aThing.toString());
	  	}
		else
			System.out.println(this+" won't eat a "+aThing.toString());
		
	}

}
