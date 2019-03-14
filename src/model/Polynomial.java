package model;


import java.util.ArrayList;
import java.util.Iterator;

public  class Polynomial {
	protected ArrayList<Monomial> monomial = new ArrayList <Monomial> () ;
	int size = monomial.size();
	
	public void add(IntegerMonomial elem) {
		monomial.add(elem);
	}
	
	public void add(DoubleMonomial elem) {
		monomial.add(elem);
	}
	public void remove(DoubleMonomial elem) {
		monomial.remove(elem);
	}
//	public void removeIth (int i) {
//		Monomial.remove(i);
//	}
	public int size() {
		return this.size();
		
	}
	
	public void setSize (int size) {
		  this.size = size;
	}
	
	public ArrayList<DoubleMonomial> getDoublePoly() {
		ArrayList<DoubleMonomial> monomialList = new ArrayList<DoubleMonomial>();
		Iterator<Monomial> it = monomial.iterator();
		while (it.hasNext()) {
			Monomial s = (Monomial) it.next();
			if (s instanceof DoubleMonomial)
				monomialList.add((DoubleMonomial) s);
		}
		return monomialList;
	}
	
	
	
	public ArrayList<IntegerMonomial> getIntegerPoly() {
		ArrayList<IntegerMonomial> monomialList = new ArrayList<IntegerMonomial>();
		Iterator<Monomial> it = monomial.iterator();
		while (it.hasNext()) {
			Monomial s = (Monomial) it.next();
			if (s instanceof IntegerMonomial)
				monomialList.add((IntegerMonomial) s);
		}
		return monomialList;
	}
	
	
	public ArrayList<Monomial> getPolynomial(){
		return monomial;
	}
		
	
		
	

}
