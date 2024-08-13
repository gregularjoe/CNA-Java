
package Java_1.Assignment5;

import java.util.ArrayList;

/**
 * A test class to demonstrate and test the functionality of products, invoice items, and invoices.
 */
public class Assignment5Tester {
    public static void main(String[] args) {

        // Products
        Product lavalamp = new Product(1, "little lava lamp", 20.01);
        Product discoBall = new Product(200,"just a lil disco ball",44.44);
        Product easterEgg = new Product(-33, "a tasty easter treat",-5.99);
        Product moonShoes = new Product(5,"bounce to the moon",200.00);
        System.out.println("----------------------------------------------------------------------------------------");
        System.out.println("Product Testing");
        System.out.println("----------------------------------------------------------------------------------------");
        System.out.printf("Lava Lamp\nid: %d | Description: %s | Price: $%,.2f \n",lavalamp.getId(),lavalamp.getDescription(),lavalamp.getPrice());
        System.out.printf("Disco Ball\nid: %d | Description: %s | Price: $%,.2f \n",discoBall.getId(),discoBall.getDescription(),discoBall.getPrice());
        System.out.printf("Easter Egg\nid: %d | Description: %s | Price: $%,.2f \n",easterEgg.getId(),easterEgg.getDescription(),easterEgg.getPrice());
        System.out.println("Setters:\nSetting lava lamp id to 3.\nSetting disco ball description to 'funky lil disco ball'");
        lavalamp.setId(3);
        System.out.printf("New lava lamp id is: %d\n",lavalamp.getId());
        discoBall.setDescription("funky lil disco ball.");
        System.out.printf("New disco ball description is: %s\n",discoBall.getDescription());
        easterEgg.setPrice(5.99);
        System.out.printf("New easter egg price is: $%,.2f\n",easterEgg.getPrice());

        // Invoice Item
        InvoiceItem item1 = new InvoiceItem(lavalamp, 5);
        InvoiceItem item2 = new InvoiceItem(discoBall, 10);
        InvoiceItem item3 = new InvoiceItem(easterEgg, -10);
        InvoiceItem item4 = new InvoiceItem(moonShoes,3);
        System.out.println("----------------------------------------------------------------------------------------");
        System.out.println("Invoice Item Testing");
        System.out.println("----------------------------------------------------------------------------------------");
        System.out.printf("Invoice Item 1\nProduct-id: %d | Quantity: %d | Item-Total: $%,.2f\n",item1.getProduct().getId(),item1.getQuantity(),item1.getItemTotal());
        System.out.printf("Invoice Item 2\nProduct-id: %d | Quantity: %d | Item-Total: $%,.2f\n",item2.getProduct().getId(),item2.getQuantity(),item2.getItemTotal());
        System.out.printf("Invoice Item 3\nProduct-id: %d | Quantity: %d | Item-Total: $%,.2f\n",item3.getProduct().getId(),item3.getQuantity(),item3.getItemTotal());
        System.out.println("Setters:\nSetting item1's product to moon shoes and its quantity to 13");
        item1.setProduct(moonShoes);
        System.out.printf("Item1's new product's description is: %s\n",item1.getProduct().getDescription());
        item1.setQuantity(13);
        System.out.printf("Item1's new quantity is: %d\n",item1.getQuantity());

        // Invoice
        System.out.println("----------------------------------------------------------------------------------------");
        System.out.println("Invoice Testing");
        System.out.println("----------------------------------------------------------------------------------------");
        ArrayList<InvoiceItem> invoiceList = new ArrayList<InvoiceItem>();
        invoiceList.add(item1);
        invoiceList.add(item2);
        invoiceList.add(item3);
        Invoice invoice = new Invoice(invoiceList);
        System.out.printf("Invoice Total: $%,.2f\n",invoice.getInvoiceTotal());
        System.out.println("Testing Add New Method:");
        invoice.addInvoiceItem(item4);
        System.out.printf("New total, with new item added is: $%,.2f\n",invoice.getInvoiceTotal());
        System.out.println("----------------------------------------------------------------------------------------");

    }
}