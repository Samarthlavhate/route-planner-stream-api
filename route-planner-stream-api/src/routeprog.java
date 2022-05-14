import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.stream.Collectors;

public class routeprog {

    ArrayList<Route> route =new ArrayList<>();

    public ArrayList<Route> Insert()  {
      try{  BufferedReader bf= new BufferedReader(new FileReader("C:\\Users\\samarth lavhate\\Desktop\\AAAA\\course5 mini\\file\\samar.csv"));
        String line;
        int i=0;
        while((line= bf.readLine())!=null) {
        String [] name= line.split(", ");
        Route r= new Route(name[0],name[1],Integer.parseInt(name[2]),name[3],name[4]);
        route.add(r);
        }
        }
      catch(IOException E){
          System.out.println(E);
      }
      catch (NumberFormatException N){
          System.out.println(N);
      }

return route;

    }
        public ArrayList<Route> directflight(ArrayList<Route> route, String fromcity){
      ArrayList<Route> dirflight = (ArrayList<Route>) route.stream()
              .filter(name->name.getFromCity().equalsIgnoreCase(fromcity)).collect(Collectors.toList());

        return dirflight ;
    }
        public ArrayList<Route> sort(ArrayList<Route> route){


      ArrayList<Route> routes= (ArrayList<Route>) route.stream().
              sorted(((o1, o2) -> o1.getToCity().compareToIgnoreCase(o2.getToCity()))).
              collect(Collectors.toList());



        return routes;
    }
    void flightfromdesired(ArrayList<Route> route , String fromcity ,String toocity){

        for (Route i : route) {
            if (i.getFromCity().equalsIgnoreCase(fromcity) && i.getToCity().equalsIgnoreCase(toocity)) {
                System.out.println(i);
                break;
            }
        }
        for (Route l : route) {
            if (l.getFromCity().equalsIgnoreCase(fromcity)) {
                String temp = l.getToCity();
                for (Route k : route) {
                    if (k.getFromCity().equalsIgnoreCase(temp) && k.getToCity().equalsIgnoreCase(toocity))
                    {
                        flightfromdesired(route, fromcity, temp);
                        flightfromdesired(route, temp, toocity);

                    }
                }
            }
        }
    }}

