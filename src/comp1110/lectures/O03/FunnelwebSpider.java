package comp1110.lectures.O03;

public class FunnelwebSpider implements Toxic {
    @Override
    public boolean isLethalToHumans() {
        return true;
    }

    public void spinWeb() {
        System.out.println("I spun a web");
    }
}
