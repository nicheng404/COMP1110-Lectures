package comp1110.lectures.J08;

public class RoomInner {
    class FloorCovering {
        String type;

        public FloorCovering(String type) {
            this.type = type;
        }

        @Override
        public String toString() {
            return "FloorCovering{" +
                    "type='" + type + '\'' +
                    "room='" + name + '\'' +
                    '}';
        }
    }

    String name;
    FloorCovering floorCovering;

    public RoomInner(String name, String floorCoveringType) {
        this.name = name;
        this.floorCovering = new FloorCovering(floorCoveringType);
    }

    @Override
    public String toString() {
        return "RoomInner{" +
                "name='" + name + '\'' +
                ", floorCovering type=" + floorCovering.type +
                '}';
    }
}
