package task3;

import java.util.List;

public interface CSV {
        void initData(List<String> lines);
        void initHeader(String headerLine);
        Cell get(int row, int column);
        Cell get(int row, String columName);
        List<Cell> getColumn(int i);
        List<Cell> getColumn(String name);
}
