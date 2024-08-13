
package Java_1.Assignment5;

import java.util.ArrayList;

/**
 * Represents an invoice containing a list of invoice items.
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
     * Sets the list of invoice items associated with this invoice.
     *
     * @param invoiceItemList The list of invoice items to set for the invoice.
     */
    public void setInvoiceItemList(ArrayList<InvoiceItem> invoiceItemList) {
        this.invoiceItemList = invoiceItemList;
    }

    /**
     * Adds an invoice item to the invoice's list of items.
     *
     * @param invoiceItem The invoice item to add to the invoice.
     */
    public void addInvoiceItem(InvoiceItem invoiceItem) {
        invoiceItemList.add(invoiceItem);
    }

    /**
     * Calculates and returns the total cost of the invoice.
     * Iterates through ArrayList returned by getInvoiceItemList() method.
     * Adds the item total from each item to the value of variable total.
     *
     * double total = 0;
     *for (InvoiceItem item : getInvoiceItemList()) {
     *  total += item.getItemTotal();
     * }
     *
     *
     * @return The total cost of the invoice, which is the sum of the total cost of all invoice items.
     */
    public double getInvoiceTotal() {
        double total = 0;
        for (InvoiceItem item : getInvoiceItemList()) {
            total += item.getItemTotal();
        }
        return total;
    }
}