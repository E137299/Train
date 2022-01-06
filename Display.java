import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;


public class Display extends JPanel{
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
}