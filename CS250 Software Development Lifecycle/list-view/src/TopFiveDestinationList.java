/*
 * TopFiveDestinationList.java
 * Author: SNHU
 * 
 * Changed by: Christian Decker
 * Changes documented in comments below prefixed with "CD".
 * 
 * AI used for handling tedious reorganization, not ideation.
 * Citations:
 * GitHub. (2025). *GitHub Copilot* (Claude Sonnet 4.5 version) [AI-powered coding assistant]. https://github.com/features/copilot
 * Anthropic. (2025). *Claude Sonnet 4.5* [Large language model]. https://www.anthropic.com
 */

import java.awt.*;
import javax.swing.*;
import javax.swing.border.*;

public class TopFiveDestinationList {

    public static void main(String[] args) {
        // CD: Replaced `Runnable` with lambda expression for brevity.
        SwingUtilities.invokeLater(() -> {
            TopDestinationListFrame topDestinationListFrame = new TopDestinationListFrame();
            topDestinationListFrame.setTitle("Top 5 Destinations");
            topDestinationListFrame.setVisible(true);
            // CD: Colocated frame setup code
            topDestinationListFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
            topDestinationListFrame.setSize(900, 750);
        }
        );
    }
}

class TopDestinationListFrame extends JFrame {

    // CD: Extract top 5 destinations into constant
    private static final Destination[] TOP_DESTINATIONS = {
        new Destination(
        "Tokyo, Japan",
        "/resources/tokyo.jpg",
        "Delso, D. (2015). Tokyo Tower and around skyscrapers [Photograph]. Wikimedia Commons. https://commons.wikimedia.org/wiki/File:Tokyo_Tower_and_around_Skyscrapers.jpg",
        "Tokyo cityscape with Tokyo Tower and modern skyscrapers",
        "A vibrant metropolis blending ancient tradition with cutting-edge innovation"
        ),
        new Destination(
        "Seoul, South Korea",
        "/resources/seoul.jpg",
        "Yoo, C. (2023). Seoul city wall and downtown Seoul from Inwangsan [Photograph]. Wikimedia Commons. https://commons.wikimedia.org/wiki/File:Seoul_City_Wall_and_Downtown_Seoul_from_Inwangsan_in_2023.jpg",
        "Seoul city wall and downtown skyline viewed from Inwangsan mountain",
        "Dynamic capital featuring ancient palaces and futuristic skyscrapers"
        ),
        new Destination(
        "Tivoli, Italy",
        "/resources/tivoli.jpg",
        "Marcok. (2010). Villa d'Este [Photograph]. Wikimedia Commons. https://commons.wikimedia.org/wiki/File:Villa_d%27Este_01.jpg",
        "Historical Villa d'Este gardens and fountains in Tivoli",
        "Historic Italian town renowned for stunning Renaissance gardens and villas"
        ),
        new Destination(
        "Manila, Philippines",
        "/resources/manila.jpg",
        "Patrickroque01. (2018). Manila sunset from C5 [Photograph]. Wikimedia Commons. https://commons.wikimedia.org/wiki/File:Manila_Sunset_from_C5.jpg",
        "Manila cityscape with dramatic sunset view from C5 road",
        "Tropical capital offering breathtaking sunsets and rich cultural heritage"
        ),
        new Destination(
        "Sydney, Australia",
        "/resources/sydney.jpg",
        "Adam.J.W.C. (2008). Sydney Opera House [Photograph]. Wikimedia Commons. https://commons.wikimedia.org/wiki/File:Sydney_Opera_House_-_Dec_2008.jpg",
        "Sydney Opera House architectural detail and harbor view",
        "Iconic harbor city with world-famous landmarks and stunning beaches"
        )
    };

    public TopDestinationListFrame() {
        super();

        // CD: Use a top-level JPanel with a vertical BoxLayout to better organize components.
        JPanel root = new JPanel();
        root.setLayout(new BoxLayout(root, BoxLayout.Y_AXIS));
        setContentPane(root);

        // CD: Add separate methods for initializing components, clarifying declarative structure of the frame.
        root.add(createHeading());
        root.add(createDestinationList());
    }

    // CD: Added centered bold heading with 10px padding.
    private JPanel createHeading() {
        JLabel heading = new JLabel("Top 5 Destinations");
        heading.setFont(heading.getFont().deriveFont(Font.BOLD, 18f));

        JPanel headingPanel = new JPanel(new GridBagLayout());
        headingPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        headingPanel.add(heading);

        return headingPanel;
    }

    // CD: Iterate through TOP_DESTINATIONS to populate the list
    private JScrollPane createDestinationList() {
        DestinationList destinationList = new DestinationList();
        for (Destination destination : TOP_DESTINATIONS) {
            destinationList.addDestination(destination);
        }
        return destinationList.getScrollPane();
    }
}

