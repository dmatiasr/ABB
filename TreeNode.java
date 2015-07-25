public class TreeNode{
	private Comparable value;
	private TreeNode left;
	private TreeNode right;

	public TreeNode(){
		value=null;
		left=null;
		right=null;
	}
	public TreeNode(Comparable value){
		this.value=value;
		left=null;
		right=null;
	}
	//Sets de la clase
	public void setValue(Comparable x){
		value=x;
	}
	public void setLeft(TreeNode l){
		left=l;
	}
	public void setRight(TreeNode r){
		right=r;
	}

	//gets de la clase
	public Comparable getValue(){
		return value;
	}

	public TreeNode getLeft(){
		return left;
	}

	public TreeNode getRight(){
		return right;
	}
	
	//RECORRIDO PREORDER:
	//Recorre primero la raiz, luego hi y luego hd.
	public void preOrder(){
		//Se imprime la raiz
		System.out.println(" Elemento "+value);
		//se recorre el hi
		if (left != null){
			left.preOrder();
		}
		//se recorre el hd
		if (right!=null){
			right.preOrder();
		}
	}
	//RECORRIDO INORDER
	//Recorre primero el hi, luego raiz, y finalmente hd.
	public void inOrder(){
		//se recorre el hi
		if (left!=null){
			left.inOrder();
		}
		System.out.println("Elemento "+value);
		//se recorre hd
		if (right!=null){
			right.inOrder();
		}
	}
	//RECORRIDO POSORDER:
	//Recorre el hi, hd y luego raiz
	public void posOrder(){
		//se recorre el hi
		if (left != null){
			left.posOrder();
		}
		//se recorre el hd
		if (right!=null){
			right.posOrder();
		}
		System.out.println("Elemento "+value);
	}

}