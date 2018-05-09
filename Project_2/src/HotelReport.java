import java.util.Arrays;

public class HotelReport{

	public static void report(Hotel h) {
	
		//It outputs a table showing Hotel h's maximum occupancy,
		//all the Rooms in the Hotel, the type of the Beds in said room, and if it is available to
		//take in any new customers.
		
		System.out.println("===========================================================");
		
		//Hotel Report for "Hotel Name"
		System.out.println(" Hotel Report for " + h.getName());
		
		System.out.println("===========================================================");
		
		//Outputs Hotel h's MaxOccupancy
		System.out.println("   Maximum Occupancy: " + h.getMaxOccupancy());
		
		//Check if there are Vacancies in the Hotel
		h.setHasVacancies();
		
		//Outputs Yes if there's vacant rooms available
		//Outputs No otherwise
		System.out.println(" Vacancies Avaliable: " + (h.getHasVacancies()? "Yes" : "No"));
		
		System.out.println("===========================================================");
		
		//First line listing the type of each variable
		System.out.format(" Room |         Status | Size | Bed Type \n");
		
		System.out.println("===========================================================");
		
		//LOOP
		//Create an list of the amount of rooms inside Hotel h depending on the HotelSize
		for(int i=0; i < h.getHotelSize() ; i++) {
			
			String[] type = new String[h.getRoom(i).getNumberOfBeds()];
			
			
		//LOOP inside LOOP
		//Create an list of the amount of beds with it's respective type
		//inside Room "Index i" depending on the RoomSize
			for(int j=0; j < h.getRoom(i).getNumberOfBeds(); j++) {
				
				//Bed "Index j": "type of Bed "Index j" in Room "Index i""
				type[j] = h.getRoom(i).getBed(j).getBedType();
				
			}
			
			//Output Room i's status in one line
			System.out.format(	"  %03d |  %14s|%5d | %s\t\n", 
								
							//Room Number
							(i+1),
								
							//Status of the Room(Vacant or Not)
							(h.getRoom(i).isVacant() ? "Available " : "Not Available "),
								
							//Room Size
							h.getRoom(i).getRoomSize(),
								
							//Bed Type 
							//Regular expression used to remove the brackets and commas for better look
							Arrays.toString(type).replaceAll("(\\[|\\]|,)", "")
								
							);
		}
		
			System.out.println("===========================================================");
			

		
			
	}
	

}
