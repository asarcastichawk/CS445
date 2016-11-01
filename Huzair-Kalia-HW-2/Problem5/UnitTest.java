import static org.junit.Assert.*;

import java.util.Arrays;

import org.junit.Test;


public class UnitTest {

	String text = "This is text for test";
	ImprovedStringTokenizer string = new ImprovedStringTokenizer(text);
	
	@Test
	public void CheckArrayTest() {
		String[] strArr = string.arrayString();
		StringBuilder strBuilder = new StringBuilder();
		for (int i = 0; i < strArr.length; i++)
		{
			if(i==(strArr.length-1))
			strBuilder.append(strArr[i]);
			else
		    strBuilder.append(strArr[i]+" ");
		}
		String arrayval = strBuilder.toString();
		assertEquals(arrayval,text);
	}

}
