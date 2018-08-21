import java.util.ArrayList;
import java.util.Stack;

class BinaireBoom <T extends Comparable<T>>{

    protected Element<T> wortel;

    public BinaireBoom() {
        wortel = null;
    }

    public void voegToe(T getal) {
        Element<T> e = new Element<>(getal);
        this.voegToe(e);
    }
    public void voegToe(Element<T> element) {

        //als er al een wortel gemaakt is
        // voegt een element toe met respect voor natuurlijke ordening
        //(de klasse van de elementen implementeert de interface Comparable);
        //duplicaten (equals geeft true) worden niet toegevoegd.

        if(wortel == null) {
            wortel = element;
        }

        else {
            //als de wortel dus al ingevuld is

            //check als het element er al in zit, zoja, voet het niet toe, tis een duplicaat
            if(this.zitErAlIn(element.getWaarde()) == true) {   //de == true mag eigelijk weg
                System.out.println("het element is een duplicaat, is dus niet toegevoegd");

            }

            else {
                //voet het element op de juiste plek toe
                //dit is moeilijk

                Element keerTerug;
                Element evalueer = wortel;

                boolean klaar = false;

                while(!klaar) {
                    keerTerug = evalueer;

                    if(element.compareTo(evalueer) < 0){
                        evalueer = evalueer.getLinks();

                        if(evalueer == null) {
                            keerTerug.setLinks(element);
                            klaar = true;
                        }

                    }
                    else {
                        //naar rechts gaan
                        evalueer = evalueer.getRechts();
                        if(evalueer == null) {
                            keerTerug.setRechts(element);
                            klaar = true;
                        }
                    }

                }

            }

        }
    }

    //private, want wordt enkel gebruikt in de klasse zelf
    private boolean zitErAlIn(T waarde) {

        if (wortel == null) {
            System.out.println("hier zouden we nooit mogen graken");
            return false;
        }

        Stack<Element<T>> stack = new Stack<Element<T>>();

        Element<T> root = null;

        stack.push(wortel);
        while (!stack.empty()) {
            root = stack.pop();

            if(root.getLinks() == null && root.getRechts() == null ) {
                if(root.getWaarde()== waarde) {return true;}
            }
            if (root.getLinks() != null) {
                stack.push(root.getLinks());
            }
            if (root.getRechts() != null) {
                stack.push(root.getRechts());
            }

        }


        return false;

    }

    public void verwijder(T waarde) {
        Element<T> e = new Element<T>(waarde);
        this.verwijder(e);
    }
    public void verwijder(Element<T> element) {
        System.out.println("element verwijderen");
        //itereer over alles
        //als het gevonden is, verwijder alle kiddos dervan
        //en verwijder het element zelf
        //zijn daddy moet ook op nul komen
        //voet het element op de juiste plek toe
        //dit is moeilijk
        T getal = element.getWaarde();
        Element<T> keerTerug;
        Element<T> evalueer = wortel;

        boolean klaar = false;

        while(!klaar) {
            keerTerug = evalueer;

            if(element.compareTo(evalueer) < 0){
                evalueer = evalueer.getLinks();

                if(evalueer.getWaarde()==getal) {
                    //dan is het het linker van keerTerug dat we moeten hebben om te verwijderen
                    Element<T> links = evalueer.getLinks();
                    Element<T> rechts = evalueer.getRechts();
                    keerTerug.setLinks(null);
                    this.voegToe(links);
                    this.voegToe(rechts);
                    klaar = true;
                }

            }
            else {
                //naar rechts gaan
                evalueer = evalueer.getRechts();
                if(evalueer == null) {
                    Element<T> links = evalueer.getLinks();
                    Element<T> rechts = evalueer.getRechts();
                    keerTerug.setRechts(null);
                    this.voegToe(links);
                    this.voegToe(rechts);
                    klaar = true;
                }
            }

        }

    }

    public void schrijfInOrder() {
        schrijfInOrder(wortel);
    }

    //private, want wordt enkel gebruikt in de klasse zelf
    private void schrijfInOrder(Element<T> node) {
        if (node != null) {
            schrijfInOrder(node.getLinks());
            System.out.println(node.getWaarde());
            schrijfInOrder(node.getRechts());
        }

    }


    public void schrijfPreOrder() {
        schrijfPreOrder(wortel);
    }

    //private, want wordt enkel gebruikt in de klasse zelf
    private void schrijfPreOrder(Element<T> node) {
        if (node != null) {
            System.out.println(node.getWaarde());
            schrijfInOrder(node.getLinks());
            schrijfInOrder(node.getRechts());
        }

    }

    public void schrijfPostOrder() {
        schrijfPostOrder(wortel);
    }

    //private, want wordt enkel gebruikt in de klasse zelf
    private void schrijfPostOrder(Element<T> node) {
        if (node != null) {
            schrijfInOrder(node.getLinks());
            schrijfInOrder(node.getRechts());
            System.out.println(node.getWaarde());
        }

    }

    public int getDiepte() {
        return getDiepte(wortel);
    }

    //private, want wordt enkel gebruikt in de klasse zelf
    private int getDiepte(Element node) {
        if(node == null) {	//checken van de wortel
            return 0;
        }
        else{
            int linksDiepte = getDiepte(node.getLinks());
            int rechtsDiepte = getDiepte(node.getRechts());

            if (linksDiepte > rechtsDiepte) {return (linksDiepte+1);}
            else {return (rechtsDiepte+1);}
        }

    }

    //deze moeten nog generic gemaakt worden
    protected ArrayList<T> stelArrayListOp(){
        ArrayList<T> alijst = new ArrayList<T>();

        visitAlleEnVoegToe(wortel,alijst);
        //itereer doorheen alle items
        //voeg hun getalWaarde toe aan de arrayList

        return alijst;
    }

    private void visitAlleEnVoegToe(Element<T> node, ArrayList<T> alijst) {

        if(node.getLinks() != null) {visitAlleEnVoegToe(node.getLinks() , alijst);}
        if(node.getRechts() != null) {visitAlleEnVoegToe(node.getRechts() , alijst);}
        T getal = node.getWaarde();
        if(!alijst.contains(getal)) {alijst.add(getal);}

    }

}