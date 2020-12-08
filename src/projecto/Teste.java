package projecto;

public class Teste {	
	
	//imgs e cores para teste
	
		static ColorImage blackSquare = new ColorImage(100,100);
				
		static ColorImage bg = new ColorImage("bg.png");
		
		static ColorImage salazar = new ColorImage("objc1(1).png");
					
		static ColorImage pattern = new ColorImage("pattern.jpeg");
		
		static final Color TRANSPARENT = new Color(255,255,255);
				
		static Layer testLayer =  new Layer(salazar, "salazar", 0.5, 50, 50);


//Testes da Class Image
	
	static ColorImage whiteBgTest(int width, int height){
		
		ColorImage bg = Image.whiteBg(width, height);
		
		return bg;
	}
	
	//teste da função paste (1.1)
	static ColorImage pasteTest(ColorImage base, ColorImage img, int x, int y){
		
		Image.paste(base, img, x, y);
		
		return base;
	
	}
	
	//teste da função que cria padrões (1.2)
	static ColorImage backgroundPatternTest(ColorImage img, int width, int height){

		ColorImage test = Image.backgroundPattern(img, width, height);
		
		return test;
	}
	
//Testes da Etapa 2
	
	static String nameTest(){
		
		testLayer.setName("Jeff");
		return testLayer.getName();
	}
	
	static double scaleTest(){
		
		testLayer.setScale(0.5);
		return testLayer.getScale();
	}
	
	static int[] positionTest(){
		
		testLayer.setPosition(5, 5);
		return testLayer.getPosition();
	}
	
	static ColorImage getLayerTest(){
		
		ColorImage test = testLayer.getLayer();
		
		return test;
	}

	
	
	
	
}
