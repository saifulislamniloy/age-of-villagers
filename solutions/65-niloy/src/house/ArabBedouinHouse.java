package house;

import canvas.CanvasSingleton;
import javafx.event.EventHandler;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.input.MouseEvent;
import shape.Point;

public class ArabBedouinHouse implements IHouse{
    private Canvas canvas;
    private boolean shouldBeDrawn = true;

    private Point one;
    private Point two;
    private Point three;
    private Point four;
    private Point five;


    public ArabBedouinHouse() {
        CanvasSingleton canvasSingleton = CanvasSingleton.getInstance();
        this.canvas = canvasSingleton.getCanvas();
    }

    private void calculateCornerPoints(Point selectedPoint) {
        one = new Point(selectedPoint.x-12, selectedPoint.y + 8);
        two = new Point(selectedPoint.x , selectedPoint.y +8);
        three = new Point(selectedPoint.x + 12, selectedPoint.y + 8);
        four = new Point(selectedPoint.x + 6, selectedPoint.y - 8);
        five = new Point(selectedPoint.x - 6, selectedPoint.y - 8);
    }

    @Override
    public void draw() {
        final GraphicsContext graphicsContext = canvas.getGraphicsContext2D();

        canvas.addEventHandler(MouseEvent.MOUSE_PRESSED,
                new EventHandler<MouseEvent>() {

                    @Override
                    public void handle(MouseEvent event) {
                        if (shouldBeDrawn) {
                            calculateCornerPoints(new Point((int) event.getX(), (int) event.getY()));

                            graphicsContext.strokeLine(one.x, one.y, two.x, two.y);
                            graphicsContext.strokeLine(two.x, two.y, three.x, three.y);
                            graphicsContext.strokeLine(three.x, three.y, four.x, four.y);
                            graphicsContext.strokeLine(four.x, four.y, five.x, five.y);
                            graphicsContext.strokeLine(five.x, five.y, one.x, one.y);
                            graphicsContext.strokeLine(two.x, two.y, five.x, five.y);
                            System.out.println("inside arab tree");
                        }
                    }
                });
    }

    @Override
    public void releaseCanvas() {
        shouldBeDrawn = false;
    }

    @Override
    public void getCanvas() {
        shouldBeDrawn = true;
    }
}