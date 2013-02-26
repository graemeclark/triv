package triv.client.model.strategy.pattern;

import com.google.gwt.regexp.shared.MatchResult;
import com.google.gwt.regexp.shared.RegExp;

import triv.client.model.strategy.interfaces.*;

public class TRIVPatternStrategy implements PatternStrategy
{
	
	protected static RegExp identifier = RegExp.compile("[a-zA-Z][a-zA-Z0-9]*");
	protected static RegExp numeric    = RegExp.compile("\\d+");
	protected static RegExp dQuote     = RegExp.compile("\"");
	protected static RegExp newline    = RegExp.compile("\n");
	
	protected MatchResult matchId, matchNum, matchDQuote, matchNewLine;
	
	String s;
	
	@Override
	public void setMatchers(String source)
	{
  	
  	  s = source;
		
	}

	@Override
	public void setIntegerPattern(String pattern)
	{
		
		numeric = RegExp.compile(pattern);
		
	}

	@Override
	public void setIdentifierPattern(String pattern)
	{
		
		identifier = RegExp.compile(pattern);
		
	}

	@Override
	public Boolean hasNum()
	{
		
		matchNum = numeric.exec(s);
		return matchNum != null && s.indexOf(matchNum.getGroup(0)) == 0;
		
	}

	@Override
	public Boolean hasId()
	{

		matchId = identifier.exec(s);
		return matchId != null && s.indexOf(matchId.getGroup(0)) == 0;
		
	}

	@Override
	public Boolean hasDQuote()
	{
		
		matchDQuote = dQuote.exec(s);
		return matchDQuote != null && s.indexOf(matchDQuote.getGroup(0)) == 0;
		
	}

	@Override
	public Boolean hasNewLine()
	{
		
		return newline.test(s); // && matchNewLine.start() != -1;
		
	}

	@Override
	public Integer closingDQuoteIndex()
	{
		
		return dQuote.getLastIndex();
		
	}

	@Override
	public Integer idEnd()
	{
		
		return matchId.getGroup(0).length();
		
	}

	@Override
	public Integer numEnd()
	{
		
		return matchNum.getGroup(0).length();
		
	}

	@Override
	public String matchingId()
	{
		
		return matchId.getGroup(0);
		
	}

	@Override
	public String matchingNum()
	{
		
		return matchNum.getGroup(0);
		
	}

	@Override
	public Boolean findDQuote()
	{
		
		return dQuote.test(s);
		
	}

}
