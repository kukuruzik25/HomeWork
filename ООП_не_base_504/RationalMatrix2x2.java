public class RationalMatrix2x2 {

	private RationalFraction[][] matrix;

	public RationalMatrix2x2() {
		this(new RationalFraction(0,1));
	}

	public RationalMatrix2x2(RationalFraction rational) {
		this(rational, rational, rational, rational);
	}

	public RationalMatrix2x2(RationalFraсtion a11, RationalFraсtion a12, RationalFraсtion a21, RationalFraсtion a22) {
		matrix = new RationalFraction[2][2];
		matrix[0][0] = a11;
		matrix[0][1] = a12;
		matrix[1][0] = a21;
		matrix[1][1] = a22;
	}

	public RationalMatrix2x2 add(RationalMatrix2x2 arr) {
		RationalFraction new_a11 = this.matrix[0][0].add(arr.matrix[0][0]);
		RationalFraction new_a12 = this.matrix[0][1].add(arr.matrix[0][1]);
		RationalFraction new_a21 = this.matrix[1][0].add(arr.matrix[1][0]);
		RationalFraction new_a22 = this.matrix[1][1].add(arr.matrix[1][1]);
		return new RationalMatrix2x2(new_a11, new_a12, new_a21, new_a22);
	} 

	public RationalMatrix2x2 mult(RationalMatrix2x2 arr) {
		RationalFraction new_a11 = this.matrix[0][0].mult(arr.matrix[0][0]).add(this.matrix[0][1].mult(arr.matrix[1][0]));
		RationalFraction new_a12 = this.matrix[0][0].mult(arr.matrix[0][1]).add(this.matrix[0][1].mult(arr.matrix[1][1]));
		RationalFraction new_a21 = this.matrix[1][0].mult(arr.matrix[0][0]).add(this.matrix[1][1].mult(arr.matrix[1][0]));
		RationalFraction new_a22 = this.matrix[1][0].mult(arr.matrix[0][1]).add(this.matrix[1][1].mult(arr.matrix[1][1]));
		return new RationalMatrix2x2(new_a11, new_a12, new_a21, new_a22);
	}

	public RationalFraction det() {
		RationalFraction ad = matrix[0][0].mult(matrix[1][1]);
        RationalFraction bc = matrix[0][1].mult(matrix[1][0]);
        return ad.sub(bc);
	}

	public RationalVector2D multVector(RationalVector2D vector) {
		RationalFraction rezult_x = matrix[0][0].mult(vector.getX()).add(matrix[0][1].mult(vector.getY()));
		RationalFraction rezult_y = matrix[1][0].mult(vector.getX()).add(matrix[1][1].mult(vector.getY()));
		return new RationalVector2D(rezult_x, rezult_y);
	}

	@Override
	public String toString() {
		return "[" + matrix[0][0] + " " + matrix[0][1] + "]\n" +
               "[" + matrix[1][0] + " " + matrix[1][1] + "]";
	} 
}