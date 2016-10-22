package source;

/**
 * @author lenovo.
 *
 */
public class GameLogic {
  /**
 * ��ǰ״̬.
 */
  private boolean [][]presentMap;
  /**
 * ��һ״̬.
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
 * ��.
 */
  public void update() {
    for (int r = 1; r <= 25; r++) {
      for (int c = 1; c <= 25; c++) {
        presentMap[r][c] = nextMap[r][c];
      }
    }
  }

  /**
 * @param row Ŀ��ϸ����.
 * @param col Ŀ��ϸ����.
 * @return ������Χ��ϸ����.
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
 * @param row ϸ��������.
 * @param col ϸ��������
 * @return ����ϸ��״̬
 */
  public boolean get(final int row,final int col) {
    return presentMap[row][col];
  }

  /**
 * @param row ����ϸ����������.
 * @param col ����ϸ����������.
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
