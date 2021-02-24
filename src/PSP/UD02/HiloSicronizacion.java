package PSP.UD02;

public class HiloSicronizacion {

	public static void main(String[] args) {

		Contador cont = new Contador(100);
		HiloA a = new HiloA("HiloA" ,cont);
		HiloB b = new HiloB("HiloB" ,cont);
		a.start();
		b.start();


	}

	static class Contador {
		private int c = 0;

		Contador(int c) {
			this.c = c;
		}

		public void incrementa() {
			c += 1;
		}

		public void decrementa() {
			c -= 1;
		}

		public int getValor() {
			return c;
		}
	}

	static class HiloA extends Thread {
		private Contador contador;

		public HiloA(String n, Contador c) {
			setName(n);
			contador = c;
		}

		public void run() {
			synchronized (contador) {

				for (int i = 0; i < 100; i++) {
					contador.incrementa();
					try {
						sleep(100);
					} catch (InterruptedException e) {
						// TODO: handle exception
					}

				}
				System.out.println(getName() + "Contador vale " + contador.getValor());
			}
		}
	}

	static class HiloB extends Thread {
		private Contador contador;

		public HiloB(String n, Contador c) {
			setName(n);
			contador = c;
		}

		public void run() {
			synchronized (contador) {

				for (int i = 0; i < 100; i++) {
					contador.decrementa();
					try {
						sleep(100);
					} catch (InterruptedException e) {
						// TODO: handle exception
					}
				}
				System.out.println(getName() + "contador vale " + contador.getValor());
			}
		}
	}
}
