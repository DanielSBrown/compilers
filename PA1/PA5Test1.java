/* 
 * Daniel Brown (dsb9ef)
 * PA5Test1
 *
 * */

import meggy.Meggy;
class PA5Test1 {
	public static void main(String[] args) {                   //Testing class variables
	//	Meggy.toneStart(Meggy.Tone.C3, 100);	
	//	Meggy.setPixel((byte)4, (byte)4, Meggy.Color.BLUE);
	//	Meggy.setPixel(new test().getByte(4), (byte)1, Meggy.Color.RED);	
		
		Meggy.setPixel(new test().getX(), new test().getY(), Meggy.Color.VIOLET);
	}



}
class test {
	byte x;
	byte y;
	public byte getX() {
		x = (byte)1;
		return x;
	}
	public byte getY() {
		y = (byte)2;
		return y;
	}
}
