package river;

import shape.Point;

public class NullRiver implements IWaterSource {
    @Override
    public void load(Point point) {
        System.out.println("No river exists!");
    }

    @Override
    public void draw() {

    }

    @Override
    public void releaseCanvas() {

    }

    @Override
    public void getCanvas() {

    }
}
