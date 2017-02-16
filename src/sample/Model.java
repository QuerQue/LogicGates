package sample;

/**
 * Created by Tomek on 2/15/2017.
 */

public class Model
{

    public int transformToInt(String value){

        int transformed=0;

        switch (value) {
            case "zero":
                transformed = 0;
            break;
            case "one":
                transformed = 1;
            break;
        }
        return transformed;
    }

    public int notCalculation(int value){
        int notValue = value;
        notValue = (notValue == 0 ? 1 : 0);

        return notValue;
    }

    public boolean andCalculation(int value1, int value2){
        boolean andValue;

        andValue = (value1==1 && value2==1);

        return andValue;
    }

    public boolean orCalculation(int value1, int value2){
        boolean orValue;

        orValue = (value1==1 || value2==1);

        return orValue;
    }

    public boolean norCalculation(int value1, int value2){
        boolean norValue;

        norValue = !(value1==1 || value2==1);

        return norValue;
    }


    public boolean nandCalculation(int value1, int value2){
        boolean nandValue;

        nandValue = !(value1==1 && value2==1);

        return nandValue;
    }


}
