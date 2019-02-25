package main.java.com.flights.example.domain.port;

import main.java.com.flights.example.domain.entity.Baggage;
import main.java.com.flights.example.domain.entity.Coupon;
import main.java.com.flights.example.domain.entity.Ticket;

import java.util.List;

public interface Flights {
    boolean isTicketAvailable(int ticketId);

    boolean isCheckIn(int destination, String baggageId);

    String isCouponValid(int couponId, double price);

    void setCouponsList(List<Coupon> coupons);

    boolean addCoupon(Coupon coupon);

    boolean addTicket(Ticket ticket);

    boolean addBaggage(Baggage baggage);
}
