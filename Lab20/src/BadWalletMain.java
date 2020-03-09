
public class BadWalletMain {

    static String[] dataSource =  {"B5","Q","B18","Q","B10","P","N","BAD","D","Q","D"};
    static Wallet myWallet = new Wallet();

    public static void main (String[] args) {
        // try / catch begins here
        for (int i=0;i<dataSource.length;i++) {
            char dataItem = dataSource[i].charAt(0);
            if (dataItem == 'B') {
                try {
                    int billValue = Integer.parseInt(dataSource[i].substring(1, dataSource[i].length()));
                    myWallet.addToWallet(new Bill(billValue));
                } catch (IllegalBillException e) {
                    System.out.println(e);
                    e.printStackTrace();
                } catch (NumberFormatException e) {
                    System.out.println(e);
                    e.printStackTrace();
                }
            } else {
                if (dataItem == 'Q')
                    myWallet.addToWallet(new Quarter());
                if (dataItem == 'D')
                    myWallet.addToWallet(new Dime());
                if (dataItem == 'N')
                    myWallet.addToWallet(new Nickel());
                if (dataItem == 'P')
                    myWallet.addToWallet(new Penny());
            }
        }

        myWallet.print();
        System.out.println("My wallet contains: $"+myWallet.getValue());
    }

}
