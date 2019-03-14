package model;

import java.util.ArrayList;

public abstract class Operation {
	protected Polynomial Rest = new Polynomial();

	public Polynomial toPolynomial(String s) {

		Polynomial p = new Polynomial();
		int n = s.length();
		int i = 0;
		char c;
		int k = 0, reprezention = 0, reprezention2 = 0;
		while (i < n) {
			k = 1;
			c = s.charAt(i);
			if (c == '-') {
				k = -1;
				i++;
				c = s.charAt(i);
			} else if (c == '+') {
				i++;
				c = s.charAt(i);
			}
			reprezention *= 10;
			while (c >= '0' && c <= '9') {

				reprezention += Character.getNumericValue(c);
				i++;
				if (i < n)
					c = s.charAt(i);
			}

			if (reprezention == 0)
				reprezention = 1;

			i++;
			if (i < n)
				c = s.charAt(i);

			i++;
			if (i < n)
				c = s.charAt(i);
			reprezention2 *= 10;
			while (c >= '0' && c <= '9' && i < n) {

				reprezention2 = Character.getNumericValue(c);

				i++;
				if (i < n)
					c = s.charAt(i);
			}
			int nr = 0;
			while (reprezention != 0) {
				nr = 10 * nr + reprezention % 10;
				reprezention = reprezention / 10;
			}
			reprezention = nr;
			nr = 0;
			while (reprezention2 != 0) {
				nr = 10 * nr + reprezention2 % 10;
				reprezention2 = reprezention2 / 10;
			}
			reprezention2 = nr;

			reprezention *= k;

			p.add(new IntegerMonomial(reprezention, reprezention2));

			reprezention = 0;
			reprezention2 = 0;
		}

		return p;

	}

	public Polynomial integration(Polynomial a) {
		ArrayList<IntegerMonomial> ai = a.getIntegerPoly();
		int n = ai.size();
		Polynomial c = new Polynomial();

		for (int i = 0; i < n; i++)
			c.add(new DoubleMonomial((double) ai.get(i).getCoeff() / (ai.get(i).getExp() + 1), ai.get(i).getExp() + 1));

		return c;
	}

	public Polynomial getRest() {
		return this.Rest;
	}

	public void setRestZero() {
		this.Rest = new Polynomial();
	}

}
