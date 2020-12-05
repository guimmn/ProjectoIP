package projecto;

public class Teste {

	static ColorImage salazar = new ColorImage("objc1(1).png");
	static Layer teste1 =  new Layer(salazar, "salazar", 0.5, 0,0);

	static String testName(){
	
		teste1.setName("Jeff");
		
		return teste1.getName();
		}
	
	static int[] testCoordinates(){
		
		return teste1.getCoordinates();
	}
	
	static double testFactor(){
		
		return teste1.getFactor();
	}
	
	static ColorImage testOriginal(){
		
		return teste1.getOriginal();
	}
	

	static void testAll(){
		
		Layer teste = new Layer(salazar,"", 0.5, 0, 0);
		
		teste.setName("salazar");
		teste.setScale(2);
		teste.setPosition(1, 2);
		
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
}
