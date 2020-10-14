package com.kenez92;

import com.kenez92.predictors.ConservativePredictor;

public class IndividualYoungCustomer extends Customer {
    public IndividualYoungCustomer(String name) {
        super(name);
        this.buyPredictor = new ConservativePredictor();
    }
}
