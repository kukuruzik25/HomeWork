public class RationalComplexMatrix2x2 {

	private RationalComplexNumber[][] matrix;

	public RationalComplexMatrix2x2() {
        this(new RationalComplexNumber());
    }
    
    public RationalComplexMatrix2x2(RationalComplexNumber num) {
        this(num, num, num, num);
    }
    
    public RationalComplexMatrix2x2(RationalComplexNumber a11, RationalComplexNumber a12, RationalComplexNumber a21, RationalComplexNumber a22) {
        matrix = new RationalComplexNumber[2][2];
        matrix[0][0] = a11;
        matrix[0][1] = a12;
        matrix[1][0] = a21;
        matrix[1][1] = a22;
    }
    
    public RationalComplexMatrix2x2 add(RationalComplexMatrix2x2 complex) {
        RationalComplexNumber new_a11 = this.matrix[0][0].add(complex.matrix[0][0]);
        RationalComplexNumber new_a12 = this.matrix[0][1].add(complex.matrix[0][1]);
        RationalComplexNumber new_a21 = this.matrix[1][0].add(complex.matrix[1][0]);
        RationalComplexNumber new_a22 = this.matrix[1][1].add(complex.matrix[1][1]);
        
        return new RationalComplexMatrix2x2(new_a11, new_a12, new_a21, new_a22);
    }
    
    public RationalComplexMatrix2x2 mult(RationalComplexMatrix2x2 complex) {
        RationalComplexNumber new_a11 = this.matrix[0][0].mult(complex.matrix[0][0]).add(this.matrix[0][1].mult(complex.matrix[1][0]));
        RationalComplexNumber new_a12 = this.matrix[0][0].mult(complex.matrix[0][1]).add(this.matrix[0][1].mult(complex.matrix[1][1]));
        RationalComplexNumber new_a21 = this.matrix[1][0].mult(complex.matrix[0][0]).add(this.matrix[1][1].mult(complex.matrix[1][0]));
        RationalComplexNumber new_a22 = this.matrix[1][0].mult(complex.matrix[0][1]).add(this.matrix[1][1].mult(complex.matrix[1][1]));
        return new RationalComplexMatrix2x2(new_a11, new_a12, new_a21, new_a22);
    }
    
    public RationalComplexNumber det() {
        RationalComplexNumber ad = matrix[0][0].mult(matrix[1][1]);
        RationalComplexNumber bc = matrix[0][1].mult(matrix[1][0]);
        return ad.sub(bc);
    }
    
    public RationalComplexVector2D multVector(RationalComplexVector2D vector) {
        RationalComplexNumber rezult_x = matrix[0][0].mult(vector.getX()).add(matrix[0][1].mult(vector.getY()));
        RationalComplexNumber rezult_y = matrix[1][0].mult(vector.getX()).add(matrix[1][1].mult(vector.getY()));
        return new RationalComplexVector2D(rezult_x, rezult_y);
    }
    
    @Override
    public String toString() {
        return "[" + matrix[0][0] + " " + matrix[0][1] + "]\n" +
               "[" + matrix[1][0] + " " + matrix[1][1] + "]";
    }
}