package view;


import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.text.DecimalFormat;
import java.util.Observable;
import java.util.Observer;
import java.util.StringTokenizer;
import java.util.Vector;

import javafx.util.Pair;
import presenter.Presenter;

public class MyInterpolationApp implements Observer {
    private double _value, result;
    private File _file;
    
    private final String CS_METHOD = "Cubic Spline";
    private final String L_METHOD = "Lagrange";
    private DecimalFormat formatResult = new DecimalFormat("####.######");
    private final String DEFAULT_METHOD = CS_METHOD;

    private Presenter o;
    
    public MyInterpolationApp(Presenter o) {
    	this.o = o;
    }

    public File getDataFile() {
        return _file;
    }

    private void getMethod() {
    	o.getMethod();
    }
    public void getMethod(String method) {
        o.getMethod(method);
    }
    
    public void registrarAlgoritmo(String nome, Object obj) {
    	o.registrarAlgoritmo(nome, obj);
    }
    
    public void calculateResult(float value, File file) {
    	this._value = value;
    	this._file = file;
    	o.calculateResult(value, file);
    	this.printResult();
    }
    
    public void calculateResult(float value, File file, String method) {
    	o.getMethod(method);
    	this._value = value;
    	this._file = file;
    	o.calculateResult(value, file);
    	this.printResult();
    }
    
    // RESPONSABILITY: IMPRIMIR RESULTADOS
    private void printResult() {
    	System.out.println("***********************");
    	System.out.println("DataFile: " + getDataFile());
    	System.out.println("Interp at " + formatResult.format(_value) + " ; result = " + formatResult.format(result));
	}

	@Override
	public void update(Observable o, Object arg) {
		this.result = (Double) arg;
	}
	
}//class
