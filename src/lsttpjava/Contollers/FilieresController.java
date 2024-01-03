package lsttpjava.Controllers;

import lsttpjava.Main;
import lsttpjava.Models.Departement;
import lsttpjava.Services.DB;
import lsttpjava.Services.DepartementServices;
import lsttpjava.Services.EnseignantServices;

public class DepartementsController {


    public static void showMenu(){
        System.out.println("-------------------------[ Départements ]---------------------------");


        System.out.println("1: Pour ajouter un département");
        System.out.println("2: Pour afficher les départements");
        System.out.println("3: Pour modifier un département");
        System.out.println("4: Pour supprimer un département");
        System.out.println("0: Pour retourner au menu principal");

        //"Veuillez sélectionner une option : ")
        int option = Main.getIntInput("Veuillez sélectionner une option : ");
        switch(option) {
            case 1:
                createFilieres();
                break;
            case 2:
                showFilieres();
                break;
            case 3:
                editFilieres();
                break;
            case 4:
                destroyFilieres();
                break;
            default:
                Main.showPrincipalMenu();
        }
    }
    public static void showFilieres(){
        for (Departement departement : DB.filieres) {
            System.out.print("Id : " + departement.getId());
            System.out.print(" | Intitulé : " + departement.getIntitule());
            if (! Main.isNull(departement.getChef())) {
                System.out.print(" | Chef : " + departement.getChef().getNom() + " " + departement.getChef().getPrenom());
            }
            System.out.println("");
        }

    }
    public static void createFilieres(){
        String intitule = Main.getStringInput("Entrez l'intitulé :");
        EnseignantsController.showEnseignants();
        int id = Main.getIntInput("Sélecionnez un enseignant par id :");
        DepartementServices.addDept(intitule, EnseignantServices.getEnsById(id));

        showFilieres();
        showMenu();


    }
    public static void editFilieres(){
        showFilieres();
        int id = Main.getIntInput("Sélecionnez un departement par id :");
        String intitule = Main.getStringInput("Entrez l'intitulé :");
        EnseignantsController.showEnseignants();
        int idEns = Main.getIntInput("Sélecionnez un enseignant par id :");

        DepartementServices.updateDept(id, intitule, EnseignantServices.getEnsById(idEns));

        showFilieres();
        showMenu();
    }
    public static void destroyFilieres(){
        showFilieres();
        int id = Main.getIntInput("Sélecionnez un departement par id :");
        DepartementServices.deleteDeptById(id);
        showFilieres();

    }
}