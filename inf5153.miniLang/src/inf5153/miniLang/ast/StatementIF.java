package inf5153.miniLang.ast;

/**
 * 
 * @author elhachemi Alikacem
 */
public class StatementIF  extends Statement {
	private ExpressionComparaison condition ; 
	private Block blockThen ; 
	private Block blockElse ;
	
	
	public StatementIF(ExpressionComparaison condition, Block blockThen, Block blockElse) {
		super();
		this.condition = condition;
		this.blockThen = blockThen;
		this.blockElse = blockElse;
	}
	
	public StatementIF(ExpressionComparaison condition, Block blockThen) {
		this(condition, blockThen, null) ; 
	}

	public ExpressionComparaison getCondition() {
		return condition;
	}

	public Block getBlockThen() {
		return blockThen;
	}

	public Block getBlockElse() {
		return blockElse;
	}
}
