public class RationalComplexNumber {
	private RationalFraction real;
    private RationalFraction fake;

    public RationalComplexNumber() {
        this(new RationalFraction(0, 1), new RationalFraction(0, 1));
    }

    public RationalComplexNumber(RationalFraction real, RationalFraction fake) {
        setReal(real);
        setFake(fake);
    }

     public void setReal(RationalFraction real) {
        this.real = real;
    }
    public void setFake(RationalFraction fake) {
        this.fake = fake;
    }
    
    public RationalFraction getReal() {
        return this.real;
    }
    public RationalFraction getFake() {
        return this.fake;
    }

    public RationalComplexNumber add(RationalComplexNumber num) {
        RationalFraction new_real = this.real.add(num.real);
        RationalFraction new_fake = this.fake.add(num.fake);
        return new RationalComplexNumber(new_real, new_fake);
    }

    public RationalComplexNumber sub(RationalComplexNumber num) {
        RationalFraction new_real = this.real.sub(num.real);
        RationalFraction new_fake = this.fake.sub(num.fake);
        return new RationalComplexNumber(new_real, new_fake);
    }

    public RationalComplexNumber mult(RationalComplexNumber num) {
        RationalFraction ac = this.real.mult(num.real);
        RationalFraction bd = this.fake.mult(num.fake);
        RationalFraction ad = this.real.mult(num.fake);
        RationalFraction bc = this.fake.mult(num.real);
        
        RationalFraction new_real = ac.sub(bd);
        RationalFraction new_fake = ad.add(bc);
        
        return new RationalComplexNumber(new_real, new_fake);
    }
     @Override
    public String toString() {
        if (fake.value() == 0) {
            return real.toString();
        } else if (real.value() == 0) {
            return fake.toString() + " * i";
        } else {
            if (fake.value() > 0) {
                return real.toString() + " + " + fake.toString() + " * i";
            } else {
                RationalFraction plus = new RationalFraction(-fake.getPasha(), fake.getLoshpendros());
                return real.toString() + " - " + plus.toString() + " * i";
            }
        }    
}