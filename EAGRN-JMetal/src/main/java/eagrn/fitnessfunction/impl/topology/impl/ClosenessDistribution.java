package eagrn.fitnessfunction.impl.topology.impl;

import java.util.ArrayList;
import java.util.Map;

import org.apache.commons.lang.ArrayUtils;
import org.jgrapht.Graph;
import org.jgrapht.alg.scoring.HarmonicCentrality;
import org.jgrapht.graph.DefaultEdge;

import eagrn.fitnessfunction.impl.topology.Topology;

public class ClosenessDistribution extends Topology {
    private ArrayList<String> geneNames;

    public ClosenessDistribution(ArrayList<String> geneNames){
        this.geneNames = geneNames;
    }

    @Override
    public double run(Map<String, Double> consensus, Double[] x) {
        Graph<String, DefaultEdge> graph = super.getGraphFromConsensus(consensus, geneNames, true, true);
        HarmonicCentrality<String, DefaultEdge> evaluator = new HarmonicCentrality<>(graph);
        Double[] scores = evaluator.getScores().values().toArray(new Double[0]);
        for (int i = 0; i < scores.length; i++) {
            scores[i] += 1;
        }
        return -super.paretoTest(ArrayUtils.toPrimitive(scores));
    }
    
}
