package lsttpjava.Controllers;

import lsttpjava.Main;
import lsttpjava.Models.Etudiant;
import lsttpjava.Services.DB;
import lsttpjava.Services.DepartementServices;
import lsttpjava.Services.EnseignantServices;
import lsttpjava.Models.Filiere;
public class EtudiantsController {


    public static void showMenu(){
        System.out.println("-------------------------[ Etudiant ]---------------------------");


        System.out.println("1: Pour ajouter un Etudiant");
        System.out.println("2: Pour afficher les Etudiant");
        System.out.println("3: Pour modifier un Etudiant");
        System.out.println("4: Pour supprimer un Etudiant");
        System.out.println("0: Pour retourner au menu principal");

        //"Veuillez sélectionner une option : ")
        int option = Main.getIntInput("Veuillez sélectionner une option : ");
        switch(option) {
            case 1:
                createEtudiant();
                break;
            case 2:
                showEtudiants();
                break;
            case 3:
                editEtudiant();
                break;
            case 4:
                destroyEtudiant();
                break;
            default:
                Main.showPrincipalMenu();
        }
    }

    public static void showEtudiants(){
        for(Etudiant etudiant : DB.etudiant) {
            System.out.print("Id : " + etudiant.getId());
            System.out.print(" | Intitule : "    etudiant.getIntitule());

            System.out.println("");
        }

    }





    public static void createEtudiant(   ){
        String intitule = Main.getStringInput("Entrez l'intitulé :");
        EtudiantsController.createEtudiant( );
        int id = Main.getIntInput("Sélecionnez un etudiant par id :");
        EtudiantsController.createEtudiant( String intitule, EtudiantsController.createEtudiant( ));

        createEtudiant();
        showMenu();


    }




    public static void editEtudiant() {
        editEtudiant();
        int id = Main.getIntInput("Sélecionnez un etudiant par id :");
        String intitule = Main.getStringInput("Entrez l'intitulé :");
        EnseignantsController.showEnseignants();
        int idEns = Main.getIntInput("Sélecionnez un enseignant par id :");

        DepartementServices.updateDept(id, intitule, EnseignantServices.getEnsById(idEns));

        editEtudiant();
        showMenu();
    }


    public static void destroyEtudiant(){
        destroyEtudiant();
        int id = Main.getIntInput("Sélecionnez un etudiant par id :");
        DepartementServices.deleteDeptById(id);
        destroyEtudiant();

    }
}