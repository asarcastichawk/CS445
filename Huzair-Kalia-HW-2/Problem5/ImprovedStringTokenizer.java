import java.util.StringTokenizer;

public class ImprovedStringTokenizer extends StringTokenizer {

	private String thestring;
	public ImprovedStringTokenizer(String str) {
		super(str);
		thestring = str;
	}
	
	public String [] arrayString()
	{
		StringTokenizer st = new StringTokenizer(thestring);
		int count = st.countTokens();
		String[] returnthis = new String[count];
		for(int i = 0; i < count ; i++){
			returnthis[i]=st.nextToken();
		}
		return returnthis;
	}
	

}
