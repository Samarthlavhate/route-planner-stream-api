import java.util.ArrayList;
import java.util.function.Consumer;
import  java.util.Scanner;
import java.util.stream.Collectors;

public class Routemain {

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        routeprog rp=new routeprog();
        ArrayList<Route> R1= (ArrayList<Route>) rp.Insert().stream().collect(Collectors.toList());
        R1.stream().forEach(System.out::println);
        System.out.println("========================");
        String fromcity= sc.next();
        System.out.println("==================");
        ArrayList<Route> R2 = (ArrayList<Route>) rp.directflight(R1,fromcity).stream().collect(Collectors.toList());
        R2.stream().forEach(System.out::println);
        System.out.println("=================");
        rp.sort(R2).stream().forEach(System.out::println);
        System.out.println("==================");
        String tooflight= sc.next();
        rp.flightfromdesired(R1,fromcity,tooflight);
    }
    }
