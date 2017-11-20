package main;

import java.util.Vector;

import model.InterpolationMethod;

public class InterpolacaoTeste implements InterpolationMethod {
	public double calculateResult(double t, Vector<Double> xx, Vector<Double> yy) {
		for (Double x : xx) {
			if(x > t && xx.indexOf(x) + 1 != xx.size()) {
				int i = xx.indexOf(x);
				return (t - xx.get(i)) * (yy.get(i + 1) - yy.get(i)) / (xx.get(i + 1) - xx.get(i));
			}
		}
		return -1;
	}
}
