/* 
 * Daniel Brown (dsb9ef)
 * PA3Test1
 *
 * */

import meggy.Meggy;
class PA3Test1 {
	public static void main(String[] args) {                   //Testing control flow
		if(Meggy.checkButton(Meggy.Button.Up)) {
			Meggy.setPixel((byte)3, (byte)4, Meggy.Color.BLUE);
		}
		else {
			Meggy.setPixel((byte)3, (byte)4, Meggy.Color.RED);
		}
	}
}
