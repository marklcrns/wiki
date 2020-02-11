/* Variable for measurements */
int worldMaxWidth = 800;
int worldMinWidth = 1;
int worldMaxHeight = 600;
int worldMinHeight = 1;
int xRange = worldMaxWidth - worldMinWidth + 1;
int yRange = worldMaxHeight - worldMinHeight + 1;
int xCenter = worldMaxWidth / 2;
int yCenter = worldMaxHeight / 2;

World world1 = new World(worldMaxWidth, worldMaxHeight);
Turtle turtle1 = new Turtle(world1);

/* Create small spirals at random locations within the World */
for (int i=0; i<=300; i++) {
  turtle1.penUp();
  /* Random number generator with Java Math class for spiral coordinates*/
  int x = (int)((Math.random() * xRange) + worldMinWidth);
  int y = (int)((Math.random() * yRange) + worldMinHeight);
  turtle1.moveTo(x, y);
  turtle1.penDown();
  /* Draw spiral */
  for (int j=0; j<=20; j++) {
    turtle1.turn(45);
    turtle1.forward(j / 3);
  }
}

/* Center the turtle back */
turtle1.penUp();
turtle1.moveTo(xCenter, yCenter);
