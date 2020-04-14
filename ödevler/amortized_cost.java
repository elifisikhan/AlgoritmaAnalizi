import java.util.Arrays;

public class dynArrMain {
    public static void main(String[] args) {
        dynArr dynamicArray = new dynArr();
        dynamicArray.append(5);
        dynamicArray.append(8);
        dynamicArray.append(12);
        dynamicArray.append(56);
        dynamicArray.append(9);
        System.out.println("\n" +dynamicArray+ "\n\n");
        dynamicArray.remove();
        dynamicArray.remove();
        dynamicArray.remove();
        dynamicArray.remove();
        dynamicArray.remove();
        System.out.println("\n" +dynamicArray+ "\n");
    }
}

class dynArr {
    private int size = 1;
    private int a[] = new int[size];
    private int capacity = 0;

    public void append(int data) {
        if (capacity == size) {
            System.out.println("amortized cost işlemi ...  " + size);
            size = 2 * size;
            int[] temp = new int[size];
            System.arraycopy(a, 0, temp, 0, a.length);
            System.out.println("move işlemi...");
            a = temp;
        }
        a[capacity] = data;
        capacity++;
    }

    public void remove() {
        if (capacity > 0) {
            capacity--;
            a[capacity] = 0;
        }
        if (capacity == size / 4) {
            System.out.println("kapasiteyi azaltma işlemi ...  " + size);
            size = size / 2;
            int[] temp = new int[size];
            System.arraycopy(a, 0, temp, 0, temp.length);
            System.out.println("move işlemi...");
            a = temp;
        }
    }
    @Override
    public String toString() {
        return "DynamicArray{" +
                "size=" + size +
                ", a=" + Arrays.toString(a) +
                ", capacity=" + capacity +
                '}';
    }
}