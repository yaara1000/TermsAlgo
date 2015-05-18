package com.company.Graph;

import org.jgrapht.graph.DefaultEdge;
import org.jgrapht.graph.DefaultWeightedEdge;

/**
 * Created by Yaara on 02/05/2015.
 */
public class TermEdge extends DefaultWeightedEdge {

    public String GetSource() {
        String source = (String) this.getSource();
        return source;
    }

    public String GetTarget() {
        String target = (String) this.getTarget();
        return target;
    }
}
