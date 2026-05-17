package com.example.eventbookingsystem.model;

/**
 * ============================================================
 *  CashPayment.java  –  SUBCLASS of Payment
 *  Place this in: src/main/java/com/eventbooking/model/
 *
 *  OOP CONCEPTS DEMONSTRATED:
 *
 *  1. INHERITANCE
 *     - "extends Payment" → inherits ALL fields from Payment
 *       (paymentId, bookingId, customerName, amount, status, etc.)
 *     - Adds its own fields: amountReceived, changeGiven
 *
 *  2. POLYMORPHISM
 *     - Overrides processPayment() with CASH-specific logic
 *     - Very different from CardPayment's version:
 *       - No card validation needed
 *       - Checks if enough cash was given
 *       - Calculates change to return to customer
 *
 *  3. ENCAPSULATION
 *     - amountReceived and changeGiven are private
 *     - Accessed through getters/setters only
 * ============================================================
 */
public class CashPayment extends Payment {

    // ── Extra fields specific to cash payments ────────────────────────────
    private double amountReceived;  // How much cash the customer handed over
    private double changeGiven;     // How much change to give back

    // ── Constructor ──────────────────────────────────────────────────────

    /**
     * Creates a new CashPayment.
     * @param amountReceived – the cash amount the customer gave
     *                         (must be >= amount to be valid)
     */
    public CashPayment(int bookingId, String customerName,
                       double amount, double amountReceived) {

        // Call parent class constructor (Payment)
        super(bookingId, customerName, amount, "CASH");

        this.amountReceived = amountReceived;
        this.changeGiven    = amountReceived - amount; // Pre-calculate change
    }

    /**
     * No-arg constructor – used when reading from the database.
     */
    public CashPayment() {
        super();
        setPaymentMethod("CASH"); // Always CASH for this class
    }

    // ── POLYMORPHISM: Override processPayment() ───────────────────────────

    /**
     * Cash-specific payment processing logic.
     * Checks if sufficient cash was received, calculates change.
     * Completely different logic from CardPayment → this is POLYMORPHISM.
     *
     * @return result message shown to the user
     */
    @Override
    public String processPayment() {

        // Check if customer gave enough cash
        if (amountReceived < getAmount()) {
            setStatus("FAILED");
            return "Payment FAILED: Insufficient cash. "
                    + "Required: Rs." + String.format("%.2f", getAmount())
                    + " | Received: Rs." + String.format("%.2f", amountReceived);
        }

        // Sufficient cash received → process successfully
        setStatus("COMPLETED");
        this.changeGiven = amountReceived - getAmount(); // Recalculate change

        return "Cash payment of Rs." + String.format("%.2f", getAmount())
                + " received successfully. "
                + "Change to return: Rs." + String.format("%.2f", changeGiven);
    }

    // ── ENCAPSULATION: Getters ────────────────────────────────────────────
    public double getAmountReceived() { return amountReceived; }
    public double getChangeGiven()    { return changeGiven; }

    // ── ENCAPSULATION: Setters ────────────────────────────────────────────
    public void setAmountReceived(double amountReceived) {
        this.amountReceived = amountReceived;
        // Recalculate change whenever amountReceived changes
        this.changeGiven = amountReceived - getAmount();
    }
    public void setChangeGiven(double changeGiven) { this.changeGiven = changeGiven; }
}