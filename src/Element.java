
public class Element implements Comparable<Element> {
	private int waarde;
	private Element links;
	private Element rechts;

	//default constructor, geen idee als dit nodig os
	public Element() {
		System.out.println("default constructor opgeroepen");
		waarde = 0;
		links = null;
		rechts = null;
	}
	
	//constructor met 1 parameter, waarde
	public Element(int waarde) {
		this.waarde = waarde;
		links = null;
		rechts = null;
	}
	
	//copyconstructor
	public Element(Element e) {
		this.waarde = e.waarde;
		this.links = e.links;
		this.rechts = e.rechts;	
	}
	
	//is eigelijk hetzelfde als de copyconstructor
	public void setWaarden(Element e) {
		this.waarde = e.waarde;
		this.links = e.links;
		this.rechts = e.rechts;
	}
	
	
	public int getWaarde() {
		return waarde;
	}
	public void setWaarde(int waarde) {
		this.waarde = waarde;
	}
	public Element getLinks() {
		return links;
	}
	public void setLinks(Element links) {
		this.links = links;
	}
	public Element getRechts() {
		return rechts;
	}
	public void setRechts(Element rechts) {
		this.rechts = rechts;
	}


	@Override
	public int compareTo(Element elem2) {
		return this.waarde - elem2.waarde;
	}
	

	public void voegToe(Element element) {
		if(links == null && rechts ==null) {
			links = new Element(element.getWaarde());
		}
		
		else if(links !=null && rechts == null) {
			rechts = new Element(element.getWaarde());
		}
		
		
		else if(links == null && rechts != null) {
			links = new Element(element.getWaarde());
		}
		
		
		
		
		//als ze allebei al ingevuld zijn
		else if(links != null && rechts != null) {
			int diepteLinks = links.getDiepte();
			int diepteRechts = rechts.getDiepte();
			
			//keuze voor de minst diepe, daar naartoe
			if(diepteLinks <= diepteRechts) {
				links.voegToe(element);
			}
			else {
				//dus als rechts minder diep is
				rechts.voegToe(element);
			}
		}
		
		
		
	}

	public int getDiepte() {
		if (links == null && rechts == null) {return -1;}
		else if (links != null && rechts != null) {
			//bereken de diepte van elke subtree
			int diepteLinks = links.getDiepte();
			int diepteRechts = rechts.getDiepte();
			
			if (diepteLinks > diepteRechts) {
				return (diepteLinks +1);
			}
			else {
				return (diepteRechts +1);
			}
		}
		else if (links != null && rechts == null) {
			int diepteLinks = links.getDiepte();
			return (diepteLinks +1);
		}
		else if (links == null && rechts != null) {}
			int diepteRechts = rechts.getDiepte();
			return (diepteRechts +1);
	}
		
		
	}
	
	

