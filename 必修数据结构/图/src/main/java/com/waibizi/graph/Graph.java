package com.waibizi.graph;

import java.util.List;

/**
 * @Author 歪鼻子
 * @Date 2020/9/6 1:52
 * @Description:
 * @Version 1.0
 */
public class Graph {
    private static class Vertex<V,E> {
        V value;
        List<Edge<V,E>> fromEdges;
        List<Edge<V,E>> toEdge;
    }
    private static class Edge<V,E>{
        /* 这条边来自哪个顶点 */
        Vertex<V,E> from;
        /* 这条边连接到哪个顶点 */
        Vertex<V,E> to;
        /* 权值 */
        E wight;
    }
}
