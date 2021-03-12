package comp1110.lectures.J08;

public class RoomStaticNested {
    static class FloorCovering {
        String type;
        RoomStaticNested room;

        public FloorCovering(String type, RoomStaticNested room) {
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

    String name;
    FloorCovering floorCovering;

    public RoomStaticNested(String name, String floorCoveringType) {
        this.name = name;
        this.floorCovering = new FloorCovering(floorCoveringType, this);
    }

    @Override
    public String toString() {
        return "RoomStaticNested{" +
                "name='" + name + '\'' +
                ", floorCovering type=" + floorCovering.type +
                '}';
    }
}
