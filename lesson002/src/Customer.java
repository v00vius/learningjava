//
// 2023-11-09
// A simple app that demonstrates class basics
// and some interactions between objects of a class

// A bank customer
public class Customer {
        protected String name;
        protected String currencyType = "EUR";
        protected double sum = 0.0;

        public Customer(String name)
        {
                this.name = name;
        }

        // add money to a customer account
        public void add(double amount)
        {
                sum += amount;
        }

        // deposit a customer
        public void deposit(Customer customer, double amount)
        {
                if (this == customer) {
                        return;
                }

                // Attention!
                // This should be a transaction (and/or some type of locking in case of
                // a multithreaded application)
                // begin/lock
                {
                        this.add(-amount);
                        customer.add(+amount);
                }
                // end/unlock
        }

        public void print()
        {
                System.out.printf("Customer name: %s\n"
                                  + "Sum: %10.2f %s\n\n",
                        name,
                        sum,
                        currencyType
                );
        }
}

class Main {
        char charVariable = 'C';

        public static void main(String[] args)
        {
                Customer john = new Customer("John");
                Customer elsa = new Customer("Elsa");

                john.add(100.0);

                System.out.print("New customers are:\n");
                john.print();
                elsa.print();

                john.deposit(elsa, 60.0);

                System.out.print("\nCustomers after depositing money are:\n");
                john.print();
                elsa.print();
        }
}
