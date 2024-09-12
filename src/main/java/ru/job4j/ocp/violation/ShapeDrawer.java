package ru.job4j.ocp.violation;

public class ShapeDrawer {
    /*Нарушение: отсутсвие абстракции, для добавления других фигур придется изменять
    существующий метод(добавлять if).
     */
    public void drawShape(String shape) {
        if (shape.equals("circle")) {
            System.out.println("Drawing a circle");
        } else if (shape.equals("square")) {
            System.out.println("Drawing a square");
        }
    }
}
