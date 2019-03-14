package model;

public class IntegerMonomial extends Monomial{
	private int coeff  ; 

	public int getCoeff() {
		return coeff;
	}

	public void setCoeff(int coeff) {
		this.coeff = coeff;
	}

	public IntegerMonomial(int coeff, int exp) {
		super(exp) ;
		this.coeff = coeff ;
		
		
	}
	
	/**
	 * return the string representation of the monomial
	 */	
	public String toString () {
		
		return coeff + "X^"+ exp;
		
	}
	
	


}
