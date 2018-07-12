
//TODO 1: declare setup variables for the x-position of the three sliders
int sliderXposRed;
int sliderXposGreen;
int sliderXposBlue;

//TODO 2: declare setup variables for the red, green, and blue colours (hint: it has to be a float because map only accepts float)
float redColorValue;
float greenColorValue;
float blueColorValue;

//TODO 3: declare setup variables for the “goal colour” (the colour that will show up in the box) (hint: it has to be a float because random only accepts float)
float redGoalValue = random(1,255);
float greenGoalValue = random(1,255);
float blueGoalValue = random(1,255);

boolean gameover = false;

void setup() {
  size(600, 600);
  //TODO 4: set the initial x-position of the sliders (explain why we have to setup an initial value)
  sliderXposRed = 300;
  sliderXposGreen = 300;
  sliderXposBlue = 300;
}


void draw() {
  //TODO 5: set colour for the background (hint: the colour should not be a specific number!)
  background(redColorValue, greenColorValue, blueColorValue);
  fill(redGoalValue,greenGoalValue,blueGoalValue);
  stroke(redGoalValue,greenGoalValue,blueGoalValue);
  rect(300-25, 450, 50, 50);
  fill(127);
  stroke(0);
  
  redColorValue = map(sliderXposRed, 100, 500, 0, 255);
  strokeWeight(5);
  line(100, 200, 500, 200);
  ellipse(sliderXposRed, 200, 50, 50);

  //TODO 6 (part 1): make a map for the greenColorValue (map(value, start1, stop1, start2, stop2))
  greenColorValue = map(sliderXposGreen, 100, 500, 0, 255);
  strokeWeight(5);
  line(100, 300, 500, 300);
  ellipse(sliderXposGreen, 300, 50, 50);

  //TODO 6 (part 2): make a map for the blueColorValue
  blueColorValue = map(sliderXposBlue, 100, 500, 0, 255);
  strokeWeight(5);
  line(100, 400, 500, 400);
  ellipse(sliderXposBlue, 400, 50, 50);
  

  if (( redColorValue <= redGoalValue+10 && redColorValue >= redGoalValue - 10) && ( greenColorValue <= greenGoalValue+10 && greenColorValue >= greenGoalValue - 10) && ( blueColorValue <= blueGoalValue+10 && blueColorValue >= blueGoalValue - 10)){
    gameover = true;    
  }
  
  if (mousePressed) {
    float redPosition = dist (sliderXposRed, 200, mouseX, mouseY);

    if (redPosition < 25) {
      sliderXposRed = mouseX;
    }

    if ( sliderXposRed < 100) {
      sliderXposRed = 100;
    }

    if (sliderXposRed > 500) {
      sliderXposRed = 500;
    }

    //TODO 7(part 1): setup the knob so that the slider can move when it is pressed (and it cannot go past each end of the line) for Green slider
    float greenPosition = dist (sliderXposGreen, 300, mouseX, mouseY);

    if (greenPosition < 25) {
      sliderXposGreen = mouseX;
    }

    if ( sliderXposGreen < 100) {
      sliderXposGreen = 100;
    }

    if (sliderXposGreen > 500) {
      sliderXposGreen = 500;
    }

    //TODO 7(part 1): setup the slider so that the slider can move when it is pressed (and it cannot go past each end of the line) for Blue slider
    float bluePosition = dist (sliderXposBlue, 400, mouseX, mouseY);

    if (bluePosition < 25) {
      sliderXposBlue = mouseX;
    }

    if (sliderXposBlue < 100) {
      sliderXposBlue = 100;
    }

    if (sliderXposBlue > 500) {
      sliderXposBlue = 500;
    }
  }
  if (gameover == true){
    fill((redColorValue/2)+50, (greenColorValue/2)+50,(blueColorValue/2)+50);
    textSize(100);
    text("You Win!!!",75,500);
    noLoop();
  }
  //fill(255);
  //text(redColorValue,50,50);
  //text(greenColorValue,50,150);
  //text(blueColorValue,50,250);
}