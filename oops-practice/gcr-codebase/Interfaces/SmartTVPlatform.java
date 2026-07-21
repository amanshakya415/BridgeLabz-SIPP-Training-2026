interface StreamingService {
    void streamMovie(String movie);
    default void showSubscriptionDetails() {
        System.out.println("Streaming Service: Premium Plan Active.");
    }
}

interface GamingService {
    void playGame(String game);
    default void showSubscriptionDetails() {
        System.out.println("Gaming Service: Ultimate Pass Active.");
    }
}

class SmartTV implements StreamingService, GamingService {
    private String[] movies;
    private String[] games;

    public SmartTV(String[] movies, String[] games) {
        this.movies = movies;
        this.games = games;
    }

    public void streamMovie(String movie) {
        System.out.println("Streaming movie: " + movie);
    }

    public void playGame(String game) {
        System.out.println("Playing game: " + game);
    }

    @Override
    public void showSubscriptionDetails() {
        StreamingService.super.showSubscriptionDetails();
        GamingService.super.showSubscriptionDetails();
    }

    public void displayContent() {
        System.out.println("--- Available Movies ---");
        for (String movie : movies) {
            streamMovie(movie);
        }
        System.out.println("--- Available Games ---");
        for (String game : games) {
            playGame(game);
        }
    }
}

public class SmartTVPlatform {
    public static void main(String[] args) {
        String[] moviesList = {"Inception", "The Matrix", "Interstellar"};
        String[] gamesList = {"Chess Premium", "Asphalt 9", "Retro Racer"};

        SmartTV tv = new SmartTV(moviesList, gamesList);
        tv.showSubscriptionDetails();
        tv.displayContent();
    }
}