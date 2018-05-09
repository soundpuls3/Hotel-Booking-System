
import java.util.Scanner;

public class HotelConfigure {
	
	//Create a Scanner
	private static Scanner keyboard;

	public static void main(String[] args) {
		
		//Scanner created defined to take user input
		keyboard = new Scanner(System.in);
		
		//Create a new Hotel h to store incoming data of the hotel's database.
		Hotel h = new Hotel();
		
		//the input detection for the number of rooms and beds.
		int tempInt;

		//User Input Required
		//Input the name of the Hotel, which will be stored in the Hotel class
		System.out.println("Insert Hotel Name:");
		
		h.setName(keyboard.nextLine());
		
		//User Input Required
		//Input the size of the Hotel (also known as the number of rooms in said Hotel)
		//which will be stored in the Hotel class.
		System.out.println("Insert Number of Rooms:");
		
		tempInt = keyboard.nextInt();
		
		//Invalid Input Detection
		//Tells the user to input again
		while(tempInt <= 0){
			
		System.out.println("============================");
			
		System.out.println("Invalid Input!");
		
		System.out.println("Insert Number of Rooms:");
		
		tempInt = keyboard.nextInt();
		
		}
		
		//Set the Size of the Hotel (number of rooms)
		h.setHotelSize(tempInt);
		
		
		//LOOP
		//User Input Required
		//Create new Rooms depending on the Hotel size, and creating New Beds inside said Room
		for(int i = 0; i < h.getHotelSize(); i++) {
			//Create a New Room
			h.addRoom();
			
			System.out.println("============================");
			
			//Notification to the user that it has been successfully created
			System.out.println("Room added!");
			
			//User Input Required
			//Input the size of the Room (also known as the number of beds in said Room)
			//which will be stored in the Room class
			
			System.out.println("Insert Number of Beds in Room " + (i+1));
			
			tempInt = keyboard.nextInt();
			
			//Invalid Input Detection
			//Tells the user to input again
			while(tempInt <= 0){
				
			System.out.println("============================");
				
			System.out.println("Invalid Input!");
			
			System.out.println("Insert Number of Beds in Room " + (i+1));
			
			tempInt = keyboard.nextInt();
			
			}
			//Set the Number of Beds (size of the Room)
			h.getRoom(i).setNumberOfBeds(tempInt);
			
			//Skip
			keyboard.nextLine();
			
			
			//LOOP inside LOOP
			//User Input Required
			//Create new Beds depending on the Room size
			
		System.out.println("(Common Bed types: Single, Double, King, Queen)");
		
		for(int j = 0 ; j < h.getRoom(i).getNumberOfBeds(); j++) {
			
			//User Input Required
			//Input the type of the Bed (Possible types: Single, Double, King, Queen)
			
			System.out.println("Insert The Type of Bed for Bed " + (j+1));
			
			//User Input stored inside a String type for easier readability of the code
			String type = keyboard.nextLine();
			

			//Create a bed of the type "type" (Possible types: Single, Double, King, Queen)
			//Not Case Sensitive
			
			
			h.getRoom(i).addBed(type);
			
			//Increase the maximum amount of customers the Hotel Can Take 
			//(Include Invalid Room's Valid Beds)
			h.addMaxOccupancy(i, j, type);
			
			}
		
		//Check/Modify the room's status (vacant or not vacant)
		System.out.println("============================");
		
		System.out.println("Is the Room Vacant? (Y/N)");
		
		String vacancy = keyboard.nextLine();
		
			//Invalid Input Detection
			//Tells the user to input again
		while(!vacancy.toLowerCase().matches("yes|no|y|n")){
			
			System.out.println("============================");
			
			System.out.println("Invalid Input!");
			
			System.out.println("Is the Room Vacant? (Y/N)");
			
			vacancy = keyboard.nextLine().toLowerCase();
		}
		
		h.getRoom(i).setVacant(vacancy);

		}
		
		//Access the HotelReport class. It outputs a table showing Hotel h's maximum occupancy,
		//all the Rooms in the Hotel, the type of the Beds in said room, and if it is available to
		//take in any new customers.
		
		HotelReport.report(h);

	}

}
