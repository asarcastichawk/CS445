
public abstract class Creature extends Thing{

	
	Thing EatObj = null;
	
	public Creature(String name) {
		super(name);
	}
	
	public abstract void move();
	
	public void eat(Thing aThing){
		EatObj = aThing;
		System.out.println(this+" has just eaten a "+aThing.toString());
	}
	
	public void whatDidYouEat(){
		if(EatObj==null){
			System.out.println(this.toString()+" has had nothing to eat at all");
		}
		else
			System.out.println(this.toString()+" has eaten a "+ EatObj.toString());
	}

}
