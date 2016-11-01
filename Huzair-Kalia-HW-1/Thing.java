
public class Thing extends java.lang.Object {

	private String thing_name;
	
	public Thing(java.lang.String name)
	{	
		thing_name = name;
	}
	
	public java.lang.String toString()
		{
		  	if ( (this.getClass().getSimpleName()).equalsIgnoreCase("Thing") ) {
		  		return thing_name+" ";
		  	}
		  	else{
		  		String class_name = getClass().getSimpleName();
				return thing_name+" "+ class_name;
		  	}
			
		}
}
