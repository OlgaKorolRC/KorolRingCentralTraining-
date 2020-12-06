package childAndGames;

import java.util.Random;

/*
2. Сезонные радости
Создайте enum Season с 4 временами года.
Создайте enum Games с 4 играми.

В каждое время года можно играть ровно в одну игру:
Зима - снежки
Весна - запуск корабликов по ручьям
Лето - собирание и поедание ягод
Осень - измерение глубины луж методом "сапога"

Создайте класс Person. У него есть имя и любимый сезон.
Создайте массив на 10 элементов с людьми со случайными именами и любимыми сезонами.

Для каждого человека выведите любимую игру.

Рекомендации:
в Season определите дополнительное поле - игра для сезона.

 */
public class Person {
    String name;
    Season loveSeason;

    Person(String name, Season loveSeason) {
        this.name = name;
        this.loveSeason = loveSeason;
    }
    public static void main(String[] args) {
        String[] name = {
                "Artem",
                "Sofia",
                "Alexander",
                "Victoria",
                "Michael",
                "Anna",
                "Maxim",
                "Maria",
                "Ivan",
                "Alice",
        };

        Person[] chelovechechki = new Person[10];
        for (int i = 0; i < chelovechechki.length; i++) {
            Person newPeople = new Person(name[new Random().nextInt(name.length)], Season.getRandom());
            System.out.println("Love game for " + newPeople.name + " is " + newPeople.loveSeason.seasonGame);
        }
    }
}

enum Season {
    WINTER(Games.SNOWBALLS),
    SPRING(Games.LAUNCHING_BOATS_ON_STREAMS),
    SUMMER(Games.PICKING_AND_EATING_BERRIES),
    FALL(Games.MEASURING_THE_DEPTH_OF_PUDDLES_USING_THE_BOOT_METHOD);

    Games seasonGame;

    Season(Games seasonGame) {
        this.seasonGame = seasonGame;
    }

    public Games getSeasonGame() {
        return seasonGame;
    }

    public static Season getRandom() {
        return values()[(int) (Math.random() * values().length)];
    }
}

enum Games {
    SNOWBALLS,
    LAUNCHING_BOATS_ON_STREAMS,
    PICKING_AND_EATING_BERRIES,
    MEASURING_THE_DEPTH_OF_PUDDLES_USING_THE_BOOT_METHOD
}