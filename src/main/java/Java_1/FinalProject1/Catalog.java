package Java_1.FinalProject1;

import java.util.ArrayList;
import java.util.List;

/**
 * The Catalog class represents a catalog of billable items, including products and services.
 * It provides methods to retrieve the list of billable items in the catalog.
 * @author greg.dawe
 */
public class Catalog {

    private static List<BillableItem> billablesArray = new ArrayList<>();

    /*
     * Static block to add default products and services to the catalog
     * when Catalog class is used.
     */
    static {
        addDefaultProducts();
    }

    /**
     * Adds default products and services to the catalog.
     */
    private static void addDefaultProducts() {
        billablesArray.add(new Product(1,"Intel Pentium III Processor",120.00));
        billablesArray.add(new Product(2,"ASUS P3B Motherboard",150.00));
        billablesArray.add(new Product(3,"Seagate Barracuda 20GB HDD",100.00));
        billablesArray.add(new Product(4,"Kingston ValueRAM 128MB SDRAM",30.00));
        billablesArray.add(new Product(5,"ATI Rage 128 Pro Graphics Card",70.00));
        billablesArray.add(new Product(6,"Sony CD-RW Drive",45.00));
        billablesArray.add(new Product(7,"Generic 350W Power Supply",35.00));
        billablesArray.add(new Product(8,"Creative Sound Blaster Live! Sound Card",50.00));
        billablesArray.add(new Product(9,"Dell 17-inch CRT Monitor",80.00));
        billablesArray.add(new Product(10,"Logitech PS/2 Keyboard",20.00));
        billablesArray.add(new Product(11,"Microsoft Intellimouse",15.00));
        billablesArray.add(new Product(12,"Case Fan 80mm",10.00));
        billablesArray.add(new Product(13,"Large metal case",70.00));
        billablesArray.add(new Service(Service.ServiceType.ASSEMBLY.id, Service.ServiceType.ASSEMBLY.description,Service.ServiceType.ASSEMBLY.price ));
        billablesArray.add(new Service(Service.ServiceType.DEFRAG_HDD.id, Service.ServiceType.DEFRAG_HDD.description, Service.ServiceType.DEFRAG_HDD.price));
        billablesArray.add(new Service(Service.ServiceType.REPAIR.id,Service.ServiceType.REPAIR.description, Service.ServiceType.REPAIR.price));
    }

    /**
     * Gets the list of billable items in the catalog.
     * @return The list of billable items.
     */
    public static List<BillableItem> getBillablesArray() {
        return billablesArray;
    }
}
