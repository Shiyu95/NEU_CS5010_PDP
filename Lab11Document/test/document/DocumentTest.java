package document;

import document.element.*;

import static org.junit.Assert.*;

public class DocumentTest {
    private Document document;
    private Document document1;


    private BasicStringVisitor basicStringVisitor;
    private HtmlStringVisitor htmlStringVisitor;
    private MarkdownStringVisitor markDownStringVisitor;



    @org.junit.Test
    public void countWords() {
        Heading heading = new Heading("Harry Potter", 1);

        BasicText basic = new BasicText("Harry Potter is a series of seven fantasy" +
                " novels written by British author J. K. Rowling");

        BoldText bold = new BoldText("I like apple");

        HyperText hyperText = new HyperText("Harry Potter",
                "https://en.wikipedia.org/wiki/Harry_Potter");

        ItalicText italic = new ItalicText("I like cherry");

        Paragraph paragraph = new Paragraph();
        paragraph.add(heading);
        paragraph.add(basic);
        paragraph.add(italic);
        paragraph.add(hyperText);

        //document
        document = new Document();
        document.add(heading);
        document.add(paragraph);
        document.add(bold);
        document.add(hyperText);
        document.add(italic);
        assertEquals(33, document.countWords());
    }

    @org.junit.Test
    public void toText() {
        Heading heading = new Heading("Harry Potter", 1);

        BasicText basic = new BasicText("Harry Potter is a series of seven fantasy" +
                " novels written by British author J. K. Rowling.");
        ItalicText italic = new ItalicText("I like cherry.");

        //visitor
        basicStringVisitor = new BasicStringVisitor();
        htmlStringVisitor = new HtmlStringVisitor();
        markDownStringVisitor = new MarkdownStringVisitor();


        Paragraph paragraph = new Paragraph();
        paragraph.add(heading);
        paragraph.add(italic);


        //document
        document = new Document();
        document.add(heading);
        document.add(paragraph);
        document.add(basic);



        // basic
        assertEquals("Harry Potter Harry Potter I like cherry. " +
                "Harry Potter is a series of seven fantasy novels written by British author J. K. Rowling.", document.toText(basicStringVisitor));

        // html
        assertEquals("<h1>Harry Potter</h1>\n"+
                "<p><h1>Harry Potter</h1>\n" + "<i>I like cherry.</i>\n</p>\n"
                +"Harry Potter is a series of seven fantasy novels written by British author J. K. Rowling.", document.toText(htmlStringVisitor));

//        //markDown
//        assertEquals("# Harry Potter\n"+
//                "\n# Harry Potter\n" + "*I like cherry.*\n\n"
//                +"Harry Potter is a series of seven fantasy novels written by British author J. K. Rowling.\n", document.toText(markDownStringVisitor));




//        Heading heading1 = new Heading("<# Top Level Heading[\n" +
//                "Just text is an important part of every document.]>", 1);
//        Heading heading2 = new Heading("<# Top Level Heading[Just text is an important part of every document.\n" +
//                "]>",1);



        Heading heading1 = new Heading("Top Level Heading[]", 1);
        BasicText basic1 = new BasicText("Just text is an important part of every document.");
        Paragraph paragraph1 = new Paragraph();
        paragraph1.add(heading1);

        //document1.add(heading1);

//        assertEquals("# <Top Level Heading[]>\n", document1.toText(markDownStringVisitor));
//        assertEquals("<Top Level Heading[]> ", document1.toText(basicStringVisitor));

    }



}