import java.util.ArrayList;

public class Row {
    private int seatCount;
    private int rowNumber;
    private ArrayList<Seat> seats;

    public Row(int seatCount, int rowNumber) {
        this.rowNumber = rowNumber;
        this.seatCount = seatCount;
        seats = new ArrayList<>();
        createSeats(this.seatCount);
    }

    public void createSeats(int seatCount) {
        for (int i = 1; i <= seatCount; i++) {
            seats.add(new Seat(false, i));
        }
    }

    public int getRowNumber() {
        return rowNumber;
    }

    public int getSeatCount() {
        return seatCount;
    }

    public ArrayList<Seat> getSeats() {
        return seats;
    }
}
