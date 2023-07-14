import java.util.ArrayList;

public class Auditorium {
    private ArrayList<Row> rows;
    private int rowCount;

    public Auditorium() {
        rows = new ArrayList<>();
    }

    public int getRowCount() {
        return rowCount;
    }

    public void createRows(int seatCount, int rowCount) {
        for (int i = 1; i <= rowCount; i++) {
            rows.add(new Row(seatCount, i));
        }
        this.rowCount += rowCount;
    }

    public ArrayList<Row> getRows() {
        return rows;
    }

    public void printSeatPlan() {
        System.out.println();
        int maxSeatsInRow = 0;
        for (Row row : getRows()) {
            if (row.getSeats().size() > maxSeatsInRow) {
                maxSeatsInRow = row.getSeats().size();
            }
        }
        System.out.print("   |");
        for (int i = 1; i <= maxSeatsInRow; i++) {
            System.out.print(" " + i);
        }
        System.out.print("\n");
        System.out.print("----");
        for (int i = 1; i <= maxSeatsInRow; i++) {
            if (i > 9) {
                System.out.print("---");
            } else {
                System.out.print("--");
            }
        }
        System.out.print("\n");
        for (Row row : getRows()) {
            if (row.getRowNumber() > 9) {
                System.out.print(row.getRowNumber() + " | ");
            } else {
                System.out.print(row.getRowNumber() + "  | ");
            }
            for (Seat seat : row.getSeats()) {

                if (seat.getReservationStatus()) {
                    System.out.print("\u001B[31m" + "X " + "\u001B[0m");
                } else {
                    System.out.print(seat.getSeatNumber() + " ");
                }
            }
            System.out.print("\n");
        }
        System.out.print("\n");
    }
}
