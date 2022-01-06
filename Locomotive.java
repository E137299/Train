import javax.swing.*;
import java.awt.*;  

public class Locomotive extends RailCar{
   private int trainX;           // Top-Left X-Coordinate of the train
   private int trainY;           // Top-Left Y-Coordinate of the train
   private int carPos;           // rail car position in the train starting at zero
	private Color carColor;       // Color of this rail car
   private int carX;             // Top-Left X-Coordinate of this rail car
   private int carY;             // Top-Left Y-Coordinate of this rail car
   

	public Locomotive(int tX, int tY, Color cC, int cP){
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
		drawScoop(g);
		drawFunnel(g);
	}

	private void drawScoop(Graphics g){
		Polygon scoop = new Polygon();
		scoop.addPoint(carX,carY+50);
		scoop.addPoint(carX,carY+100);
		scoop.addPoint(carX-50,carY+100);
	   g.setColor(Color.black);
	   g.fillPolygon(scoop);
	}

	private void drawFunnel(Graphics g){
		Polygon funnel = new Polygon();
		funnel.addPoint(carX+20,carY);
		funnel.addPoint(carX+20,carY-30);
		funnel.addPoint(carX,carY-50);
		funnel.addPoint(carX,carY-60);
		funnel.addPoint(carX+60,carY-60);
		funnel.addPoint(carX+60,carY-50);
		funnel.addPoint(carX+40,carY-30);
		funnel.addPoint(carX+40,carY);
	   g.setColor(Color.black);
	   g.fillPolygon(funnel);
	}
   
}
