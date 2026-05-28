# CS250 List View - Top Five Destinations

## Assignment Brief
This module builds a Java Swing desktop UI that displays five travel destinations in a scrollable list with images, descriptions, citations, and accessibility text. The code defines a data model (`Destination`), list wrapper (`DestinationList`), frame composition (`TopDestinationListFrame`), and custom renderer (`DestinationListCellRenderer`) in one source file.

## Lessons Learned (High Impact)
- **[Java, Swing, EDT]:** UI creation runs inside `SwingUtilities.invokeLater`, keeping construction on the Event Dispatch Thread. Correct thread usage prevents hard-to-debug UI race conditions.
- **[Java, JList, ListCellRenderer]:** A custom renderer builds HTML text plus image icons per row via `getListCellRendererComponent`. Renderer-driven customization enables rich list presentation without heavy custom components.
- **[Java, Accessibility, Swing]:** Each rendered item sets an accessible description from destination alt text. Embedding accessibility metadata improves compatibility with assistive technologies.
- **[Java, UI Architecture, Separation of Concerns]:** Distinct classes for frame setup, data records, list state, and rendering isolate responsibilities. Modular UI code is easier to evolve and review.
- **[Java, Swing Performance]:** Overridden repaint/validate methods in the renderer avoid unnecessary layout work for transient cell components. This reduces rendering overhead in list-heavy views.
