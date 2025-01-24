package com.inheritance.inout;
import com.exception.InvalidException;
import com.utilshub.UtilsScan;
import com.inheritance.task.*;

public class InheritanceRunner
{
	private void exercise2() throws InvalidException
	{
		System.out.println("\nEXERCISE 2 : Calling All Setter and Getter Methods of a Subclass\n");
		Swift swiftCar = new Swift();
		
		System.out.print("Seats: ");
		swiftCar.setSeats(UtilsScan.getInteger());
		System.out.print("Airbags: ");
		swiftCar.setAirbags(UtilsScan.getInteger());
		System.out.print("Model: ");
		swiftCar.setModel(UtilsScan.getString());
		System.out.print("Color: ");
		swiftCar.setColor(UtilsScan.getString());

		System.out.println("\nSwift Details:");
		System.out.println("Seats: " + swiftCar.getSeats());
		System.out.println("Airbags: " + swiftCar.getAirbags());
		System.out.println("Model: " + swiftCar.getModel());
		System.out.println("Color: " + swiftCar.getColor());
		
	}
	
	private void exercise3() throws InvalidException
	{
		System.out.println("\nEXERCISE 3 : Calling All Setter and Getter Methods of Subclass & Superclass\n");
		SCross scrossCar = new SCross();
		
		System.out.print("Year of Make: ");
		scrossCar.setYearOfMake(UtilsScan.getInteger());
		System.out.print("Engine Number: ");
		scrossCar.setEngineNumber(UtilsScan.getString());
		System.out.print("Type: ");
		scrossCar.setType(UtilsScan.getString());
		System.out.print("Seats: ");
		scrossCar.setSeats(UtilsScan.getInteger());
		System.out.print("Airbags: ");
		scrossCar.setAirbags(UtilsScan.getInteger());
		System.out.print("Model: ");
		scrossCar.setModel(UtilsScan.getString());
		System.out.print("Color: ");
		scrossCar.setColor(UtilsScan.getString());

		System.out.println("\nSCross Details:");
		System.out.println("Year of Make: " + scrossCar.getYearOfMake());
		System.out.println("Engine Number: " + scrossCar.getEngineNumber());
		System.out.println("Type: " + scrossCar.getType());
		System.out.println("Seats: " + scrossCar.getSeats());
		System.out.println("Airbags: " + scrossCar.getAirbags());
		System.out.println("Model: " + scrossCar.getModel());
		System.out.println("Color: " + scrossCar.getColor());
	}
	
	private void startCar(Car car)
	{
		System.out.println("Starting a car...");
	}
	
	private void exercise4()
	{
		System.out.println("\nEXERCISE 4 : Passing Subclass Objects to a Method with Superclass Argument\n");
		Swift swiftCar = new Swift();
		SCross scrossCar = new SCross();
		XUV xuvCar = new XUV();
		
		startCar(swiftCar);
        startCar(scrossCar);
        startCar(xuvCar);
	}
	
	private void identifyCar(Car car) 
	{
        if (car instanceof Swift) 
		{
            System.out.println("Hatch");
        } 
		else if (car instanceof SCross) 
		{
            System.out.println("Sedan");
        } 
		else if (car instanceof XUV) 
		{
            System.out.println("SUV");
        } 
		else 
		{
            System.out.println("Unknown Car Type");
        }
    }
	
	private void exercise5()
	{
		System.out.println("\nEXERCISE 5 : Identify Subclass Type from a Superclass Reference\n");
		Swift swiftCar = new Swift();
		SCross scrossCar = new SCross();
		XUV xuvCar = new XUV();
		
		identifyCar(swiftCar);
        identifyCar(scrossCar);
        identifyCar(xuvCar);
	}
	
	private void operateSwift(Swift swift)
	{
		System.out.println("Operating a Swift car...");
	}
	
	private void exercise6()
	{
		System.out.println("\nEXERCISE 6 : Create Method with Swift Argument and Explore Method Calls\n");
		Swift swiftCar = new Swift();
//		SCross scrossCar = new SCross();
//		XUV xuvCar = new XUV();
//		Car car = new Swift();
		
		operateSwift(swiftCar);
		//operateSwift(car);         //error: incompatible types: Car cannot be converted to Swift
        //operateSwift(scrossCar);   //error: incompatible types: SCross cannot be converted to Swift
        //operateSwift(xuvCar);      //error: incompatible types: XUV cannot be converted to Swift
	}
	
	private void exercise7()
	{
		System.out.println("\nEXERCISE 7 : Method Overriding\n");
		Car car = new Car();
		Swift swiftCar = new Swift();
		SCross scrossCar = new SCross();
		XUV xuvCar = new XUV();
		
		car.maintenance();
		swiftCar.maintenance();
		scrossCar.maintenance();
		xuvCar.maintenance();
	}
	
	private void exercise8()
	{
		System.out.println("\nEXERCISE 8 :  instance of XUV using the default & Overloaded constructor\n");
//		XUV xuvCar1 = new XUV();
		//XUV xuvCar2 = new XUV("Overloaded"); //: error: constructor XUV in class XUV cannot be applied to given types
	}
	
	private void exercise9()
	{
		System.out.println("\nEXERCISE 9 :  Subclass inherits the methods of Abstract class\n");
		//BirdAbstract bird = new BirdAbstract(); //error: BirdAbstract is abstract; cannot be instantiated
		BirdAbstract bird = new ParrotMod();
		bird.fly();  
        bird.speak();
		ParrotMod parrot = new ParrotMod();
        parrot.fly();  
        parrot.speak();
	}
	
	private void exercise10()
	{
		System.out.println("\nEXERCISE 10 :  Concrete Method in Subclass for Abstract method in Superclass\n");
		Duck duck = new Duck();
		duck.fly();  
        duck.speak();
	}
	
public static void main (String[] abc) throws InvalidException
    {
		boolean isContinue = true;
		String exercise;
		InheritanceRunner inheritRunner = new InheritanceRunner();
		System.out.print("\nTASK : INHERITANCE\n\n2. Calling All Setter and Getter Methods of a Subclass\n3. Calling All Setter and Getter Methods of Subclass & Superclass\n4. Passing Subclass Objects to a Method with Superclass Argument\n5. Identify Subclass Type from a Superclass Reference\n6. Create Method with Swift Argument and Explore Method Calls\n7. Method Overriding\n8. instance of XUV using the default & Overloaded constructor\n9. Subclass inherits the methods of Abstract class\n10. Concrete Method in Subclass for Abstract method in Superclass\nEnter 0 to Exit\n");
		
		while(isContinue)
		{
			try
			{
				System.out.print("\nEnter the Excercise to carry out : ");
				exercise = UtilsScan.getString();
				switch (exercise)
				{		
				case "2":
					inheritRunner.exercise2();
					break;
				
				case "3":
					inheritRunner.exercise3();
					break;
					
				case "4":
					inheritRunner.exercise4();
					break;
				
				case "5":
					inheritRunner.exercise5();
					break;
					
				case "6":
					inheritRunner.exercise6();
					break;
					
				case "7":
					inheritRunner.exercise7();
					break;
					
				case "8":
					inheritRunner.exercise8();
					break;
					
				case "9":
					inheritRunner.exercise9();
					break;
					
				case "10":
					inheritRunner.exercise10();
					break;
					
				case "0":
					isContinue = false;
					break;
					
				default:
					System.out.println("Invalid Input");
					break;
				}
			}

			catch (Exception e) 
			{
				e.printStackTrace();
			}
		}
	}
}