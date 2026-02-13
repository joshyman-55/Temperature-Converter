package application;

public class TempConverter {
	
	public static int celsiusToFahrenheit (int celsius) {
		return (int) Math.round((celsius * 9.0/5.0) + 32);
	}
	
	public static int fahrenheitToCelsius (int fahrenheit) {
		return (int) Math.round((fahrenheit - 32) * 5.0/9.0);
	}
	
	public static int celsiusToKelvin (int celsius) {
		return (int) Math.round(celsius + 273.15);
	}
	
	public static int kelvinToCelsius (int kelvin) {
		return (int) Math.round(kelvin - 273.15);
	}
	
	public static int fahrenheitToKelvin(int fahrenheit) {
	int c = fahrenheitToCelsius(fahrenheit);
		return Math.round(celsiusToKelvin(c));
	}
	
	public static int kelvinToFahrenheit(int kelvin) {
		int c = kelvinToCelsius(kelvin);
			return Math.round(celsiusToFahrenheit(c));
		}

}
