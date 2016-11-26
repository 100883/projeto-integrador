/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfacegrafica;

import java.awt.Dimension;
import javax.swing.JInternalFrame;

/**
 *
 * @author Aluno
 */
public class Util {

    public static void centralizar(JInternalFrame fr) {
        Dimension d = fr.getDesktopPane().getSize();
        fr.setLocation((d.width - fr.getSize().width) / 2, (d.height - fr.getSize().height) / 2);

    }

}
