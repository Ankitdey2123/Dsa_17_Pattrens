class Solution {
    public int minMoves(String[] classroom, int energy) {
        int m = classroom.length;
        int n = classroom[0].length();

        int[][] arr = new int[m][n];

        for (int row = 0; row < m; row++) {
            Arrays.fill(arr[row], -1);
        }

        int lcount = 0;
        int startrow = 0;
        int startcol = 0;

        // Find L and S
        for (int row = 0; row < m; row++) {
            for (int col = 0; col < n; col++) {

                if (classroom[row].charAt(col) == 'L') {
                    arr[row][col] = lcount;
                    lcount++;
                }

                if (classroom[row].charAt(col) == 'S') {
                    startrow = row;
                    startcol = col;
                }
            }
        }

        int targetMask = (1 << lcount) - 1;

        class State {
            int row, col, cuEnergy, mask, moves;

            State(int row, int col, int cuEnergy, int mask, int moves) {
                this.row = row;
                this.col = col;
                this.cuEnergy = cuEnergy;
                this.mask = mask;
                this.moves = moves;
            }
        }

        // visited[row][col][energy][mask]
        boolean[][][][] visited = new boolean[m][n][energy + 1][1 << lcount];

        Queue<State> queue = new LinkedList<>();

        // Initial state
        queue.offer(new State(startrow, startcol, energy, 0, 0));

        visited[startrow][startcol][energy][0] = true;

        // 4 directions
        int[] dr = { -1, 1, 0, 0 };
        int[] dc = { 0, 0, -1, 1 };

        while (!queue.isEmpty()) {

            State current = queue.poll();

            // All litter collected
            if (current.mask == targetMask) {
                return current.moves;
            }

            for (int i = 0; i < 4; i++) {

                int newrow = current.row + dr[i];
                int newcol = current.col + dc[i];

                // Outside the grid
                if (newrow < 0 || newrow >= m ||
                        newcol < 0 || newcol >= n) {
                    continue;
                }

                // Obstacle
                if (classroom[newrow].charAt(newcol) == 'X') {
                    continue;
                }

                // No energy
                if (current.cuEnergy == 0) {
                    continue;
                }

                // Moving costs 1 energy
                int newEnergy = current.cuEnergy - 1;

                // Recharge
                if (classroom[newrow].charAt(newcol) == 'R') {
                    newEnergy = energy;
                }

                // Current mask
                int newMask = current.mask;

                // Collect litter
                if (arr[newrow][newcol] != -1) {

                    int litterId = arr[newrow][newcol];

                    newMask = newMask | (1 << litterId);
                }

                // Already visited this exact state
                if (visited[newrow][newcol][newEnergy][newMask]) {
                    continue;
                }

                // Mark visited
                visited[newrow][newcol][newEnergy][newMask] = true;

                // Add new state
                queue.offer(
                        new State(
                                newrow,
                                newcol,
                                newEnergy,
                                newMask,
                                current.moves + 1));
            }
        }

        return -1;
    }

}