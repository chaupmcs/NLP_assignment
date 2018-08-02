// Generated from Student.g4 by ANTLR 4.4
import org.antlr.v4.runtime.misc.NotNull;
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link StudentParser}.
 */
public interface StudentListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link StudentParser#r}.
	 * @param ctx the parse tree
	 */
	void enterR(@NotNull StudentParser.RContext ctx);
	/**
	 * Exit a parse tree produced by {@link StudentParser#r}.
	 * @param ctx the parse tree
	 */
	void exitR(@NotNull StudentParser.RContext ctx);
	/**
	 * Enter a parse tree produced by {@link StudentParser#whQUERY}.
	 * @param ctx the parse tree
	 */
	void enterWhQUERY(@NotNull StudentParser.WhQUERYContext ctx);
	/**
	 * Exit a parse tree produced by {@link StudentParser#whQUERY}.
	 * @param ctx the parse tree
	 */
	void exitWhQUERY(@NotNull StudentParser.WhQUERYContext ctx);
}