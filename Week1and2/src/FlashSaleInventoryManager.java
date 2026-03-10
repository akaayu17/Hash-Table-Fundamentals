import java.util.*;

class FlashSale {

    private HashMap<String, Integer> stockMap = new HashMap<>();


    private HashMap<String, Queue<Integer>> waitingList = new HashMap<>();

    public void addProduct(String productId, int stock) {
        stockMap.put(productId, stock);
        waitingList.put(productId, new LinkedList<>());
    }


    public int checkStock(String productId) {
        return stockMap.getOrDefault(productId, 0);
    }

    public synchronized void purchaseItem(String productId, int userId) {

        int stock = stockMap.getOrDefault(productId, 0);

        if (stock > 0) {
            stockMap.put(productId, stock - 1);
            System.out.println("User " + userId + " purchase SUCCESS. Remaining stock: " + (stock - 1));
        } else {
            Queue<Integer> queue = waitingList.get(productId);
            queue.add(userId);
            System.out.println("User " + userId + " added to WAITING LIST. Position: " + queue.size());
        }
    }

    public synchronized void restock(String productId, int quantity) {

        int stock = stockMap.getOrDefault(productId, 0);
        stock += quantity;
        stockMap.put(productId, stock);

        Queue<Integer> queue = waitingList.get(productId);

        while (stock > 0 && !queue.isEmpty()) {
            int user = queue.poll();
            stock--;
            stockMap.put(productId, stock);
            System.out.println("Waiting user " + user + " purchase SUCCESS. Remaining stock: " + stock);
        }
    }

    public static void main(String[] args) {

        FlashSaleInventoryManager manager = new FlashSaleInventoryManager();


        manager.addProduct("IPHONE15_256GB", 3);

        System.out.println("Stock Available: " + manager.checkStock("IPHONE15_256GB"));

        manager.purchaseItem("IPHONE15_256GB", 101);
        manager.purchaseItem("IPHONE15_256GB", 102);
        manager.purchaseItem("IPHONE15_256GB", 103);


        manager.purchaseItem("IPHONE15_256GB", 104);
        manager.purchaseItem("IPHONE15_256GB", 105);


        manager.restock("IPHONE15_256GB", 2);
    }
}