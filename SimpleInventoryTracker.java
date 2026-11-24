import java.util.*;
import java.io.*;

class InventoryItem {
    private String itemId, name;
    private int quantity;
    private double price;

    public InventoryItem(String id, String name, int qty, double price) {
        this.itemId = id;
        this.name = name;
        this.quantity = qty;
        this.price = price;
    }

    public String getItemId() { 
        return itemId; 
    }
    public String getName() { 
        return name; 
    }
    public int getQuantity() { 
        return quantity; 
    }
    public double getPrice() { 
        return price; 
    }

    public void setQuantity(int qty) {
        quantity = qty;
    }

    public String toFileString() {
        return itemId + "," + name + "," + quantity + "," + price;
    }

    public static String formatPrice(double price) {
        if (price == Math.floor(price))
            return String.valueOf((long) price);
        return String.valueOf(price);
    }

    public String toString() {
        return itemId + " | " + name + " | Qty: " + quantity
                + " | " + formatPrice(price);
    }
}

public class SimpleInventoryTracker {

    static ArrayList<InventoryItem> items = new ArrayList<>();
    static Scanner sc = new Scanner(System.in);
    static int nextId = 101;
    static final String FILE_NAME = "inventory.txt";

    public static void main(String[] args) {
        loadItems();

        while (true) {
            System.out.println("\n========== SIMPLE INVENTORY TRACKER ==========");
            System.out.println("1. Add Item");
            System.out.println("2. Display Items");
            System.out.println("3. Search Item");
            System.out.println("4. Sell Item");
            System.out.println("5. Low Stock Report");
            System.out.println("6. Sort by Quantity");
            System.out.println("7. Exit");
            System.out.print("Enter choice: ");

            int choice = readInt();

            switch (choice) {
                case 1: addItem(); break;
                case 2: displayItems(); break;
                case 3: searchItem(); break;
                case 4: sellItem(); break;
                case 5: lowStockReport(); break;
                case 6: sortByQuantity(); break;
                case 7:
                    saveItems();
                    System.out.println("Inventory saved successfully. Goodbye!");
                    return;
                default:
                    System.out.println("Invalid menu option.");
            }
        }
    }

    static int readInt() {
        while (true) {
            try {
                return Integer.parseInt(sc.nextLine().trim());
            } catch (NumberFormatException e) {
                System.out.print("Enter a valid number: ");
            }
        }
    }

    static double readDouble() {
        while (true) {
            try {
                return Double.parseDouble(sc.nextLine().trim());
            } catch (NumberFormatException e) {
                System.out.print("Enter a valid price: ");
            }
        }
    }

    static void addItem() {
        System.out.print("Enter item name: ");
        String name = sc.nextLine().trim();

        if (name.isEmpty() || name.contains(",")) {
            System.out.println("Invalid item name.");
            return;
        }

        System.out.print("Enter quantity: ");
        int qty = readInt();

        System.out.print("Enter price: ");
        double price = readDouble();

        if (qty <= 0 || price <= 0) {
            System.out.println("Quantity and price must be greater than 0.");
            return;
        }

        String id = "I" + nextId++;

        InventoryItem item =
                new InventoryItem(id, name, qty, price);

        items.add(item);

        System.out.println("Item added. ID: " + id + " | "
                + name + " | Qty: " + qty + " | "
                + InventoryItem.formatPrice(price));
    }

    static void displayItems() {
        if (items.isEmpty()) {
            System.out.println("Inventory is empty.");
            return;
        }

        System.out.println("INVENTORY ITEMS");

        for (InventoryItem item : items) {
            System.out.println(item);
        }
    }

    static InventoryItem findItem(String id) {
        for (InventoryItem item : items) {
            if (item.getItemId().equalsIgnoreCase(id.trim())) {
                return item;
            }
        }
        return null;
    }

    static void searchItem() {
        System.out.print("Enter item ID: ");
        String id = sc.nextLine();

        InventoryItem item = findItem(id);

        if (item == null)
            System.out.println("Item not found.");
        else
            System.out.println(item);
    }

    static void sellItem() {
        System.out.print("Enter item ID: ");
        String id = sc.nextLine();

        InventoryItem item = findItem(id);

        if (item == null) {
            System.out.println("Item not found.");
            return;
        }

        System.out.print("Enter quantity to sell: ");
        int qty = readInt();

        if (qty <= 0) {
            System.out.println("Sale quantity must be greater than 0.");
            return;
        }

        if (qty > item.getQuantity()) {
            System.out.println("Insufficient stock. Available: "
                    + item.getQuantity());
            return;
        }

        item.setQuantity(item.getQuantity() - qty);

        System.out.println("Stock updated. " + item.getItemId()
                + " | " + item.getName()
                + " | Qty: " + item.getQuantity());

        if (item.getQuantity() == 0) {
            System.out.println("Item is now out of stock.");
        }
    }

    static void lowStockReport() {
        boolean found = false;

        System.out.println("LOW STOCK ITEMS (Quantity below 5)");

        for (InventoryItem item : items) {
            if (item.getQuantity() < 5) {
                System.out.println(item.getItemId() + " | "
                        + item.getName() + " | Qty: "
                        + item.getQuantity());
                found = true;
            }
        }

        if (!found)
            System.out.println("No low-stock items.");
    }

    static void sortByQuantity() {
        items.sort(Comparator.comparingInt(
                InventoryItem::getQuantity));

        System.out.println("ITEMS SORTED BY QUANTITY (LOW TO HIGH)");

        int rank = 1;

        for (InventoryItem item : items) {
            System.out.println(rank + ". " + item.getItemId()
                    + " | " + item.getName()
                    + " | " + item.getQuantity());
            rank++;
        }
    }

    static void loadItems() {
        File file = new File(FILE_NAME);

        if (!file.exists())
            return;

        try (BufferedReader br =
                     new BufferedReader(new FileReader(file))) {

            String line;

            while ((line = br.readLine()) != null) {
                String[] data = line.split(",", 4);

                if (data.length == 4) {
                    String id = data[0];
                    String name = data[1];
                    int qty = Integer.parseInt(data[2]);
                    double price = Double.parseDouble(data[3]);

                    items.add(new InventoryItem(id, name, qty, price));

                    int number = Integer.parseInt(id.substring(1));

                    if (number >= nextId)
                        nextId = number + 1;
                }
            }

        } catch (IOException | NumberFormatException e) {
            System.out.println("Error loading inventory file.");
        }
    }

    static void saveItems() {
        try (PrintWriter pw =
                     new PrintWriter(new FileWriter(FILE_NAME))) {

            for (InventoryItem item : items) {
                pw.println(item.toFileString());
            }

        } catch (IOException e) {
            System.out.println("Error saving inventory file.");
        }
    }
}