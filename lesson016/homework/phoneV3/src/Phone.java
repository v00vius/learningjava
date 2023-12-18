// package phoneV2;

import java.util.Arrays;

public class Phone {
    private int imei;

    private SimCard[] simCard = new SimCard[2];

    private String model;
    private PhoneCase phoneCase;


    public Phone(int imei,  String model) {
        this.imei = imei;
        this.model = model;
    }

    public int getImei() {
        return imei;
    }

    public SimCard getSimCard() {
        return getSimCard(0);
    }

    public SimCard getSimCard(int index) {
        return simCard[index];
    }

    public SimCard removeSimCard() {
        return removeSimCard(0);
    }

    public SimCard[] removeAllSimCards() {
        SimCard[] olCards = this.simCard;

        this.simCard = new SimCard[2];

        return olCards;
    }

    public SimCard removeSimCard(int index) {
        return setSimCard(index, null);
    }

    public SimCard setSimCard(int index,  SimCard simCard) {
        SimCard olCard = this.simCard[index];

        this.simCard[index] = simCard;
        return olCard;
    }

    public String getModel() {
        return model;
    }

    public PhoneCase getPhoneCase() {
        return phoneCase;
    }

    public PhoneCase removPhoneCase() {
        return setPhoneCase(null);
    }

    public PhoneCase setPhoneCase(PhoneCase phoneCase) {
        PhoneCase olPhoneCase = this.phoneCase;

        this.phoneCase = phoneCase;
        return olPhoneCase;
    }

    @Override
    public String toString() {
        return "phone " + model + "\n" +
                "  imei " + imei + "\n" +
                "  " + phoneCase + "\n" +
                "  " + Arrays.toString(simCard);
                
    }
}
