package projecto;

public class Poster {

	int width;
	int height;
	int next;
	
	static final int SIZE_INIT = 4; 
	
	Layer[] layers;
	
	
	Poster(int width, int height){
		
		this.width = width;
		this.height = height;
		
		next = 0;
		
		//capacidade do poster por defeito
		this.layers = new Layer[SIZE_INIT]; 
						
	}
	
	//1
	void setBackground(ColorImage img){
		
		ColorImage background = Image.backgroundPattern(img, width, height);
		
		layers[0] = new Layer(background,"bg",1.0,0,0);
		
		next++;
		
	}
	
	//função desenvolvida para testar funcionamento do setBg
	Layer getBackground(){
		
		return this.layers[0];
	}
	
	//2
	void addLayer(Layer layer){
		
		if(layers.length == next){
			
			Layer[] resized = new Layer[layers.length +1];
				
				for(int i = 0; i < layers.length; i++){
					
					resized[i] = layers[i];
				}
				
				layers = resized;
		}
		
		layers[next] = layer;
		next ++;
	}
	
	//3
	void removeLayer(int index){
		
		if(index >= next){
			
			throw new IllegalStateException("a posição escolhida não tem nenhuma imagem");
		}
	
		layers[index] = null;
		next = next -1 ;
		
			for(int i = layers.length; i > index; i--){
				
				layers[i] = layers[i-1];
				
			}

	}
	
	//4
	void insertLayer(Layer layer,int index){
		
		if(layers.length == next){
			
			Layer[] resized = new Layer[layers.length +1];
				
				for(int i = 0; i < layers.length; i++){
					
					resized[i] = layers[i];
				}
				
				layers = resized;
		}
		
		for(int i = next - 1; i > index; i--){
			
			layers[i] = layers[i-1];
		}
		
		layers[index] = layer;
		next++;
	}
	
	//5
	void swapLayer(int a, int b){
		
		Layer a0 = layers[a];
		Layer b0 = layers[b];
		
		layers[a] = b0;
		layers[b] = a0;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
