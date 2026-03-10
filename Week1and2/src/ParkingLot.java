/**
 * ParkingLot
 *
 * Description:
 * Implements a parking system using hash table
 * with open addressing and linear probing.
 */

public class ParkingLot {

    private String[] spots;
    private int size;

    public ParkingLot(int size) {

        this.size = size;
        spots = new String[size];
    }

    private int hash(String plate) {

        return Math.abs(plate.hashCode()) % size;
    }

    public int parkVehicle(String plate) {

        int index = hash(plate);

        while (spots[index] != null) {

            index = (index + 1) % size;
        }

        spots[index] = plate;

        return index;
    }

    public void exitVehicle(String plate) {

        int index = hash(plate);

        while (spots[index] != null) {

            if (spots[index].equals(plate)) {

                spots[index] = null;
                return;
            }

            index = (index + 1) % size;
        }
    }
}