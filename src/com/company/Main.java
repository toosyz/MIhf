package com.company;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args){
        Graph2 graph=new Graph2();
        BufferedReader br = null;
        int height=0;
        boolean setWidth=false;
        try {
            br = new BufferedReader(new InputStreamReader(System.in));
            String input;
            do {
                input = br.readLine();
                String[] line=input.split(" ");
                if(line.length==1){
                    graph.setObjects(Integer.parseInt(line[0]));
                    break;
                }
                else if(line.length==0) break;
                else{
                    if(!setWidth){
                        graph.setWidth(line.length);
                        setWidth=true;
                    }
                    for(int i=0; i<line.length; i++)
                    {
                        graph.addNodes(new Node(Integer.parseInt(line[i]), height, i));
                    }
                    height++;
                }
            } while(true);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (br != null) {
                try {
                    br.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        graph.setHeight(height);
        graph.setNodeNeighbours();
        graph.initSearch();
    }
}
