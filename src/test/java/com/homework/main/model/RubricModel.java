package com.homework.main.model;

public class RubricModel {

    private String rubric;
    private String subRubric;
    private String subSubRubric;

    private String price;


    public RubricModel(String rubric, String subRubric, String subSubRubric) {
        this.rubric = rubric;
        this.subRubric = subRubric;
        this.subSubRubric = subSubRubric;
    }

    public String getRubric() {
        return rubric;
    }

    public String getSubRubric() {
        return subRubric;
    }

    public String getSubSubRubric() {
        return subSubRubric;
    }
}
