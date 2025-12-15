public class Matrix2x2 {

	private double[][] matrix;

	public Matrix2x2() {
		this(new double[2][2]);
	}

	public Matrix2x2(double num) {
		this(new double[][]{{num, num}, {num, num}});
	}

	public Matrix2x2 (double[][] arr) {
		if (arr == null || arr.length != 2 || arr[0].length != 2 || arr[1].length != 2) {
			for (int i = 0; i < 2; i++) {
				for (int j = 0; j < 2; j++) {
					this.matrix[i][j] = arr[i][j];
				}
			}
		} else {
			this.matrix[2][2];
		}
	}

	public Matrix2x2 (double a, double b, double c, double d) {
		this(new double[][]{{a, b}, {c, d}});
	}

	public void set(int ryad, int stolb, int num) {
		if ((ryad >= 0 && ryad < 2) || (stolb >= 0 && stolb < 2)) {
			matrix[ryad][stolb] = num;
		}
	}

	public double get(int ryad, int stolb) {
		if ((ryad >= 0 && ryad < 2) || (stolb >= 0 && stolb < 2)) {
			return matrix[ryad][stolb];
		}
	}

	public Matrix2x2 add(Matrix2x2 arr) {
		double[][] rezult = new double[2][2];
		for (int i = 0; i < 2; i++) {
			for (int j = 0; j < 2; j++) {
				rezult[i][j] = arr[i][j] + this.matrix[i][j];
			}
		}
		retrun new Matrix2x2(rezult);
	}	
	public void add2(Matrix2x2 arr) {
		for (int i = 0; i < 2; i++) {
			for (int j = 0; j < 2; j++) {
				this.matrix[i][j] += arr[i][j];
			}
		}
	}

	public Matrix2x2 sub(Matrix2x2 arr) {
		double[][] rezult = new double[2][2];
		for (int i = 0; i < 2; i++) {
			for (int j = 0; j < 2; j++) {
				rezult[i][j] = arr[i][j] - this.matrix[i][j];
			}
		}
		retrun new Matrix2x2(rezult);
	}	
	public void sub2(Matrix2x2 arr) {
		for (int i = 0; i < 2; i++) {
			for (int j = 0; j < 2; j++) {
				this.matrix[i][j] -= arr[i][j];
			}
		}
	}

	public Matrix2x2 multNumber(double num) {
		double[][] rezult = new double[2][2];
		for (int i = 0; i < 2; i++) {
			for (int j = 0; j < 2; j++) {
				rezult[i][j] = this.matrix[i][j] * num;
			}
		}
		return new Matrix2x2(rezult);
	}
	public void multNumber2(double num) {
		for (int i = 0; i < 2; i++) {
			for (int j = 0; j < 2; j++) {
				this.matrix[i][j] *= num;
			}
		}
	}

	public Matrix2x2 mult(Matrix2x2 arr) {
		double[][] rezult = new double[2][2];
		for (int i = 0; i < 2; i++) {
			for (int j = 0; j < 2; j++) {
				rezult[i][j] += this.matrix[i][j] * arr[j][i]
			}
		}
	}
	public void mult2(Matrix2x2 arr) {
		for (int i = 0; i < 2; i++) {
			for (int j = 0; j < 2; j++) {
				this.matrix[i][j] += this.matrix[i][j] * arr[j][i]
			}
		}
	}

	public double det() {
		retrun this.matrix[0][0] * this.matrix[1][1] - this.matrix[0][1] * this.matrix[1][0];
	}

	public void transpon() {
		for (int i = 0; i < 2; i++) {
			for (int j = 0; j < 2; j++) {
				this.matrix[i][j] = matrix[j][i];
			}
		}
	}

	public Matrix2x2 inverseMatrix() {
		double determinant = this.det();
        if (Math.abs(determinant) < 0.0000001) {
            System.out.println("Обратной матрицы не существует!");
            return new Matrix2x2();
        }
        double a = matrix[0][0];
        double b = matrix[0][1];
        double c = matrix[1][0];
        double d = matrix[1][1];
        return new Matrix2x2(d / determinant, -b / determinant, -c / determinant, a / determinant);
	}

	public Matrix2x2 equivalentDiagonal() {
		return new Matrix2x2(matrix[0][0], 0, 0, matrix[1][1]);
	}

	public Vector2D multVector(Vector2D vector) {
		double xx = this.Matrix[0][0] * vector.getX() + this.Matrix[0][1] * vector.getY();
        double yy = this.Matrix[1][0] * vector.getX() + this.Matrix[1][1] * vector.getY();
        
        return new Vector2D(xx, yy);
	}
}