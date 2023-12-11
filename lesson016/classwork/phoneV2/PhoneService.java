package phoneV2;

public class PhoneService {

    /*
    1. Вставить симку
    2. удалить симку
    3. Заменить симку с сохранением номера
    4. Получить смс
    5. удалить какую-то смску

     */

    public PhoneCase setCase(Phone phone, PhoneCase phoneCase) {
        PhoneCase lastCase = phone.getPhoneCase();

        phone.setPhoneCase(phoneCase);
        return lastCase;
    }

    public PhoneCase removeCase(Phone phone) {
        return setCase(phone, null);
    }

    public PhoneCase setCase(Phone phone, String color, String material) {
        PhoneCase phoneCase = new PhoneCase(color, material);

        return setCase(phone, phoneCase);
    }

    public boolean insertSimCard(Phone phone, SimCard simCard){
        if (simCard.getNumber() != 0) {
        phone.setSimCard(simCard);
        return true;
        } else {
            return false;
        }
    }

    public SimCard removeSimCard(Phone phone) {
        SimCard removedSimCard = phone.getSimCard();
        phone.setSimCard(null);
        return removedSimCard;
    }

    public SimCard changeSimCard(Phone phone, SimCard newSimCard){
            SimCard removedSimCard = phone.getSimCard();
            int oldNumber = removedSimCard.getNumber();
            newSimCard.setNumber(oldNumber);
            phone.setSimCard(newSimCard);
            removedSimCard.setNumber(0);
            return removedSimCard;

    }

    public boolean receivedSms(Phone phone, String message){

        String[] ourSmsMessages = phone.getSimCard().getSms();
        int emptyCell = firstEmptyCell(ourSmsMessages);
        if (emptyCell == -1) {
            System.out.println("Нет памяти для новой смс. Удалите прошлые сообщения!");
            return false;
        } else {
            ourSmsMessages[emptyCell] = message;
            return true;
        }
    }

    private int firstEmptyCell(String[] messages){
        for (int i = 0; i < messages.length; i++) {
            if (messages[i] == null) {
                return i;
            }
        }
        return -1;
    }

    public boolean deleteSmsMessage(Phone phone, int smsNumber){
        if (smsNumber >= 0 && smsNumber < 10) {
        phone.getSimCard().getSms()[smsNumber] = null;
        return true;
        } else {
            System.out.println("Нет сообщения с таким номером!");
            return false;
        }
    }

    public boolean deleteAllMessages(Phone phone) {
        String[] newSmsMessages = new String[10];
        phone.getSimCard().setSms(newSmsMessages);
        return true;
    }

}
