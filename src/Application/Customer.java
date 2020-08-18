package Application;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Customer Object Class
 */
public class Customer {

    private String username, password;
    private int credit;

    /**
     * Customer constructor with all customer details
     * @param username
     * @param password
     * @param credit
     */
    public Customer(String username, String password, int credit){
        this.username = username;
        this.password = password;
        this.credit = credit;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getCredit() {
        return credit;
    }

    public void setCredit(int credit) {
        this.credit = credit;
    }

    /**
     * Reads customer DB and returns an ArrayList
     * @return Arraylist of users
     * @throws IOException
     */
    public static ArrayList<Customer> readingDB() throws IOException {

        ArrayList<Customer> customer = new ArrayList<>();

        Scanner scan = new Scanner(new File(System.getProperty("user.dir") + "/src/Application/Customers.txt"));
        scan.useDelimiter("[,\n]");

        while (scan.hasNext()) {

            customer.add(new Customer(scan.next(), scan.next(), scan.nextInt()));
        }
        scan.close();

        return customer;
    }
}
