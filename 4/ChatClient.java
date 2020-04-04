import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ChatClient extends JFrame {
    public ChatClient(){
        setTitle("Chat");
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setBounds(300, 300, 300, 300);
        setLayout(new BorderLayout());

        JPanel top = new JPanel();
        top.setPreferredSize(new Dimension(300, 180));
        top.setLayout(new BorderLayout());
        add(top, BorderLayout.PAGE_START);

        JPanel bottom = new JPanel();
        bottom.setLayout(new BorderLayout());
        add(bottom, BorderLayout.CENTER);


        JTextArea textArea = new JTextArea();
        textArea.setEditable(false);
        JScrollPane scroll = new JScrollPane(textArea);
        top.add(scroll);


        JTextField textField = new JTextField();
        textField.setPreferredSize(new Dimension(300, 25));
        bottom.add(textField, BorderLayout.PAGE_START);

        textField.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (!textField.getText().equals("")){
                    textArea.setText(textArea.getText() + "\n You: " + textField.getText());
                    textField.setText("");
                }
            }
        });


        JButton button = new JButton("Send");
        bottom.add(button, BorderLayout.CENTER);

        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (!textField.getText().equals("")){
                    textArea.setText(textArea.getText() + "\n You: " + textField.getText());
                    textField.setText("");
                }
            }
        });

        setVisible(true);
    }
}
