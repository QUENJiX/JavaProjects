package labModules.labMod8.Pirate;

public class Pirate {
    private String pirateName;
    private String country;

    public Pirate() {
    }

    public Pirate(String name, String country) {
        this.pirateName = name;
        this.country = country;
    }

    public void setPirateName(String pirateName) {
        this.pirateName = pirateName;
    }

    public String getPirateName() {
        return pirateName;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getCountry() {
        return country;
    }
}
