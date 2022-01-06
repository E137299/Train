import javax.swing.*;
import java.awt.*; 

public class FreightCar extends RailCar{
   private int trainX;           // Top-Left X-Coordinate of the train
   private int trainY;           // Top-Left Y-Coordinate of the train
   private int carPos;           // rail car position in the train starting at zero
   private Color carColor;       // Color of this rail car
   private int carX;             // Top-Left X-Coordinate of this rail car
   private int carY;             // Top-Left Y-Coordinate of this rail car


   public FreightCar(int tX, int tY, Color cC, int cP){
      super(tX,tY,cC,cP);
      trainX = tX;
      trainY = tY;
      carPos = cP;
      carX = trainX + 175 * carPos;
      carY = trainY;	carColor = cC;
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
	drawFreightDoors(g);
   }
   
   private void drawFreightDoors(Graphics g){
	g.setColor(Color.black);
	g.drawRect(carX+30,carY+10,90,60);
        g.drawLine(carX+75,carY+10,carX+75,carY+70);
        g.drawLine(carX+30,carY+10,carX+75,carY+70);
        g.drawLine(carX+30,carY+70,carX+75,carY+10);
        g.drawLine(carX+75,carY+10,carX+120,carY+70);
        g.drawLine(carX+75,carY+70,carX+120,carY+10);
        g.fillRect(carX+66,carY+35,5,15);
        g.fillRect(carX+80,carY+35,5,15);
   }
 }