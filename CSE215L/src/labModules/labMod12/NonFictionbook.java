package labModules.labMod12;

public class NonFictionBook extends Book {
    private String subject;

    public NonFictionBook() {
    }

    public NonFictionBook(String name, String author, String subject) {
        super(name, author);
        this.subject = subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getSubject() {
        return subject;
    }

    @Override
    public void displayInfo() {
        System.out.println(getName());
        System.out.println(getAuthor());
        System.out.println(subject);
    }

    @Override
    public boolean isRecommendedForAge(int age) {
        return age >= 18;
    }
}
