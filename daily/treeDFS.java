import java.util.ArrayList;

public class treeDFS {
    public static void main(String[] args) {

    }

    public static ArrayList<String> solution1(tree node){
        // 실패한 풀이
        // 결과값을 담을 ArrayList 선언 -> 결과값 : node의 변수 value
        // 방문여부는 체크할 수 없으나 tree 클래스에는 자식 노드의 값이 들어가 있음 -> 뒤로 돌아갈 필요 x
        // 1. node의 value를 어레이리스트에 저장한 후, children 값을 불러와 리스트 안에 있는 노드로 재귀 돌리기
        // 2. 재귀 종료 조건 -> 자식노드가 없을 경우
        ArrayList<String> result = new ArrayList<>();

        result.add(node.getValue());

        ArrayList<tree> nodesChild = node.getChildrenNode();

        // 만약 nodesChild의 사이즈가 0이라면 return result
        if(nodesChild.size() == 0) return result;
        // 0이 아니라면 nodeChild의 사이즈만큼 반복문을 돌림
        for(int i = 0; i < nodesChild.size(); i++) {
        // 리스트에서 하나씩 빼며 재귀 돌리기
           // solution1(nodesChild.get(i)); -> 재귀를 돌리면 위에 로직에서 해당 value가 저장될 것을 예상 했으나 안됨
            result.addAll(solution1(nodesChild.get(i)));
        }
        return result;
        // 해당 로직은 nodesChild.size() != 0으로 NullPointerException이 발생
        // (nodesChild.size() != 0) 와 (nodeChild != null)의 차이?
    }

    public static ArrayList<String> solution2(tree node) {
        ArrayList<String> result = new ArrayList<>();

        result.add(node.getValue());

        ArrayList<tree> nodesChild = node.getChildrenNode();

        if(nodesChild != null) {
            for(int i = 0; i < nodesChild.size(); i++) {
                ArrayList<String> list = solution2(nodesChild.get(i));
                result.addAll(list);
                // add()와 addAll()의 차이
                // add(String e)이고 addAll(Collection<? extends String>)
            }
        }
        return result;
    }




    // tree 클래스는 수정 불가
    public static class tree {
        private String value;
        private ArrayList<tree> children;

        public tree(String data) {
            this.value = data;
            this.children = null;
        }

        public tree addChildNode(tree node) {
            if(children == null) children = new ArrayList<>();
            children.add(node);
            return children.get(children.size() - 1);
        }

        public String getValue() {      //현재 노드의 데이터를 반환
            return value;
        }

        public ArrayList<tree> getChildrenNode() {
            return children;
        }
    }
}
