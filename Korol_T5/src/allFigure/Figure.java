package allFigure;
import java.util.Random;
/*
1. Абстрактный супрематизм

Создать абстрактный класс Figure, описывающий фигуру на двумерной плоскости с декартовыми координатами центра x,y.
В классе объявить абстрактный метод square, который вычисляет площадь фигуры.
В классе объявить и реализовать метод getQuadrant(), который возвращает четверть на координатной плоскости, в которой лежит центр фигуры.
Для описания четверти используйте Enum с четырьями значениями: I,II,III,IV


Создать классы-наследники:
Circle - дополнительный параметр радиус, от 0 до 10
Rectangle - дополнительные параметры ширина и высота, от 0 до 20.

В каждом классе определить метод square, чтобы он правильно считал площадь.

в main'e создать массив на 5 элементов типа Figure, заполните любыми фигурами (не обязательно случайными), выведите все фигуры в формате
"Название фигуры - площадь"

 */
public abstract class Figure {
    int coordinateX = new Random().nextInt();
    int coordinateY = new Random().nextInt();
    String type;
    public abstract double square();

    public Quadrants getQuadrant () throws IllegalAccessException {
    if (coordinateX > 0 && coordinateY > 0) {
        return Quadrants.I;
        } else if (coordinateX < 0 && coordinateY > 0) {
            return Quadrants.II;
            } else if (coordinateX < 0 && coordinateY < 0) {
                 return Quadrants.III;
                } else if (coordinateX > 0 && coordinateY < 0)
                    {
                        return Quadrants.IV;
                    }
    else {
        throw new IllegalAccessException("Center of figure replaced by axis");
        }
    }

    public static void main(String[] args) {

        Figure[] fiveFigures = {new Circle(), new Rectangle(), new Circle(), new Rectangle(), new Circle()};
        for (Figure oneFigure : fiveFigures) {
            System.out.println("For this " + oneFigure.getClass().getSimpleName() + " square is " + oneFigure.square());
        }
    }
}

enum Quadrants {
    I,
    II,
    III,
    IV
}
