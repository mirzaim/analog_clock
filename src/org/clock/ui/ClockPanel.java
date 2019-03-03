package org.clock.ui;

import javax.swing.*;
import java.awt.*;

class ClockPanel extends JPanel {

    /**
     * The coordinates used to paint the clock hands.
     */
    private int xHandSec, yHandSec, xHandMin, yHandMin, xHandHour, yHandHour;

    /**
     * The size of the clock.
     */
    private final int HORIZONTAL_SIZE = 500;
    private final int VERTICAL_SIZE = 500;

    private final static Color GRAY_COLOR = new Color(160, 160, 160);
    private static final Color BACKGROUND_COLOR = new Color(24, 116, 205);

    private int second;
    private int minute;
    private int hour;

    /**
     * creates clock container, initialize background and size
     */
    ClockPanel() {
        setMinimumSize(new Dimension(HORIZONTAL_SIZE, VERTICAL_SIZE));
        setMaximumSize(new Dimension(HORIZONTAL_SIZE, VERTICAL_SIZE));
        setPreferredSize(new Dimension(HORIZONTAL_SIZE, VERTICAL_SIZE));
        setBackground(BACKGROUND_COLOR);
        setLayout(null);
    }

    /**
     * set seconds
     *
     * @param second second value
     */
    void setSecond(int second) {
        this.second = second;
    }

    /**
     * set minute
     *
     * @param minute minute value
     */
    void setMinute(int minute) {
        this.minute = minute;
    }

    /**
     * set hour
     *
     * @param hour hour value
     */
    void setHour(int hour) {
        this.hour = hour;
    }

    /**
     * recalculates the coordinates of the clock hands,
     * and repaint everything.
     */
    void draw() {
        int secondHandLength = HORIZONTAL_SIZE / 2 - 50;
        xHandSec = minToLocation(second, secondHandLength).x;
        yHandSec = minToLocation(second, secondHandLength).y;
        int minuteHandLength = HORIZONTAL_SIZE / 2 - 70;
        xHandMin = minToLocation(minute, minuteHandLength).x;
        yHandMin = minToLocation(minute, minuteHandLength).y;
        int hourHandLength = HORIZONTAL_SIZE / 2 - 100;
        xHandHour = minToLocation(hour * 5 + getRelativeHour(hour), hourHandLength).x;
        yHandHour = minToLocation(hour * 5 + getRelativeHour(hour), hourHandLength).y;
        repaint();
    }


    /**
     * Returns how much the hour hand should be ahead
     * according to the minutes value.
     * 04:00, return 0.
     * 04:12, return 1, so that we move the hour handle ahead of one dot.
     *
     * @param min The current minute.
     * @return The relative offset to add to the hour hand.
     */
    private int getRelativeHour(int min) {
        return min / 12;
    }

    /**
     * paint clock hands
     *
     * @param g don't touch it!
     */
    protected void paintComponent(Graphics g) {
        Graphics2D g2 = (Graphics2D) g;
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
                RenderingHints.VALUE_ANTIALIAS_ON);

        g2.setColor(BACKGROUND_COLOR);
        g2.fillRect(0, 0, getWidth(), getHeight());

        // Draw the dots
        g2.setColor(GRAY_COLOR);
        for (int i = 0; i < 60; i++) {
            int DISTANCE_DOT_FROM_ORIGIN = HORIZONTAL_SIZE / 2 - 40;
            Point dotCoordinates = minToLocation(i, DISTANCE_DOT_FROM_ORIGIN);
            g2.setColor((i <= second ? Color.white : GRAY_COLOR));

            if (i % 5 == 0) {
                // big dot
                int DIAMETER_BIG_DOT = 8;
                g2.fillOval(dotCoordinates.x - (DIAMETER_BIG_DOT / 2),
                        dotCoordinates.y - (DIAMETER_BIG_DOT / 2),
                        DIAMETER_BIG_DOT,
                        DIAMETER_BIG_DOT);
            } else {
                // small dot
                int DIAMETER_SMALL_DOT = 4;
                g2.fillOval(dotCoordinates.x - (DIAMETER_SMALL_DOT / 2),
                        dotCoordinates.y - (DIAMETER_SMALL_DOT / 2),
                        DIAMETER_SMALL_DOT,
                        DIAMETER_SMALL_DOT);
            }
        }

        // Draw the clock hands
        g2.setColor(Color.white);
        g2.drawLine(HORIZONTAL_SIZE / 2, VERTICAL_SIZE / 2, xHandSec, yHandSec);
        g2.setStroke(new BasicStroke(3));
        g2.drawLine(HORIZONTAL_SIZE / 2, VERTICAL_SIZE / 2, xHandMin, yHandMin);
        g2.setStroke(new BasicStroke(5));
        g2.drawLine(HORIZONTAL_SIZE / 2, VERTICAL_SIZE / 2, xHandHour, yHandHour);
    }

    /**
     * Converts current second/minute/hour to x and y coordinates.
     *
     * @param timeStep The current second/minute/hour
     * @param radius   The radius length
     * @return the coordinates point
     */
    private Point minToLocation(int timeStep, int radius) {
        double t = 2 * Math.PI * (timeStep - 15) / 60;
        int x = (int) (HORIZONTAL_SIZE / 2 + radius * Math.cos(t));
        int y = (int) (VERTICAL_SIZE / 2 + radius * Math.sin(t));
        return new Point(x, y);
    }
}