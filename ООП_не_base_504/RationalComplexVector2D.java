public class RationalComplexVector2D {

	private RationalComplexNumber x;
    private RationalComplexNumber y;

    public RationalComplexVector2D() {
        this(new RationalComplexNumber(), new RationalComplexNumber());
    }

    public RationalComplexVector2D(RationalComplexNumber x, RationalComplexNumber y) {
        setX(x);
        setY(y);
    }

     public void setX(RationalComplexNumber  x) {
        this.x = x;
    }
    public void setY(RationalComplexNumber  y) {
        this.y = y;
    }
    
    public RationalComplexNumber  getReal() {
        return this.x;
    }
    public RationalComplexNumber  getFake() {
        return this.y;
    }

     public RationalComplexVector2D add(RationalComplexVector2D vector) {
        RationalComplexNumber new_x = this.x.add(vector.x);
        RationalComplexNumber new_y = this.y.add(vector.y);
        return new RationalComplexVector2D(new_x, new_y);
    }
    
    public RationalComplexNumber scalarProduct(RationalComplexVector2D vector) {
        RationalComplexNumber new_x = this.x.mult(vector.x);
        RationalComplexNumber new_y = this.y.mult(vector.y);
        return new_x.add(new_y);
    }
    
    @Override
    public String toString() {
        return "(" + x.toString() + ", " + y.toString() + ")";
    }
}