package river;

import canvas.CanvasSingleton;
import javafx.event.EventHandler;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.input.MouseEvent;
import javafx.scene.shape.ArcType;
import shape.Point;

public class EgyptianKingsWaterSource implements IWaterSource {
    private Canvas canvas;
    private boolean shouldBeDrawn;
    private CanvasSingleton canvasSingleton;

    private Point center;

    public EgyptianKingsWaterSource() {
        canvasSingleton = CanvasSingleton.getInstance();
        this.canvas = canvasSingleton.getCanvas();
    }

    private void calculateCornerPoints(Point selectedPoint) {
        center = new Point(selectedPoint.x, selectedPoint.y);
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

                            graphicsContext.strokeArc(center.x, center.y, 12, 12, 0, 360, ArcType.OPEN);
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