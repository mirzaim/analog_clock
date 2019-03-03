package test;
import org.clock.logic.ClockLogic;

public class ClockLogicTest {
    public static void main(String[] args) {
        ClockLogic clockLogic = new ClockLogic(1,2,3);
        System.out.println(clockLogic.getSecond() == 3);
        System.out.println(clockLogic.getMinute() == 2);
        System.out.println(clockLogic.getHour() == 1);
        clockLogic.setClock(10,20,30);
        System.out.println(clockLogic.getSecond() == 30);
        System.out.println(clockLogic.getMinute() == 20);
        System.out.println(clockLogic.getHour() == 10);
        clockLogic.tik(1);
        System.out.println(clockLogic.getSecond() == 31);
        System.out.println(clockLogic.getMinute() == 20);
        System.out.println(clockLogic.getHour() == 10);
        clockLogic.setClock(10,20,0);
        clockLogic.tik(100);
        System.out.println(clockLogic.getSecond() == 40);
        System.out.println(clockLogic.getMinute() == 21);
        System.out.println(clockLogic.getHour() == 10);

    }
}
