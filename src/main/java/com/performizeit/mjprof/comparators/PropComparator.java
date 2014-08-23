/*
       This file is part of mjprof.

        mjprof is free software: you can redistribute it and/or modify
        it under the terms of the GNU General Public License as published by
        the Free Software Foundation, either version 3 of the License, or
        (at your option) any later version.

        mjprof is distributed in the hope that it will be useful,
        but WITHOUT ANY WARRANTY; without even the implied warranty of
        MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
        GNU General Public License for more details.

        You should have received a copy of the GNU General Public License
        along with mjprof.  If not, see <http://www.gnu.org/licenses/>.
*/
package com.performizeit.mjprof.comparators;

import com.performizeit.mjprof.api.ThreadInfoComparator;
import com.performizeit.mjprof.api.Plugin;
import com.performizeit.mjprof.api.Param;
import com.performizeit.mjprof.parser.ThreadInfo;

@Plugin(name = "sort", params = {@Param("attr") },description="Sorts based on an attribute")
public class PropComparator extends SortMapper{
    private final String prop;

    public PropComparator(String prop) {
        this.prop = prop;
    }
    @Override
    public int compare(ThreadInfo o1, ThreadInfo o2) {
        return ((Comparable)o1.getVal(prop)) .compareTo(o2.getVal(prop));

    }
}
