package inheritance;

public class Cat {

    private String name;

    public Cat(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void voice() {
        System.out.println("Meow!!!");
    }

    public void greeting(){
        System.out.println("Cat name " + name);
    }
}
