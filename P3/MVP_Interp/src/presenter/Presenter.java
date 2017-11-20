package presenter;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Observable;
import java.util.StringTokenizer;
import java.util.Vector;

import model.CubicSpline;
import model.InterpolationMethod;
import model.Lagrange;

public class Presenter extends Observable {
	private InterpolationMethod interpolationModel;
	private FileReader input;
	private BufferedReader bufRead;
	private StringTokenizer xy;
	private Vector<Double> x, y;
	private double _value, result;
    private File _file;
    
    private HashMap<String, InterpolationMethod> algoritmos;
    private final String CS_METHOD = "Cubic Spline";
    private final String L_METHOD = "Lagrange";
    private final String DEFAULT_METHOD = CS_METHOD;
    
	public Presenter() {
		bind();
	}
	
	public void bind() {
        algoritmos = new HashMap();
        algoritmos.put(L_METHOD, new Lagrange());
        algoritmos.put(CS_METHOD, new CubicSpline());
        
        interpolationModel = (InterpolationMethod) getMethod(DEFAULT_METHOD);
	}
	
	public double getResult() {
		return this.result;
	}
	
	public double getValue() {
		return this._value;
	}
	
	public File getFile() {
		return this._file;
	}
	
	public InterpolationMethod getMethod() {
		return interpolationModel;
	}
	
	 // RESPONSABILITY: ESCOLHER O METODO DE INTERPOLACAO DESEJADO E CRIAR O OBJETO CORRESPONDENTE
    public InterpolationMethod getMethod(String method) {
        if(algoritmos.containsKey(method)) {
        	interpolationModel = algoritmos.get(method);
        } else {
        	System.out.println("Unknown method " + method);
        }
        
        this.setChanged();
        return interpolationModel;
    }
    
    // RESPONSABILITY: DADO O VALOR DE X, EFETIVAMENTE LER O ARQUIVO E CHAMAR O CALCULO. 
    public void calculateResult(float value, File file) {
        _value = value;
        buildDataPoints(file);
        if(getMethod() != null) {
            result = getMethod().calculateResult(_value, x, y);
        } else {
            System.out.println("It is not defined an interpolation method.");
        }
        this.setChanged();
        this.notifyObservers(this.result);
    }

	// RESPONSABILITY: LER ARQUIVO DE DADOS
 	private void buildDataPoints(File file) {
         if(file == null)
            return;
         else _file = file;

         x = new Vector<Double>();
         y = new Vector<Double>();
         try {
             input = new FileReader(_file);
 		    /* Filter FileReader through a Buffered read to read a line at a time */
             bufRead = new BufferedReader(input);
             // Read first line
             String line = bufRead.readLine();
             // Read through file one line at time.
             while (line != null){
                 xy = new StringTokenizer(line, "\t ");
                 while(xy.hasMoreTokens()) {
                     x.addElement(Double.parseDouble(xy.nextToken()));
                     y.addElement(Double.parseDouble(xy.nextToken()));
                 }
                 line = bufRead.readLine();
             }
             bufRead.close();
         } catch (IOException e) { // If another exception is generated, print a stack trace
             e.printStackTrace();
         }
     }//buildDataPoints

	public void registrarAlgoritmo(String nome, Object obj) {
		algoritmos.put(nome, (InterpolationMethod) obj);
	}
}
