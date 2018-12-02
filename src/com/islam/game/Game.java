package com.islam.game;

import javax.swing.*;
import java.awt.*;
import java.awt.Dimension;
import java.awt.image.BufferStrategy;

public class Game extends Canvas implements Runnable {

    private static final long serialVersionUID = 6273365517518954804L;
    public static int width = 300;
    public static int height = width / 16*9;
    public static int scale = 3;

    private Thread thread;
    private boolean running = false;
    private JFrame frame;

    public Game(){
        Dimension size = new Dimension(width*scale , height*scale);
        setPreferredSize(size);
        frame = new JFrame();

    }

    public synchronized  void start(){
        running = true;
        thread = new Thread(this);
        thread.start();
    }

    public synchronized void stop(){
        running = false;
        try {
            thread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void run(){

        while (running){
            render();
            update();
        }
    }

    private void render() {
        BufferStrategy buffer = getBufferStrategy();
        if(buffer == null){
            createBufferStrategy(3);
            return;

        }
    }

    private void update(){


    }

    @Override
    public void run() {
        while (running){
            System.out.println("Запускается ... ");

        }

    }

    public static void main(String[] args) {
        Game game = new Game();
        game.frame.setResizable(false);
        game.frame.setTitle("Fury of the ancients");
        game.frame.add(game);
        game.frame.pack();
        game.frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        game.frame.setLocationRelativeTo(null);
        game.frame.setVisible(true);
        game.start();
    }






}