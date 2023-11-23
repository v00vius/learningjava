public class DynamicStringArray {
    static
    public int minArraySize = 16;
    private String[] data;
    private int size;           // size (logical) of an array
    private int allocated;      // real (allocated) size of an array

    private void lowLevelInit(String[] array, int sz) {
        size = (array == null) ? sz : array.length;
        allocated = (size <= minArraySize) ? minArraySize : (size + (size >> 2));
        data = new String[allocated];

        if(array != null) {
            for (int i = 0; i < size; i++)
                data[i] = array[i];
        }
    }
    public DynamicStringArray() {
        lowLevelInit(null, 0);
    }
    public DynamicStringArray(int sz) {
        lowLevelInit(null, sz);
    }
    public DynamicStringArray(String[] array) {
        lowLevelInit(array, 0);
    }
    @Override
    public String toString() {
        String s = "DynamicStringArray: size=" + size + ", allocated=" + allocated + " for storage\n";

        if(size == 0)
            return s + "{}";
        else
            s += "{\n";

        for (int i = 0; i < size ; i++) {
            s += "\t\"" + get(i) + "\"";

            if(i < size - 1)
                s += ",\n";
        }

        s += "\n}";

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
    public String get(int i) {
        return data[i];
    }
    //
    // set a value at the index i
    public String set(int i, String value) {
        String prev;

        if(i < size) {
            prev = data[i];
        }
        else if(i < allocated) {
            size = i + 1;
            prev = null;
        }
        else {
            grow(i + 1);
            prev = null;
        }

        data[i] = value;
        return prev;
    }
    public int add(String s) {
        set(getSize(), s);

        return getSize();
    }
    //
    // grow an array to the size newSIze (logical)
    private int  grow(int newSize) {
        int  newAllocated = newSize + (newSize >> 2);
        String[] newData = new String[newAllocated];

        for(int i = 0; i < size; ++i)
            newData[i] = data[i];

        data = newData;
        allocated = newAllocated;
        size = newSize;

        return allocated;
    }
}
