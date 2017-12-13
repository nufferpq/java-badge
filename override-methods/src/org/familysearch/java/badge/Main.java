package org.familysearch.java.badge;

class Shape {
    public void show(){
        System.out.println("This is Shape");
    }
}

class Square extends Shape {
    @Override
    public void show() {
        System.out.println("This is Square");
    }
}

public class Main {
    public static void main( String[] args ) {
        Shape shape = new Shape();
        shape.show();
        Shape square = new Square();
        square.show();
    }
}
