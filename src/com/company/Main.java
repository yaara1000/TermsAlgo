package com.company;

import com.company.Graph.GraphAlgo;

import java.util.logging.*;

public class Main {
    private final static Logger LOGGER = Logger.getLogger("AlgoLog");

    public static void main(String[] args) {
        String[] terms;
        terms = new String[]{"Java", "C#", "Database", "Oracle", "Linux", "Developer", "Security", "TCP/IP", "PHP"};
        // write your code here
        LOGGER.info("Starting Algo");
        GraphAlgo gr = new GraphAlgo();
        for (int i = 0; i < terms.length; i++) {
            gr.Graph.addVertex(terms[i]);

        }
        for (int i = 0; i < terms.length - 2; i += 3) {
            gr.addEdge(terms[i], terms[i + 1]);
            gr.addEdge(terms[i], terms[i + 2]);
        }
        gr.addEdge("Java", "C#");

        for (int i = 0; i < terms.length; i++) {
            System.out.println(terms[i]);
            gr.FindNeighbors(terms[i], 0);


        }
        System.out.println(gr.toString());


        LOGGER.info("Finishing Algo");

    }
}
