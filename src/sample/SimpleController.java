package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class SimpleController {

    /** INITIALISATION DES VARIABLES**/
    private Float result;
    private int operateur;
    Float operation2, cal = result;
    int tempOp, operation = operateur;
    int n = 0;
    boolean touche, isEgale;
    int  multiEgale = 0;

    /** DECLARATION DES BOUTONS**/
    @FXML private Button egale;
    @FXML private Button un;
    @FXML private Button delete;
    @FXML private Button trois;
    @FXML private Button deux;
    @FXML private Button clear;
    @FXML private Button supp;
    @FXML private Button trash;
    @FXML private Button diviser;
    @FXML private Button multi;
    @FXML private Button soustraction;
    @FXML private Button addition;
    @FXML private Button quatre;
    @FXML private Button cinq;
    @FXML private Button six;
    @FXML private Button neuf;
    @FXML private Button sept;
    @FXML private Button huit;
    @FXML private Button zero;
    @FXML private Button virgule;


    /** DECLARATION DES LABELS**/
    @FXML private Label ecrant;
    @FXML private Label historique1;
    @FXML private Label resultat1;
    @FXML private Label historique2;
    @FXML private Label resultat2;
    @FXML private Label historique3;
    @FXML private Label resultat3;
    @FXML private Label historique4;
    @FXML private Label resultat4;
    @FXML private Label historique0;
    @FXML private Label resultat0;

    /** ********************************************************************************** **/
    /** LES FONCTIONS POUR L'HISTORIQUE **/
    /** ********************************************************************************** **/
    /** DECLARATION VARIABLE POUR L'HISTORIQUE**/
    private static int nbreHistorique = 5;
    private static String[] histoireCalcul=new String[nbreHistorique];
    private static String[] ResultatCalcul=new String[nbreHistorique];

    public static void setHistoire(int index, String value) {
        histoireCalcul[index] = value;
    }
    public static void setResultatCalcul(int index, String value) {
        ResultatCalcul[index] = value;
    }
    static int getPlaceLibre(int nbreHistorique) {
        int occurence = 0;

        for(int i = 0; i < nbreHistorique; ++i) {
            if (histoireCalcul[i] == null) {
                ++occurence;
            }
        }

        return occurence;
    }
    static int getPlaceLibreResultat(int nbreHistorique) {
        int occurence = 0;
        for(int i = 0; i < nbreHistorique; ++i) {
            if (ResultatCalcul[i] == null) {
                ++occurence;
            }
        }
        return occurence;
    }
    static void insertHist(String historique) {
        int occurence = getPlaceLibre(nbreHistorique);
        switch(occurence) {
            case 0:
                ecraserLastHist(historique);
                break;
            case 1:
                setHistoire(0, historique);
                break;
            case 2:
                setHistoire(1, historique);
                break;
            case 3:
                setHistoire(2, historique);
                break;
            case 4:
                setHistoire(3, historique);

                break;
            case 5:
                setHistoire(4, historique);
        }

    }
    static void insertRes(String resultat) {
        int occurence = getPlaceLibreResultat(nbreHistorique);
        switch(occurence) {
            case 0:
                ecraserLastRes(resultat);
                break;
            case 1:
                setResultatCalcul(0, resultat);
                break;
            case 2:
                setResultatCalcul(1, resultat);
                break;
            case 3:
                setResultatCalcul(2, resultat);
                break;
            case 4:
                setResultatCalcul(3, resultat);
                break;
            case 5:
                setResultatCalcul(4, resultat);
        }

    }
    @FXML static void ecraserLastHist(String historique) {
        int bullet1;
        for(bullet1 = 0; bullet1 < histoireCalcul.length; ++bullet1) {
            if (bullet1 != 0) {
                histoireCalcul[bullet1 - 1] = histoireCalcul[bullet1];
            }
        }
        setHistoire(4, historique);
    }
    /** FONCTION ECRASER LA DERNIERE **/
    @FXML static void ecraserLastRes(String resultat) {
        int bullet1;

        for(bullet1 = 0; bullet1 < ResultatCalcul.length; ++bullet1) {
            if (bullet1 != 0) {
                ResultatCalcul[bullet1 - 1] = ResultatCalcul[bullet1];
            }
        }

        setResultatCalcul(4, resultat);
    }
    /** FONCTION QUI PERMET D'AFFICHER L'HISTORIQUE **/
    @FXML public void afficher(){
        historique0.setText(histoireCalcul[4]);
        resultat0.setText(ResultatCalcul[4]);

        historique1.setText(histoireCalcul[3]);
        resultat1.setText(ResultatCalcul[3]);

        historique2.setText(histoireCalcul[2]);
        resultat2.setText(ResultatCalcul[2]);

        historique3.setText(histoireCalcul[1]);
        resultat3.setText(ResultatCalcul[1]);

        historique4.setText(histoireCalcul[0]);
        resultat4.setText(ResultatCalcul[0]);
    }

    /** ********************************************************************************** **/
    /** LES FONCTIONS POUR LES CALCULES **/
    /** ********************************************************************************** **/
    /** FONCTION GESTION D'AFFICHAGE en Entier ou en Décimale **/
    @FXML public void isInt(String valeur, float fin) {
        if ((valeur.charAt(valeur.length() - 2) == '.') && (valeur.charAt(valeur.length() - 1) == '0')) {
            ecrant.setText(String.valueOf((int) (Math.round(fin))));
              insertRes(String.valueOf((int) (Math.round(fin))));
        } else
        {
            ecrant.setText(String.valueOf(fin));
            insertRes(String.valueOf(fin));
        }

        System.out.println("Print Resultat tableau");
        for (int i = 0; i < ResultatCalcul.length; i++) {
            System.out.println(ResultatCalcul[i]);
        }
        System.out.println("Print calcul tableau");
        for (int i = 0; i < histoireCalcul.length; i++) {
            System.out.println(histoireCalcul[i]);
        }
        afficher();
    }

    @FXML public String isIntHistorique(String valeur, float fin) {
        if ((valeur.charAt(valeur.length() - 2) == '.') && (valeur.charAt(valeur.length() - 1) == '0')) {
            return String.valueOf((int) (Math.round(fin)));
        } else
        {
            return String.valueOf(fin);
        }

    }

    /** ********************************************************************************** **/
    /** LES FONCTIONS POUR LE GESTION SYSTEME (avec l'utilisateur) **/
    /** ********************************************************************************** **/
    /** FONCTION POUR EFFACER L'HISTORIQUE ET VIDER LES MEMOIRES **/
    @FXML void deleteHistoriqueEcran() {
        ecrant.setText("");
        cal = result;
        operation = 0;
        n = 0;

        System.out.println("tableau historique");
        for (int i = 0; i < histoireCalcul.length; i++) {
            histoireCalcul[i]=null;
            System.out.println(histoireCalcul[i]);
        }
        System.out.println("tableau resultat");
        for (int i = 0; i < ResultatCalcul.length; i++) {
            ResultatCalcul[i]=null;
            System.out.println(ResultatCalcul[i]);
        }
        afficher();
    }
    /**         FONCTION GESTION DU PRECEDENT         **/
    /** supprime le dernier nombre saisie sur l'écran **/
    @FXML public void GestionPrecedent(int taille, String precedent){
        for(int i=0; i<taille-1; i++) {
            ecrant.setText(ecrant.getText() + String.valueOf(precedent.charAt(i)));
        }
    }

/** ********************************************************************************** **/
/** ECOUTEUR ACTION BOUTTON **/ /** les boutons numeriques et les signes **/
/** ********************************************************************************** **/
    @FXML
    void boutton(ActionEvent event) {

        //////////////////////////////////////////////////////////// PARTIE INITIALISATION DE L'OPERATEUR (SIGNE)
        if (event.getSource() == diviser){
            if (multiEgale == 1) {
                tempOp = operation;
            }else {
                try {
                    cal = Float.parseFloat(ecrant.getText());
                }catch (Exception e) {
                    ecrant.setText("");
                    multiEgale--;
                }
            }
            operation = 1;
            n=1;
            multiEgale ++;
            if (multiEgale > 1 && touche == true){
                MultipleCalcule();
            }
            touche = false;
        }
        else if (event.getSource() == multi){
            if (multiEgale == 1) {
                tempOp = operation;
            }else {
                try {
                    cal = Float.parseFloat(ecrant.getText());
                }catch (Exception e) {
                    ecrant.setText("");
                    multiEgale--;
                }
            }
            operation = 2;
            n=1;
            multiEgale ++;
            if (multiEgale > 1 && touche == true){
                MultipleCalcule();
            }
            touche = false;
        }
        else if (event.getSource() == soustraction){
            if (multiEgale > 0) {
                tempOp = operation;
            }else {
                try {
                    cal = Float.parseFloat(ecrant.getText());
                }catch (Exception e) {
                    ecrant.setText("");
                    multiEgale--;
                }
            }
            operation = 3;
            n=1;
            multiEgale ++;
            System.out.println("Moins ="+touche);
            if (multiEgale > 1 && touche == true){
                MultipleCalcule();
            }
            touche = false;
        }
        else if (event.getSource() == addition){
            if (multiEgale > 0) {
                tempOp = operation;
            }else {
                try {
                    cal = Float.parseFloat(ecrant.getText());
                }catch (Exception e) {
                    ecrant.setText("");
                    multiEgale--;
                }
            }
            operation = 4;
            n=1;
            multiEgale ++;
            System.out.println("Plous ="+touche);
            if (multiEgale > 1 && touche == true){
                MultipleCalcule();
            }
            touche = false;
        }


        //////////////////////////////////////////////////////////// PARTIE CALCUL
        else if (event.getSource() == egale ){
            Float fin;
            isEgale = true;
            touche = false;
            multiEgale = 0;
            if(ecrant.getText() == "") {
                ecrant.setText("");
            }
            else if (operation == -1){
                ecrant.setText(ecrant.getText());
            }
            else {
                operation2 = Float.parseFloat(ecrant.getText());

                /** AFFICHAGE DU CALCULE DANS LABEL **/
                switch(operation){
                    case 1:
                        if(n>0){
                            historique1.setText(cal+"/"+ operation2);
                            insertHist(isIntHistorique(String.valueOf(operation2),operation2)+ " / "+ isIntHistorique(String.valueOf(cal),cal));
                        }else{
                            historique1.setText(cal+"/"+ operation2);
                            insertHist(isIntHistorique(String.valueOf(cal),cal)+ " / "+isIntHistorique(String.valueOf(operation2),operation2));
                        }
//
                        break;
                    case 2:
                        if(n>0){
                            historique1.setText(cal+"*"+ operation2);
                            insertHist(isIntHistorique(String.valueOf(operation2),operation2)+ " * "+ isIntHistorique(String.valueOf(cal),cal));
                        }else {
                            historique1.setText(cal+"*"+ operation2);
                            insertHist(isIntHistorique(String.valueOf(cal),cal)+ " * "+isIntHistorique(String.valueOf(operation2),operation2));
                        }
//
                        break;
                    case 3:
                        if(n>0){
                            historique1.setText(cal+"-"+ operation2);
                            insertHist(isIntHistorique(String.valueOf(operation2),operation2)+ " - "+ isIntHistorique(String.valueOf(cal),cal));
                        }else {
                            historique1.setText(cal+"-"+ operation2);
                            insertHist(isIntHistorique(String.valueOf(cal),cal)+ " - "+isIntHistorique(String.valueOf(operation2),operation2));
                        }
//
                        break;
                    case 4:
                        if(n>0){
                            historique1.setText(cal+"+"+ operation2);
                            insertHist(isIntHistorique(String.valueOf(operation2),operation2)+ " + "+ isIntHistorique(String.valueOf(cal),cal));
                        }else {
                            historique1.setText(cal+"+"+ operation2);
                            insertHist(isIntHistorique(String.valueOf(cal),cal)+ " + "+isIntHistorique(String.valueOf(operation2),operation2));
                        }
                        break;
                }
                /** DEBUT DU CALCULE **/
                switch (operation){
                    case 1 : //division

                        ///////////////////////////////             gestion du spam égale
                        if(n>0){
                            fin = operation2/cal;
                            ////////                                gestion d'affichage d'un entier, ou décimaux
                            isInt(String.valueOf(fin),fin);
                            ////////
                        }else{
                            fin = cal/operation2;
                            ////////
                            isInt(String.valueOf(fin),fin);
                            ////////
                        }
                        n++;
                        if(n==1){
                            cal = operation2;
                        }
                        ///////////////////////////////

                        break;
                    case 2 ://multi
                        if(n>0){
                            fin = operation2*cal;
                            isInt(String.valueOf(fin),fin);
                        }else{
                            fin = cal*operation2;
                            isInt(String.valueOf(fin),fin);
                        }
                        n++;
                        if(n==1){
                            cal = operation2;
                        }
                        break;
                    case 3 ://soustraction
                        System.out.println("N1 ="+n);
                        if(n>0){
                            fin = operation2 - cal;
                            isInt(String.valueOf(fin),fin);
                        }
                        if(n == 0){
                            fin = cal-operation2;
                            isInt(String.valueOf(fin),fin);
                        }
                        n++;
                        if(n==1){
                            cal = operation2;
                        }
                        break;
                    case 4 ://addition
                        if(n>1){
                            fin = operation2+cal;
                            isInt(String.valueOf(fin),fin);
                        }else{
                            fin = cal+operation2;
                            isInt(String.valueOf(fin),fin);
                        }
                        n++;
                        if(n==1 && multiEgale <2){
                            cal = operation2;
                        }
                        break;
                }
            }

        }

        //////////////////////////////////////////////////////////// PARTIE D'AFFICHAGE SAISIE
        else{
            String temp = ecrant.getText();         /** pour le gestion de la touche PREC **/

            if(n>=1) {                              /** clean écran pour nouvelle valeur saisie **/
                ecrant.setText("");
                n = 0; /** reset du compteur de la gestion des spams "égale" **/
                touche = true;
            }

            if(event.getSource() == un) {
                ecrant.setText(ecrant.getText() + "1");
            }else if (event.getSource() == deux ) {
                ecrant.setText(ecrant.getText() + "2");
            }else if (event.getSource() == trois ) {
                ecrant.setText(ecrant.getText() + "3");
            }else if (event.getSource() == quatre ) {
                ecrant.setText(ecrant.getText() + "4");
            }else if (event.getSource() == cinq ) {
                ecrant.setText(ecrant.getText() + "5");
            }else if (event.getSource() == six ) {
                ecrant.setText(ecrant.getText() + "6");
            }else if (event.getSource() == sept ) {
                ecrant.setText(ecrant.getText() + "7");
            }else if (event.getSource() == huit ) {
                ecrant.setText(ecrant.getText() + "8");
            }else if (event.getSource() == neuf ) {
                ecrant.setText(ecrant.getText() + "9");
            }else if (event.getSource() == zero ){
                ecrant.setText(ecrant.getText() + "0");
            }else if (event.getSource() == virgule) {
                ecrant.setText(ecrant.getText() + ".");
            }else if (event.getSource() == clear) {          /** clean écran simple avec reset à 0 **/
                ecrant.setText("0");
                n=1;
            }else if (event.getSource() == trash) {         /** gestion de la puobelle XD avec reset à 0 **/
                deleteHistoriqueEcran();
                ecrant.setText("0");
                n=1;
                multiEgale = 0;
            }else if (event.getSource() == supp) {
                String precedent = ecrant.getText();
                int taille = precedent.length();
                if(isEgale == true) {                   /** gestion du bouton PREC après un égale **/
                        ecrant.setText(temp);
                        n = 1;
                        return;
                }
                else {
                    if(taille == 1 || taille == 0){     /** gestion du bouton PREC pour un seul/dernier ou 0 élément **/
                        ecrant.setText("0");
                        n=1;
                    }
                    else{
                        ecrant.setText("");      /** gestion du bouton PREC supprime juste le dernier élément saisi **/
                        GestionPrecedent(taille,precedent);
                    }
                }
            }
            isEgale = false;                    /** RESET de la gestion bouton PREC **/
        }
    }


/** ********************************************************************************** **/
/** ECOUTE SUR LE CLAVIER **/ /** Instanciation avec HandlerEvent dans le Main  **/
/** ********************************************************************************** **/
    @FXML
    void clavier(String code) {
        //////////////////////////////////////////////////////////// Partie d'initialisation des signes
        if (code == "SLASH" || code == "DIVIDE"){
            if (multiEgale > 0) {
                tempOp = operation;
            }else {
                try {
                    cal = Float.parseFloat(ecrant.getText());
                }catch (Exception e) {
                    ecrant.setText("");
                    multiEgale--;
                }
            }
            operation = 1;
            n=1;
            multiEgale ++;
            if (multiEgale > 1 && touche == true){
                MultipleCalcule();
            }
            touche = false;
        }
        else if (code == "ASTERISK" || code == "MULTIPLY"){
            if (multiEgale > 0) {
                tempOp = operation;
            }else {
                try {
                    cal = Float.parseFloat(ecrant.getText());
                }catch (Exception e) {
                    ecrant.setText("");
                    multiEgale--;
                }
            }
            operation = 2;
            n=1;
            multiEgale ++;
            if (multiEgale > 1 && touche == true){
                MultipleCalcule();
            }
            touche = false;
        }
        else if (code == "SUBTRACT"){
            if (multiEgale > 0) {
                tempOp = operation;
            }else {
                try {
                    cal = Float.parseFloat(ecrant.getText());
                }catch (Exception e) {
                    ecrant.setText("");
                    multiEgale--;
                }
            }
            operation = 3;
            n=1;
            multiEgale ++;
            System.out.println("Moins ="+touche);
            if (multiEgale > 1 && touche == true){
                MultipleCalcule();
            }
            touche = false;
        }
        else if (code == "PLUS" || code == "ADD"){
            if (multiEgale > 0) {
                tempOp = operation;
            }else {
                try {
                    cal = Float.parseFloat(ecrant.getText());
                }catch (Exception e) {
                    ecrant.setText("");
                    multiEgale--;
                }
            }
            operation = 4;
            n=1;
            multiEgale ++;
            System.out.println("Plous ="+touche);
            if (multiEgale > 1 && touche == true){
                MultipleCalcule();
            }
            touche = false;
        }


        //////////////////////////////////////////////////////////// PARTIE GESTION DES CALCULS
        else if (code == "EQUALS" || code == "ENTER"){
            Float fin;
            touche = false;
            multiEgale = 0;
            isEgale = true;
            /** initialise les multiples calcul <" donc ce n'est pas un multiple calcul "> **/
            multiEgale = 0;
            /** gestion d'erreur, rien est entré et l'égale a été pressé **/
            if(ecrant.getText() == "") {
                ecrant.setText("");
            }

            /** gestion d'erreur, si pas de signe d'opération entrée **/
            else if (operation == -1){
                ecrant.setText(ecrant.getText());
            }

            else { /** si pas d'erreur de saisie, passe au calcule** /

                /** récupère la deuxième valeur pour le calcule **/
                operation2 = Float.parseFloat(ecrant.getText());

                /** AFFICHAGE DU CALCULE DANS LABEL (Historique) **/
                switch(operation){
                    case 1:
                        /** gestion des spams "égale" grace au compteur "n" avec la bonne affichage de l'historique**/
                        if(n>0){
                            historique1.setText(cal+"/"+ operation2);
                            insertHist(isIntHistorique(String.valueOf(operation2),operation2)+ " / "+ isIntHistorique(String.valueOf(cal),cal));
                        }
                        else{
                            historique1.setText(cal+"/"+ operation2);
                            insertHist(isIntHistorique(String.valueOf(cal),cal)+ " / "+isIntHistorique(String.valueOf(operation2),operation2));
                        }
//
                        break;
                    case 2:
                        if(n>0){
                            historique1.setText(cal+"*"+ operation2);
                            insertHist(isIntHistorique(String.valueOf(operation2),operation2)+ " * "+ isIntHistorique(String.valueOf(cal),cal));
                        }
                        else {
                            historique1.setText(cal+"*"+ operation2);
                            insertHist(isIntHistorique(String.valueOf(cal),cal)+ " * "+isIntHistorique(String.valueOf(operation2),operation2));
                        }
//
                        break;
                    case 3:
                        if(n>0){
                            historique1.setText(cal+"-"+ operation2);
                            insertHist(isIntHistorique(String.valueOf(operation2),operation2)+ " - "+ isIntHistorique(String.valueOf(cal),cal));
                        }
                        else {
                            historique1.setText(cal+"-"+ operation2);
                            insertHist(isIntHistorique(String.valueOf(cal),cal)+ " - "+isIntHistorique(String.valueOf(operation2),operation2));
                        }
//
                        break;
                    case 4:
                        if(n>0){
                            historique1.setText(cal+"+"+ operation2);
                            insertHist(isIntHistorique(String.valueOf(operation2),operation2)+ " + "+ isIntHistorique(String.valueOf(cal),cal));
                        }
                        else {
                            historique1.setText(cal+"+"+ operation2);
                            insertHist(isIntHistorique(String.valueOf(cal),cal)+ " + "+isIntHistorique(String.valueOf(operation2),operation2));
                        }
                        break;
                }
                /** partie calcul **/
                switch (operation){
                    case 1 : //division
                        /** gestion des spams "égale" grace au compteur "n" **/
                        if(n>0){
                            fin = operation2/cal;
                            isInt(String.valueOf(fin),fin);
                        }
                        else{
                            fin = cal/operation2;
                            isInt(String.valueOf(fin),fin);
                        }
                        /** tanque aucune touche à part le égale, incrémentation de n**/
                        n++;
                        if(n==1){
                            /** Si spam du égale bloque la valeur de départ dans cal **/
                            cal = operation2;
                        }
                        break;
                    case 2 ://multi
                        if(n>0){
                            fin = operation2*cal;
                            isInt(String.valueOf(fin),fin);
                        }
                        else{
                            fin = cal*operation2;
                            isInt(String.valueOf(fin),fin);
                        }
                        n++;
                        if(n==1){
                            cal = operation2;
                        }
                        break;
                    case 3 ://soustraction
                        System.out.println("N1 ="+n);
                        if(n>0){
                            fin = operation2 - cal;
                            isInt(String.valueOf(fin),fin);
                        }
                        if(n == 0){
                            fin = cal-operation2;
                            isInt(String.valueOf(fin),fin);
                        }
                        n++;
                        if(n==1){
                            cal = operation2;
                        }
                        break;
                    case 4 ://addition
                        if(n>1){
                            fin = operation2+cal;
                            isInt(String.valueOf(fin),fin);
                        }
                        else{
                            fin = cal+operation2;
                            isInt(String.valueOf(fin),fin);
                        }
                        n++;
                        if(n==1 && multiEgale <2){
                            cal = operation2;
                        }
                        break;
                }
            }
        }
        else{
            /** variable de stockage pour temporiser les touches non répertoriées dans le programme
             *  ET pour la gestion de la touche PREC **/
            String temp = ecrant.getText();
            if(n>=1) {
                ecrant.setText("");
                n = 0;
                touche = true;
            }

            /** Gestion des touches clavier répertoriées dans l'encodage KeyEvent.getCode **/
            if(code == "DIGIT1" || code == "NUMPAD1") {
                ecrant.setText(ecrant.getText() + "1");
            }else if (code == "DIGIT2" || code == "NUMPAD2") {
                ecrant.setText(ecrant.getText() + "2");
            }else if (code == "DIGIT3" || code == "NUMPAD3") {
                ecrant.setText(ecrant.getText() + "3");
            }else if (code == "DIGIT4" || code == "NUMPAD4") {
                ecrant.setText(ecrant.getText() + "4");
            }else if (code == "DIGIT5" || code == "NUMPAD5") {
                ecrant.setText(ecrant.getText() + "5");
            }else if (code == "DIGIT6" || code == "NUMPAD6") {
                ecrant.setText(ecrant.getText() + "6");
            }else if (code == "DIGIT7" || code == "NUMPAD7") {
                ecrant.setText(ecrant.getText() + "7");
            }else if (code == "DIGIT8" || code == "NUMPAD8") {
                ecrant.setText(ecrant.getText() + "8");
            }else if (code == "DIGIT9" || code == "NUMPAD9") {
                ecrant.setText(ecrant.getText() + "9");
            }else if (code == "DIGIT0" || code == "NUMPAD0"){
                ecrant.setText(ecrant.getText() + "0");
            }else if (code == "COMMA" || code == "DECIMAL") {
                ecrant.setText(ecrant.getText() + ".");
            }
            else if (code == "BACK_SPACE") {
                ecrant.setText("0");
                n=1;
            }
            else if (code == "DELETE") {
                deleteHistoriqueEcran();
                ecrant.setText("0");
                n=1;
                multiEgale = 0;
            }
            else if (code == "ESCAPE") {
                String precedent = ecrant.getText();
                int taille = precedent.length();
                if(isEgale == true) {
                    ecrant.setText(temp);
                    n = 1;
                    return;
                }
                else {
                    if (taille == 1 || taille == 0) {
                        ecrant.setText("0");
                        n=1;
                    } else {
                        ecrant.setText("");
                        GestionPrecedent(taille, precedent);
                    }
                }
            }
            else{
                /** Touche non répertoriée, affiche la valeur stockée **/
                ecrant.setText(temp);
                n=1;
                touche = false;
            }
            isEgale = false;
        }
    }

/** ********************************************************************************** **/
/** CLIQUE SUR LE BOUTON DELETE **/
/** ********************************************************************************** **/
    @FXML
    void system(ActionEvent event) { /** delete tout avec l'historique, avec gestion du reset à 0 **/
        if (event.getSource() == delete) {
            deleteHistoriqueEcran();
            multiEgale = 0;
            ecrant.setText("0");
            n=1;
        }
    }

    /** Gestion d'enchainement d'opération ( ... + .... (+=) ... (+=) ...) **/
    @FXML
    void MultipleCalcule(){
        Float fin = Float.parseFloat("0.0");
        operation2 = Float.parseFloat(ecrant.getText());

        /** AFFICHAGE DU CALCULE DANS LABEL **/
        switch(tempOp){
            case 1:
                    historique1.setText(cal+"/"+ operation2);
                    insertHist(isIntHistorique(String.valueOf(cal),cal)+ " / "+isIntHistorique(String.valueOf(operation2),operation2));
                break;
            case 2:
                    historique1.setText(cal+"*"+ operation2);
                    insertHist(isIntHistorique(String.valueOf(cal),cal)+ " * "+isIntHistorique(String.valueOf(operation2),operation2));
                break;
            case 3:
                    historique1.setText(cal+"-"+ operation2);
                    insertHist(isIntHistorique(String.valueOf(cal),cal)+ " - "+isIntHistorique(String.valueOf(operation2),operation2));
                break;
            case 4:
                    historique1.setText(cal+"+"+ operation2);
                    insertHist(isIntHistorique(String.valueOf(cal),cal)+ " + "+isIntHistorique(String.valueOf(operation2),operation2));
                break;
        }
        /** DEBUT DU CALCULE **/
        switch (tempOp){
            case 1 : //division
                fin = cal/operation2;
                ////////
                isInt(String.valueOf(fin),fin);
                break;
            case 2 ://multi
                fin = cal*operation2;
                isInt(String.valueOf(fin),fin);
                break;
            case 3 ://soustractionelse{
                fin = cal-operation2;
                isInt(String.valueOf(fin),fin);
                break;
            case 4 ://additionelse{
                fin = cal+operation2;
                isInt(String.valueOf(fin),fin);
                break;
        }
        cal = fin;
    }
}


