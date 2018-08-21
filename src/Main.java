public class Main {

	public static void main(String[] args) {

		/*System.out.println("testing binaire boom");
		BinaireBoom<Integer> b = new BinaireBoom<>();
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
	
		System.out.println("diepte");
		System.out.println(b.getDiepte());
		
		b.voegToe(1);	//print dat het getal er al in zit uit
		b.verwijder(3);
		b.schrijfInOrder();
		System.out.println(b.getDiepte());
		
		System.out.println("");
		System.out.println("");
		System.out.println("balanceerde binaire boom");*/

		GebalanceerdeBinaireBoom gbbb = new GebalanceerdeBinaireBoom();
		gbbb.voegToe(new Element(8));
		gbbb.voegToe(new Element(3));
		gbbb.voegToe(new Element(10));
		gbbb.voegToe(new Element(1));
		gbbb.voegToe(new Element(6));
		gbbb.voegToe(1);
		gbbb.voegToe(2);
		gbbb.voegToe(3);
		gbbb.voegToe(4);
		for(int i = 5; i<10; i++) gbbb.voegToe(i);
		System.out.println("inorder");
		gbbb.schrijfInOrder();
		System.out.println("preorder");
		gbbb.schrijfPreOrder();
		System.out.println("postorder");
		gbbb.schrijfPostOrder();
	
		System.out.println("diepte");
		System.out.println(gbbb.getDiepte());
		

		
	}

}









