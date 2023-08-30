package com.allef.view.components;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JLabel;
import javax.swing.Timer;

public class Animation {
    public void smoothMove(JLabel label, int startX, int startY, int endX, int endY, int duration) {
        int totalSteps = duration / 20;
        int stepX = (endX - startX) / totalSteps;
        int stepY = (endY - startY) / totalSteps;

        Timer timer = new Timer(20, new ActionListener() {
            int currentStep = 0;

            @Override
            public void actionPerformed(ActionEvent e) {
                int newX = startX + stepX * currentStep;
                int newY = startY + stepY * currentStep;

                label.setLocation(newX, newY);

                currentStep++;

                if (currentStep >= totalSteps) {
                    ((Timer) e.getSource()).stop();
                }
            }
        });

        timer.start();
    }
}
