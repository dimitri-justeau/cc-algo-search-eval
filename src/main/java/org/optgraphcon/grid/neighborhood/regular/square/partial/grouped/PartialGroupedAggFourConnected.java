/*
 * Copyright (c) 2021, Dimitri Justeau-Allaire
 *
 * Institut Agronomique neo-Caledonien (IAC), 98800 Noumea, New Caledonia
 * AMAP, Univ Montpellier, CIRAD, CNRS, INRA, IRD, Montpellier, France
 *
 * This file is part of flsgen.
 *
 * flsgen is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * flsgen is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with flsgen.  If not, see <https://www.gnu.org/licenses/>.
 */

package org.optgraphcon.grid.neighborhood.regular.square.partial.grouped;

import org.optgraphcon.grid.neighborhood.INeighborhood;
import org.optgraphcon.grid.neighborhood.Neighborhoods;
import org.optgraphcon.grid.regular.square.PartialRegularGroupedAggGrid;
import org.chocosolver.solver.Model;
import org.chocosolver.util.objects.graphs.GraphFactory;
import org.chocosolver.util.objects.graphs.UndirectedGraph;
import org.chocosolver.util.objects.setDataStructures.ISet;
import org.chocosolver.util.objects.setDataStructures.SetFactory;
import org.chocosolver.util.objects.setDataStructures.SetType;

/**
 * The k-wide four-connected neighborhood in a partial grouped regular square grid
 */
public class PartialGroupedAggFourConnected<T extends PartialRegularGroupedAggGrid> implements INeighborhood<T> {

    public int[] getNeighbors(T grid, int groupedIdx) {
        if (groupedIdx < grid.getNbGroups()) {
            ISet neighs = SetFactory.makeRangeSet();
            for (int partialIdx : grid.getGroup(groupedIdx)) {
                for (int n : Neighborhoods.PARTIAL_FOUR_CONNECTED.getNeighbors(grid, partialIdx)) {
                    if (grid.getGroupIndexFromPartialIndex(n) != groupedIdx) {
                        neighs.add(grid.getGroupIndexFromPartialIndex(n));
                    }
                }
            }
            return neighs.toArray();
        } else {
            ISet neighbors = SetFactory.makeRangeSet();
            for (int partialIxd : grid.getAggregatePartialIndices(groupedIdx)) {
                for (int n : Neighborhoods.PARTIAL_FOUR_CONNECTED.getNeighbors(grid, partialIxd)) {
                    if (grid.getGroupIndexFromPartialIndex(n) != groupedIdx) {
                        neighbors.add(grid.getGroupIndexFromPartialIndex(n));
                    }
                }
            }
            return neighbors.toArray();
        }
    }

    @Override
    public UndirectedGraph getPartialGraph(T grid, Model model, int[] cells, SetType nodeSetType, SetType edgeSetType) {
        int nbCells = grid.getNbCells();
        UndirectedGraph partialGraph = GraphFactory.makeStoredUndirectedGraph(model, nbCells, nodeSetType, edgeSetType);
        for (int i : cells) {
            partialGraph.addNode(i);
        }
        for (int i : cells) {
            if (i >= grid.getNbGroups()) {
                int[] neighbors = getNeighbors(grid, i);
                for (int ii : neighbors) {
                    if (partialGraph.getNodes().contains(ii)) {
                        partialGraph.addEdge(i, ii);
                    }
                }
            }
        }
        return partialGraph;
    }

    @Override
    public UndirectedGraph getPartialGraph(T grid, Model model, int[] cells, SetType setType) {
        return getPartialGraph(grid, model, cells, setType, setType);
    }

}
