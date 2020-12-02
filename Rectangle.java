package allFigure;
import java.util.Random;

public class Rectangle extends Figure{
    int width = new Random().nextInt(20);
    int height = new Random().nextInt(20);

    @Override
    public double square() {
        return (width*height);
    }
}
