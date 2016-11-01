
public class Test{
	public static void main(String[] args){
		
		ImprovedStringTokenizer string = new ImprovedStringTokenizer("This class is easy");
		int count = string.countTokens();
		String[] stringarray = string.arrayString();
		for(int i = 0; i < count; i++)
			System.out.println(stringarray[i]);
		}
}
