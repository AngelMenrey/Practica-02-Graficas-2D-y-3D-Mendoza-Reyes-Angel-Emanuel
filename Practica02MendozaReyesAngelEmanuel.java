import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Polygon;

public class Practica02MendozaReyesAngelEmanuel {
    public static void main(String[] args) {
        JFrame ventana = new JFrame("Práctica 02 - Paisaje con figuras geométricas");
        Paisaje paisaje = new Paisaje();
        ventana.add(paisaje);
        ventana.setSize(800, 600);
        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ventana.setVisible(true);
        ventana.setLocationRelativeTo(null);
    }
}

class Paisaje extends JPanel {
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        this.setBackground(new Color(135, 206, 235));
        
        g.setColor(Color.GREEN);
        g.fillRect(0, getHeight() - 100, getWidth(), 100);
        
        int casaAncho = 100;
        int casaAlto = 100;
        int casaX = 50;
        int casaY = getHeight() - 200;
        
        g.setColor(new Color(139, 69, 19));
        g.fillRect(casaX, casaY, casaAncho, casaAlto);
        
        g.setColor(new Color(210, 180, 140));
        g.fillRect(casaX + 35, casaY + 40, 30, 60);
        
        g.setColor(new Color(139, 69, 19));
        g.fillOval(casaX + 55, casaY + 65, 5, 5);
        
        g.setColor(new Color(135, 206, 235));
        g.fillOval(casaX + 40, casaY + 5, 20, 20);
        
        g.setColor(new Color(139, 69, 19));
        g.drawLine(casaX + 50, casaY + 5, casaX + 50, casaY + 25);
        g.drawLine(casaX + 40, casaY + 15, casaX + 60, casaY + 15);
        
        g.setColor(new Color(255, 140, 0));
        Polygon techo = new Polygon();
        techo.addPoint(casaX, casaY);
        techo.addPoint(casaX + casaAncho / 2, casaY - casaAlto / 2);
        techo.addPoint(casaX + casaAncho, casaY);
        g.fillPolygon(techo);
        
        int solX = 600;
        int solY = 100;
        int solRadio = 40;
        
        g.setColor(Color.YELLOW);
        g.fillOval(solX - solRadio, solY - solRadio, solRadio * 2, solRadio * 2);
        
        Graphics2D g2d = (Graphics2D) g;
        g2d.setColor(Color.YELLOW);
        float[] patronGuiones = {10, 10};
        g2d.setStroke(new BasicStroke(3, BasicStroke.CAP_BUTT, BasicStroke.JOIN_MITER, 10, patronGuiones, 0));
        
        int rayoLongitud = 60;
        for (int i = 0; i < 360; i += 30) {
            double angulo = Math.toRadians(i);
            int x1 = (int) (solX + solRadio * Math.cos(angulo));
            int y1 = (int) (solY + solRadio * Math.sin(angulo));
            int x2 = (int) (solX + (solRadio + rayoLongitud) * Math.cos(angulo));
            int y2 = (int) (solY + (solRadio + rayoLongitud) * Math.sin(angulo));
            g2d.drawLine(x1, y1, x2, y2);
        }
        
        int arcoAncho = 500;
        int arcoAlto = 520;
        int arcoGrosor = 10;
        int arcoY = getHeight() - 105;
        
        Color[] coloresArcoiris = {Color.RED, Color.ORANGE, Color.YELLOW, Color.GREEN, Color.BLUE, new Color(75, 0, 130), new Color(143, 0, 255)};
        
        for (Color color : coloresArcoiris) {
            g2d.setColor(color);
            g2d.setStroke(new BasicStroke(arcoGrosor));
            g2d.drawArc(getWidth() - arcoAncho, arcoY - arcoAlto / 2, arcoAncho, arcoAlto, 0, 180);
            arcoAncho -= arcoGrosor;
            arcoAlto -= arcoGrosor;
        }
    }
}