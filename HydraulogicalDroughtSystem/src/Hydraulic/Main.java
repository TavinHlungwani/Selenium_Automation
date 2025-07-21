package Hydraulic;
import java.util.Scanner;
import org.apache.commons.math3.special.Gamma;
import org.apache.commons.math3.distribution.GammaDistribution;
import org.apache.commons.math3.distribution.NormalDistribution;

public class Main {

	public static void main(String[] args) {
		
		//Capture Variables
		Scanner scanner = new Scanner(System.in);

        // Ask for the number of variables
        System.out.print("Enter the number of variables: ");
        int numVariables = scanner.nextInt();
        
        // Store the variables in an array
        double numbers[] = new double[numVariables];
        double sum = 0;

        // Input the variables (from index 0 to 2, i.e. array starts at index 0)
        for (int i = 0; i < numVariables; i++) {
        	System.out.println("Enter Variable: " + i);
            numbers[i] = scanner.nextDouble();
            sum += numbers[i];  // Accumulate the sum
        }

        // Calculate and print the mean
        double mean = sum / numVariables;
        System.out.println("Mean: " + mean);
        
        // Calculate the sum of squared differences from the Mean
        double squaredDifferenceSum = 0;
        for (int i = 0; i < numVariables; i++) {
            squaredDifferenceSum += Math.pow(numbers[i] - mean, 2);
        }

        // Calculate and print the Variance
        double variance = squaredDifferenceSum / numVariables;
        System.out.println("Variance: " + variance);
        
        //Calculate and print Shape Parameter
        double shapeParameter = 0;
        shapeParameter = (mean * mean) / variance;
        System.out.println("Shape Parameter: " + shapeParameter);
        
        //Calculate and Print the Scale Factor
        double scaleFactor = 0;
        scaleFactor = mean / variance;
        System.out.println("Scale Factor: " + scaleFactor);
        
        //Invoke, Compute and print Gamma PDF and CDF at each Variable
        for(int x=0; x<numVariables; x++) {
        	double pdf = gammaPDF(numbers[x], shapeParameter, scaleFactor);
            System.out.println("Gamma PDF at Variable = " + numbers[x] + " is: " + pdf);
        }
        
        System.out.print("\n");
        
        //Calculate and Pint Cumulative Distribution Function (CDF)
        for(int x = 0; x < numVariables; x++) {
        	 // Create a GammaDistribution object with Shape Parameter and Scale Factor
            GammaDistribution gammaDist = new GammaDistribution(shapeParameter, scaleFactor);
            // Calculate the CDF at Variable
            double cdf = gammaDist.cumulativeProbability(numbers[x]);
            System.out.println("Gamma CDF at Variable = " + numbers[x] + " is: " + cdf);
        }
        
        System.out.print("\n");
        
        //Standardized Data
        double standardDeviation = Math.sqrt(variance);
        for(int x = 0; x < numVariables; x++) {
        	 // Calculate the z-score
            double zScore = calculateZScore(numbers[x], mean, standardDeviation);
            //System.out.println("Standardized z-score: " + zScore);
            // Create a standard normal distribution
            NormalDistribution standardNormal = new NormalDistribution(mean, standardDeviation);
            // Calculate the CDF of the z-score
            double cdf = standardNormal.cumulativeProbability(zScore);
            // Output the result
            System.out.println("CDF of the Standardized Value at Variable "+ numbers[x] + " is: " + cdf);
        }
	}
	
	// Method to compute Gamma PDF
    public static double gammaPDF(double numVars, double alpha, double beta) {
        if (numVars < 0) {
            return 0; // Gamma distribution is defined for x >= 0
        }
        // Using the formula: (beta^alpha * x^(alpha-1) * exp(-beta*x)) / Gamma(alpha)
        double gammaValue = Gamma.gamma(alpha);
        return Math.pow(beta, alpha) * Math.pow(numVars, alpha - 1) * Math.exp(-beta * numVars) / gammaValue;
    }
    
    // Method to calculate the z-score (standardization)
    public static double calculateZScore(double numVariables, double mean, double stddev) {
        return (numVariables - mean) / stddev;
    }

}