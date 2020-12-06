package allFigure;
import java.util.Random;

public class Circle extends Figure{
    int radius = new Random().nextInt(10);

    @Override
    public double square() {
        final double Pi = 3.1415926536;
      return (Pi*radius*radius);
    }
}
