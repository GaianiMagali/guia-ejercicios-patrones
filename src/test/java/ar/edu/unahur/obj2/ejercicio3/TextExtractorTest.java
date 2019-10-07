package ar.edu.unahur.obj2.ejercicio3;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.testng.Assert.*;

public class TextExtractorTest {

    Tag tag;
    StringNode stringNode;
    LinkTag linkTag;
    Parser parser;
    TextExtractor textExtractor;
    TagExtractor tagExtractor;


    @BeforeMethod
    public void setUp() {
        tag = new Tag("texto1");
        stringNode = new StringNode("texto2");
        linkTag = new LinkTag("texto3");
        parser = new Parser(Stream.of(tag, stringNode, linkTag).collect(Collectors.toList()));

        tagExtractor = new TagExtractor();
    }

    @Test
    public void testExtractText() {
        Map<String, NodeExtractor> extractors1 = new HashMap<>();
        extractors1.put("texto1",tagExtractor);
        textExtractor = new TextExtractor(extractors1);
        String resultado = textExtractor.extractText(parser);
        String esperado = "texto1" + "texto2" + "texto3";
        assertEquals(resultado, esperado);
    }
}