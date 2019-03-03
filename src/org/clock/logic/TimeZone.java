package org.clock.logic;

public class TimeZone {
    private int hour;
    private int minute;

    public TimeZone(int hour, int minute, int positive) {
        this.hour = hour;
        this.minute = minute;
        if (positive < 0) {
            this.hour = (-1)*hour;
            this.minute = (-1)*minute;
        }
    }

    public int getHour() {
        return hour;
    }

    public int getMinute() {
        return minute;
    }

}
