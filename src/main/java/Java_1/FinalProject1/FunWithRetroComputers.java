package Java_1.FinalProject1;

import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * The main class for Classic Computer Company's Invoice System.
 * @author greg.dawe
 */
public class FunWithRetroComputers {

    /**
     * The main method to run the invoice system.
     * @param args The command line arguments.
     */
    public static void main(String[] args) {
        PrintStream printStream = new PrintStream(System.out);
        Scanner input = new Scanner(System.in);
        char c;
        String b;
        System.out.println(InvoicePrinter.ANSI_GREEN + "Welcome to Classic Computer Company's Invoice System!");

        do {
            printStream.print("""

                    Enter A to view the CCC catalog.
                    Enter B to print demo invoice.
                    Enter C to create new invoice.
                    When you're ready to Quit Press Q.
                    What would you like to do?:\s""");
            c = Character.toUpperCase(input.next().charAt(0));

            if (c == 'A') {
                printStream.println(InvoicePrinter.printCatalogToString());
            } else if (c == 'B') {
                printStream.println(InvoicePrinter.printDemoInvoice(printStream));

            } else if (c == 'C') {
                printStream.println("Enter first name: ");
                input.nextLine();
                String userFirstName = input.nextLine();

                printStream.println("Enter last name: ");
                String userLastName = input.nextLine();
                Customer customer = new Customer(userFirstName,userLastName);

                printStream.println("Enter street address: ");
                String userStreetAddress = input.nextLine();
                printStream.println("Enter postal code: ");
                String userPostalCode = input.nextLine();
                printStream.println("Enter city: ");
                String userCity = input.nextLine();
                printStream.println("Enter province: ");
                String userProvince = input.nextLine();
                printStream.println("Enter country: ");
                String userCountry = input.nextLine();
                Address address = new Address(userStreetAddress,userPostalCode, userCity,userProvince,userCountry);
                ArrayList<InvoiceItem> invoiceList = new ArrayList<>();

                BillableItem userBillable = Catalog.getBillablesArray().get(3);
                int userQuantity = 1;

                printStream.println(InvoicePrinter.printCatalogToString());

                label:
                while(true) {
                    printStream.print("""
                    
                    Enter Q to print invoice.
                             or
                    Enter the ID of a product or service to add item:\s""");
                    String userChoice = input.next();
                    b = userChoice.toUpperCase();
                    Invoice invoice = new Invoice(invoiceList);
                    switch (b) {
                        case "1":
                            userBillable = Catalog.getBillablesArray().get(0);
                            printStream.println("Enter Quantity: ");
                            userQuantity = input.nextInt();
                            InvoiceItem invoiceItem = new InvoiceItem(userBillable,userQuantity);
                            invoiceList.add(invoiceItem);
                            break;
                        case "2":
                            userBillable = Catalog.getBillablesArray().get(1);
                            printStream.println("Enter Quantity: ");
                            userQuantity = input.nextInt();
                            InvoiceItem invoiceItem2 = new InvoiceItem(userBillable,userQuantity);
                            invoiceList.add(invoiceItem2);
                            break;
                        case "3":
                            userBillable = Catalog.getBillablesArray().get(2);
                            printStream.println("Enter Quantity: ");
                            userQuantity = input.nextInt();
                            InvoiceItem invoiceItem3 = new InvoiceItem(userBillable,userQuantity);
                            invoiceList.add(invoiceItem3);
                            break;
                        case "4":
                            userBillable = Catalog.getBillablesArray().get(3);
                            printStream.println("Enter Quantity: ");
                            userQuantity = input.nextInt();
                            InvoiceItem invoiceItem4 = new InvoiceItem(userBillable,userQuantity);
                            invoiceList.add(invoiceItem4);
                            break;
                        case "5":
                            userBillable = Catalog.getBillablesArray().get(4);
                            printStream.println("Enter Quantity: ");
                            userQuantity = input.nextInt();
                            InvoiceItem invoiceItem5 = new InvoiceItem(userBillable,userQuantity);
                            invoiceList.add(invoiceItem5);
                            break;
                        case "6":
                            userBillable = Catalog.getBillablesArray().get(5);
                            printStream.println("Enter Quantity: ");
                            userQuantity = input.nextInt();
                            InvoiceItem invoiceItem6 = new InvoiceItem(userBillable,userQuantity);
                            invoiceList.add(invoiceItem6);
                            break;
                        case "7":
                            userBillable = Catalog.getBillablesArray().get(6);
                            printStream.println("Enter Quantity: ");
                            userQuantity = input.nextInt();
                            InvoiceItem invoiceItem7 = new InvoiceItem(userBillable,userQuantity);
                            invoiceList.add(invoiceItem7);
                            break;
                        case "8":
                            userBillable = Catalog.getBillablesArray().get(7);
                            printStream.println("Enter Quantity: ");
                            userQuantity = input.nextInt();
                            InvoiceItem invoiceItem8 = new InvoiceItem(userBillable,userQuantity);
                            invoiceList.add(invoiceItem8);
                            break;
                        case "9":
                            userBillable = Catalog.getBillablesArray().get(8);
                            printStream.println("Enter Quantity: ");
                            userQuantity = input.nextInt();
                            InvoiceItem invoiceItem9 = new InvoiceItem(userBillable,userQuantity);
                            invoiceList.add(invoiceItem9);
                            break;
                        case "10":
                            userBillable = Catalog.getBillablesArray().get(9);
                            printStream.println("Enter Quantity: ");
                            userQuantity = input.nextInt();
                            InvoiceItem invoiceItem10 = new InvoiceItem(userBillable,userQuantity);
                            invoiceList.add(invoiceItem10);
                            break;
                        case "11":
                            userBillable = Catalog.getBillablesArray().get(10);
                            printStream.println("Enter Quantity: ");
                            userQuantity = input.nextInt();
                            InvoiceItem invoiceItem11 = new InvoiceItem(userBillable,userQuantity);
                            invoiceList.add(invoiceItem11);
                            break;
                        case "12":
                            userBillable = Catalog.getBillablesArray().get(11);
                            printStream.println("Enter Quantity: ");
                            userQuantity = input.nextInt();
                            InvoiceItem invoiceItem12 = new InvoiceItem(userBillable,userQuantity);
                            invoiceList.add(invoiceItem12);
                            break;
                        case "13":
                            userBillable = Catalog.getBillablesArray().get(12);
                            printStream.println("Enter Quantity: ");
                            userQuantity = input.nextInt();
                            InvoiceItem invoiceItem13 = new InvoiceItem(userBillable,userQuantity);
                            invoiceList.add(invoiceItem13);
                            break;
                        case "14":
                            userBillable = Catalog.getBillablesArray().get(13);
                            printStream.println("Enter Quantity: ");
                            userQuantity = input.nextInt();
                            InvoiceItem invoiceItem14 = new InvoiceItem(userBillable,userQuantity);
                            invoiceList.add(invoiceItem14);
                            break;
                        case "15":
                            userBillable = Catalog.getBillablesArray().get(14);
                            printStream.println("Enter Quantity: ");
                            userQuantity = input.nextInt();
                            InvoiceItem invoiceItem15 = new InvoiceItem(userBillable,userQuantity);
                            invoiceList.add(invoiceItem15);
                            break;
                        case "16":
                            userBillable = Catalog.getBillablesArray().get(15);
                            printStream.println("Enter Quantity: ");
                            userQuantity = input.nextInt();
                            InvoiceItem invoiceItem16 = new InvoiceItem(userBillable,userQuantity);
                            invoiceList.add(invoiceItem16);
                            break;
                        case "Q":
                            break label;
                    }
                }
                Invoice invoice = new Invoice(invoiceList);
                printStream.println(InvoicePrinter.printInvoice(customer,address,invoice,printStream));
            }
        } while (c != 'Q');
        printStream.println("Quit Successfully.");
    }
}
