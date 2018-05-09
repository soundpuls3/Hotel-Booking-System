import java.util.ArrayList;
import java.util.List;

public class Hotel {

	
	//Private variables so that it can not be accessed accidentally.
	private String name;
	
	private List<Room> listOfRooms = new ArrayList<Room>();
	
	private int hotelSize = 0;
	
	private int maxOccupancy = 0;
	
	private boolean hasVacancies = false;
	

	
	
	//Create a new Room r and add it inside the ArrayList listOfRooms (Input from HotelConfigure)
	public void addRoom() {
		
		Room r = new Room();

		listOfRooms.add(r);
		
	}
	
	
	//Setter to determine the maximum occupancy in the Hotel (Input from HotelConfigure)
	public void addMaxOccupancy(int i, int j, String type) {

		maxOccupancy = maxOccupancy + getRoom(i).getBed(j).getBedSize();

	}

	
	//Setter for the Hotel Name (Input from HotelConfigure)
	public void setName(String name) {

		this.name = name;

	}

	
	//Setter for the size of the Hotel (Input from HotelConfigure)
	public void setHotelSize(int hotelSize) {
		
		this.hotelSize = hotelSize;
		
	}
	
	
	//A function that checks all the Rooms in the Hotel, 
	//if anyone of the room is vacant, there is vacancy. (Sets Vacancy)
	public void setHasVacancies() {
	
		for (int i = 0; i < hotelSize; i++) {
			
			if (getRoom(i).isVacant() == true ) {

				this.hasVacancies = true;
			
			}
		}
	}

	
	//Getter for the size of the Hotel (Output to HotelConfigure)
	public String getName() {

		return name;

	}

	
	//Getter for the Hotel Name (Output to HotelReport)
	public int getHotelSize() {

		return hotelSize;

	}

	
	//Getter to determine if there is any vacancies in the Hotel (Output to HotelReport)
	public boolean getHasVacancies() {

		return hasVacancies;

	}
	
	
	//Getter for the Room(Index) of the ArrayList listOfRooms (Output to HotelReport, HotelConfigure)
	public Room getRoom(int index) { 

		return listOfRooms.get(index);

	}

	
	//Getter to determine the maximum occupancy in the Hotel (Output to HotelReport)
	public int getMaxOccupancy() {

		return maxOccupancy;

	}

}
