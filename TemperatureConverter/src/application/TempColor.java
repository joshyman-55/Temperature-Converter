package application;

import javafx.scene.paint.Color;

public class TempColor {
	
	@SuppressWarnings("exports")
	public static Color getColor(String classification) {
		
		switch (classification) {
		
		case "Frigid": 
			return Color.PURPLE;
		case "Cold": 
			return Color.BLUE;
		case "Chilly": 
			return Color.LIME;
		case "Ideal": 
			return Color.YELLOW;
		case "Warm":
			return Color.ORANGE;
		case "Hot":
			return Color.RED;
		case "Meltdown":
			return Color.HOTPINK;
		case "Furnace":
			return Color.MAROON;
			
		}
		return null;
	}
}
