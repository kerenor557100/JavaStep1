package primitives;

public class Vector {
    private  Point3D _head;

    public  final static Vector ZERO = new Vector(new Point3D(new Coordinate(0.0),new Coordinate(0.0),new Coordinate(0.0)));

    public Vector(Point3D _head) {
        this._head = _head;
    }

    public Point3D get_head() {
        return _head;
    }

    public void set_head(Point3D _head) {
        this._head = _head;
    }

    public double dotProduct(Vector n) {
        return 0.0;
    }

    public Vector crossProduct(Vector edge2) {
        return Vector.ZERO;
    }
}
