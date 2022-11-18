//package dummydata;
//
//import com.solverscrum.shopping.entity.*;
//
//import java.text.ParseException;
//import java.text.SimpleDateFormat;
//import java.util.ArrayList;
//import java.util.Date;
//import java.util.List;
//
//public class DummyData {
//    static SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
//
//    static public List<Customers> customers = new ArrayList<>(List.of(
//                new Customers(7001,"Abhi","Tatisilwai","Ranchi",835103,"India"),
//                new Customers(7002,"Ram","Kestopur","Kolkata",700102,"India"),
//                new Customers(7003,"Geeta","Phusro","Bokaro",835201,"India")
//    ));
//    static public List<Suppliers> suppliers = new ArrayList<>(List.of(
//                new Suppliers(8001,"Rohan Stationary","Kantatoli","Ranchi",835101,1987654321),
//                new Suppliers(8002,"Shyam Electronics","2nd Gold Street","Kolkata",700212,1234567890)
//    ));
//    static public List<Shippers> shippers = new ArrayList<>(List.of(
//            new Shippers(9001,"BlueDart",642632899),
//            new Shippers(9002,"Ekart",762436423)
//    ));
//    static public List<Products> products = new ArrayList<>(List.of(
//            new Products(200001,"Notebook",1000,70,8001),
//            new Products(200002,"Pen",1500,20,8001),
//            new Products(200003,"Crayons",1000,100,8001),
//            new Products(200004,"Fan",100,2500,8002),
//            new Products(200005,"Bulbs",3000,250,8002)
//    ));
//    static public List<Orders> orders;
//
//    static {
//        try {
//            orders = new ArrayList<>(List.of(
//                    new Orders(1,sdf.parse("12-10-2022"),70001,9001),
//                    new Orders(2,sdf.parse("22-11-2022"),70002,9002),
//                    new Orders(3,sdf.parse("20-11-2022"),70003,9002)
//                    ));
//        } catch (ParseException e) {
//            throw new RuntimeException(e);
//        }
//    }
//
//    static public List<OrderDetails> orderDetails = new ArrayList<>(List.of(
//            new OrderDetails(101,20,1,20001),
//            new OrderDetails(102,10,2,20002),
//            new OrderDetails(103,2,3,20004)
//            ));
//
//}
