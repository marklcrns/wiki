/*
 * NestedLoops.java
 * Copyright (C) 2020 Mark Lucernas <marklcrns@gmail.com>
 *
 * Distributed under terms of the MIT license.
 */

public class NestedLoops
{
	public static void main(String[] args) {
    Picture sourcePicture = new Picture(FileChooser.getMediaPath("turtle.jpg"));
    Picture sourcePicture2 = new Picture(FileChooser.getMediaPath("greenTurtle.jpg"));
    Picture canvas = new Picture(FileChooser.getMediaPath("7inx95in.jpg"));
    // source rectangle crop coordinates
    int[] sourceCrop = {31, 60, 16, 41};
    int[] sourceCrop2 = {34, 51, 12, 23};

    // Canvas measurements
    int canvasMaxWidth = canvas.getWidth() - (sourceCrop[1] - sourceCrop[0]);
    int canvasMaxHeight = canvas.getHeight() - (sourceCrop[3] - sourceCrop[2]);
    int canvasMinWidth = 0;
    int canvasMinHeight = 0;

    // turtle source loop
    for (int i = 0; i < 300; i++)
    {
      // Random coordinates generator based on canvas size
      int x = (int)((Math.random() * canvasMaxWidth) + canvasMinWidth);
      int y = (int)((Math.random() * canvasMaxHeight) + canvasMinHeight);

      // Paste source cropped image into random location in the canvas
      int[] sourceCropTarget = {x, y};

      canvas.cropFromSource(sourcePicture, sourceCrop, sourceCropTarget);
    }

    // greenTurtle source loop
    for (int i = 0; i < 300; i++)
    {
      // Random coordinates generator based on canvas size
      int x = (int)((Math.random() * canvasMaxWidth) + canvasMinWidth);
      int y = (int)((Math.random() * canvasMaxHeight) + canvasMinHeight);

      // Paste source cropped image into random location in the canvas
      int[] sourceCropTarget = {x, y};

      canvas.cropFromSource(sourcePicture2, sourceCrop2, sourceCropTarget);
    }

    canvas.show();
    sourcePicture.explore();
    sourcePicture2.explore();
	}
}
