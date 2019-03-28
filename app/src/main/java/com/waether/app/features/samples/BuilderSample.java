package com.waether.app.features.samples;

// Builder pattern


// parameters are optional
public class BuilderSample {


    private final Integer intOne;
    private final String stringOne;
    private final int intTwo;
    private final String stringTwo;
    private final Object object;
    private final Double number;

    private BuilderSample(Builder builder) {

        this.intOne = builder.intOne;
        this.stringOne = builder.stringOne;
        this.intTwo = builder.intTwo;
        this.stringTwo = builder.stringTwo;
        this.object = builder.object;
        this.number = builder.number;
    }

    public static class Builder {

        private Integer intOne;
        private String stringOne = "1";
        private int intTwo;
        private String stringTwo = "2";
        private Object object;
        private Double number = 1D;

        public Builder() {
        }

        public Builder intOne(Integer intOne){
            this.intOne  = intOne;
            return this;
        }

        public Builder stringOne(String stringOne){
            this.stringOne  = stringOne;
            return this;
        }

        public Builder intTwo(Integer intTwo){
            this.intTwo  = intTwo;
            return this;
        }

        public Builder stringTwo(String stringTwo){
            this.stringTwo  = stringTwo;
            return this;
        }

        // and the rest of the variables

        public BuilderSample build(){
            return new BuilderSample(this);
        }

    }


}

class BuilderMain{
    public static void main(String[] args) {
        BuilderSample builderSample = new BuilderSample.Builder()
                .intOne(1)
                .stringOne("989")
                .build();
    }
}


// another solution : Parameter Object 


class MultipleArgsObject {

    private final Integer intOne;
    private final String stringOne;
    private final int intTwo;
    private final String stringTwo;
    private final Object object;
    private final Double number;

    public MultipleArgsObject(MultipleArgsParameter parameter) {
        intOne = parameter.intOne;
        stringOne = parameter.stringOne;
        intTwo = parameter.intTwo;
        stringTwo = parameter.stringTwo;
        object = parameter.object;
        number = parameter.number;
    }
}

class MultipleArgsParameter {
    Integer intOne;
    String stringOne;
    int intTwo;
    String stringTwo;
    Object object;
    Double number;
}


class Main {
    public static void main(String[] args) {


        MultipleArgsParameter parameter = new MultipleArgsParameter();
        parameter.intOne = 1;
        parameter.intTwo = 2;
        parameter.number = 5D;
        parameter.object = new Object();
        parameter.stringOne = "1";
        parameter.stringTwo = "2";

        MultipleArgsObject myObject = new MultipleArgsObject(parameter);


    }
}