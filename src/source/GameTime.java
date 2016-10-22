package source;

import java.awt.Graphics;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.JPanel;


/**
 * @author lenovo.
 *
 */
public class GameTime extends JPanel {
  /**
   * @author lenovo.
   *
   */
  private final GameLogic logic;

  GameTime(final GameLogic gameL) {
    super();
    logic = gameL;
  }

  /**
 * ��ͼ���и�������.
 */
  public void mapallset() {
    for (int r = 1; r <= 25; r++) {
      for (int c = 1; c <= 25; c++) {
        logic.set(r, c);
      }
    }
  }
 
  /**
   * @author lenovo.
   *
   */ 
  public void next2present() {
    mapallset();
    logic.update();
  }
  
  @Override
  /**
   * ��.
   */
  protected void paintComponent(final Graphics graphics) {

    super.paintComponent(graphics);
    for (int r = 1; r <= 25; r++) {
      for (int c = 1; c <= 25; c++) {
        if (logic.get(r, c)) {
          graphics.fillRect((c - 1) * 15, (r - 1) * 15, 15, 15);
        } else {
          graphics.drawRect((c - 1) * 15, (r - 1) * 15, 15, 15);
        }
      }
    }

  }

  /**
 * ��ʱ��ʼ.
 */
  public void starter() {
    final Timer timer = new Timer(true);
    timer.schedule(new TimerTask() {
      @Override
      /**
       * ��.
       */
      public void run() {
        next2present();
        
        repaint();
      }
    }, 600, 600);
  }
}
