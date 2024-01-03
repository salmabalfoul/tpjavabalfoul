package lsttpjava.Controllers;
import lsttpjava.Models.Enseignant;
import lsttpjava.Services.DB;
import lsttpjava.Services.DepartementServices;
import lsttpjava.Services.EnseignantServices;

public class EnseignantsController {
    private static Object EnseignantServices;

    public static void showMenu(){
        System.out.println("-------------------------[ Enseignant ]---------------------------");


        System.out.println("1: Pour ajouter un eneignant");
        System.out.println("2: Pour afficher les eneignant");
        System.out.println("3: Pour modifier un eneignant");
        System.out.println("4: Pour supprimer un eneignant");
        System.out.println("0: Pour retourner au menu principal");

        //"Veuillez sélectionner une option : ")
        int option = Main.getIntInput("Veuillez sélectionner une option : ");
        switch(option) {
            case 1:
                createEnseignant();
                break;
            case 2:
                showEnseignants();
                break;
            case 3:
                editEnseignant();
                break;
            case 4:
                destroyEnseignant();
                break;
            default:
                Main.showPrincipalMenu();
        }

    }
    public static void showEnseignants(){
        for (Enseignant enseignant : DB.enseignants) {
            System.out.print("Id : " + enseignant.getId());
            System.out.print(" | Nom : " + enseignant.getNom() + " " + enseignant.getPrenom());
            System.out.print(" | Email : " + enseignant.getEmail() );

//            if (! Main.isNull(departement.getChef())) {
//                System.out.print(" | Chef : " + departement.getChef().getNom() + " " + departement.getChef().getPrenom());
//            }
            System.out.println("");
        }
    }

    public static void createEnseignant(){
        String nom = Main.getStringInput(nom:String s="Entrer le nom de l'Enseignant:";
        String prenom = Main.getStringInput(prenom:String s1 = "Entrer le prenom de l'Enseignant:";;
        String email = Main.getStringInput(email:String s2="Entrer lemail de l'Enseignant:";
        String grade = Main.getStringInput(grade:String s3="Entrer le grade de l'Enseignant:";

        int id = Main.getInput(s:String s4="selectionnez le module par id :";


        EnseignantServices.notifyAll(nom,prenom,email,grade,EnseignantServices.getClass(id));
        showEnseignants();
        showMenu();

    }
    public static void editEnseignant(){
        editEnseignant();
        int id = Main.getIntInput("Sélecionnez un etudiant par id :");
        String intitule = Main.getStringInput("Entrez l'intitulé :");
        EnseignantsController.showEnseignants();
        int idEns = Main.getIntInput("Sélecionnez un enseignant par id :");

        DepartementServices.updateDept(id, intitule, lsttpjava.Services.EnseignantServices.getEnsById(idEns));

        editEnseignant();
        showMenu();



    }
    public static void destroyEnseignant(){

        destroyEnseignant();
        int id = Main.getIntInput("Sélecionnez un etudiant par id :");
        DepartementServices.deleteDeptById(id);
        destroyEnseignant();


    }


}
