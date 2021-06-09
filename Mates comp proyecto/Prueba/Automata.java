import java.util.Hashtable;

public class Automata {
    Estado inicial;

    public Automata(String st){
        inicial=new Estado(false);
        generar(st);
    }

    //Metodo que genera un automata finito determinista
    public void generar(String st){
        Estado current=inicial,
                pre=null,
                repre=null;
        boolean fin =false;
        for (int i=0;i<st.length();i++){
            if(i==st.length()-1) {
                fin = true;
            }
            if(st.charAt(i)!='*') {
                Estado tmp=new Estado(fin);
                current.listaEst.put(st.charAt(i), tmp);

                if(i!=0&&st.charAt(i-1)=='*'){
                    pre.listaEst.put(st.charAt(i), tmp);
                    repre.listaEst.put(st.charAt(i), tmp);
                }
                current = current.listaEst.get(st.charAt(i));
                if(i<=(st.length()-3)){
                    if(st.charAt(i+2)=='*') {
                        repre = current;
                    }
                }
            }else{
                current.listaEst.put(st.charAt(i-1),current);
                pre=current;
                current=current.listaEst.get(st.charAt(i-1));
                current.fin=true;
            }
        }
        current=inicial;
        if(st.charAt(st.length()-1)=='*'){
            for(int i=0;i<st.length()-2;i++){
                current=current.listaEst.get(st.charAt(i));
            }
            current.fin=true;
        }
    }

    public boolean evaluar(String st){
        Estado current=inicial;
        for(int i=0;i<st.length();i++){
            if(current.listaEst.containsKey(st.charAt(i))){
                current=current.listaEst.get(st.charAt(i));
            }else {
                return false;
            }
        }
        return current.fin;
    }

    public static void main(String[] args) {
        Automata aut=new Automata("sas*");
        System.out.print(aut.evaluar("saa"));
    }
}

class Estado {
    boolean fin;
    Hashtable<Character,Estado> listaEst;

    Estado(boolean fin){
        this.fin=fin;
        listaEst= new Hashtable<>();
    }
}

