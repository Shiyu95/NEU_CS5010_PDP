package document;

import document.element.*;

import java.util.List;

public class MarkdownStringVisitor implements DocumentVisitor<String> {
    @Override
    public String visitBasicText(BasicText current) {
        return current.getText().trim() + "\n";
    }

    @Override
    public String visitBoldText(BoldText current) {
        return "**" + current.getText().trim() + "**\n";
    }

    @Override
    public String visitHeading(Heading current) {
        StringBuilder heading = new StringBuilder();
        switch (current.getLevel()) {
            case 1: heading.append("# ");
                break;
            case 2: heading.append("## ");
                break;
            default: heading.append("### ");
                break;
        }
        return heading.append(current.getText().trim()).append("\n").toString();
    }

    @Override
    public String visitHyperText(HyperText current) {
        return "[" + current.getText().trim() + "](" + current.getUrl() + ")\n";
    }

    @Override
    public String visitItalicText(ItalicText current) {
        return "*" + current.getText().trim() + "*\n";
    }

    @Override
    public String visitParagraph(Paragraph current) {
        StringBuilder text = new StringBuilder();
        text.append("\n");
        List<BasicText> list = current.getContent();
        for (BasicText b : list ) {
            text.append(b.accept(this));
        }
        text.append("\n");
        return text.toString();
    }
}
