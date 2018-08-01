
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
	
}
	
	

