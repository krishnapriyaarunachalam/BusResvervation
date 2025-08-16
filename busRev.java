package busrev;

import java.util.*;

public class busRev {

	public static void main(String[] args)  {

		BusBAO busdao = new BusBAO();

		// Add these two lines
		ArrayList<Bus> buses = new ArrayList<>();
		ArrayList<Booking> bookings = new ArrayList<>();

		// Sample buses
		buses.add(new Bus(1, true, 2, "Chennai", "Coimbatore"));
		buses.add(new Bus(2, false, 3, "Madurai", "Trichy"));
		try {
			busdao.displayBusInfo();

			int userOpt = 1;
			Scanner scanner = new Scanner(System.in);

			while(userOpt == 1) {
				System.out.println("Enter 1 to Book and 2 to Exit");
				userOpt = scanner.nextInt();

				if(userOpt == 1) {
					Booking booking = new Booking(bookings, buses);
					if(booking.isAvailable(bookings, buses)) {
						BookingDAO bookingdao = new BookingDAO();
						bookingdao.addBooking(booking);
						bookings.add(booking); // 💡 Don't forget this!
						System.out.println("Booking successful for " + booking.getPassengerName());
						Thread.sleep(4000);
		            } else {
		                System.out.println("Sorry, no seats available for this bus/date.");
		                Thread.sleep(4000);
		            }

		            System.out.print("Do you want to book another ticket? (1 for Yes, other to Exit): ");
		            userOpt = scanner.nextInt();
		        }

		        System.out.println("Thank you for using our bus reservation system.");
		    }
			scanner.close();
		} catch(Exception e) {
			System.out.println(e);
		}
	}
}
