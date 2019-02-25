package main.java.com.flights.example.domain.model;

import main.java.com.flights.example.domain.entity.*;
import main.java.com.flights.example.domain.port.Flights;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class FlightsEmbedded implements Flights {

    private static final double MIN_DISCOUNT = 20;
    private static final double MAX_DISCOUNT = 80;
    private static final String NO_COUPON = "Coupon not found";
    private static final int COUPONS_COUNT = 100;
    private Map<Integer, Ticket> tickets = new HashMap<>();
    private Map<String, Baggage> baggages = new HashMap<>();
    private List<Coupon> couponsList = new ArrayList<>(COUPONS_COUNT);

    @Override
    public boolean isTicketAvailable(int ticketId) {

        return tickets.containsKey(ticketId);
    }

    @Override
    public boolean isCheckIn(int destination, String baggageId) {
        return baggages.containsKey(baggageId) && baggages.get(baggageId).getTicket().getDestinationCode() == destination;
    }

    @Override
    public String isCouponValid(int couponId, double price) {
        if (couponsList.contains(couponId)) {
            return "final price is " + (price * MIN_DISCOUNT + (int) (Math.random() * MAX_DISCOUNT));
        }
        return NO_COUPON;
    }

    @Override
    public void setCouponsList(List<Coupon> coupons) {
        couponsList = coupons;

    }

    @Override
    public boolean addCoupon(Coupon coupon) {
        return couponsList.add(coupon);
    }

    @Override
    public boolean addTicket(Ticket ticket) {
        if (tickets.containsKey(ticket.getId())) return false;
        tickets.put(ticket.getId(), ticket);
        return true;
    }

    @Override
    public boolean addBaggage(Baggage baggage) {
        if (!tickets.containsKey(baggage.getTicket().getId()) || baggages.containsKey(baggage.getId())) return false;
        baggages.put(baggage.getId(), baggage);
        return true;
    }
}
