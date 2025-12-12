public class Main_OOP {
	
	Vector2D vector1 = new Vector2D(5.2, 3.4);
	Vector2D vector2 = new Vector2D(1.0, -2.1);

	RationalFraction fraction1 = new RationalFraction(2,5);
	RationalFraction fraction2 = new RationalFraction(1,3);

	ComplexNumber number1 = new ComplexNumber(1.2, 5.0);
	ComplexNumber number2 = new ComplexNumber(2.3, 4.1);

	double arr1 = {2.1, 7.0, 1.8, 3.3};
	double arr2 = {3.0, 4.3, 1.0, 4.3};
	Matrix2x2 matrix1 = new Matrix2x2(arr1);
	Matrix2x2 matrix2 = new Matrix2x2(arr2);

	vector1.add(vector2);
	vector2.mult(vector1);
	System.out.println();

	
}