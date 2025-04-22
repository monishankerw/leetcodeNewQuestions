package com.leetcode.leetcode.designPattern;
public class DesignPatternDemo {
    public static void main(String[] args) {
        Shape shape1 = Shape.ShapeFactory.getShape("CIRCLE");
        shape1.draw();  // Output: Drawing a Circle

        Shape shape2 = Shape.ShapeFactory.getShape("RECTANGLE");
        shape2.draw();  // Output: Drawing a Rectangle
    }

    public static interface Shape {

        public void draw();

        public static class Circle implements Shape {

            @Override
            public void draw() {
                System.out.println("Drawing a circle");
            }
        }

        public static class Rectangle implements Shape {

            @Override
            public void draw() {
                System.out.println("Drawing a Rectangle");
            }
        }

        public static class ShapeFactory {
            public static Shape getShape(String type) {
                if (type.equalsIgnoreCase("CIRCLE")) {
                    return new Circle();
                } else if (type.equalsIgnoreCase("RECTANGLE")) {
                    return new Rectangle();

                }
                return null;
            }
        }
    }
}


