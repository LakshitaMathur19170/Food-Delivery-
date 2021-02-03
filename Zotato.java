package assignments;

import java.util.*;

public class Zotato {
    public static void main(String[] args) {
        customer obj[]=new customer[5];
        restaurent obj1[]=new restaurent[5];
        Scanner scn = new Scanner(System.in);
        obj[0] = new elitecustomer("Ram", "Noida");
        obj[1] = new elitecustomer("Sam","Kanpur");
        obj[2] = new specialcustomer("Tim","Dwarka");
        obj[3] = new customer("Kim", "Pune");
        obj[4] = new customer("Jim", "Delhi");
        obj1[0] = new authentic_restaurent("Shah","Chandani Chowk");
        obj1[1] = new restaurent("Ravi's","Noida");
        obj1[2] = new authentic_restaurent("The Chinese","Greater Kailash");
        obj1[3] = new fastfood_restaurent("Wang's","GTB Nagar");
        obj1[4] = new restaurent("Paradise","Old Delhi");
        company company=new company();
        callrestaurent res = new callrestaurent(obj,obj1);
        callcustomer cus = new callcustomer(obj,obj1,company);

        int n = 0;
        do {
            System.out.println("Welcome to Zotato:\r\n" + "1) Enter as Restaurant Owner\r\n" + "2) Enter as Customer\r\n"
                            + "3) Check User Details\r\n" + "4) Company Account details\r\n" + "5) Exit");
            user x;
            n = scn.nextInt();
            if (n == 1) {
                System.out.println("Choose Restaurent");
                x= new callrestaurent(obj,obj1);
                x.displayRestaurent();
                int m1 = 0;
                int n1 = scn.nextInt() - 1;
                    do {

                        System.out.println(
                                "Welcome " + res.obj1[n1].getName() + "\r\n" + "1) Add item\r\n" + "2) Edit item\r\n"
                                        + "3) Print Rewards\r\n" + "4) Discount on bill value\r\n" + "5) Exit");

                        m1 = scn.nextInt();
                        if (m1 == 1) {
                            res.additem(n1);
                        } else if (m1 == 2) {
                            res.edititem(n1);

                        } else if (m1 == 3) {
                            res.printReward(n1);
                        } else if(m1==4) {
                            res.discountvalue(n1);
                        }
                    }while(m1!=5);

            } else if (n == 2) {
                x= new callcustomer(obj,obj1,company);
                x.displaycustomer();
                int m2 = scn.nextInt() -1;

                int m3=0;
                do {
                    System.out.println("Welcome " + cus.obj[m2].getName() + "\r\n" + "Customer Menu\r\n"
                            + "1) Select Restaurant\r\n" + "2) checkout cart\r\n" + "3) Reward won\r\n"
                            + "4) print the recent orders\r\n" + "5) Exit");
                    m3 = scn.nextInt();
                    if (m3 == 1) {
                        x.displayRestaurent();
                        int n2=scn.nextInt()-1;
                        cus.buyitem(n2, m2);
                    }else if (m3==2) {
                        System.out.println(m2);
						cus.checkoutcart(m2);
                    }else if(m3==3){
                        cus.printReward(m2);
                    }else if(m3==4) {
                        cus.recentorder(m2);
                    }
                } while (m3 != 5);
            }else if(n==3){
                System.out.println("1) Customer List\r\n" +
                        "2) Restaurant List");
                int m4=scn.nextInt();
                if(m4==1){
                    x= new callcustomer(obj,obj1,company);
                    x.displaycustomer();
                    int n3=scn.nextInt();
                    System.out.println(cus.obj[n3-1].getName()+", "+cus.obj[n3-1].getPlace()+", "+cus.obj[n3-1].getWallet());
                }else if(m4==2){
                    x= new callrestaurent(obj,obj1);
                    x.displayRestaurent();
                    int n3= scn.nextInt();
                    System.out.println(res.obj1[n3-1].getName()+", "+res.obj1[n3-1].getPlace()+", ");
                }
            }else if(n==4){
                company.account();
            }

        } while (n != 5);

    }
}
class company{
    private double companybalance=0.0;
    private int deliverycharges=0;

    public double getCompanybalance() {
        return companybalance;
    }

    public void setCompanybalance(double companybalance) {

        this.companybalance = companybalance*0.01;
    }

    public int getDeliverycharges() {
        return deliverycharges;
    }

