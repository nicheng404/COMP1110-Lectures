package comp1110.lectures.J08;

public class FloorCovering {
    String type;
    Room room;

    public FloorCovering(String type, Room room) {
        this.type = type;
        this.room = room;
    }

    @Override
    public String toString() {
        return "FloorCovering{" +
                "type='" + type + '\'' +
                "room='" + room + '\'' +
                '}';
    }
}
