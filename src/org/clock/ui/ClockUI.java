package org.clock.ui; /**
 * ClockUI is a simple package for drawing ClockUI!
 * <p>
 * Thanks to Paolo Boschini for his <a href="https://github.com/paoloboschini/analog-clock/blob/master/Clock.java">code</a>!
 * <p>
 * @author MohammadHossein Hessar
 */


import java.awt.BorderLayout;
import java.awt.Dimension;
import javax.swing.JFrame;

public class ClockUI extends JFrame {
    private ClockPanel container;

    public ClockUI(int hour, int minute, int second){
        container = new ClockPanel();
        setClock(hour,minute,second);
        add(container, BorderLayout.CENTER);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setResizable(false);
        setSize(500, 500);
        setMinimumSize(new Dimension(500, 500));
        setLocationRelativeTo(null);
        pack();
        setVisible(true);
    }

    public ClockUI() {
        this(0,0,0);
    }

    /**
     * set time to display
     * do nothing when values are out of range!
     *
     * @param hour   hour value
     * @param minute minute value
     * @param second second value
     */
    public void setClock(int hour, int minute, int second) {
        if (hour > 24 || hour < 0)
            return;
        if (minute < 0 || minute > 60)
            return;
        if (second < 0 || second > 60)
            return;

        container.setHour(hour);
        container.setMinute(minute);
        container.setSecond(second);
        container.draw();
    }

    /**
     * set hour to display
     * do nothing when values are out of range!
     *
     * @param hour hour value
     */
    public void setHour(int hour) {
        if (hour > 24 || hour < 0)
            return;
        container.setHour(hour);
        container.draw();
    }

    /**
     * set minute to display
     * do nothing when values are out of range!
     *
     * @param minute minute value
     */
    public void setMinute(int minute) {
        if (minute < 0 || minute > 60)
            return;
        container.setMinute(minute);
        container.draw();
    }

    /**
     * set second to display
     * do nothing when values are out of range!
     *
     * @param second second value
     */
    public void setSecond(int second) {
        if (second < 0 || second > 60)
            return;
        container.setSecond(second);
        container.draw();
    }
}

