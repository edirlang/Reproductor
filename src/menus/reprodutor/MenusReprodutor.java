/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package menus.reprodutor;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.*;
import java.io.*;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

/**
 *
 * @author Edixon Hernandez
 */
public class MenusReprodutor extends JFrame implements ActionListener {

    JMenuBar bar;
    JMenu archivo, cancion, vallenato, salsa, imajen, credi;
    JMenuItem v1, v2, v3, s1, s2, s3, im1, im2, im3, acerca, salir;
    JLabel l1;
    JButton b1, b2, b3;
    JPanel p1;
    int i = 1, n = 0;
    Icon[] imajenes = {new ImageIcon("Imagenes/imagen1.jpg"), new ImageIcon("Imagenes/imagen2.jpg"),
        new ImageIcon("Imagenes/imagen3.jpg")};
    Clip sonido;
    String[] lista = {"Canciones/v1.wav", "Canciones/v2.wav", "Canciones/v3.wav",
        "Canciones/s1.wav", "Canciones/s2.wav", "Canciones/s3.wav"};

    @SuppressWarnings("empty-statement")
    public MenusReprodutor() {

        bar = new JMenuBar();

        archivo = new JMenu("Archivo");

        cancion = new JMenu("Canciones");
        vallenato = new JMenu("Vallenato");
        salsa = new JMenu("Salsa");
        imajen = new JMenu("Imagen");

        v1 = new JMenuItem("Mi primera cana Diomedes Diaz");
        v2 = new JMenuItem("La invitacion Jorge Celedon");
        v3 = new JMenuItem("Olvidala Binomio de oro");

        vallenato.add(v1);
        vallenato.add(v2);
        vallenato.add(v3);

        s1 = new JMenuItem("Cali pachanguero grupo Niche");
        s2 = new JMenuItem("Gotas de lluvia grupo Niche");
        s3 = new JMenuItem("La rebelion Joe Arroyo");

        salsa.add(s1);
        salsa.add(s2);
        salsa.add(s3);

        im1 = new JMenuItem("Imagen 1");
        im2 = new JMenuItem("Imagen 2");
        im3 = new JMenuItem("Imagen 3");

        imajen.add(im1);
        imajen.add(im2);
        imajen.add(im3);

        cancion.add(vallenato);
        cancion.add(salsa);

        salir = new JMenuItem("Salir");

        archivo.add(cancion);
        archivo.add(imajen);
        archivo.add(salir);
        
        credi = new JMenu("Creditos");
        acerca = new JMenuItem("Acerca de");
        credi.add(acerca);
        bar.add(archivo);
        bar.add(credi);

        v1.addActionListener(this);
        v2.addActionListener(this);
        v3.addActionListener(this);
        s1.addActionListener(this);
        s2.addActionListener(this);
        s3.addActionListener(this);
        im1.addActionListener(this);
        im2.addActionListener(this);
        im3.addActionListener(this);
        salir.addActionListener(this);
        credi.addActionListener(this);
        acerca.addActionListener(this);

        this.setJMenuBar(bar);

        l1 = new JLabel();

        b1 = new JButton("Play");
        b2 = new JButton("Pause");
        b3 = new JButton("RePlay");

        b1.addActionListener(this);
        b2.addActionListener(this);
        b3.addActionListener(this);

        p1 = new JPanel(new FlowLayout(FlowLayout.CENTER));
        
        add(p1);



        try {
            sonido = AudioSystem.getClip();
        } catch (LineUnavailableException ex) {
            JOptionPane.showMessageDialog(null, "No enconttrada" + ex);
        }
        
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public static void main(String[] args) {
        MenusReprodutor ob = new MenusReprodutor();
        ob.setSize(500, 550);
        ob.setVisible(true);
    }

    void cancion() {

        p1.remove(l1);
        p1.add(b1);
        p1.add(b2);
        p1.add(b3);
        if (sonido.isOpen()) {
            sonido.close();
        }
        try {
            sonido.open(AudioSystem.getAudioInputStream(new File(lista[n])));
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "No enconttrada" + e);
        } catch (LineUnavailableException ex) {
            JOptionPane.showMessageDialog(null, "No enconttrada" + ex);
        } catch (UnsupportedAudioFileException ex) {
            JOptionPane.showMessageDialog(null, "No enconttrada" + ex);
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == salir) {
            System.exit(0);
        }
        if (e.getSource() == v1) {
            n = 0;
            cancion();
        }
        if (e.getSource() == v2) {
            n = 1;
            cancion();        }
        if (e.getSource() == v3) {
            n = 2;
            cancion();
        }

        if (e.getSource() == s1) {
            n = 3;
            cancion();
        }
        if (e.getSource() == s2) {
            n = 4;
            cancion();
        }
        if (e.getSource() == s3) {
            n = 5;
            cancion();
        }

        if (e.getSource() == im1) {
            if (sonido.isOpen()) {
                sonido.close();
            }
            p1.removeAll();
            l1.setIcon(imajenes[0]);
            p1.add(l1);
        }
        if (e.getSource() == im2) {
            if (sonido.isOpen()) {
                sonido.close();
            }
            p1.removeAll();
            l1.setIcon(imajenes[1]);
            p1.add(l1);
        }
        if (e.getSource() == im3) {
            if (sonido.isOpen()) {
                sonido.close();
            }
            p1.removeAll();
            l1.setIcon(imajenes[2]);
            p1.add(l1);
        }

        if (e.getSource() == acerca) {
            JOptionPane.showMessageDialog(null, "Programando con el sobrino de sotelo"
                    + "\n" + "Con puro croche " + "\n" + "Desarrollado por:" + "\n" + "Edixon Hernandez"
                    + "\n" + "Javier Valencia" + "\n" + "Ingenieritos de pipiripao");
        }

        if (e.getSource() == b1) {
            sonido.start();
        }
        if (e.getSource() == b2) {
            sonido.stop();

        }
        if (e.getSource() == b3) {
            sonido.close();
            cancion();
            sonido.start();
        }
        if (i == 1) {
            i = -1;
        } else {
            i = 1;
        }
        setSize(500 + i, 550);
    }
}
