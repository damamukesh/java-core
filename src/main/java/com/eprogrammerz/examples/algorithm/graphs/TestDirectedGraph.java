package com.eprogrammerz.examples.algorithm.graphs;

import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

/**
 * @author Yogen Rai
 */
public class TestDirectedGraph {
    DirectedGraph graph;

    @Before
    public void setUp() {
        /**
         *                  6
         *                /   \
         *               4  <- 5
         *             /  \     \
         *            1    2    3
         *
         */
        graph = new DirectedGraph();
    }
    @Test
    public void testRouteBetweenNodes() {

        Node a = new Node(1);
        Node b = new Node(2);
        Node c = new Node(3);
        Node d = new Node(4);
        d.connections = Arrays.asList(a, b);
        Node e = new Node(5);
        e.connections = Arrays.asList(c, d);
        Node f = new Node(6);
        f.connections = Arrays.asList(d,e);

//        assertTrue(graph.isRouteBetween(f, a)); // OK
//        assertFalse(graph.isRouteBetween(a, c)); // OK
//        assertFalse(graph.isRouteBetween(a,f));
        assertTrue(graph.isRouteBetween(e,a));

    }

    @Test
    public void testFindRouteBetweenNodes() {
        Node a = new Node(1);
        Node b = new Node(2);
        Node c = new Node(3);
        Node d = new Node(4);
        d.connections = Arrays.asList(a, b);
        Node e = new Node(5);
        e.connections = Arrays.asList(c, d);
        Node f = new Node(6);
        f.connections = Arrays.asList(d,e);

        assertThat(Arrays.asList(f, d ,a), is(graph.findRoute(f,a)));

    }
}
