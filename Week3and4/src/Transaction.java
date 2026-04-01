public class Transaction {
    String id;
    double fee;
    String timestamp; // HH:MM



    Transaction(String id, double fee, String timestamp) {
        this.id = id;
        this.fee = fee;
        this.timestamp = timestamp;
    }
    @Override
    public String toString() {
        return "Transaction{" +
                "id='" + id + '\'' +
                ", fee=" + fee +
                ", timestamp='" + timestamp + '\'' +
                '}';
    }

}
