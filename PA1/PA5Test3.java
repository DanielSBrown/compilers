/* 
 * Daniel Brown (dsb9ef)
 * PA5Test3
 *
 * */

import meggy.Meggy;
class PA5Test3 {
	public static void main(String[] args) {                   //Testing object creation
		
		Meggy.setPixel(new test2().get4pt2(), (byte)0, Meggy.Color.BLUE);
	}



}
class test {
	public byte get4() {
		int x;
		x = 4;
		return (byte)x;
	}
}
class test2 {
	public byte get4pt2() {
		test t;
	        t = new test();
		return t.get4();
	}
}
