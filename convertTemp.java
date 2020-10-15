import java.util.Scanner; //For user input
import java.math.*; //Used for rounding result

public class convertTemp {
	//Main function, we run the program here
	public static void main(String[] args)
	{
		//Take user input for a double value in unknown temp
		Scanner input = new Scanner(System.in);
		System.out.print("Input a temperature: ");
		double temp = input.nextDouble();
		//We ask the user what unit they are putting the temperature in
		System.out.print("Input units (K, F, C): ");
		String type = input.next();
		//We ask the user what unit they want to convert their temperature to
		System.out.print("Input units you want to convert to(K,F,C): ");
		String convertType = input.next();
		//We call our function to convert the temperature
		convertTemps(temp, type, convertType);
	}
	//This function converts Kelvin or Celsius to Fahrenheit
	public static double convertToF(double temp, String type)
	{
		//If we are given the temperature in Kelvin, we can just convert the temperature to Celsius 
		//and use recursion to convert to Fahrenheit
		if(type.toUpperCase().equals("K"))
		{
			temp = convertToC(temp, "K");
			return convertToF(temp, "C");
		}
		//If we are given Celsius, we do the conversion
		else if(type.toUpperCase().equals("C"))
		{
			return temp * 9/5 + 32; 
		}
		else
		{
			return temp;
		}
	}
	//Function to convert to Celsius
	public static double convertToC(double temp, String type)
	{
		//Conversion for Celsius to Fahrenheit
		if(type.toUpperCase().equals("F"))
		{
			return (temp-32) * 5/9;
		}
		//Conversion to Kelvin
		else if(type.toUpperCase().equals("K"))
		{
			return temp - 273.15;
		}
		else
		{
			return temp;
		}
	}
	//Function to convert to Kelvin
	public static double convertToK(double temp, String type) 
	{
		//We convert to Kelvin from Fahrenheit by first converting to Celsius
		//We then use recursion to convert to Kelvin
		if(type.toUpperCase().equals("F"))
		{
			temp = convertToC(temp, "F");
			return convertToK(temp, "C");
		}
		//Conversion to Kelvin from Celsius
		else if(type.toUpperCase().equals("C"))
		{
			return temp += 273.15;
		}
		else
		{
			return temp;
		}
	}
	//Main converter for program
	public static void convertTemps(double temp, String type, String convertType)
	{
		double result;
		//We just need the unit we want to convert to in order to use our functions above
		//Note: we round our results to two decimal places
		if(convertType.toUpperCase().equals("C"))
		{
			result = Math.round(convertToC(temp, type) * 100.0)/100.0;
			System.out.println("Your temperature is " + result + " degrees Celsius");
		}
		else if(convertType.toUpperCase().equals("K"))
		{
			result = Math.round(convertToK(temp, type) * 100.0)/100.0;
			System.out.println("Your temperature is " + result + " degrees Kelvin");
		}
		else if(convertType.toUpperCase().equals("F"))
		{
			result = Math.round(convertToF(temp, type) * 100.0)/100.0;
			System.out.println("Your temperature is " + result + " degrees Fahrenheit");
		}
		else
		{
			System.out.println("We seem to have run into an error, please try again.");
		}
	}
}