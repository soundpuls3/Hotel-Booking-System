import java.util.HashMap;
import java.util.Map;

public class Bed {
	
	//Private variables so that it can not be accessed accidentally.
	private String bedType;
	
	private int bedSize;
	
	private boolean vacant = true;

	private Map<String, Integer> bedSizeMap = new HashMap<String, Integer>();


	// Setter for defining the type of Beds available for input (Key -> Type , Value
	// -> Size)
	public void setBedSizeMap() {

		// Expandable for any future Type of Beds added
		
		// e.g. California King Size
		// bedSizeMap.put("calking",2)
		// for the above expression,
		// words that mean such type will have to be recognized and changed
		// so it can be detected by the HashMap
		
		bedSizeMap.put("king", 2);
		bedSizeMap.put("queen", 2);
		bedSizeMap.put("double", 2);
		bedSizeMap.put("single", 1);

	}

	// Setter of the Type of the Bed (Output to HotelReport)
	public void setBedType(String bedType) {

		setBedSizeMap();

		// Change Type to Lower Case for simple identification and higher usability
		bedType = bedType.toLowerCase();

		if (bedSizeMap.containsKey(bedType)) {

			setBedSize(bedType);

			this.bedType = String.format("%-7s", bedType.substring(0, 1).toUpperCase() + bedType.substring(1));

			// Otherwise, Output "Invalid"
		} else {
			
			setBedSize(bedType);

			this.bedType = "Invalid";

		}
	}

	// Setter for the Size of the Type of the Bed (Input from setBedType)
	public void setBedSize(String bedType) {
		
		// If Bed Type matches one of the Keys, Output Value pair (size)
		if (bedSizeMap.containsKey(bedType)) {
			
			bedSize = bedSizeMap.get(bedType);
			
		} else {
			//Else, the bed size is 0 and that bed is not vacant (not available)
			bedSize = 0;
			
			//Set vacant to false
			this.vacant = false;
			
		}
	}
	
	
	//Getter to return if it is Vacant or not (Output to Room)
	public boolean isVacant() { 
		
		return vacant;
		
	}
	
	// Getter of the Type of the Bed
	public String getBedType() {

		return bedType;

	}
	
	
	// Getter for the Size of the Type of the Bed (Output to Room)
	public int getBedSize() {
		return bedSize;
	}
	
}
