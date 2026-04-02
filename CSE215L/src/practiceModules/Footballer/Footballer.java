package practiceModules.Footballer;

public class Footballer {
    //1. 
    private String name;
    private String team;
    private String position;
    private int matches;
    private int goals;
    private int assists;

    //2.
    public Footballer() {
        this.name = null;
        this.team = null;
        this.position = null;
        this.matches = 0;
        this.goals = 0;
        this.assists = 0;

    }

    //3.
    public String getName() {
        return name;
    }public void setName(String name) {
        this.name = name;
    }

    public String getTeam() {
        return this.team;
    }public void setTeam(String team) {
        this.team = team;
    }

    public String getPosition() {
        return this.position;
    }public void setPosition(String position) {
        this.position = position;
    }

    //4a.
    public void increaseMatches() {
        this.matches++;
    }
    // 4b.
    public void increaseGoals(int goalsToAdd){
        this.goals += goalsToAdd;
    }
    // 4c.
    public void increaseAssists(int assistsToAdd){
        this.assists += assistsToAdd;
    }

    //5.
    //p1 = hasib, p2 = jaima
    // p1.compare(p2)
    public void compare(Footballer other){
        if(this.goals > other.goals && this.assists > other.assists){ //5a.
            System.out.println(this.name + " has more goals and assists than " + other.name);
        }else if(this.goals > other.goals && this.assists <= other.assists){ //5b.
            System.out.println(this.name + " has more goals but fewer or equal assists than " + other.name);
        }else if(this.assists > other.assists && this.goals <= other.goals){ //5c.
            System.out.println(this.name + " has more more assists but fewer  or equal goals than " + other.name);
        }else{ //5d.
            System.out.println(this.name + " has fewer goals and assists than " + other.name);
        }
    }

}
