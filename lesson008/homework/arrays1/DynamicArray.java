package arrays1;

import java.util.Random;

public class DynamicArray {
    static
    public int minArraySize = 16;
    private int[] data;
    private int size;           // size (logical) of an array
    private int allocated;      // real (allocated) size of an array

    private void lowLevelInit(int[] array, int sz) {
        size = (array == null) ? sz : array.length;
        allocated = (size <= minArraySize) ? minArraySize : (size + (size >> 2));
        data = new int[allocated];

        if(array != null) {
            for (int i = 0; i < size; i++)
                data[i] = array[i];
        }
    }
    public DynamicArray() {
        lowLevelInit(null, 0);
    }
    public DynamicArray(int sz) {
        lowLevelInit(null, sz);
    }
    public DynamicArray(int[] array) {
        lowLevelInit(array, 0);
    }

    public DynamicArray fillRandom(int nElements, int range) {
        Random rnd = new Random();

        for (int i = 0; i < nElements;)
            set(i++, rnd.nextInt(range));

        return this;
    }

    public boolean isUnique() {
        for (int i = 0; i < getSize() - 1; ++i) {
            int elem = get(i);

            for(int j = i + 1; j < getSize(); ++j) {
                if(elem == get(j))
                    return false;
            }
        }

        return true;
    }
    public int avg() {
        int sum = 0;

        for (int i = 0; i < getSize(); ++i) {
            sum += get(i);
        }

        return sum / getSize();
    }
    @Override
    public String toString() {
        String s = "arrays1.DynamicArray: size=" + size + ", allocated=" + allocated + " for storage\n";

        if(size == 0)
            return s + "{}";
        else
            s += "{";

        for (int i = 0; i < size ; i++) {
            s += get(i);

            if(i < size - 1)
                s += ", ";
        }

        s += "}";

        return s;
    }
    public int getSize() {
        return size;
    }
    public int getAllocated() {
        return allocated;
    }
    //
    // get a value at the index i
    public int get(int i) {
        return data[i];
    }
    public int inc(int i) {
        return data[i]++;
    }
    public int dec(int i) {
        return data[i]--;
    }
    //
    // set a value at the index i
    public int set(int i, int value) {
        int prev;

        if(i < size) {
            prev = data[i];
        }
        else if(i < allocated) {
                size = i + 1;
                prev = 0;
        }
        else {
            grow(i + 1);
            prev = 0;
        }

        data[i] = value;
        return prev;
    }
    //
    // add an element of the value to the end of the array
    // returns array size
    public int add(int value) {
        set(getSize(), value);

        return getSize();
    }
    //
    // grow an array to the size newSIze (logical)
    // returns allocated storage of elements
    private int  grow(int newSize) {
        int  newAllocated = newSize + (newSize >> 2);
        int[] newData = new int[newAllocated];

        for(int i = 0; i < size; ++i)
            newData[i] = data[i];

        data = newData;
        allocated = newAllocated;
        size = newSize;

        return allocated;
    }
}
