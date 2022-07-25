import javax.swing.*;
import java.awt.*;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.awt.geom.Line2D;


public class Face {

    static boolean resize = false;

    public static void main(String[] args) throws ArrayIndexOutOfBoundsException {
        JFrame frame = new JFrame();
        frame.setSize(640, 600);
        frame.setLocationRelativeTo(null);
        frame.setResizable(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
        Graphics g = frame.getGraphics();
        long startTime = System.currentTimeMillis();
        int j = 1;
        frame.getRootPane().addComponentListener(new ComponentAdapter() {
            public void componentResized(ComponentEvent e) {
                set();
            }
        });

        double t = 0;
        Graphics2D g2 = (Graphics2D) g;
        Dimension old = frame.getSize();
        while (1 == 1) {
            int width = frame.getWidth();
            int height = frame.getHeight();
            g2.translate(0, 0);
            g2.drawRoundRect(30, 30, frame.getWidth() - 60, frame.getHeight() - 60, 0, 0);
            if (resize) {
                g2.clearRect(0, 0, frame.getWidth(), frame.getHeight());
                resize = false;
            }

            if (height > width) {
                // TODO:
            }

            int widt = (int) (frame.getWidth() - 60) / 10;
            System.out.println(widt);
            g2.drawOval((frame.getWidth() - 60) / 2, (frame.getHeight() - 60) / 2, 50, 50);

            for (int i = 2; i < widt + 1; i++) {
                if (resize)
                    break;
                g2.drawLine(30, (widt - i) * 10, (i + 1) * 10, 30);
                g2.drawLine((i + 2) * 10, frame.getHeight() - 30, frame.getWidth() - 30, (widt - i + 1) * 10);
                g2.draw(new Line2D.Double(i, fun(i) * 10, i + 0.01, fun(i + 0.01)));
            }

            old = frame.getSize();


            Point p = MouseInfo.getPointerInfo().getLocation();
            double mouseX = p.getX() / 500.0;
            double mouseY = p.getY() / 500.0;
            Point p1 = MouseInfo.getPointerInfo().getLocation();


            //if(p1.getX() != p.getX() && p1.getY() != p.getY()) {
            //g.clearRect(0, 0, frame.getWidth(), frame.getHeight());
            for (float theta = 0; theta <= 2 * Math.PI; theta += 0.01) {
                double rad = r(theta, 1, 1, 1, 1, Math.sin(t), Math.sin(t));
                double x = rad * Math.cos(theta) * frame.getWidth() / 3 + frame.getWidth() / 2;
                double y = rad * Math.sin(theta) * frame.getHeight() / 3 + frame.getHeight() / 2;

                g2.draw(new Line2D.Double(x, y, x, y));

            }
            t += 0.1;
        }
        //}

    }

    //}
    //}
    public static double r(double theta, double a, double b, double m, double n1, double n2, double n3) {

        return Math.pow(Math.pow(Math.abs(Math.cos(m * theta / 4.0) / a), n2)
                + Math.pow(Math.abs(Math.sin(m * theta / 4.0) / b), n3), -1.0 / n1);
    }

    public static void set() {
        resize = true;
    }

    public static double fun(double z) {
        return Math.sin(z) + Math.exp(z) + 6;
    }


}