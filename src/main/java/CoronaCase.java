public class CoronaCase {
    private String country;
    private String state;
    private int confirmed;
    private int death;
    private int active;

    public CoronaCase(String country, String state, int confirmed, int death, int active) {
        this.country = country;
        this.state = state;
        this.confirmed = confirmed;
        this.death = death;
        this.active = active;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public int getConfirmed() {
        return confirmed;
    }

    public void setConfirmed(int confirmed) {
        this.confirmed = confirmed;
    }

    public int getDeath() {
        return death;
    }

    public void setDeath(int death) {
        this.death = death;
    }

    public int getActive() {
        return active;
    }

    public void setActive(int active) {
        this.active = active;
    }
}
