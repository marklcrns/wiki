
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
    Picture pic = new Picture(file);
    int picWidth = pic.getWidth();
    int picHeight = pic.getHeight();
    pic.show();  // show original picture

    // Canvas for collage
    Picture canvas = new Picture(picWidth * 3, picHeight);

    // Picture copies
    Picture picCopy1 = new Picture(pic);
    Picture picCopy2 = new Picture(pic);

    // Apply filters to all picture objects
    int picPixelCount = pic.getPixels().length;
    pic.negative(0, picPixelCount);
    picCopy1.myFilter(0, picPixelCount);
    picCopy2.mirrorHorizontalBottomToTop();

    // Combine all three pictures with collage method
    canvas.collage(pic, picCopy1, picCopy2);
    canvas.show();
  }
}
