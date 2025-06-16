import java.util.Comparator;

public class ClientComparators {

    // Сортування по імені
    public static Comparator<Client> sortByFirstName = new Comparator<Client>() {
        @Override
        public int compare(Client c1, Client c2) {
            return c1.getFirstName().compareTo(c2.getFirstName());
        }
    };

    // Сортування по даті приєднання до компанії
    public static Comparator<Client> sortByDate = new Comparator<Client>() {
        @Override
        public int compare(Client c1, Client c2) {
            return c1.getBecomeClientAt().compareTo(c2.getBecomeClientAt());
        }
    };
}