package Main;
import static org.junit.Assert.*;
import org.junit.Test;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import lightbulb.Lightbulb;
import button.PushDownButton;
public class TableLampTest {

	ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    PrintStream ps = new PrintStream(outContent);
    PrintStream old = System.out;
	
    TableLamp ltb = new Lightbulb();
    PushDownButton btn = new PushDownButton();
    
    
	@Test
	public void testButtonSwitchOn() {
		System.setOut(ps);
	    btn.PushButton(ltb);
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
		btn.PushButton(ltb); //Because it works like a chain switch we need to turn it on before turning it off
		System.setOut(ps);
	    btn.PushButton(ltb);
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
