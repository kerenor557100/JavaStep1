package primitives;

import com.sun.deploy.security.ruleset.ExceptionRule;
import com.sun.xml.internal.ws.api.message.ExceptionHasMessage;
import com.sun.xml.internal.ws.api.model.ExceptionType;
import java.lang.Math;

import java.nio.charset.CoderResult;
import java.util.Objects;

import java.util.Objects;

public class Vector {
    private  Point3D _head;

    public  final static Vector ZERO = new Vector(new Point3D(new Coordinate(0.0),new Coordinate(0.0),new Coordinate(0.0)));

    /**
     * Constractor
     * • Builders receiving:
     * a) three coordinates,
     * b) three double-digit numbers,
     * c) a point,
     * d) a vector
     * @param _head
     */
    public Vector(Point3D _head) {
        Point3D Zero=new Point3D(new Coordinate(0.0),new Coordinate(0.0),new Coordinate(0.0));

        if (_head != Zero)
            this._head = _head;

        else throw new IllegalArgumentException (  "head cannot be the zero vector");


    }
    public Vector (Coordinate _x,Coordinate _y,Coordinate _z){
        Point3D _head =new Point3D(new Coordinate(_x),new Coordinate(_y),new Coordinate(_z));
        Point3D Zero=new Point3D(new Coordinate(0.0),new Coordinate(0.0),new Coordinate(0.0));

        if (_head != Zero)
            this._head = _head;

        else throw new IllegalArgumentException (  "head cannot be the zero vector");


    }

    public Vector(double _x,double _y,double _z){
        Point3D _head=new Point3D(_x,_y,_z);
        Point3D Zero=new Point3D(new Coordinate(0.0),new Coordinate(0.0),new Coordinate(0.0));

        if (_head != Zero)
            this._head = _head;

        else throw new IllegalArgumentException (  "head cannot be the zero vector");

    }
    public Vector(Vector _head)
    {
        Vector v2=new Vector(_head.get_head().get_x(),_head.get_head().get_y(),_head.get_head().get_z());
        this._head=v2._head;
    }
    public Vector subtract(Vector vec){
        return new Vector(
                this._head.get_x().get()-vec._head.get_x().get(),
                this._head.get_y().get()-vec._head.get_y().get(),
                this._head.get_z().get()-vec._head.get_z().get());
    }
    public Vector add(Vector vec){
        return new Vector(
                this._head.get_x().get()+vec._head.get_x().get(),
                this._head.get_y().get()+vec._head.get_y().get(),
                this._head.get_z().get()+vec._head.get_z().get());
    }
    public Vector scale(double scalingFacor) {
        return new Vector(
                new Point3D(
                        new Coordinate(scalingFacor * _head._x._coord),
                        new Coordinate(scalingFacor * _head._y._coord),
                        new Coordinate(scalingFacor * _head._z._coord)));
    }

    public double dotProduct(Vector v) {
        return (this._head._x._coord * v._head._x._coord +
                this._head._y._coord * v._head._y._coord +
                this._head._z._coord * v._head._z._coord);
    }
    public Vector crossProduct(Vector v) {
        double w1 = this._head._y._coord * v._head._z._coord - this._head._z._coord * v._head._y._coord;
        double w2 = this._head._z._coord * v._head._x._coord - this._head._x._coord * v._head._z._coord;
        double w3 = this._head._x._coord * v._head._y._coord - this._head._y._coord * v._head._x._coord;

        return new Vector(new Point3D(w1, w2, w3));
    }
    public double lengthSquared() {
        double xx = this._head._x._coord * this._head._x._coord;
        double yy = this._head._y._coord * this._head._y._coord;
        double zz = this._head._z._coord * this._head._z._coord;

        return xx + yy + zz;

    }
    public double length() {
        return Math.sqrt(lengthSquared());
    }


    /**
     * get Fun return _head
     * @return
     */
    public Point3D get_head() {
        return _head;
    }

    /**
     * set Fun set Point to _head
     * @param _head
     */
    public void set_head(Point3D _head) {
        this._head = _head;
    }



    /**
     * override equal fun
     * @param o
     * @return
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Vector vector = (Vector) o;
        return Objects.equals(_head, vector._head);
    }

    @Override
    public int hashCode() {
        return Objects.hash(_head);
    }

    public Vector normalize() {

        double x = this._head._x._coord;
        double y = this._head._y._coord;
        double z = this._head._z._coord;

        double length = this.length();

        if (length == 0)
            throw new ArithmeticException("divide by Zero");

        this._head._x = new Coordinate(x / length);
        this._head._y = new Coordinate(y / length);
        this._head._z = new Coordinate(z / length);

        return this;
    }

    public Vector normalized() {
        Vector vector = new Vector(this);
        vector.normalize();
        return vector;
    }

    @Override
    public String toString() {
        return "Vector{" +
                "_head=" + _head +
                '}';
    }
}
