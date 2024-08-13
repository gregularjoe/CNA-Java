package Java_1.FinalProject1;

import java.util.ArrayList;

/**
 * Represents an invoice containing a list of invoice items.
 * @author greg.dawe
 */
public class Invoice {
    private ArrayList<InvoiceItem> invoiceItemList;

    /**
     * Constructs a new Invoice with an initial list of invoice items.
     *
     * @param invoiceItemList The list of invoice items to initialize the invoice with.
     */
    public Invoice(ArrayList<InvoiceItem> invoiceItemList) {
        this.invoiceItemList = invoiceItemList;
    }

    /**
     * Gets the list of invoice items associated with this invoice.
     *
     * @return The list of invoice items.
     */
    public ArrayList<InvoiceItem> getInvoiceItemList() {
        return this.invoiceItemList;
    }

    /**
     * Calculates and returns the total cost of the invoice.
     * Iterates through ArrayList returned by getInvoiceItemList() method.
     * Adds the item total from each item to the value of variable total.
     * @return The total cost of the invoice, which is the sum of the total cost of all invoice items.
     */
    public double subTotal() {
        double total = 0;
        for (InvoiceItem item : getInvoiceItemList()) {
            total += item.itemTotal();
        }
        return total;
    }

    /**
     * Calculates and returns amount of taxes based on the result of the subtotal method.
     * @return The amount of the taxes, which is the product of the subtotal and the tax rate of 15%.
     */
    public double taxAmount() {
        return subTotal() * .15;
    }

    /**
     * Calculates and returns the total based on the result of the taxAmount method.
     * @return The total, which is the sum of the result from the subtotal and taxAmount methods.
     */
    public double total() {
        return subTotal() + taxAmount();
    }
}
