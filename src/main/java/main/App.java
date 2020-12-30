package main;

import objects.MyPolygon;
import services.generator.PolygonRandomGenerator;

import javax.swing.*;
import java.awt.*;

public class App {
    private JFrame frame;

    private DrawPanel drawPanel;
    private JPanel editPanel;

    private JTextField minY;
    private JTextField maxY;
    private JTextField minX;
    private JTextField maxX;
    private JTextField count;

    private JTextField square;
    {
        square = new JTextField();
    }

    private final JButton build;
    {
        build = new JButton("Build");
        build.addActionListener(e -> {
            String str = count.getText();
            int count = Integer.parseInt(str);

            str = minX.getText();
            int minX = Integer.parseInt(str);

            str = minY.getText();
            int minY = Integer.parseInt(str);

            str = maxX.getText();
            int maxX = Integer.parseInt(str);

            str = maxY.getText();
            int maxY = Integer.parseInt(str);

            PolygonRandomGenerator prg = new PolygonRandomGenerator();
            MyPolygon polygon = prg.create(count, minX, maxX, minY, maxY);
            drawPanel.setPolygon(polygon);
        });
    }

    private final JButton sq;
    {
        sq = new JButton("Square");
        sq.addActionListener(e -> {
            MyPolygon pol = drawPanel.getPolygon();
            square.setText(Double.toString(pol.square()));
        });
    }

    public App() {
        setFrame();
        initComponents();
        frame.add(drawPanel);
        frame.add(editPanel);
    }

    private void setFrame() {
        frame = new JFrame("Polygon generator");
        frame.setSize(1400, 800);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.setLayout(null);
        frame.setResizable(true);
        frame.setFocusable(true);
    }

    private void initComponents() {
        drawPanel = new DrawPanel();
        editPanel = new JPanel();
        setEditPanel();
        drawPanel.setLayout(null);
        drawPanel.setBounds(frame.getWidth() / 5, 0, 4 * frame.getWidth() / 5, frame.getHeight());
    }

    private void setEditPanel() {
        editPanel.setBounds(0, 0, frame.getWidth() / 5, frame.getHeight());
        editPanel.setLayout(new GridLayout(8, 1));

        JPanel p1;
        p1 = new JPanel();
        count = new JTextField();
        count.setPreferredSize(new Dimension(40, 20));
        p1.add(new JLabel("Vertex count:"));
        p1.add(count);
        editPanel.add(p1);

        p1 = new JPanel();
        minX = new JTextField();
        minX.setPreferredSize(new Dimension(40, 20));
        p1.add(new JLabel("Min X:"));
        p1.add(minX);
        editPanel.add(p1);

        p1 = new JPanel();
        maxX = new JTextField();
        maxX.setPreferredSize(new Dimension(40, 20));
        p1.add(new JLabel("Max X:"));
        p1.add(maxX);
        editPanel.add(p1);

        p1 = new JPanel();
        minY = new JTextField();
        minY.setPreferredSize(new Dimension(40, 20));
        p1.add(new JLabel("Min Y:"));
        p1.add(minY);
        editPanel.add(p1);

        p1 = new JPanel();
        maxY = new JTextField();
        maxY.setPreferredSize(new Dimension(40, 20));
        p1.add(new JLabel("Max Y:"));
        p1.add(maxY);
        editPanel.add(p1);

        editPanel.add(build);

        editPanel.add(sq);
        editPanel.add(square);
    }

    public void show() {
        frame.setVisible(true);
    }


}
