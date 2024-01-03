package lsttpjava.Controllers;

import lsttpjava.Main;
import lsttpjava.Models.Departement;
import lsttpjava.Services.DB;
import lsttpjava.Services.DepartementServices;
import lsttpjava.Services.EnseignantServices;
import lsttpjava.Models.Enseignant;
import lsttpjava.Models.Module;
public class ModulesController {


    public static void showMenu(){
        System.out.println("-------------------------[ Modules ]---------------------------");


        System.out.println("1: Pour ajouter un Modules");
        System.out.println("2: Pour afficher les Modules");
        System.out.println("3: Pour modifier un Modules");
        System.out.println("4: Pour supprimer un Modules");
        System.out.println("0: Pour retourner au menu principal");

        //"Veuillez sélectionner une option : ")
        int option = Main.getIntInput("Veuillez sélectionner une option : ");
        switch(option) {
            case 1:
                createModules();
                break;
            case 2:
                showModules();
                break;
            case 3:
                editModules();
                break;
            case 4:
                destroyModules();
                break;
            default:
                Main.showPrincipalMenu();
        }
    }


    public static void showModules() {
        for (Module module : DB.mod) {
            System.out.print("Id : " + module.getId());
            System.out.print(" | Intitule : " + module.getIntitule() + " " + module.getIntitule());
            System.out.print(" | Filiere : " + module.getFiliere());
            System.out.print(" | Professeur : " + module.getChef());
            if (!Main.isNull(module)) {
                System.out.print(" | nom : " + module.getIntitule());
            }
            System.out.println("");

        }
    }






    public static void createModules(){
        String intitule = Main.getStringInput("Entrez l'intitulé :");
        EnseignantsController.showEnseignants();
        int id = Main.getIntInput("Sélecionnez un enseignant par id :");
        DepartementServices.addDept(intitule, EnseignantServices.getEnsById(id));

        showModules();
        showMenu();


    }
    public static void editModules(){
        showModules();
        int id = Main.getIntInput("Sélecionnez un departement par id :");
        String intitule = Main.getStringInput("Entrez l'intitulé :");
        EnseignantsController.showEnseignants();
        int idEns = Main.getIntInput("Sélecionnez un enseignant par id :");

        DepartementServices.updateDept(id, intitule, EnseignantServices.getEnsById(idEns));

        showModules();
        showMenu();
    }
    public static void destroyModules(){
        showModules();
        int id = Main.getIntInput("Sélecionnez un Modules par id :");
        DepartementServices.deleteDeptById(id);
        showModules();

    }
}