public class Booking {
    int rowNumber;
    int seatNumber;
    int cost;
    User user;
    Event event;


    public Booking(User user, Event event) {
        this.user = user;
        this.event = event;
    }

    public User getUser() {
        return user;
    }

    public void setRowNumber(int rowNumber) {
        this.rowNumber = rowNumber;
    }

    public void setSeatNumber(int seatNumber) {
        this.seatNumber = seatNumber;
    }

    public int getCost() {
        return cost += event.getEventPrice();
    }

    public boolean reserveSeat(int selectedRow, int selectedSeat) {
        if (event.getAuditorium().getRows().get(selectedRow).getSeats().get(selectedSeat).getReservationStatus()) {
            return false;
        } else {
            event.getAuditorium().getRows().get(selectedRow).getSeats().get(selectedSeat).reserve();
            setRowNumber(selectedRow);
            setSeatNumber(selectedSeat);
            return true;
        }
    }

    public void dereserveSeat() {
        event.getAuditorium().getRows().get(rowNumber).getSeats().get(seatNumber).dereserve();
    }
}
