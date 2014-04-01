package com.performizeit.mjstack.mappers;

import com.performizeit.mjstack.api.JStackMapper;
import com.performizeit.mjstack.parser.JStackMetadataStack;
import com.performizeit.mjstack.parser.JStackStack;

import java.util.ArrayList;
import java.util.HashMap;

public abstract class StackFrameCNC implements JStackMapper {
    protected final String expr;
    protected boolean reverse = false;

    public StackFrameCNC(String expr,boolean reverse) {
        this.expr = expr;
        this.reverse = reverse;
    }

    @Override
    public JStackMetadataStack map(JStackMetadataStack stck) {
        HashMap<String,Object> mtd = stck.cloneMetaData();
        JStackStack jss = (JStackStack) mtd.get("stack");
        String[] stackFrames = jss.getStackFrames();
        ArrayList<String> partial = new ArrayList<String>();
        for (String sf:stackFrames) {
            if (reverse) {
                if (!sf.contains(expr)  ) partial.add(sf);
            }else {
                if (sf.contains(expr)  ) partial.add(sf);
            }
        }
        jss.setStackFrames(partial);

        return      new JStackMetadataStack(mtd);
    }
}