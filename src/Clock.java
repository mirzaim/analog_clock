import org.clock.logic.ClockLogic;
import org.clock.logic.TimeZone;
import org.clock.ui.ClockUI;

import java.util.concurrent.TimeUnit;

public class Clock {

    public static void main(String[] args) throws InterruptedException {
        ClockLogic greenwichTime = new ClockLogic(13, 6, 0);
        ClockLogic tehranTime = new ClockLogic(13, 6, 0, new TimeZone(3, 30, 1));
        ClockLogic newYorkTime = new ClockLogic(13, 6, 0, new TimeZone(5, 0, -1));
        ClockUI greenwich = new ClockUI();
        ClockUI tehran = new ClockUI();
        ClockUI newYork = new ClockUI();

        while (true) {
            greenwichTime.tik(1);
            tehranTime.tik(1);
            newYorkTime.tik(1);
            TimeUnit.SECONDS.sleep(1);
            greenwich.setClock(greenwichTime.getHour(), greenwichTime.getMinute(), greenwichTime.getSecond());
            tehran.setClock(tehranTime.getHour(), tehranTime.getMinute(), tehranTime.getSecond());
            newYork.setClock(newYorkTime.getHour(), newYorkTime.getMinute(), newYorkTime.getSecond());
        }
    }
}
