
import java.util.ArrayList;
import java.util.Collections;

public class GebalanceerdeBinaireBoom<T extends Comparable<T>> extends BinaireBoom<T> {

    private ArrayList<T> getallenLijst;

    public GebalanceerdeBinaireBoom() {
        super();
        getallenLijst = new ArrayList<T>();
    }

    //methoden die enkel in de klasse zelf moeten gebruikt worden
    //deze erven niet over van de BinaireBoom Klasse

    private void sorteer() {
        Collections.sort(getallenLijst);
    }

    private Element<T> tekenGebalanceerdeBinaireBoom(ArrayList<T> getallenLijst, int start, int einde) {
        //basis case
        if (start > einde) {
            return null;
        }

        //stap 1  Get the middle element and make it root
        int midden = (start + einde) / 2;
        Element<T> element = new Element(getallenLijst.get(midden));


        /* Recursively construct the left subtree and make it
         left child of root */
        element.setLinks(tekenGebalanceerdeBinaireBoom(getallenLijst, start, midden - 1));

        /* Recursively construct the right subtree and make it
         right child of root */
        element.setRechts(tekenGebalanceerdeBinaireBoom(getallenLijst, midden + 1, einde));

        return element;
    }


    public void stelListOp() {
        getallenLijst = super.stelArrayListOp();
        sorteer();
    }

    //overriden van de methoden van BinaireBoom
    @Override
    public void voegToe(T waarde) {
        super.voegToe(waarde);
        stelListOp();

    }

    @Override
    public void voegToe(Element<T> element) {
        super.voegToe(element);
        stelListOp();
    }

    @Override
    public void verwijder(T waarde) {
        super.verwijder(waarde);
        stelListOp();
    }

    @Override
    public void verwijder(Element<T> element) {
        super.verwijder(element.getWaarde());
        stelListOp();
    }

    @Override
    public void schrijfInOrder() {
        super.wortel = tekenGebalanceerdeBinaireBoom(getallenLijst, 0, getallenLijst.size() - 1);
        super.schrijfInOrder();
    }

    @Override
    public void schrijfPreOrder() {
        super.wortel = tekenGebalanceerdeBinaireBoom(getallenLijst, 0, getallenLijst.size() - 1);
        super.schrijfPreOrder();
    }

    @Override
    public void schrijfPostOrder() {
        super.wortel = tekenGebalanceerdeBinaireBoom(getallenLijst, 0, getallenLijst.size() - 1);
        super.schrijfPostOrder();
    }

    @Override
    public int getDiepte() {
        return super.getDiepte();
    }
}

