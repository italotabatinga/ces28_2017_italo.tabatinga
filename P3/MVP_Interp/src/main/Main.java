package main;

import java.io.File;

import presenter.Presenter;
import view.MyInterpolationApp;

public class Main {
	public static void main(String[] args) {
		   // RESPONSABILITY: CREATE APP
		   Presenter observable = new Presenter();
		   MyInterpolationApp observer = new MyInterpolationApp(observable);
		   observable.addObserver(observer);
     // ENTRADA DE USUARIO HUMANO: ESCOLHA DO METODO DE INTERPOLACAO   
     // RESPONSABILITY: LEITURA DO NOME DO METODO DE INTERPOLACAO
		   observer.getMethod("Lagrange");
		// ENTRADA DE USUARIO HUMANO: PONTO DE INTERPOLACAO E NOME DO ARQUIVO DE DADOS.   
		// RESPONSABILITY: DEFINIR PONTO DE INTERPOLACAO (LEITURA ENTRADA DE USUARIO HUMANO) 
		// RESPONSABILITY: DEFINIR QUAL EH O ARQUIVO COM DADOS DE PONTOS DA FUNCAO (LEITURA ENTRADA DE USUARIO HUMANO)
		   observer.calculateResult(10.3f, new File("./data.dat"));
	   
		   //Registrando novo algoritmo e rodando com ele.
		   InterpolacaoTeste teste = new InterpolacaoTeste();
		   observer.registrarAlgoritmo("Teste", teste);
		   observer.calculateResult(10.3f, new File("./data.dat"), "Teste");
	}
	
}
