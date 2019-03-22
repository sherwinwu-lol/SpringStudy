package com.wusd.design.second.simpleFactoryPattern.ex;

import com.wusd.design.util.XMLUtil;

public class GraphFactory {
    public static Graph getGraph() throws UnSupportShapeException {
        String type = XMLUtil.getRootTag("target/classes/graphConfig.xml", "type");
        Graph graph = null;
        switch (type) {
            case "circle":
                graph = new Circle();
                break;
            case "rectangle":
                graph = new Rectangle();
                break;
            default:
                throw new UnSupportShapeException(type);
        }
        return graph;
    }
}
