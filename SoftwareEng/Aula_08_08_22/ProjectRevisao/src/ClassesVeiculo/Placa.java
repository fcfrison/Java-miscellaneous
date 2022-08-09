/**
 * Observations:
 *  - classes that have immutable attributes are called immutable classes.
 *  -  
 */
package ClassesVeiculo;
import java.util.regex.Pattern;

public class Placa{
    private String pais; //'pais' is an attribute that can be accessed only through the setters. 
    private String codigo; // LLLNLNN

    public Placa(String pais,String codigo){ //the class constructor ensures the integrity of the fields.
        if(pais==null || pais.length()==0){// the left hand side of the if expression is valued first. 
            throw new RuntimeException();        
        }else{
        this.pais = pais;
    }
        if (Pattern.matches("[A-Z]{3}[0-9][A-Z][0-9]{2}", codigo) == true){ //true if the characters match the regex.
            this.codigo = codigo;
        }else{
            this.codigo = "AAA0A00"; //default value if regex doesn't match.
        }
    }

    public void setPais(String pais){
        this.pais = pais;
    }

    public String getPais(){
        return pais;
    }

    public String getCodigo(){// once the codigo is setted, there's no way to altered it.
        return codigo;
    }

    public String toString(){
        if (codigo.equals("AAA0A00")){
            return("Invalida!");
        }else{
            return(codigo+":"+pais);
        }
    }
}