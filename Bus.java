package busrev;

public class Bus {
    private int busNo;
    private boolean ac;
    private int capacity;
    private String fromPlace;
    private String toPlace;

    public Bus(int no, boolean ac, int cap, String from, String to) {
        this.busNo = no;
        this.ac = ac;
        this.capacity = cap;
        this.fromPlace = from;
        this.toPlace = to;
    }

    public int getBusNo() {
        return busNo;
    }

    public int getCapacity() {
        return capacity;
    }

    public void displayBusInfo() {
        System.out.println("Bus No: " + busNo + ", AC: " + ac + ", Capacity: " + capacity +
                           ", From: " + fromPlace + ", To: " + toPlace);
    }
}
