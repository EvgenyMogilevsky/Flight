package main.java.com.flights.example.domain.entity;

public class Coupon {

    private int couponID;
    private int discount;

    public Coupon(int couponID, int discount) {
        super();
        this.couponID = couponID;
        this.discount = discount;
    }

    public Coupon() {

    }

    public int getCouponID() {
        return couponID;
    }

    public int getDiscount() {
        return discount;
    }

    public void setCouponID(int couponID) {
        this.couponID = couponID;
    }

    public void setDiscount(int discount) {
        this.discount = discount;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Coupon)) return false;

        Coupon coupon = (Coupon) o;

        if (couponID != coupon.couponID) return false;
        return Double.compare(coupon.discount, discount) == 0;
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        result = couponID;
        temp = Double.doubleToLongBits(discount);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        return result;
    }
}
