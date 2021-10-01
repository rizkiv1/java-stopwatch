package com.java.stopwatch;

import javax.swing.*;
//import java.awt.*;
//import java.util.Timer;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
//import java.util.TimerTask;
 
public class Stopwatch extends JFrame{
    private JPanel MainPane;
    private JLabel Title;
    private JTextField TFTimer;
    private JButton Start;
    private JButton Pause;
    private JButton Reset;
    private int seconds, minutes, hours, mili;
    private final Timer timer;

    public Stopwatch() {
//        this.pack();
        mili = seconds = minutes =  hours = 0;
        timer = new Timer(100, new ActionListener(){
            //        @Override
            public void actionPerformed(ActionEvent e) {
                mili++;
                if(mili == 10){
                    seconds++;
                    mili = 0;
                }
//                seconds++;
                if(seconds >= 60) {
                    seconds = 0;
                    minutes++;
                }
                if(minutes >= 60) {
                    minutes = 0;
                    hours++;
                }
                TFTimer.setText(String.format("%d:%02d:%02d:%d", hours, minutes, seconds, mili));
            }
        });

        Start.addMouseListener(new MouseAdapter() {
            /**
             * {@inheritDoc}
             *
             * @param e
             */
            @Override
            public void mouseReleased(MouseEvent e) {
                super.mouseReleased(e);
//                if(timer.isRunning() == true) return;
                Start.setEnabled(false);
                Pause.setEnabled(true);
                timer.start();
            }
        });
        Pause.addMouseListener(new MouseAdapter() {
            /**
             * {@inheritDoc}
             * 
             * @param e
             */
            @Override
            public void mouseReleased(MouseEvent e) {
                super.mouseReleased(e);
//                if(timer.isRunning() == false) return;
                Pause.setEnabled(false);
                Start.setEnabled(true);
                timer.stop();
            }
        });
        Reset.addMouseListener(new MouseAdapter() {
            /**
             * {@inheritDoc}
             *
             * @param e
             */
            @Override
            public void mouseReleased(MouseEvent e) {
                super.mouseReleased(e);
                seconds = minutes = hours = 0;
                TFTimer.setText("0:00:00:00");
            }
        });
        Reset.addMouseListener(new MouseAdapter() {
        });
    }

    public static void main(String[] Args) {
        Stopwatch app = new Stopwatch();
        app.setContentPane(new Stopwatch().MainPane);
        app.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        app.pack();
        app.setVisible(true);

//        mainStopwatch.setTitle("Ini Stopwatch");
//        mainStopwatch.setSize(600, 400);
//        mainStopwatch.setLocationRelativeTo(null);
//        mainStopwatch.setVisible(true);
    }
}
