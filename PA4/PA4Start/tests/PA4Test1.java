/* 
 * Daniel Brown (dsb9ef)
 * PA4Test1
 *
 * */

import meggy.Meggy;
class PA4Test1 {
	public static void main(String[] args) {                   //Testing while
		
		Meggy.setPixel((byte)4, (byte)4, Meggy.Color.BLUE);
		Meggy.setPixel(new test().getByte(4), (byte)1, Meggy.Color.RED);	
	}



}
class test {
	public byte getByte(int pix) {
		return (byte)pix;
	}
}
