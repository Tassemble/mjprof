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

package com.performizeit.mjstack.mergers;

import com.performizeit.mjstack.api.JStackTerminal;
import com.performizeit.mjstack.api.Plugin;
import com.performizeit.mjstack.model.Profile;
import com.performizeit.mjstack.parser.JStackDump;
import com.performizeit.mjstack.parser.JStackProps;
import com.performizeit.mjstack.parser.ThreadInfo;


@Plugin(name="tree", paramTypes={},description="combine all stack traces ")
public class StackTreeMerger implements JStackTerminal {
    Profile st = new Profile();
    public void addStackDump(JStackDump jsd) {
        for (ThreadInfo mss : jsd.getStacks()  ) {
            st.addMulti((Profile) mss.getVal(JStackProps.STACK));      // System.out.println();
        }
    }

    @Override
    public String toString() {
        return st.toString();
    }
}
