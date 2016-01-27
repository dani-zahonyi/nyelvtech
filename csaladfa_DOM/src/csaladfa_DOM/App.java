package csaladfa_DOM;



public class App {


	public static void main(String[] args) {
		
		DOM dom = new DOM();
		dom.parse("src\\csaladfa.xml");
		
		System.out.println("\n-----------------------\nBeolvasott adatokból\n-----------------------");
		for(Szemely e:dom.getCsaladfa())
		System.out.println(e.toString());
		System.out.println("\n");
		
	}
}