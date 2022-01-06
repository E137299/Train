import javax.swing.*;
import java.awt.*;  

public class Caboose extends RailCar{
   	private int trainX;           // Top-Left X-Coordinate of the train
   	private int trainY;           // Top-Left Y-Coordinate of the train
   	private int carPos;           // rail car position in the train starting at zero
	private Color carColor;       // Color of this rail car
   	private int carX;             // Top-Left X-Coordinate of this rail car
   	private int carY;             // Top-Left Y-Coordinate of this rail car

	public Caboose(int tX, int tY, Color cC, int cP){
		super(tX,tY,cC,cP);
		trainX = tX;
		trainY = tY;
		carPos = cP;
		carX = trainX + 175 * carPos;
		carY = trainY;
		carColor = cC;
	}
   
   public int getPos(){
      	return carPos;
   }
   
   public void setPos (int cP){
		super.setPos(cP);
		carPos = cP;
		carX = trainX + carPos * 175;
   }

	public void drawCar(Graphics g){
		super.drawCar(g);
		drawWindows(g);
		drawCupola(g);
	}

	private void drawWindows(Graphics g){
	    g.setColor(Color.white);
	    g.fillRect(carX+30,carY+30,30,30);
	    g.fillRect(carX+90,carY+30,30,30);
	}

	private void drawCupola(Graphics g){
	    g.setColor(Color.red);
	    g.fillRect(carX+30,carY-30,90,30);
	    g.setColor(Color.black);
	    g.fillRect(carX+25,carY-30,100,5);
	}
}
