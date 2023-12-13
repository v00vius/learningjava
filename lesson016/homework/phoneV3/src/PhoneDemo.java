// package phoneV2;

// import java.util.Arrays;

public class PhoneDemo {
    public static void main(String[] args) {

                Phone phone = new Phone(123456789, "Example Model");
                SimCard simCard1 = new SimCard(9991188);
                SimCard simCard2 = new SimCard(1115544);
                SimCard simCard3 = new SimCard(5550099);
                SimCard simCard4 = new SimCard(6665500);

                PhoneCase phoneCase1 = new PhoneCase("White", "Hard Plastic");
                PhoneCase phoneCase2 = new PhoneCase("Brown", "Leather");

                PhoneService phoneService = new PhoneService();

                System.out.println("Phone without a case:\n" + phone);

                PhoneCase phoneCase = phoneService.setCase(phone, phoneCase1);
                System.out.println("With case1:\n" + phone);
                System.out.println("Old case:\n" + phoneCase);
                System.out.println("=======================================");

                phoneCase = phoneService.setCase(phone, phoneCase2);
                System.out.println("With case2:\n" + phone);
                System.out.println("Old Phone Case:\n" + phoneCase);
                System.out.println("=======================================");

                phoneCase =  phoneService.setCase(phone, "Transparent", "Silicone");
                System.out.println("With case13\n" + phone);
                System.out.println("Old Phone Case:\n" + phoneCase);
                System.out.println("=======================================");

                phoneCase =  phoneService.removeCase(phone);
                System.out.println("Phone after removing Phone Case:\n" + phone);
                System.out.println("Old Phone Case:\n" + phoneCase);
                System.out.println("=======================================");

                phoneService.setCase(phone, phoneCase2);
              
                // Проверка вставки сим карты 
                boolean inserted = phoneService.insertSimCard(phone, simCard1);

                if (inserted) {
                    System.out.println("Sim0 карта вставлена: " + phone);
                } else {
                    System.out.println("Ошибка вставки Sim0 карты.");
                }

                inserted = phoneService.insertSimCard(phone, simCard3, 1);

                if (inserted) {
                    System.out.println("Sim1 карта вставлена: " + phone);
                } else {
                    System.out.println("Ошибка вставки Sim1 карты");
                }

                // Проверка получения смс
                phoneService.receivedSms(phone, "Привет!");
                phoneService.receivedSms(phone, "Как дела?");
                phoneService.receivedSms(phone, ">>> Привет!", 1);
                phoneService.receivedSms(phone, ">>>Как дела?", 1);

                System.out.println("Полученные смс SIM0: " + phone.getSimCard());
                System.out.println("Полученные смс SIM1: " + phone.getSimCard(1));

                // Проверка удаления смс
                phoneService.deleteSmsMessage(phone, 1);
                System.out.println("Смс после удаления SIM0: " + phone.getSimCard());
                phoneService.deleteSmsMessage(phone, 1, 1);
                System.out.println("Смс после удаления SIM1: " + phone.getSimCard(1));

                // Проверка удаления всех смс
                phoneService.deleteAllMessages(phone);
                System.out.println("Смс SIM0 после удаления всех: " + phone.getSimCard());
                phoneService.deleteAllMessages(phone, 1);
                System.out.println("Смс SIM1 после удаления всех: " + phone.getSimCard(1));


                // Проверка получения всех смс
                phoneService.receivedSms(phone, "Message 1");
                phoneService.receivedSms(phone, "Message 2");
                phoneService.receivedSms(phone, "Message 3");
                phoneService.receivedSms(phone, "Message 4");
                phoneService.receivedSms(phone, "Message 5");
                phoneService.receivedSms(phone, "Message 6");
                phoneService.receivedSms(phone, "Message 7");
                phoneService.receivedSms(phone, "Message 8");
                phoneService.receivedSms(phone, "Message 9");
                phoneService.receivedSms(phone, "Message10");

                phoneService.receivedSms(phone, ">>Message 1",1);
                phoneService.receivedSms(phone, ">>Message 2", 1);
                phoneService.receivedSms(phone, ">>Message 3", 1);
                phoneService.receivedSms(phone, ">>Message 4", 1);
                phoneService.receivedSms(phone, ">>Message 5", 1);
                phoneService.receivedSms(phone, ">>Message 6", 1);
                phoneService.receivedSms(phone, ">>Message 7", 1);
                phoneService.receivedSms(phone, ">>Message 8", 1);
                phoneService.receivedSms(phone, ">>Message 9", 1);
                phoneService.receivedSms(phone, ">>Message 0", 1);

                System.out.println("Смс SIM0 после получения всех sms: " + phone.getSimCard());
                System.out.println("Смс SIM0 после получения всех sms: " + phone.getSimCard(1));

                phoneService.receivedSms(phone, "Message11");
                phoneService.receivedSms(phone, ">>>Message11",1);

                System.out.println("=======================================");
                System.out.println(phone);

                // Проверка замены сим карты
                SimCard removedSim = phoneService.changeSimCard(phone, simCard2);
                System.out.println("Старая сим0 карта: " + removedSim);
                System.out.println("Новая сим0 карта: " + phone.getSimCard());

                removedSim = phoneService.changeSimCard(phone, simCard4, 1);
                System.out.println("Старая сим1 карта: " + removedSim);
                System.out.println("Новая сим1 карта: " + phone.getSimCard(1));

                System.out.println("=======================================");
                System.out.println(phone);

                // Проверка удаления сим карты
                SimCard removed = phoneService.removeSimCard(phone);
                System.out.println("Удаленная сим0 карта " + removed);
                System.out.println(" Телефон после удаления сим0 карты: " + phone);

                removed = phoneService.removeSimCard(phone, 1);
                System.out.println("Удаленная сим1 карта " + removed);
                System.out.println(" Телефон после удаления сим1 карты: " + phone);

            }

}
