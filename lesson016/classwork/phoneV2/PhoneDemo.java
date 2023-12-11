package phoneV2;

import java.util.Arrays;

public class PhoneDemo {
    public static void main(String[] args) {

                Phone phone = new Phone(123456789, "Example Model");
                SimCard simCard1 = new SimCard(987654321);
                SimCard simCard2 = new SimCard(123456789);

                PhoneCase phoneCase1 = new PhoneCase("White", "Hard Plastic");
                PhoneCase phoneCase2 = new PhoneCase("Brown", "Leather");

                PhoneService phoneService = new PhoneService();

                PhoneCase phoneCase = phoneService.setCase(phone, phoneCase1);
                System.out.println("Phone after the new Phone Case: " + phone);
                System.out.println("Old Phone Case: " + phoneCase);
                System.out.println("=======================================");

                phoneCase = phoneService.setCase(phone, phoneCase2);
                System.out.println("Phone after the new Phone Case: " + phone);
                System.out.println("Old Phone Case: " + phoneCase);
                System.out.println("=======================================");

                phoneCase =  phoneService.setCase(phone, "Transparent", "Silicone");
                System.out.println("Phone after the new Phone Case: " + phone);
                System.out.println("Old Phone Case: " + phoneCase);
                System.out.println("=======================================");

                phoneCase =  phoneService.removeCase(phone);
                System.out.println("Phone after removing Phone Case: " + phone);
                System.out.println("Old Phone Case: " + phoneCase);
                System.out.println("=======================================");

                // Проверка вставки сим карты
                boolean inserted = phoneService.insertSimCard(phone, simCard1);
                if (inserted) {
                    System.out.println("Sim карта вставлена: " + phone);
                } else {
                    System.out.println("Ошибка вставки Sim карты.");
                }

                // Проверка получения смс
                phoneService.receivedSms(phone, "Привет!");
                phoneService.receivedSms(phone, "Как дела?");

                System.out.println("Полученные смс: " + Arrays.toString(phone.getSimCard().getSms()));

                // Проверка удаления смс
                phoneService.deleteSmsMessage(phone, 1);
                System.out.println("Смс после удаления: " + Arrays.toString(phone.getSimCard().getSms()));

                // Проверка удаления всех смс
                phoneService.deleteAllMessages(phone);
                System.out.println("Смс после удаления всех: " + Arrays.toString(phone.getSimCard().getSms()));


                // Проверка получения всех смс
                phoneService.receivedSms(phone, "Message1");
                phoneService.receivedSms(phone, "Message2");
                phoneService.receivedSms(phone, "Message3");
                phoneService.receivedSms(phone, "Message4");
                phoneService.receivedSms(phone, "Message5");
                phoneService.receivedSms(phone, "Message6");
                phoneService.receivedSms(phone, "Message7");
                phoneService.receivedSms(phone, "Message8");
                phoneService.receivedSms(phone, "Message9");
                phoneService.receivedSms(phone, "Message10");

                System.out.println("Смс после удаления всех: " + Arrays.toString(phone.getSimCard().getSms()));

                phoneService.receivedSms(phone, "Message11");

                System.out.println("=======================================");
                System.out.println(phone);

                // Проверка замены сим карты
                SimCard removedSim = phoneService.changeSimCard(phone, simCard2);
                System.out.println("Старая сим карта: " + removedSim);
                System.out.println("Новая сим карта: " + phone.getSimCard());

                System.out.println("=======================================");
                System.out.println(phone);

                // Проверка удаления сим карты
                SimCard removed = phoneService.removeSimCard(phone);
                System.out.println("Удаленная сим карта " + removed);
                System.out.println(" Телефон после удаления сим карты: " + phone);

            }

}
