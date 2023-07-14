public class Event implements IEvent {
    private String eventName;
    private String eventDate;
    private String eventDetails;
    private int eventPrice;
    private Auditorium auditorium;

    public Event(String eventName, String eventDate, String eventDetails, int eventPrice, Auditorium auditorium) {
        this.eventName = eventName;
        this.eventDate = eventDate;
        this.eventDetails = eventDetails;
        this.eventPrice = eventPrice;
        this.auditorium = auditorium;
    }

    public int getFreeSeatsCount() {
        int freeSeats = 0;
        for (int i = 0; i < auditorium.getRowCount(); i++) {
            for (int j = 0; j < auditorium.getRows().get(i).getSeatCount(); j++) {
                if (!auditorium.getRows().get(i).getSeats().get(j).getReservationStatus()) {
                    freeSeats++;
                }
            }
        }
        return freeSeats;
    }

    public int getBookedSeatsCount() {
        int bookedSeats = 0;
        for (int i = 0; i < auditorium.getRowCount(); i++) {
            for (int j = 0; j < auditorium.getRows().get(i).getSeatCount(); j++) {
                if (auditorium.getRows().get(i).getSeats().get(j).getReservationStatus()) {
                    bookedSeats++;
                }
            }
        }
        return bookedSeats;
    }

    public String getEventDetails() {
        return eventDetails;
    }

    public void setEventDetails(String eventDetails) {
        this.eventDetails = eventDetails;
    }

    public int getEventPrice() {
        return eventPrice;
    }

    public String getEventName() {
        return eventName;
    }

    public String getEventDate() {
        return eventDate;
    }

    public Auditorium getAuditorium() {
        return auditorium;
    }
}
