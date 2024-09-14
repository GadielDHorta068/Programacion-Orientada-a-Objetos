package org.deneb.tp4.ejercicio4.stylusUI;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableColumn;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.font.TextAttribute;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.Map;
import java.util.Objects;

public class StylusUI {
    // Colores oscuros inspirados en Material UI y Ubuntu
    public static final Color COLOR_PRIMARIO = new Color(38, 50, 56);  // Gris oscuro
    public static final Color COLOR_SECUNDARIO = new Color(13, 36, 175);// Azul
    public static final Color COLOR_FONDO_BOTON = new Color(45, 60, 70);     // Color apenas diferente al fondo
    public static final Color COLOR_TEXTO = Color.WHITE;                            // Color blanco
    public static final Color COLOR_HOVER_BOTON = new Color(60, 75, 85);  // Color para hover
    public static final Color COLOR_PRESIONADO_BOTON = new Color(30, 40, 50);  // Color para presionado
    private static final Color DARK_BACKGROUND_COLOR = new Color(45, 45, 45); // Fondo oscuro
    private static final Color TEXT_COLOR = new Color(230, 230, 230);         // Color del texto
    private static final Color ERROR_COLOR = Color.RED;                       // Color para errores
    private static final int PADDING_HORIZONTAL = 2;                         // Espacio extra en los botones
    private static final Color BUTTON_BACKGROUND_COLOR = new Color(45, 60, 70);
    private static final Color BUTTON_HOVER_COLOR = BUTTON_BACKGROUND_COLOR.darker();
    private static final Color BUTTON_PRESSED_COLOR = BUTTON_BACKGROUND_COLOR.brighter();

    // Tipografía personalizada
    public static Font FUENTE_TEXTO;
    public static Font FUENTE_TITULO;

    static {
        try {
            URL fuenteURL = StylusUI.class.getResource("FiraMonoNerdFontMono-Regular.otf");
            if (fuenteURL == null) {
                throw new IOException("No se pudo encontrar la fuente en la URL especificada.");
            }

            try (InputStream fuenteStream = fuenteURL.openStream()) {
                FUENTE_TEXTO = Font.createFont(Font.TRUETYPE_FONT, fuenteStream).deriveFont(14f);
                FUENTE_TITULO = FUENTE_TEXTO.deriveFont(Font.ITALIC, 16f);
                GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
                ge.registerFont(FUENTE_TEXTO);

                // Aplicar la fuente a todos los componentes globalmente
                UIManager.put("Label.font", FUENTE_TEXTO);
                UIManager.put("Button.font", FUENTE_TEXTO);
                UIManager.put("TextField.font", FUENTE_TEXTO);
                UIManager.put("Table.font", FUENTE_TEXTO);
                UIManager.put("TextArea.font", FUENTE_TEXTO);
                UIManager.put("ComboBox.font", FUENTE_TEXTO);
                UIManager.put("CheckBox.font", FUENTE_TEXTO);
            }
        } catch (Exception e) {
            e.printStackTrace(); // Imprimir el error para verificar problemas con la carga de la fuente
            FUENTE_TEXTO = new Font("SansSerif", Font.PLAIN, 14);
            FUENTE_TITULO = new Font("SansSerif", Font.BOLD, 16);
        }
    }

