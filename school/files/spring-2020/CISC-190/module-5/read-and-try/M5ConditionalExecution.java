/*
 * Filename: ConditionalExecution.java
 *
 * Created by: Mark Lucernas
 *
 * Date: 2020-03-27
 */

public class M5ConditionalExecution
{
  public static void main(String[] args) {
    String picFile = FileChooser.getMediaPath("my-pic-small.JPG");
    Picture myPic = new Picture(picFile);
    Picture copyMyPic = new Picture(myPic);

    // original picture
    myPic.explore();

    // sepiaTint filter
    copyMyPic.hightlightLightAndDark(70, java.awt.Color.CYAN);
    copyMyPic.explore();

    // posterize filter
    copyMyPic.posterize(10);
    copyMyPic.explore();

    // sepia filter
    copyMyPic.sepiaTint();
    copyMyPic.explore();
  }
}
