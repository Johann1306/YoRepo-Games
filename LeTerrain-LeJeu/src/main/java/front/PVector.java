package front;

public class PVector {

    public double x;
    public double y;
    public double z;

    public PVector(double x, double y, double z) {
        super();
        this.x = x;
        this.y = y;
        this.z = z;
    }

    public void normalize() {
        double m = mag(); 
        if (m != 0 && m != 1) { 
          div(m); 
        } 
    }

    public void div(double value) {
        x /= value;
        y /= value;
        z /= value;
    }

    public void mult(double value) {
        x *= value;
        y *= value;
        z *= value;
    }

    public void add(PVector v) {
        x += v.x;
        y += v.y;
        z += v.z;
    }

    public void sub(PVector v) {
        x -= v.x;
        y -= v.y;
        z -= v.z;
    }

    public void limit(float max) {
        if (mag() > max) {
            normalize();
            mult(max);
        }
    }

    public double mag() {
        return Math.sqrt(x * x + y * y + z * z);
    }

    public static PVector sub(PVector v1, PVector v2) {
        return sub(v1, v2, null);
    }

    public static PVector sub(PVector v1, PVector v2, PVector target) {
        if (target == null) {
            target = new PVector(v1.x - v2.x, v1.y - v2.y, v1.z - v2.z);
        } else {
            target.set(v1.x - v2.x, v1.y - v2.y, v1.z - v2.z);
        }
        return target;
    }

    public void set(double x, double y, double z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }
}