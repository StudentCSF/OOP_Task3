package main;

import objects.MyCut;
import objects.MyPolygon;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.List;

public class DrawPanel extends JPanel {
    private MyPolygon polygon = null;

    @Override
    public void paint(Graphics g) {
        BufferedImage bi = new BufferedImage(getWidth(), getHeight(), BufferedImage.TYPE_INT_RGB);
        Graphics2D gr = bi.createGraphics();
        gr.setColor(Color.WHITE);
        gr.fillRect(0, 0, getWidth(), getHeight());
        drawPolygon(gr);
        gr.dispose();
        g.drawImage(bi, 0, 0, null);
    }

    public void setPolygon(MyPolygon polygon) {
        this.polygon = polygon;
        repaint();
    }

    public MyPolygon getPolygon() {
        return polygon;
    }

    private void drawPolygon(Graphics2D gr) {
        if (polygon == null) return;
        gr.setColor(polygon.getColor());
        List<MyCut> list = polygon.getEdges();
        for (MyCut myCut : list) {
            gr.drawLine(myCut.getP1().getX(), myCut.getP1().getY(), myCut.getP2().getX(), myCut.getP2().getY());
        }
    }
}
