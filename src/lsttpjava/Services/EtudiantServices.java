package lsttpjava.Services;

import lsttpjava.Models.Etudiant;
import lsttpjava.Models.Filiere;

import java.util.ArrayList;

public class EtudiantServices {

    private static final Object DB = ;

    public static Etudiant addEtd(String nom, String prenom, String email, int apogee, Filiere filiere){
        return  new Etudiant();
    }

    public static Etudiant updateEtd(int id,String nom, String prenom, String email, int apogee, Filiere filiere){
        return  new Etudiant();
    }
    public static ArrayList<Etudiant> deleteEtdById(int id){
        return  DB.Etudiant ;
    }

    public static Etudiant getEtdById(int id){
        return  new Etudiant();
    }

    public static ArrayList<Etudiant> getAllEtd(){
        return  DB.etudiant;
    }
}