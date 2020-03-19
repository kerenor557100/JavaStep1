package primitives;

public class Point3D {
    private  Coordinate _x;
    private Coordinate _y;
    private Coordinate _z;

    /**
     *  Builders that receive:
     *  a) three coordinates,
     *  b) three double-digit numbers,
     *  c) a point
     * @param _x
     * @param _y
     * @param _z
     */
    public Point3D(Coordinate _x, Coordinate _y, Coordinate _z) {
        this._x = _x;
        this._y = _y;
        this._z = _z;
    }
    public Point3D(Point3D other)
    {
        Point3D p2=new Point3D(other._x,other._y,other._z);
        this._x = p2._x;
        this._y = p2._y;
        this._z = p2._z;
    }
    public Point3D(double _x,double _y,double _z)
    {
        Coordinate coorX =new Coordinate(_x);
        Coordinate coorY =new Coordinate(_y);
        Coordinate coorZ =new Coordinate(_z);


        this._x = coorX;
        this._y = coorY;
        this._z = coorZ;
    }
    public Coordinate get_x() {
        return _x;
    }

    public void set_x(Coordinate _x) {
        this._x = _x;
    }

    public Coordinate get_y() {
        return _y;
    }

    public void set_y(Coordinate _y) {
        this._y = _y;
    }

    public Coordinate get_z() {
        return _z;
    }

    public void set_z(Coordinate _z) {
        this._z = _z;
    }

    /**
     * override equals
     * @param o
     * @return
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Point3D point3D = (Point3D) o;
        return _x.equals(point3D._x) &&
                _y.equals(point3D._y) &&
                _z.equals(point3D._z);
    }

    /**
     * add - Adds a vector to a point -
     * returns a new point
     * @param vec
     * @return
     */

    public Vector subtract (Vector vertex) {
        if (this.equals(vertex.get_head()) == true)
            return Vector.ZERO;
        else {
            double dX = (this._x.get() - vertex.get_head()._x.get());
            double dY = (this._y.get() - vertex.get_head()._y.get());
            double dZ = (this._z.get() - vertex.get_head()._z.get());
            return new Vector(new Point3D(new Coordinate(dX), new Coordinate(dY), new Coordinate(dZ)));
        }


    }

    /**
     * distanceSquared - The squeeze between two squares
     * @param p2
     * @return
     */
    public double distanceSquared(Point3D other)
    {
        return ( (other._x._coord - this._x._coord) * (other._x._coord - this._x._coord) +
                (other._y._coord - this._y._coord) * (other._y._coord - this._y._coord) +
                (other._z._coord - this._z._coord) * (other._z._coord - this._z._coord));
    }
    }

    /**
     * distance - distance between 2 points
     * @param p2
     * @return
     */
    public double distance (Point3D other){
        return Math.sqrt(distanceSquared(other));
    }

    /**
     * subtract - vector subtraction - receives a second
     * point in the parameter, returns a vector from the second point
     * to the point at which the operation is performed
     * @param vertex
     * @return
     */
    public Point3D add(Vector v) {
        return new Point3D(this._x._coord + v._head._x._coord,
                this._y._coord + v._head._y._coord,
                this._z._coord + v._head._z._coord);
    }


    }

    /**
     * to string fun override
     * @return
     */
    @Override
    public String toString() {
        return "Point3D{" +
                "_x=" + _x +
                ", _y=" + _y +
                ", _z=" + _z +
                '}';
    }
}
