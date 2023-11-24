package arrays1;

import java.util.Random;
//
// Dynamic Array of int (integers)
// Usege:
// to create an empty array:
//   DynamicArray array = DynamicArray();
// to set 100-th elemet to a value of 21 (array grows automatically):
//    array.set(100, 21)
// to get an i-th Element:
//    int value = array.get(i);
// 
public class DynamicArray {
    static
    public int minArraySize = 16;
    private int[] data;
    private int size;           // size (logical) of an array
    private int allocated;      // real (allocated) size of an array

    // an empty array
    public DynamicArray() {
        lowLevelInit(null, 0);
    }
    // an array of sz elements
    public DynamicArray(int sz) {
        lowLevelInit(null, sz);
    }
    // an array initialized by an existing 'array'. 'array' can be null
    public DynamicArray(int[] array) {
        lowLevelInit(array, 0);
    }
    
    private void lowLevelInit(int[] array, int sz) {
        size = (array == null) ? sz : array.length;
        allocated = (size <= minArraySize) ? minArraySize : (size + (size >> 2));
        data = new int[allocated];

        if(array != null) {
            for (int i = 0; i < size; i++)
                data[i] = array[i];
        }
    }

    // fill (0..nElements - 1) of random numbers in (0 .. range - 1)
    public DynamicArray fillRandom(int nElements, int range) {
        Random rnd = new Random();

        for (int i = 0; i < nElements;)
            set(i++, rnd.nextInt(range));

        return this;
    }

    // check if all alements are unique
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
    // get averago of elements
    public int avg() {
        int sum = 0;

        for (int i = 0; i < getSize(); ++i) {
            sum += get(i);
        }

        return sum / getSize();
    }
    // reverse an array in the place (do not create new one)
    public DynamicArray reverse() {
        for (int i = 0; i < getSize() / 2; i++) {
            int tmp = get(i);

            set(i, get(getSize() - 1 - i));
            set(getSize() - 1 - i, tmp);
        }

        return this;
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
    // get logical size
    public int getSize() {
        return size;
    }
    // get size of storage
    public int getAllocated() {
        return allocated;
    }
    //
    // get a value at the index i
    public int get(int i) {
        return data[i];
    }
    // increment i-th element (returns previous value)
    public int inc(int i) {
        return data[i]++;
    }
    // decrement i-th element (returns previous value)
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
