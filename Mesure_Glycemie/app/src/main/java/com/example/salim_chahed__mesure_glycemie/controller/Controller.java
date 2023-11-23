package com.example.salim_chahed__mesure_glycemie.controller;

import com.example.salim_chahed__mesure_glycemie.model.Patient;

import kotlinx.coroutines.channels.ActorKt;

public class Controller {


        public Patient patient;
        public static Controller instance ;
        public Controller()
        {
            super();
        }
        public static Controller getInstance(){
            if(instance == null)
                return instance = new Controller();
            else
                return instance;

        }

        public void createPatient(int age,String valeur,boolean jen)
        {
            patient =new Patient(age,valeur,jen);
        }
        public String getResult()
        {
            return patient.getRes();
        }
    }

