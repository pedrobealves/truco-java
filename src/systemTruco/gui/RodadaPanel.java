package systemTruco.gui;

import javax.swing.*;
import java.awt.*;

public class RodadaPanel extends JPanel {

    public void paint(Graphics g) {
        setSize(500, 500);
        g.drawOval(100, 100, 50, 50);
        g.setColor(Color.GREEN);
    }

    public RodadaPanel() {
        super();
        update();
    }

    public void update() {
        this.removeAll();
        this.revalidate();
        this.setLayout(new FlowLayout());
        this.setOpaque(false);
    }
}
