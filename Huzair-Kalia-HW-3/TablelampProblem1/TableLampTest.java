import static org.junit.Assert.*;

import org.junit.Test;
import static org.junit.Assert.*;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import org.junit.Test;

public class TableLampTest {

	ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    PrintStream ps = new PrintStream(outContent);
    PrintStream old = System.out;
	
    TableLamp tlmp = new TableLamp();
    Button btn = new Button();
    Lightbulb ltb = new Lightbulb();
    
	@Test
	public void testButtonSwitchOn() {
		System.setOut(ps);
	    btn.switchOn();
	    System.out.flush();
	    System.setOut(old);
	    
	    String actualOutput = outContent.toString().trim();
	    String textStr[] = actualOutput.split("\\r\\n|\\n|\\r");
		String expectedOutput = "Button switched to ON";
		String expectedOutput2 = "Lightbulb on";
		assertEquals(expectedOutput, textStr[0]);
		assertEquals(expectedOutput2, textStr[1]);
	}
	
	@Test
	public void testButtonSwitchOFF() {
		System.setOut(ps);
	    btn.switchOff();
	    System.out.flush();
	    System.setOut(old);
	    
	    String actualOutput = outContent.toString().trim();
	    String textStr[] = actualOutput.split("\\r\\n|\\n|\\r");
		String expectedOutput = "Button switched to OFF";
		String expectedOutput2 = "Lightbulb off";
		assertEquals(expectedOutput, textStr[0]);
		assertEquals(expectedOutput2, textStr[1]);
	}
	
	@Test
	public void testLightbulbOn() {
		System.setOut(ps);
	    ltb.on();
	    System.out.flush();
	    System.setOut(old);
	    
	    String actualOutput = outContent.toString().trim();
		String expectedOutput = "Lightbulb on";
		assertEquals(expectedOutput, actualOutput);
	}
	
	@Test
	public void testLightbulbOff() {
		System.setOut(ps);
	    ltb.off();
	    System.out.flush();
	    System.setOut(old);
	    
	    String actualOutput = outContent.toString().trim();
		String expectedOutput = "Lightbulb off";
		assertEquals(expectedOutput, actualOutput);
	}

}
