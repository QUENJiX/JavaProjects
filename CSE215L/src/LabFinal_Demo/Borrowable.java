package LabFinal_Demo;

public interface Borrowable {
    void borrowItem(Student student, int days);
    void returnItem();
    boolean isAvailable();
}
