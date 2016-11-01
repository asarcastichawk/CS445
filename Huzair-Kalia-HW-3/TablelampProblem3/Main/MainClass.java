package Main;
import lightbulb.Lightbulb;
import button.PushDownButton;


public class MainClass {

	public static void main(String[] args) {
		TableLamp ltb = new Lightbulb();
		PushDownButton btn = new PushDownButton();
		btn.PushButton(ltb);
		btn.PushButton(ltb);
	}

}
