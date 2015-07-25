//Implementa directamente las ABB's

public class TreeGen {
	private TreeNode root;
	private int alt;

	public TreeGen (){
		root=null;
	}
	public Comparable getRoot(){
		return root.getValue();
	}
	public void setRoot(Comparable x){
		root.setValue(x);
	}
	public boolean isEmpty(){
		return root==null;
	}
	public void makeEmpty(){
		root=null;
	}
	public void printPreOrder(){
		root.preOrder();
	}
	public void printInOrder(){
		root.inOrder();
	}
	public void printPosOrder(){
		root.posOrder();
	}
	//Insertar elementos en el arbol sin repetidos.
	private TreeNode insert(Comparable value, TreeNode current)throws ExceptionTree{
		//caso 1: si el arbol es vacio.
		if (current==null){
			current=new TreeNode(value);
		}
		//si el arbol no es vacio.
		else{			
			//ubico por derecha
			if (  value.compareTo(  current.getValue() ) > 0 ) {
				current.setRight(insert(value, current.getRight() ) );
			}
			//ubico por izquierda
			if (value.compareTo(current.getValue() ) < 0){
				current.setLeft(insert(value, current.getLeft()));
			}
			//no ubico, elemento existente.
			if ( value.compareTo(current.getValue() )==0 ) {
				throw new ExceptionTree ("ExceptionTree : insert : Elemento Existente ");
			}
		}
		return current;
	}
	public void insertTree (Comparable value)throws ExceptionTree{
		TreeNode current = root;
		current=insert(value,current);
		root=current;
	}
	public TreeNode remove (Comparable value, TreeNode r)throws ExceptionTree{
		if (r == null) {
        return null;
    	}    
    	if (value.equals(r.getValue())) {
        // r es el nodo que hay que remover.
        	if (r.getLeft() == null && r.getRight() == null) {
            	return null;
        	}
        	if (r.getLeft() == null) {
            	return r.getRight();
        	}
        	if (r.getRight() == null) {
            	return r.getLeft();
        	}
       	// si llega aca, r tiene dos hijos.
        	Comparable smallVal = smallest(r.getRight());
        	r.setValue(smallVal);
        	r.setRight(remove(smallVal,r.getRight()) );
        	return r; 
    	}
       	else if (value.compareTo(r.getValue()) < 0) {
        	r.setLeft( remove(value,r.getLeft()) );
        	return r;
    	}
        else {
        	r.setRight( remove(value,r.getRight()) );
        	return r;
    	}	
	}
	public void removeTree(Comparable value){
		try{ 
		root=(remove(value,root));
		}catch (ExceptionTree e){}
	}









	//EL mas chico del arbol.
	public Comparable smallest(TreeNode r){
		if (r.getLeft()==null){
			return	r.getValue();
		}else{
			return smallest(r.getLeft());
		}
	}









	//CONTINUAR OTRA METODOLOGIA POR ACA!!!







	//Eliminar un elemento del arbol
	/*public void removeTree(Object x)throws ExceptionTree{
		TreeNode current=root;
		current = searchRemove(x, current);
		if (current!= null){ 
			if (isLeaf(current)){ //Si es hoja, solamente borro.
				current=null;
			}
			else{//Si no es hoja
				if ( current.getLeft()!=null && current.getLeft()!=null ){
					//buscar el minimo o maximo y setearlo con el.
					//En este caso el nodo a reemplazar es un root.
					Object valueMax= maxTree(current);
					current.setValue(valueMax);
				}
				if ( current.getLeft()==null && current.getLeft()!=null ){
					//hi = null pero el hd!= null,
					//reemplazo por el maximo de la derecha.
					Object valueMax= maxTree(current);
					current.setValue(valueMax);
				} 
				if ( current.getLeft()!=null && current.getLeft()==null ){
					//hi!= null y hd==null,
					//reemplazo por el minimo de la derecha.
					Object valueMin= minTree(current);
					current.setValue(valueMin);
				}

			}
		}else{
			throw new ExceptionTree("ExceptionTree : remove : Elemento No existente ");
		}		
	} 

	//Si un nodo es Hoja
	public boolean isLeaf (TreeNode current){
		return (current.getRight()==null && current.getLeft()==null);
	}
    //ACAAAAAAAAAAAA---------------------------------
	//Devuelve el elemento a borrar
	public TreeNode searchRemove(Comparable x, TreeNode current){
		TreeNode found = null;
		if ( ( current.getValue() ).equals(x) ){
			found=current;
		}
		if ( ( current.getValue() ).compareTo(x) > 0) {
			current.setRight(searchRemove( x,current.getRight() ) );
		}
		if (( current.getValue() ).compareTo( x) < 0){
			current.setLeft(searchRemove( x,current.getLeft() ) );
		}
		return found;
	}


	//Obtiene el minimo del arbol y lo destruye.
	//antes retornando su dato
	public Comparable minTree (TreeNode current){
		TreeNode min = current;
		while (min.getLeft()!=null){
			min=min.getLeft(); //solo avanzo
		}
		Comparable value= min.getValue();
		min=null;
		return value;
	}
	//Obtiene el maximo del arbol y lo destruye.
	//antes retornando su dato
	public Comparable maxTree(TreeNode current){
		TreeNode max= current;
		while (max.getRight()!=null){
			max=max.getRight();
		}
		Comparable value= max.getValue();
		max=null;
		return value;
	}*/

}