import java.util.Scanner;
public class Estrategia
{
    private int px;
    private int py;
    private int pos;
    private Tablero estPos;
    private Ventana ven;
    public Estrategia(Ventana v){
        this.ven = v;
        this.estPos = iniciar();
    }
    public Tablero iniciar()
    {
        Scanner scan = new Scanner(System.in);
        Casilla[][] base = {
            {new Casilla('A',0),new Casilla('A',0),new Casilla('A',0),new Casilla('A',0),new Casilla('A',0),new Casilla('A',0),new Casilla('A',0),new Casilla('A',0),new Casilla('A',0),new Casilla('A',0)},
            {new Casilla('A',0),new Casilla('A',0),new Casilla('A',0),new Casilla('A',0),new Casilla('A',0),new Casilla('A',0),new Casilla('A',0),new Casilla('A',0),new Casilla('A',0),new Casilla('A',0)},
            {new Casilla('A',0),new Casilla('A',0),new Casilla('A',0),new Casilla('A',0),new Casilla('A',0),new Casilla('A',0),new Casilla('A',0),new Casilla('A',0),new Casilla('A',0),new Casilla('A',0)},
            {new Casilla('A',0),new Casilla('A',0),new Casilla('A',0),new Casilla('A',0),new Casilla('A',0),new Casilla('A',0),new Casilla('A',0),new Casilla('A',0),new Casilla('A',0),new Casilla('A',0)},
            {new Casilla('A',0),new Casilla('A',0),new Casilla('A',0),new Casilla('A',0),new Casilla('A',0),new Casilla('A',0),new Casilla('A',0),new Casilla('A',0),new Casilla('A',0),new Casilla('A',0)},
            {new Casilla('A',0),new Casilla('A',0),new Casilla('A',0),new Casilla('A',0),new Casilla('A',0),new Casilla('A',0),new Casilla('A',0),new Casilla('A',0),new Casilla('A',0),new Casilla('A',0)},
            {new Casilla('A',0),new Casilla('A',0),new Casilla('A',0),new Casilla('A',0),new Casilla('A',0),new Casilla('A',0),new Casilla('A',0),new Casilla('A',0),new Casilla('A',0),new Casilla('A',0)},
            {new Casilla('A',0),new Casilla('A',0),new Casilla('A',0),new Casilla('A',0),new Casilla('A',0),new Casilla('A',0),new Casilla('A',0),new Casilla('A',0),new Casilla('A',0),new Casilla('A',0)},
            {new Casilla('A',0),new Casilla('A',0),new Casilla('A',0),new Casilla('A',0),new Casilla('A',0),new Casilla('A',0),new Casilla('A',0),new Casilla('A',0),new Casilla('A',0),new Casilla('A',0)},
            {new Casilla('A',0),new Casilla('A',0),new Casilla('A',0),new Casilla('A',0),new Casilla('A',0),new Casilla('A',0),new Casilla('A',0),new Casilla('A',0),new Casilla('A',0),new Casilla('A',0)}
        };
        
        Tablero tabN = new Tablero(colocarNave(scan, base,"destructor",2));
        tabN.mostrar();
        ven.setPropio(tabN.getTab());
        
        tabN = new Tablero(colocarNave(scan, tabN.getTab(),"submarion",3));
        tabN.mostrar();
        ven.setPropio(tabN.getTab());
        
        tabN = new Tablero(colocarNave(scan, tabN.getTab(),"crucero",6));
        tabN.mostrar();
        ven.setPropio(tabN.getTab());
        
        tabN = new Tablero(colocarNave(scan, tabN.getTab(),"acorazado",4));
        tabN.mostrar();
        ven.setPropio(tabN.getTab());
        
        tabN = new Tablero(colocarNave(scan, tabN.getTab(),"portaaviones",5));
        tabN.mostrar();
        ven.setPropio(tabN.getTab());
        
        return tabN;
    }
    public Casilla[][] colocarNave(Scanner sc, Casilla[][] bs, String nom, int dmn){
        boolean phv = false;
        boolean pxv = false;
        boolean pyv = false;
    
        while (!phv){
            System.out.println("Selecciona la posición del barco: 0 - Horizontal : 1 - Vertical");
            pos = sc.nextInt();
            if(pos == 0 || pos == 1){
                phv = true;
            }else{
                System.out.println("Número incorrecto - Fuera de rango");
            }
        }
        
        while(!pxv){
            System.out.println("Indique un número entre {1-10}");
            px = sc.nextInt();
            if(px >= 1 && px <=10){
                pxv = true;
            }else{
                System.out.println("Número incorrecto - Fuera de rango");
            }
        }
        
        char[] eje = {'A','B','C','D','E','F','G','H','I','J'};
        
        while(!pyv){
            System.out.println("Indique una letra entre {A-J}");
            py = Character.toUpperCase(sc.next().charAt(0));
            py = new String(eje).indexOf(py);
            
            if(py != -1){
                pyv = true;
            }else{
                System.out.println("Letra incorrecta - Fuera de rango");
            }
        }
        
        px = px-1;
        
        if(pos == 0){
            return posHorizontal(bs,nom,dmn,px,py);
        }else{
            return posVertical(bs,nom,dmn,px,py);
        }
    }
    public Casilla[][] posHorizontal(Casilla[][] bs, String nom, int d, int x, int y){
        int cont = 0;
        for(int i=0; i< bs.length; i++){
            for(int j=0; j< bs[0].length; j++){
                if(d!=6){
                    if(i==y && j>=x && cont!=d){
                        bs[i][j] = new Casilla('B',d);
                        cont= cont+1;
                    }
                }else{
                    if(i==y && j>=x && cont!=3){
                        bs[i][j] = new Casilla('B',d);
                        cont= cont+1;
                    }
                }
            }
        }
        System.out.println(" Ha colocado un "+nom);
        return bs;
    }
    public Casilla[][] posVertical(Casilla[][] bs, String nom, int d, int x, int y){
        int cont = 0;
        for(int i=0; i< bs.length; i++){
            for(int j=0; j< bs[0].length; j++){
                if(d!=6){
                    if(i>=y && j==x && cont!=d){
                        bs[i][j] = new Casilla('B',d);
                        cont= cont+1;
                    }
                }else{
                    if(i>=y && j==x && cont!=3){
                        bs[i][j] = new Casilla('B',d);
                        cont= cont+1;
                    }
                }
            }
        }
        System.out.println(" Ha colocado un "+nom);
        return bs;
    }
    public Tablero getT(){
        return estPos;
    }
}