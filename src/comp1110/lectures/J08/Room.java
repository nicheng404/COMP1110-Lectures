package comp1110.lectures.J08;

public class Room {
    String name;
    FloorCovering floorCovering;

    public Room(String name, String floorCoveringType) {
        this.name = name;
        this.floorCovering = new FloorCovering(floorCoveringType, this);
    }

    @Override
    public String toString() {
        return "Room{" +
                "name='" + name + '\'' +
                ", floorCovering type=" + floorCovering.type +
                '}';
    }
}
