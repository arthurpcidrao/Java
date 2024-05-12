public class Main {
    public static void main(String[] args) throws Exception {
        HashingTable<String> table = new HashingTable<>(26);

        table.add("arthur");
        table.add("leonardo");
        table.add("andre");
        table.add("jane");
        table.add("alice");
        table.add("beraldo");
        table.add("carlos");
        table.add("zuila");

        table.show();

    }
}
