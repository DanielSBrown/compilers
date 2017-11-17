

import meggy.Meggy;

class ten {
  public static void main (String[] args) {
    while (Meggy.getPixel((byte)2,(byte)1) == Meggy.Color.BLUE){
      Meggy.setPixel((byte)1,(byte)-1, Meggy.Color.GREEN);
    }


  }
}
