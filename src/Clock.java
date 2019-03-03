import org.clock.logic.ClockLogic;
import org.clock.ui.ClockUI;

import java.util.concurrent.TimeUnit;

public class Clock {

    public static void main(String[] args) throws InterruptedException {
        ClockLogic logic = new ClockLogic(20, 52, 0);
        ClockUI ui = new ClockUI();

        while (true) {
            logic.tik(1);
            TimeUnit.SECONDS.sleep(1);
            ui.setClock(logic.getHour(), logic.getMinute(), logic.getSecond());
        }
    }
}
