public class Casilla
{
    private char iden;
    private int dim;
    private boolean atck;
    public Casilla(char iden, int dim)
    {
        this.iden = iden; //Identifica 'B' barco, 'A' agua, 'X' impacto certero y 'N' tiro al agua.   
        this.dim = dim; //Tamaño del barco [2,3,4,5], sino 0 en caso de 'A' o 'N'.
        this.atck = false; //Establece si la casilla ya ha sido atacada.
    }
    protected char getIden(){
        return iden;
    }
    protected int getDim(){
         return dim;
    }
    protected boolean getAtck(){
         return atck;
    }
    protected void setIden(char nIden){
         this.iden = nIden;
    }
    protected void setAtck(){
         this.atck = true;
    }
}