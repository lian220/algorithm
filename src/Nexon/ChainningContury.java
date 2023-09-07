package Nexon;

import java.util.*;

public class ChainningContury {

    static int[][] graph;
    // 각 노드의 부모
    static int[] parent;

    public static int minimumCost(List<Integer> cost, List<List<Integer>> offers) {
        int answer = 0;
        // cost 갯수 만큼의 지점이 있어
        // 지점이름은 순서대로 0부터의 숫자라고 하자
        // 각 지점 0, 1 의 이동 비용은 cost[0] + cost[1] 이야
        // 특수한 경우가 있는대
        // offer라는 특수한 경우가 있는대
        // offer는 [0, 1, 2] 이렇게 3개의 숫자로 이루어져있어
        // 이떄는 0->1 비용이 2라고 계산하면돼
        // offer는 여러개가 있을 수 있어. 이걸 offers 라고 할게
        // 이때 모든 지점을 방문하는데 드는 최소 비용을 구해야해

        graph = new int[cost.size()][3];
        for (int i = 0; i < cost.size(); i++) {

        }
        parent = new int[V];
        final_cost = 0;

        // 간선 비용 순으로 오름차순 정렬
        Arrays.sort(graph, (o1, o2) -> Integer.compare(o1[2], o2[2]));

        // makeSet
        for (int i = 0; i < V; i++) {
            parent[i] = i;
        }
        // 낮은 비용부터 크루스칼 알고리즘 진행
        for (int i = 0; i < E; i++) {
            // 사이클이 존재하지 않는 경우에만 간선을 선택한다(여기서는 최종 비용만 고려하도록 하겠다).
            if (find(graph[i][0] - 1) != find(graph[i][1] - 1)) {
                System.out.println("<선택된 간선>");
                System.out.println(Arrays.toString(graph[i]));
                union(graph[i][0] - 1, graph[i][1] - 1);
                final_cost += graph[i][2];
                System.out.println("<각 노드가 가리키고 있는 부모>");
                System.out.println(Arrays.toString(parent) + "\n");
                continue;
            }
        }

        return answer;
    }

    //조상찾기
    static int find(int a) {
        if(parent[a]==a) return a;
        return find(parent[a]);
    }

    //동맹찾기
    static void union(int a, int b) {
        parent[find(a)]=find(b);
    }

    //노드 연결 정보
    static class info implements Comparable<info>{
        int start, target, cost;
        public info(int start, int target, int cost) {
            this.start= start;
            this.target= target;
            this.cost= cost;
        }
        @Override
        public int compareTo(info o) {
            return this.cost-o.cost;
        }
    }

    public static void main(String[] args) {
        List<Integer> cost = List.of(
                3, 1, 2, 3, 1);
        List<List<Integer>> offer = List.of(
                List.of(3, 4, 1),
                List.of(1, 5, 5));

        System.out.println(minimumCost(cost, offer));
    }

}
