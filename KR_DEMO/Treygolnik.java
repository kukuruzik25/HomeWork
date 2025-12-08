public class Treygolnik {

	private double x1, y1;
	private double x2, y2;
	private double x3, y3;

	public Treygolnik(double x1, double y1, double x2, double y2, double x3, double y3) {
		this.x1 = x1; this.y1 = y1;
		this.x2 = x2; this.y2 = y2;
		this.x3 = x3; this.y3 = y3;
	}

	public double sqrt(double x) {
		if (x < 0) {
			return -1;
		}
		if (x == 0) {
			return 0;
		}
		double y = x;
		for (int i = 0; i < 20; i++) {
			y = 0.5 * (y + x / y)
		}
		return y;
	}

	public double pow(double num, int stepen) {
		double rezult = 1;
		for (int i = 0; i < stepen; i++) {
			rezult *= num;
		}
		return rezult;
	}

	public double abs(double num) {
		return (num < 0 ? -num : num);
	}

	public boolean isEqual(double x, double y) {
		return abs(x - y) < 0.00000000001;
	} 

	public double getA() {
		return sqrt(pow((x2 - x1),2) + pow((y2 - y1), 2));
	}
	public double getB() {
		return sqrt(pow((x3 - x2),2) + pow((y3 - y2), 2));
	}
	public double getC() {
		return sqrt(pow((x3 - x1),2) + pow((y3 - y1), 2));
	}

	public double perimetr() {
		return getA() + getB() + getC();
	}

	public double ploshad() {
		double a = getA();
		double b = getB();
		double c = getC();

		double p = perimetr() / 2;

		return sqrt(p * (p - a) * (p - b) * (p - c));
	}

	public boolean pryamoyg() {
		double a = getA();
		double b = getB();
		double c = getC();

		double max = a;
		double side1 = b;
		double side2 = c;

		if (b > max) {
			max = b;
			side1 = a;
		}
		if (c > max) {
			max = c;
			side2 = a;
		}

		return (pow(max, 2) - (pow(side1, 2) + pow(side2, 2))) < 0.000000001;
	}

	public boolean ravnobedr() {
		double a = getA();
		double b = getB();
		double c = getC();
		return isEqual(a, b) || isEqual(b, c) || isEqual(a, c);
	}

	public boolean equals(Treygolnik other) {
		double a = getA();
		double b = getB();
		double c = getC();

		double a1 = other.getA1();
		double b1 = other.getB1();
		double c1 = other.getC1();

		return (isEqual(a, a1) && isEqual(a, b1) && isEqual(a, c1)) || (isEqual(b, a1) && isEqual(b, b1) && isEqual(b, c1)) || (isEqual(c, a1) && isEqual(c, b1) && isEqual(c, c1));
	}
}	