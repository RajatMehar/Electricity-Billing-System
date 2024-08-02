import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class payment_bill extends JFrame implements ActionListener {
    JButton openBrowser;
    JComboBox<String> paymentOptions;
    String meter;

    payment_bill(String meter) {
        this.meter = meter;

        String[] options = {"GPay", "Paytm", "PhonePe", "Amazon Pay"};
        paymentOptions = new JComboBox<>(options);

        openBrowser = new JButton("Open Payment Website");
        openBrowser.addActionListener(this);

        JPanel panel = new JPanel();
        panel.add(paymentOptions);
        panel.add(openBrowser);
        add(panel, BorderLayout.CENTER);

        setTitle("Payment Bill");
        setSize(400, 200);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == openBrowser) {
            String selectedOption = (String) paymentOptions.getSelectedItem();
            String url = "";

            switch (selectedOption) {
                case "GPay":
                    url = "https://pay.google.com/";
                    break;
                case "Paytm":
                    url = "https://paytm.com/online-payments";
                    break;
                case "PhonePe":
                    url = "https://www.phonepe.com/";
                    break;
                case "Amazon Pay":
                    url = "https://www.amazon.in/amazonpay";
                    break;
            }

        }
    }

    public static void main(String[] args) {
        new payment_bill("");
    }
}
