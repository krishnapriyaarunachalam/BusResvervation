package busrev;

import java.text.SimpleDateFormat;
import java.util.*;

public class Booking {
    private String passengerName;
    private int busno;
    private int seatNo;
    private Date date;

    public Booking(ArrayList<Booking> bookings, ArrayList<Bus> buses) {
        Scanner scan = new Scanner(System.in);
        System.out.print("Enter Passenger Name: ");
        passengerName = scan.nextLine();

        System.out.print("Enter Bus Number: ");
        busno = scan.nextInt();

        System.out.print("Enter Seat No: ");
        seatNo = scan.nextInt();

        System.out.print("Enter travel date (dd-MM-yyyy): ");
        String inputDate = scan.next();

        try {
            SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
            date = sdf.parse(inputDate);
        } catch (Exception e) {
            System.out.println("Invalid date format. Setting today's date.");
            date = new Date();
        }
    }

    public boolean isAvailable(ArrayList<Booking> bookings, ArrayList<Bus> buses) {
        int capacity = 0;

        for (Bus b : buses) {
            if (b.getBusNo() == busno) {
                capacity = b.getCapacity();
                break;
            }
        }

        int bookedCount = 0;
        for (Booking b : bookings) {
            if (b.getBusNo() == busno && b.getDate().equals(date)) {
                bookedCount++;
            }
        }

        return bookedCount < capacity;
    }

    // Getters for DAO
    public int getBusNo() {
        return busno;
    }

    public Date getDate() {
        return date;
    }

    public String getPassengerName() {
        return passengerName;
    }

    public int getSeatNo() {
        return seatNo;
    }
}
