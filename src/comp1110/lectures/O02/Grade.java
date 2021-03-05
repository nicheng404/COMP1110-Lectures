package comp1110.lectures.O02;

public enum Grade {
    HD(80, "High distinction"),
    D(70, "Distinction"),
    CR(60, "Credit"),
    P(50, "Pass"),
    N(0, "Fail");

    private final int lowerBound; // lowest mark for which grade is awarded
    private final String longName;

    Grade(int lowerBound, String longName) {
        this.lowerBound = lowerBound;
        this.longName = longName;
    }

    public static Grade fromMark(int mark) {
        for (Grade g : Grade.values()) {
            if (mark >= g.lowerBound) {
                return g;
            }
        }
        return N;
    }

    @Override
    public String toString() {
        return longName;
    }
}
