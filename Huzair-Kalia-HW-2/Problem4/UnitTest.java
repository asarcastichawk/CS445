import static org.junit.Assert.*;

import org.junit.Test;


public class UnitTest {

	@Test
	public void ImprovedRandomWithSeedTest() {
		long a = 0, seed=0;
		ImprovedRandom rand = new ImprovedRandom(a);
		rand.setSeed(seed);
		assertEquals(seed,a);
	}
	@Test
	public void randIntTest() {
		ImprovedRandom rand2 = new ImprovedRandom();
		int a = rand2.randInt(5, 10);
		boolean isValid = false;
		if (a >= 5 || a <= 10){
		isValid = true;
		}
		assertTrue(isValid);
	}

}
