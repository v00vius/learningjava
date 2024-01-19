package maze3;

import java.util.List;

public class MazeMeshBuilder {
private final int cellSize;
private final int gridColor;
private final int waveColor;
private final int graphColor;

public MazeMeshBuilder(int cellSize, int gridColor, int waveColor, int graphColor)
{
        this.cellSize = cellSize;
        this.gridColor = gridColor;
        this.waveColor = waveColor;
        this.graphColor = graphColor;
}

public void createMesh(Maze2D maze)
{
        List<Maze2D.Edge> wave = maze.getWave();
        List<Maze2D.Edge> graph = maze.getGraph();

        createGrid();
        createWave();
        createGraph();
}
private void createGrid()
{

}
private void createWave()
{

}
private void createGraph()
{

}
}
