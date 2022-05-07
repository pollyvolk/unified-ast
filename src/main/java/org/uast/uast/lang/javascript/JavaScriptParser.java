/*
 * MIT License Copyright (c) 2022 unified-ast
 * https://github.com/unified-ast/unified-ast/blob/master/LICENSE.txt
 */
package org.uast.uast.lang.javascript;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.uast.uast.base.EmptyTree;
import org.uast.uast.base.Node;
import org.uast.uast.generated.antlr4.JavaScriptLexer;
import org.uast.uast.generated.tree.js.JsAdapter;
import org.uast.uast.lang.AntlrToNodeConverter;

/**
 * Parses JavaScript source code to unified syntax tree.
 *
 * @since 1.0
 */
public class JavaScriptParser {
    /**
     * The source code.
     */
    private final String source;

    /**
     * Constructor.
     * @param source Source string.
     */
    public JavaScriptParser(final String source) {
        this.source = source;
    }

    /**
     * Parses Java source code to unified syntax tree.
     * @return Root node
     */
    public Node parse() {
        final InputStream input = new ByteArrayInputStream(
            this.source.getBytes(StandardCharsets.UTF_8)
        );
        CharStream stream = null;
        Node result;
        try {
            stream = CharStreams.fromStream(input, StandardCharsets.UTF_8);
            final JavaScriptLexer lexer = new JavaScriptLexer(stream);
            final CommonTokenStream tokens = new CommonTokenStream(lexer);
            final org.uast.uast.generated.antlr4.JavaScriptParser parser =
                new org.uast.uast.generated.antlr4.JavaScriptParser(tokens);
            final AntlrToNodeConverter converter = new AntlrToNodeConverter(parser);
            final Node draft = converter.convert(parser.program());
            result = JsAdapter.INSTANCE.convert(draft);
        } catch (final IOException exception) {
            result = EmptyTree.INSTANCE;
        }
        return result;
    }
}
