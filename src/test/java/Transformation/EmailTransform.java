package Transformation;

import cucumber.api.Transformer;

/**
 * Created by Swathi.Battula on 13/08/2017.
 */
public class EmailTransform extends Transformer<String> {


    @Override
    public String transform(String Username){
        return Username.concat("gmail.com");
    }
}