    public void setDeliverycharges(int deliverycharges) {
        this.deliverycharges = deliverycharges;
    }
     public void account(){
         System.out.println("Total Company balance - INR "+getCompanybalance()+"\r\n" +
                 "Total Delivery Charges Collected - INR "+getDeliverycharges()+"/-");
     }
}
interface user{
    void displayRestaurent();
    void displaycustomer();
}
class customer {
    Scanner scn= new Scanner(System.in);
    private String Name;
    private int deliverycharge = 40;
    private int rewardpoints = 0;
    private String category = null;
    private double wallet = 1000;
    private String place=null;
    Map<Integer, food> items = new HashMap<Integer, food>();


    customer(String Name, String place) {
        this.Name = Name;
        this.place=place;

    }
    public double discountedPrice(double value){

        return value;
    }

    public int getRewardpoints() {
        return rewardpoints;
    }

    public void setRewardpoints(int rewardpoints) {
        this.rewardpoints = rewardpoints;
    }

    public double getWallet() {
        return wallet;
    }

    public void setWallet(double wallet) {
        this.wallet -= wallet;
    }

    public int getDeliverycharge() {
        return deliverycharge;
    }

    public String getCategory() {
        return category;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public void setDeliverycharge(int deliverycharge) {
        this.deliverycharge = deliverycharge;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getPlace() {
        return place;
    }

    public void setPlace(String place) {
        this.place = place;
    }
}

class elitecustomer extends customer {
    elitecustomer(String Name, String place) {
        super(Name, place);
        // TODO Auto-generated constructor stub

    }

    final int deliverycharge = 0;
    final String category = "Elite";

    public int getDeliverycharge() {
        return deliverycharge;
    }
    @Override
    public double discountedPrice(double value){

        if(value>200){
            value-=50;
        }
        return value;
    }
    public String getCategory() {
        return category;
    }

}

class specialcustomer extends customer {
    specialcustomer(String Name, String place) {
        super(Name, place);
        // TODO Auto-generated constructor stub
    }

    final int deliverycharge = 20;
    final String category = "Special";

    public int getDeliverycharge() {
        return deliverycharge;
    }
    @Override
    public double discountedPrice(double value){

        if(value>200){
            value-=25;
        }
        return value;
    }
    public String getCategory() {
        return category;
    }

    }


class food {
    private String type;
    private int price;
    private String Name;
    private int offer;
    private int quantity;
    private int id;
    private boolean bought=false;
    private double buyingprice;
    private restaurent restaurent;


    food(String Name, int price, int quantity, String type, int offer) {

        this.Name = Name;
        this.offer = offer;
        this.type = type;
        this.quantity = quantity;
        this.price = price;
    }

    public food() {

    }

    public double getBuyingprice() {
        return buyingprice;
    }

    public void setBuyingprice(double buyingprice) {
        this.buyingprice = buyingprice;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public int getOffer() {
        return offer;
    }

    public void setOffer(int offer) {
        this.offer = offer;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public boolean isBought() {
        return bought;
    }

    public void setBought(boolean bought) {
        this.bought = bought;
    }

    public restaurent getRestaurent() {
        return restaurent;
    }

    public void setRestaurent(restaurent restaurent) {
        this.restaurent = restaurent;
    }
}

class restaurent {

    private String Name;
    private int discount = 0;
    private final String type = null;
    private int rewardpoints = 0;
    private String place=null;

    Map<Integer, food> items= new HashMap<Integer, food>();


    restaurent(String Name, String place) {
        this.Name = Name;
        this.place=place;
    }
    public int rewards(double cost){
        int value= (int) ((cost/100)*5);
        return value;
    }
    public void addfood(food obj) {

        items.put(obj.getId(),obj);
    }
    public double discountedPrice(double value){
        return value;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public int getRewardpoints() {
        return rewardpoints;
    }

    public void setRewardpoints(int rewardpoints) {
        this.rewardpoints = rewardpoints;
    }

    public int getDiscount() {
        return discount;
    }

    public void setDiscount(int discount) {
        this.discount = discount;
    }

    public String getType() {
        return type;
    }

    public String getPlace() {
        return place;
    }

    public void setPlace(String place) {
        this.place = place;
    }
}

class fastfood_restaurent extends restaurent {
    private int discount = 0;
    private final String type = "Fast Food";

    fastfood_restaurent(String Name, String place) {
        super(Name, place);
        // TODO Auto-generated constructor stub
    }
    public double discountedPrice(double value){
        value = ((100-discount)/100.0)*value;
        return value;
    }
    public int getDiscount() {
        return discount;
    }

    public void setDiscount(int discount) {
        this.discount = discount;
    }

    public String getType() {
        return type;
    }
    public int rewards(double cost){
        int value= (int) ((cost/150)*10);
        return value;
    }
}

class authentic_restaurent extends restaurent {
    private int discount = 0;
    private final String type = "Authentic";

    authentic_restaurent(String Name, String place) {
        super(Name, place);
        // TODO Auto-generated constructor stub
    }
    public double discountedPrice(double value){
        value = ((100-discount)/100.0)*value;
        if(value>100){
            value-=50;
        }
        return value;
    }
    public int getDiscount() {
        return discount;
    }

    public void setDiscount(int discount) {

        this.discount = discount;
    }

    public String getType() {

        return type;
    }
    public int rewards(double cost){
        int value= (int) ((cost/150)*10);
        return value;
    }
}

class callcustomer implements user {
    Scanner scn = new Scanner(System.in);
    customer obj[];
    restaurent obj1[];
    company company;

    callcustomer(customer obj[],restaurent obj1[],company company) {
        this.obj = obj;
        this.obj1 =obj1;
        this.company=company;

    }
    @Override
    public void displaycustomer() {
        for (int i = 0; i < 5; i++) {
            if (obj[i].getCategory() != null) {
                System.out.println(i + 1 + " " + obj[i].getName() + " (" + obj[i].getCategory() + ")");
            } else {
                System.out.println(i + 1 + " " + obj[i].getName());
            }

        }

    }

    public void buyitem(int index , int n) {
        double value=0;
        System.out.println("Choose item by code");
        displayMenu(index);
        int id = scn.nextInt();
        food f= new food();
        f=obj1[index].items.get(id);
        System.out.println("Enter item quantity -");
        int q =scn.nextInt();
        f.setQuantity(q);
        value=f.getPrice()*q;
        value=value*((100-f.getOffer())/100.0);
        f.setBuyingprice(value);
        obj[n].items.put(f.getId(),f);
//        System.out.println(f.getId()+" " +f.getRestaurent().getName()+" "+f.getName()+" "+f.getQuantity()+" "+f.getPrice()+" "+f.getOffer()+" "+f.getBuyingprice());
        System.out.println("Items added to cart");
    }
    public void checkoutcart(int index) {
        double value=0;
        int cnt=0;
        int k=0;
        System.out.println("Items in Cart -");
        Set setofkeys = obj[index].items.keySet();
        Iterator iterator= setofkeys.iterator();
        while(iterator.hasNext()){
            int key = (int) iterator.next();
            food f= obj[index].items.get(key);
            System.out.println(f.getId() + " " + f.getRestaurent().getName() + " - "
                    + f.getName() + " " + f.getPrice() + " "
                    + f.getQuantity() + " " + f.getOffer() + " % off "
                    + f.getType());

            cnt += f.getQuantity();
            value+=f.getBuyingprice();
//            System.out.println(value);
            f.setBought(true);
            k=key;
        }
        value=obj[index].items.get(k).getRestaurent().discountedPrice(value);
        value=obj[index].discountedPrice(value);
        int rewards=obj[index].items.get(k).getRestaurent().rewards(value);
//        System.out.println(rewards);
        company.setCompanybalance(value);
        obj[index].items.get(k).getRestaurent().setRewardpoints(rewards);
        obj[index].setRewardpoints(rewards);
//        System.out.println(company.getCompanybalance());
        System.out.println("Delivery Charge-" + obj[index].getDeliverycharge() + "/-");
        value = value + obj[index].getDeliverycharge();
        company.setDeliverycharges(obj[index].getDeliverycharge());
        System.out.println("Total order value - INR " + value + "/-");
        if (value < obj[index].getWallet()) {
            System.out.println("    1) Proceed to checkout");
            int n = scn.nextInt();
            System.out.println(cnt + " items successfully bought for INR " + value + "/-");
        } else {
            System.out.println("	Delete item");
            int n = scn.nextInt();
            int y=obj[index].items.get(n).getQuantity();
            double x=obj[index].items.get(n).getBuyingprice();
            obj[index].items.remove(n);
            value = value -x;
            System.out.println("Total order value - INR " + value + "/-");
            System.out.println("    1) Proceed to checkout");
            int n1 = scn.nextInt();
            System.out.println(cnt-y + " items successfully bought for INR " + value + "/-");

        }
        value=value-rewards;
        obj[index].setWallet(value);

    }
    @Override
    public void displayRestaurent() {
        for (int i = 0; i < 5; i++) {
            if (obj1[i].getType() != null) {
                System.out.println(i + 1 + " " + obj1[i].getName() + " (" + obj1[i].getType() + ")");
            } else {
                System.out.println(i + 1 + " " + obj1[i].getName());
            }

        }

    }
    public void displayMenu(int index) {

        Set setofkeys = obj1[index].items.keySet();
        Iterator iterator= setofkeys.iterator();
        while(iterator.hasNext()){
            int key = (int) iterator.next();
            food f= obj1[index].items.get(key);
            System.out.println(f.getId() + " " + f.getRestaurent().getName() + " - "
                    + f.getName() + " " + f.getPrice() + " "
                    + f.getQuantity() + " " + f.getOffer() + " % off "
                    + f.getType());

        }

    }
    public void printReward(int index) {

        System.out.println("Rewards Point: " + obj[index].getRewardpoints());
    }
    public void recentorder(int index){
        Set setofkeys = obj[index].items.keySet();
        Iterator iterator= setofkeys.iterator();
        while(iterator.hasNext()){
            int key = (int) iterator.next();
            food f= obj[index].items.get(key);
            if (f.isBought()) {
                System.out.println("Bought item: " + f.getName() + " , quantity: " + f.getQuantity()
                        + " for Rs " + f.getPrice() + " from Restaurent " + f.getRestaurent().getName()+ " and Delivery Charge "
                        + obj[index].getDeliverycharge()+"/-");
            }
        }

    }

    }


class callrestaurent implements user {
    Scanner scn = new Scanner(System.in);
    customer obj[];
    restaurent obj1[];

    callrestaurent(customer obj[],restaurent obj1[]) {
        this.obj =obj;
        this.obj1 = obj1;

    }

    public void additem(int index) {
        System.out.println("Enter food details:");
        System.out.println("Food Name");
        String name = scn.next();
        System.out.println("price");
        int price = scn.nextInt();
        System.out.println("item quantity");
        int quantity = scn.nextInt();
        System.out.println("item Category");
        String type = scn.next();
        System.out.println("Offer");
        int offer = scn.nextInt();
        food food = new food(name, price, quantity, type, offer);
        food.setRestaurent(obj1[index]);
        food.setId(obj1[index].items.size() + 1);
        obj1[index].addfood(food);
        System.out.println(food.getId() + " " + food.getRestaurent().getName() + " - " + food.getName() + " " + food.getPrice() + " "
                + food.getQuantity() + " " + food.getOffer() + " % off " + food.getType());
    }

    public void edititem(int index) {
        System.out.println("Choose item by code");
        Set setofkeys = obj1[index].items.keySet();
        Iterator iterator= setofkeys.iterator();
        while(iterator.hasNext()){
            int key = (int) iterator.next();
            food f= obj1[index].items.get(key);
            System.out.println(f.getId() + " " + f.getName() + " - "
                    + f.getName() + " " + f.getPrice() + " "
                    + f.getQuantity() + " " + f.getOffer() + " % off "
                    + f.getType());

        }

        int n = scn.nextInt();
        System.out.println("Choose an attribute to edit:\r\n" + "1) Name\r\n" + "2) Price\r\n" + "3) Quantity\r\n"
                + "4) Category\r\n" + "5) Offer");
        int n1 = scn.nextInt();
        if (n1 == 1) {
            obj1[index].items.get(n).setName(scn.next());
        } else if (n1 == 2) {
            obj1[index].items.get(n).setPrice(scn.nextInt());
        } else if (n1 == 3) {
            obj1[index].items.get(n).setQuantity(scn.nextInt());
        } else if (n1 == 4) {
            obj1[index].items.get(n).setType(scn.next());
        } else {
            obj1[index].items.get(n).setOffer(scn.nextInt());
        }

    }

    public void printReward(int index) {

        System.out.println("Rewards Point: " + obj1[index].getRewardpoints());
    }
    public void displayMenu(int index) {
        Set setofkeys = obj1[index].items.keySet();
        Iterator iterator= setofkeys.iterator();
        while(iterator.hasNext()){
            int key = (int) iterator.next();
            food f= obj1[index].items.get(key);
            System.out.println(f.getId() + " " + f.getRestaurent().getName() + " - " + f.getName() + " " + f.getPrice() + " "
                    + f.getQuantity() + " " + f.getOffer() + " % off "
                    + f.getType());

        }

    }

    public void displayRestaurent() {
        for (int i = 0; i < 5; i++) {
            if (obj1[i].getType() != null) {
                System.out.println(i + 1 + " " + obj1[i].getName() + " (" + obj1[i].getType() + ")");
            } else {
                System.out.println(i + 1 + " " + obj1[i].getName());
            }
        }
    }

    @Override
    public void displaycustomer() {
        for (int i = 0; i < 5; i++) {
            if (obj[i].getCategory() != null) {
                System.out.println(i + 1 + " " + obj[i].getName() + " (" + obj[i].getCategory() + ")");
            } else {
                System.out.println(i + 1 + " " + obj[i].getName());
            }
        }
    }

    public void discountvalue(int n) {
        System.out.println("Enter offer on total bill value -");
        obj1[n].setDiscount(scn.nextInt());
    }
}