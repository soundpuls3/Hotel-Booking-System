import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class HotelTest {

	public static void main(String[] args) {
		
		Hotel h = new Hotel();

	//Create a list of all available types of bed
		List<String> typearr = new ArrayList<String>();
		typearr.add("Single");
		typearr.add("Double");
		typearr.add("King");
		typearr.add("Queen");
	
	//A string named type that stores the random bed type assigned
	//from shuffling the list
		String type = null;
		
	// Randomly Generate a Hotel
	// Set the size of Hotel and Room 
		h.setName("Random Hotel");
		int sizeOfHotel = 50;
		int sizeOfRoom = 3;
		h.setHotelSize(sizeOfHotel);
		
		
		for (int i = 0; i < sizeOfHotel; i++) {
			
			//add a Room
			h.addRoom();
			
			//Set the room to have a number of beds
			h.getRoom(i).setNumberOfBeds(sizeOfRoom);
			
			for (int j = 0; j < sizeOfRoom; j++) {
				
				//Shuffle the array and get a random bed type
				Collections.shuffle(typearr);
				
				type = typearr.get(0);
				
				//Add the Bed Type and Increase max. Occupancy
				h.getRoom(i).addBed(type);
				h.addMaxOccupancy(i, j, type);
				
			}
			
			//Randomly set the room to vacant/occupied
			h.getRoom(i).setVacant(Math.random()<0.5? "yes" : "no");

		}
		
		//Input each room one by one (Hotel size of 5)
		/*h.setName("Test Hotel");
		
		//Set Hotel Size 
		h.setHotelSize(5);
		
		//Input Procedure:
		//Add a Room
		//Set the number of Beds in the Room
		//Add Beds with their bedType
		//Increase maximum occupancy
		//Set the room's vacancy
		
		h.addRoom();
		h.getRoom(0).setNumberOfBeds(2);
		h.getRoom(0).addBed("Single");
		h.getRoom(0).addBed("Double");
		h.addMaxOccupancy(0, 0, "Single");
		h.addMaxOccupancy(0, 1, "Double");
		h.getRoom(0).setVacant(true);
		
		
		h.addRoom();
		h.getRoom(1).setNumberOfBeds(3);
		h.getRoom(1).addBed("Single");
		h.getRoom(1).addBed("Double");
		h.getRoom(1).addBed("Single");
		h.addMaxOccupancy(1, 0, "Single");
		h.addMaxOccupancy(1, 1, "Double");
		h.addMaxOccupancy(1, 2, "Single");
		h.getRoom(1).setVacant(true);
		
		
		h.addRoom();
		h.getRoom(2).setNumberOfBeds(1);
		h.getRoom(2).addBed("Single");
		h.addMaxOccupancy(2, 0, "Single");
		h.getRoom(2).setVacant(true);
		
		
		h.addRoom();
		h.getRoom(3).setNumberOfBeds(2);
		h.getRoom(3).addBed("Double");
		h.getRoom(3).addBed("Single");
		h.addMaxOccupancy(3, 0, "Double");
		h.addMaxOccupancy(3, 1, "Single");
		h.getRoom(3).setVacant(false);
		
		
		h.addRoom();
		h.getRoom(4).setNumberOfBeds(3);
		h.getRoom(4).addBed("King");
		h.getRoom(4).addBed("Single");
		h.getRoom(4).addBed("Double");
		h.addMaxOccupancy(4, 0, "King");
		h.addMaxOccupancy(4, 1, "Single");
		h.addMaxOccupancy(4, 2, "Double");
		h.getRoom(4).setVacant(true);*/
	

	//Access the HotelReport class. It outputs a table showing Hotel h's maximum occupancy,
	//all the Rooms in the Hotel, the type of the Beds in said room, and if it is available to
	//take in any new customers.
		
		HotelReport.report(h);
	}

}
