package sample;

/**
 * Created by Tomek on 2/15/2017.
 */

public class Model
{
    //transform string value to int
    public int transformToInt(String value){

        int transformed=0;

        switch (value) {
            case "0":
                transformed = 0;
            break;
            case "1":
                transformed = 1;
            break;
        }
        return transformed;
    }

    public int notCalculation(int value){
        boolean notValue;
        int convertedToInt;
        notValue = (value == 0 ? true : false);
        convertedToInt = (notValue) ? 1 : 0; //I want to return int value so need to replace true to 1 and false to 0

        return convertedToInt;
    }

    public int andCalculation(int value1, int value2){
        boolean andValue;
        int convertedToInt;
        andValue = (value1==1 && value2==1);
        convertedToInt = (andValue) ? 1 : 0;
        return convertedToInt;
    }

    public int andCalculation(int value1, int value2, int value3){
        boolean andValue;
        int convertedToInt;
        andValue = (value1==1 && value2==1 && value3==1);
        convertedToInt = (andValue) ? 1 : 0;
        return convertedToInt;
    }

    public int orCalculation(int value1, int value2){
        boolean orValue;
        int convertedToInt;
        orValue = (value1==1 || value2==1);
        convertedToInt = (orValue) ? 1 : 0;
        return convertedToInt;
    }

    public int orCalculation(int value1, int value2, int value3){
        boolean orValue;
        int convertedToInt;
        orValue = (value1==1 || value2==1 || value3==1);
        convertedToInt = (orValue) ? 1 : 0;
        return convertedToInt;
    }

    public int nandCalculation(int value1, int value2){
        boolean nandValue;
        int convertedToInt;
        nandValue = !(value1==1 && value2==1);
        convertedToInt = (nandValue) ? 1 : 0;
        return convertedToInt;
    }

    public int nandCalculation(int value1, int value2, int value3){
        boolean nandValue;
        int convertedToInt;
        nandValue = !(value1==1 && value2==1 && value3==1);
        convertedToInt = (nandValue) ? 1 : 0;
        return convertedToInt;
    }

    public int norCalculation(int value1, int value2){
        boolean norValue;
        int convertedToInt;
        norValue = !(value1==1 || value2==1);
        convertedToInt = (norValue) ? 1 : 0;
        return convertedToInt;
    }

    public int norCalculation(int value1, int value2, int value3){
        boolean norValue;
        int convertedToInt;
        norValue = !(value1==1 || value2==1 || value3==1);
        convertedToInt = (norValue) ? 1 : 0;
        return convertedToInt;
    }

}
