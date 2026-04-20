package labModules.labMod12;

abstract class Book {
    private String name;
    private String author;

    public Book() {
        this.name = "Unknown";
        this.author = "Unknown";
    }

    public Book(String name, String author) {
        this.name = name;
        this.author = author;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getAuthor() {
        return author;
    }

    public abstract void displayInfo();

    public abstract boolean isRecommendedForAge(int age);
}
