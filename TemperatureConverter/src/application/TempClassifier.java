package application;

public class TempClassifier {
	
	public static String classify (int tempFahrenheit) {
		
		if (tempFahrenheit  <= 32) {
			return "Frigid"; // (tempCelsius <= 0)
		} else if (tempFahrenheit > 32 && tempFahrenheit < 50) {
			return "Cold"; // (tempCelsius > 0 && tempCelsius < 10)
		} else if (tempFahrenheit >= 50 && tempFahrenheit < 60) {
			return "Chilly"; // (tempCelsius >= 10 && tempCelsius < 16)
		} else if (tempFahrenheit >= 60 && tempFahrenheit <= 77) {
			return "Ideal"; // (tempCelsius >= 16 && tempCelsius <= 25)
		} else if (tempFahrenheit > 77 && tempFahrenheit < 95) {
			return "Warm"; // (tempCelsius > 25 && tempCelsius <= 35)
		} else if (tempFahrenheit >= 95 && tempFahrenheit < 122) {
			return "Hot"; // (tempCelsius > 35 && tempCelsius < 50)
		} else if (tempFahrenheit >= 122 && tempFahrenheit < 212) {
			return "Meltdown"; // (tempCelsius <= 50 && tempFahrenheit < 100)
		} else // (tempFahrenheit >= 212)
			return "Furnace"; //(tempCelsius >= 100)
	}
}
