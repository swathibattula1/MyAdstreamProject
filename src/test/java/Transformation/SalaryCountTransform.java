package Transformation;

import cucumber.api.Transformer;

/**
 * Created by Swathi.Battula on 13/08/2017.
 */
public class SalaryCountTransform extends Transformer<Integer> {

    @Override
    public Integer transform(String Salary){
        return Salary.length();
    }
}



