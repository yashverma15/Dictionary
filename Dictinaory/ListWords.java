import java.awt.Container;
import java.util.TreeMap;
import java.util.Vector;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class ListWords extends JFrame{
    public ListWords(){
        super("List of Words");
        Container c = getContentPane();
        Vector headings = new Vector<>();
        headings.add("Word");
        headings.add("Meaning");

        Vector rows = new Vector<>();
        TreeMap<String,String> words = Dictionary.getWords();
        for (String word : words.keySet()) {
            Vector row = new Vector<>();
            row.add(word);
            row.add(words.get(word));
            rows.add(row);
        }
        JTable wordstable = new JTable(rows,headings);
        JScrollPane sp = new JScrollPane(wordstable,20,30);
        c.add(sp);
        pack();
    }
}
