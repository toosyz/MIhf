package com.company;

class Node {
    private Node north;
    private Node east;
    private Node south;
    private Node west;
    private boolean isObject;
    public int x, y;
    private int value;
    Node(int in, int x, int y)
    {
        this.x=x;
        this.y=y;
        value=in;
    }
    public int getValue() {return value;}
    public void setObject(boolean b) {isObject=b;}
    public void setNorth(Node n) {north=n;}
    public void setEast(Node n) {east=n;}
    public void setSouth(Node n) {south=n;}
    public void setWest(Node n) {west=n;}
}
