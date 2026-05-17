package com.example.eventbookingsystem.model;

/**
 * ============================================================
 *  CardPayment.java  –  SUBCLASS of Payment
 *  Place this in: src/main/java/com/eventbooking/model/
 *
 *  OOP CONCEPTS DEMONSTRATED:
 *
 *  1. INHERITANCE
 *     - "extends Payment" means CardPayment INHERITS all fields
 *       and methods from Payment (bookingId, amount, status, etc.)
 *     - We don't re-write those fields – we reuse them from Payment
 *     - CardPayment ADDS its own extra fields: cardNumber, cardHolder, expiryDate
 *
 *  2. POLYMORPHISM
 *     - Overrides processPayment() with CARD-specific logic
 *     - When Java calls processPayment() on a Payment variable
 *       that actually holds a CardPayment object, THIS version runs
 *     - This is called "runtime polymorphism" or "method overriding"
 *
 *  3. ENCAPSULATION
 *     - cardNumber is stored only as last 4 digits for security
 *     - Private fields with getters/setters
 * ============================================================
 */
public class CardPayment extends Payment {

    // ── Extra fields specific to card payments ────────────────────────────
    private String cardNumber;   // Only last 4 digits stored (security)
    private String cardHolder;   // Name printed on the card
    private String expiryDate;   // Format: MM/YY

    // ── Constructor ──────────────────────────────────────────────────────

    /**
     * Creates a new CardPayment.
     * Calls super() to set common fields in Payment (parent class).
     */
    public CardPayment(int bookingId, String customerName, double amount,
                       String cardNumber, String cardHolder, String expiryDate) {

        // Call parent class constructor (Payment)
        super(bookingId, customerName, amount, "CARD");

        // Set card-specific fields
        this.cardNumber = maskCardNumber(cardNumber); // Store only last 4 digits!
        this.cardHolder = cardHolder;
        this.expiryDate = expiryDate;
    }

    /**
     * No-arg constructor used when reading from the database.
     */
    public CardPayment() {
        super();
        setPaymentMethod("CARD"); // Always CARD for this class
    }

    // ── POLYMORPHISM: Override processPayment() ───────────────────────────

    /**
     * Card-specific payment processing logic.
     * Validates card details, then marks payment as COMPLETED or FAILED.
     *
     * @return result message shown to the user
     */
    @Override
    public String processPayment() {

        // Validate card number
        if (cardNumber == null || cardNumber.isEmpty()) {
            setStatus("FAILED");
            return "Payment FAILED: Invalid card number.";
        }

        // Validate card holder name
        if (cardHolder == null || cardHolder.trim().isEmpty()) {
            setStatus("FAILED");
            return "Payment FAILED: Card holder name is required.";
        }

        // Validate expiry date
        if (expiryDate == null || expiryDate.isEmpty()) {
            setStatus("FAILED");
            return "Payment FAILED: Expiry date is required.";
        }

        // All validations passed → mark as completed
        setStatus("COMPLETED");
        return "Card payment of Rs." + String.format("%.2f", getAmount())
                + " processed successfully. Card ending in " + cardNumber;
    }

    // ── Private helper: Security – store only last 4 digits ──────────────
    private String maskCardNumber(String rawNumber) {
        if (rawNumber == null) return null;
        // Remove spaces from card number
        String cleaned = rawNumber.replaceAll("\\s+", "");
        if (cleaned.length() < 4) return cleaned;
        // Return only last 4 digits
        return cleaned.substring(cleaned.length() - 4);
    }

    // ── ENCAPSULATION: Getters ────────────────────────────────────────────
    public String getCardNumber() { return cardNumber; }
    public String getCardHolder() { return cardHolder; }
    public String getExpiryDate() { return expiryDate; }

    // ── ENCAPSULATION: Setters ────────────────────────────────────────────
    public void setCardNumber(String cardNumber) { this.cardNumber = maskCardNumber(cardNumber); }
    public void setCardHolder(String cardHolder) { this.cardHolder = cardHolder; }
    public void setExpiryDate(String expiryDate) { this.expiryDate = expiryDate; }
}