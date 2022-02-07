package document;

import java.util.ArrayList;
import java.util.List;

import document.element.TextElement;

public class Document {
  
  private List<TextElement> content;
  
  public Document() {
    content = new ArrayList<>();
  }

  public void add(TextElement e) {
    content.add(e);
  }


  //returns the number of words in the document.
  public int countWords(){
    WordCountVisitor wordCountVisitor = new WordCountVisitor();
    int count = 0;
    for(TextElement element: content){
      count = count + element.accept(wordCountVisitor);
    }
    return count;
  }

  //String visitors should accumulate their result and
  //return it when toString is called on the visitor
  public <R> String toText(DocumentVisitor<R> visitor) {
    StringBuilder toText = new StringBuilder();
    for(TextElement element: content){
      toText.append(element.accept(visitor));
    }
    return toText.toString().trim();
  }
}
