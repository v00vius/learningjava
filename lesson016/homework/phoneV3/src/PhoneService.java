// package phoneV2;

public class PhoneService {

    /*
    1. Вставить симку
    2. удалить симку
    3. Заменить симку с сохранением номера
    4. Получить смс
    5. удалить какую-то смску

     */

    public PhoneCase setCase(Phone phone, PhoneCase phoneCase) {
        return phone.setPhoneCase(phoneCase);
    }

    public PhoneCase removeCase(Phone phone) {
        return phone.removPhoneCase();
    }

    public PhoneCase setCase(Phone phone, String color, String material) {
        PhoneCase phoneCase = new PhoneCase(color, material);

        return phone.setPhoneCase(phoneCase);
    }

    public boolean insertSimCard(Phone phone, SimCard simCard) {
        return insertSimCard(phone, simCard, 0);
    }

    public boolean insertSimCard(Phone phone, SimCard simCard, int index){
        if (simCard.getNumber() != 0) {
            phone.setSimCard(index, simCard);

            return true;
        }

        return false;
    }

    public SimCard removeSimCard(Phone phone) {
        return phone.removeSimCard(0);
    }

    public SimCard removeSimCard(Phone phone, int index) {
        return phone.removeSimCard(index);
    }

    public SimCard changeSimCard(Phone phone, SimCard newSimCard) {
        return changeSimCard(phone, newSimCard, 0);
    }

    public SimCard changeSimCard(Phone phone, SimCard newSimCard, int index){
            SimCard removedSimCard = phone.removeSimCard(index);
            int oldNumber = removedSimCard.getNumber();

            newSimCard.setNumber(oldNumber);
            phone.setSimCard(index, newSimCard);
            removedSimCard.removeNumber();

            return removedSimCard;

    }

    public boolean receivedSms(Phone phone, String message) {
        return receivedSms(phone, message, 0);
    }        
       
    public boolean receivedSms(Phone phone, String message, int index) {
        SimCard sim  = phone.getSimCard(index);

        if (!sim.receiveSms(message)) {
            System.out.println("Нет памяти для новой смс. SIM" + index +
                    ". Удалите прошлые сообщения!");

            return false;
        }

        return true;
    }
    public boolean deleteSmsMessage(Phone phone, int smsNumber) {
        return deleteSmsMessage(phone, smsNumber, 0);
    }

    public boolean deleteSmsMessage(Phone phone, int smsNumber, int index){
        if (0 <= smsNumber && smsNumber < 10) {
            phone.getSimCard(index).removeSms(smsNumber);

            return true;
        }

        System.out.println("Нет сообщения c таким номером! SIM" + index);

        return false;
    }
    
    public boolean deleteAllMessages(Phone phone) {
        return deleteAllMessages(phone, 0);
    }

    public boolean deleteAllMessages(Phone phone, int index) {
        phone.getSimCard(index)
            .removeSms();

        return true;
    }
}
