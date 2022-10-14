public class Tablero implements Cloneable
{
    private int fila;
    private int colu;
    private Casilla[][] tab;
    private char[] letr;
    public Tablero(Casilla[][] mat)
    {
        this.tab = mat;
        this.fila = tab.length;
        this.colu = tab[0].length;
        this.letr = new char[10];
        
        char[] ejey = {'A','B','C','D','E','F','G','H','I','J'};
        this.letr = ejey;
    }
    public void mostrar(){
        System.out.println("________________________________");
        System.out.println("   1  2  3  4  5  6  7  8  9  10");
        for(int i=0; i<fila; i++){
            for(int j=0; j<colu; j++){
                if(j==0){
                    System.out.print(letr[i]+" ");
                }
                System.out.print("|"+tab[i][j].getIden()+"|");
            }
            System.out.println("");
        }
        System.out.println("--------------------------------");
    }
        public boolean esPerdedor(){
        boolean res = true;
        for(int i=0; i<fila; i++){
            for(int j=0; j<colu; j++){
                if(tab[i][j].getIden()=='B'){
                    return false;
                }
            }
        }
        return res;
    }
    public void atacadoEn(int x,char yc){
        int y = new String(letr).indexOf(yc);
        for(int i=0; i<fila; i++){
            for(int j=0; j<colu; j++){
                if(y==i && (x-1)==j){
                    if(tab[i][j].getIden()=='A'){
                        tab[i][j].setAtck(); //Marcamos la casilla como atacada
                    }
                    if(tab[i][j].getIden()=='B'){
                        tab[i][j].setIden('X'); //Mostramos tiro acertado
                        tab[i][j].setAtck();
                    }
                }
            }
        }
    }
    public void radar(){
        for(int i=0; i<fila; i++){
            for(int j=0; j<colu; j++){
                if(tab[i][j].getAtck()==false){
                    tab[i][j].setIden('A');
                }else{
                    if(tab[i][j].getIden()=='A'){
                        tab[i][j].setIden('N'); //Mostramos tiro al agua
                    }
                }
            }
        }
    }
    public Tablero clone() throws CloneNotSupportedException{
        Tablero nuevo = (Tablero) super.clone();
        return nuevo;
    }
    public int getFila(){
        return fila;
    }
    public int getColu(){
        return colu;
    }
    public Casilla[][] getTab(){
        return tab;
    }
}