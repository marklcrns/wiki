/*
 * Filename: AdvancedCollage.java
 *
 * Created by: Mark Lucernas
 *
 * Date: 2020-04-14
 */

public class AdvancedCollage
{
  public static void main(String[] args) {
    Picture pic1 = new Picture(FileChooser.getMediaPath("yellowFlowers.jpg"));
    Picture pic2 = new Picture(FileChooser.getMediaPath("gardenwall.jpg"));
    Picture pic3 = new Picture(FileChooser.getMediaPath("waterfall.jpg"));
    Picture pic4 = new Picture(FileChooser.getMediaPath("temple.jpg"));
    Picture pic5 = new Picture(FileChooser.getMediaPath("passionFlower.jpg"));

    // collage 5 pictures
    Picture collage = Picture.createCollage(pic1, pic2, pic3, pic4, pic5);

    // show collage
    collage.show();

    // write collage into jpg file
    collage.write("./Lucernas_AdvancedCollage.jpg");
  }
}
