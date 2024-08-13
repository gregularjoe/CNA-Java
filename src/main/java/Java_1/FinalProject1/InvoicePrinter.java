package Java_1.FinalProject1;

import java.io.*;
import java.time.LocalDate;
import java.util.ArrayList;

/**
 * Utility class for printing invoices and catalog information.
 * @author greg.dawe
 */
public class InvoicePrinter {
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_YELLOW = "\u001B[33m";

    /**
     * Prints the catalog information to a string.
     * @return A string containing the formatted catalog information.
     */
    public static String printCatalogToString() {
        StringWriter stringWriter = new StringWriter();
        PrintWriter printWriter = new PrintWriter(stringWriter);
        printWriter.printf(ANSI_GREEN + "\n=================================================================================\n");
        printWriter.printf(ANSI_YELLOW + "Classic Computer Company Catalog");
        printWriter.printf(ANSI_GREEN + "\n--------------------------------------------------------------------------------\n");
        printWriter.printf(ANSI_YELLOW + "ID        DESCRIPTION                                   PRICE($)");
        printWriter.printf(ANSI_GREEN + "\n--------------------------------------------------------------------------------\n");
        for (int i = 0; i < Catalog.getBillablesArray().size(); i++) {
            BillableItem currentProduct = Catalog.getBillablesArray().get(i);
            printWriter.printf(
                    ANSI_YELLOW + "%-10d" + ANSI_GREEN + "%-45.45s " + ANSI_YELLOW + "%-10.2f%n",
                    currentProduct.getId(),
                    currentProduct.getDescription(),
                    currentProduct.getPrice());
        }
        printWriter.printf(ANSI_GREEN + "\n=================================================================================\n");
        return stringWriter.toString();
    }

    /**
     * Prints the header information to the provided print stream.
     * @param printStream The print stream to which the header will be printed.
     * @return The same print stream for method chaining.
     */
    public static PrintStream printHeader(PrintStream printStream) {
        return printStream.printf(
                ANSI_GREEN +
                        "\n=================================================================================\n" +
                        ANSI_YELLOW + "                    %s\n" + ANSI_GREEN +
                        "                %s %s \n                         %s," +
                        " %s\n                             %s\n" + ANSI_YELLOW +
                        "                       Phone: " + ANSI_GREEN + "%-13s\n" + ANSI_YELLOW +
                        "                       Email: " + ANSI_GREEN + "%s\n" +
                        "\n=================================================================================\n",
                Company.getCompanyInfo().getCompanyName(),
                Company.getCompanyInfo().getCompanyStreetAddress(),
                Company.getCompanyInfo().getCompanyPostalCode(),
                Company.getCompanyInfo().getCompanyCity(),
                Company.getCompanyInfo().getCompanyProvince(),
                Company.getCompanyInfo().getCompanyCountry(),
                Company.getCompanyInfo().getCompanyPhone(),
                Company.getCompanyInfo().getCompanyEmail());
    }

    /**
     * Prints the invoice information to the provided print stream.
     * @param printStream The print stream to which the invoice information will be printed.
     * @param x           A parameter (e.g., invoice number) used in formatting.
     * @return The same print stream for method chaining.
     */
    public static PrintStream printInvoiceInfo(PrintStream printStream, int x) {
        LocalDate currentDate = LocalDate.now();
        String invoiceNumber = "CCC-2023-";
        return printStream.printf(
                ANSI_YELLOW +
                        "\nInvoice Number: " + ANSI_GREEN + "%s%d\n" + ANSI_YELLOW +
                        "Date: " + ANSI_GREEN + "%tF\n" + ANSI_YELLOW +
                        "Due Date: " + ANSI_GREEN + "%tF\n",
                invoiceNumber, x, currentDate, currentDate.plusWeeks(6));
    }

    /**
     * Prints the billing information to the provided print stream.
     * @param customer     The customer associated with the invoice.
     * @param address      The billing address associated with the invoice.
     * @param printStream  The print stream to which the billing information will be printed.
     * @return The same print stream for method chaining.
     */
    public static PrintStream printBillTo(Customer customer, Address address, PrintStream printStream) {
        return printStream.printf(
                ANSI_YELLOW + "\nBill To:\n" +
                        "Customer Name: " + ANSI_GREEN + "%s %s\n" + ANSI_YELLOW +
                        "org.Address: " + ANSI_GREEN + "%s, %s\n" +
                        "         %s %s, %s",
                customer.getFirstName(), customer.getLastName(),
                address.getStreetAddress(), address.getPostalCode(),
                address.getCity(), address.getProvince(), address.getCountry()
        );
    }

    /**
     * Prints the shipping information to the provided print stream.
     * @param customer     The customer associated with the invoice.
     * @param address      The shipping address associated with the invoice.
     * @param printStream  The print stream to which the shipping information will be printed.
     * @return The same print stream for method chaining.
     */
    public static PrintStream printShipTo(Customer customer, Address address, PrintStream printStream) {
        return printStream.printf(
                ANSI_YELLOW + "\nShip To:\n" +
                "Customer Name: " + ANSI_GREEN + "%s %s\n" + ANSI_YELLOW +
                "org.Address: " + ANSI_GREEN + "%s, %s\n" + "         %s %s, %s",
                customer.getFirstName(), customer.getLastName(),
                address.getStreetAddress(), address.getPostalCode(),
                address.getCity(), address.getProvince(), address.getCountry()
        );
    }


