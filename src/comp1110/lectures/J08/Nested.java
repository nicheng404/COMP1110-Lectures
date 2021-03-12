package comp1110.lectures.J08;

public class Nested {
    public static void main(String[] args) {
        Room office = new Room("Josh's office", "Carpet");
        System.out.println(office);

        RoomStaticNested kitchen = new RoomStaticNested("CSIT kitchen", "Linoleum");
        System.out.println(kitchen);

        RoomInner marieReay = new RoomInner("Marie Reay Level 3", "Wood");
        System.out.println(marieReay);
    }
}
