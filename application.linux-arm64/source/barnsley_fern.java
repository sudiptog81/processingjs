import processing.core.*; 
import processing.data.*; 
import processing.event.*; 
import processing.opengl.*; 

import java.util.HashMap; 
import java.util.ArrayList; 
import java.io.File; 
import java.io.BufferedReader; 
import java.io.PrintWriter; 
import java.io.InputStream; 
import java.io.OutputStream; 
import java.io.IOException; 

public class barnsley_fern extends PApplet {

float x, y;

public void setup() {
  
  background(255);
}

public void drawPoint() {

  stroke(34, 139, 34);
  strokeWeight(1);
  float px = map(x, -2.1820f, 2.6558f, 0, width);
  float py = map(y, 0, 9.9983f, height, 0);
  point(px, py);
}

public void nextPoint() {
  float nextX, nextY;
  float r = random(1);

  if (r<0.01f) {
    nextX =  0;
    nextY =  0.16f * y;
  } else if (r<0.86f) {
    nextX =  0.85f * x + 0.04f * y;
    nextY = -0.04f * x + 0.85f * y + 1.6f;
  } else if (r<0.93f) {
    nextX =  0.20f * x - 0.26f * y;
    nextY =  0.23f * x + 0.22f * y + 1.6f;
  } else {
    nextX = -0.15f * x + 0.28f * y;
    nextY =  0.26f * x + 0.24f * y + 0.44f;
  }

  x = nextX;
  y = nextY;
}

public void draw() {
  for (int i = 0; i < 100; i++) {
    drawPoint();
    nextPoint();
  }
}
  public void settings() {  size(600, 600); }
  static public void main(String[] passedArgs) {
    String[] appletArgs = new String[] { "barnsley_fern" };
    if (passedArgs != null) {
      PApplet.main(concat(appletArgs, passedArgs));
    } else {
      PApplet.main(appletArgs);
    }
  }
}
