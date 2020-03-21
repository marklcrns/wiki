/*
 * Filename: SimpleCollage.java
 *
 * Date: 2020-03-20
 *
 * Description: This class is designed to create 2 copies of the desired Picture
 * object and combine them into one Picture object placed side by side
 * horizontally.
 *
 */

public class SimpleCollage
{
  public static void main(String[] args) {
    // Get file name
    String file = FileChooser.pickAFile();

    // Picture objects
    Picture canvas = new Picture();
    Picture pic = new Picture(file);
    // Picture copies
    Picture picCopy1 = new Picture(pic);
    Picture picCopy2 = new Picture(pic);

    pic.show();  // show original picture

    int picPixelCount = pic.getPixels().length;

    // Apply filters to all picture objects
    pic.negative(0, picPixelCount);
    picCopy1.myFilter(0, picPixelCount);
    picCopy2.mirrorHorizontalBottomToTop();

    // Combine all three pictures with collage method
    canvas = canvas.collage(pic, picCopy1, picCopy2);
    canvas.show();
  }
}
