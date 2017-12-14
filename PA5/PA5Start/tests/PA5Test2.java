/* 
 * Daniel Brown (dsb9ef)
 * PA5Test2
 *
 * */

import meggy.Meggy;
class PA5Test2 {
	public static void main(String[] args) {                   //Testing local variable assignment
		
		Meggy.setPixel(new test().get4(), (byte)0, Meggy.Color.RED);
	}



}
class test {
	public byte get4() {
		int x;
		x = 4;
		return (byte)x;
	}
}
