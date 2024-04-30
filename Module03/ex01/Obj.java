public class Obj implements Runnable{

	private String 		type;
	private SharedRs	sharedRs;


	public Obj(String type, SharedRs sharedRs){
		this.type = type;
		this.sharedRs = sharedRs;
	}

	@Override
	public void run() {
		sharedRs.print(type);
	}
}
