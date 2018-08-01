import java.util.ArrayList;
import java.util.Collections;

// https://www.geeksforgeeks.org/convert-normal-bst-balanced-bst/
// https://www.geeksforgeeks.org/sorted-array-to-balanced-bst/

/*
 * 	1) Get the Middle of the array and make it root.
	2) Recursively do same for left half and right half.
      a) Get the middle of left half and make it left child of the root
          created in step 1.
      b) Get the middle of right half and make it right child of the
          root created in step 1.
 */
public class GebalanceerdeBinaireBoom extends BinaireBoom{

	static Element wortel;
	private ArrayList<Integer> getallenLijst;
	
	public GebalanceerdeBinaireBoom () {
		getallenLijst = new ArrayList<Integer>();
	}
	//methoden die enkel in de klasse zelf moeten gebruikt worden
	//deze erven niet over van de BinaireBoom Klasse
	
	private void sorteer() {
		Collections.sort(getallenLijst);
	}
	
	private Element tekenGebalanceerdeBinaireBoom(ArrayList<Integer> getallenLijst, int start, int einde){
		//basis case
		if(start > einde) {return null;}
		
		//stap 1  Get the middle element and make it root
		int midden = (start + einde)/2;
		Element element = new Element(getallenLijst.get(midden));
 
        /* Recursively construct the left subtree and make it
         left child of root */
        element.setLinks(tekenGebalanceerdeBinaireBoom(getallenLijst, start, midden-1) );
 
        /* Recursively construct the right subtree and make it
         right child of root */
        element.setRechts( tekenGebalanceerdeBinaireBoom(getallenLijst, midden+1, einde) );
         
        return element;
    }
	
	
	public void stelListOp() {
		getallenLijst = super.stelArrayListOp();
		sorteer();
	}
	
	//overriden van de methoden van BinaireBoom
	@Override 
	public void voegToe(int waarde) {
		super.voegToe(waarde);
		stelListOp();
		
	}
	
	@Override
	public void voegToe(Element element) {
		super.voegToe(element.getWaarde());
		stelListOp();
	}
	
	@Override
	public void verwijder(int waarde) {
		super.verwijder(waarde);
		stelListOp();
	}
	
	@Override
	public void verwijder(Element element) {
		super.verwijder(element.getWaarde());
		stelListOp();
	}
	
	@Override
	public void schrijfInOrder() {
		super.schrijfInOrder();
	}
	
	@Override
	public void schrijfPreOrder() {
		super.schrijfPreOrder();
	}
	
	@Override
	public void schrijfPostOrder() {
		super.schrijfPostOrder();
	}
	
	@Override
	public int getDiepte() {
		return super.getDiepte();
	}
	
	
	
	
	
	
		
		
	
	
	
	
	
	
	
	
	
	
	
}
