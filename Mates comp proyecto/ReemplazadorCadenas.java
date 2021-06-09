import java.util.ArrayList;

public class ReemplazadorCadenas {
    public Automata[] automatas;

    public String reemplazar(String cadena,String expre,String reemp){
        ArrayList<String> div=new ArrayList<>();
        int in;
        in=0;
        for(int c=0;c<expre.length()-1;c++){
            if(expre.charAt(c+1)=='+'){
                div.add(expre.substring(in,c+1));
                in=c+2;
            }
        }

        div.add(expre.substring(in,expre.length()));


        automatas=new Automata[div.size()];
        for(int i=0;i<automatas.length;i++){
            automatas[i]=new Automata(div.get(i));
        }
        in=0;
        String res="";
        for(int f=0;f<cadena.length();f++){
            for (int l=f;l<cadena.length();l++){
                for(int j=0;j<automatas.length;j++){
                    if(l==cadena.length()-1){
                        if(automatas[j].evaluar(cadena.substring(f, l+1))){
                            res += cadena.substring(in, f) + reemp;
                            in = l+1;
                            f=l;
                        }
                    }else {
                        if (automatas[j].evaluar(cadena.substring(f, l+1)) && !automatas[j].evaluar(cadena.substring(f, l + 2))) {
                            res += cadena.substring(in, f) + reemp;
                            in = l+1;
                            f = l+1;
                        }
                    }
                }
            }
        }
        res+=cadena.substring(in);

        return res;
    }

    public static void main(String[] args) {
        ReemplazadorCadenas rc= new ReemplazadorCadenas();
        String res=rc.reemplazar("draw","dra","Joa");
        System.out.print(res);
    }
}
