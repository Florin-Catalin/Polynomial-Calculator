package model;


public abstract class Monomial {

	protected int exp = 0;

	public int getExp() {
		return this.exp;
	}

	public void setExp(int exp) {
		this.exp = exp;

	}

	
	public Monomial(int exp) {
		this.exp = exp;
	}

}
