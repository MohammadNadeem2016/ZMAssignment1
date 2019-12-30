/**
 * 
 */
package com.Pages;

/**
 * @author $Mohammad_Nadeem$
 *
 */

public class BothComparison{
	
	int AmazonPrice;
	int FlipkartPrice;
	

public BothComparison(int AmazonPrice, int FlipkartPrice)
{
	
	this.AmazonPrice=AmazonPrice;
	this.FlipkartPrice=FlipkartPrice;
	
if(AmazonPrice==FlipkartPrice) {
	System.out.println("");
	System.out.println("Both the Prices are equal and i.e = " + AmazonPrice + ", " +FlipkartPrice);
	
	
}
else if(AmazonPrice<FlipkartPrice) {
	System.out.println("");
	System.out.println("Amazon Apple iPhone XR (Yellow, 64 GB) Price is cheaper compare to Flipkart Price and i.e = " + AmazonPrice);
	
	
}
else{
	System.out.println("");
	System.out.println("Flipkart Apple iPhone XR (Yellow, 64 GB) Price is cheaper compare to Amazon Price and i.e = " +FlipkartPrice);
	
	
}

}
	
}



