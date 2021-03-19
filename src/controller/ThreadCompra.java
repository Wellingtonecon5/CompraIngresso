package controller;

import java.util.concurrent.Semaphore;

public class ThreadCompra extends Thread { 
	
	private int quantIngresso = 100;
	int idCompra;
	private Semaphore semaforo;

	public ThreadCompra (int idCompra, Semaphore semaforo) {
		this.idCompra = idCompra;
		this.semaforo = semaforo;
	}

	

		@Override
			public void run() {
			try {
				semaforo.acquire();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			Comprar();
			confirmaCompra();
			
			
}

	private void Login () {
		
		int tempo = (int)((Math.random()*2000) + 5000);
		if (tempo >= 1000) 
		{
			System.out.println("Infelizmente seu tempo esgotou");	
		}else {
			try {
				Thread.sleep(tempo);
			} catch (InterruptedException e) {
				
				e.printStackTrace();
			}
		
			
		}	
	}	
	
	public void Comprar () {
	
		int tempoComprar = (int)((Math.random()*2001)+1000);
		 if (tempoComprar > 15000) {
			 System.out.println("tempo estourado, fim de sessão");
		 }else {
			 
			 try {
				Thread.sleep(tempoComprar);
			} catch (InterruptedException e) {
	
				e.printStackTrace();
			}
		 }
			
	}
	
	public void confirmaCompra () {
		int ingressosavenda = (int)((Math.random()*4)+1);
		if (ingressosavenda < quantIngresso) {
			quantIngresso = quantIngresso - ingressosavenda;
			
			System.out.println("Comprador #" + idCompra + " quantidade vendida" + ingressosavenda + "restam" + quantIngresso);
			
		}else {
			System.out.println("Todos os ingressos já foram vendidos");
		}
		
		
		
	}
	
	
}
