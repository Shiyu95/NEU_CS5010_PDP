package document.element;

import document.DocumentVisitor;

/**
 * Interface that represents an element in our document.
 */
public interface TextElement {

  /**
   * Returns the text contained within the element.
   * 
   * @return the text
   */
  public String getText();

  //Making the elements of the document "visitable" by the following method the document elements
  public <R> R accept(DocumentVisitor<R> visitor);



}
