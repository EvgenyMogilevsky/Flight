package main.java.com.flights.example.domain.controller;

import main.java.com.flights.example.domain.entity.*;
import main.java.com.flights.example.domain.model.Cashe;
import main.java.com.flights.example.domain.port.Flights;
import org.springframework.beans.factory.annotation.*;
import org.springframework.web.bind.annotation.*;

import javax.annotation.PostConstruct;
import java.util.*;

import static main.java.com.flights.example.domain.port.PathConstants.*;

@RestController
public class FlightsController {
    private static Random random = new Random();

    @Autowired
    Flights flights;
    @Autowired
    Cashe cashe;

    @Value("${countCoupons:10}")
    int countCoupons;

    @PostConstruct
    public void set() {
        List<Coupon> couponList = new ArrayList<>(countCoupons);
        couponList.forEach(c -> c.setCouponID(random.nextInt(1000)));
        flights.setCouponsList(couponList);
    }

    @GetMapping(value = TICKET + "/{ticketId}")
    public boolean ticketAvailable(@PathVariable("ticketId") Integer ticketId) {
        return checkInCashe(TICKET + "/" + ticketId)?cashe.getValue(TICKET + "/" + ticketId):flights.isTicketAvailable(ticketId);
    }

    private boolean checkInCashe(String s) {
        //TODO to implement cache mechanism code checking
        return true;
    }

    @GetMapping(value = BAGGAGE)
    public boolean checkIn(@RequestParam("destinationCode") int destinationCode, @RequestParam("baggageId") String baggageId) {
        return flights.isCheckIn(destinationCode, baggageId);
    }

    @GetMapping(value = COUPON)
    public String couponValid(@RequestParam("couponId") int couponId, @RequestParam("couponPrice") double couponPrice){
        return flights.isCouponValid(couponId, couponPrice);

    }
    @PostMapping(value = COUPON)
    public boolean addCoupon(@RequestBody Coupon coupon){
        return flights.addCoupon(coupon);
    }
    @PostMapping(value = TICKET)
    public boolean addTicket(@RequestBody Ticket ticket){
        return flights.addTicket(ticket);
    }
    @PostMapping(value = BAGGAGE)
    public boolean addBaggage(@RequestBody Baggage baggage){
        return flights.addBaggage(baggage);
    }
}
