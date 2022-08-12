/*
 * MIT License Copyright (c) 2022 unified-ast
 * https://github.com/unified-ast/unified-ast/blob/master/LICENSE.txt
 */

package org.uast.uast.generated.tree.js.rules;

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
public final class Matcher417 implements Matcher {
    /**
     * The instance.
     */
    public static final Matcher INSTANCE = new Matcher417();

    /**
     * Expected node type.
     */
    private static final String EXPECTED_TYPE = "methodDefinition";

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
     * The number of the second hole.
     */
    private static final int SECOND_HOLE_ID = 3;

    /**
     * The index of the second child.
     */
    private static final int SECOND_CHILD_ID = 2;

    /**
     * Constructor.
     */
    private Matcher417() {
    }

    @Override
    public boolean match(final Node node,
        final Map<Integer, List<Node>> children,
        final Map<Integer, String> data) {
        final boolean result = node.belongsToGroup(Matcher417.EXPECTED_TYPE)
            && node.getChildCount() == Matcher417.EXPECTED_COUNT
            && Matcher418.INSTANCE.match(node.getChild(0), children, data);
        if (result) {
            children.put(
                Matcher417.FIRST_HOLE_ID,
                Collections.singletonList(node.getChild(Matcher417.FIRST_CHILD_ID))
            );
            children.put(
                Matcher417.SECOND_HOLE_ID,
                Collections.singletonList(node.getChild(Matcher417.SECOND_CHILD_ID))
            );
        }
        return result;
    }
}
