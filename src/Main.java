
public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
		/*Element element = null;
		System.out.println(element == null);
		Element wortel = new Element();
		wortel.setWaarde(1);
		wortel.setLinks(new Element(2));
		wortel.setRechts(new Element(3));
		
		wortel.getLinks().setLinks(new Element(4));
		wortel.getLinks().setRechts(new Element(5));
		
		wortel.getLinks().getLinks().setLinks(new Element(6));
		wortel.getLinks().getLinks().setRechts(new Element(7));
		
		wortel.getLinks().getLinks().getRechts().setLinks(new Element(8));
		wortel.getLinks().getLinks().getRechts().setRechts(new Element(9));
		
		wortel.schrijfPreOrder();
		System.out.println("umama");
		System.out.println(wortel.getDiepte());
		*/
		
		System.out.println("testing binaire boom");
		BinaireBoom b = new BinaireBoom();
		b.voegToe(new Element(8));
		b.voegToe(new Element(3));
		b.voegToe(new Element(10));
		b.voegToe(new Element(1));
		b.voegToe(new Element(6));
		
		System.out.println("inorder");
		b.schrijfInOrder();
		System.out.println("preorder");
		b.schrijfPreOrder();
		System.out.println("postorder");
		b.schrijfPostOrder();
		
		b.voegToe(1);	//print dat het getal er al in zit uit
		b.verwijder(3);
		b.schrijfInOrder();
	}

}