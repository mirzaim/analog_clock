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

    public ClockLogic(int hour, int minute, int second, TimeZone zone) {
        this.hour = hour + zone.getHour();
        this.minute = minute + zone.getMinute();
        this.second = second;

        if (minute < 0) {
            this.minute += 60;
            this.hour--;
        }
        if (hour < 0)
            this.hour += 24;

        fix();
    }

    public void setClock(int hour, int minute, int second) {
        this.hour = hour;
        this.minute = minute;
        this.second = second;
    }

    public void setClock(int hour, int minute, int second, TimeZone zone) {
        this.hour = hour + zone.getHour();
        this.minute = minute + zone.getMinute();
        this.second = second;

        if (minute < 0) {
            this.minute += 60;
            this.hour--;
        }
        if (hour < 0)
            this.hour += 24;

        fix();
    }

    public void tik(int second) {
        addTime(0, 0, second);
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

    private void addTime(int hour, int minute, int second) {
        this.second += second;
        this.minute += this.second / 60 + minute;
        this.second = this.second % 60;
        this.hour += this.minute / 60 + hour;
        this.minute = this.minute % 60;
        this.hour = this.hour % 24;
    }

    private void fix() {
        addTime(0, 0, 0);
    }
}