    /**
     * Prints a demo invoice to a string.
     * @param printStream The print stream to which the demo invoice will be printed.
     * @return A string containing the formatted demo invoice information.
     */
    public static String printDemoInvoice(PrintStream printStream) {
        StringWriter stringWriter = new StringWriter();
        PrintWriter printWriter = new PrintWriter(stringWriter);

        Customer demoCustomer = new Customer("Tosh", "Baylor");
        Address demoAddress = new Address("123 Real Street", "A1B 1B3", "St.John's", "NL", "Canada");

        ArrayList<InvoiceItem> invoiceList = new ArrayList<>();
        invoiceList.add(new InvoiceItem(Catalog.getBillablesArray().get(0), 1));
        invoiceList.add(new InvoiceItem(Catalog.getBillablesArray().get(1), 1));
        invoiceList.add(new InvoiceItem(Catalog.getBillablesArray().get(2), 1));
        invoiceList.add(new InvoiceItem(Catalog.getBillablesArray().get(3), 2));
        invoiceList.add(new InvoiceItem(Catalog.getBillablesArray().get(4), 1));
        invoiceList.add(new InvoiceItem(Catalog.getBillablesArray().get(6), 1));
        invoiceList.add(new InvoiceItem(Catalog.getBillablesArray().get(12), 1));
        invoiceList.add(new InvoiceItem(Catalog.getBillablesArray().get(13), 1));
        Invoice demoInvoice = new Invoice(invoiceList);

        printWriter.printf(ANSI_GREEN + "\n=================================================================================\n");
        printWriter.printf(ANSI_YELLOW + "DESCRIPTION                                QUANTITY   UNIT-PRICE($)     TOTAL($)");
        printWriter.printf(ANSI_GREEN + "\n--------------------------------------------------------------------------------\n");
        InvoicePrinter.printHeader(printStream);
        InvoicePrinter.printInvoiceInfo(printStream,42);
        InvoicePrinter.printBillTo(demoCustomer,demoAddress,printStream);
        InvoicePrinter.printShipTo(demoCustomer,demoAddress,printStream);

        for (InvoiceItem invoiceItem : invoiceList) {
            printWriter.printf(
                    ANSI_GREEN + "%-45.43s " + ANSI_YELLOW + "%-10d " + ANSI_GREEN + "%-15.2f %-10.2f\n",
                    invoiceItem.getBillableItem().getDescription(),
                    invoiceItem.getQuantity(),
                    invoiceItem.getBillableItem().getPrice(),
                    invoiceItem.itemTotal());
        }
        printWriter.printf(ANSI_YELLOW + "Subtotal: " + ANSI_GREEN + "%.2f\n" + ANSI_YELLOW + "Tax(15%%): " + ANSI_GREEN + "%.2f",demoInvoice.subTotal(),demoInvoice.taxAmount());
        printWriter.printf(ANSI_GREEN + "\n--------------------------------------------------------------------------------\n");
        printWriter.printf(ANSI_YELLOW + "Total Amount Due: " + ANSI_GREEN + "%.2f",demoInvoice.total());
        printWriter.printf(ANSI_GREEN + "\n=================================================================================\n");
        printWriter.printf(ANSI_YELLOW + "Payment Instructions:\n" + ANSI_GREEN +
                "Please make the payment by the due date mentioned above.\n" +
                "You can send your payment via check to the address provided.\n\n\n" +
                "Thank you for choosing Classic Computer Corporation!");
        printWriter.printf(ANSI_GREEN + "\n=================================================================================\n");
        return stringWriter.toString();
    }

    /**
     * Prints a customer invoice to a string.
     * @param customer    The customer associated with the invoice.
     * @param address     The billing and shipping address associated with the invoice.
     * @param invoice     The invoice to be printed.
     * @param printStream The print stream to which the customer invoice will be printed.
     * @return A string containing the formatted customer invoice information.
     */
    public static String printInvoice(Customer customer, Address address, Invoice invoice, PrintStream printStream) {
        StringWriter stringWriter = new StringWriter();
        PrintWriter printWriter = new PrintWriter(stringWriter);

        printWriter.printf(ANSI_GREEN + "\n=================================================================================\n");
        printWriter.printf(ANSI_YELLOW + "DESCRIPTION                                QUANTITY   UNIT-PRICE($)     TOTAL($)");
        printWriter.printf(ANSI_GREEN + "\n--------------------------------------------------------------------------------\n");
        printHeader(printStream);
        printInvoiceInfo(printStream,42);
        printBillTo(customer,address,printStream);
        printShipTo(customer,address,printStream);

        for (InvoiceItem invoiceItem : invoice.getInvoiceItemList()) {
            double itemTotalHolder = invoiceItem.itemTotal();
            printWriter.printf(
                    ANSI_GREEN + "%-45.43s " + ANSI_YELLOW + "%-10d " + ANSI_GREEN + "%-15.2f %-10.2f\n",
                    invoiceItem.getBillableItem().getDescription(),
                    invoiceItem.getQuantity(),
                    invoiceItem.getBillableItem().getPrice(),
                    invoiceItem.itemTotal());
        }
        printWriter.printf(ANSI_YELLOW + "Subtotal: " + ANSI_GREEN + "%.2f\n" + ANSI_YELLOW + "Tax(15%%): " + ANSI_GREEN + "%.2f",invoice.subTotal(),invoice.taxAmount());
        printWriter.printf(ANSI_GREEN + "\n--------------------------------------------------------------------------------\n");
        printWriter.printf(ANSI_YELLOW + "Total Amount Due: " + ANSI_GREEN + "%.2f",invoice.total());
        printWriter.printf(ANSI_GREEN + "\n=================================================================================\n");
        printWriter.printf(ANSI_YELLOW + "Payment Instructions:\n" + ANSI_GREEN +
                "Please make the payment by the due date mentioned above.\n" +
                "You can send your payment via check to the address provided.\n\n\n" +
                "Thank you for choosing Classic Computer Corporation!");
        printWriter.printf(ANSI_GREEN + "\n=================================================================================\n");
        return stringWriter.toString();
    }
}
