package labModules.labMod12;

class NonFictionBook extends Book {
    private String subject;

    public NonFictionBook() {
        super();
        this.subject = "Unknown";
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
        System.out.println("Name: " + getName());
        System.out.println("Author: " + getAuthor());
        System.out.println("Subject: " + subject);
    }

    @Override
    public boolean isRecommendedForAge(int age) {
        return age >= 18;
    }
}
