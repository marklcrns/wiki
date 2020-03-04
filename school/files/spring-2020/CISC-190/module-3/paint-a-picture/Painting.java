
/*
 * Filename: Painting.java
 *
 * Created by: Mark Lucernas
 *
 * Date: 03-03-2020
 *
 */

public class Painting
{
 public static void main(String[] args) {
    Picture pic1 = new Picture(FileChooser.pickAFile());
    pic1.createSolid(50, 100, 50);
    pic1.show();

    Picture pic2 = new Picture(FileChooser.pickAFile());
    pic2.createPattern(50, 50, 200);
    pic2.show();
 }
}
