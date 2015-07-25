public class TreeMain{
	public static void main(String[] args){
		TreeGen tree = new TreeGen();
		try{
			tree.insertTree(args[0]);
			tree.insertTree(args[1]);
			tree.insertTree(args[2]);
			tree.insertTree(args[3]);
			tree.printInOrder();

			System.out.println("MOMENTO DE ELIMINACION ");
			tree.removeTree("1");
			

			tree.printInOrder();	

	 	}catch (ExceptionTree e){}
	}	
	

}