package view;

import java.lang.management.ThreadInfo;
import java.util.concurrent.Semaphore;

import controller.ThreadCompra;

public class Principal {

	public static void main(String[] args) {
		
	int id = 0;
	int quantIngresso = 100;
	Semaphore semaforo = new Semaphore (quantIngresso);
	for(int i = 0; i < 100 ; i++) {
		
		Thread threadcompra = new ThreadCompra (id,semaforo);
		threadcompra.start();
		id++;
		
		
	}
	}

}
