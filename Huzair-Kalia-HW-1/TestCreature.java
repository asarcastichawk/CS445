/*
 * Huzair Kalia
 * Illinois Institute of Technology
 * CS 445
 */
public class TestCreature extends java.lang.Object{

	public static final int CREATURE_COUNT = 6;
	public static final int THING_COUNT = 10;
	
	public TestCreature(){}
	
	public static void main(String[] args) {
		
		Creature[] creature_array = new Creature[CREATURE_COUNT];
		creature_array[0] = new Tiger("Tigger");
		creature_array[1] = new Tiger("Jungle");
		creature_array[2] = new Ant("Sub-Zero");
		creature_array[3] = new Bat("Bruce");
		creature_array[4] = new Bat("Robin");
		creature_array[5] = new Fly("Doremon");
		
		Thing[] thing_array = new Thing[THING_COUNT];
		thing_array[0] = new Thing("Canned Meat");
		thing_array[1] = new Thing("Sugar Cube");
		thing_array[2] = new Thing("Stick");
		thing_array[3] = new Thing("Banana");
		
		for(int i =0;i<creature_array.length;i++){
			 thing_array[i+4] = creature_array[i]; }
		
		System.out.println("Things:\n");
		for(int i =0;i<thing_array.length;i++){
			System.out.println(thing_array[i]);}
		
		System.out.println("\n\nCreatures:\n");
		for(int i =0;i<creature_array.length;i++){
			System.out.println(creature_array[i]);}
		
		System.out.println("\n");
		for(int i=0;i<creature_array.length;i++)
			creature_array[i].move();
	}
}
