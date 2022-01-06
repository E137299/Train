import javax.swing.*;
import java.awt.*;  

public class PassengerCar extends RailCar{
   private int trainX;           // Top-Left X-Coordinate of the train
   private int trainY;           // Top-Left Y-Coordinate of the train
   private int carPos;           // rail car position in the train starting at zero
	private Color carColor;       // Color of this rail car
   private int carX;             // Top-Left X-Coordinate of this rail car
   private int carY;             // Top-Left Y-Coordinate of this rail car


	public PassengerCar(int tX, int tY, Color cC, int cP){
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
      drawRoof(g);
	}

	private void drawWindows(Graphics g){
	    g.setColor(Color.white);
	    g.fillRect(carX+10,carY+30,25,30);
       g.fillRect(carX+45,carY+30,25,30);
	    g.fillRect(carX+80,carY+30,25,30);
       g.fillRect(carX+115,carY+30,25,30);
	}
   
   private void drawRoof(Graphics g){
      Polygon roof = new Polygon();
      roof.addPoint(carX-15,carY+20);
      roof.addPoint(carX,carY);
      roof.addPoint(carX+150,carY);
      roof.addPoint(carX+165,carY+20);
      g.setColor(carColor);
      g.fillPolygon(roof);
   }   
}
