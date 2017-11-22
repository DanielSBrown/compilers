/*
 * Daniel Brown (dsb9ef)
 * PA4Test3
 *
 * */

import meggy.Meggy;
class PA4Test3 {
	public static void main(String[] args) {                   // Going to fail, since there is no > sign in PA4
    if ((byte)3 > (byte)2) {
      Meggy.setPixel((byte)2, (byte)2, Meggy.Color.GREEN);
    }
	}



}
