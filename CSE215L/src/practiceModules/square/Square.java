package practiceModules.square;

public class Square {
    private double side;

    //default constructor
    public Square(){
        this.side = 1.0;
    }
    //parameterized constructor
    public Square(double side){
        this.side = side;
    }

    public void setSide(double s){
        this.side = s;
    }public double getSide(){
        return this.side;
    }

    public double getArea(){
        return this.side * this.side;
    }public double getPerimeter(){
        return 4 * this.side;
    }public double getDiagonal(){
        return this.side * Math.sqrt(2);
    }
}
