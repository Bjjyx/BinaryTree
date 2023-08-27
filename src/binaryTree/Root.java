package binaryTree;

class Root<V,K extends Comparable<K>> {

    private K key;
    private Root<V,K> rightRoot;
    private Root<V,K> leftRoot;
    private Root<V,K> highRoot;
    private V value;
    // Переделать
    Root(V value, Root<V,K> rightRoot, Root<V,K> leftRoot, Root<V,K> highRoot, K key){

        this.key = key;
        this.rightRoot = rightRoot;
        this.leftRoot = leftRoot;
        this.highRoot = highRoot;
        this.value = value;

    }

    K getKey(){
        return key;
    }
    Root<V,K> getRightRoot(){
        return rightRoot;
    }
    Root<V,K> getLeftRoot(){
        return leftRoot;
    }
    Root<V,K> getHighRoot(){
        return highRoot;
    }
    V getValue(){
        return value;
    }

    void setKey(K key){
        this.key = key;
    }
    void setRightRoot(Root<V,K> rightRoot){
        this.rightRoot = rightRoot;
    }
    void setLeftRoot(Root<V,K> leftRoot){
        this.leftRoot = leftRoot;
    }
    void setHighRoot(Root<V,K> highRoot){
        this.highRoot = highRoot;
    }
    void setValue(V value){
        this.value = value;
    }
}
