package model;

public class DoubleMonomial extends Monomial {
	double coeff ;
	public DoubleMonomial(double e, int exp) {
		super(exp);
		this.coeff = e ;
 	}
	public double getCoeff() {
		return coeff;
	}
	public void setCoeff(double coeff) {
		this.coeff = coeff;
	}
	

public String toString () {
		
		return coeff + "X^"+ exp;
		
	}
	

}
