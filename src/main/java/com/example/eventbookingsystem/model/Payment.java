package com.example.eventbookingsystem.model;

/**
 * ============================================================
 *  Payment.java  –  BASE CLASS (Abstract)
 *  Place this in: src/main/java/com/eventbooking/model/
 *
 *  OOP CONCEPTS DEMONSTRATED:
 *
 *  1. ENCAPSULATION
 *     - All fields are PRIVATE → cannot be accessed directly from outside
 *     - Public getters/setters control how data is read and written
 *     - Example: amount is private; you must call getAmount() to read it
 *
 *  2. ABSTRACTION
 *     - This class is declared "abstract" → cannot be instantiated directly
 *     - processPayment() is abstract → every subclass MUST override it
 *     - Users of this class don't need to know HOW payment is processed
 * ============================================================
 */
public abstract class Payment {

    // ── ENCAPSULATION: Private fields – hidden from outside classes ───────
    private int    paymentId;
    private int    bookingId;
    private String customerName;
    private double amount;
    private String paymentMethod;   // "CARD" or "CASH"
    private String status;          // "PENDING", "COMPLETED", "REFUNDED", "FAILED"
    private String transactionDate;
    private String notes;

    // ── Constructors ──────────────────────────────────────────────────────

    /**
     * Constructor used when creating a NEW payment.
     */
    public Payment(int bookingId, String customerName, double amount, String paymentMethod) {
        this.bookingId     = bookingId;
        this.customerName  = customerName;
        this.amount        = amount;
        this.paymentMethod = paymentMethod;
        this.status        = "PENDING";  // All new payments start as PENDING
    }

    /**
     * No-argument constructor – needed when reading payments from the database.
     * (DAO creates an empty object then fills it using setters)
     */
    public Payment() {}

    // ── ABSTRACTION: Abstract method ──────────────────────────────────────
    /**
     * Each payment type processes differently:
     *   - CardPayment → validates card details, charges the card
     *   - CashPayment → confirms cash received, calculates change
     *
     * Subclasses MUST provide their own implementation.
     *
     * @return String message describing the result of payment processing
     */
    public abstract String processPayment();

    // ── ENCAPSULATION: Getters (READ access to private fields) ────────────

    public int    getPaymentId()       { return paymentId; }
    public int    getBookingId()       { return bookingId; }
    public String getCustomerName()    { return customerName; }
    public double getAmount()          { return amount; }
    public String getPaymentMethod()   { return paymentMethod; }
    public String getStatus()          { return status; }
    public String getTransactionDate() { return transactionDate; }
    public String getNotes()           { return notes; }

    // ── ENCAPSULATION: Setters (WRITE access with controlled input) ────────

    public void setPaymentId(int paymentId)             { this.paymentId = paymentId; }
    public void setBookingId(int bookingId)              { this.bookingId = bookingId; }
    public void setCustomerName(String customerName)     { this.customerName = customerName; }
    public void setAmount(double amount)                 { this.amount = amount; }
    public void setPaymentMethod(String paymentMethod)   { this.paymentMethod = paymentMethod; }
    public void setStatus(String status)                 { this.status = status; }
    public void setTransactionDate(String date)          { this.transactionDate = date; }
    public void setNotes(String notes)                   { this.notes = notes; }

    // ── toString – useful for debugging ───────────────────────────────────
    @Override
    public String toString() {
        return "Payment{" +
                "paymentId=" + paymentId +
                ", bookingId=" + bookingId +
                ", customerName='" + customerName + '\'' +
                ", amount=" + amount +
                ", method='" + paymentMethod + '\'' +
                ", status='" + status + '\'' +
                '}';
    }
}
