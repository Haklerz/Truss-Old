package com.haklerz.truss;

import java.awt.BorderLayout;
import java.awt.Canvas;
import java.awt.Dimension;
import java.awt.Graphics2D;
import java.awt.image.BufferStrategy;

import javax.swing.JFrame;

public class Runner {

    private final Game game;
    private Canvas canvas;

    public Runner(Game game) {
        this.game = game;
    }

    public void run() {
        initialize();

        while (true) {
            game.update(0);

            render();

            try {
                Thread.sleep(17);
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
    }

    private void render() {
        BufferStrategy bs = canvas.getBufferStrategy();

        if (bs != null) {
            Graphics2D g = (Graphics2D) bs.getDrawGraphics();

            game.draw(g);

            g.dispose();
            bs.show();
        }
        else {
            canvas.createBufferStrategy(3);
            canvas.requestFocus();
        }
    }

    private void initialize() {
        Settings settings = new Settings();
        settings.setResolution(640, 360);
        settings.setTitle("Truss");

        game.setup(settings);

        canvas = new Canvas();
        Dimension size = new Dimension(settings.getWidth(), settings.getHeight());
        canvas.setMaximumSize(size);
        canvas.setMinimumSize(size);
        canvas.setPreferredSize(size);

        JFrame frame = new JFrame(settings.getTitle());
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new BorderLayout());
        frame.add(canvas, BorderLayout.CENTER);
        frame.pack();
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);

        frame.setVisible(true);
    }
}