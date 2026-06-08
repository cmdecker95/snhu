
import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class SlideShow extends JFrame {

    //Declare Variables
    private JPanel slidePane;
    private JPanel textPane;
    private JPanel buttonPane;
    private CardLayout card;
    private CardLayout cardText;
    private JButton btnPrev;
    private JButton btnNext;
    private JLabel lblSlide;
    private JLabel lblTextArea;

    /**
     * Create the application.
     */
    public SlideShow() throws HeadlessException {
        initComponent();
    }

    /**
     * Initialize the contents of the frame.
     */
    private void initComponent() {
        //Initialize variables to empty objects
        card = new CardLayout();
        cardText = new CardLayout();
        slidePane = new JPanel();
        textPane = new JPanel();
        // CD: Removed blue background color to enhance readability of text descriptions.
        // textPane.setBackground(Color.BLUE);
        textPane.setBounds(5, 470, 790, 50);
        textPane.setVisible(true);
        buttonPane = new JPanel();
        btnPrev = new JButton();
        btnNext = new JButton();
        lblSlide = new JLabel();
        lblTextArea = new JLabel();

        //Setup frame attributes
        setSize(800, 600);
        setLocationRelativeTo(null);
        setTitle("Top 5 Destinations SlideShow");
        // CD: Added vertical gap of 100 pixels to create more space between the slide and text description for improved readability.
        getContentPane().setLayout(new BorderLayout(10, 100));
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //Setting the layouts for the panels
        slidePane.setLayout(card);
        textPane.setLayout(cardText);

        //logic to add each of the slides and text
        for (int i = 1; i <= 5; i++) {
            lblSlide = new JLabel();
            lblTextArea = new JLabel();
            lblSlide.setText(getResizeIcon(i));
            lblTextArea.setText(getTextDescription(i));
            slidePane.add(lblSlide, "card" + i);
            textPane.add(lblTextArea, "cardText" + i);
        }

        getContentPane().add(slidePane, BorderLayout.CENTER);
        getContentPane().add(textPane, BorderLayout.SOUTH);

        buttonPane.setLayout(new FlowLayout(FlowLayout.CENTER, 20, 10));

        btnPrev.setText("Previous");
        btnPrev.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                goPrevious();
            }
        });
        buttonPane.add(btnPrev);

        btnNext.setText("Next");
        btnNext.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                goNext();
            }
        });
        buttonPane.add(btnNext);

        getContentPane().add(buttonPane, BorderLayout.SOUTH);
    }

    /**
     * Previous Button Functionality
     */
    private void goPrevious() {
        card.previous(slidePane);
        cardText.previous(textPane);
    }

    /**
     * Next Button Functionality
     */
    private void goNext() {
        card.next(slidePane);
        cardText.next(textPane);
    }

    /**
     * Method to get the images
     */
    private String getResizeIcon(int i) {
        String image = "";

        // CD: Updated images and alt text to match the new wellness theme of the slideshow.
        // Each image is resized to fit within the 800x500 pixel area of the slide pane while maintaining aspect ratio.
        // The alt text provides descriptive information about the content of each image.
        switch (i) {
            case 1 ->
                image = "<html><body><img width='800' height='500' alt='Bahamas tropical beach with crystal clear turquoise waters for wellness retreat' src='" + getClass().getResource("/resources/bahamas.jpeg") + "'></body></html>";
            case 2 ->
                image = "<html><body><img width='800' height='500' alt='Hawaii hiking peak overlooking the ocean for wellness and rejuvenation' src='" + getClass().getResource("/resources/hawaii.jpeg") + "'></body></html>";
            case 3 ->
                image = "<html><body><img width='800' height='500' alt='Japan mountain hot spring promoting relaxation and wellness' src='" + getClass().getResource("/resources/japan.jpeg") + "'></body></html>";
            case 4 ->
                image = "<html><body><img width='800' height='500' alt='Vietnam water kayaking adventure next to mountains supporting physical wellness and stress relief' src='" + getClass().getResource("/resources/kayak.jpeg") + "'></body></html>";
            case 5 ->
                image = "<html><body><img width='800' height='500' alt='Redwood forest ecosystem for nature-based mental health recovery' src='" + getClass().getResource("/resources/redwood.jpeg") + "'></body></html>";
        }
        return image;
    }

    /**
     * Method to get the text values
     */
    private String getTextDescription(int i) {
        String text = "";

        // CD: Updated text descriptions to align with the new wellness theme of the slideshow.
        switch (i) {
            case 1 ->
                text = "<html><body><font size='5'>#1 Bahamas Beach Detox</font> <br><b>Mental Health Benefits:</b> Ocean air reduces anxiety and promotes emotional balance. <br><b>Physical Benefits:</b> Salt water therapy improves skin health and circulation.</body></html>";
            case 2 ->
                text = "<html><body><font size='5'>#2 Hawaii Wellness Retreat</font> <br><b>Mental Health Benefits:</b> Volcanic mineral springs enhance cognitive function and mood stability. <br><b>Physical Benefits:</b> Geothermal heat therapy aids muscle recovery and detoxification.</body></html>";
            case 3 ->
                text = "<html><body><font size='5'>#3 Japan Zen Sanctuary</font> <br><b>Mental Health Benefits:</b> Mindfulness gardens reduce cortisol levels and promote inner peace. <br><b>Physical Benefits:</b> Forest bathing strengthens immune system and reduces inflammation.</body></html>";
            case 4 ->
                text = "<html><body><font size='5'>#4 Mountain Adventure Wellness</font> <br><b>Mental Health Benefits:</b> Outdoor activities combat depression and enhance self-esteem. <br><b>Physical Benefits:</b> Kayaking builds cardiovascular endurance and improves overall fitness.</body></html>";
            case 5 ->
                text = "<html><body><font size='5'>#5 Redwood Forest Retreat</font> <br><b>Mental Health Benefits:</b> Nature immersion reduces stress and promotes neurological healing. <br><b>Physical Benefits:</b> Forest air improves respiratory function and oxygen absorption.</body></html>";
        }
        return text;
    }

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {

            @Override
            public void run() {
                SlideShow ss = new SlideShow();
                ss.setVisible(true);
            }
        });
    }
}
