package com.example.salim_chahed__mesure_glycemie.model;

public class Patient {
    int age;
    double val;
    boolean jeunz;
    String res;

    public String getRes() {
        return res;
    }


    public Patient(int age,double val,boolean jeunz){
        this.jeunz=jeunz;
        this.val=val;
        this.age=age;
        calcule();
    }
    public Patient(){

    }

    public void calcule(){
        if (jeunz) {
            if (age < 6 && age != 0) {
                if (val >= 5.5 && val <= 10.0) {
                    res=("niv de glycemi est normal");

                } else if (val < 5.5){
                    res=("niv de glycemi est trop bas");

                }else
                {
                    res=("niv de glycemi est trop eleve");

                }
            } else if (age >= 6 && age < 12) {
                if (val >= 5.0 && val <= 10.0) {
                    res=("niv de glycemi est normal");

                } else if (val < 5.0){
                    res=("niv de glycemi est trop bas ");

                }else{
                   res=("niv de glycemi est trop eleve");

                }
            } else if (age >= 12) {
                if (val >= 5.0 && val <= 7.2) {

                    res=("niv de glycemi est normal");
                } else if (val < 5.0){

                    res=("niv de glycemi est trop bas");
                }
                else {

                    res=("niv de glycemi est trop eleve");
                }
            }
        } else {
            if (val < 10.5) {

                res=("niv de glycemi est normal");
            } else {

                res=("niv de glycemi est trop eleve");
            }
        }
    }

}
