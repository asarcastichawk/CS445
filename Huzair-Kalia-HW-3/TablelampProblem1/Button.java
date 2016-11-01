
public class Button {
	
	Lightbulb ltb = new Lightbulb();
	
	public void switchOn(){
		System.out.println("Button switched to ON");
		ltb.on();
	}
	public void switchOff(){
		System.out.println("Button switched to OFF");
		ltb.off();
	}
}
