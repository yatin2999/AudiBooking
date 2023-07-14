public interface IEvent {
    public int getFreeSeatsCount();

    public int getBookedSeatsCount();

    public String getEventDetails();

    public void setEventDetails(String eventDetails);

    public int getEventPrice();
}
