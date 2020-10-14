package com.kenez92;

import com.kenez92.predictors.AggressivePredictor;

public class IndividualCustomer extends Customer {
    public IndividualCustomer(String name) {
        super(name);
        this.buyPredictor = new AggressivePredictor();
    }
}
