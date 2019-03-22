package com.wusd.design.second.simpleFactoryPattern.ex;

public class Client {
    public static void main(String[] args) {
        try {
            Graph graph = GraphFactory.getGraph();
            graph.draw();
            graph.erase();
        } catch (UnSupportShapeException e) {
            e.printStackTrace();
        }
    }
}
