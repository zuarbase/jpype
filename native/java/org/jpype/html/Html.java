package org.jpype.html;

import java.util.Arrays;
import java.util.HashSet;
import org.w3c.dom.Document;

public class Html
{

  public final static HashSet<String> VOID_ELEMENTS = new HashSet<>();
  public final static HashSet<String> OPTIONAL_ELEMENTS = new HashSet<>();

  static
  {
    VOID_ELEMENTS.addAll(Arrays.asList(
            "area", "base", "br", "col", "command", "embed", "hr", "img",
            "input", "keygen", "link", "meta", "param", "source", "track", "wbr"));
    OPTIONAL_ELEMENTS.addAll(Arrays.asList("html", "head", "body", "p", "dt",
            "dd", "li", "option", "thead", "th", "tbody", "tr", "td", "tfoot", "colgroup"));

  }

  private static class HtmlParser extends Parser<Document>
  {

    HtmlHandler handler = new HtmlTreeHandler();
    HtmlGrammar grammar = new HtmlGrammar(handler);
    public HtmlParser()
    {
      super();
      setGrammar(grammar);
    }
  }

  public static Parser<Document> newParser()
  {
    return new HtmlParser();
  }

}
