import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class treeBfs {
    public static void main(String[] args) {

    }

    public static ArrayList<String> solution(tree node) {
        //bfs -> 큐(선입선출)
        // 1번 노드를 큐에 저장, 그 후 1번 노드의 자식을 순회하고 자식 노드가 없거나 순회를 마치면 큐에서 제거
        ArrayList<String> result = new ArrayList<>();
        result.add(node.getValue());

        Queue<tree> que = new LinkedList<>();
        que.add(node);

        //만약 que가 빈 리스트가 아니라면 -> 반복
        while (que.size() > 0) {
            //que의 첫번째 요소를 꺼내(peek())
            tree parent = que.peek();
            ArrayList<tree> parentChild = parent.getChildrenNode();
            // 자식노드가 있으면 순회하면서 que에 저장, result에 해당 노드 밸류값 저장
            if(parentChild != null) {
                for(int i = 0; i < parentChild.size(); i++) {
                    que.add(parentChild.get(i));
                    result.add(parentChild.get(i).getValue());
                }
            }
        // 자식이 없거나 순회가 끝나면 해당 노드는 que에서 제거
            que.poll();
        }
        return result;
    }

    public static ArrayList<String> solution2(tree node) {
        Queue<tree> que = new LinkedList<>();
        ArrayList<String> result = new ArrayList<>();
        que.add(node);

        while (que.size() > 0) {
            tree curNode = que.poll(); // poll() 삭제 후 삭제된 요소를 반환하는 메서드
            result.add(curNode.getValue());
            if(curNode.getChildrenNode() != null) {
                que.addAll(curNode.getChildrenNode());
            }
        }
        return result;
    }

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
