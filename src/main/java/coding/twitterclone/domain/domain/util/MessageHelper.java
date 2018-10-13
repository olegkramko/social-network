package coding.twitterclone.domain.domain.util;

import coding.twitterclone.domain.domain.User;

public abstract class MessageHelper {
    public static String getAuthorName(User author) {
        return author != null ? author.getUsername() : "<none>";
    }
}