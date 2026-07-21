interface TextModeration {
    boolean checkOffensive(String post);
    default void displayModerationPolicy() {
        System.out.println("Policy: Ensure community standards are met.");
    }
    static boolean containsRestrictedWords(String post) {
        String[] restricted = {"badword", "offensive", "hate"};
        for (String word : restricted) {
            if (post.toLowerCase().contains(word)) {
                return true;
            }
        }
        return false;
    }
}

interface SpamDetection {
    boolean checkSpam(String post);
    default void displayModerationPolicy() {
        System.out.println("Policy: Prevent automation and repetitive spam.");
    }
}

class ContentModerator implements TextModeration, SpamDetection {
    public boolean checkOffensive(String post) {
        return TextModeration.containsRestrictedWords(post);
    }

    public boolean checkSpam(String post) {
        return post.toUpperCase().contains("BUY NOW") || post.toUpperCase().contains("FREE CASH");
    }

    @Override
    public void displayModerationPolicy() {
        TextModeration.super.displayModerationPolicy();
        SpamDetection.super.displayModerationPolicy();
    }
}

public class ContentModerationPlatform {
    public static void main(String[] args) {
        String[] posts = {
            "Hello everyone! Welcome to my profile.",
            "BUY NOW to win FREE CASH immediately!!!",
            "This post contains a badword and is offensive.",
            "Just sharing a beautiful sunset picture.",
            "Click here for FREE CASH deals!"
        };

        ContentModerator moderator = new ContentModerator();
        moderator.displayModerationPolicy();
        System.out.println();

        for (String post : posts) {
            System.out.println("Post: \"" + post + "\"");
            if (moderator.checkSpam(post)) {
                System.out.println("Status: SPAM POST");
            } else if (moderator.checkOffensive(post)) {
                System.out.println("Status: OFFENSIVE POST");
            } else {
                System.out.println("Status: VALID POST");
            }
            System.out.println();
        }
    }
}