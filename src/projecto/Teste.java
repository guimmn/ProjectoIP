package projecto;

public class Teste {	
	
	//imgs e cores para teste
	
		static ColorImage blackSquare = new ColorImage(100,100);
		
		static ColorImage whiteSquare = Image.whiteBg(100, 100);
				
		static ColorImage bg = new ColorImage("bg.png");
		
		static ColorImage salazar = new ColorImage("objc1(1).png");
					
		static ColorImage pattern = new ColorImage("pattern.jpeg");
		
		static ColorImage salazarCircle = Image.circleSelection(salazar, 90, 100, 90);
		
		static ColorImage salazarGray = Image.replicateGrayscale(salazar);
				
		
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
	
	//teste da função que cria uma reṕlica redimensionada (1.3)
	static ColorImage scaleTest(ColorImage img, double factor){
		
		ColorImage scaledImg = Image.scale(img, factor);
		
		return scaledImg;
	}
	
	//teste da função que cria uma selecção circular (1.4)
	static ColorImage circleSelectionTest(ColorImage img, int x, int y, int radius){
		
		ColorImage circleSelec = Image.circleSelection(img, x, y, radius);
		
		return circleSelec;
		
	}
	
	//teste da função que cria réplica em "grayscale" (1.5)
	static ColorImage replicateGrayscaleTest(ColorImage img){
		
		ColorImage grayImg = Image.replicateGrayscale(img);
		
		return grayImg;
	}
	
	
//Testes da Class Layer
	
	static Layer testLayer =  new Layer(salazar, "salazar", 0.5, 50, 50);
	
	static Layer testLayer1 =  new Layer(salazar, "salazar", 1.0, 50, 50);

	static Layer testPreto = new Layer(blackSquare,"preto",1,350,200);
	
	static Layer testBranco = new Layer(whiteSquare,"branco",1,0,0);
	
	static Layer testSalazarCircle = new Layer(salazarCircle,"salazarCircle",0.5,100,100);
	
	static Layer testSalazarGray = new Layer(salazarGray,"salazarGray",0.7,250,50);
	
	static String nameTest(){
		
		testLayer.setName("Jeff");
		return testLayer.getName();
	}
	
	static double setScaleTest(){
		
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
	
	static void nullImgTest(ColorImage img){
		
		Layer nullTest = new Layer(img);
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
	
	static void removeLastLayerTest(){
		
		test1.setBackground(pattern); //add bg
		test1.addLayer(testLayer); //add layer
		test1.addLayer(testLayer1);// add layer c img maior
		ColorImage test = test1.layers[2].getLayer(); //vê layer no i=2
		int x = test1.next;//nº de imagens
		
		test1.removeLayer(2);
		x = test1.next;
		test = test1.layers[1].getLayer();
		test = test1.layers[2].getLayer();//deve dar erro
		

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
		quadrado = test1.layers[test1.next-1].getLayer();
	}
	
	static void inserLayerBeyondNextTest(){
	
		test1.setBackground(pattern);
		test1.addLayer(testPreto);
		test1.addLayer(testPreto);
		test1.addLayer(testPreto);
		
		int x = test1.next;
		
		test1.insertLayer(testSalazarCircle, 4);
		test1.insertLayer(testSalazarGray, 67);
		
		ColorImage circle = test1.layers[4].getLayer();
		ColorImage gray = test1.layers[5].getLayer();
	}
	
	static void insertTest(){
		
		Poster testInsert = new Poster(100,100);
		
		testInsert.setBackground(pattern);
		
		int x = testInsert.next;
		
		testInsert.insertLayer(testSalazarGray, 3);
		
		x = testInsert.next;
		
		String testName = testInsert.layers[1].getName();
		
		testInsert.insertLayer(testSalazarCircle, 3);
		
		String testName2 = testInsert.layers[2].getName();
		
		testInsert.insertLayer(testPreto, 4);
		
	}
	
	static void swapLayerTest(){
		
		test1.setBackground(pattern);
		ColorImage layer0 = test1.layers[0].getLayer();
		test1.addLayer(testLayer);
		ColorImage layer1 = test1.layers[1].getLayer();
		test1.addLayer(testSalazarCircle);
		ColorImage layer2 = test1.layers[2].getLayer();
		
		//trocar layer 0 com layer 1
		test1.swapLayer(1, 2);
		//verificar
		ColorImage newLayer0 = test1.layers[1].getLayer();
		ColorImage newLayer1 = test1.layers[2].getLayer();
		
		ColorImage testBg = test1.getFinalPoster();
	}
	
	
	static ColorImage finalPosterTest(){
		
		//definir dimensões da tela
		Poster estadoNovo = new Poster(400,225);
		
		//criar layers que constituem o poster
		estadoNovo.setBackground(pattern);
		estadoNovo.addLayer(testLayer);//salazar em (50,50), f=0.5
		estadoNovo.addLayer(testPreto);//quadrado preto em (0,0), f=1
		estadoNovo.addLayer(testBranco);//quadrado branco em (0,0), f=1
		
		estadoNovo.addLayer(testSalazarCircle);
		estadoNovo.addLayer(testSalazarGray);
		
		ColorImage posterFinal = estadoNovo.getFinalPoster();
		
		return posterFinal;
		
		
	}
	
	//teste para verificar alterações de escala e posição
	static void posterFinalTest1(){
		
		Poster estadoNovo1 = new Poster(400,225);
		
		Layer salazar0 = new Layer(salazar);
		
		estadoNovo1.setBackground(pattern);
		estadoNovo1.addLayer(salazar0);
		ColorImage check1 = estadoNovo1.getFinalPoster();
		
		salazar0.setPosition(150, 50);
		salazar0.setScale(0.5);
		ColorImage check2 = estadoNovo1.getFinalPoster();
		
		estadoNovo1.addLayer(testSalazarCircle);
		testSalazarCircle.setPosition(0, 0);
		ColorImage check3 = estadoNovo1.getFinalPoster();
		
		estadoNovo1.layers[2].deactivate();
		ColorImage check4 = estadoNovo1.getFinalPoster();
	}
	
	static void illegalBgStatesTest(){
		
		Poster testState = new Poster(100,100);
		
		testState.setBackground(pattern);
		
		testState.insertLayer(testSalazarCircle, 0);//toggle com comment
		
		testState.addLayer(testSalazarCircle);
		testState.swapLayer(0, 1);
	}
	
	static void illegalArgTest(){
		
		Poster testArg = new Poster(400,225);
		
		testArg.setBackground(pattern);
		testArg.addLayer(testSalazarCircle);
		testArg.insertLayer(testSalazarCircle, 2);
		ColorImage test = testArg.getFinalPoster();
		testArg.insertLayer(testPreto, -1);
	}
	
	
	
	
	
	
	
}
