package source;

import javax.swing.*;

/**
 * @author lenovo.
 *
 */
public class GameMap extends JFrame {

  GameMap() {
    super();
    this.setSize(25 * 15 + 1, 25 * 15 + 45);
    this.setTitle("LifeGame");
    this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
    this.setLocationRelativeTo(null);
  }

  /**
 * @param args ..
 */
  public static void main(final String[] args) {
    final GameLogic logic = new GameLogic();
    final GameTime timer = new GameTime(logic);
    final GameMap map = new GameMap();
    map.setVisible(true);
    map.add(timer);
    timer.starter();
  }

}
