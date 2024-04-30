public class Obj extends Thread{

	private String 	type;
	private int 	times;

	public Obj(String type, int times){
		this.type = type;
		this.times = times;
	}

	public void run(){
		for(int i = 0; i < times; i++){
			System.out.println(type);
		}
	}	
}
