import java.util.ArrayList;
import java.util.List;

public class Room {

	//Private variables so that it can not be accessed accidentally.
	private List<Bed> listOfBeds = new ArrayList<Bed>();

	private int numberOfBeds = 0;

	private int roomSize = 0;

	private boolean vacant = true;

	
	
	// Create a new Bed b and add it inside the ArrayList listOfBeds (Input from
	// HotelConfigure)
	public void addBed(String bedType) {

		Bed b = new Bed();

		listOfBeds.add(b);

		b.setBedType(bedType);

		addRoomSize(b.getBedSize());

	}

	
	// Setter for increasing the size of the Hotel (Input from HotelConfigure)
	public void addRoomSize(int bedSize) {

		this.roomSize = this.roomSize + bedSize;

	}

	
	//Setter for the number of beds in the room
	public void setNumberOfBeds(int numberOfBeds) {
		
		this.numberOfBeds = numberOfBeds;
	
	}
	
	
	//Setter of the room's vacancy status
	public void setVacant(String vacancy) { 
		//If the Room is Not Available (invalid beds, or room with size 0)
		//It is not available no matter the user input
		//Input ignored.
		
		//If the Room is Vacant (available beds)
		if(isVacant() != false){
			
		//If input is yes or equivalent, it is still vacant, status unchanged. (true)
		//If input is no or equivalent, it becomes occupied, status change to false;
			if(vacancy.toLowerCase().contains("n")){
				
			this.vacant = false;
			
				}
		}
	}
	
	
	// Getter of the room's vacancy status
	// Check if all Beds have a valid bed type, output true, else false
	public boolean isVacant() {
		
		for (int i = 0; i < numberOfBeds; i++) {
				
				if (getBed(i).isVacant() == false) {
					
					vacant = false;
				}

		}
		
		return vacant;
	}
	
	
	// Getter for the Bed(Index) of the ArrayList listOfBeds
	public Bed getBed(int index) {

		return listOfBeds.get(index);

	}
	
	
	// Getter for the size of the Room
	public int getRoomSize() {

		return roomSize;

	}
	
	
	// Getter for the number of Beds
	public int getNumberOfBeds() {
		
		return numberOfBeds;
		
	}
}
