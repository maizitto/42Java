public class Program {
    public static void main(String[] args) {
        int n = 0;
        SharedRs sharedRs;

        if (args.length > 0) {
            if (!(args[0].startsWith("--count="))) {
                System.out.println("Invalid argument. Usage: --count=<number>");
                return;
            }
            n = Integer.valueOf(args[0].substring(args[0].indexOf("=") + 1, args[0].length()));
            sharedRs = new SharedRs(n);
            Thread eggThread = new Thread(new Obj("Egg", sharedRs));
            Thread henThread = new Thread(new Obj("Hen", sharedRs));
            eggThread.start();
            henThread.start();
            // for (int i = 0; i < n; i++) {
            //     System.out.println("Human");
            // }
        } else {
            System.out.println("Missing argument. Usage: --count=<number>");
        }
    }
}