    /**
     * Esta clase recibe un boton como parametro y le aplica toda la configuracion personalizada que deseemos
     * @param boton boton a ser alterado
     */
    public static void aplicarEstiloBoton(JButton boton) {
        boton.setBackground(COLOR_FONDO_BOTON);
        boton.setForeground(COLOR_TEXTO);
        boton.setFont(FUENTE_TEXTO.deriveFont(12f));  // Tamaño de fuente reducido
        boton.setFocusPainted(false);
        boton.setBorder(new BordeRedondeado(10));  // Borde redondeado más pequeño

        // Ajustar márgenes muy pequeños para hacer el botón más compacto
        boton.setMargin(new Insets(2, 5, 2, 5));
        boton.setPreferredSize(new Dimension(80, 30));  // Tamaño ajustado, me quedaba muy grande
        boton.setContentAreaFilled(true);  // Mantener el relleno

        // Ajustar tamaño al contenido del texto del botón
        Dimension preferredSize = boton.getPreferredSize();
        preferredSize.width += PADDING_HORIZONTAL * 2; // Añadir espacio horizontal adicional
        boton.setPreferredSize(preferredSize);

        // Añadir eventos para cambiar el color al pasar el mouse y al presionar
        boton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                // Cambiar el color de fondo cuando el mouse está encima (hover)
                boton.setBackground(COLOR_HOVER_BOTON);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                // Volver al color original cuando el mouse sale del botón
                boton.setBackground(COLOR_FONDO_BOTON);
            }

