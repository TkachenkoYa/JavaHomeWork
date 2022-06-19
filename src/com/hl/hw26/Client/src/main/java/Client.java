import lombok.Data;
import lombok.RequiredArgsConstructor;

import javax.swing.*;
import java.awt.*;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

@Data
@RequiredArgsConstructor
public class Client extends JFrame {
    private static final String SERVER_HOST = "localhost";
    private static final int SERVER_PORT = 8080;
    private Socket clientSocket;
    private Scanner inMessage;
    private PrintWriter outMessage;
    private final JTextField jtfMessage;
    private final JTextField jtfName;
    private final JTextArea jtaTextAreaMessage;
    private String clientName = "";

    public Client() {
        try {
            clientSocket = new Socket(SERVER_HOST, SERVER_PORT);
            inMessage = new Scanner(clientSocket.getInputStream());
            outMessage = new PrintWriter(clientSocket.getOutputStream());
        } catch (IOException e) {
            e.printStackTrace();
        }
        setBounds(100, 100, 500, 500);
        setTitle("Chat");
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        jtaTextAreaMessage = new JTextArea();
        jtaTextAreaMessage.setEditable(false);
        jtaTextAreaMessage.setLineWrap(true);
        JScrollPane jsp = new JScrollPane(jtaTextAreaMessage);
        add(jsp, BorderLayout.CENTER);
        JPanel bottomPanel = new JPanel(new BorderLayout());
        add(bottomPanel, BorderLayout.SOUTH);
        JButton jbSendMessage = new JButton("Отправить");
        bottomPanel.add(jbSendMessage, BorderLayout.EAST);
        jtfMessage = new JTextField("Введите ваше сообщение: ");
        bottomPanel.add(jtfMessage, BorderLayout.CENTER);
        jtfName = new JTextField("Введите ваше имя: ");
        bottomPanel.add(jtfName, BorderLayout.WEST);
        jbSendMessage.addActionListener(e -> {
            if (!jtfMessage.getText().trim().isEmpty() && !jtfName.getText().trim().isEmpty()) {
                clientName = jtfName.getText();
                sendMsg();
                jtfMessage.grabFocus();
            }
        });
        jtfMessage.addFocusListener(new FocusAdapter() {
            @Override
            public void focusGained(FocusEvent e) {
                jtfMessage.setText("");
            }
        });
        jtfName.addFocusListener(new FocusAdapter() {
            @Override
            public void focusGained(FocusEvent e) {
                jtfName.setText("");
            }
        });
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    while (true) {
                        if (inMessage.hasNext()) {
                            String inMes = inMessage.nextLine();
                            // String clientsInChat = "Клиентов в чате = ";
                            if (inMes.contains("-file")) {
                                ClientFileUploader clientFileUploader = new ClientFileUploader();
                                clientFileUploader.uploadFile(inMes);
                            } else {
                                jtaTextAreaMessage.append(inMes);
                                jtaTextAreaMessage.append("\n");
                            }
                        }
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }).start();
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                super.windowClosing(e);
                try {
                    if (!clientName.isEmpty() && !clientName.equals("Введите ваше имя: ") || inMessage.equals("-exit"))
                        outMessage.println(clientName + " вышел из чата!");
                    else
                        outMessage.println("User left the chat without introducing himself!");
                    outMessage.flush();
                    outMessage.close();
                    inMessage.close();
                    clientSocket.close();
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
            }
        });
        setVisible(true);
    }

    public void sendMsg() {
        String messageStr = jtfName.getText() + ": " + jtfMessage.getText();
        getOutMessage().println(messageStr);
        getOutMessage().flush();
        getJtfMessage().setText("");
    }
}