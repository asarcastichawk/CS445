import java.util.Random;

public class ImprovedRandom extends Random{
	 
		private static final long serialVersionUID = 1L;
		ImprovedRandom() {
		}
		ImprovedRandom(long seed){	
			setSeed(seed);
		}
		public int randInt(int min, int max) {
		Random rand = new Random();
	    int randomNum = rand.nextInt((max - min) + 1) + min;
	    return randomNum;
	}
}
