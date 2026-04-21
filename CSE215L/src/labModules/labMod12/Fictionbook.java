package labModules.labMod12;

public class FictionBook extends Book {
    private String genre;

    public FictionBook() {
    }

    public FictionBook(String name, String author, String genre) {
        super(name, author);
        this.genre = genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getGenre() {
        return genre;
    }

    @Override
    public void displayInfo() {
        System.out.println(getName());
        System.out.println(getAuthor());
        System.out.println(genre);
    }

    @Override
    public boolean isRecommendedForAge(int age) {
        return age >= 14;
    }
}
