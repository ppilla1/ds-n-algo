package net.recursion.problemset03;

import java.util.ArrayList;
import java.util.List;

public class TopDownCircularTour {

    private final int startCity='a';
    private char[] cities;
    private final int[] distance;
    private final int[] petrol;


    public TopDownCircularTour(int[] cost, int[] fuel) {
        this.distance = cost;
        this.petrol = fuel;

        this.cities=new char[cost.length];

        for(int i=0; i< cost.length; i++){
            cities[i] = (char)(startCity + i);
        }
    }

    List<String> findTourRouteDFdefaultStack(){
        List<String> routes = new ArrayList<>();

        for(int i=0; i< cities.length; i++){
            char[] solutionRoute = {cities[i]};
            String route = findRouteDF(i,(i+1)% cities.length,  petrol[i]-distance[i],solutionRoute);

            if(null != route && !route.isEmpty()){
                routes.add(route);
            }

        }
        return routes;
    }

    private String findRouteDF(int startPosition, int nextPosition, int fuel, char[] cityRoute) {
        String cityRoutes = null;

        // Happy case
        if (startPosition == nextPosition){
            char[] newSolution = new char[cityRoute.length + 1];
            System.arraycopy(cityRoute,0,newSolution,0, cityRoute.length);
            newSolution[newSolution.length-1]=cities[nextPosition];
            cityRoutes = String.valueOf(newSolution);
        }else if (startPosition != nextPosition && fuel  < 0){ // Sad case
            cityRoutes = "";
        }else{ // Processing meat
            char[] newSolution = new char[cityRoute.length + 1];
            System.arraycopy(cityRoute,0,newSolution,0, cityRoute.length);
            newSolution[newSolution.length-1]=cities[nextPosition];
            cityRoutes = findRouteDF(startPosition, (nextPosition + 1)%cities.length, fuel + petrol[nextPosition] - distance[nextPosition],newSolution);
        }
        return cityRoutes;
    }
}
