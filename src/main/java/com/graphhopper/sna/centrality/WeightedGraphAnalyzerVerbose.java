/**
 * GraphHopper-SNA implements a collection of social network analysis
 * algorithms. It is based on the <a
 * href="http://graphhopper.com/">GraphHopper</a> library.
 *
 * GraphHopper-SNA is distributed under the GPL 3 license. It is produced by the
 * "Atelier SIG" team of the <a href="http://www.irstv.fr">IRSTV Institute</a>,
 * CNRS FR 2488.
 *
 * Copyright 2012 IRSTV (CNRS FR 2488)
 *
 * GraphHopper-SNA is free software: you can redistribute it and/or modify it
 * under the terms of the GNU General Public License as published by the Free
 * Software Foundation, either version 3 of the License, or (at your option) any
 * later version.
 *
 * GraphHopper-SNA is distributed in the hope that it will be useful, but
 * WITHOUT ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or
 * FITNESS FOR A PARTICULAR PURPOSE. See the GNU General Public License for more
 * details.
 *
 * You should have received a copy of the GNU General Public License along with
 * GraphHopper-SNA. If not, see <http://www.gnu.org/licenses/>.
 */
package com.graphhopper.sna.centrality;

import com.graphhopper.sna.data.PathLengthData;
import com.graphhopper.sna.progress.ProgressMonitor;
import com.graphhopper.storage.Graph;
import gnu.trove.stack.array.TIntArrayStack;

/**
 * Calculates various centrality measures on weighted graphs which are
 * <b>assumed to be connected</b>; shows verbose output for debugging.
 *
 * Only the {@link WeightedGraphAnalyzer#calculateShortestPathsFromNode(int,
 * com.graphhopper.sna.data.PathLengthData,
 * gnu.trove.stack.array.TIntArrayStack) calculateShortestPathsFromNode} method
 * is overridden.
 *
 * @author Adam Gouge
 */
public class WeightedGraphAnalyzerVerbose extends WeightedGraphAnalyzer {

    /**
     * Initializes a new instance of a verbose weighted graph analyzer with the
     * given {@link ProgressMonitor}.
     *
     * @param graph The graph to be analyzed.
     * @param pm    The {@link ProgressMonitor} to be used.
     */
    public WeightedGraphAnalyzerVerbose(Graph graph, ProgressMonitor pm) {
        super(graph, pm);
    }

    /**
     * Initializes a new instance of a verbose weighted graph analyzer that
     * doesn't keep track of progress.
     *
     * @param graph The graph to be analyzed.
     */
    public WeightedGraphAnalyzerVerbose(Graph graph) {
        super(graph);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected void calculateShortestPathsFromNode(
            int startNode,
            PathLengthData pathsFromStartNode,
            TIntArrayStack stack) {
        DijkstraForCentralityVerbose algorithm =
                new DijkstraForCentralityVerbose(
                graph,
                nodeBetweenness,
                startNode,
                pathsFromStartNode,
                stack);
        algorithm.calculate();
        printSPInfo(startNode);
    }
}
