public class ComplexNumber {

	public static final double pogreshnost = 0.000000000000001;

	private double real;
	private double fake;

	public ComplexNumber() {
		this(0.0, 0.0);
	}

	public ComplexNumber(double real, double fake) {
		this.real = real;
		this.fake = fake;
	}

	public void setReal(double real) {
		this.real = real;
	}
	public void setFake(double fake) {
		this.fake = fake;
	}

	public double getReal() {
		return this.real;
	}
	public double getFake() {
		return this.fake;
	}

	public ComplexNumber add(ComplexNumber chislo2) {
		return new ComplexNumber(this.real + chislo2.real, this.fake + chislo2.fake);
	}
	public void add2(ComplexNumber chislo2) {
		this.real += chislo2.real;
		this.fake += chislo2.fake;
	}

	public ComplexNumber sub(ComplexNumber chislo2) {
		return new ComplexNumber(this.real - chislo2.real, this.fake - chislo2.fake);
	}
	public void sub2(ComplexNumber chislo2) {
		this.real -= chislo2.real;
		this.fake -= chislo2.fake;
	}

	public ComplexNumber multNumber(double num) {
		return new ComplexNumber(this.real * num, this.fake * num);
	}
	public void multNumber2(double num) {
		this.real *= num;
		this.fake *= num;
	}

	public ComplexNumber mult(ComplexNumber chislo2) {
		double real_new = this.real * chislo2.real - this.fake * chislo2.fake;
		double fake_new = this.real * chislo2.fake + this.fake * chislo2.real;
		return new ComplexNumber(real_new, fake_new);
	}
	public void mult2(ComplexNumber chislo2) {
		double old_real = this.real;
		double new_real = this.real * chislo2.real - this.fake * chislo2.fake;
		double new_fake = this.real * chislo2.fake + this.fake * chislo2.real;
		this.real = new_real;
		this.fake = new_fake;
	}

	public ComplexNumber div(ComplexNumber chislo2) {
		double real_new = this.real * chislo2.real + this.fake * chislo2.fake;
		double fake_new = this.fake * chislo2.real - this.real * chislo2.fake;
		double drob = chislo2.real * chislo2.real + chislo2.fake * chislo2.fake;
		return new ComplexNumber(real_new / drob, fake_new / drob);
	}
	public void div2(ComplexNumber chislo2) {
		double old_real = this.real;
		this.real = (old_real * chislo2.real + this.fake * chislo2.fake) / (chislo2.real * chislo2.real + chislo2.fake * chislo2.fake);
		this.fake = (this.fake * chislo2.real - old_real * chislo2.fake) / (chislo2.real * chislo2.real + chislo2.fake * chislo2.fake);
	}

	public double length() {
		return Math.sqrt(this.real * this.real + this.fake * this.fake);
	}

	public String toString() {
		if (fake >= 0) {
            return real + " + " + fake + "i";
        } else {
            return real + " - " + (-fake) + "i";
        }
	}

	public double arg() {
		return Math.atan2(fake, real);
	}

	public ComplexNumber pow(double num) {
		double r = this.length();
		double newR = Math.pow(r, num);
		double phi = this.arg();  
		double newPhi = num * phi;
		double newReal = newR * Math.cos(newPhi);
        double newFake = newR * Math.sin(newPhi);
        return new ComplexNumber(newReal, newFake);
	} 

	public boolean equals(ComplexNumber chislo2) {
		return Math.abs(this.real - chislo2.real) < pogreshnost && Math.abs(this.fake - chislo2.fake) < pogreshnost;
	}
}