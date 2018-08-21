
public class Element <T extends Comparable<T>> implements Comparable<Element<T>> {

    private T waarde;
    private Element<T> links;
    private Element<T> rechts;

    //default constructor, geen idee als dit nodig os
    public Element() {
        System.out.println("default constructor opgeroepen");
        waarde = null;
        links = null;
        rechts = null;
    }

    //constructor met 1 parameter, waarde
    public Element(T waarde) {
        this.waarde = waarde;
        links = null;
        rechts = null;
    }

    //copyconstructor
    public Element(Element<T> e) {
        this.waarde = e.waarde;
        this.links = e.links;
        this.rechts = e.rechts;
    }

    //is eigelijk hetzelfde als de copyconstructor
    public void setWaarden(Element<T> e) {
        this.waarde = e.waarde;
        this.links = e.links;
        this.rechts = e.rechts;
    }


    public T getWaarde() {
        return waarde;
    }
    public void setWaarde(T waarde) {
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
    public int compareTo(Element<T> elem2) {
        return this.waarde.compareTo(elem2.waarde);
    }

}