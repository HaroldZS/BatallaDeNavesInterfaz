    import java.util.Scanner;
public class Principal
{
    private int corx; // Coordenada en x
    private char cory; // Coordenada en y
    private boolean ganar = false;
    
    public void jugar(){
        System.out.println("===============Interfaz J1================");
        System.out.println("Estrategia J1 - Posicionar Naves");
        Casilla[][] mat = new Estrategia().getT().getTab();
        System.out.println("===============Interfaz J2================");
        System.out.println("Estrategia J2 - Posicionar Naves");
        Casilla[][] oMat = new Estrategia().getT().getTab();
        /*
        Casilla[][] mat = {
            {new Casilla('A',0),new Casilla('A',0),new Casilla('A',0),new Casilla('A',0),new Casilla('A',0),new Casilla('A',0),new Casilla('A',0),new Casilla('A',0),new Casilla('A',0),new Casilla('A',0)},
            {new Casilla('A',0),new Casilla('B',2),new Casilla('A',0),new Casilla('B',4),new Casilla('A',0),new Casilla('A',0),new Casilla('A',0),new Casilla('A',0),new Casilla('A',0),new Casilla('A',0)},
            {new Casilla('A',0),new Casilla('B',2),new Casilla('A',0),new Casilla('B',4),new Casilla('A',0),new Casilla('B',5),new Casilla('A',0),new Casilla('A',0),new Casilla('A',0),new Casilla('A',0)},
            {new Casilla('A',0),new Casilla('A',0),new Casilla('A',0),new Casilla('B',4),new Casilla('A',0),new Casilla('B',5),new Casilla('A',0),new Casilla('A',0),new Casilla('A',0),new Casilla('A',0)},
            {new Casilla('A',0),new Casilla('A',0),new Casilla('A',0),new Casilla('B',4),new Casilla('A',0),new Casilla('B',5),new Casilla('A',0),new Casilla('A',0),new Casilla('A',0),new Casilla('A',0)},
            {new Casilla('A',0),new Casilla('A',0),new Casilla('A',0),new Casilla('A',0),new Casilla('A',0),new Casilla('B',5),new Casilla('A',0),new Casilla('A',0),new Casilla('A',0),new Casilla('A',0)},
            {new Casilla('A',0),new Casilla('B',6),new Casilla('B',6),new Casilla('B',6),new Casilla('A',0),new Casilla('B',5),new Casilla('A',0),new Casilla('A',0),new Casilla('A',0),new Casilla('A',0)},
            {new Casilla('A',0),new Casilla('A',0),new Casilla('A',0),new Casilla('A',0),new Casilla('A',0),new Casilla('A',0),new Casilla('A',0),new Casilla('A',0),new Casilla('A',0),new Casilla('A',0)},
            {new Casilla('A',0),new Casilla('A',0),new Casilla('A',0),new Casilla('A',0),new Casilla('A',0),new Casilla('A',0),new Casilla('A',0),new Casilla('A',0),new Casilla('A',0),new Casilla('A',0)},
            {new Casilla('A',0),new Casilla('A',0),new Casilla('B',3),new Casilla('B',3),new Casilla('B',3),new Casilla('A',0),new Casilla('A',0),new Casilla('A',0),new Casilla('A',0),new Casilla('A',0)}
        };
        Casilla[][] oMat = {
            {new Casilla('B',6),new Casilla('B',6),new Casilla('B',6),new Casilla('A',0),new Casilla('A',0),new Casilla('A',0),new Casilla('A',0),new Casilla('A',0),new Casilla('A',0),new Casilla('A',0)},
            {new Casilla('A',0),new Casilla('A',0),new Casilla('A',0),new Casilla('A',0),new Casilla('A',0),new Casilla('A',0),new Casilla('A',0),new Casilla('A',0),new Casilla('A',0),new Casilla('A',0)},
            {new Casilla('B',3),new Casilla('A',0),new Casilla('A',0),new Casilla('B',4),new Casilla('A',0),new Casilla('A',0),new Casilla('A',0),new Casilla('A',0),new Casilla('A',0),new Casilla('A',0)},
            {new Casilla('B',3),new Casilla('A',0),new Casilla('A',0),new Casilla('B',4),new Casilla('A',0),new Casilla('A',0),new Casilla('A',0),new Casilla('A',0),new Casilla('A',0),new Casilla('A',0)},
            {new Casilla('B',3),new Casilla('A',0),new Casilla('A',0),new Casilla('B',4),new Casilla('A',0),new Casilla('A',0),new Casilla('A',0),new Casilla('A',0),new Casilla('A',0),new Casilla('A',0)},
            {new Casilla('A',0),new Casilla('A',0),new Casilla('A',0),new Casilla('B',4),new Casilla('A',0),new Casilla('B',5),new Casilla('A',0),new Casilla('A',0),new Casilla('A',0),new Casilla('A',0)},
            {new Casilla('A',0),new Casilla('B',2),new Casilla('A',0),new Casilla('A',0),new Casilla('A',0),new Casilla('B',5),new Casilla('A',0),new Casilla('A',0),new Casilla('A',0),new Casilla('A',0)},
            {new Casilla('A',0),new Casilla('B',2),new Casilla('A',0),new Casilla('A',0),new Casilla('A',0),new Casilla('B',5),new Casilla('A',0),new Casilla('A',0),new Casilla('A',0),new Casilla('A',0)},
            {new Casilla('A',0),new Casilla('A',0),new Casilla('A',0),new Casilla('A',0),new Casilla('A',0),new Casilla('B',5),new Casilla('A',0),new Casilla('A',0),new Casilla('A',0),new Casilla('A',0)},
            {new Casilla('A',0),new Casilla('A',0),new Casilla('A',0),new Casilla('A',0),new Casilla('A',0),new Casilla('B',5),new Casilla('A',0),new Casilla('A',0),new Casilla('A',0),new Casilla('A',0)}
        };
        */
        
        Tablero radar1 = null;
        Tablero radar2 = null;
        
        int[][] nav1 = null;
        int[][] nav2 = null;
        int navDim= 0;
        
        corx= 100;
        cory= 'Z';
        
        //Scanner
        Scanner sc = new Scanner(System.in);
        
        //Crear tablero J1
        System.out.println("Tablero propio Jugador 1");
        Tablero t1 = new Tablero(mat);
        t1.mostrar();
        
        //Crear tablero J2
        System.out.println("Tablero propio Jugador 2");
        Tablero t2 = new Tablero(oMat);
        t2.mostrar();
        
        System.out.println("Empieza el Juego!");
        while(!ganar){
            System.out.println("===============Interfaz J1================");
            System.out.println("J1 Propio");
            t1.mostrar();
            System.out.println("J1 Radar");
            radar1 = new Tablero(genRadar(t2.getTab()));
            radar1.mostrar();
            
            if(corx != 100 && cory != 'Z'){
                nav1 = resumen(t1.getTab());
                navDim = getBarcoDim(nav1,corx,cory);
                existeHundido(nav1,navDim,"J2","J1");
            }
            
            if(t1.esPerdedor()){
                System.out.println("Ganó el jugador 2");
                break;
            }
            
            pedirXY(sc);
                            
            //J1 ataca a J2
            t2.atacadoEn(corx,cory);
            
            System.out.println("===============Interfaz J1================");
            System.out.println("J1 Propio");
            t1.mostrar();
            System.out.println("J1 Radar");
            radar1 = new Tablero(genRadar(t2.getTab()));
            radar1.mostrar();
            
            System.out.println("===============Interfaz J2================");
            System.out.println("J2 Propio");
            t2.mostrar();
            System.out.println("J2 Radar");
            radar2 = new Tablero(genRadar(t1.getTab()));
            radar2.mostrar();
            
            nav2 = resumen(t2.getTab());
            navDim = getBarcoDim(nav2,corx,cory);
            existeHundido(nav2,navDim,"J1","J2");
            
            if(t2.esPerdedor()){
                System.out.println("Ganó el jugador 1");
                break;
            }
            
            pedirXY(sc);
        
            //J2 ataca a J1
            t1.atacadoEn(corx,cory);
            
            System.out.println("===============Interfaz J2================");
            System.out.println("J2 Propio");
            t2.mostrar();
            System.out.println("J2 Radar");
            radar2 = new Tablero(genRadar(t1.getTab()));
            radar2.mostrar();
        }
    }
    private void pedirXY(Scanner sc){
        System.out.println("Indique un número entre entre {1-10}");
        corx = sc.nextInt();
        System.out.println("Indique una letra entre {A-J}");
        cory = sc.next().charAt(0);
    }
    private Casilla[][] genRadar(Casilla[][] t){
        Casilla[][] c = {
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
        for(int i=0; i< t.length; i++){
            for(int j=0; j< t[0].length; j++){
                if(t[i][j].getAtck()==false){
                    c[i][j] = new Casilla('A',t[i][j].getDim());
                }else{
                    if(t[i][j].getIden()=='A'){
                        c[i][j] = new Casilla('N',t[i][j].getDim());
                        c[i][j].setAtck();
                    }else{
                        c[i][j] = new Casilla('X',t[i][j].getDim());
                        c[i][j].setAtck();
                    }
                }
            }
        }
        return c;
    }
    private int[][] resumen(Casilla[][] a){
        int[][] ar = {
            {0,0,0,0,0,0,0,0,0,0},
            {0,0,0,0,0,0,0,0,0,0},
            {0,0,0,0,0,0,0,0,0,0},
            {0,0,0,0,0,0,0,0,0,0},
            {0,0,0,0,0,0,0,0,0,0},
            {0,0,0,0,0,0,0,0,0,0},
            {0,0,0,0,0,0,0,0,0,0},
            {0,0,0,0,0,0,0,0,0,0},
            {0,0,0,0,0,0,0,0,0,0},
            {0,0,0,0,0,0,0,0,0,0}
        };
        for(int i=0; i< a.length; i++){
            for(int j=0; j< a[0].length; j++){
                if(a[i][j].getIden()=='X'){
                    ar[i][j] = a[i][j].getDim();
                }
                }
        }
        
        return ar;
    }
    private void imprimir(int[][] n){
        for(int i=0; i< n.length; i++){
            for(int j=0; j< n[0].length; j++){
                System.out.print(n[i][j]+" ");
            }
            System.out.println("");
        }
    }
    private int getBarcoDim(int[][] r, int x, char ay){
        char[] eje = {'A','B','C','D','E','F','G','H','I','J'};
        int y = new String(eje).indexOf(ay);
        x=x-1;
        
        return r[y][x];
    }
    private void existeHundido(int[][] bar, int tam,String jugX, String jugY){
        int cont = 0;
        String[] naves = {"destructor","submarino","acorazado","portaaviones"};
        
        for(int i=0; i< bar.length; i++){
            for(int j=0; j< bar[0].length; j++){
                if(bar[i][j]==tam){
                    cont= cont+1;
                }
            }
        }
        if(tam == 6){
            if(cont == 3){
                System.out.println(jugX+" ha undido el crucero de "+jugY);
            }
        }else{
            if(cont == tam){
                System.out.println(jugX+" ha hundido el "+naves[cont-2]+" de "+jugY);
            }
        }
    }
}