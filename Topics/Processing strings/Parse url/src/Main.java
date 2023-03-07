import java.net.URI;
import java.net.URISyntaxException;
import java.util.Objects;
import java.util.Scanner;

class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        String urlString = scanner.nextLine();

        try {
            URI uri = new URI(urlString);
            String query = uri.getQuery();

            String[] queryParams = query.split("&");
            String password = "";

            for (String param : queryParams) {
                String[] pair = param.split("=");
                String key = pair[0];
                String value = pair.length > 1 ? pair[1] : "";
                if(Objects.isNull(value) || value.equals("")) {
                    value = "not found";
                }
                if(Objects.equals(key,"pass")) {
                    password = value;
                }
                System.out.println(key + " : " + value);
            }

            if(!Objects.equals(password, "")) {
                System.out.println("password : " + password);
            }

        } catch (URISyntaxException e) {
            System.out.println("Invalid URL");
        }
    }
}