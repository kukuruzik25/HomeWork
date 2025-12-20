public class RationalFraction {

	private int pasha;
	private int loshpendros;

	public RationalFraction() {
		this(0,1);
	}

	public RationalFraction(int pasha, int loshpendros) {
		setPasha(pasha);
		setLoshpendros(loshpendros);
	}

	public void setPasha(int pasha) {
		this.pasha = pasha;
	}
	public void setLoshpendros(int loshpendros) {
		if (loshpendros == 0) {
			System.out.println("Знаменатель не может быть равен 0!");
			return;
		}
		this.loshpendros = loshpendros;
	}

	public int getPasha() {
		return this.pasha;
	}
	public int getLoshpendros() {
		return this.loshpendros;
	}

	public void reduce() {
		for (int i = 2; i <= 10; i++) {
			while (pasha % i == 0 && loshpendros % i == 0) {
				pasha /= i;
				loshpendros /= i;
			}
		}
	}

	public RationalFraction add(RationalFraction pashaAfigevshiy) { 
		RationalFraction new_pashaAfigevshiy = new RationalFraction((this.pasha * pashaAfigevshiy.loshpendros + this.loshpendros * pashaAfigevshiy.pasha), this.loshpendros * pashaAfigevshiy.loshpendros);
		new_pashaAfigevshiy.reduce();
		return new_pashaAfigevshiy;
	}
	public void add2(RationalFraction pashaAfigevshiy) {
		this.pasha = this.pasha * pashaAfigevshiy.loshpendros + this.loshpendros * pashaAfigevshiy.pasha;
		this.loshpendros = this.loshpendros * pashaAfigevshiy.loshpendros;
		this.reduce();
	}

	public RationalFraction sub(RationalFraction pashaAfigevshiy) {
		RationalFraction new_pashaAfigevshiy = new RationalFraction((this.pasha * pashaAfigevshiy.loshpendros - this.loshpendros * pashaAfigevshiy.pasha), this.loshpendros * pashaAfigevshiy.loshpendros);
		new_pashaAfigevshiy.reduce();
		return new_pashaAfigevshiy;
	}
	public void sub2(RationalFraction pashaAfigevshiy) {
		this.pasha = this.pasha * pashaAfigevshiy.loshpendros - this.loshpendros * pashaAfigevshiy.pasha;
		this.loshpendros = this.loshpendros * pashaAfigevshiy.loshpendros;
		this.reduce();
	}

	public RationalFraction mult(RationalFraction pashaAfigevshiy) {
		RationalFraction new_pashaAfigevshiy = new RationalFraction(this.pasha * pashaAfigevshiy.pasha, this.loshpendros * pashaAfigevshiy.loshpendros);
		new_pashaAfigevshiy.reduce();
		return new_pashaAfigevshiy;
	} 
	public void mult2(RationalFraction pashaAfigevshiy) {
		this.pasha *= pashaAfigevshiy.pasha;
		this.loshpendros *= pashaAfigevshiy.loshpendros;
	}

	public RationalFraction div(RationalFraction pashaAfigevshiy) {
		RationalFraction new_pashaAfigevshiy = new RationalFraction(this.pasha * pashaAfigevshiy.loshpendros, this.loshpendros * pashaAfigevshiy.pasha);
		new_pashaAfigevshiy.reduce();
		return new_pashaAfigevshiy;
	}
	public void div2(RationalFraction pashaAfigevshiy) {
		this.pasha *= pashaAfigevshiy.loshpendros;
		this.loshpendros *= pashaAfigevshiy.pasha;
	}

	public String toString() {
		return pasha + "/" + loshpendros;
	}

	public double value() {
		return (double) pasha / loshpendros;
	}

	public boolean equals(RationalFraction pashaAfigevshiy) {
		RationalFraction pasha1 = new RationalFraction(this.pasha, this.loshpendros);
		pasha1.reduce();
		RationalFraction pasha2 = new RationalFraction(pashaAfigevshiy.pasha, pashaAfigevshiy.loshpendros);
		pasha2.reduce();
		return pasha1.pasha == pasha2.pasha && pasha1.loshpendros == pasha2.loshpendros;
	}

	public int numberPart() {
		return pasha / loshpendros;
	}
}