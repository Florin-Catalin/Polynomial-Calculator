package model;

import java.util.ArrayList;

public class DoubleOperation extends Operation {


	public String doublePolynomialToString(Polynomial poli) {
		String stringForm = "";
		
		ArrayList<DoubleMonomial> Polynomial = new ArrayList<DoubleMonomial>();
		Polynomial = poli.getDoublePoly();
		if (Polynomial.size() != 0)
			stringForm += String.format("%.2f", Polynomial.get(0).getCoeff()) + "x^" + Polynomial.get(0).getExp();
		for (int i = 1; i < Polynomial.size(); i++) {
			if (Polynomial.get(i).getCoeff() < 0)
				stringForm +=  String.format("%.2f", Polynomial.get(i).getCoeff()) + "x^" + Polynomial.get(i).getExp();
		
			else
				stringForm += "+" + String.format("%.2f", Polynomial.get(i).getCoeff()) + "x^" + Polynomial.get(i).getExp();
				
		}
		return stringForm;
	}

	public Polynomial monomialsToPoly(ArrayList<DoubleMonomial> nou) {
		Polynomial p = new Polynomial();

		for (DoubleMonomial var : nou) {
			p.add(var);

		}

		return p;

	}

	public Polynomial addTwoDoublePoly(Polynomial a, Polynomial b) {

		ArrayList<DoubleMonomial> ar = a.getDoublePoly();
		ArrayList<DoubleMonomial> br = b.getDoublePoly();
		Polynomial c = new Polynomial();
		
	

		for (int i = 0; i < br.size(); i++)
			ar.add(new DoubleMonomial(br.get(i).getCoeff(), br.get(i).getExp()));

		int max = 0;
		if (br.get(0).getExp() > ar.get(0).getExp())
			max = br.get(0).getExp();
		else
			max = ar.get(0).getExp();
		int coefficient;

		for (int i = max; i >= 0; i--) {

			coefficient = 0;
			for (int j = 0; j < br.size() + ar.size(); j++)
				if (ar.get(j).getExp() == i) {
					coefficient += ar.get(j).getCoeff();
				}
			if (coefficient != 0)
				c.add(new DoubleMonomial(coefficient, i));
		}

		return c;
	}

	public Polynomial subtractTwoDoublePoly(Polynomial a, Polynomial b) {

		ArrayList<DoubleMonomial> ar = a.getDoublePoly();
		ArrayList<DoubleMonomial> br = b.getDoublePoly();
		Polynomial c = new Polynomial();
		int n = ar.size();
		int m = br.size();

		for (int i = 0; i < m; i++)
			ar.add(new DoubleMonomial(br.get(i).getCoeff() * (-1), br.get(i).getExp()));

		int max = 0;
		if (br.get(0).getExp() > ar.get(0).getExp())
			max = br.get(0).getExp();
		else
			max = ar.get(0).getExp();
		int coefficient;

		for (int i = max; i >= 0; i--) {

			coefficient = 0;
			for (int j = 0; j < m + n; j++)
				if (ar.get(j).getExp() == i) {
					coefficient += ar.get(j).getCoeff();
				}
			if (coefficient != 0)
				c.add(new DoubleMonomial(coefficient, i));
		}
		if (c.getPolynomial().size() == 0)
			c.add(new DoubleMonomial(0.0, 0));
		return c;
	}

	public Polynomial multiplyTwoDoublePoly(Polynomial a, Polynomial b) {
		ArrayList<DoubleMonomial> ar = a.getDoublePoly();
		ArrayList<DoubleMonomial> br = b.getDoublePoly();
		int n = ar.size();
		int m = br.size();

		Polynomial c = new Polynomial();
		Polynomial d = new Polynomial();

		for (int i = 0; i < n; i++)
			for (int j = 0; j < m; j++)
				d.add(new DoubleMonomial(ar.get(i).getCoeff() * br.get(j).getCoeff(),
						ar.get(i).getExp() + br.get(j).getExp()));
		int max = (ar.get(0).getExp() + br.get(0).getExp());
		int coefficient;

		for (int i = max; i >= 0; i--) {

			coefficient = 0;
			for (int j = 0; j < m * n; j++)
				if (d.getDoublePoly().get(j).getExp() == i) {
					coefficient += d.getDoublePoly().get(j).getCoeff();
				}
			if (coefficient != 0)
				c.add(new DoubleMonomial(coefficient, i));
		}
		if (c.getPolynomial().size() == 0)
			c.add(new DoubleMonomial(0.0, 0));

		return c;
	}

	public double doubleInput(String a, String b, Polynomial p1) {

		int numar = 0;
		char c = a.charAt(0);
		for (int i = 0; i < a.length(); i++) {
			numar *= 10;

			numar += Character.getNumericValue(c);

			if (i < a.length())
				c = a.charAt(i);
		}

		int numar2 = 0;
		c = b.charAt(0);
		numar2 *= 10;
		for (int i = 0; i < b.length(); i++) {
			numar2 *= 10;
			numar2 += Character.getNumericValue(c);

			if (i < b.length())
				c = b.charAt(i);

		}

		int j;
		int nr1 = numar, nr2 = numar2;
		double coef = 0.0, suma = 0.0;
		for (int i = 0; i < p1.getPolynomial().size(); i++) {
			numar = nr1;
			numar2 = nr2;
			coef = p1.getDoublePoly().get(i).getCoeff();

			for (j = 0; j < coef; j++)
				numar *= numar;
			for (j = 0; j < coef; j++)
				numar2 *= numar2;
			numar = numar - numar2;
			coef = numar * coef;
			suma += coef;
		}
		return suma;
	}

	Polynomial rest = new Polynomial();

	public Polynomial divideTwoPoly(Polynomial a, Polynomial b) {

		Polynomial aux = new Polynomial();
		Polynomial aux2 = new Polynomial();
		ArrayList<IntegerMonomial> ai = a.getIntegerPoly();
		ArrayList<IntegerMonomial> bi = b.getIntegerPoly();
		ArrayList<DoubleMonomial> br = new ArrayList<DoubleMonomial>();
		ArrayList<DoubleMonomial> restul = new ArrayList<DoubleMonomial>();
		DoubleMonomial mon = new DoubleMonomial(0, 0);
		int n = ai.size();
		int m = bi.size();
		Polynomial c = new Polynomial();
		for (int i = 0; i < n; i++) {
			mon = new DoubleMonomial(ai.get(i).getCoeff(), ai.get(i).getExp());
			restul.add(mon);

		}

		for (int i = 0; i < m; i++) {
			mon = new DoubleMonomial(bi.get(i).getCoeff(), bi.get(i).getExp());
			br.add(mon);
		}

		while (restul.get(0).getExp() >= br.get(0).getExp()) {
			mon = new DoubleMonomial(restul.get(0).getCoeff() / br.get(0).getCoeff(),
					restul.get(0).getExp() - br.get(0).getExp());
			c.add(mon);
			aux = new Polynomial();
			aux.add(mon);
			aux2 = multiplyTwoDoublePoly(aux, monomialsToPoly(br));
			rest = subtractTwoDoublePoly(monomialsToPoly(restul), aux2);
			restul = rest.getDoublePoly();

		}

		Rest = monomialsToPoly(restul);

		return c;
	}

}
