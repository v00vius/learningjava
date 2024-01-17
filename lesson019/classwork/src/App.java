import messenger.BaseMessenger;
import messenger.Telegram;
import messenger.Viber;
import messenger.WatsApp;
import phone.Phone;

public class App {
        public static void main(String[] args)
        {
                Phone phone = new Phone(new BaseMessenger[]{new Telegram(), new WatsApp(), new Viber()});

                phone.setMessenger(0);
                String message = phone.getMessenger().receive();
                System.out.println(message);

                phone.setMessenger(1);
                phone.getMessenger().send(message);
                System.out.println(phone.getMessenger().getMessage());
                message = phone.getMessenger().receive();
                System.out.println(phone.getMessenger().getMessage());

                phone.setMessenger(2);
                phone.getMessenger().send(message);
                System.out.println(phone.getMessenger().getMessage());
                message = phone.getMessenger().receive();
                System.out.println(phone.getMessenger().getMessage());
        }
}
