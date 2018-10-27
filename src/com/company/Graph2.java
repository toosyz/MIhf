package com.company;
import java.util.ArrayList;
import java.util.List;


class Graph2 {
    private int objects;
    private int width;
    private int height;
    private static List<Node> nodes;
    private static List<Node> finalPath;
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
    void printPath()
    {
        Node n;
        List<Node> objectNodes=new ArrayList<>();
        for(int i=1; i<finalPath.size(); i++)
        {
            n=finalPath.get(i);
            n.print();
            if(n.objectON() && !objectNodes.contains(n)) {
                objectNodes.add(n);
                System.out.println("felvesz");
            }
        }
    }

    public void initSearch()
    {
        Node start=nodes.get(0);
        finalPath=new ArrayList<>();
        finalPath.addAll(search(start, null));
        finalPath.addAll(search(finalPath.get(finalPath.size()-1), nodes.get(nodes.size()-1)));
        printPath();
        System.out.println();
    }

    public List<Node> search(Node from, Node to)
    {
        List<Node> path=new ArrayList<>();
        List<Node> visited=new ArrayList<>();
        List<Node> objectNodes=new ArrayList<>();
        Node current=from;
        int foundObjects=0;
        while(true)
        {
            path.add(current);
            if(!visited.contains(current)) visited.add(current);
            if(to!=null)
            {
                if(current==to) break;
            }
            else
            {
                if(current.objectON() && !objectNodes.contains(current)) {
                    foundObjects++;
                    objectNodes.add(current);
                }
                if(foundObjects==objects) break;
            }
            if(current.getEast()!=null && !path.contains(current.getEast())) {
                current=current.getEast();
            }
            else if(current.getSouth()!=null && !path.contains(current.getSouth())) {
                current=current.getSouth();
            }
            else if(current.getWest()!=null && !path.contains(current.getWest())) {
                current=current.getWest();
            }
            else if(current.getNorth()!=null && !path.contains(current.getNorth())) {
                current=current.getNorth();
            }
            else
            {
              //  path.remove(current);
             //   System.out.print("Turned around at ");
              //  current.print();
                current=path.get(path.indexOf(current)-1);
            }
           /* System.out.println("Current path is: ");
            for(Node n:path)
            {
                n.print();
            }
            System.out.println();
            try {
                Thread.sleep(200);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }*/
        }
        if(to!=null) path.remove(0);
       /* System.out.println(foundObjects + " objects found");
        for(Node n: objectNodes)
        {
            n.print();
        }*/
        return path;
    }

    void setNodeNeighbours()
    {
        for (int i=0; i<nodes.size(); i++) {
            Node n=nodes.get(i);
           // System.out.println("index is "+i +" with value " + n.getValue());
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
