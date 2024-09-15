package org.deneb.stylusUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class MacOSWindowButtons extends JPanel {
    private Point initialClick;

    public MacOSWindowButtons(JFrame frame) {
        setLayout(new BorderLayout());  // Cambiar a BorderLayout para colocar el título y los botones en distintas regiones

        // Crear un panel para los botones
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new FlowLayout(FlowLayout.RIGHT, 5, 5));

        // Crear botones
        JButton closeButton = createCircleButton(Color.RED);
        JButton minimizeButton = createCircleButton(Color.YELLOW);
        JButton maximizeButton = createCircleButton(Color.GREEN);

        // Añadir acciones a los botones
        if (frame != null) {
            closeButton.addActionListener(e -> System.exit(0));
            minimizeButton.addActionListener(e -> frame.setState(Frame.ICONIFIED));
            maximizeButton.addActionListener(e -> frame.setExtendedState(frame.getExtendedState() ^ Frame.MAXIMIZED_BOTH));

            buttonPanel.add(closeButton);
            buttonPanel.add(minimizeButton);
            buttonPanel.add(maximizeButton);

            add(buttonPanel, BorderLayout.EAST);

            JLabel titleLabel = new JLabel(frame.getTitle());
            titleLabel.setForeground(Color.WHITE);
            titleLabel.setFont(new Font("Arial", Font.BOLD, 12));
            add(titleLabel, BorderLayout.CENTER);

            addMouseListener(new MouseAdapter() {
                @Override
                public void mousePressed(MouseEvent e) {
                    initialClick = e.getPoint();
                    getComponentAt(initialClick);
                }
            });

            addMouseMotionListener(new MouseAdapter() {
                @Override
                public void mouseDragged(MouseEvent e) {
                    int thisX = frame.getLocation().x;
                    int thisY = frame.getLocation().y;

                    int xMoved = e.getX() - initialClick.x;
                    int yMoved = e.getY() - initialClick.y;

                    int newX = thisX + xMoved;
                    int newY = thisY + yMoved;
                    frame.setLocation(newX, newY);
                }
            });
        } else {
            closeButton.addActionListener(e -> System.exit(0)); // Encontrar la manera de destruir el parent que lo contenga
            buttonPanel.add(closeButton);
            add(buttonPanel, BorderLayout.EAST);
        }
    }

    /**
     * Suavizar los botones
     * @param color color del boton
     * @return Boton suavizados
     */
    private JButton createCircleButton(Color color) {
        JButton button = new JButton() {
            @Override
            protected void paintComponent(Graphics g) {
                // Enable anti-aliasing
                Graphics2D g2d = (Graphics2D) g;
                g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

                // Draw circle with anti-aliasing
                g2d.setColor(color);
                g2d.fillOval(0, 0, getWidth(), getHeight());
            }
        };
        button.setPreferredSize(new Dimension(15, 15));  // Tamaño del botón
        button.setContentAreaFilled(false);
        button.setBorderPainted(false);
        button.setFocusPainted(false);
        button.setCursor(new Cursor(Cursor.HAND_CURSOR));
        return button;
    }
}
