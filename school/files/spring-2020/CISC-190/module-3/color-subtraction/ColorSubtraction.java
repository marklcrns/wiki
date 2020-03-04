
/*
 * Filename: ColorSubtraction.java
 *
 * Created by: Mark Lucernas
 *
 * Date: 03-03-2020
 *
 */

public class ColorSubtraction
{
 public static void main(String[] args) {
    // Get file name
    String file = FileChooser.pickAFile();

    // Original Picture object
    Picture pic = new Picture(file);
    pic.explore();

    // Make a copy and modify Picture object
    Picture copy = new Picture(pic);
    copy.subtractColor(100, 50, 30);
    copy.explore();
 }
}
