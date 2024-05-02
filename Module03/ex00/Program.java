
public class Program {
	public static void main(String[] args) {
		
		int n = 0;
		Obj t1, t2;

		if (args.length > 0) {
			if (!(args[0].startsWith("--count="))) {
				System.out.println("Invalid argument. Usage: --count=<number>");
				return ;
			}
			n = Integer.valueOf(args[0].substring(args[0].indexOf("=") + 1, args[0].length()));
			t1 = new Obj("Egg", n);
			t2 = new Obj("Hen", n);
			t1.start();
			t2.start();
			// try {
			// 	t1.join();
			// 	t2.join();
			// } catch (InterruptedException e) {
			// 	e.printStackTrace();
			// }
			for (int i = 0; i < n; i++) {
				System.out.println("Human");
			}
		}
		return ;
	}
}