            @Override
            public void mousePressed(MouseEvent e) {
                // Cambiar el color cuando el botón es presionado
                boton.setBackground(COLOR_PRESIONADO_BOTON);

                // Reproducir sonido al presionar el botón
                reproducirSonido("boton.wav");
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                // Volver al color de hover o al color original cuando se suelta el botón
                if (boton.getBounds().contains(e.getPoint())) {
                    boton.setBackground(COLOR_HOVER_BOTON);
                } else {
                    boton.setBackground(COLOR_FONDO_BOTON);
                }
            }
        });
    }

    /**
     * Cambia la fuente y el fondo a una etiqueta
     * @param etiqueta
     */
    public static void aplicarEstiloEtiqueta(JLabel etiqueta) {
        etiqueta.setForeground(COLOR_TEXTO);
        etiqueta.setFont(FUENTE_TEXTO);
    }

    /**
     * Cambia el fondo del panel
     * @param panel panel a ser tratado
     */
    public static void aplicarEstiloPanel(JPanel panel) {
        panel.setBackground(COLOR_PRIMARIO);
    }

    /**
     * Recibe una tabla y se le cambian mucho aspectos de la misma
     * @param tabla tabla a ser tratada
     * @param reajustar si es verdadero, se ajustara el largo de las columnas al largo del texto que las contenga
     */
    public static void aplicarEstiloTabla(JTable tabla, boolean reajustar) {
        // Estilo de la tabla
        tabla.setBackground(COLOR_PRIMARIO);  // Fondo de la tabla
        tabla.setForeground(COLOR_TEXTO);     // Color del texto
        tabla.setFont(FUENTE_TEXTO);          // Fuente del texto

        // Si la tabla está vacía, asegurarse de que el fondo siga siendo oscuro
        tabla.setFillsViewportHeight(true);   // Llenar el área de la tabla, incluso cuando está vacía

        JTableHeader cabecera = tabla.getTableHeader();
        cabecera.setBackground(COLOR_SECUNDARIO);  // Fondo de la cabecera
        cabecera.setForeground(COLOR_TEXTO);       // Texto de la cabecera
        cabecera.setFont(FUENTE_TITULO);           // Fuente de la cabecera

        // Bordes y selección
        tabla.setGridColor(COLOR_SECUNDARIO);         // Color de las líneas de la tabla
        tabla.setSelectionBackground(COLOR_SECUNDARIO.darker());  // Fondo de selección
        tabla.setSelectionForeground(COLOR_TEXTO);    // Texto de selección

        // Renderer para el fondo de las celdas
        tabla.setDefaultRenderer(Object.class, new DefaultTableCellRenderer() {
            @Override
            public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
                Component c = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
                if (isSelected) {
                    c.setBackground(COLOR_SECUNDARIO.darker());  // Fondo seleccionado
                    c.setForeground(COLOR_TEXTO);               // Texto seleccionado
                } else {
                    c.setBackground(COLOR_PRIMARIO);            // Fondo normal
                    c.setForeground(COLOR_TEXTO);               // Texto normal
                }
                return c;
            }
        });

        if (reajustar){
            ajustarAnchoColumnas(tabla);
        }
    }

    /**
     * Modifica las visuale de un campo de texto
     * @param textField texto a ser tratado
     */
    public static void aplicarEstiloCampoTexto(JTextField textField) {
        textField.setBackground(DARK_BACKGROUND_COLOR);
        textField.setForeground(TEXT_COLOR);
        textField.setCaretColor(TEXT_COLOR);
        textField.setBorder(BorderFactory.createLineBorder(TEXT_COLOR));
        textField.setFont(FUENTE_TEXTO);
    }

    /**
     * Este metodo recibe una jtable y ajusta el largo de cada columna al largo de su texto,
     * para no dejar titulos ilegibles
     * @param tabla a ser tratada
     */
    public static void ajustarAnchoColumnas(JTable tabla) {
        JTableHeader header = tabla.getTableHeader();
        int rowCount = tabla.getRowCount();

        for (int i = 0; i < tabla.getColumnCount(); i++) {
            TableColumn column = tabla.getColumnModel().getColumn(i);
            int maxWidth = header.getDefaultRenderer().getTableCellRendererComponent(tabla, column.getHeaderValue(), false, false, 0, i).getPreferredSize().width;

            for (int j = 0; j < rowCount; j++) {
                int cellWidth = tabla.getCellRenderer(j, i).getTableCellRendererComponent(tabla, tabla.getValueAt(j, i), false, false, j, i).getPreferredSize().width;
                maxWidth = Math.max(maxWidth, cellWidth);
            }

            column.setPreferredWidth(maxWidth + 10); // Añadir un margen adicional para el espaciado
        }
    }

    // Método para aplicar estilo al JDialog
    public static void aplicarEstiloDialogo(JDialog dialog) {
        dialog.getContentPane().setBackground(DARK_BACKGROUND_COLOR);

        // Aplicar estilo a los componentes dentro del diálogo
        for (Component component : dialog.getContentPane().getComponents()) {
            if (component instanceof JPanel) {
                aplicarEstiloPanel((JPanel) component);
            } else if (component instanceof JLabel) {
                aplicarEstiloEtiqueta((JLabel) component);
            } else if (component instanceof JTextField) {
                aplicarEstiloCampoTexto((JTextField) component);
            } else if (component instanceof JButton) {
                aplicarEstiloBoton((JButton) component);
            }
        }

        dialog.pack(); // Ajustar el tamaño del diálogo según su contenido
        dialog.setLocationRelativeTo(null); // Centrar el diálogo en la pantalla
    }

    // Método para aplicar estilo a JOptionPane
    public static void aplicarEstiloJOptionPane() {
        UIManager.put("OptionPane.background", DARK_BACKGROUND_COLOR);
        UIManager.put("Panel.background", DARK_BACKGROUND_COLOR);
        UIManager.put("OptionPane.messageForeground", TEXT_COLOR);
        UIManager.put("Button.background", BUTTON_BACKGROUND_COLOR);
        UIManager.put("Button.foreground", TEXT_COLOR);
        UIManager.put("Button.font", FUENTE_TEXTO.deriveFont(14f)); // Actualizar con fuente personalizada
        UIManager.put("Button.border", BorderFactory.createLineBorder(TEXT_COLOR));

        // Personalizar el comportamiento de los botones en JOptionPane
        UIManager.put("OptionPane.buttonFont", FUENTE_TEXTO.deriveFont(14f)); // Actualizar con fuente personalizada
    }

    private static void reproducirSonido(String archivoSonido) {
        try {
            // Cargar el archivo de sonido desde el classpath
            URL sonidoURL = StylusUI.class.getResource(archivoSonido);
            if (sonidoURL != null) {
                AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(sonidoURL);
                Clip clip = AudioSystem.getClip();
                clip.open(audioInputStream);
                clip.start();
            } else {
                System.err.println("Archivo de sonido no encontrado: " + archivoSonido);
            }
        } catch (Exception e) {
            System.err.println("Error al reproducir el sonido: " + e.getMessage());
        }
    }
}
