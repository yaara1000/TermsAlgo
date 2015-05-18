package com.company.Graph;

import java.util.*;
import java.util.logging.Logger;


import org.jgrapht.graph.*;

/**
 * Created by Yaara on 29/04/2015.
 */


public class GraphAlgo {
    private final static Logger LOGGER = Logger.getLogger("AlgoLog");
    public SimpleWeightedGraph Graph; //fsfsfsf

    /*
    Constructor - graph for each search
     */
    public GraphAlgo() {

        this.Graph = new SimpleWeightedGraph(TermEdge.class);

    }

    public void addEdge(String term1, String term2) {
        try {
            if ((this.Graph.containsEdge(term1, term2)) || (this.Graph.containsEdge(term2, term1))) {
                Object edge;
                if (this.Graph.containsEdge(term1, term2)) {
                    edge = this.Graph.getEdge(term1, term2);
                } else edge = this.Graph.getEdge(term2, term1);
                this.Graph.setEdgeWeight(edge, this.Graph.getEdgeWeight(edge) + 1);

            } else {
                this.Graph.addEdge(term1, term2);
                //this.Graph.setEdgeWeight(this.Graph.getEdge(term1, term2), 1);
            }
        } catch (Exception ex) {
            LOGGER.info(ex.getMessage());
        }
    }

    /*
    Given a graph term, find neighbors
     */
    public List<String> FindNeighbors(String term, double threshold) {
        Set<TermEdge> edges = null;
        List<String> Neighbors = new ArrayList<String>();

        try {
            edges = this.Graph.edgesOf(term);

            //  System.out.println("Degree of term:" +term+" is: "+ this.Graph.degreeOf((Object) term));
            String temp;

            for (TermEdge e : edges) {
                System.out.println(e.toString());
                temp = e.GetTarget();
                if (temp.compareTo(term) == 0)
                    temp = e.GetSource();
                Neighbors.add(temp);
                System.out.println("Edge: " + e.toString() + " Weight=" + this.Graph.getEdgeWeight(e));

            }
          /*  System.out.println("Source: "+term);
            for (int i=0;i<Neighbors.size();i++){
                System.out.println(Neighbors.get(i));
            }*/

        } catch (Exception ex) {
            LOGGER.info("Error in FindNeighbors " + ex.getMessage());
        }

        return Neighbors;
    }


}
