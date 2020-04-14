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
    private int capacity = 1;
    private int a[] = new int[capacity];
    private int data = 0;

    public void append(int e) {
        if (data== capacity) {
            System.out.println("amortized cost işlemi ...  " + capacity);
            capacity = 2 * capacity;
            int[] temp = new int[capacity];
            System.arraycopy(a, 0, temp, 0, a.length);
            System.out.println("move işlemi...");
            a = temp;
        }
        a[data] = e;
        data++;
    }

    public void remove() {
        if (data > 0) {
            data--;
            a[data] = 0;
        }
        if (data == capacity / 4) {
            System.out.println("kapasiteyi azaltma işlemi ...  " + capacity);
            capacity = capacity / 2;
            int[] temp = new int[capacity];
            System.arraycopy(a, 0, temp, 0, temp.length);
            System.out.println("move işlemi...");
            a = temp;
        }
    }
    @Override
    public String toString() {
        return "DynamicArray{" +
                "capacity=" + capacity +
                ", a=" + Arrays.toString(a) +
                ", data=" + data +
                '}';
    }
}

/* 

Çıktı 


amortized cost işlemi ...  1
move işlemi...
amortized cost işlemi ...  2
move işlemi...
amortized cost işlemi ...  4
move işlemi...

DynamicArray{capacity=8, a=[5, 8, 12, 56, 9, 0, 0, 0], data=5}


kapasiteyi azaltma işlemi ...  8
move işlemi...
kapasiteyi azaltma işlemi ...  4
move işlemi...
kapasiteyi azaltma işlemi ...  2
move işlemi...

DynamicArray{capacity=1, a=[0], data=0}



*/
