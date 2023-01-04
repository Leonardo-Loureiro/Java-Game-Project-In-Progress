package zork;

import java.util.Scanner;

public class QuizMaster {

    //private String question;
    private String answer;
    private int sternen = 0;


    public QuizMaster() {
        //leer, kein Anfangszustand implentiert!
    }

    //Methoden
    ///
    //getter und setter
    public void setAnswer(String answer){
       this.answer = answer;
    }

    public String getAnswer() {
        return answer;
    }

    public void setSternen(int sternen) {this.sternen = sternen;}

    public int getSternen() {return sternen;}



    //Sternen Zähler Methode
    public void printSternen() {
        int amount = getSternen();
        System.out.println("Anzahl Sterne: " + amount);

    }

    //Methode für die Erste Frage
    public void QuestionForLevel1() {

        answer = "a";//Beliebig verstellbar

        //boolean ending = loop;

        System.out.println("\t # Willkommen im erstem Level des Turms #");
        System.out.println("\t # Wenn du den Turm weiter klettern möchtest musst du meine Frage beantworten, ansonsten ist dies dein Untergang #\n");


        Scanner scan = new Scanner(System.in);
        System.out.print("\t # Wo steht das höchste Gebäude der Welt? #\n\t a=>in Taipeh / b=>in New York / c=>in London / d=>in Tokio \n \t>");
        String name = scan.next();

        //Thread.activeCount();

        if (answer.equals(name)) {
            //Stern(Item) hinzufügen
            System.out.println("\t # Gratuliere du hast richtig beantwortet und darfst nun dein Abenteuer fortsetzen! # ");
            setAnswer(name);
            System.out.println("\t # Sie haben einen Stern erhalten! # ");
            sternen++;

        }
        //if (answer != name) {
        //    String abbruch = "zschüss";
         //   System.out.println("\nFalsche Antwort");
         //   setAnswer(abbruch);
        //}
        else {
                String abbruch = "zschüss";
                System.out.println("\nFalsche Antwort");
                setAnswer(abbruch);
        }
        //setAnswer(name);

    }
    //Methode für die Zweite Frage
    public void QuestionForLevel2() {

        answer = "d";//Beliebig verstellbar

        System.out.println("\t # Willkommen im zweiten Level des Turms #");
        System.out.println("\t # Wenn du den Turm weiter klettern möchtest musst du meine Frage beantworten, ansonsten ist dies dein Untergang #\n");


        Scanner scan = new Scanner(System.in);
        System.out.print("\t # Wo ist die steilste Eisenbahnstrecke der Welt? #\n\t a=>im Himalaya / b=>in Peru / c=>in Marokko / d=>in der Schweiz\n \t>");
        String name = scan.next();


        if (answer.equals(name)) {
            //Stern(Item) hinzufügen
            System.out.println("\t # Gratuliere du hast richtig beantwortet und darfst nun dein Abenteuer fortsetzen! # ");
            setAnswer(name);
            System.out.println("\t # Sie haben einen Stern erhalten! # ");
            sternen++;

        }
        if (answer != name) {
            String abbruch = "zschüss";
            System.out.println("\nFalsche Antwort");
            setAnswer(abbruch);

        }
        setAnswer(name);
    }
    //Methode für die Dritte Frage
    public void QuestionForLevel3() {

        answer = "c";//Beliebig verstellbar

        System.out.println("\t # Willkommen im dritten Level des Turms #");
        System.out.println("\t # Wenn du den Turm weiter klettern möchtest musst du meine Frage beantworten, ansonsten ist dies dein Untergang #\n");


        Scanner scan = new Scanner(System.in);
        System.out.print("\t # Wie oft atmet ein Mensch täglich ein und aus? #\n\t a=>ca. 250-mal / b=>ca. 2 500-mal / c=>ca. 25 000-mal / d=ca 250 000-mal\n \t>");
        String name = scan.next();


        if (answer.equals(name)) {
            //Stern(Item) hinzufügen
            System.out.println("\t # Gratuliere du hast richtig beantwortet und darfst nun dein Abenteuer fortsetzen! # ");
            setAnswer(name);
            System.out.println("\t # Sie haben einen Stern erhalten! # ");
            sternen++;

        }
        if (answer != name) {
            String abbruch = "zschüss";
            System.out.println("\nFalsche Antwort");
            setAnswer(abbruch);

        }
        setAnswer(name);
    }
    //Methode für die Vierte Frage
    public void QuestionForLevel4() {

        answer = "b";//Beliebig verstellbar

        System.out.println("\t # Willkommen im viertem Level des Turms #");
        System.out.println("\t # Wenn du den Turm weiter klettern möchtest musst du meine Frage beantworten, ansonsten ist dies dein Untergang #\n");


        Scanner scan = new Scanner(System.in);
        System.out.print("\t # Wann landete der erste Mensch auf dem Mond? #\n\t a=1950 / b=1969 / c=1986 / d=1991 \n \t>");
        String name = scan.next();


        if (answer.equals(name)) {
            //Stern(Item) hinzufügen
            System.out.println("\t # Gratuliere du hast richtig beantwortet und darfst nun dein Abenteuer fortsetzen! # ");
            setAnswer(name);
            System.out.println("\t # Sie haben einen Stern erhalten! # ");
            sternen++;

        }
        if (answer != name) {
            String abbruch = "zschüss";
            System.out.println("\nFalsche Antwort");
            setAnswer(abbruch);

        }
        setAnswer(name);
    }
    public void QuestionFinal() {

        answer = "c";//Beliebig verstellbar

        //Schatzraum erstellen und das letzte Hindernis
        System.out.println("\t # Willkommen im letzten Level des Turms #");
        System.out.println("\t # Wenn du den Schatz gewinnen möchtest musst du meine Ultimative Frage  beantworten um den letzten Stern zu erhalten # ");

        Scanner scan = new Scanner(System.in);
        System.out.print("\t # Wie hoch ist die höchste Pyramide? #\n\t a=7m / b=37m / c=137m / d=370m\n \t>");
        String name = scan.next();


        if (answer.equals(name)) {
            //Stern(Item) hinzufügen
            System.out.println("\t # Gratuliere du hast richtig beantwortet und deinen letzten Stern erhalten! # ");
            setAnswer(name);
            //System.out.println("\t # Sie haben einen Stern erhalten! # ");
            sternen++;
        }

        if (answer != name) {
            String abbruch = "zschüss";
            System.out.println("\nFalsche Antwort");
            setAnswer(abbruch);

        }

        //}else {
        //    String abbruch = "zschüss";
        //    System.out.println("\nFalsche Antwort");
        //    setAnswer(abbruch);
        //}



        setAnswer(name);
    }

    public void worthytest() {
        //Zulassung auf den Schatz überprüfen
        if (sternen == 5) {
            System.out.println("Gratuliere, du hast den Schatzraum geöffnet und dein Schatz bekommen.");
            setSternen(0);
        } else {
            System.out.println("Dir fehlen immer noch Sterne, hole sie dir bevor dein Schatz erlangen kannst!");
        }

    }




}


