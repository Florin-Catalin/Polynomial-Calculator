package model;

import java.util.ArrayList;

public class IntegerOperation  extends Operation{

	
	public String stringToIntegerPolynomial(Polynomial poli) {
		String s = "";
		
		ArrayList<IntegerMonomial> Polynomial = new ArrayList<IntegerMonomial>();
		Polynomial = poli.getIntegerPoly();
	
	
		for ( IntegerMonomial var : Polynomial) {
			if (var.getCoeff() > 0)
				s += "+"+ var.getCoeff() +"x^" + var.getExp() ;
			else
				s+= var.getCoeff() + "x^" + var.getExp() ;
	}
	return s;
	}

		public Polynomial addTwoIntegerPoly(Polynomial a, Polynomial b) {

			ArrayList<IntegerMonomial> ai = a.getIntegerPoly();
			ArrayList<IntegerMonomial> bi = b.getIntegerPoly();
			Polynomial c = new Polynomial();
			int n = ai.size();
			int m = bi.size();


		for (IntegerMonomial var : bi) {
			ai.add(new IntegerMonomial (var.getCoeff(),var.getExp())) ;
				
			}
		

			int max = 0;
			if (bi.get(0).getExp() > ai.get(0).getExp())
				max = bi.get(0).getExp();
			else
				max = ai.get(0).getExp();
			
			
			int indice;

			for (int i = max; i >= 0; i--) {

				indice = 0;
				for (int j = 0; j < m + n; j++)
					if (ai.get(j).getExp() == i) {
						indice += ai.get(j).getCoeff();
					}
				if (indice != 0)
					c.add(new IntegerMonomial(indice, i));
			}
             
			return c;
		}
		
		public Polynomial subtractTwoIntegerPoly(Polynomial a, Polynomial b) {

			ArrayList<IntegerMonomial> ai = a.getIntegerPoly();
			ArrayList<IntegerMonomial> bi = b.getIntegerPoly();
			Polynomial c = new Polynomial();
			int n = ai.size();
			int m = bi.size();

			for (int i = 0; i < m; i++)
				ai.add(new IntegerMonomial(bi.get(i).getCoeff() * (-1), bi.get(i).getExp()));

			int max = 0;
			if (bi.get(0).getExp() > ai.get(0).getExp())
				max = bi.get(0).getExp();
			else
				max = ai.get(0).getExp();
			int indice;

			for (int i = max; i >= 0; i--) {

				indice = 0;
				for (int j = 0; j < m + n; j++)
					if (ai.get(j).getExp() == i) {
						indice += ai.get(j).getCoeff();
					}
				if (indice != 0)
					c.add(new IntegerMonomial(indice, i));
			}

			return c;
		}
 
		public Polynomial karatsuba ( Polynomial a, Polynomial b) {
			
			Polynomial product = new Polynomial ();
		 
			product.setSize(2*a.size);
			// handle the case where the polynomial has only one coefficient 
			if (a.size == 1) 
		product.add(new IntegerMonomial (1, a.getIntegerPoly().get(0).getCoeff() + b.getIntegerPoly().get(0).getCoeff()));
				
			int halfPolynomialSize = a.size/2 ;
			
			//declare polynomial to hold hlved factors 
			
			Polynomial aLow  = new Polynomial ();
			aLow.setSize(halfPolynomialSize);
			Polynomial aHigh  = new Polynomial ();
			aHigh.setSize(halfPolynomialSize);
			
			
			Polynomial bLow  = new Polynomial ();
			bLow.setSize(halfPolynomialSize);
			Polynomial bHigh  = new Polynomial ();
			bHigh.setSize(halfPolynomialSize);
			
			
			
			Polynomial aHighLow = new Polynomial();
			aHighLow.setSize(halfPolynomialSize);
			Polynomial bHighLow = new Polynomial();
			bHighLow.setSize(halfPolynomialSize);
			
			
			//filling the low and high arrays
			for (int halfSizeIndex =0 ; halfSizeIndex < halfPolynomialSize ; halfSizeIndex ++) {
				aLow.add(new IntegerMonomial (halfSizeIndex, a.getIntegerPoly().get(halfSizeIndex).getCoeff()));
				aHigh.add(new IntegerMonomial (halfSizeIndex + halfPolynomialSize , a.getIntegerPoly().get(halfSizeIndex).getCoeff()));
				
			 aHighLow = addTwoIntegerPoly(aLow , aHigh);
			 
			 
			 bLow.add(new IntegerMonomial (halfSizeIndex, b.getIntegerPoly().get(halfSizeIndex).getCoeff()));
				bHigh.add(new IntegerMonomial (halfSizeIndex + halfPolynomialSize , b.getIntegerPoly().get(halfSizeIndex).getCoeff()));
			 
			bHighLow = addTwoIntegerPoly(aLow,aHigh);
			
			}
			
			
			//Recursively call method on smaller polynomials and construct the low and high parts of the product 
			
			Polynomial pLow =  karatsuba (aLow , bLow);
			Polynomial pHigh = karatsuba (aHigh,bHigh);
			Polynomial pHighLow = karatsuba (aHighLow,bHighLow);
			
			//construct the middle portion of the product 
			
			Polynomial pMiddle  = new Polynomial ();
			
			for (int halfSizeIndex = 0; halfSizeIndex  < a.size ; ++ halfSizeIndex) {
			pMiddle.add(new IntegerMonomial (halfSizeIndex  ,pHighLow.getIntegerPoly().get(halfSizeIndex).getCoeff()
					-pHigh.getIntegerPoly().get(halfSizeIndex).getCoeff() - pLow.getIntegerPoly().get(halfSizeIndex).getCoeff()));
							}
			
			//assemble the product from the low,middle and high prts. Start with the low and high parts of the product.
			
			for (int halfSizeIndex = 0 , middleOfSet = a.size/2 ; halfSizeIndex < a.size ; halfSizeIndex ++) {
	  product.add (new IntegerMonomial (halfSizeIndex ,product.getIntegerPoly().get(halfSizeIndex).getCoeff()
			  + pLow.getIntegerPoly().get(halfSizeIndex).getCoeff() ));
	  
	  product.add (new IntegerMonomial (halfSizeIndex + a.size  ,product.getIntegerPoly().get(halfSizeIndex + a.size).getCoeff()
			  + pHigh.getIntegerPoly().get(halfSizeIndex).getCoeff() ));
	  
	  product.add (new IntegerMonomial (halfSizeIndex + middleOfSet  ,product.getIntegerPoly().get(halfSizeIndex + middleOfSet).getCoeff()
			  + pHigh.getIntegerPoly().get(halfSizeIndex).getCoeff() ));
			}
			
			
				
			
			return product ;
			
		}

	
		public Polynomial derivation(Polynomial a) {
			int newCoeff = 0,newExp ;
			ArrayList<IntegerMonomial> ai = a.getIntegerPoly();
			Polynomial c = new Polynomial();
		
			for (IntegerMonomial var : ai) {
				if (var.getExp() != 0)
				newCoeff = var.getExp() * var.getCoeff() ;
				if (var.getExp() == 0)
					newExp = 0 ;
				else 
				   newExp = var.getExp() - 1;
				
				c.add(new IntegerMonomial(newCoeff ,newExp));
					
				
			}
			


			return c;
		}
		

}
