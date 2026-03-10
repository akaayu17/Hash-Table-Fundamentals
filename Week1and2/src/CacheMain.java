/**
 * CacheMain
 *
 * Driver program to test multi-level cache behavior.
 */

public class CacheMain {

    public static void main(String[] args) {

        MultiLevelCache cache = new MultiLevelCache();

        System.out.println(cache.getVideo("video1"));
        System.out.println(cache.getVideo("video1"));
    }
}