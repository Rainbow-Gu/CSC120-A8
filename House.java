import java.util.ArrayList;

/**
 * The House class is a specific type of Building 
 * A place where students live, work, and sometimes eat (if the House has a dining room)
 */
public class House extends Building implements HouseRequirements {
  
  private ArrayList<Student> residents;
  private boolean hasDiningRoom;
  private boolean hasElevator;

  /** 
   * Overload constructor to a default mode with no arguments
   */
  public House() {
    this("<Name Unknown>", "<Address Unknown>", 1, false, false);
    System.out.println("You have built a house that needs more information: 🏠");
  }

  /**
   * Constructor for House class
   * @param name house name
   * @param address house address
   * @param nFloors house number of floors
   * @param hasDiningRoom whether the house has a dining room
   * @param hasElevator whether the house have an elevator
   */
  public House(String name, String address, int nFloors, boolean hasDiningRoom, boolean hasElevator) {
    super(name, address, nFloors);
    this.residents = new ArrayList<Student>();
    this.hasDiningRoom = hasDiningRoom;
    this.hasElevator = hasElevator;
    System.out.println("You have built a house: 🏠");
  }

  /** 
   * Accessor for whether the house have a dining room
   */
  public boolean hasDiningRoom() {
    return hasDiningRoom;
  }

  /** 
   * Accessor for number of residents
   */
  public int nResidents() {
    return residents.size();
  }

  /**
   * Add a student to the list of residents
   * @param s the student/resident to move in
   */
  public void moveIn(Student s) {
    if (!residents.contains(s)) {
      residents.add(s);
      System.out.println(s + " moved in.");
    } else {
      System.out.println(s + " is already a resident.");
    }
  }

  /**
   * Overload moveIn: add a student if only name is available to the list of residents
   * @param s the student/resident to move in
   */
  public void moveIn(String studentName) {
    Student s = new Student(studentName, "990000000", 0000);
    moveIn(s);
  }

  /** 
   * Remove a student from the list and return them
   * @param s the student/resident to move out
   * @return s the student who wished to move out
   */
  public Student moveOut(Student s) {
    if (residents.contains(s)) {
      residents.remove(s);
      System.out.println(s + " moved out.");
      return s;
    } else {
      System.out.println(s + " is not a resident.");
      return null;
    }
  }

  /** 
   * Check if a student is a resident
   * @param s the student to check
   * @return true if the student is a resident; false otherwise
   */ 
  public boolean isResident(Student s) {
    return residents.contains(s);
  }

  /**
   * Override Building class to show the options a Student can make in a House class
   */
  public void showOptions() {
    System.out.println(" + moveIn(Student s) \n + moveOut(Student s) \n + isResident(Student s)");
  }

  /**
   * Override Building class to go to floors one by one if there are no elevator
   * @param floorNum number of floor to go to 
   * @throws RuntimeException for building without an elevator that tries to go to non-adjacent floors
   */
  public void goToFloor(int floorNum) {
    if (!hasElevator && floorNum >= 1 && floorNum <= nFloors){
      if (floorNum == this.activeFloor) {
        System.out.println("You are already at " + floorNum + " floor.");
      }
      else if (floorNum == activeFloor + 1 || floorNum == activeFloor-1) {
        super.goToFloor(floorNum);
      } else {
        throw new RuntimeException("This building doesn't have an elevator. You must go one floor at a time.");
      }
    } else {
      super.goToFloor(floorNum);
    }
  }

  /**
   * Main method for testing the House class
   */
  public static void main(String[] args) {
    House washburn = new House("Washburn", "5 Seelye Drive", 3, false, false);
    Student emily = new Student("Emily", "991345627", 2028);
    washburn.moveIn(emily);
    washburn.moveIn(emily);
    System.out.println("There is a dining room: " + washburn.hasDiningRoom());
    System.out.println("Number of residents: " + washburn.nResidents());
    System.out.println("Is Emily a resident? " + washburn.isResident(emily));
    washburn.moveOut(emily);
    washburn.moveOut(emily);
    washburn.enter();
    washburn.goToFloor(1);
    washburn.goToFloor(2);
    washburn.goToFloor(1);
    try {
      washburn.goToFloor(4);
    } catch (Exception e) {
      System.out.println(e.getMessage());
    }
  }

}