
/*
 * Filename: ColorSubtraction.java
 *
 * Created by: Mark Lucernas
 *
 * Date: 03-03-2020
 *
 */

public class TriEffect
{
  public static void main(String[] args) {
    // Get file name
    String file = FileChooser.pickAFile();

    // Original Picture object
    Picture pic = new Picture(file);

    // Copy Picture object
    Picture copy = new Picture(pic);

    int thirdOfPic = pic.getWidth() * (pic.getHeight() / 3);

    // First third
    int firstStart = 0;
    int firstEnd = thirdOfPic;
    copy.negative(firstStart, firstEnd);

    // Second third
    int secondStart = firstEnd;
    int secondEnd = secondStart + thirdOfPic;
    copy.grayscale(secondStart, secondEnd);

    // Third third
    int thirdStart = secondEnd;
    int thirdEnd = thirdStart + thirdOfPic;
    copy.myFilter(thirdStart, thirdEnd);

    pic.show();
    copy.show();
  }
}
