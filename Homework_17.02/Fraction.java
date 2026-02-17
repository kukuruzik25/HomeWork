public class Fraction extends Number {

	private int numerator;
	private int denominator;

	public Fraction(int numerator, int denominator) {
		setNumerator(numerator);
		setDenominator(denominator);
	}

	public void setNumerator(int numerator) {
		this.numerator = numerator;
	}

	public int getNumerator() {
		return this.numerator;
	}

	public void setDenominator(int denominator) {
		if (denominator != 0) {
			this.denominator = denominator;
		} else {
			throw new IllegalArgumentException("опа");
		}
	}

	public int getDenominator() {
		return this.denominator;
	}


	@Override
	public int intValue() {
		return numerator/denominator;
	}

	@Override
	public long longValue() {
		return (double) numerator/denominator;
	}
	
	@Override
	public float floatValue() {
		return (float) numerator/denominator;
	}

	@Override
	public double doubleValue() {
		return (double) numerator/denominator;
	}

	private int nod(int a, int b) {
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }
    
	public String reduce() {
    	int gcd = nod(numerator, denominator);
        numerator = numerator / gcd;
        denominator = denominator / gcd;
        return numerator + "/" + denominator;
	}

	public Fraction add(Fraction drob) {
    	Fraction new_drob = new Fraction((this.numerator * drob.denominator + this.denominator * drob.numerator), this.denominator * drob.denominator);
		new_drob.reduce();
		return new_drob;
  	}

  	public Fraction subtract(Fraction drob) {
    	Fraction new_drob = new Fraction((this.numerator * drob.denominator - this.denominator * drob.numerator), this.denominator * drob.denominator);
		new_drob.reduce();
		return new_drob;
  	}

  	public Fraction multiply(Fraction drob) {
    	Fraction new_drob = new Fraction(this.numerator * drob.numerator, this.denominator * drob.denominator);
		new_drob.reduce();
		return new_drob;
  	}

  	public Fraction divide(Fraction drob) {
  		if (drob.numerator != 0) {
  			Fraction new_drob = new Fraction(this.numerator * drob.denominator, this.denominator * drob.numerator);
			new_drob.reduce();
			return new_drob;
  		} else {
  			throw new ArithmeticException("ойой");
  		}
  	}

  	public Fraction negate() {
  		return -(this.numerator/this.denominator);
  	}

  	public void abs(int a, int b) {
  		int abs_a = a;
  		int abs_b = b;
  		if (a < 0) {
  			abs_a = -a;
  		}
  		if (b < 0) {
  			abs_b = -b;
  		}
  		
  	}

  	public boolean isProper() {
  		return (abs(numerator) < abs(denominator));
  	}

  	@Override
  	public String toString() {
  		return numerator + "/" + denominator;
  	}

  	@Override
  	public Object hashCode() {
  		return Objects.hash(numerator, denominator);
  	}

  	@Override
  	public boolean equals(Fraction drob) {
  		boolean flag = false;
   		if (this.numerator * drob.denominator == this.denominator * drob.numerator){
    		flag = true;
    	}
    	return flag;
	}
}