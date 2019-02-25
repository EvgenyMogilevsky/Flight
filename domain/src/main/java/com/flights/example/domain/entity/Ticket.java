package main.java.com.flights.example.domain.entity;

import java.io.Serializable;
import java.util.Date;

public class Ticket implements Serializable {
    private int id;
    private int depaptureCode;
    private int destinationCode;
    private String passengerName;
    private Date departureDate;

    public Ticket(int id, int depaptureCode, int destinationCode, String passengerName, Date departureDate) {
        this.id = id;
        this.depaptureCode = depaptureCode;
        this.destinationCode = destinationCode;
        this.passengerName = passengerName;
        this.departureDate = departureDate;
    }

    public Ticket() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getDepaptureCode() {
        return depaptureCode;
    }

    public void setDepaptureCode(int depaptureCode) {
        this.depaptureCode = depaptureCode;
    }

    public int getDestinationCode() {
        return destinationCode;
    }

    public void setDestinationCode(int destinationCode) {
        this.destinationCode = destinationCode;
    }

    public String getPassengerName() {
        return passengerName;
    }

    public void setPassengerName(String passengerName) {
        this.passengerName = passengerName;
    }

    public Date getDepartureDate() {
        return departureDate;
    }

    public void setDepartureDate(Date departureDate) {
        this.departureDate = departureDate;
    }

    @Override
    public String toString() {
        return "Ticket{" +
                "id=" + id +
                ", depaptureCode=" + depaptureCode +
                ", destinationCode=" + destinationCode +
                ", passengerName='" + passengerName + '\'' +
                ", departureDate=" + departureDate +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Ticket)) return false;

        Ticket ticket = (Ticket) o;

        if (id != ticket.id) return false;
        if (depaptureCode != ticket.depaptureCode) return false;
        if (destinationCode != ticket.destinationCode) return false;
        if (passengerName != null ? !passengerName.equals(ticket.passengerName) : ticket.passengerName != null)
            return false;
        return departureDate != null ? departureDate.equals(ticket.departureDate) : ticket.departureDate == null;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + depaptureCode;
        result = 31 * result + destinationCode;
        result = 31 * result + (passengerName != null ? passengerName.hashCode() : 0);
        result = 31 * result + (departureDate != null ? departureDate.hashCode() : 0);
        return result;
    }
}