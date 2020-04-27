package algo.trees.tree;

public class IntCTree extends CTree<Integer> {

    @Override
    public Integer getPrevDiscreteValue(Integer item) {
        return item - 1;
    }
}
