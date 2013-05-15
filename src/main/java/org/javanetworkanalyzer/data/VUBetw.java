/**
 * Java Network Analyzer provides a collection of graph theory and social
 * network analysis algorithms implemented on mathematical graphs using the
 * <a href="http://www.jgrapht.org/">JGraphT</a> library.
 *
 * Java Network Analyzer is distributed under the GPL 3 license. It is produced
 * by the "Atelier SIG" team of the <a href="http://www.irstv.fr">IRSTV
 * Institute</a>, CNRS FR 2488.
 *
 * Copyright 2013 IRSTV (CNRS FR 2488).
 *
 * Java Network Analyzer is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by the Free
 * Software Foundation, either version 3 of the License, or (at your option) any
 * later version.
 *
 * Java Network Analyzer is distributed in the hope that it will be useful, but
 * WITHOUT ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or
 * FITNESS FOR A PARTICULAR PURPOSE. See the GNU General Public License for more
 * details.
 *
 * You should have received a copy of the GNU General Public License along with
 * Java Network Analyzer. If not, see <http://www.gnu.org/licenses/>.
 */
package org.javanetworkanalyzer.data;

/**
 * Unweighted vertex to be used during the betweenness calculation.
 *
 * All distances are {@code int}s; we initialize them to -1.
 *
 * @author Adam Gouge
 */
public class VUBetw
        extends VBetw<VUBetw, Integer> {

    /**
     * Number of steps on a shortest path from a certain source leading to this
     * node (BFS).
     */
    private int distance;

    public VUBetw(Integer id) {
        super(id);
        this.distance = -1;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void reset() {
        super.reset();
        distance = -1;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void setSource() {
        super.setSource();
        distance = 0;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Integer getDistance() {
        return distance;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void setDistance(Integer newDistance) {
        distance = newDistance;
    }
}