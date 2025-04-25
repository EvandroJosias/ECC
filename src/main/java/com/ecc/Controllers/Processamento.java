package com.Controllers;

import javax.swing.table.DefaultTableModel;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;
public  class Processamento{
    private  String TextoEntrada;

    private Vector<Double> Data;

    //private DefaultTableModel tableModel;
    private List<List<Double>> resultado;

    private Vector Matrix;

    private String textos;

    private static Integer totalcolunas = 0;

    private static final DecimalFormat df = new DecimalFormat("0.00");

    public Integer getTotalcolunas( ) { return totalcolunas; };

    public Processamento() {
        Data = new Vector<Double>();
        Matrix = new Vector<Double>();
        resultado = new ArrayList<>();
    }

    public String getTextos( ) {
        return textos;
    }

    public void setTextoEntrada(String S){
        TextoEntrada = S;
    }

    public void Processar(){
        int inteiro;
        String separator = "\t";
        String line = "\n";
        totalcolunas = 0;
        if(!TextoEntrada.isEmpty()){
            //cortar a linda a onde tiver tab
            String[] lineByLine =  TextoEntrada.split(line);
            for(int aux = 0; aux < lineByLine.length; aux++){
                String[] valores = lineByLine[aux].split(separator);
                // separar os inteiros do float
                inteiro =  Integer.parseInt(valores[0]);
                double resto = Float.parseFloat(valores[1]);
                // Repitir a quantidade de vezes do inteiro
                for( int count = 0; count < inteiro; count++ ){
                    Data.add(resto);
                }
            }
            this.Ordenar();
        }else{
            System.out.println("Nenhum parametro enviado !");
        }
    }
    public void Ordenar(){
        double aux;
        for( int i = 0; i < Data.size(); i++ ) {
            for( int j = 0; j < Data.size(); j++ ){
                if( Data.get(i) > Data.get(j) ) {
                    aux = Data.get(i);
                    Data.set( i, Data.get(j));
                    Data.set( j, aux );
                }
            }
        }
        this.Retorno();
    }

    public void Retorno(){
        while( ! Data.isEmpty() ) {
            //List<List<Double>> combinations = generateCombinations( Data );
            List<List<Double>> combinations = melhorCombinacao( Data );
            for( List<Double> combination : combinations ) {
                List<Double> line = new ArrayList<>();
                line.add( 1.0 );
                line.add( 0.0 );
                int verify = -1;
                double resto = 12.0;
                for( int i=0 ; i < combination.size() ; i++ ) {
                    resto = resto - combination.get(i);
                    line.add( combination.get(i));
                    Data.removeElement( combination.get(i) );
                }
                line.set(1,resto);
                for(int j = 0; j< resultado.size();j++){
                    List<Double> tmpR = new ArrayList<>();
                    tmpR.add(1.0);
                    for(int x=1; x <resultado.get(j).size(); x++) tmpR.add( resultado.get(j).get(x));
                    if(tmpR.hashCode() == line.hashCode()){
                        verify = j ;
                    }
                }
                if(verify >= 0 ){
                    List<Double>  temp = resultado.get(verify);
                    temp.set(0,temp.get(0)+1.0);
                    if( temp.size() > totalcolunas ) { totalcolunas = temp.size(); };
                    resultado.set(verify, temp);
                } else {
                    if( line.size() > totalcolunas ) { totalcolunas = line.size(); };
                    resultado.add( line );
                }
                System.out.println("pro-totalcolunas : " + totalcolunas );
            }
        }

        textos = "";
        for( List<Double> result : resultado ) {
            String str = "[";
            for( int i = 0; i < result.size(); i++ ) {
                double val = result.get( i );
                str = str + df.format( val ) + " ";
            }
            str = str + "]\n";
            textos = textos + str;
        }
    }


    public static List<List<Double>> melhorCombinacao( Vector<Double> vetor ) {
        // Soma desejada
        double somaDesejada = 12.0;

        // Inicializar variáveis para armazenar a melhor combinação
        ArrayList<Double> bestCombinacao = null;
        double melhorSoma = 0.0;

        // Iterar sobre todas as combinações possíveis
        for (int i = 0; i < vetor.size(); i++) {
            ArrayList<Double> combinacaoAtual = new ArrayList<>();
            double somaAtual = 0.0;

            for (int j = i; j < vetor.size(); j++) {
                if( bestCombinacao != null ) {
                    if( (combinacaoAtual.size() == bestCombinacao.size() ) && (somaAtual == melhorSoma) ) {
                        int pos = combinacaoAtual.size() - 1;
                        somaAtual -= combinacaoAtual.get(pos);
                        combinacaoAtual.remove(pos);
                    }
                }
                if( (somaAtual + vetor.get(j)) <= somaDesejada ) {
                    combinacaoAtual.add(vetor.get(j));
                    somaAtual += vetor.get(j);
                }
                if( somaAtual == somaDesejada ) {
                    j += vetor.size() + 1;
                }
            }
            // Verificar se a combinação atual é válida e melhor
            //if (somaAtual > melhorSoma && (melhorCombinacao == null || combinacaoAtual.size() < melhorCombinacao.size())) {
            if (somaAtual > melhorSoma ){
                bestCombinacao = new ArrayList<>(combinacaoAtual);
                melhorSoma = somaAtual;
                if( combinacaoAtual.size() > totalcolunas ) {
                    totalcolunas = combinacaoAtual.size();
                }
            }
        }
        List<List<Double>> combinations = new ArrayList<>();
        combinations.add( bestCombinacao );
        return combinations;
    }
    public static List<List<Double>> generateCombinations(Vector<Double> vector) {
        List<List<Double>> combinations = new ArrayList<>();
        List<Double> temp = new ArrayList<>();
        generateCombinations(vector, 0, temp, combinations);
        return combinations;
    }
    public static void generateCombinations(Vector<Double> vector, int index, List<Double> currentCombination, List<List<Double>> combinations) {
        if (index == vector.size()) {
            double tot1 = 0;
            double tot2 = 0;
            if ( combinations.size() > 0 ) {
                List<Double> temp = combinations.get(0);
                for (int i = 0; i < temp.size(); i++) {
                    tot1 = tot1 + temp.get(i);
                }
            }
            for (int i = 0; i < currentCombination.size(); i++) {
                tot2 = tot2 + currentCombination.get(i);
            }
            if (combinations.size() == 0) {
                combinations.add(new ArrayList<>(currentCombination));
            }
            if ((tot2 > tot1) && (tot2 <= 12)) {
                combinations.remove(0);
                combinations.add(new ArrayList<>(currentCombination));
            }
            return;
        }

        //Caso em que o elemento atual não esta incluido na combinação
        generateCombinations( vector, index + 1, currentCombination, combinations );

        //Caso em que o elemento atual está incluido na combinação
        currentCombination.add( vector.get(index));
        generateCombinations( vector, index + 1, currentCombination, combinations );

        //Remove o elemento atual para que possamos considerar outras combinações
        currentCombination.remove( currentCombination.size()-1);
    }


    public List<List<Double>> getResultado() {
        return resultado;
    }
}