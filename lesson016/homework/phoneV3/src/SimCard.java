// package phoneV2;

import java.util.Arrays;

public class SimCard {

    private int number;

    private String[] sms = new String[10];

    public SimCard(int number) {
        this.number = number;
    }

    public int getNumber() {
        return number;
    }

    public int removeNumber() {
        return setNumber(0);
    }

    public int setNumber(int number) {
        int oldNumber = this.number;

        this.number = number;
        return oldNumber;
    }

    public String[] getSms() {
        return sms;
    }

    public String[] removeSms() {
        return setSms(new String[10]);
    }

    public String removeSms(int smsIndex) {
        String oldSms = sms[smsIndex];

        sms[smsIndex] = null;

        return oldSms;
    }

    public boolean receiveSms(String message) {    
        int empyCell = firstEmptyCell();

        if(-1 == empyCell)
            return false;

        receiveSms(empyCell, message);

        return true;
    }

    public String receiveSms(int smsIndex, String message) {
        String oldSms = removeSms(smsIndex);

        sms[smsIndex] = message;

        return oldSms;
    }

    private int firstEmptyCell(){
        for (int i = 0; i < sms.length; ++i) {
            if (sms[i] == null)
                return i;
        }

        return -1;
    }

    public String[] setSms(String[] sms) {
        String[] oldSms = this.sms;

        this.sms = sms;
        return oldSms;
    }


    @Override
    public String toString() {
        String messages = "";

        for (int i = 0; i < sms.length; i++) {
            messages += "    " + (i + 1) + ") '" + sms[i] + "'\n";
        }

        return "SIM Card\n" +
                "  number " + number + "\n" +
                "  messages:\n" + messages;
    }
}
