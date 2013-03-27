package triv.client.model.strategy.interfaces;

/**
 * Defines the methods required to use regular expressions to
 * find symbols from the source code.
 * @author Graeme Clark
 *
 */
public interface PatternStrategy
{
	
	/**
	 * @param source
	 */
	public void setMatchers(String source);
	
	/**
	 * @param pattern
	 */
	public void setIntegerPattern(String pattern);
	
	/**
	 * @param pattern
	 */
	public void setIdentifierPattern(String pattern);
	
	/**
	 * Checks if a match is found for an integer.
	 * @return
	 */
	public Boolean hasNum();
	
	/**Checks if a match is found for an identifier.
	 * @return
	 */
	public Boolean hasId();
	
	/**Checks if a match is found for a quote.
	 * @return
	 */
	public Boolean hasDQuote();
	
	/**Checks if a match is found for a new line.
	 * @return
	 */
	public Boolean hasNewLine();
	
	/**Checks if a match is found for a quote anywhere else in
     * the source code.
	 * @return
	 */
	public Boolean findDQuote();
	
	/** Get the index of the next quote.
	 * @return
	 */
	public Integer closingDQuoteIndex();
	
	/** Get the index of the end of the matching identifier.
	 * @return
	 */
	public Integer idEnd();
	
	/**
	 *  Get the index of the end of the matching integer.
	 * @return
	 */
	public Integer numEnd();
	
	/** Return the matching identifier.
	 * @return
	 */
	public String matchingId();
	
	/**Return the matching integer.
	 * @return
	 */
	public String matchingNum();

}