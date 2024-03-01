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

package org.cceval.grid.neighborhood;

import org.cceval.grid.neighborhood.regular.square.FourConnected;
import org.cceval.grid.neighborhood.regular.square.HeightConnected;
import org.cceval.grid.neighborhood.regular.square.KWideFourConnected;
import org.cceval.grid.neighborhood.regular.square.partial.PartialFourConnected;
import org.cceval.grid.neighborhood.regular.square.partial.PartialHeightConnected;
import org.cceval.grid.neighborhood.regular.square.partial.PartialTwoWideFourConnected;
import org.cceval.grid.neighborhood.regular.square.partial.PartialTwoWideHeightConnected;
import org.cceval.grid.neighborhood.regular.square.partial.grouped.PartialGroupedAggFourConnected;
import org.cceval.grid.neighborhood.regular.square.partial.grouped.PartialGroupedFourConnected;
import org.cceval.grid.neighborhood.regular.square.partial.grouped.PartialGroupedKWideFourConnected;
import org.cceval.grid.neighborhood.regular.square.partial.grouped.PartialGroupedTwoWideFourConnected;

/**
 * Utility class for accessing neighborhoods.
 */
public class Neighborhoods {

    public final static FourConnected FOUR_CONNECTED = new FourConnected();
    public final static HeightConnected HEIGHT_CONNECTED = new HeightConnected();
    public final static PartialFourConnected PARTIAL_FOUR_CONNECTED = new PartialFourConnected();
    public final static PartialHeightConnected PARTIAL_HEIGHT_CONNECTED = new PartialHeightConnected();
    public final static PartialTwoWideFourConnected PARTIAL_TWO_WIDE_FOUR_CONNECTED = new PartialTwoWideFourConnected();
    public final static PartialTwoWideHeightConnected PARTIAL_TWO_WIDE_HEIGHT_CONNECTED = new PartialTwoWideHeightConnected();
    public final static PartialGroupedFourConnected PARTIAL_GROUPED_FOUR_CONNECTED = new PartialGroupedFourConnected();
    public final static PartialGroupedTwoWideFourConnected PARTIAL_GROUPED_TWO_WIDE_FOUR_CONNECTED = new PartialGroupedTwoWideFourConnected();
    public final static PartialGroupedAggFourConnected PARTIAL_GROUPED_AGG_FOUR_CONNECTED = new PartialGroupedAggFourConnected();

    public final static KWideFourConnected K_WIDE_FOUR_CONNECTED(int k) {
        return new KWideFourConnected(k);
    }

    public final static PartialGroupedKWideFourConnected PARTIAL_GROUPED_K_WIDE_FOUR_CONNECTED(int k) {
        return new PartialGroupedKWideFourConnected(k);
    }
}
