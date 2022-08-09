/*
 * MIT License Copyright (c) 2022 unified-ast
 * https://github.com/unified-ast/unified-ast/blob/master/LICENSE.txt
 */

package org.uast.uast.generated.tree.java.rules;

import java.util.Collections;
import java.util.List;
import java.util.Map;
import org.uast.uast.base.Matcher;
import org.uast.uast.base.Node;

/**
 * Checks if the node matches some structure, and extracts the data and children.
 *
 * @since 1.0
 */
public final class Matcher203 implements Matcher {
    /**
     * The instance.
     */
    public static final Matcher INSTANCE = new Matcher203();

    /**
     * Expected node type.
     */
    private static final String EXPECTED_TYPE = "ClassOrInterfaceDeclaration";

    /**
     * Expected number of child nodes.
     */
    private static final int EXPECTED_COUNT = 3;

    /**
     * The number of the first hole.
     */
    private static final int FIRST_HOLE_ID = 2;

    /**
     * The index of the first child.
     */
    private static final int FIRST_CHILD_ID = 1;

    /**
     * Constructor.
     */
    private Matcher203() {
    }

    @Override
    public boolean match(final Node node,
        final Map<Integer, List<Node>> children,
        final Map<Integer, String> data) {
        final boolean result = node.belongsToGroup(Matcher203.EXPECTED_TYPE)
            && node.getChildCount() == Matcher203.EXPECTED_COUNT
            && Matcher204.INSTANCE.match(node.getChild(0), children, data)
            && Matcher205.INSTANCE.match(node.getChild(2), children, data);
        if (result) {
            children.put(
                Matcher203.FIRST_HOLE_ID,
                Collections.singletonList(node.getChild(Matcher203.FIRST_CHILD_ID))
            );
        }
        return result;
    }
}
