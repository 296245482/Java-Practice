package practice.lru;

/**
 * 使用数组实现的LRU算法，刚使用的放在数组最后，主要考察元素是否已经存在和缓存是否已满这两种情况，使用与否只考察了set，没考察get
 */
public class MyArrayLRU {
    /**
     * 计数
     */
    private static int count = 0;
    /**
     * 已有元素个数
     */
    private static int size = 0;
    /**
     * 缓存大小
     */
    private int maxSize;
    /**
     * 使用数组存储元素
     */
    private int[] listArray;

    public MyArrayLRU(int max) {
        listArray = new int[max];
        this.maxSize = max;
    }

    public int getSize() {
        return size;
    }

    public Object get(int index) {
        return listArray[index];
    }

    private void moveArrayElement(int[] arr, int start, int end) {
        for (int i = start; i <= end; i++) {
            arr[i] = arr[i + 1];
        }
    }

    public void insert(int item) {
        //第一步查看是否已存在
        boolean exist = false;
        int existLocation = 0;
        for (int i = 0; i < maxSize; i++) {
            if (item == listArray[i]) {
                exist = true;
                existLocation = i;
            }
        }

        // 分情况查看是否已经满了
        if (size < maxSize) {
            if (exist) {
                if (existLocation < size - 1) {
                    moveArrayElement(listArray, existLocation, size - 2);
                }
                listArray[size - 1] = item;
            } else {
                listArray[size] = item;
                size++;
            }
        } else {
            if (!exist || item == listArray[0]) {
                moveArrayElement(listArray, 0, maxSize - 2);
            } else if (item != listArray[maxSize - 1]) {
                moveArrayElement(listArray, existLocation, maxSize - 2);
            }
            listArray[maxSize - 1] = item;
        }
        count++;
    }

    // 测试
    public static void main(String[] args) {
        int cacheSize = 5;
        MyArrayLRU lru = new MyArrayLRU(cacheSize);
        try {
            lru.insert(1);
            lru.insert(2);
            lru.insert(3);
            lru.insert(4);
            lru.insert(5);
            lru.insert(2);
            lru.insert(3);
            lru.insert(5);
            lru.insert(4);
            lru.insert(4);
            lru.insert(5);
            lru.insert(1);
            for (int i = 0; i < cacheSize; i++) {
                System.out.println(lru.get(i));
            }
            System.out.println("成功插入" + count + "次元素.");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}


