/*
 * This code is sample code, provided as-is, and we make no
 * warranties as to its correctness or suitability for
 * any purpose.
 *
 * We hope that it's useful to you.  Enjoy.
 * Copyright LearningPatterns Inc.
 */
package com.javatunes.billing;

/**
 * European orders are taxed as follows:
 *  VAT is 17% of taxable amount.
 *  Luxury tax is an additional 25% on amount over $100.
 */

public class EuropeTax implements TaxCalculator{
    private static final double VAT_TAX_RATE = 0.17;
    private static final double LUX_TAX_RATE = 0.20;
    private static final double LUX_THRESHOLD =100.0;

    @Override
    public double taxAmount(double taxable) {
        double vat = taxable * VAT_TAX_RATE;
        double luxTax =0.0;

//        if (taxable > LUXURY_THRESHOLD) {
//            result = vat + ( (taxable - LUXURY_THRESHOLD) * LUXURY_RATE );
//        }
//        else {
//            result = taxable * VAT_RATE;
//        }
//        return result;

        if (taxable > LUX_THRESHOLD) {
            luxTax = (taxable - LUX_THRESHOLD) * LUX_TAX_RATE;
        }
        return vat + luxTax;
    }
}