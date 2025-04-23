import java.util.ArrayList;
import java.util.Scanner;

public class CampusMap {

    ArrayList<Building> buildings;

    /**
     * Default constructor, initializes empty ArrayList
     */
    public CampusMap() {
        buildings = new ArrayList<Building>();
    }

    /**
     * Adds a Building to the map
     * @param b the Building to add
     */
    public void addBuilding(Building b) {
        System.out.println("Adding building...");
        buildings.add(b);
        System.out.println("-->Successfully added " + b.getName() + " to the map.");
    }

    /**
     * Removes a Building from the map
     * @param b the Building to remove
     * @return the removed Building
     */
    public Building removeBuilding(Building b) {
        System.out.println("Removing building...");
        buildings.remove(b);
        System.out.println("-->Successfully removed " + b.getName() + " to the map.");
        return b;
    }

    public String toString() {
        String mapString = "DIRECTORY of BUILDINGS";

        for (int i = 0; i < this.buildings.size(); i ++) {
            mapString += "\n  " + (i+1) + ". "+ this.buildings.get(i).getName() + " (" + this.buildings.get(i).getAddress() + ")";
        }
        return mapString;
    }

    /**
     * Main method for testing the CampusMap class.
     */
    public static void main(String[] args) {
        CampusMap myMap = new CampusMap();

        myMap.addBuilding(new Building("Ford Hall", "100 Green Street Northampton, MA 01063", 4));
        myMap.addBuilding(new Building("Bass Hall", "4 Tyler Court Northampton, MA 01063", 4));
        myMap.addBuilding(new Building("Burton Hall", "10 Green Street Northampton, MA 01063", 3));
        myMap.addBuilding(new Building("Seelye Hall", "2 Seelye Drive Northampton, MA 01063", 4));
        myMap.addBuilding(new Building("John M. Greene Hall", "60 Elm Street Northampton, MA 01063", 1));

        House chase = new House("Chase House", "11 Elm Street Northampton, MA 01063", 4, true, true);
        House washburn = new House("Washburn House", "4 Seelye Drive Northampton, MA 01063", 3, false, false);
        House tyler = new House("Tyler House", "164 Green Street Northampton, MA 01063", 4, true, false);
        myMap.addBuilding(chase);
        myMap.addBuilding(washburn);
        myMap.addBuilding(tyler);

        Library neilson = new Library("Neilson Library", "7 Neilson Drive Northampton, MA 01063", 4, true);
        Library hillyer = new Library("Hillery Arts Library", "22 Elm Street Northampton, MA 01063", 2, false);
        myMap.addBuilding(neilson);
        myMap.addBuilding(hillyer);

        Cafe compass = new Cafe("Compass Cafe", "7 Neilson Drive Northampton, MA 01063", 1, 50, 20, 15, 10);
        Cafe campusCafe = new Cafe("Campus Cafe", "100 Elm Street Northampton, MA 01063", 1, 50, 50, 25, 20);
        myMap.addBuilding(compass);
        myMap.addBuilding(campusCafe);

        // Use overloaded methods
        House unnamedHouse = new House();
        myMap.addBuilding(unnamedHouse);
        chase.moveIn("Laura");

        neilson.addTitle("Thinking about History by Sarah Maza");
        neilson.isAvailable("Thinking about History", "Sarah Maza");
        neilson.containsTitle("Thinking about History", "Sarah Maza");

        Cafe randomCafe = new Cafe();
        myMap.addBuilding(randomCafe);
        randomCafe.sellCoffee(23.34, 2.00, 3.55);
        randomCafe.sellCoffee();

        System.out.println("\n" + myMap);

    }
    
}
