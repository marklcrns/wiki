/*
 * SwapColors.java
 *
 * Created by: Mark Lucerjas
 *
 * Date: 2020-03-22
 */

public class SwapColors
{
  public static void main(String[] args) {
    String file = FileChooser.pickAFile();
    Picture pic = new Picture(file);
    Picture picCopy = new Picture(pic);

    pic.swapColors1D();
    pic.show();
    picCopy.swapColors2D();
    picCopy.show();
  }
}
