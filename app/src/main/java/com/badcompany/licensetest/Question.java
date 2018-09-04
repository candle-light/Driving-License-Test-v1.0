package com.badcompany.licensetest;


/**
 * Created by Donatas on 28/08/2018.
 */

public class Question {


    private String question;
    private String imagename;
    private String category;
    private String answera;
    private String answerb;
    private String answerc;
    private String answerd;

    public Question(){}

    public Question(String question, String imagename, String category, String answera, String answerb, String answerc, String answerd){
        this.question = question;
        this.imagename  = imagename;
        this.category = category;
        this.answera = answera;
        this.answerb = answerb;
        this.answerc = answerc;
        this.answerd = answerd;
    }

   /* @Override
    public String toString(){
        return "Question: \n\t id = " + id + ",\n\t\t Question = " + question + ",\n\t\t ImageName = " + imagename + ",\n\t\t Category = " +
                category + ",\n\t\t\t AnswerA = " + answera + ",\n\t\t\t AnswerB = " + answerb + ",\n\t\t\t AnswerC = " + answerc+ ",\n\t\t\t AnswerD = " + answerd + "\n";
    }*/


    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public String getImagename() {
        return imagename;
    }

    public void setImagename(String imagename) {
        this.imagename = imagename;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getAnswera() {
        return answera;
    }

    public void setAnswera(String answera) {
        this.answera = answera;
    }

    public String getAnswerb() {
        return answerb;
    }

    public void setAnswerb(String answerb) {
        this.answerb = answerb;
    }

    public String getAnswerc() {
        return answerc;
    }

    public void setAnswerc(String answerc) {
        this.answerc = answerc;
    }

    public String getAnswerd() {
        return answerd;
    }

    public void setAnswerd(String answerd) {
        this.answerd = answerd;
    }
}
