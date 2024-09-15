package org.deneb.stylusUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class MacOSWindowButtons extends JPanel {
    private Point initialClick;

    public MacOSWindowButtons(JFrame frame) {
        setLayout(new BorderLayout());

        // Crear un panel para los botones
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new FlowLayout(FlowLayout.RIGHT, 5, 5));

        // Crear botones
        JButton closeButton = createCircleButton(Color.RED);
        JButton minimizeButton = createCircleButton(Color.YELLOW);
        JButton maximizeButton = createCircleButton(Color.GREEN);

        // A�adir acciones a los botones
        if (frame != null) {
            closeButton.addActionListener(e -> System.exit(0));
            minimizeButton.addActionListener(e -> frame.setState(Frame.ICONIFIED));

            // Agregar la animaci�n de maximizaci�n/restauraci�n
            maximizeButton.addActionListener(e -> {
                if (frame.getExtendedState() == JFrame.MAXIMIZED_BOTH) {
                    animateRestore(frame);
                } else {
                    animateMaximize(frame);
                }
            });

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
            closeButton.addActionListener(e -> {
                Window window = SwingUtilities.getWindowAncestor(this);
                if (window != null) {
                    window.dispose();
                }
            });
            buttonPanel.add(closeButton);
            add(buttonPanel, BorderLayout.EAST);
        }
    }

    /**
     * M�todo para animar la maximizaci�n de la ventana
     */
    private void animateMaximize(JFrame frame) {
        Rectangle startBounds = frame.getBounds();
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        Rectangle targetBounds = new Rectangle(0, 0, screenSize.width, screenSize.height);

        animateWindow(frame, startBounds, targetBounds);
    }

    /**
     * M�todo para animar la restauraci�n de la ventana
     */
    private void animateRestore(JFrame frame) {
        Rectangle startBounds = frame.getBounds();
        Rectangle targetBounds = new Rectangle(100, 100, 800, 600); // Tama�o y posici�n originales o deseadas

        animateWindow(frame, startBounds, targetBounds);
    }

    /**
     * M�todo gen�rico para animar el cambio de tama�o de la ventana
     */
    private void animateWindow(JFrame frame, Rectangle startBounds, Rectangle targetBounds) {
        int animationDuration = 100; // Duraci�n de la animaci�n en milisegundos
        int steps = 10; // N�mero de pasos de la animaci�n
        int delay = animationDuration / steps;

        Timer timer = new Timer(delay, null);
        ActionListener animationStep = new ActionListener() {
            int step = 0;

            @Override
            public void actionPerformed(ActionEvent e) {
                if (step >= steps) {
                    timer.stop();
                    // Establecer el estado final de la ventana (maximizado/restaurado)
                    if (targetBounds.width == Toolkit.getDefaultToolkit().getScreenSize().width) {
                        frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
                    } else {
                        frame.setBounds(targetBounds);
                    }
                    return;
                }

                // Interpolaci�n entre los l�mites iniciales y los finales
                int newX = interpolate(startBounds.x, targetBounds.x, step, steps);
                int newY = interpolate(startBounds.y, targetBounds.y, step, steps);
                int newWidth = interpolate(startBounds.width, targetBounds.width, step, steps);
                int newHeight = interpolate(startBounds.height, targetBounds.height, step, steps);

                frame.setBounds(newX, newY, newWidth, newHeight);
                step++;
            }
        };
        timer.addActionListener(animationStep);
        timer.start();
    }

    /**
     * Funci�n de interpolaci�n para calcular el valor intermedio en cada paso de la animaci�n
     */
    private int interpolate(int startValue, int endValue, int step, int totalSteps) {
        return startValue + ((endValue - startValue) * step) / totalSteps;
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
        button.setPreferredSize(new Dimension(15, 15));  // Tama�o del bot�n
        button.setContentAreaFilled(false);
        button.setBorderPainted(false);
        button.setFocusPainted(false);
        button.setCursor(new Cursor(Cursor.HAND_CURSOR));
        return button;
    }
}
