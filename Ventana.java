import java.awt.*;
import javax.swing.*;
import java.applet.AudioClip;
public class Ventana extends JFrame
{
    public Ventana(String jugador, int x, int y){
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setTitle("Batalla Naval - "+jugador);
        setBounds(x,y,800,500);
        setResizable(false);
        //setLayout(null);
        
        iniciarComponentes();
    }
    private void iniciarComponentes(){
        JPanel panel = new JPanel();
        panel.setLayout(null);
        this.getContentPane().add(panel);
        
        /*
        JLabel bg;
        ImageIcon img = new ImageIcon ("Fondo.jpg");
        bg = new JLabel ("",img,JLabel.CENTER);
        bg.setBounds(0,0,800,500);
        panel.add(bg);
        */
        
        JLabel[][] m1 = crearMatriz();
        imprimirMat(m1,panel,30,150);
        
        JLabel[][] m2 = crearMatriz();
        imprimirMat(m2,panel,300,150);
        
        /*
        JLabel et1 = new JLabel(new ImageIcon("prueba.jpg"));
        et1.setBounds(10,80,50,50);
        panel.add(et1);
        JLabel et2 = new JLabel(new ImageIcon("prueba.jpg"));
        et2.setBounds(60,80,50,50);
        panel.add(et2);
        */
    }
    public JLabel[][] crearMatriz(){
        JLabel[][] mt = new JLabel[10][10];
        for(int i=0;i<mt.length;i++){
            for(int j=0;j<mt[0].length;j++){
                mt[i][j] = new JLabel(new ImageIcon("alAgua.png"));
            }
        }
        return mt;
    }
    public void imprimirMat(JLabel[][] m, JPanel p, int x, int y){
        int xr = x;
        int yr = y;
        for(int i=0;i<m.length;i++){
            for(int j=0;j<m[0].length;j++){
                m[i][j].setBounds(xr,yr,20,20);
                p.add(m[i][j]);
                xr=xr+20;
            }
            xr=x;
            yr=yr+20;
        }
    }
}