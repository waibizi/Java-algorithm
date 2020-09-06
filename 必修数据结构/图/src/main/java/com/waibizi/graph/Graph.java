package com.waibizi.graph;

import java.util.HashSet;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @Author 歪鼻子
 * @Date 2020/9/6 1:52
 * @Description:
 * @Version 1.0
 */
public class Graph<V,E> {
    /**
     * 对于每个顶点，应该知道自己有多少边，并且需要知道自己的边，从自己出发的有多少条，来到自己这个顶点的有多少个
     * @param <V>
     * @param <E>
     */
    private static class Vertex<V,E> {
        V value;
        Set<Edge<V,E>> inEdges = new HashSet<>();
        Set<Edge<V,E>> outEdge = new HashSet<>();

        public Vertex(V value) {
            this.value = value;
        }
    }

    /**
     * 边，对于每一条边，我们都应该知道他来自哪个顶点，要连接到哪个顶点。并且记录权值
     * @param <V>
     * @param <E>
     */
    private static class Edge<V,E>{
        /* 这条边来自哪个顶点 */
        Vertex<V,E> from;
        /* 这条边连接到哪个顶点 */
        Vertex<V,E> to;
        /* 权值 */
        E wight;

        public Edge(Vertex<V, E> from, Vertex<V, E> to) {
            this.from = from;
            this.to = to;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) {return true;}
            if (o == null || getClass() != o.getClass()) {return false;}
            Edge<?, ?> edge = (Edge<?, ?>) o;
            return from.equals(edge.from) &&
                    to.equals(edge.to) &&
                    wight.equals(edge.wight);
        }

        @Override
        public int hashCode() {
            return Objects.hash(from, to, wight);
        }
    }

    /**
     * 因为用户操作图的时候，只是传一个顶点值进来，而不是传整个顶点对象，所以我们需要根据顶点值与顶点对象对应起来
     */
    private Map<V,Vertex<V,E>> vertexs = new ConcurrentHashMap<>();
    private Set<Edge<V, E>> edges = new HashSet<>();
    public  void addVertex(V v){

    }

    /**
     * 添加没有权值的边
     * @param from
     * @param to
     */
    public  void addEdge(V from, V to) {
        addEdge(from,to,null);
    }

    /**
     *添加有权值的边
     * @param from
     * @param to
     * @param weight
     */
    public  void addEdge(V from, V to, E weight) {
        Vertex<V,E> fromVertex = vertexs.get(from);
        if (fromVertex == null){
            fromVertex = new Vertex<>(from);
            vertexs.put(from,fromVertex);
        }
        Vertex<V,E> toVertex = vertexs.get(to);
        if (toVertex == null){
            toVertex = new Vertex<>(to);
            vertexs.put(to,toVertex);
        }
        Edge<V,E> edge = new Edge<>(fromVertex,toVertex);
        edge.wight = weight;
        if (fromVertex.inEdges.remove(edge)){
            fromVertex.outEdge.remove(edge);
            edges.remove(edge);
        }
        fromVertex.outEdge.add(edge);
        toVertex.inEdges.add(edge);
        edges.add(edge);
    }

    /**
     * 获取边的数量
     * @return
     */
    public int edgesSize() {
        return edges.size();
    }
}
