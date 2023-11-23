package com.example.salim_chahed__mesure_glycemie.model;

public class Patient {
    public int age;
    public String val;
    public boolean jeune;
    String res;

    public String getRes() {
        return res;
    }


    public Patient(int age,String val,boolean jeune){
        this.jeune=jeune;
        this.val=val;
        this.age=age;
        calcule();
    }
    public Patient(){

    }

    public void calcule(){
        double val = Double.parseDouble(this.val);

        if (jeune) {
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
