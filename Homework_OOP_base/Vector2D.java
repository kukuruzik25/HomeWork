public class Vector2D {

	private double x;
	private double y;

	public static final double POGRESHNOST = 0.0000000000000001;

	public Vector2D() {
		this(0.0,0.0);
	}

	public Vector2D(double x, double y) {
		setX(x);
		setY(y);
	}

	public void setX(double x) {
		this.x = x;
	}
	public void setY(double y) {
		this.y = y;
	}

	public double getX() {
		return this.x;
	}
	public double getY() {
		return this.y;
	}
	public static double getPogreshnost() {
    return POGRESHNOST;
	}

	public Vector2D add(Vector2D new_vector) {
		return new Vector2D(this.x + new_vector.x, this.y + new_vector.y);
	}
	public void add2(Vector2D new_vector) {
		this.x += new_vector.x;
		this.y += new_vector.y;
	}

	public Vector2D sub(Vector2D new_vector) {
		return new Vector2D(this.x - new_vector.x, this.y - new_vector.y);
	}
	public void sub2(Vector2D new_vector) {
		this.x -= new_vector.x;
		this.y -= new_vector.y;
	}

	public Vector2D mult(double number) {
		return new Vector2D(this.x * number, this.y * number);
	}
	public void mult2(double number) {
		this.x *= number;
		this.y *= number;
	}

	public String toString() {
		return "(" + this.x + ", " + this.y + ")";
	}

	public double length() {
		return Math.sqrt(x*x + y*y);
	}

	public double scalarProduct(Vector2D new_vector) {
		return this.x * new_vector.x + this.y * new_vector.y;
	} 

	public double cos(Vector2D new_vector) {
		double gipotenuza = this.length(); 
		double new_gipotenuza = new_vector.length();
		double proizv = this.scalarProduct(new_vector);
		if (gipotenuza == 0 || new_gipotenuza == 0) {
			return 0;
		}
		return proizv / (gipotenuza * new_gipotenuza);
	}

	public boolean equals(Vector2D new_vector) {
		return Math.abs(this.x - new_vector.x) < pogreshnost && Math.abs(this.y - new_vector.y) < pogreshnost;
	}
}