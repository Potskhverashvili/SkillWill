package Messenger;

public class Card implements Msg {
    // ---------------- Overriding - (Dynamic Polymorphism) ----------
    @Override
    public void hello(String message) {
        System.out.println(message);
    }

    @Override
    public void hello(String message, int num) {
        while (num != 0)   {
            System.out.println(message);
            num--;
        }
    }
}
