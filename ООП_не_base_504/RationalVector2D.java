public class RationalVector2D {

	private RationalFraction x;
	private RationalFraction y;

	public class RationalVector2D() {
		this((0,1), (0,1));
	}

	public class RationalVector2D(RationalFraction x, RationalFraction y) {
		setX(x);
		setY(y);
	}

	public void setX(RationalFraction x) {
		this.x = x;
	}
	public void setY(RationalFraction y) {
		this.y = y;
	}

	public getX(RationalFraction x) {
		return this.x;
	}
	public getY(RationalFraction y) {
		return this.y;
	}

	public RationalVector2D add(RationalVector2D vector) {
		RationalFraction newX = this.x.add(vector.x);
		RationalFraction newY = this.y.add(vector.y);
		return new RationalFraction(newX, newY);
	}

	@Override
	public String toString() {
		return "(" + x.toString() + ", " + y.toString() + ")";
	}

	public double length() {
		RationalFraction newX = this.x.value();
		RationalFraction newY = this.y.value();
		return Math.sqrt(newX * newX + newY * newY);
	}

	public RationalFraction scalarProduct(RationalVector2D vector) {
		RationalFraction newX = this.x.mult(vector.x);
		RationalFraction newY = this.y.mult(vector.y);
		return newX.add(newY);
	}

	public boolean equals(RationalVector2D vector) {
		return this.x.equals(vector.x) && this.y(vector.y);
	}
}