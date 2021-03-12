package comp1110.lectures.O03;

public class Interfaces {
    public static void main(String[] args) {
        FunnelwebSpider charlotte = new FunnelwebSpider();
        Toxic gas = new HydrogenCyanide();
        Borax powder = new Borax();
        Dog leslie = new Dog();

        Toxic[] toxicThings = new Toxic[3];
        toxicThings[0] = charlotte;
        toxicThings[1] = gas;
        toxicThings[2] = powder;
        //toxicThings[2] = leslie; // can't assign an instance of Dog to the array, because Dog doesn't implement Toxic

        for (Toxic t : toxicThings) {
            System.out.println(t.getClass().getSimpleName() + " is deadly?: " + t.isLethalToHumans());
            if (t instanceof FunnelwebSpider) {
                FunnelwebSpider spider = (FunnelwebSpider) t; // cast t to the type FunnelwebSpider
                spider.spinWeb();
            }
        }
    }
}
