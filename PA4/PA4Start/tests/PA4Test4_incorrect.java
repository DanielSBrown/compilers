/*
 * Daniel Brown (dsb9ef)
 * PA4Test3
 *
 * */

import meggy.Meggy;
class PA4Test3 {
	public static void main(String[] args) {                   // Going to fail, since there are no local vars in PA4
    test t = new test();
		t.setPix();
	}



}
class test {
	public void setPix() {
		Meggy.setPixel((byte)2, (byte)2, Meggy.Color.GREEN);
	}
}
