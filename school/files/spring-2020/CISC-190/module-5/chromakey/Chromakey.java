/*
 * Filename: Chromakey.java
 *
 * Created by: Mark Lucernas
 *
 * Date: 2020-04-17
 */

import java.awt.*;

public class Chromakey
{
  public static void main(String[] args) {
    // get all the necessary pictures
    String prof = FileChooser.getMediaPath("prof-frankie-green-screen.JPG");
    String newBg = FileChooser.getMediaPath("moon-surface.jpg");
    String newShirt = FileChooser.getMediaPath("red-flannel-pattern.jpg");
    Picture profPic = new Picture(prof);
    Picture newBgPic = new Picture(newBg);
    Picture newShirtPic = new Picture(newShirt);

    // scale pictures to roughly match their resolution
    Picture biggerNewBgPic = newBgPic.scaleUp(4);
    Picture biggerNewShirtPic = newShirtPic.scaleUp(4);

    // replace profPic background with newBgPic
    profPic.chromakey(new Color(28, 143, 84), 70, biggerNewBgPic);

    // replace profPic blue shirt with newShirtPic
    profPic.chromakey(new Color(33, 42, 49), 20, biggerNewShirtPic);

    // apply custom vignette filter
    profPic.vignette(250);

    // show profPic
    profPic.show();

    // write profPic
    profPic.write("./Lucernas_Chromakey.jpg");
  }
}
