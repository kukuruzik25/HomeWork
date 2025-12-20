public class ComplexVector2D {

	private ComplexNumber x;
	private ComplexNumber y;

	public ComplexVector2D() {
		this(new ComplexNumber(0.0, 0.0), new ComplexNumber(0.0, 0.0));
	}

	public ComplexVector2D(ComplexNumber x, ComplexNumber y) {
		setX(x);
        setY(y);
	}

	public void setX(ComplexNumber x) {
        this.x = x;
    }
    public void setY(ComplexNumber y) {
        this.y = y;
    }

    public ComplexNumber getX() {
        return this.x;
    }
    public ComplexNumber getY() {
        return this.y;
    } 

	public ComplexVector2D add(ComplexVector2D vector) {
		ComplexNumber newX = this.x.add(vector.x);
		ComplexNumber newY = this.y.add(vector.y);
		return new ComplexVector2D(newX, newY);
	} 

	@Override
	public String toString() {
		return  return "(" + x.toString() + ", " + y.toString() + ")";
	}	

	public ComplexNumber scalarProduct(ComplexVector2D vector) {
		ComplexNumber newX = this.x.mult(vector.x);
		ComplexNumber newY = this.y.mult(vector.y);
		return new ComplexNumber(newX, newY);
	}

	public boolean equals(ComplexVector2D vector) {
		return (this.x.equals(vector.x) && this.y.equals(vector.y));
	} 
}