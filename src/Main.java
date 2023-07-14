import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int firstOption;
        int secondOption;
        int thirdOption = 0;
        Auditorium auditorium = new Auditorium();
        auditorium.createRows(20, 12);
        ArrayList<Admin> admins = new ArrayList<>();
        ArrayList<User> users = new ArrayList<>();
        ArrayList<Event> events = new ArrayList<>();
        ArrayList<Booking> bookings = new ArrayList<>();
        Scanner sc = new Scanner(System.in);

        //Initial Admin and Events
        Admin admin = new Admin("Yatin", 20200020);
        admins.add(admin);
        events.add(new Event("N2O Event", "21.10.2022",
                "Comedy Show featuring Abhishek Upmanyu", 900, auditorium));

        do {
            System.out.println("------------------------------------");
            System.out.println("- Audi Booking System - ");
            System.out.println("------------------------------------\n");
            System.out.println("Please Enter 1 to Open Admin Mode");
            System.out.println("Please Enter 2 to Open User Mode");
            System.out.println("Please Enter 3 to Exit\n");

            System.out.print("Enter Option - ");
            firstOption = sc.nextInt();
            sc.nextLine();

            if (firstOption == 1) {
                do {
                    System.out.println("Admins can only be Registered through the Code");
                    System.out.println("Please Log in to an Existing Account\n");
                    System.out.print("Enter your BITS ID in numbers - ");
                    int adminId = sc.nextInt();
                    sc.nextLine();
                    int counter = 0;
                    for (; counter < admins.size(); counter++) {
                        if (admins.get(counter).getId() == adminId) {
                            System.out.println("Successfully logged in. Redirecting to Admin Mode...");
                            break;
                        }
                    }
                    if (counter == admins.size()) {
                        System.out.println("Invalid name or ID");
                        break;
                    }
                    System.out.println("------------------------------------");
                    System.out.println("- Admin Mode - ");
                    System.out.println("------------------------------------\n");
                    System.out.println("Please Enter 1 to Add Event");
                    System.out.println("Please Enter 2 to Edit Event details");
                    System.out.println("Please Enter 3 to Track Event Revenue");
                    System.out.println("Please Enter 4 to Go Back to Mode Selection\n");

                    System.out.print("Enter Option - ");
                    secondOption = sc.nextInt();
                    sc.nextLine();

                    if (secondOption == 1) {
                        System.out.println("ADD EVENT Selected");
                        System.out.println("-------------------------\n");
                        System.out.print("Enter the date of the Event [DD/MM/YYYY] - ");
                        String eventDate = sc.nextLine();
                        System.out.print("Enter name of the Event - ");
                        String eventName = sc.nextLine();
                        System.out.print("Enter details of the Event - ");
                        String eventDetails = sc.nextLine();
                        System.out.print("Enter price of each ticket - ");
                        int eventPrice = sc.nextInt();
                        sc.nextLine();
                        Auditorium auditorium1 = new Auditorium();
                        auditorium1.createRows(20, 12);
                        events.add(new Event(eventName, eventDate, eventDetails, eventPrice, auditorium1));
                    }

                    if (secondOption == 2) {
                        System.out.println("EDIT EVENT DETAILS Selected");
                        System.out.println("-------------------------\n");
                        System.out.println("Enter the Event ID - ");
                        int eventID = sc.nextInt();
                        sc.nextLine();
                        System.out.println("Details of Event - " + events.get(eventID - 1).getEventDetails());
                        System.out.println("Enter new details - ");
                        String eventDetails = sc.nextLine();
                        events.get(eventID - 1).setEventDetails(eventDetails);
                        System.out.println("Event details  successfully modified.");
                    }

                    if (secondOption == 3) {
                        System.out.println("TRACK EVENT REVENUE Selected");
                        System.out.println("-------------------------\n");
                        System.out.println("Enter the Event ID - ");
                        int eventID = sc.nextInt();
                        sc.nextLine();
                        int numOfTktSold = events.get(eventID - 1).getBookedSeatsCount();
                        System.out.println("Total seats available in the Event - " +
                                (numOfTktSold + events.get(eventID - 1).getFreeSeatsCount()));
                        System.out.println("Tickets sold - " + numOfTktSold);
                        System.out.println("Current revenue from this Event - " +
                                (numOfTktSold * events.get(eventID - 1).getEventPrice()));
                    }
                } while (secondOption != 4);
            }

            if (firstOption == 2) {
                do {
                    System.out.println("Please Enter 1 to Register a New User Account");
                    System.out.println("Please Enter 2 to Log in to an Existing Account\n");

                    System.out.print("Enter Option - ");
                    secondOption = sc.nextInt();
                    sc.nextLine();

                    if (secondOption == 1) {
                        System.out.print("Enter your name - ");
                        String userName = sc.nextLine();
                        System.out.print("Enter your BITS ID in numbers - ");
                        int userId = sc.nextInt();
                        sc.nextLine();
                        User user = new User(userName, userId);
                        users.add(user);
                        System.out.println("Successfully registered. Redirecting to Login page...");
                    } else if (secondOption == 2) {
                        System.out.print("Enter your BITS ID in numbers - ");
                        int userId = sc.nextInt();
                        sc.nextLine();
                        int counter = 0;
                        for (; counter < users.size(); counter++) {
                            if (users.get(counter).getId() == userId) {
                                System.out.println("Successfully logged in. Redirecting to User Mode...");
                                break;
                            }
                        }
                        if (counter == users.size()) {
                            System.out.println("Invalid name or ID");
                            break;
                        }
                        System.out.println("------------------------------------");
                        System.out.println("- User Mode - ");
                        System.out.println("------------------------------------\n");
                        System.out.println("Please Enter 1 to Display Events");
                        System.out.println("Please Enter 2 to Make Booking");
                        System.out.println("Please Enter 3 to Cancel Booking");
                        System.out.println("Please Enter 4 to Go Back to Mode Selection\n");

                        System.out.print("Enter Option - ");
                        thirdOption = sc.nextInt();
                        sc.nextLine();

                        if (thirdOption == 1) {
                            System.out.println("DISPLAY EVENTS Selected");
                            System.out.println("-------------------------\n");
                            for (int i = 0; i < events.size(); i++) {
                                int eventID = i + 1;
                                System.out.println("Event ID - 00" + eventID);
                                System.out.println("Name of Event - " + events.get(i).getEventName());
                                System.out.println("Date of Event - " + events.get(i).getEventDate());
                                System.out.println("Details of Event - " + events.get(i).getEventDetails());
                                System.out.println("Price of Each Ticket - " + events.get(i).getEventPrice());
                                System.out.println("Seats free - " + events.get(i).getFreeSeatsCount());
                                System.out.println();
                            }
                            System.out.println("End of Event List.\n");
                        }


                        if (thirdOption == 2) {
                            System.out.println("MAKE BOOKING Selected");
                            System.out.println("-------------------------\n");
                            for (int i = 0; i < events.size(); i++) {
                                int eventID = i + 1;
                                System.out.println("Event ID - 00" + eventID);
                                System.out.println("Name of Event - " + events.get(i).getEventName());
                                System.out.println("Date of Event - " + events.get(i).getEventDate());
                                System.out.println("Details of Event - " + events.get(i).getEventDetails());
                                System.out.println("Price of Each Ticket - " + events.get(i).getEventPrice());
                                System.out.println("Seats free - " + events.get(i).getFreeSeatsCount());
                                System.out.println();
                            }
                            System.out.println("-------------------------");
                            System.out.print("Enter the Event ID - ");
                            int eventID = sc.nextInt();
                            sc.nextLine();
                            int repeat;
                            System.out.println();
                            do {
                                events.get(eventID - 1).getAuditorium().printSeatPlan();
                                System.out.print("Enter the row - ");
                                int selectedRow = sc.nextInt();
                                sc.nextLine();
                                System.out.print("Enter the seat - ");
                                int selectedSeat = sc.nextInt();
                                sc.nextLine();
                                System.out.println();
                                Booking booking = new Booking(users.get(counter), events.get(eventID - 1));
                                if (booking.reserveSeat(selectedRow - 1, selectedSeat - 1)) {
                                    bookings.add(booking);
                                    System.out.println("The seat is now reserved for you.");
                                } else {
                                    System.out.println("Sorry the seat is already reserved.");
                                }
                                System.out.println();
                                System.out.print("Enter 1 to reserve another seat or 2 to check out - ");
                                repeat = sc.nextInt();
                                sc.nextLine();
                            } while (repeat == 1);
                            System.out.println();
                            System.out.println("Your Bill");
                            System.out.println("-------------------------");
                            int totalCost = 0;
                            for (Booking booking : bookings) {
                                if (booking.getUser().getId() == users.get(counter).getId()) {
                                    totalCost += booking.getCost();
                                }
                            }
                            System.out.println("Student ID - " + users.get(counter).getId());
                            System.out.println("Total costs - " + totalCost + " Rupees");
                            System.out.println();
                        }

                        if (thirdOption == 3) {
                            System.out.println("CANCEL BOOKING Selected");
                            System.out.println("-------------------------\n");
                            for (User user : users) {
                                if (user.getId() == userId) {
                                    for (Booking booking : bookings) {
                                        if (booking.getUser().getId() == user.getId()) {
                                            booking.dereserveSeat();
                                        }
                                    }
                                    System.out.println("Your reservation has been cancelled!");
                                }
                            }
                            System.out.println();
                        }
                    } else {
                        System.out.println("Invalid option");
                        break;
                    }

                } while (thirdOption != 4);
            }

        } while (firstOption != 3);
    }
}
