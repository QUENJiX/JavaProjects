package practiceModules.practice_LabMod13;

public class FirePoken implements Pokemon {
    private String name;
    private int level;

    public FirePoken() {}
    public FirePoken(String name, int level) {
        this.name = name;
        this.level = level;
    }

    @Override
    public void setName(String name){
        this.name = name;
    }
    @Override
    public String getName(){
        return name;
    }
    @Override
    public int getLevel(){
        return level;
    }
    @Override
    public void levelUp(){
        level++;
    }
    @Override
    public void attack(){
        System.out.println(name + " has used Ember");
    }
    @Override
    public void displayInfo(){
        System.out.println(name);
        System.out.println("Fire");
        System.out.println(level);
    }
}
