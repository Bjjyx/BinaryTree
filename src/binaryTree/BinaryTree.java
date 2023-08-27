package binaryTree;

public class BinaryTree<V,K extends Comparable<K>> {

    private Root<V,K> startRoot;

    public BinaryTree(V value,K key){
        this.startRoot = new Root<>(value,null,null,null,key);
    }

    private void illegalKey(Root<V,K> root,K key){

        if (root.getKey().equals(key)){
            throw new IllegalArgumentException("Значение с данным ключём уже существует");
        }

    }
    //Подумать о переделке. Сделать реализацию setRoot иначе.
    //Возможно стоит заменить сравнение хэшкодов, на кампеир, чтобы было не так громоздко
    public void add(V value, K key){

        Root<V,K> tempRoot = startRoot, tempRoot2 = null;

        while (tempRoot != null){
            illegalKey(tempRoot,key);
            tempRoot2 = tempRoot;
            if (tempRoot.getKey().hashCode() < key.hashCode()){
                tempRoot = tempRoot.getRightRoot();
            } else {
                tempRoot = tempRoot.getLeftRoot();
            }
        }
        if (tempRoot2.getKey().hashCode() < key.hashCode()){
            tempRoot2.setRightRoot(new Root<V,K>(value, null, null, tempRoot2, key));
        } else {
            tempRoot2.setLeftRoot(new Root<V,K>(value, null,null, tempRoot2, key));
        }
        System.out.println(tempRoot2.getRightRoot().getValue());

    }

    public void delete(K key) {

        Root<V,K> tempRoot = getByKey(key), tempRoot2 = null;

        if (tempRoot == null){
            return;
        }
        if (tempRoot.getLeftRoot() == null && tempRoot.getRightRoot() == null){
            if (tempRoot.getHighRoot().getLeftRoot() == tempRoot){
                tempRoot.getHighRoot().setLeftRoot(null);
                return;
            } else {
                tempRoot.getHighRoot().setRightRoot(null);
                return;
            }
        }
        if (tempRoot.getRightRoot() == null){
            if (tempRoot == startRoot){
                startRoot = startRoot.getLeftRoot();
            } else {
                if (tempRoot == tempRoot.getHighRoot().getLeftRoot()){
                    tempRoot.setLeftRoot(tempRoot.getLeftRoot());
                } else {
                    tempRoot.setRightRoot(tempRoot.getLeftRoot());
                }
            }
        } else {
            Root<V,K> leftMost = tempRoot.getRightRoot();
            while (leftMost != null) {
                tempRoot2 = leftMost;
                leftMost = leftMost.getLeftRoot();
            }
                if (tempRoot2 != null){
                    tempRoot.setValue(tempRoot2.getValue());
                    tempRoot.setKey(tempRoot2.getKey());
                    tempRoot2.getHighRoot().setLeftRoot(tempRoot2.getRightRoot());
                } else {
                    tempRoot.getRightRoot().setHighRoot(tempRoot.getRightRoot());
                }
        }

    }

    public V getValueByKey(K key) {

        Root<V,K> tempRoot = getByKey(key);
        if (tempRoot == null){
            System.out.println("Not found");
            return null;
        } else {
            return tempRoot.getValue();
        }

    }

    private Root<V,K> getByKey(K key) {

        Root<V,K> tempRoot = startRoot;

        while (tempRoot != null){
            if(tempRoot.getKey().hashCode() < key.hashCode()){
                tempRoot = tempRoot.getRightRoot();
            } else if (tempRoot.getKey().hashCode() > key.hashCode()) {
                tempRoot = tempRoot.getLeftRoot();
            } else {
                return tempRoot;
            }
        }
        return null;

    }

}
