import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class LotoFacilInterface extends JFrame {
    private JLabel titleLabel;
    private JButton apostar0a100Button, apostarAaZButton, apostarParOuImparButton, sairButton;
    private JTextArea resultTextArea;

    public LotoFacilInterface() {
        setTitle("LOTOFÁCIL");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new FlowLayout());

        titleLabel = new JLabel("LOTOFÁCIL");
        titleLabel.setFont(new Font("Arial", Font.BOLD, 20));
        add(titleLabel);

        apostar0a100Button = new JButton("Apostar de 0 a 100");
        apostar0a100Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                apostarDe0a100();
            }
        });
        add(apostar0a100Button);

        apostarAaZButton = new JButton("Apostar de A à Z");
        apostarAaZButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                apostarDeAaZ();
            }
        });
        add(apostarAaZButton);

        apostarParOuImparButton = new JButton("Apostar em par ou ímpar");
        apostarParOuImparButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                apostarParOuImpar();
            }
        });
        add(apostarParOuImparButton);

        sairButton = new JButton("Sair");
        sairButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0); 
            }
        });
        add(sairButton);
        
        resultTextArea = new JTextArea(8, 30);
        resultTextArea.setEditable(false);
        add(new JScrollPane(resultTextArea));

        setVisible(true);
    }

    public void apostarDe0a100() {
        int numeroApostado = Integer.parseInt(JOptionPane.showInputDialog(null, "Digite um número de 0 a 100:"));
        Random random = new Random();
        int numeroSorteado = random.nextInt(101);

        if (numeroApostado < 0 || numeroApostado > 100) {
            JOptionPane.showMessageDialog(null, "Aposta inválida.");
            return;
        }

        if (numeroApostado == numeroSorteado) {
            resultTextArea.append("Você ganhou R$ 1.000,00 reais.\n");
        } else {
            resultTextArea.append("Que pena! O número sorteado foi: " + numeroSorteado + ".\n");
        }
    }

    public void apostarDeAaZ() {
        String letraApostada = JOptionPane.showInputDialog(null, "Digite uma letra de A à Z:").toUpperCase();
        char letraPremiada = 'B'; 

        if (!Character.isLetter(letraApostada.charAt(0))) {
            JOptionPane.showMessageDialog(null, "Aposta inválida.");
            return;
        }

        if (letraApostada.charAt(0) == letraPremiada) {
            resultTextArea.append("Você ganhou R$ 500,00 reais.\n");
        } else {
            resultTextArea.append("Que pena! A letra sorteada foi: " + letraPremiada + ".\n");
        }
    }

    public void apostarParOuImpar() {
        int numeroApostado = Integer.parseInt(JOptionPane.showInputDialog(null, "Digite um número inteiro:"));

        if (numeroApostado % 2 == 0) {
            resultTextArea.append("Você ganhou R$ 100,00 reais.\n");
        } else {
            resultTextArea.append("Que pena! O número digitado é ímpar e a premiação foi para números pares.\n");
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new LotoFacilInterface();
            }
        });
    }
}
