// AUTHOR: 			Forrest Collins
// LAST UPDATED: 	12/2/15
// PURPOSE: 		This class contains Triangle class member variables
// 					which are sideOne, sideTwo, and sideThree as well as three boolean
// 					methods to determine if a Triangle is scalene, isosceles,
// 					or equilateral.

public class Triangle {
	
	// sideOne, sideTwo, & sideThree are variables that can be used in the UseTriangle class.
	// also the boolean methods below can also be used in the UseTriangle class.
	
	public static double sideOne;
	public static double sideTwo;
	public static double sideThree;
		
	//-----------------------------------
	// MARK: - isScalene Boolean Function
	//-----------------------------------
	public static boolean isScalene() {
			
		if ((sideOne != sideTwo) && 
			(sideOne != sideThree) && 
			(sideTwo != sideThree)) {
				
			return true;
		} else {
			return false;
		}
	}
		
	//-------------------------------------
	// MARK: - isIsosceles Boolean Function
	//-------------------------------------
	public static boolean isIsosceles() {
			
		if (((sideOne == sideTwo) && (sideOne != sideThree)) ||
			((sideTwo == sideThree) && (sideTwo != sideOne)) ||
			((sideOne == sideThree) && (sideOne != sideTwo))) {
				
			return true;
		} else {
			return false;
		}	
	}
		
	//---------------------------------------
	// MARK: - isEquilateral Boolean Function
	//---------------------------------------
	public static boolean isEquilateral() {
			
		if ((sideOne == sideTwo) && (sideTwo == sideThree)){
				
			return true;
		} else {
			return false;
		}
	}
	
}
