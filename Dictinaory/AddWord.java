import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
// import java.util.Dictionary;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.JTextPane;
import java.awt.Container;
import java.awt.GridBagLayout;
// import static java.util.Dictionary.*;

public class AddWord extends JFrame{
    private JTextField tfWord;
    private JTextArea taMeaning;
    private JButton btnAdd;

    public AddWord(){
        super("Add Word");

        GridBagLayout gbl = new GridBagLayout();
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets=new Insets(5, 5, 5, 5);
        gbc.fill= 1;

        this.tfWord = new JTextField(30);
        this.taMeaning = new JTextArea();
        this.btnAdd = new JButton("Add Word");
        this.btnAdd.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e){
                if((AddWord.this.tfWord.getText().length()>0)&&(AddWord.this.taMeaning.getText().length()>0)){
                    Dictionary.addWord(AddWord.this.tfWord.getText(),AddWord.this.taMeaning.getText());
                    AddWord.this.tfWord.setText("");
                    AddWord.this.taMeaning.setText("");
                    AddWord.this.tfWord.requestFocus();
                    JOptionPane.showMessageDialog(AddWord.this, "Added word successfully","Add Word",1);
                }else{
                    JOptionPane.showMessageDialog(AddWord.this, "Please enter word and meaning!","Add word",0);
                }
            }
        });
        Container c = getContentPane();
        c.setLayout(gbl);

        gbc.anchor = 13;
        c.add(new JLabel("Enter word"),gbc);
        gbc.anchor=17;
        c.add(this.tfWord);

        gbc.gridx = 0;
        gbc.anchor = 13;
        c.add(new JLabel("Enter Meaning: "),gbc);
        gbc.anchor =17;
        gbc.gridx = 1;
        gbc.gridwidth = 2;
        gbc.gridheight = 2;
        this.taMeaning.setRows(3);
        this.taMeaning.setColumns(30);
        JScrollPane sp = new JScrollPane(this.taMeaning,20,30);
        c.add(sp, gbc);

        gbc.gridx = 0;
        gbc.gridwidth = 3;
        gbc.anchor = 10;
        gbc.fill = 0;
        c.add(this.btnAdd, gbc);

        pack();
    }
    public static void main(String[] args) {
        AddWord w = new AddWord();
        w.setVisible(true);
    }
}