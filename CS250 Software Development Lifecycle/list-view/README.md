# CS250 — List View

Java Swing GUI displaying a scrollable list of 5 travel destinations with image icons, descriptions, and photo citations. Uses `JList` with a custom `ListCellRenderer` for rich HTML-formatted rows. Targets JavaSE-1.8 with standard Eclipse project layout.

## Lessons Learned
- **[Java, Swing, JList, DefaultListModel]:** `DefaultListModel<Destination>` provides type-safe observable list backing `JList`. Adding elements via `addElement()` automatically updates the view without manual refresh.
- **[Java, Swing, ListCellRenderer]:** Custom renderer extending `JLabel` with `getListCellRendererComponent()` renders each row with HTML-formatted text and `ImageIcon`. Gives per-row control over fonts, colors, and layout without multiple components.
- **[Java, Swing, SwingUtilities, Lambda]:** Launches GUI on the Event Dispatch Thread via `SwingUtilities.invokeLater(() -> ...)`. Lambda syntax reduces boilerplate compared to anonymous `Runnable` class.
- **[Java, Swing, BorderFactory, Focus]:** Compound border with `EmptyBorder` (unfocused) or gold `LineBorder` (focused) on the cell renderer. Lightweight focus indicator avoids custom painting.
- **[Java, Swing, Performance]:** Overrides `validate()`, `invalidate()`, `repaint()`, `revalidate()` as no-ops in the cell renderer. Prevents unnecessary layout passes since renderer is not a real container.
- **[Java, Swing, Accessibility]:** Calls `getAccessibleContext().setAccessibleDescription(destination.getAltText())` on each rendered cell. Provides screen reader support for images via alt text stored in the data model.
- **[Java, Swing, Constants, Data Encapsulation]:** Five destinations stored as `private static final Destination[]` array with image path, citation, alt text, and description. Centralizes data and separates model from presentation.
- **[Java, Swing, Layout, BoxLayout]:** Root `JPanel` uses `BoxLayout(Y_AXIS)` to stack heading and scrollable list vertically. Simple linear arrangement without nested layout managers.
- **[Java, Swing, Dark Theme]:** `DARK_GRAY` background, white text, black selection background, white selection foreground. Consistent dark appearance without a custom L&F.
- **[Java, Swing, Class Separation]:** Code split into `TopDestinationListFrame` (window), `Destination` (data), `DestinationList` (list model + scroll pane), and `DestinationListCellRenderer` (presentation). Each class has a single responsibility.
