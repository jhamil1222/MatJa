package MatJa;

public class Main
{
	public static void main(String []args)
	{
		double [][]x=MatJa.random(810,860);
		double [][]ollo=new double [][]{x[0]};
		double [][]y=MatJa.random(860,860);
		//MatJa.impMat(x);
		//MatJa.impMat(y);
		//System.out.println(6/5);
		long startTime = System.nanoTime();
		//System.out.println(startTime/1e6);
		//calculateETOrdered(12,13); // llamamos al método
		//System.out.println(startTime);
		 resPro(x,y);
		long endTime = System.nanoTime();
		//System.out.println(endTime/1e6);
		long cal=endTime-startTime;
		System.out.println("tiempo"+cal/1e6);
		/*MatJa.impMat(*/MatJa.result(x,y);
		long gati=System.nanoTime();
		long col=gati-endTime;
		System.out.println("tiempo"+col/1e6);
		System.out.println("existe una diferencia de "+((col-cal)/1e6));
	}
	static public void resPro(double [][]x,double [][]y)
	{
		if(x.length>=12){
		int numeri=0,numri=0;
		int setAumen=0;
		int uron=0;
        Thread hiloprin=Thread.currentThread();
		//numri es el valor de los hilos que procesaran numeri cantidad de filas en un proceso
		/*esta parte se basara en el numero de hilos que puede soportar la cpu pero en todo caso se pondra un entero para que este
		*no pase el limite impuesto
		*/
		if(x.length>Runtime.getRuntime().availableProcessors())
		{
			numeri= x.length/Runtime.getRuntime().availableProcessors();
			numri=Runtime.getRuntime().availableProcessors();
			//numero de filas restantes de la divicion
			setAumen=x.length-(numeri*Runtime.getRuntime().availableProcessors());
		}
		else{
			for(int re=1; re<=9; re++)
			{
				if(x.length%re==0)
				{
					//en esta parte entra el multiplo proximo mas pequeño que se pueda procesar
					if(x.length/re<Runtime.getRuntime().availableProcessors()) {
						numeri = x.length / re;
						numri=re;
					}

					//System.out.println(numeri);
				}
			}
		}
		//System.out.println("numri"+numri);
		//System.out.println("numeri"+numeri);
		//no tocar esete array
		double [][] pori=new double [numeri][x[0].length];
		//System.out.println(Runtime.getRuntime().availableProcessors());
	//aqui tenemos que dividir las filas de x en hilos procesables
	//pero eso si no vamos a tener que sacar 18 hilos para procesar 18 filas
	//solo usare los hilos que da la pc como maximo
		//numri es el numero de hilos noy que olvidar ese detalle
		//MatJa.impMat(x);

		porfila [] grupo=new porfila[numri];
		//establecemos una constante no tan constante ustedes entienden gg
		grupo[0]=new porfila();
		grupo[0].constante=y;
		grupo[0].memoria=new double[x.length][y[0].length];
		//grupo[0].guardador=new int[numri];
        grupo[0].hiloPrin=hiloprin;
        grupo[0].ultimo=numri-1;
			for(int conta=0; conta<numri; conta++)
			{

				grupo[conta]=new porfila();
				if(conta==numri-1){
					numeri=numeri+setAumen;
					pori=new double [numeri][x[0].length];
				}
				for(int cuenta=0; cuenta<numeri; cuenta++)
				{
					pori[cuenta]=x[uron];

					uron++;
			    }

				//iteramos las filas pero en realidad aqui es donde definiremos los threads



					synchronized (grupo) {
						grupo[conta].cambiador = MatJa.memoriaFantasma(pori);
						//MatJa.impMat(pori);
						//MatJa.impMat(grupo[conta].cambiador);

						
						//grupo[conta].filas = conta;
						//System.out.println(conta);
					}
				//grupo[conta].start();



			}
			for (porfila pli: grupo){
				pli.start();
			}
        synchronized (hiloprin){
            try {
                hiloprin.wait();
            }catch(Exception es){
                //establecer log aqui
                System.out.println("error linea 95 interupcion hilo principal no lograda un error tipo \n "+es);
            }
        }
		//double acomodador=0;
       for(porfila polli: grupo){
           // MatJa.impMat(polli.memoria);
			//System.out.println(polli.aument);
        }
		}else{
			//MatJa.impMat(MatJa.result(x,y));
		}
	}
	
}
class porfila extends Thread 
{
    static double [][]constante;
    double [][] memoria;
	public double[][] cambiador;
    static int aument=0;
    static Thread hiloPrin;
	int filas=6;
	static int ultimo;

	@Override
	public  void run() 
	{
		
		
		//int pollo=filas;
		//System.out.println(filas);
		double [][]clara;

			//MatJa.impMat(cambiador);
try{
	
		clara= MatJa.result(cambiador,constante);
	//System.out.println("pollito");
		//MatJa.impMat(clara);
        memoria=clara;
}catch(Exception er){
System.out.println(er);
}
//System.out.println(aument);
        //detectamos la ultima fila a procesar que quiero decir con eso que se enviara a procesar
		synchronized(porfila.class){
        if(porfila.aument>=ultimo){
           // MatJa.impMat(memoria);
			
           // synchronized (this){
			   try{
				   synchronized(hiloPrin){
                hiloPrin.notify();
				}}
				catch(Exception es){
					System.out.println(es);
				}
           // }
			
        }
		//System.out.println(aument+"ruanda "+ultimo);
		
		
			//System.out.flush();
			porfila.aument++;
			
		}


	}
	
}

