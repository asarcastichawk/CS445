package button;
import Main.TableLamp;

public class PushDownButton {
	
	private boolean pushbutton = false;
	
	public void PushButton(TableLamp tbl){
		if(!pushbutton)
		{
			System.out.println("Button switched to ON");
			tbl.on();
			pushbutton=true;
		}
		else{
			System.out.println("Button switched to OFF");
			tbl.off();
			pushbutton=false;
		}
	}

}
