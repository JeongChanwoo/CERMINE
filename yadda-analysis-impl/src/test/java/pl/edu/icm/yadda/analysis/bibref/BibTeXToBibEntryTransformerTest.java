package pl.edu.icm.yadda.analysis.bibref;

import java.io.StringReader;
import java.io.Reader;
import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import pl.edu.icm.yadda.metadata.transformers.TransformationException;

/**
 *
 * @author estocka
 */
public class BibTeXToBibEntryTransformerTest {
BibTeXToBibEntryTransformer btbt;
String bibtexString;
    public BibTeXToBibEntryTransformerTest() {
    }

    @BeforeClass
    public static void setUpClass() throws Exception {
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
    }

    @Before
    public void setUp() {
        btbt = new BibTeXToBibEntryTransformer();
        bibtexString = "@book{Twain1876,\n"
                + "\tauthor = {Twain, Mark},\n"
                + "\ttitle = {The Adventures of Tom Sawyer},\n"
                + "\tyear = {1876},\n"
                + "}\n\n"
                + "@book{Smith1876,\n"
                + "\tauthor = {Smith, John},\n"
                + "\ttitle = {Title\\_including \\{ curly\\_braces\\} },\n"
                + "\tyear = {1876},\n"
                + "}\n\n";
    }

    @After
    public void tearDown() {
    }

   @Test
   public void readerToStringTest() {
   Reader reader = new StringReader(bibtexString);
      
        assertEquals("@book{Twain1876,\n"
                + "\tauthor = {Twain, Mark},\n"
                + "\ttitle = {The Adventures of Tom Sawyer},\n"
                + "\tyear = {1876},\n"
                + "}\n\n"
                + "@book{Smith1876,\n"
                + "\tauthor = {Smith, John},\n"
                + "\ttitle = {Title\\_including \\{ curly\\_braces\\} },\n"
                + "\tyear = {1876},\n"
                + "}\n\n",btbt.readerToString(reader));
   }
   @Test
   public void readTest() throws TransformationException{
        List<BibEntry> bibEntryList = btbt.read(bibtexString);
      
        assertEquals("book",bibEntryList.get(0).getType());
        assertEquals("Twain, Mark",bibEntryList.get(0).getFirstFieldValue(BibEntry.FIELD_AUTHOR));
        assertEquals("The Adventures of Tom Sawyer",bibEntryList.get(0).getFirstFieldValue(BibEntry.FIELD_TITLE));
        assertEquals("1876",bibEntryList.get(0).getFirstFieldValue(BibEntry.FIELD_YEAR));
   
        assertEquals("book",bibEntryList.get(1).getType());
        assertEquals("Smith, John",bibEntryList.get(1).getFirstFieldValue(BibEntry.FIELD_AUTHOR));
        assertEquals("Title_including { curly_braces} ",bibEntryList.get(1).getFirstFieldValue(BibEntry.FIELD_TITLE));
        assertEquals("1876",bibEntryList.get(1).getFirstFieldValue(BibEntry.FIELD_YEAR));

   }
}