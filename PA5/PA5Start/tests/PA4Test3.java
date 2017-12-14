/* 
 * Daniel Brown (dsb9ef)
 * PA4Test3
 *
 * */

import meggy.Meggy;
class PA4Test3 {
	public static void main(String[] args) {                   //Testing void method
	//	Meggy.toneStart(Meggy.Tone.C3, 100);	
	//	Meggy.setPixel((byte)4, (byte)4, Meggy.Color.BLUE);
	//	Meggy.setPixel(new test().getByte(4), (byte)1, Meggy.Color.RED);	
		new test().setPix();
	}



}
class test {
	public void setPix() {
		Meggy.setPixel((byte)2, (byte)2, Meggy.Color.GREEN);
	}
}
