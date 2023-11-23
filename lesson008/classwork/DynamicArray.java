public class DynamicArray {
    static
    public int minArraySize = 16;
    private int[] data;
    private int size;
    private int allocated;

    public DynamicArray(int sz) {
        this.size = sz;
        allocated = size <= minArraySize ? minArraySize : size + (size >> 2);

        data = new int[allocated];
    }
    public int getSize() {
        return size;
    }
    public int getAllocated() {
        return allocated;
    }
    public int get(int i) {
        return data[i];
    }
    public int set(int i, int value) {
        int prev;

        if(i < allocated)
            prev = data[i];
        else {
            grow(i + 1);
            prev = 0;
        }

        data[i] = value;
        return prev;
    }
    private int  grow(int newSize) {
        int  newAllocated = newSize + newSize >> 2;
        int[] newData = new int[newAllocated];

        for(int i = 0; i < size; ++i)
            newData[i] = data[i];

        data = newData;
        allocated = newAllocated;
        size = newSize;

        return allocated;
    }
}
