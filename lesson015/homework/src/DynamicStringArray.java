public class DynamicStringArray {
    private String[] data;

    public DynamicStringArray() {
        data = new String[0];
    }

    public DynamicStringArray add(String str) {
        grow();
        data[data.length - 1] = str;

        return this;
    }
    public DynamicStringArray add(String[] strings) {
        int prevSize  = grow(strings.length);

        for (int i = 0; i < strings.length; i++) {
            data[prevSize + i] = strings[i];
        }

        return this;
    }

    public String[] getData() {
        return data;
    }
    public int getSize() {
        return data.length;
    }

    private int grow() {
        return grow(1);
    }
    private int grow(int delta) {
        String[] newData = new String[data.length + delta];
        int prevSize = data.length;

        for (int i = 0; i < data.length; ++i) {
            newData[i] = data[i];
        }

        data = newData;

        return prevSize;
    }
}
