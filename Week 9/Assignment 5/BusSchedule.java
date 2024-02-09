/*
 * Create a limited bus scheduling system that will allow a user to enter city-to-city connections and their prices.
 * Your system should then allow a user to enter two cities and should return the shortest path and the cheapest path between the two cities.
 * Your system should report if there is no connection between two cities. Assume an undirected network.
 */

import java.util.*;
import Graph.Graph;

public class BusSchedule {
    public static void main(String[] args) {
        boolean random = false;
        Scanner in = new Scanner(System.in);
        System.out.println("Enter the number of cities: ");
        int numCities;
        if (!random) {
            numCities = in.nextInt();
        }
        else {
            numCities = 10;
        }

        // Create a graph
        Graph graph = new Graph(numCities);

        //let the user enter the cities
        System.out.println("Enter the cities: ");
        for (int i = 0; i < numCities; i++) {
            if (!random) {
                String city = in.next();
                if (city != null) {
                    graph.addNode(city);
                }
            }
            else {
                graph.addNode("City" + i);
                System.out.println("City" + i);
            }
        }

        //let the user enter the connections
        System.out.println("Enter the number of connections: ");
        int numConnections;
        if (!random) {
            numConnections = in.nextInt();
        }
        else {
            numConnections = 10;
            System.out.println(numConnections);
        }
        System.out.println("Enter the connections: ");
        for (int i = 0; i < numConnections; i++) {
            if (!random){
                String city1 = in.next();
                String city2 = in.next();
                int price = in.nextInt();
                graph.addEdge(city1, city2, price);
                //make sure the edge was added
                if (graph.getEdge(city1, city2) != null) {
                    System.out.println("Edge added: " + city1 + " " + city2 + " " + price);
                }
            }
            else {
                int city1 = (int)(Math.random() * numCities);
                int city2 = (int)(Math.random() * numCities);
                int price = (int)(Math.random() * 100);
                System.out.println("City" + city1 + "\nCity" + city2 + "\n" + price);
                graph.addEdge("City" + city1, "City" + city2, price);
                //make sure the edge was added
                if (graph.getEdge("City" + city1, "City" + city2) != null) {
                    System.out.println("Edge added: " + "City" + city1 + " " + "City" + city2 + " " + price);
                }
            }
        }

        //print the graph
        System.out.println("Graph: ");
        graph.printGraph();

        //ask the user for their start and end point
        System.out.println("Enter the start city: ");
        String startCity = in.next();
        System.out.println("Enter the end city: ");
        String endCity = in.next();

        //find the shortest path
        System.out.println("Shortest path: ");
        graph.shortestPath(startCity, endCity);

        //find the cheapest path
        System.out.println("Cheapest path: ");
        graph.cheapestPath(startCity, endCity);
    }
}