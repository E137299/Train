import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;


public class Train extends JPanel{
	//    ATTRIBUTES
	private int trainX;                    // Top-Left X-Coordinate of the train
   	private int trainY;                    // Top-Left Y-Coordinate of the train
   	private int carCount;                  // Number of rail cars in the train.
   	private ArrayList<RailCar> railCars;   // Array that stores of the <RailCar> objects

	public Train(int tX, int tY){
		setLayout(null);
		trainX = tX;
      	trainY = tY;
	}
	// paintCommponent is not explicitly called. It is executed whenever the JPanel is called.
	// Graphics g object is implicitly passed to function.
	public void paintComponent(Graphics g){
		super.paintComponent(g); //satisfies the parent class' requirements.
		setBackground(Color.WHITE);
		railCars = new ArrayList<RailCar>();
      	carCount = 0;
		addCar("Locomotive",Color.blue);
      	addCar("PassengerCar",Color.gray);
      	addCar("FreightCar",Color.green);
      	addCar(3,"PassengerCar",Color.gray);
      	addCar("FreightCar",Color.green);
      	addCar("Caboose",Color.red);
		showCars(g);
	}

   // This method adds a new rail car at the end of the train  
   public void addCar(String carType, Color carColor)
   {
      switch (carType)
      {
         case "Locomotive"    :  railCars.add(new Locomotive(trainX,trainY,carColor,carCount));
                                 break;
         case "FreightCar"    :  railCars.add(new FreightCar(trainX,trainY,carColor,carCount));
                                 break;
         case "PassengerCar"  :  railCars.add(new PassengerCar(trainX,trainY,carColor,carCount));
                                 break;
         case "Caboose"       :  railCars.add(new Caboose(trainX,trainY,carColor,carCount));
                                 break;
      } 
      carCount++;
   }
   
   
   // The overloaded addCar method inserts a new rail car at a specified location 
   public void addCar(int carPos, String carType, Color carColor){
      switch (carType){
         case "Locomotive"    :  railCars.add(carPos,new Locomotive(trainX,trainY,carColor,carCount));
                                 break;
         case "FreightCar"    :  railCars.add(carPos,new FreightCar(trainX,trainY,carColor,carCount));
                                 break;
         case "PassengerCar"  :  railCars.add(carPos,new PassengerCar(trainX,trainY,carColor,carCount));
                                 break;
         case "Caboose"       :  railCars.add(carPos,new Caboose(trainX,trainY,carColor,carCount));
                                 break;
      } 
      carCount++;
           
      for (int carIndex = carPos; carIndex < railCars.size(); carIndex++)
         railCars.get(carIndex).setPos(carIndex); 
   }

   // This method uses polymorphism to display each rail car properly 
   public void showCars(Graphics g){
      for (RailCar railCar : railCars)
         railCar.drawCar(g);
   }
}