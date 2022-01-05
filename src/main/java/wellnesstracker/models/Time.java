package wellnesstracker.models;

public enum Time {

    ONE("1 AM"),
    TWO("2 AM"),
    THREE("3 AM"),
    FOUR("4 AM"),
    FIVE("5 AM"),
    SIX("6 AM"),
    SEVEN("7 AM"),
    EIGHT("8 AM"),
    NINE("9 AM"),
    TEN("10 AM"),
    ELEVEN("11 AM"),
    TWELVE("12 PM"),
    THIRTEEN("1 PM"),
    FOURTEEN("2 PM"),
    FIFTEEN("3 PM"),
    SIXTEEN("4 PM"),
    SEVENTEEN("5 PM"),
    EIGHTEEN("6 PM"),
    NINETEEN("7 PM"),
    TWENTY("8 PM"),
    TWENTYONE("9 PM"),
    TWENTYTWO("10 PM"),
    TWENTYTHREE("11 PM"),
    TWENTYFOUR("12 AM");

    private final String displayName;

    Time(String displayName) {
        this.displayName = displayName;
    }

    public String getDisplayName() {
        return displayName;
    }


}