// CD: Replaced `TextAndIcon` with semantically meaningful `Destination` class.
class Destination {

    private String name;
    private String imagePath;
    private String citation;
    private String altText;
    private String description;

    public Destination(String name, String imagePath, String citation, String altText, String description) {
        this.name = name;
        this.imagePath = imagePath;
        this.citation = citation;
        this.altText = altText;
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public String getImagePath() {
        return imagePath;
    }

    public String getCitation() {
        return citation;
    }

    public String getAltText() {
        return altText;
    }

    public String getDescription() {
        return description;
    }
}

// CD: Encapsulate list model and JList into a `DestinationList` class for better separation of concerns.
class DestinationList {

    private DefaultListModel<Destination> listModel;
    private JList<Destination> list;
    private JScrollPane scrollPane;

    public DestinationList() {
        listModel = new DefaultListModel<>();
        list = new JList<>(listModel);

        // CD: Change colors to dark theme
        list.setBackground(Color.DARK_GRAY);
        list.setForeground(Color.WHITE);
        list.setSelectionBackground(Color.BLACK);
        list.setSelectionForeground(Color.WHITE);

        list.setCellRenderer(new DestinationListCellRenderer(2));
        scrollPane = new JScrollPane(list);
    }

    public void addDestination(Destination destination) {
        listModel.addElement(destination);
    }

    public JScrollPane getScrollPane() {
        return scrollPane;
    }
}

// CD: Custom list cell renderer for Destination objects.
class DestinationListCellRenderer extends JLabel implements ListCellRenderer<Destination> {

    // CD: Define constant for border thickness, since it must match across both focused and non-focused states.
    private static final short BORDER_THICKNESS = 1;
    private static final Border NO_FOCUS_BORDER = new EmptyBorder(BORDER_THICKNESS, BORDER_THICKNESS, BORDER_THICKNESS, BORDER_THICKNESS);

    private Border insideBorder;

    public DestinationListCellRenderer() {
        this(0, 0, 0, 0);
    }

    public DestinationListCellRenderer(int padding) {
        this(padding, padding, padding, padding);
    }

    public DestinationListCellRenderer(int topPadding, int rightPadding, int bottomPadding, int leftPadding) {
        insideBorder = BorderFactory.createEmptyBorder(topPadding, leftPadding, bottomPadding, rightPadding);
        setOpaque(true);
    }

    // CD: Add missing @Override annotation
    @Override
    public Component getListCellRendererComponent(
            JList<? extends Destination> list,
            Destination destination,
            int index,
            boolean isSelected,
            boolean hasFocus
    ) {
        // CD: Auto-number and build HTML content with destination name, description, and citation
        String numberedName = (index + 1) + ". " + destination.getName();
        String htmlText = "<html><div style='padding: 5px;'>"
                + "<div style='font-size: 12px; font-weight: bold;'>" + numberedName + "</div>"
                + "<div style='font-size: 10px; margin-top: 2px;'>" + destination.getDescription() + "</div>"
                + "<div style='font-size: 9px; color: #CCCCCC; margin-top: 3px;'>" + destination.getCitation() + "</div>"
                + "</div></html>";

        setText(htmlText);
        setIcon(new ImageIcon(getClass().getResource(destination.getImagePath())));

        // CD: Set accessible description using alt text
        getAccessibleContext().setAccessibleDescription(destination.getAltText());

        if (isSelected) {
            setBackground(list.getSelectionBackground());
            setForeground(list.getSelectionForeground());
        } else {
            setBackground(list.getBackground());
            setForeground(list.getForeground());
        }

        Border outsideBorder;

        if (hasFocus) {
            // CD: Custom gold border for focused items.
            Color gold = new Color(255, 215, 0);
            outsideBorder = BorderFactory.createLineBorder(gold, BORDER_THICKNESS);
        } else {
            outsideBorder = NO_FOCUS_BORDER;
        }

        setBorder(BorderFactory.createCompoundBorder(outsideBorder, insideBorder));
        setComponentOrientation(list.getComponentOrientation());
        setEnabled(list.isEnabled());
        setFont(list.getFont());

        return this;
    }

    // The following methods are overridden to be empty for performance
    // reasons. If you want to understand better why, please read:
    //
    // http://java.sun.com/javase/6/docs/api/javax/swing/DefaultListCellRenderer.html#override
    //
    // CD: Add missing @Override annotations
    @Override
    public void validate() {
    }

    @Override
    public void invalidate() {
    }

    @Override
    public void repaint() {
    }

    @Override
    public void revalidate() {
    }

    @Override
    public void repaint(long tm, int x, int y, int width, int height) {
    }

    @Override
    public void repaint(Rectangle r) {
    }
}
