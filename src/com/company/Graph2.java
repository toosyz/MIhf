package com.company;
import java.util.ArrayList;
import java.util.List;


class Graph2 {
    private int objects;
    private int width;
    private int height;
    private List<Node> nodes;
    Graph2()
    {
        objects=0;
        width=0;
        height=0;
        nodes=new ArrayList<>();
    }

    void addNodes(Node n)
    {
        nodes.add(n);
    }
    void setHeight(int n) { height=n; }
    void setWidth(int n) { width=n; }
    void setObjects(int n) { objects=n;}
    void print()
    {
        for (Node node : nodes) {
            System.out.println(node.getValue());
        }
    }
    void setNodeNeighbours()
    {
        for (int i=0; i<nodes.size(); i++) {
            Node n=nodes.get(i);
            System.out.println("index is "+i +" with value " + n.getValue());
            int temp = n.getValue();
            int x=n.x;
            int y=n.y;
            if (temp >= 16) {
                n.setObject(true);
                temp -= 16;
            }
            if (temp >= 8) {
                n.setWest(null);
                temp -= 8;
            } else n.setWest(nodes.get(i-1));
            if (temp >= 4) {
                n.setSouth(null);
                temp -= 4;
            } else if(i==nodes.size()-1) n.setSouth(null);
                else n.setSouth(nodes.get(i+width));
            if (temp >= 2) {
                n.setEast(null);
                temp -= 2;
            } else n.setEast(nodes.get(i+1));
            if (temp >= 1) {
                n.setNorth(null);
                temp -= 1;
            } else if (i==0) n.setNorth(null);
                else n.setNorth(nodes.get(i-width));
        }
    }
}
