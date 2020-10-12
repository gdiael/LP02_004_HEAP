public class Heap extends PriorityQueue {
	
	public Heap(){
		super(100);
	}

	public Heap(int[] vetor){
		if(vetor.length > 0){
			this.size = vetor.length;
			this.capacity = vetor.length;
			this.elements = vetor;
			for(int i = this.size/2; i>0; i--){
				descer(i);
			}
		}else{
			this.size = 0;
			this.capacity = 100;
			this.elements = new int[this.capacity];
		}
	}
	
	// Verifica se o vetor base está vazio
	private Boolean isEmpty(){
		return this.size < 1;
	}

	// Verifica se o vetor base está vazio e joga uma mensagem de erro
	private Boolean isEmptyWithWarning(){
		if(this.isEmpty()){
			throw new IndexOutOfBoundsException("Esta lista está vazia!");
		}
		return false;
	}

	// verifica se o elemento e seu pai atendem a condição de heap, se não, sobe este elemento
	public void subir(int i){
		if(this.isEmptyWithWarning()) return;

		int parent = (i+1)/2-1;
		if(parent < 0) return; // o inice informado representa o primeiro elemento, por isso não tem pai
		if(parent >= this.size) return; // caso o indice informado esteja muito fora, quando dividirmos por dois ainda estará fora
		if(this.elements[i] > this.elements[parent]){ // se o elemento atual for maior que sei pai
			this.trocar(i, parent); // trocamos os dois de posição
			this.subir(parent); // fazemos a verifcação na nova posição
		}
	}
	
	// verifica se o elemento e seus filhos atendem a condição de heap, se não, desce este elemento
	public void descer(int i){
		if(this.isEmptyWithWarning()) return;

		int son = (i+1)*2-1; // sera o indice do primeiro filho
		if(son >= this.size) return; // se o indice em son está fora do vetor, nada a fazer
		if(son < this.size-1){ // se existe um proximo elemento
			if(this.elements[son+1] > this.elements[son]){ // verificamos se ele é maior que son
				son++; // se for incrementamos son para o proximo indice
			}
		}
		if(this.elements[son] > this.elements[i]){ // se o elemento em son é maior que o atual
			this.trocar(i, son); // trocamos de lugar
			descer(son); // procedemos com a verificação na nova posição
		}
	}

	// troca dois elementos de posição
	public void trocar(int a, int b){
		if(this.isEmptyWithWarning()) return;

		int aux = this.elements[a];
		this.elements[a] = this.elements[b];
		this.elements[b] = aux;
	}

	public boolean add(int value) {
		this.elements[this.size] = value;
		this.size += 1;
		subir(this.size-1);
		return true;
	}
	
	// retorna o maior elemento [primeiro], remove-o e reorganiza o vetor para continuar nas condições de heap
	public int remove() {
		if(this.isEmptyWithWarning()) return -1;

		int valor = this.elements[0];
		this.trocar(0, this.size-1);
		this.size -= 1;
		this.descer(0);
		return valor;
	}
	
	// retorna o maior elemento [primeiro]
	public int get() {
		if(this.isEmptyWithWarning()) return -1;

		return this.elements[0];
	}
	
	// atualiza um determinado valor
	public void update(int valor, int newValue) {
		if(this.isEmptyWithWarning()) return;
		
		Boolean noFind = true;
		for(int i = 0;i < this.size;i++){
			if(this.elements[i] == valor){
				this.elements[i] = newValue;
				if(newValue > valor){
					this.subir(i);
				}
				if(newValue < valor){
					this.descer(i);
				}
				noFind = false;
				break;
			}
		}
		if(noFind) System.out.println("Valor não encontrado!");
	}
}