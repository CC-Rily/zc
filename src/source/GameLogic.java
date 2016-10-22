package source;

/**
 * @author lenovo.
 *
 */
public class GameLogic {
  /**
 * 当前状态.
 */
  private boolean [][]presentMap;
  /**
 * 下一状态.
 */
  private boolean [][]nextMap;

  GameLogic() {
    presentMap = new boolean[27][27];
    nextMap = new boolean[27][27];

    int col;
    int row;

    for (col = 7; col < 19; col++) {
      for (row = 7; row < 19; row++) {
        presentMap[row][col] = true;
      }
    }
  }

  /**
 * 无.
 */
  public void update() {
    for (int r = 1; r <= 25; r++) {
      for (int c = 1; c <= 25; c++) {
        presentMap[r][c] = nextMap[r][c];
      }
    }
  }

  /**
 * @param row 目标细胞行.
 * @param col 目标细胞列.
 * @return 返回周围活细胞数.
 */
  public int get_neighbor_count(final int row, final int col) {
    int counter = 0;
    for (int r = -1; r <= 1; r++) {
      for (int c = -1; c <= 1; c++) {
        if (r != 0 || c != 0) {
          if (get(row + r, col + c)) {
            counter++;
          }
        }
      }
    }
    return counter;
  }

  /**
 * @param row 细胞所在行.
 * @param col 细胞所在咧
 * @return 返回细胞状态
 */
  public boolean get(final int row,final int col) {
    return presentMap[row][col];
  }

  /**
 * @param row 设置细胞的所在行.
 * @param col 设置细胞的所在列.
 */
  public void set(final int row, final int col) {
    switch (get_neighbor_count(row, col)) {

      case 2:
        nextMap[row][col] = presentMap[row][col];
        break;
      case 3:
        nextMap[row][col] = true;
        break;
      default:
        nextMap[row][col] = false;
        break;
    }
  }

}
