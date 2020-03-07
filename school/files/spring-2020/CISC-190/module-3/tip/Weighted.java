
/*
 * Filename: Weighted.java
 * Created by: Mark Lucernas
 * Date: 2020-03-04
 */

public class Weighted
{
	public static void main(String[] args) {
		String file = FileChooser.pickAFile();
    Picture pic = new Picture(file);
    pic.explore();
    pic.weightedRGBToRed(0.5, 0.4);
    pic.explore();
	}
}
