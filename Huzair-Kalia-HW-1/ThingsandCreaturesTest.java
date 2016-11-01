
import static org.junit.Assert.*;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import org.junit.Test;

public class ThingsandCreaturesTest {

	
	Thing test = new Thing("Chair");
	Creature test2 = new Tiger("The Tiger");
	Creature test3 = new Ant("The Ant");
	Creature test4 = new Bat("The Bat");
	Creature test5 = new Fly("The Fly");
	
	ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    PrintStream ps = new PrintStream(outContent);
    PrintStream old = System.out;
	
	@Test
	public void testToStringClassEquals() {
		assertEquals("Thing",test.getClass().getSimpleName());
		assertEquals("Tiger",test2.getClass().getSimpleName());
		assertEquals("Ant",test3.getClass().getSimpleName());
		assertEquals("Bat",test4.getClass().getSimpleName());
		assertEquals("Fly",test5.getClass().getSimpleName());
	}
	
	@Test
	public void testToStringReturnIsNotNull(){
		assertNotNull(test.toString());
		assertNotNull(test2.toString()); 
		assertNotNull(test3.toString()); 
		assertNotNull(test4.toString()); 
		assertNotNull(test5.toString()); 
	}
	
	@Test
	public void testStaticVarCountIsNotNull(){
		assertNotNull(TestCreature.CREATURE_COUNT);
		assertNotNull(TestCreature.THING_COUNT);
	}
	
	@Test
	public void CreatureEatObjShouldNotBeNullIfEaten(){
		test2.eat(test);
		assertNotNull(test2.EatObj);		
	}
	
	@Test
	public void testNames(){
		assertEquals("The Tiger Tiger",test2.toString());
		assertEquals("The Ant Ant",test3.toString());	
		assertEquals("The Bat Bat",test4.toString());	
		assertEquals("The Fly Fly",test5.toString());	
	}
	
	@Test
	public void testWhatDidYouEat(){
		System.setOut(ps);
	    test3.whatDidYouEat();
	    System.out.flush();
	    System.setOut(old);
	    
	    String actualOutput = outContent.toString().trim();
		String expectedOutput = "The Ant Ant has had nothing to eat at all";
		assertEquals(expectedOutput, actualOutput);
	}
	
	@Test
	public void testWhatDidYouEatIfNotNull(){
		test3.eat(test);
		System.setOut(ps);
	    test3.whatDidYouEat();
	    System.out.flush();
	    System.setOut(old);
	    
	    String actualOutput = outContent.toString().trim();
		String expectedOutput = "The Ant Ant has eaten a Chair";
		assertEquals(expectedOutput, actualOutput);
	}
	
	@Test
	public void testTigerMove(){
		System.setOut(ps);
	    test2.move();
	    System.out.flush();
	    System.setOut(old);
	    
	    String actualOutput = outContent.toString().trim();
		String expectedOutput = "The Tiger Tiger has just pounced";
		assertEquals(expectedOutput, actualOutput);
	}
	
	@Test
	public void testAntMove(){
		System.setOut(ps);
	    test3.move();
	    System.out.flush();
	    System.setOut(old);
	    
	    String actualOutput = outContent.toString().trim();
		String expectedOutput = "The Ant Ant is crawling around";
		assertEquals(expectedOutput, actualOutput);
	}
	
	@Test
	public void testFlyMove(){
		System.setOut(ps);
	    test5.move();
	    System.out.flush();
	    System.setOut(old);
	    
	    String actualOutput = outContent.toString().trim();
		String expectedOutput = "The Fly Fly is buzzing around in Flight";
		assertEquals(expectedOutput, actualOutput);
	}
	@Test
	public void testBatMove(){
		System.setOut(ps);
	    test4.move();
	    System.out.flush();
	    System.setOut(old);
	    
	    String actualOutput = outContent.toString().trim();
		String expectedOutput = "The Bat Bat is swooping through the dark";
		assertEquals(expectedOutput, actualOutput);
	}
	@Test
	public void testFlyEatAThing(){
		System.setOut(ps);
	    test5.eat(test);
	    System.out.flush();
	    System.setOut(old);
	    
	    String actualOutput = outContent.toString().trim();
		String expectedOutput = "The Fly Fly has just eaten a Chair";
		assertEquals(expectedOutput, actualOutput);
	}
	@Test
	public void testFlyEatACreature(){
		System.setOut(ps);
	    test5.eat(test4);
	    System.out.flush();
	    System.setOut(old);
	    
	    String actualOutput = outContent.toString().trim();
		String expectedOutput = "The Fly Fly won't eat a The Bat Bat";
		assertEquals(expectedOutput, actualOutput);
	}
	@Test
	public void testBatEatAThing(){
		
		System.setOut(ps);
	    test4.eat(test);
	    System.out.flush();
	    System.setOut(old);
	    
	    String actualOutput = outContent.toString().trim();
		String expectedOutput = "The Bat Bat won't eat a Chair";
		assertEquals(expectedOutput, actualOutput);
	}
	@Test
	public void testBatEatACreature(){
		
		System.setOut(ps);
	    test4.eat(test5);
	    System.out.flush();
	    System.setOut(old);
	    
	    String actualOutput = outContent.toString().trim();
		String expectedOutput = "The Bat Bat has just eaten a The Fly Fly";
		assertEquals(expectedOutput, actualOutput);
		
	}
	
}
