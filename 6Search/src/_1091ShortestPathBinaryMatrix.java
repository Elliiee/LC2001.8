import javafx.util.Pair;
import java.util.LinkedList;
import java.util.Queue;

public class _1091ShortestPathBinaryMatrix {

        public int shortestPathBinaryMatrix(int[][] grid) {
            if (grid == null || grid.length == 0 || grid[0].length == 0) return -1;

            int[][] directions = {{-1, -1}, {-1, 0}, {-1, 1}, {0, -1}, {0, 1},
                    {1, -1}, {1, 0}, {1, 1}};
            int m = grid.length, n = grid[0].length;
            Queue<Pair<Integer, Integer>> queue = new LinkedList<>();
            queue.add(new Pair<>(0, 0));
            int result = 0;

            while (!queue.isEmpty()){
                int size = queue.size();
                result++;
                while (size-- > 0){
                    Pair<Integer, Integer> cur = queue.poll();
                    int cr = cur.getKey(), cc = cur.getValue();
                    if (grid[cr][cc] == 1) continue;
                    if (cr == m-1 && cc == n-1)
                        return result;
                    grid[cr][cc] = 1;
                    for (int[] d : directions){
                        int nr = cr + d[0], nc = cc + d[1];
                        if (nr < 0 || nr >= m || nc < 0 || nc >= n)
                            continue;
                        queue.add(new Pair<>(nr, nc));
                    }
                }
            }
            return -1;
        }

}
