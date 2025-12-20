public class ComplexMatrix2x2 {

	private ComplexNumber[][] matrix;

	public ComplexMatrix2x2() {
		this(new ComplexNumber(0, 0));
	}
	public ComplexMatrix2x2(ComplexNumber num) {
		this(num, num, num, num);
	}
	public ComplexMatrix2x2(ComplexNumber a11, ComplexNumber a12, ComplexNumber a21, ComplexNumber a22) {
		matrix = new ComplexNumber[2][2];
		matrix[0][0] = a11;
		matrix[0][1] = a12;
		matrix[1][0] = a21;
		matrix[1][1] = a22;
	}

	public ComplexMatrix2x2 add(ComplexMatrix2x2 complex) {
		ComplexNumber new_a11 = this.matrix[0][0].add(complex.matrix[0][0]);
		ComplexNumber new_a12 = this.matrix[0][1].add(complex.matrix[0][1]);
		ComplexNumber new_a21 = this.matrix[1][0].add(complex.matrix[1][0]);
		ComplexNumber new_a22 = this.matrix[1][1].add(complex.matrix[1][1]);
		return new ComplexMatrix2x2(new_a11, new_a12, new_a21, new_a22);
	}

	public ComplexMatrix2x2 mult(ComplexMatrix2x2 complex) {
		ComplexNumber new_a11 = this.matrix[0][0].mult(complex.matrix[0][0]).add(this.matrix[0][1].mult(complex.matrix[1][0]));
		ComplexNumber new_a12 = this.matrix[0][0].mult(complex.matrix[0][1]).add(this.matrix[0][1].mult(complex.matrix[1][1]));
		ComplexNumber new_a21 = this.matrix[1][0].mult(complex.matrix[0][0]).add(this.matrix[1][1].mult(complex.matrix[1][0]));
		ComplexNumber new_a22 = this.matrix[1][0].mult(complex.matrix[0][1]).add(this.matrix[1][1].mult(complex.matrix[1][1]));
		return new ComplexMatrix2x2(new_a11, new_a12, new_a21, new_a22);
	}

	public ComplexNumber det() {
		ComplexNumber ad = matrix[0][0].mult(matrix[1][1]);
        ComplexNumber bc = matrix[0][1].mult(matrix[1][0]);
        return ad.sub(bc);
	}

	public ComplexVector2D multVector(ComplexVector2D vector) {
		ComplexNumber rezult_x = matrix[0][0].mult(vector.getX()).add(matrix[0][1].mult(vector.getY()));
		ComplexNumber rezult_y = matrix[1][0].mult(vector.getX()).add(matrix[1][1].mult(vector.getY()));
		return new ComplexVector2D(rezult_x, rezult_y);
	}

	@Override
    public String toString() {
        return "[" + matrix[0][0] + " " + matrix[0][1] + "]\n" +
               "[" + matrix[1][0] + " " + matrix[1][1] + "]";
    }
}