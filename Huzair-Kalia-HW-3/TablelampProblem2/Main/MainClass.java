package Main;
import lightbulb.Lightbulb;
import button.Button;

public class MainClass {

	public static void main(String[] args) {
		TableLamp ltb = new Lightbulb();
		Button btn = new Button();
		btn.switchOn(ltb);
		btn.switchOff(ltb);
	}

}
