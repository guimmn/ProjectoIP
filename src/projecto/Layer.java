package projecto;

public class Layer {
	
	//Imagem e nome
	ColorImage img;
	String name;
	
	//Coordenadas no poster e factor de escala
	int x;
	int y;
	double factor;
	
	//status, se está activa ou não
	boolean active = true;
	
	
//Construtores
		
	//Método 1
	Layer(ColorImage img, String name, double factor, int x, int y){
		
		this.img = img;
		this.name = name;
		this.factor = factor;
		this.x = x;
		this.y = y;
		this.active = true;
		

	}

	//Método 2
	Layer(ColorImage img, int x, int y){
		
		this(img, "sem nome", 1, x, y);
	}
	
	//Método 3
	Layer(ColorImage img){
		
		this(img, "sem nome", 1, 0, 0);
	}
	
	
//Modificadores
	
	//Muda o nome do obj Layer
	void setName(String name){
		
		this.name = name;
	}
	
	//Muda a escala 
	void setScale(double factor){
		
		if(factor <= 0){
			throw new IllegalArgumentException("factor tem de ser maior que 0!");
		}
		
		this.factor = factor;
	}
	
	//Muda o posicionamento no poster
	void setPosition(int x, int y){
		
		this.x = x;
		this.y = y;
	}
	
	//não percebi bem esta alínea ...
	void activate(){
		
		this.active = true;
	}
	
	void deactivate(){
		
		this.active = false;
	}

	
//Inspectores
	
	//diz o nome do obj
	String getName(){
		
		return this.name;
	}
	
	//diz o factor de escala da layer
	double getScale(){
		
		return this.factor;
	}
	
	//diz as coordenadas do obj layer no poster
	int[] getPosition(){
		
		int[] coordinates = new int[2];
		
		coordinates[0] = this.x;
		coordinates[1] = this.y;
		
			return coordinates;
	}
	
	ColorImage getLayer(){
		
		ColorImage scaledImg = Image.scale(img, factor);
		
		ColorImage white = Image.whiteBg(x + scaledImg.getWidth(), y + scaledImg.getHeight());
		
		Image.paste(white, scaledImg, x, y);
		
		return white;
		
		
		

		
	}
	
	
	
	
	

}
