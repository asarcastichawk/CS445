package button;
import Main.TableLamp;

public class Button {
	
	
	
	public void switchOn(TableLamp tbl){
		System.out.println("Button switched to ON");
		tbl.on();
	}
	public void switchOff(TableLamp tbl){
		System.out.println("Button switched to OFF");
		tbl.off();
	}
}
