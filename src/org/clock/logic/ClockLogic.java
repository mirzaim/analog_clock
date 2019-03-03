package org.clock.logic;

public class ClockLogic {
    private int hour;
    private int minute;
    private int second;

    public ClockLogic(int hour, int minute, int second) {
        this.hour = hour;
        this.minute = minute;
        this.second = second;
    }

    public void setClock(int hour, int minute, int second) {
        this.hour = hour;
        this.minute = minute;
        this.second = second;
    }

    public void tik(int second) {
        this.second += second;
        this.minute += this.second / 60;
        this.second = this.second % 60;
        this.hour += this.minute / 60;
        this.minute = this.minute % 60;
        this.hour = this.hour % 24;
    }

    public int getHour() {
        return hour;
    }

    public int getMinute() {
        return minute;
    }

    public int getSecond() {
        return second;
    }
}
