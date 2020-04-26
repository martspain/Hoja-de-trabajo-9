
public class SplayTree<K extends Comparable<K>, V> implements Mapping<K,V>{
    private Association<K,V> val;
    private SplayTree<K,V> parent;
    private SplayTree<K,V> left, right; 

    public SplayTree(){
        val = null;
        parent = null; 
        left = right = null;
    }

    public SplayTree(Association<K,V> assoc){
        val = assoc;
        right = left = new SplayTree<K,V>();
        setLeft(left);
        setRight(right);
    }

    public int size(){
        return 0;
    }

    public Association<K,V> get(SplayTree<K,V> node, Association<K,V> value){
        if (node.getValue().compareTo(value)==0) {
            return node.getValue();
        }
        Association<K,V> contains = null;
        if (node.getLeft() != null) {
            contains = get(node.getLeft(), value);
        }
        if (contains == null && node.getRight() != null) {
            contains = get(node.getRight(), value);
        }
    
        return contains;
    }

    public Association<K,V> remove(Association<K,V> value){
        return value;
    }

    public void setLeft(SplayTree<K,V> newLeft){
        if (isEmpty()) return;
        if (left != null && left.getParent() == this) left.setParent(null);
        left = newLeft;
        left.setParent(this);
    }

    public boolean isEmpty() {
        return this.getValue() == null;
    }

    public void setRight(SplayTree<K,V> newRight){
        if (isEmpty()) return;
        if (right != null && right.getParent() == this) right.setParent(null);
        right = newRight;
        right.setParent(this);
    }

    protected void setParent(SplayTree<K,V> newParent){
        if (!isEmpty()){
            parent = newParent;
        }
    }

    public SplayTree<K,V> getLeft() {
        return left;
    }

    public SplayTree<K,V> getRight() {
        return right;
    }

    public SplayTree<K,V> getParent() {
        return parent;
    }

    public Association<K,V> getValue(){
        return val;
    }

    public void setValue(Association<K,V> value){
        val = value;
    }

    public void add(Association<K,V> newValue, SplayTree<K,V> tree){  
        int comp = tree.getValue().compareTo(newValue);

        if(comp>0 && tree.getLeft()==null){
            tree.setLeft(new SplayTree<K,V>());
            tree.getLeft().setValue(newValue);
            balance(tree.getLeft());
        }else if(comp>0 && tree.getLeft()!=null){
            add(newValue, tree.getLeft());

        }if(comp<=0 && tree.getRight()==null){
            tree.setRight(new SplayTree<K,V>());
            tree.getRight().setValue(newValue);
            balance(tree.getRight());
        }else if(comp<=0 && tree.getRight()!=null){
            add(newValue, tree.getRight());
        }
    }

    private void balance(SplayTree<K,V> tree){
        //Repetir los movimientos hasta llegar a la raiz
        while(tree.parent != null){
            //Si el arbol esta a la izquierda del padre hacer zig
            if(tree.getValue().compareTo(tree.getParent().getValue()) < 0){
                zig(tree);
            //Si esta a la derecha del padre hacer zag
            }else{
                zag(tree);
            }
        }
    }

    private void zig(SplayTree<K,V> tree){
        tree.getRight().setParent(tree.getParent());
        tree.getParent().setLeft(tree.getRight());

        tree.setRight(tree.getParent());
        tree.setParent(tree.getRight().getParent());
        tree.getRight().setParent(tree);
    }

    private void zag(SplayTree<K,V> tree){
        tree.getLeft().setParent(tree.getParent());
        tree.getParent().setRight(tree.getLeft());

        tree.setLeft(tree.getParent());
        tree.setParent(tree.getLeft().getParent());
        tree.getLeft().setParent(tree);
    }

    public void inOrder(SplayTree<K,V> node) {
        if (node.getLeft() != null) {
            inOrder(node.getLeft());
        }else{
            System.out.println(node.getValue().toString());
            if (node.getRight() != null) {
                inOrder(node.getRight());
            }
        }
    }

    @Override
    public boolean isHashing() {
        return false;
    }

    @Override
    public V remove(K key) {
        
        return this.remove(key);
    }

    @Override
    public V put(Association<K, V> association) {
        return this.put(association);
    }

    @Override
    public boolean searchValue(String key) {
        return this.searchValue(key);
    }

    @Override
    public V get(Object key) {
        return this.get(key);
    }
}