/* 
 * Daniel Brown (dsb9ef)
 * PA3Test3
 *
 * */

import meggy.Meggy;
class PA3Test3 {
	public static void main(String[] args) {                   //Testing while
		while(!Meggy.checkButton(Meggy.Button.Up)) {
			Meggy.setPixel((byte)(3+1), (byte)(4-2), Meggy.Color.RED);
			Meggy.setPixel((byte)2, (byte)2, Meggy.getPixel((byte)4,(byte)2));
		}
		
}
}
