import java.awt.*;
import javax.swing.*;
import java.applet.AudioClip;
public class Ventana extends JFrame
{
    private JLabel[][] m1;
    private JLabel[][] m2;
    private JPanel panel;
    public Ventana(String jugador, int x, int y){
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setTitle("Batalla Naval - "+jugador);
        setBounds(x,y,800,465);
        setResizable(false);
        setIconImage(new ImageIcon("nave.png").getImage());
        
        iniciarComponentes();
    }
    private void iniciarComponentes(){
        panel = new JPanel();
        panel.setLayout(null);
        panel.setBackground(Color.DARK_GRAY);
        this.getContentPane().add(panel);
        
        JLabel head = new JLabel(new ImageIcon("header.png"));
        head.setBounds(40,20,700,80);
        panel.add(head);
        
        JLabel ejeX1 = new JLabel(new ImageIcon("ejeX.png"));
        ejeX1.setBounds(50,125,200,25);
        panel.add(ejeX1);
        
        JLabel ejeX2 = new JLabel(new ImageIcon("ejeX.png"));
        ejeX2.setBounds(320,125,200,25);
        panel.add(ejeX2);
        
        JLabel ejeY1 = new JLabel(new ImageIcon("ejeY.png"));
        ejeY1.setBounds(28,150,25,200);
        panel.add(ejeY1);
        
        JLabel ejeY2 = new JLabel(new ImageIcon("ejeY.png"));
        ejeY2.setBounds(298,150,25,200);
        panel.add(ejeY2);
        
        JLabel pr = new JLabel(new ImageIcon("propio.png"));
        pr.setBounds(30,362,225,40);
        panel.add(pr);
        
        JLabel cr = new JLabel(new ImageIcon("contrario.png"));
        cr.setBounds(300,362,225,40);
        panel.add(cr);
        
        JLabel sr = new JLabel(new ImageIcon("salir.png"));
        sr.setBounds(650,368,115,35);
        panel.add(sr);
        
        JLabel puerto = new JLabel(new ImageIcon("puerto.png"));
        puerto.setBounds(565,126,180,125);
        panel.add(puerto);
        
        this.m1 = crearMatriz();
        imprimirMat(m1,50,150);
        
        this.m2 = crearMatriz();
        imprimirMat(m2,320,150);
    }
    public JLabel[][] crearMatriz(){
        JLabel[][] mt = new JLabel[10][10];
        for(int i=0;i<mt.length;i++){
            for(int j=0;j<mt[0].length;j++){
                mt[i][j] = new JLabel(new ImageIcon("vacio.png"));
                //mt[i][j].setIcon(new ImageIcon("nave.png"));
            }
        }
        return mt;
    }
    public void imprimirMat(JLabel[][] m, int x, int y){
        int xr = x;
        int yr = y;
        for(int i=0;i<m.length;i++){
            for(int j=0;j<m[0].length;j++){
                m[i][j].setBounds(xr,yr,20,20);
                panel.add(m[i][j]);
                xr=xr+20;
            }
            xr=x;
            yr=yr+20;
        }
    }
    public void setPropio(Casilla[][] tn){
        for(int i=0;i<tn.length;i++){
            for(int j=0;j<tn[0].length;j++){
                if(tn[i][j].getIden()=='B'){
                    m1[i][j].setIcon(new ImageIcon("nave.png"));
                }
                if(tn[i][j].getIden()=='A'){
                    m1[i][j].setIcon(new ImageIcon("vacio.png"));
                }
                if(tn[i][j].getIden()=='X'){
                    m1[i][j].setIcon(new ImageIcon("hundido.png"));
                }
            }
        }
    }
    public void setContrario(Casilla[][] tn){
        for(int i=0;i<tn.length;i++){
            for(int j=0;j<tn[0].length;j++){
                if(tn[i][j].getIden()=='A'){
                    m2[i][j].setIcon(new ImageIcon("vacio.png"));
                }
                if(tn[i][j].getIden()=='X'){
                    m2[i][j].setIcon(new ImageIcon("hundido.png"));
                }
                if(tn[i][j].getIden()=='N'){
                    m2[i][j].setIcon(new ImageIcon("alAgua.png"));
                }
            }
        }
    }
}