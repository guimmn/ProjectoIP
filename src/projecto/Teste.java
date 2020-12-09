package projecto;

public class Teste {	
	
	//imgs e cores para teste
	
		static ColorImage blackSquare = new ColorImage(100,100);
				
		static ColorImage bg = new ColorImage("bg.png");
		
		static ColorImage salazar = new ColorImage("objc1(1).png");
					
		static ColorImage pattern = new ColorImage("pattern.jpeg");
		
		static final Color TRANSPARENT = new Color(255,255,255);
				
		

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
	
//Testes da Class Layer
	
	static Layer testLayer =  new Layer(salazar, "salazar", 0.5, 50, 50);
	
	static Layer testLayer1 =  new Layer(salazar, "salazar", 1.0, 50, 50);

	static Layer testPreto = new Layer(blackSquare,"preto",1,0,0);
	
	
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
	
//Testes da Class Poster
	
	static Poster test1 = new Poster(200,400);
	
	static ColorImage setBackgroundTest(){
		
		
		test1.setBackground(pattern);
		Layer test = test1.getBackground();
		
		ColorImage bg = test.getLayer();
		
		return bg;
		
		
	}
	
	//coloquei temporariamente o SIZE_INIT a 1
	static int addLayerTest(){
		
		int x = test1.layers.length;
		test1.setBackground(pattern);
		test1.addLayer(testLayer);
	
		x = test1.layers.length;
		
		return x;
		
	}
	
	//coloquei temporariamente o SIZE_INIT a 2
	static void removeLayerTest(){
		
		test1.setBackground(pattern); //add bg
		test1.addLayer(testLayer); //add layer
		test1.addLayer(testLayer1);// add layer c img maior
		ColorImage test = test1.layers[1].getLayer(); //vê layer no i=1
		int x = test1.next;//nº de imagens
		
		test1.removeLayer(1);//remove layer no i=1
		test = test1.layers[1].getLayer();//verificar se layer é substituída
		
		x = test1.next;
		
		test1.removeLayer(2);//esta parte deve dar erro
		
	}
	
	//coloquei o INIT_SIZE a 4 temporariamente
	static void insertLayerTest(){
		
		//a layer do salazar deverá aparecer na posição 2
		//o album deve aumentar de tamanho para 5
		
		test1.setBackground(pattern);
		test1.addLayer(testPreto);
		test1.addLayer(testPreto);
		test1.addLayer(testPreto);
		
		int x = test1.next; //deverá contar 4 (layers)
		int y = test1.layers.length;
		//album encontra-se cheio agora
		
		//vejamos a imagem guardada na posição 2, deve ser um quadrado preto
		ColorImage quadrado = test1.layers[2].getLayer();
		
		//inserir salazar e verificar se funcionou
		test1.insertLayer(testLayer, 2);
		ColorImage salazar = test1.layers[2].getLayer();
		
		//para verificar se album aumentou e se a ultima é o preto
		x = test1.next;
		y = test1.layers.length;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
