package phoneV2;

public class Phone {
    private int imei;

    private SimCard simCard;

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
        return simCard;
    }

    public void setSimCard(SimCard simCard) {
        this.simCard = simCard;
    }

    public String getModel() {
        return model;
    }

    public PhoneCase getPhoneCase() {
        return phoneCase;
    }

    public void setPhoneCase(PhoneCase phoneCase) {
        this.phoneCase = phoneCase;
    }

    @Override
    public String toString() {
        return "Phone{" +
                ".imei=" + imei +
                " .simCard=" + simCard +
                ". model='" + model + '\'' +
                " .phoneCase=" + phoneCase +
                '}';
    }
}
