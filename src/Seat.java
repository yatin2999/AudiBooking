public class Seat {
    boolean isReserved;
    int seatNumber;

    public Seat(boolean isReserved, int seatNumber) {
        this.isReserved = isReserved;
        this.seatNumber = seatNumber;
    }

    public boolean getReservationStatus() {
        return isReserved;
    }

    public int getSeatNumber() {
        return this.seatNumber;
    }

    public void reserve() {
        isReserved = true;
    }

    public void dereserve() {
        isReserved = false;
    }
}
