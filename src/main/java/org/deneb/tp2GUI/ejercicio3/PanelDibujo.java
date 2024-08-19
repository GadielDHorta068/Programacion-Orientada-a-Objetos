package org.deneb.tp2GUI.ejercicio3;

import org.deneb.tp2GUI.ejercicio3.geometria.Figura;

import java.awt.*;
import java.util.List;

public class PanelDibujo {
    public PanelDibujo(List<Figura> figuras, Graphics g){
        for (Figura f : figuras){
            f.dibujar(g);
        }
    }
}
