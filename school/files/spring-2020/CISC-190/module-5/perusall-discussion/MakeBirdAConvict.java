/*
 * Filename: MakeBirdAConvict.java
 *
 * Created by: Mark Lucernas
 *
 * Date: 2020-04-13
 */

public class MakeBirdAConvict
{
  public static void main(String[] args) {
    String picFile = FileChooser.getMediaPath("green-bird.jpg");
    Picture myPic = new Picture(picFile);
    Picture myPicCopy = new Picture(myPic);

    myPic.show();
    myPicCopy.makeBirdAConvict();
    myPicCopy.show();
  }
}
