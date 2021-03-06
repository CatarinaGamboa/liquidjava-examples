import repair.regen.specification.Refinement;
import repair.regen.specification.StateRefinement;
import repair.regen.specification.StateSet;

public class TrafficLight {

	private int r; 	
	private int g; 	
	private int b;
	
	
	public TrafficLight() {
		r = 76; g = 187; b = 23;
	}

	public void transitionToGreen() {
		r = 76; g = 187; b = 23;
	}

	public void transitionToAmber() {
		r = 255; g = 120; b = 0;
	}
	
	public void transitionToRed() {
		r = 230; g = 0; b = -1; 
	}

}
