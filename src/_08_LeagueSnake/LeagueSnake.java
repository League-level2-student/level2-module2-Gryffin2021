package _08_LeagueSnake;

import java.awt.Color;
import java.util.ArrayList;
import java.util.Random;

import processing.core.PApplet;

public class LeagueSnake extends PApplet {
    static final int WIDTH = 800;
    static final int HEIGHT = 800;
    
    /*
     * Game variables
     * 
     * Put all the game variables here.
     */
    Segment head;
    ArrayList<Segment> tail = new ArrayList<Segment>();
    int foodX;
    int foodY;
    int direction = UP;
    int foodGobbled = 0;
    int r = 10;
    int r2 = 4;
    int speed = 10;
    /*
     * Setup methods
     * 
     * These methods are called at the start of the game.
     */
    @Override
    public void settings() {
        size(500, 500);
    }

    @Override
    public void setup() {
        head = new Segment(0, 0);
        frameRate(20);
        dropFood();
    }

    void dropFood() {
        // Set the food in a new random location
    	foodX = (int)random(500-30) + 10 ;
    	foodY = (int)random(500-30) + 10 ;
    	System.out.println(foodX);
    	System.out.println(foodY);
    }

    /*
     * Draw Methods
     * 
     * These methods are used to draw the snake and its food
     */

    @Override
    public void draw() {
    	background(Color.black.getRGB());
    	drawFood();
    	keyPressed();
    	move();
    	drawSnake();
    	eat();
    }

    void drawFood() {
        // Draw the food
    	fill(255, 0, 0);
        rect(foodX, foodY, 10, 10);
    }

    void drawSnake() {
        // Draw the head of the snake followed by its tail
    	fill(0, 255, 0);
        rect(head.X, head.Y, 10, 10);
        manageTail();
    }

    void drawTail() {
        // Draw each segment of the tail
    	for(Segment i : tail) {
    	fill(0, 200, 0);
        rect(i.X, i.Y, 10, 10);
    	}
    }

    /*
     * Tail Management methods
     * 
     * These methods make sure the tail is the correct length.
     */

    void manageTail() {
        // After drawing the tail, add a new segment at the "start" of the tail and
        // remove the one at the "end"
        // This produces the illusion of the snake tail moving.
    	checkTailCollision();
    	drawTail();
    	tail.add(0, new Segment(head.X, head.Y));
    	tail.remove(tail.size()-1);
    }

    void checkTailCollision() {
        // If the snake crosses its own tail, shrink the tail back to one segment
    	for(Segment i : tail) {
    		if(i.X == head.X && i.Y == head.Y) {
    			tail = new ArrayList<Segment>();
    	}
    	}
    	}
   

    /*
     * Control methods
     * 
     * These methods are used to change what is happening to the snake
     */

    @Override
    public void keyPressed() { 
        // Set the direction of the snake according to the arrow keys pressed
        if(keyCode == UP && direction != DOWN) {
        	direction = UP;
        }else if(keyCode == DOWN && direction != UP) {
        	direction = DOWN;
        }else if(keyCode == LEFT && direction != LEFT) {
        	direction = RIGHT;
        }else if(keyCode == RIGHT && direction != RIGHT) {
        	direction = LEFT;
        }
    }

    void move() {
        // Change the location of the Snake head based on the direction it is moving.
        if (direction == UP) {
        	head.Y -= speed;
        } else if (direction == DOWN) {
        	head.Y += speed;
        } else if (direction == LEFT) {
            head.X += speed;
        } else if (direction == RIGHT) {
            head.X -= speed;
        }
        checkBoundaries();
    }

    void checkBoundaries() {
        // If the snake leaves the frame, make it reappear on the other side
        if(head.Y > 500) {
        	head.Y = 1;
        }else if(head.Y < 0) {
        	head.Y = 499;
        }else if(head.X > 500) {
        	head.X = 1;
        }else if(head.X < 0) {
        	head.X = 499;
        }
    }

    void eat() {
        // When the snake eats the food, its tail should grow and more
        // food appear
    	double bean = Math.sqrt(Math.pow(head.X - foodX, 2) + Math.pow(head.Y - foodY, 2));
    	if(bean < r){
        	System.out.println("ate");
        	System.out.println(tail.size());
        	foodGobbled ++;
        	dropFood();
        	tail.add(new Segment(head.X, head.Y));
    	}
    }

    static public void main(String[] passedArgs) {
        PApplet.main(LeagueSnake.class.getName());
    }
}
