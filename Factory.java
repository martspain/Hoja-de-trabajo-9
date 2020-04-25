
public class Factory{
    public Mapping<String,String> getMapping(String type){
        if(type == null){
			System.out.println("-Se ha ingresado un valor no valido, por favor ingresar de nuevo...");
			return null;
		}

        if(type.equals("HashMap")){
            return new Hashing<String,String>();
        }
        /*
        else if(type.equals("RedBlackTree")){
            return new RedBlackTree();
        }
        */
        System.out.println("-Se ha ingresado un valor no valido, por favor ingresar de nuevo...");
        return null;
    }
}