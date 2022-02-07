package document;

import document.element.*;

import java.util.List;

public class HtmlStringVisitor implements DocumentVisitor<String>{
    @Override
    public String visitBasicText(BasicText current) {
        return current.getText().trim() + "\n";
    }

    @Override
    public String visitBoldText(BoldText current) {
        return "<b>" + current.getText().trim() + "</b>\n";
    }

    @Override
    public String visitHeading(Heading current) {
        return "<h" + current.getLevel() + ">" + current.getText().trim() + "</h" + current.getLevel() + ">" + "\n";
    }

    @Override
    public String visitHyperText(HyperText current) {
        return "<a href=\"" + current.getUrl().trim() + "\">" + current.getText().trim() + "</a>\n";
    }

    @Override
    public String visitItalicText(ItalicText current) {
        return "<i>" + current.getText().trim() + "</i>\n";
    }

    @Override
    public String visitParagraph(Paragraph current) {
        StringBuilder text = new StringBuilder();
        text.append("<p>");
        List<BasicText> list = current.getContent();
        for (BasicText b : list ) {
            text.append(b.accept(this));
        }
        text.append("</p>\n");
        return text.toString();
    }
}
